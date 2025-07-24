**System Design: Log Ingestion System**

---

### ✅ 1. Clarify the Requirements

**Functional Requirements Clarifications:**
- Accept logs from multiple services and formats (JSON, plain text, ECS).
- Ingest logs in near real-time.
- Support structured and unstructured logs.
- Enable search, filtering, and visualization.
- Ensure reliable delivery with at-least-once semantics.
- Retain logs for configurable durations.
- Index logs for fast querying and analytics.

**Non-Functional Requirements Clarifications:**
- High availability (99.99%)
- Horizontal scalability to support spikes in log volume
- Low ingestion latency (<2s for majority)
- Durable storage with retention enforcement
- Strong observability into pipeline health
- Secure at all stages (encryption, access control)
- Fault-tolerant (component failures must not drop logs)

---

### ✅ 2. Functional Requirements

1. **Multi-source Input Handling**: Receive logs from apps, servers, containers, cloud infra.
2. **Real-Time Streaming**: Push logs into pipeline with <2s latency.
3. **Schema Normalization**: Convert formats into a unified schema (ECS, for example).
4. **Log Indexing**: Store metadata-rich logs for search.
5. **Query Interface**: Support filtering logs by time, level, service, etc.
6. **Alerting Integration**: Send alerts on error patterns or volume spikes.
7. **Retention & Archiving**: Retain logs based on service-specific policies.

---

### ✅ 3. Non-Functional Requirements

1. **High Throughput**: Handle millions of log lines/sec.
2. **Fault Tolerance**: Buffer and retry on failure.
3. **Durability**: Persist all logs to storage even under failure.
4. **Low Latency**: Minimal delay between log emission and storage/indexing.
5. **Observability**: Pipeline metrics, dashboards, error tracking.
6. **Security**: Role-based access, TLS everywhere.
7. **Cost Optimization**: Cold storage for archived logs (e.g., S3 Glacier).

---

### ✅ 4. High-Level Architecture (11+ Components)

```
+-------------+      +----------------+     +----------------+    +--------------+
| App Clients | ---> | Log Shippers   | --> | Ingestion API  | -> | Kafka Topics |
+-------------+      +----------------+     +----------------+    +--------------+
                                                                |
                                                                v
                                                          +-------------+
                                                          | Stream Router|
                                                          +------+------+
                                                                 |
       +----------------+      +--------------------+     +------+------+
       | Parser/Enricher| <--- | Config Store       | --> | Indexer     |
       +----------------+      +--------------------+     +-------------+
                                                                 |
                                                    +----------------------+
                                                    | Time-Series Storage   |
                                                    | + Object Archive (S3) |
                                                    +----------+-----------+
                                                               |
                                                               v
                                                   +----------------------+
                                                   | Query & Dashboard UI  |
                                                   +----------------------+
```

---

### ✅ 5. Component Deep Dive

1. **Log Shippers**: Deployed on host machines or containers (Filebeat, Fluentd). Collect stdout, file logs, syslogs.
2. **Ingestion API**: Validates incoming log packets, applies rate-limiting, forwards to Kafka.
3. **Kafka Topics**: Used for buffering logs to decouple ingestion from processing. Partitions by service/region.
4. **Stream Router**: Inspects log type/metadata and routes to appropriate parser pipeline.
5. **Parser/Enricher**: Converts logs into structured format, attaches tenant ID, service name, region, etc.
6. **Config Store**: Manages field mappings, schema definitions, sensitive field masking rules.
7. **Indexer**: Pushes structured logs to search engine (e.g., Elasticsearch).
8. **Time-Series Storage**: Stores high-volume time-indexed logs for querying (TSDB + cold backup).
9. **Object Archive**: Stores compressed logs in blob storage (e.g., S3) for long-term compliance.
10. **Query UI**: Frontend for searching, filtering, and visualizing logs.
11. **Alerting System**: Uses rules to trigger alerts on anomalies (e.g., spike in 500 errors).

---

### ✅ 6. Database Design (Log Entity Examples)

**Example 1 - ECS Normalized Log:**
```json
{
  "@timestamp": "2025-07-16T18:22:00Z",
  "log.level": "error",
  "service.name": "auth-service",
  "message": "Login failed for user X",
  "host.name": "ip-172-31-2-5",
  "trace.id": "abc-123",
  "event.dataset": "auth.logs"
}
```

**Example 2 - Raw App Log:**
```json
{
  "timestamp": "2025-07-16T18:21:50Z",
  "level": "INFO",
  "msg": "user logged in",
  "user_id": "u123",
  "region": "us-east-1"
}
```

**Example 3 - Parsed & Enriched:**
```json
{
  "timestamp": "2025-07-16T18:21:50Z",
  "log_level": "INFO",
  "message": "user logged in",
  "user": { "id": "u123", "region": "us-east-1" },
  "source": "auth-service",
  "host_ip": "172.31.2.5"
}
```

---

### ✅ 7. Estimations

Assume:
- 10,000 hosts sending logs
- Each emits 5 logs/sec
- Total logs/sec = 50,000
- Each log ≈ 1 KB
- Ingestion per day = 50,000 × 1 KB × 86400 = ~4.3 GB/hour, ~100 GB/day
- Monthly = ~3 TB

**Kafka retention**: 3 days (~300 GB buffer)
**Hot storage (ES)**: Retain 15 days (~1.5 TB)
**Cold archive (S3)**: Retain 6 months (~18 TB)

---

### ✅ 8. API Design (REST/HTTP)

- `POST /logs/bulk`
- `GET /logs/search?q=error&from=ts1&to=ts2`
- `GET /logs/{traceId}`
- `GET /stats/error-rate?service=xyz`
- Rate-limited, JWT-secured

---

### ✅ 9. Caching

- Recent logs in Redis for UI performance
- Query results cached via Elastic’s query cache
- Use CDN for static dashboards

---

### ✅ 10. Consistency and Sync

- Write-ahead logs in Kafka for durability
- Async indexing ensures system isn’t blocked
- Eventual consistency for cold storage

---

### ✅ 11. Fault Tolerance

- Retry on shipper and API failure
- Kafka as buffer during downstream lag
- Storage replication across AZs
- Circuit breakers for storage/index

---

### ✅ 12. Security

- TLS across all communication
- Role-based access control
- Masking sensitive data during ingestion
- Secure log access & auditing

---

### ✅ 13. Monitoring & Alerting

- Log drop rates, ingest latency, parsing errors
- Grafana + Prometheus, AlertManager
- ELK for operational visibility

---

### ✅ 14. Trade-offs

- Chose Kafka over RabbitMQ for high throughput
- Cold storage is cheap but slower retrieval
- Elastic search is fast but costly at scale

---

### ✅ 15. Future Improvements

- ML-based log classification and anomaly detection
- Support for real-time dashboards
- Multi-tenant log pipelines with isolated quotas

---

✅ Conclusion:
The Log Ingestion System ensures reliable, secure, and scalable collection and querying of application logs across services and teams. It is future-ready for multi-tenant, cloud-native operations with full observability.

---

