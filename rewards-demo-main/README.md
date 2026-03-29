Reporting UI (React + Vite)

Requirements:
- Node 18+ (or recent LTS)
- Your Spring Boot API running on http://localhost:8080 (default)

1) Install
   npm install

2) Run (dev)
   npm run dev
   The app will be available at http://localhost:3000

Configuration:
- To change API base URL set environment variable VITE_API_BASE_URL.
  Example: VITE_API_BASE_URL=http://localhost:8080 npm run dev

CORS:
- If your Spring Boot app is at http://localhost:8080, enable CORS for the UI origin (http://localhost:3000). See the sample CorsConfig.java file included below.

Notes:
- The UI expects the transactions endpoint to return a Spring Page with fields:
  { content: [...], totalElements, totalPages, number, size }
- The summary endpoint is GET /api/reports/summary