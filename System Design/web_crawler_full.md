**System Design: Web Crawler (Full Version)**

---

### ✅ 1. Clarify the Requirements

**Functional Clarifications**:
- Should crawl and index **web pages recursively**, starting from seed URLs.
- Must obey **robots.txt** and crawl-delay policies.
- Should **detect duplicate pages** and avoid re-crawling them.
- Must support **re-crawling** after configurable intervals.
- Crawl must support **URL prioritization**.
- System should be **resilient to failures and scalable**.
- Should provide logs and insights (monitoring, alerting).

**Non-Functional Clarifications**:
- Latency isn't a primary concern — focus is on **throughput and politeness**.
- System must **scale horizontally**.
- **High availability** (even if some fetchers fail).
- Must maintain **eventual consistency** for duplicate checks.
- Must be **secure** and compliant with legal standards.
- **Extensibility**: Ability to plug in ML components for intelligent crawling in future.
- Must follow **modular, loosely coupled architecture**.

---

### ✅ 2. Functional Requirements (Explained)

1. **Start Crawling from Seed URLs**: Input a set of seed URLs to initiate the crawl tree.
2. **Recursively Discover New Links**: Extract URLs from page content and enqueue them.
3. **Follow Robots.txt**: Respect disallowed paths and delays.
4. **Store Crawled Content**: Save HTML/text for search indexing or offline processing.
5. **Detect Duplicates**: Prevent re-fetching the same content via hashing.
6. **Prioritize URLs**: High PR or known domains should be prioritized.
7. **Support Recrawling**: Set intervals or conditions under which pages are revisited.

---

### ✅ 3. Non-Functional Requirements (Explained)

1. **Scalability**: Use horizontal scaling for fetchers, parsers, queues.
2. **Fault Tolerance**: Retries on fetch failure, durable queues, backup.
3. **Availability**: Redundant components, failover fetchers.
4. **Performance**: Optimize throughput, not latency (thousands of URLs/sec).
5. **Security**: Sanitize inputs, follow domain restrictions, avoid malicious links.
6. **Monitoring**: Real-time tracking of queue depth, URL rate, errors.
7. **Extensibility**: Design with plugin-based architecture (ML, language detection).

---

### ✅ 4. High-Level Architecture (11+ Components)

```
     +-------------------+     +-------------------+
     |  Seed URL Source  +----->  URL Frontier    |
     +--------+----------+     +---------+--------+
              |                          |
              v                          v
+-------------+-------------+     +------+-----------+
| Robots.txt Fetcher        |<----+  Duplicate Filter|
+---------------------------+     +------+-----------+
              |                          |
              v                          v
+---------------------------+     +------+-----------+
| Politeness Policy Manager |     |   URL Scheduler |
+---------------------------+     +------+-----------+
              |                          |
              v                          v
     +--------+----------+     +--------+-----------+
     |   Fetcher Service  |----> Content Processor  |
     +--------------------+     +--------+-----------+
              |                          |
              v                          v
     +--------+-----------+    +---------+----------+
     | HTML Parser        |    |  Link Extractor    |
     +--------+-----------+    +---------+----------+
              |                          |
              v                          v
     +--------+-----------+    +---------+----------+
     | Storage (S3/ES/DB) |    |  Analytics Pipeline |
     +--------------------+    +---------------------+
```

---

### ✅ 5. Component Deep Dive (100+ words each)

1. **Seed URL Source**: Initial set of trusted, well-known URLs. Can be from manual entry, sitemap.xml, or a domain dump. Seed URLs kickstart the crawling process and help cover the most relevant content first.

2. **URL Frontier**: Priority queue that holds discovered URLs waiting to be fetched. Uses scoring logic based on domain priority, depth, or freshness. Powered by Redis or a custom min-heap.

3. **Robots.txt Fetcher**: Fetches and parses robots.txt rules. Ensures crawler respects disallow, crawl-delay, and user-agent-specific restrictions. Uses caching to prevent frequent re-fetching.

4. **Duplicate Filter**: Uses hash-based deduplication (e.g., SHA256 of normalized URL or content). Prevents redundant crawling and conserves bandwidth. Could be Bloom Filter, Redis, or Cassandra.

5. **Politeness Policy Manager**: Ensures crawler is polite by tracking delays and host-specific rate limits. Prevents hammering any single domain, and implements crawl politeness using timers.

6. **URL Scheduler**: Decides which URL from the frontier to send to fetchers based on delay compliance and priority. Can rate-limit by domain/IP. Integrates with robots.txt and politeness manager.

