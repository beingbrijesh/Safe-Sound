import { readFileSync } from "fs";
import path from "path";

const dataPath = path.resolve(process.cwd(), "data", "official_domains.json");
const raw = readFileSync(dataPath, "utf-8");

export const officialDomains: string[] = JSON.parse(raw);
