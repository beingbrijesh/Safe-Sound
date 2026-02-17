import { officialDomains } from "./officialDomains.js";
import { readFileSync } from "fs";
import path from "path";
import {
  getSpecFromCache,
  purgeExpiredCache,
  upsertSpecCache,
} from "../storage/specCache.js";

export type SpecResult = {
  brand?: string;
  model?: string;
  driverSizeMm?: number;
  frequencyLowHz?: number;
  frequencyHighHz?: number;
  impedanceOhm?: number;
  sensitivityDb?: number;
  powerMw?: number;
  sourceName?: string;
  sourceUrl?: string;
  verified: boolean;
};

type CatalogSpec = Omit<SpecResult, "verified"> & {
  brand: string;
  model: string;
  sourceName: string;
  sourceUrl: string;
  aliases?: string[];
  verified?: boolean;
  trustScore?: number;
};

type SourceType = "official" | "croma" | "trusted";

const dataDir = path.resolve(process.cwd(), "data");
const officialCatalog = readJsonFile<CatalogSpec[]>(path.join(dataDir, "spec_catalog.json"), []);
const cromaCatalog = readJsonFile<CatalogSpec[]>(path.join(dataDir, "spec_catalog_croma.json"), []);
const trustedCatalog = readJsonFile<CatalogSpec[]>(path.join(dataDir, "spec_catalog_trusted.json"), []);
const trustedDomains = readJsonFile<string[]>(path.join(dataDir, "trusted_domains.json"), []);

const allCatalogs = [...officialCatalog, ...cromaCatalog, ...trustedCatalog];
const knownBrands = Array.from(new Set(allCatalogs.map((spec) => normalize(spec.brand))));
const MIN_CONFIDENCE_SCORE = 400;
const TRUSTED_MIN_SCORE = 0.75;
const CACHE_TTL_DAYS = Number(process.env.SPEC_CACHE_TTL_DAYS || "30");
const FILLABLE_FIELDS: Array<Exclude<keyof SpecResult, "verified">> = [
  "brand",
  "model",
  "driverSizeMm",
  "frequencyLowHz",
  "frequencyHighHz",
  "impedanceOhm",
  "sensitivityDb",
  "powerMw",
  "sourceName",
  "sourceUrl",
];

function readJsonFile<T>(filePath: string, fallback: T): T {
  try {
    const raw = readFileSync(filePath, "utf-8");
    return JSON.parse(raw) as T;
  } catch {
    return fallback;
  }
}

function normalize(value: string): string {
  return value.toLowerCase().replace(/[^a-z0-9]+/g, " ").trim();
}

function tokenize(value: string): string[] {
  return normalize(value).split(/\s+/).filter(Boolean);
}

function isOfficialSource(url: string): boolean {
  const host = getHost(url);
  if (!host) return false;
  return inDomainList(host, officialDomains);
}

function isCromaSource(url: string): boolean {
  const host = getHost(url);
  if (!host) return false;
  return host === "croma.com" || host.endsWith(".croma.com");
}

function isTrustedFallbackSource(spec: CatalogSpec): boolean {
  const host = getHost(spec.sourceUrl);
  if (!host) return false;
  const domainTrusted = inDomainList(host, trustedDomains);
  const score = spec.trustScore ?? 0;
  return domainTrusted && score >= TRUSTED_MIN_SCORE;
}

function getHost(url: string): string | null {
  try {
    return new URL(url).hostname.toLowerCase().replace(/^www\./, "");
  } catch {
    return null;
  }
}

function inDomainList(host: string, domains: string[]): boolean {
  return domains.some((domain) => host === domain || host.endsWith(`.${domain}`));
}

function scoreSpec(query: string, queryTokens: string[], spec: CatalogSpec): number {
  const candidates = [
    `${spec.brand} ${spec.model}`,
    spec.model,
    ...(spec.aliases ?? []),
  ]
    .map(normalize)
    .filter((candidate) => candidate.length > 0);

  if (candidates.some((candidate) => candidate === query)) return 1000;

  if (query.length >= 3 && candidates.some((candidate) => candidate.includes(query))) {
    return 700 + query.length;
  }

  const overlap = candidates.reduce((best, candidate) => {
    const candidateTokens = tokenize(candidate);
    const current = queryTokens.filter((token) => candidateTokens.includes(token)).length;
    return Math.max(best, current);
  }, 0);

  if (queryTokens.length > 0 && overlap === queryTokens.length) return 500 + overlap;
  if (overlap > 0) return 200 + overlap;
  return 0;
}

