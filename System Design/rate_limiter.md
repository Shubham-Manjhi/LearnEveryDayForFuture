**System Design: Rate Limiter**

---

### ✅ 1. Clarify the Requirements

**Functional Clarifications:**
- Prevent abuse by limiting API requests per user/client.
- Should support **per-IP**, **per-user**, and **per-endpoint** limits.
- Implement flexible strategies: **Token Bucket**, **Leaky Bucket**, and **Fixed Window**.
- Provide real-time enforcement and **usage introspection**.
- Expose rate-limiting feedback in headers (e.g., X-RateLimit-Remaining).
- Allow soft and hard limits per plan (free, premium, etc.).
- API gateway integration.

**Non-Functional Clarifications:**
- **Low latency** (<2ms for decision).
- Must be **highly available and distributed**.
- **Near real-time synchronization** across nodes.
- **Fault-tolerant** with fallback.
- **Secure**: No leaks across tenants.
- Configurable per client.
- Should scale with millions of TPS.

---

### ✅ 2. Functional Requirements

1. **Token Consumption**: Deduct token on every request.
2. **Bucket Refill Logic**: Periodically add tokens or drain bucket.
3. **Limits by Scope**: IP, user, API key, or client ID.
4. **Plan Aware Throttling**: Different limits for Free/Paid.
5. **Real-Time Feedback**: Headers to notify rate limit status.
6. **Config Management**: Dynamic limits per user group.
7. **Stats Reporting**: Logs, dashboards, usage analytics.

---

### ✅ 3. Non-Functional Requirements

1. **Latency**: Limit decision in under 2ms.
2. **Scalability**: Handle millions of requests/sec.
3. **High Availability**: Stateless design with HA Redis.
4. **Resilience**: Graceful fallback if Redis fails.
5. **Observability**: Request metrics, hit/miss counters.
6. **Security**: Prevent abuse via signed tokens.
7. **Distributed**: Global throttling across pods/regions.

---

### ✅ 4. Choosing a Model: Token Bucket vs Leaky Bucket

| Criteria             | Token Bucket                        | Leaky Bucket                        |
|---------------------|-------------------------------------|-------------------------------------|
| Burst Allowance     | Yes (tokens can accumulate)         | No (fixed rate outflow)             |
| Uniformity          | Less uniform                        | Smooth output                       |
| Flexibility         | High (token refill, burst allowed)  | Simple, less flexible               |
| Use Case            | APIs, user actions                  | Payment gateways, logging systems   |

✅ **Chosen**: **Token Bucket** (for burst tolerance + flexibility)

---

### ✅ 5. Stateless vs Stateful

- **Stateless**:
  - Stored in client-side JWT
  - Pros: no backend lookup, fast
  - Cons: easy to forge, poor control

- **Stateful (Preferred)**:
  - Uses Redis to track counters & timestamps
  - More reliable and controllable

✅ Chosen: **Stateful** + Redis (with fallback to in-memory on failure)

---

### ✅ 6. High-Level Architecture (11 Components)

```
+---------------------+
|     Client/API      |
+--------+------------+
         |
         v
+---------------------+
|   API Gateway       |
+--------+------------+
         |
         v
+----------------------+
| Rate Limiter Filter |
+--------+------------+
         |
         v
+---------------------+       +-------------------+
| Redis Store (HA)    |<----->| Token Refill Job  |
+---------------------+       +-------------------+
         |
         v
+-------------------------+
| Rate Limit Config Store |
+-------------------------+
         |
         v
+---------------------+     +------------------+
| Rate Limit Tracker  |<--->| Monitoring Stack |
+---------------------+     +------------------+
         |
         v
+-------------------------+
| Response Header Writer  |
+-------------------------+
```

---

### ✅ 7. Component Explanation (Highlights)

1. **API Gateway**: Enforces policy and invokes rate-limit filter. Integrates with OAuth/JWT auth.

2. **Rate Limiter Filter**: Middleware that checks request quota before forwarding.

3. **Redis Store**: Tracks token count and timestamps per user/key. Uses Redis `INCR`, `EXPIRE`, `ZSET` operations.

4. **Token Refill Job**: Background job that replenishes tokens per policy. Can use `cron` or `Lua` script in Redis.

5. **Config Store**: Stores per-client policy configs. Can be SQL/NoSQL.

6. **Monitoring Stack**: Prometheus + Grafana to monitor limit hits, blocks, refill metrics.

7. **Response Header Writer**: Adds `X-RateLimit-Limit`, `Retry-After`, etc., for transparency.

8. **Fallback Mechanism**: Local memory fallback with sliding window.

9. **Client Identification**: API key, user ID, or IP-based identifiers.

10. **Admin Dashboard**: Change limits, see stats, manage abuse.

11. **CDN-aware Limiting**: Optional edge-limiting with Cloudflare Workers/Lambda@Edge.

---

### ✅ 8. Redis Key Schema

```
rate:<user_id>:<api>
- tokens: integer
- timestamp: unix epoch
```

---

### ✅ 9. Sample Token Bucket Logic (Pseudo Java)

```java
if (tokens > 0) {
  tokens -= 1;
  allowRequest();
} else {
  rejectRequest();
}
```

---

### ✅ 10. Estimation (Example)

- **QPS**: 100K requests/sec
- **Users**: 1M
- Each key = 64 bytes (avg)
- Memory per user = ~150B
- Redis memory = 150B * 1M = 150MB
- With replication and buffer = ~500MB RAM

Redis handles 1M+ ops/sec with pipelining and clustering ✅

---

### ✅ 11. Trade-offs

- Token Bucket allows bursts but may let abuse if refill rate high.
- Redis adds latency (1ms) vs local mem (0.1ms), but enables shared view.
- Circuit breakers on Redis prevent system lock-up.

---

### ✅ 12. Future Enhancements

- Add AI/ML for dynamic limit tuning.
- Expose GraphQL API for user usage stats.
- Integrate with billing system for overages.
- Implement geo-aware sharded Redis clusters.

---

✅ Conclusion: A highly scalable, Redis-backed Token Bucket rate limiter with low latency, flexible scoping, and multi-tenant safety, perfect for modern API traffic control.

---

