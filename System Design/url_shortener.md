**System Design: URL Shortener (e.g., Bitly, TinyURL)**

---

### 📅 1. Clarify the Requirements

**Functional Requirements:**
1. Shorten a given long URL and return a short URL.
2. Redirect users from the short URL to the original long URL.
3. Track number of visits per short URL.
4. Support custom aliases for short URLs.
5. Expiry support (e.g., links that expire after time or clicks).
6. Handle collision and idempotency for same long URLs.
7. Admin dashboard to manage and delete links.

**Non-Functional Requirements:**
1. Low latency redirection (<100ms).
2. High availability (SLA > 99.99%).
3. Scalability to handle millions of URLs and redirects.
4. Security and spam protection.
5. Fault-tolerant and resilient to partial failures.
6. Analytics for usage tracking.
7. Consistency and accuracy of redirects.

---

### ✅ 2. High-Level Architecture (11+ Components)

```
+-------------+     +--------------+     +-----------------+     +----------------+
| Web/Mobile  | <-> | Load Balancer| <-> | API Gateway      | <-> | Auth Service    |
+-------------+     +--------------+     +-----------------+     +----------------+
                                                           |
                                                           v
                                                     +------------------+
                                                     | URL Shortener     |
                                                     | Microservice      |
                                                     +---------+--------+
                                                               |
                      +---------------------+------------------+-------------------+
                      |                     |                                      |
      +---------------------------+     +--------------------+     +--------------------------+
      | URL Mapping Store (DB)    |     | Redis Cache         |     | Analytics Service         |
      +---------------------------+     +--------------------+     +--------------------------+
                      |                                                |
                      v                                                v
              +---------------------+                        +-------------------------+
              | Base62 Encoder      |                        | Logging and Monitoring   |
              +---------------------+                        +-------------------------+
                                                               |
                                                               v
                                                     +------------------------+
                                                     | Admin Dashboard        |
                                                     +------------------------+
```

---

### ✅ 3. Component Deep Dive

1. **Web/Mobile Client**: Users input URLs, request short URLs, or visit short links.

2. **Load Balancer**: Distributes incoming traffic among API and redirection nodes.

3. **API Gateway**: Routes API traffic, enforces throttling, and handles authentication (e.g., for dashboard access).

4. **Auth Service**: Manages user login, session handling, and API keys for link creation/deletion.

5. **URL Shortener Microservice**: Handles creation of short URLs, decoding, and redirection. Checks for existing entries and manages collisions.

6. **URL Mapping Store (Database)**: Stores mappings of short codes to long URLs along with metadata (created_at, clicks, expiry). SQL or NoSQL.

7. **Redis Cache**: Frequently accessed short-to-long mappings stored for fast lookups and redirect latency improvement.

8. **Analytics Service**: Tracks click counts, referrers, IPs, and device info for each short URL.

9. **Base62 Encoder**: Converts incremental numeric ID into short alphanumeric codes (62 chars: [A-Za-z0-9]).

10. **Logging and Monitoring**: Use ELK or Prometheus/Grafana for real-time error and traffic metrics.

11. **Admin Dashboard**: Web portal to manage URL entries, expire/remove links, and view reports.

---

### ✅ 4. Core Entities (Sample)

#### Short URL Entity
```json
{
  "short_code": "b7xYz",
  "long_url": "https://openai.com/blog/gpt-4",
  "created_at": "2025-07-16T10:30:00Z",
  "expires_at": "2025-09-01T00:00:00Z",
  "user_id": "usr123",
  "clicks": 1420
}
```

#### User Entity
```json
{
  "user_id": "usr123",
  "email": "user@example.com",
  "plan": "premium",
  "created_at": "2025-01-01T12:00:00Z"
}
```

#### Visit Record (Log Entry)
```json
{
  "short_code": "b7xYz",
  "timestamp": "2025-07-16T12:05:23Z",
  "ip": "192.168.1.42",
  "device": "Chrome on Windows",
  "referrer": "https://twitter.com"
}
```

---

### ✅ 5. Estimations

- Expected URLs/day = 5M → ~150M/month
- Storage per URL = 1KB → ~150GB/month
- Redirects/sec peak = 30K/sec → Need caching + horizontal scaling
- Redis memory = 100B x 10M popular links → ~1GB RAM

---

### ✅ 6. Caching Strategy

- Use Redis with TTL for frequently redirected links.
- Invalidate on updates or expiry.
- Consider Bloom filters to avoid DB lookup for invalid short codes.

---

### ✅ 7. API Design

- `POST /shorten` → returns short URL
- `GET /{short_code}` → redirect to long URL
- `GET /stats/{short_code}` → return usage stats
- `DELETE /{short_code}` → delete the mapping

---

### ✅ 8. Fault Tolerance

- Retry DB writes and Redis updates
- Use circuit breaker for third-party integrations
- Dead-letter queue for failed analytics events

---

### ✅ 9. Security

- Validate URLs (prevent XSS, malware links)
- Rate limit anonymous shorten requests
- Use HTTPS for all redirections
- Add CAPTCHA and auth for spam protection

---

### ✅ 10. Monitoring & Alerts

- Alert on 5xx spikes
- Log slow redirects
- Track shortened link generation errors

---

### ✅ 11. Trade-offs

- Base62 with DB ID ensures uniqueness but adds DB dependency
- Hash-based codes (MD5/SHA) avoid collisions but may create duplicates for similar URLs
- Redis adds latency on cold cache misses, but improves overall performance drastically

---

### ✅ 12. Future Improvements

- QR code generator for mobile usage
- A/B testing of landing pages
- Custom branded domains (e.g., go.company.com/xYz)

---

🔄 Final Thoughts:
URL shorteners must balance speed, consistency, and spam protection. With proper caching, Base62 encoding, and monitoring, they scale effectively while staying performant.