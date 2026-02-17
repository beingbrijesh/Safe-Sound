import { officialDomains } from "./officialDomains.js";

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

// TODO: Implement manufacturer-specific adapters.
// This stub ensures only whitelisted manufacturer domains are used.
export async function fetchOfficialSpecs(_query: string): Promise<SpecResult | null> {
  void officialDomains;
  return null;
}
