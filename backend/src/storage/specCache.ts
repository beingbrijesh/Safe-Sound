import Database from "better-sqlite3";
import path from "path";

type CacheRecord = {
  brand: string | null;
  model: string | null;
  driver_size_mm: number | null;
  frequency_low_hz: number | null;
  frequency_high_hz: number | null;
  impedance_ohm: number | null;
  sensitivity_db: number | null;
  power_mw: number | null;
  source_name: string | null;
  source_url: string | null;
  verified: number;
  updated_at: number;
};

export type CachedSpecResult = {
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

const dbPath = path.resolve(process.cwd(), "data", "spec_cache.sqlite");
const db = new Database(dbPath);

db.pragma("journal_mode = WAL");
db.exec(`
CREATE TABLE IF NOT EXISTS spec_cache (
  query_key TEXT PRIMARY KEY,
  query_original TEXT,
  brand TEXT,
  model TEXT,
  driver_size_mm REAL,
  frequency_low_hz INTEGER,
  frequency_high_hz INTEGER,
  impedance_ohm REAL,
  sensitivity_db REAL,
  power_mw REAL,
  source_name TEXT,
  source_url TEXT,
  verified INTEGER NOT NULL,
  updated_at INTEGER NOT NULL
);
CREATE INDEX IF NOT EXISTS idx_spec_cache_updated_at ON spec_cache(updated_at);
`);

const getStmt = db.prepare(`
  SELECT
    brand,
    model,
    driver_size_mm,
    frequency_low_hz,
    frequency_high_hz,
    impedance_ohm,
    sensitivity_db,
    power_mw,
    source_name,
    source_url,
    verified,
    updated_at
  FROM spec_cache
  WHERE query_key = ?
`);

const upsertStmt = db.prepare(`
  INSERT INTO spec_cache (
    query_key,
    query_original,
    brand,
    model,
    driver_size_mm,
    frequency_low_hz,
    frequency_high_hz,
    impedance_ohm,
    sensitivity_db,
    power_mw,
    source_name,
    source_url,
    verified,
    updated_at
  ) VALUES (
    @query_key,
    @query_original,
    @brand,
    @model,
    @driver_size_mm,
    @frequency_low_hz,
    @frequency_high_hz,
    @impedance_ohm,
    @sensitivity_db,
    @power_mw,
    @source_name,
    @source_url,
    @verified,
    @updated_at
  )
  ON CONFLICT(query_key) DO UPDATE SET
    query_original = excluded.query_original,
    brand = excluded.brand,
    model = excluded.model,
    driver_size_mm = excluded.driver_size_mm,
    frequency_low_hz = excluded.frequency_low_hz,
    frequency_high_hz = excluded.frequency_high_hz,
    impedance_ohm = excluded.impedance_ohm,
    sensitivity_db = excluded.sensitivity_db,
    power_mw = excluded.power_mw,
    source_name = excluded.source_name,
    source_url = excluded.source_url,
    verified = excluded.verified,
    updated_at = excluded.updated_at
`);

const deleteExpiredStmt = db.prepare(`
  DELETE FROM spec_cache
  WHERE updated_at < ?
`);

function toResult(row: CacheRecord): CachedSpecResult {
  return {
    brand: row.brand ?? undefined,
    model: row.model ?? undefined,
    driverSizeMm: row.driver_size_mm ?? undefined,
    frequencyLowHz: row.frequency_low_hz ?? undefined,
    frequencyHighHz: row.frequency_high_hz ?? undefined,
    impedanceOhm: row.impedance_ohm ?? undefined,
    sensitivityDb: row.sensitivity_db ?? undefined,
    powerMw: row.power_mw ?? undefined,
    sourceName: row.source_name ?? undefined,
    sourceUrl: row.source_url ?? undefined,
    verified: row.verified === 1,
  };
}

export function getSpecFromCache(queryKey: string, ttlDays: number): CachedSpecResult | null {
  const row = getStmt.get(queryKey) as CacheRecord | undefined;
  if (!row) return null;

  const ttlMillis = Math.max(ttlDays, 1) * 24 * 60 * 60 * 1000;
  const isExpired = Date.now() - row.updated_at > ttlMillis;
  if (isExpired) return null;

  return toResult(row);
}

export function upsertSpecCache(
  queryKey: string,
  queryOriginal: string,
  spec: CachedSpecResult
): void {
  upsertStmt.run({
    query_key: queryKey,
    query_original: queryOriginal,
    brand: spec.brand ?? null,
    model: spec.model ?? null,
    driver_size_mm: spec.driverSizeMm ?? null,
    frequency_low_hz: spec.frequencyLowHz ?? null,
    frequency_high_hz: spec.frequencyHighHz ?? null,
    impedance_ohm: spec.impedanceOhm ?? null,
    sensitivity_db: spec.sensitivityDb ?? null,
    power_mw: spec.powerMw ?? null,
    source_name: spec.sourceName ?? null,
    source_url: spec.sourceUrl ?? null,
    verified: spec.verified ? 1 : 0,
    updated_at: Date.now(),
  });
}

export function purgeExpiredCache(ttlDays: number): number {
  const ttlMillis = Math.max(ttlDays, 1) * 24 * 60 * 60 * 1000;
  const cutoff = Date.now() - ttlMillis;
  const result = deleteExpiredStmt.run(cutoff);
  return result.changes;
}