7. **Fetcher Service**: Makes HTTP requests to fetch page content. Handles retries, redirects, timeouts, and respects headers. Uses multiple threads and can scale horizontally.

8. **Content Processor**: Extracts metadata (title, charset, status), detects content type, filters invalid pages, and stores logs. Can apply heuristic checks (404/soft 404s).

9. **HTML Parser**: Extracts main HTML body. Can use tools like JSoup or Apache Tika to strip unnecessary tags and extract clean text.

10. **Link Extractor**: Extracts `<a href>` tags, validates and normalizes them, filters out unwanted links, and re-inserts new URLs into the frontier.

11. **Storage Layer**: Stores full HTML, extracted text, and metadata. Uses S3 for raw content, ElasticSearch for search, or NoSQL (MongoDB) for metadata. Supports indexing and backup.

12. **Analytics Pipeline**: Sends page signals (language, length, domain, freshness) to analytics/ML for scoring, topic tagging, and future prioritization.

---

### ✅ 6. Design Core Entities (With 3 URLs)

#### URL Object
```json
{
  "url": "https://example.com",
  "status": "pending",
  "lastCrawled": null,
  "robotsAllowed": true,
  "priorityScore": 10
}
```

#### Fetched Page
```json
{
  "url": "https://example.com/about",
  "title": "About Us",
  "htmlSize": 51235,
  "statusCode": 200,
  "contentHash": "ab34...f91",
  "timestamp": "2025-07-16T12:00:00Z"
}
```

#### Link Object
```json
{
  "fromUrl": "https://example.com",
  "toUrl": "https://example.com/contact",
  "anchorText": "Contact",
  "depth": 1
}
```

---

### ✅ 7. Estimation (Traffic, Storage, Bandwidth)

- **Target**: 100M pages crawled/month
- **Avg HTML page size**: 50 KB
- **Monthly Bandwidth**: 100M * 50KB = ~5 TB
- **Storage Required (1 year)**: 5TB * 12 = **60 TB** (raw + metadata)
- **URL Queue Size**: 1M–10M at any point
- **Crawl Rate per node**: ~500 pages/sec
- **Nodes needed**: 100M pages / (30 days * 86400 sec * 500 p/s) ≈ ~8–10 fetcher nodes

---

### ✅ 8. Caching Strategy
- **robots.txt responses** – Cache for 24 hours
- **URL deduplication hashes** – LRU cache
- **404/5xx response URLs** – TTL cache before retrying
- **Link popularity scores** – In-memory TTL for recency

---

### ✅ 9. API Design (REST)
- `POST /seed`: Submit seed URL
- `GET /url/status`: Get crawl status of a URL
- `GET /logs/errors`: Crawl failures
- Secured with API key + RBAC
- Rate limited at 10 requests/sec/client

---

### ✅ 10. Data Consistency and Synchronization
- Use **Kafka** for URL/event propagation
- Content and metadata stored in separate services
- Deduplication is **eventually consistent**
- Retry & compensation jobs handle delayed sync

---

### ✅ 11. Scalability & Load Handling
- Stateless fetchers → easy horizontal scaling
- ElasticSearch → sharded and replicated
- Redis frontier → partitioned by domain hash
- Auto-scaling using CPU/network metrics

---

### ✅ 12. Fault Tolerance and HA
- Retry on failure (3x backoff)
- Dead-letter queues for persistent failures
- Health checks for each fetcher/parser
- Load balanced fetchers with graceful degradation

---

### ✅ 13. Security Considerations
- HTTPS for all fetches and API access
- Validate all extracted URLs to avoid malware
- Sanitize stored HTML to remove scripts
- Use token-based access for dashboards

---

### ✅ 14. Monitoring & Alerting
- Prometheus for metrics (queue size, fetch rate)
- Grafana dashboards for trends
- Alert on: crawl spikes, error rates, node failures
- ELK Stack for logs and search

---

### ✅ 15. Trade-Offs Discussion
- **Chose eventual consistency** over strong for performance
- **Bloom filters** may give false positives → trade-off space vs accuracy
- ElasticSearch over SQL for flexibility in search
- Kafka used despite complexity to enable async processing

---

### ✅ 16. Future Improvements
- ML-based priority ranking for smart crawling
- JavaScript rendering with headless browsers (e.g. Puppeteer)
- Geo-distributed crawlers for better latency
- WebSockets to stream crawl logs live

---

✅ Final Thoughts:
This design follows best practices in scalability, modularity, and system resilience. By applying principles like async processing, intelligent caching, sharding, and event-driven architecture, the system can crawl and index billions of pages reliably and efficiently.

---

