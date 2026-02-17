import express from "express";
import cors from "cors";
import { fetchOfficialSpecs } from "./sources/officialFetcher.js";

const app = express();
app.use(cors());

app.get("/health", (_req, res) => {
  res.json({ status: "ok" });
});

app.get("/specs", async (req, res) => {
  const query = String(req.query.query || "").trim();
  if (!query) {
    res.status(400).json({ error: "Missing query" });
    return;
  }

  try {
    const result = await fetchOfficialSpecs(query);
    if (!result) {
      res.status(404).json({ error: "No spec found in trusted sources" });
      return;
    }
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: "Spec lookup failed" });
  }
});

const port = process.env.PORT ? Number(process.env.PORT) : 8080;
app.listen(port, () => {
  console.log(`SafeSound backend running on :${port}`);
});