function findBestMatch(
  queryNormalized: string,
  queryTokens: string[],
  requestedBrand: string | null,
  catalog: CatalogSpec[],
  source: SourceType
): CatalogSpec | null {
  let bestSpec: CatalogSpec | null = null;
  let bestScore = 0;

  for (const spec of catalog) {
    if (requestedBrand && normalize(spec.brand) !== requestedBrand) continue;
    if (source === "official" && !isOfficialSource(spec.sourceUrl)) continue;
    if (source === "croma" && !isCromaSource(spec.sourceUrl)) continue;
    if (source === "trusted" && !isTrustedFallbackSource(spec)) continue;

    const score = scoreSpec(queryNormalized, queryTokens, spec);
    if (score > bestScore) {
      bestScore = score;
      bestSpec = spec;
    }
  }

  if (!bestSpec || bestScore < MIN_CONFIDENCE_SCORE) return null;
  return bestSpec;
}

function isMissing(value: unknown): boolean {
  return (
    value === null ||
    value === undefined ||
    (typeof value === "string" && value.trim().length === 0)
  );
}

function mergeMissing(target: Partial<SpecResult>, source: CatalogSpec): void {
  for (const field of FILLABLE_FIELDS) {
    if (field === "sourceName" || field === "sourceUrl") continue;
    if (isMissing(target[field]) && !isMissing(source[field])) {
      target[field] = source[field];
    }
  }
}

function selectRequestedBrand(queryNormalized: string): string | null {
  const candidates = knownBrands
    .filter((brand) => queryNormalized.includes(brand))
    .sort((left, right) => right.length - left.length);
  return candidates[0] ?? null;
}

export async function fetchOfficialSpecs(query: string): Promise<SpecResult | null> {
  const queryNormalized = normalize(query);
  if (queryNormalized.length < 2) return null;

  // Lightweight cleanup on request path; cheap and keeps DB size bounded.
  purgeExpiredCache(CACHE_TTL_DAYS);
  const cached = getSpecFromCache(queryNormalized, CACHE_TTL_DAYS);
  if (cached) return cached;

  const queryTokens = tokenize(queryNormalized);
  const requestedBrand = selectRequestedBrand(queryNormalized);

  const officialMatch = findBestMatch(
    queryNormalized,
    queryTokens,
    requestedBrand,
    officialCatalog,
    "official"
  );
  const cromaMatch = findBestMatch(
    queryNormalized,
    queryTokens,
    requestedBrand,
    cromaCatalog,
    "croma"
  );
  const trustedMatch = findBestMatch(
    queryNormalized,
    queryTokens,
    requestedBrand,
    trustedCatalog,
    "trusted"
  );

  if (!officialMatch && !cromaMatch && !trustedMatch) return null;

  const merged: Partial<SpecResult> = {};
  const sourcesUsed: string[] = [];
  let primaryUrl: string | undefined;

  const apply = (spec: CatalogSpec | null): void => {
    if (!spec) return;
    if (!primaryUrl) primaryUrl = spec.sourceUrl;
    mergeMissing(merged, spec);
    sourcesUsed.push(spec.sourceName);
  };

  // Priority order: official -> croma -> trusted fallback.
  apply(officialMatch);
  apply(cromaMatch);
  apply(trustedMatch);

  if (isMissing(merged.brand) && isMissing(merged.model)) return null;

  const result: SpecResult = {
    brand: merged.brand,
    model: merged.model,
    driverSizeMm: merged.driverSizeMm,
    frequencyLowHz: merged.frequencyLowHz,
    frequencyHighHz: merged.frequencyHighHz,
    impedanceOhm: merged.impedanceOhm,
    sensitivityDb: merged.sensitivityDb,
    powerMw: merged.powerMw,
    sourceName: sourcesUsed.length > 0 ? sourcesUsed.join(" + ") : "Unknown",
    sourceUrl: primaryUrl,
    verified: true,
  };

  upsertSpecCache(queryNormalized, query, result);
  return result;
}
