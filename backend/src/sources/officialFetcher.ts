import { officialDomains } from "./officialDomains.js";
import { readFileSync } from "fs";
import path from "path";

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
};

const catalogPath = path.resolve(process.cwd(), "data", "spec_catalog.json");
const catalog: CatalogSpec[] = JSON.parse(readFileSync(catalogPath, "utf-8"));

function normalize(value: string): string {
  return value.toLowerCase().replace(/[^a-z0-9]+/g, " ").trim();
}

function tokenize(value: string): string[] {
  return normalize(value).split(/\s+/).filter(Boolean);
}

function isOfficialSource(url: string): boolean {
  try {
    const host = new URL(url).hostname.toLowerCase().replace(/^www\./, "");
    return officialDomains.some((domain) => host === domain || host.endsWith(`.${domain}`));
  } catch {
    return false;
  }
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

export async function fetchOfficialSpecs(query: string): Promise<SpecResult | null> {
  const queryNormalized = normalize(query);
  if (queryNormalized.length < 2) return null;

  const queryTokens = tokenize(queryNormalized);
  let bestMatch: CatalogSpec | null = null;
  let bestScore = 0;

  for (const spec of catalog) {
    const score = scoreSpec(queryNormalized, queryTokens, spec);
    if (score > bestScore) {
      bestScore = score;
      bestMatch = spec;
    }
  }

  if (!bestMatch || bestScore < 200) return null;
  if (!isOfficialSource(bestMatch.sourceUrl)) return null;

  return {
    brand: bestMatch.brand,
    model: bestMatch.model,
    driverSizeMm: bestMatch.driverSizeMm,
    frequencyLowHz: bestMatch.frequencyLowHz,
    frequencyHighHz: bestMatch.frequencyHighHz,
    impedanceOhm: bestMatch.impedanceOhm,
    sensitivityDb: bestMatch.sensitivityDb,
    powerMw: bestMatch.powerMw,
    sourceName: bestMatch.sourceName,
    sourceUrl: bestMatch.sourceUrl,
    verified: bestMatch.verified ?? true,
  };
}
