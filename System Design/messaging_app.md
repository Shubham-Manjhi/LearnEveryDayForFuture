**System Design: Online Messaging App (e.g., WhatsApp, Slack)**

---

### 🔎 1. Clarify the Requirements

**Functional Requirements:**

1. Real-time 1:1 and group messaging.
2. Message delivery acknowledgment (sent, delivered, read).
3. Media support (images, video, voice notes).
4. End-to-end encryption.
5. Typing indicators and read receipts.
6. Notifications and push alerts.
7. Searchable message history.

**Non-Functional Requirements:**

1. Real-time low-latency communication (<100ms).
2. Scalability to 100M+ users.
3. Fault tolerance and auto-recovery.
4. Data durability and backups.
5. High availability (>99.99%).
6. Secure storage and transmission.
7. Multi-device sync support.

---

### ✅ 2. High-Level Architecture (12+ Components)

```
+--------------+     +--------------+     +-----------------+     +------------------+
| Mobile/Web   | <-> | Load Balancer| <-> | API Gateway      | <-> | Auth Service      |
+--------------+     +--------------+     +-----------------+     +------------------+
                                                              |
                                                              v
+--------------------+   +--------------------+   +-------------------------+
| Chat Service        |   | Media Service       |   | Notification Service    |
+--------------------+   +--------------------+   +-------------------------+
         |                        |                         |
         v                        v                         v
+--------------------+   +--------------------+   +-------------------------+
| Message DB (NoSQL)  |   | Object Storage     |   | Push Queue + FCM/APNS   |
+--------------------+   +--------------------+   +-------------------------+
         |                                                  |
         v                                                  v
+------------------------+      +-------------------------+     +--------------------+
| WebSocket Sync Server  | <--> | Real-time Event Queue    | <-> | Presence Service   |
+------------------------+      +-------------------------+     +--------------------+
                                                                 |
                                                                 v
                                                       +-----------------------+
                                                       | Monitoring & Logging  |
                                                       +-----------------------+
```

---

### ✅ 3. Component Deep Dive

1. **Mobile/Web Clients**: Provide the interface for sending and receiving messages, typing indicators, and read receipts. Use WebSocket or gRPC for real-time updates.

2. **Load Balancer**: Distributes incoming traffic, maintains session stickiness, and scales the infrastructure based on usage.

3. **API Gateway**: Routes external HTTP/gRPC traffic to internal services, applies auth checks, rate limits, and logs API calls.

4. **Auth Service**: Manages user sign-up, sign-in, session tokens, device pairing, and supports SSO/OAuth.

5. **Chat Service**: Core logic to handle message persistence, chat thread management, and conversation metadata. Integrates with encryption services.

6. **Media Service**: Handles upload, compression, and retrieval of media files. Uses CDN and object storage (like AWS S3 or GCP Storage).

7. **Notification Service**: Delivers real-time alerts using Firebase Cloud Messaging (FCM) and Apple Push Notification (APNS). Deduplicates and schedules retries.

8. **Message DB (NoSQL)**: Stores all messages with time-based partitioning. Supports high write throughput and quick retrieval. (e.g., Cassandra, DynamoDB)

9. **Object Storage**: Used for images, voice, videos, and documents. Includes metadata indexing and secure, temporary URL generation.

10. **WebSocket Sync Server**: Manages persistent connections with mobile/web clients, delivers real-time message updates and status changes.

11. **Real-time Event Queue**: (e.g., Kafka, Pulsar) for decoupling message ingestion, analytics, delivery acknowledgments, and notification triggers.

12. **Presence Service**: Tracks user online/offline status, last seen, typing states, and broadcasts status changes to relevant users.

13. **Monitoring & Logging**: Uses Prometheus/Grafana for infrastructure metrics, ELK stack for app logs, and alerting on latency/errors.

---

### ✅ 4. Core Entities (Example JSON)

#### Message

```json
{
  "message_id": "msg_789",
  "sender_id": "user_123",
  "chat_id": "chat_456",
  "content": "Hey, are we meeting today?",
  "timestamp": "2025-07-16T08:00:00Z",
  "status": "delivered",
  "type": "text"
}
```

#### Chat

```json
{
  "chat_id": "chat_456",
  "participants": ["user_123", "user_456"],
  "created_at": "2025-07-15T10:00:00Z",
  "is_group": false
}
```

#### Media Metadata

```json
{
  "media_id": "media_101",
  "url": "https://cdn.app.com/media_101.jpg",
  "uploader_id": "user_456",
  "upload_time": "2025-07-16T08:01:00Z",
  "content_type": "image/jpeg",
  "size_bytes": 1048576
}
```

---

### ✅ 5. Estimations

- 50M DAU → 1B messages/day
- Avg message size = 1KB → 1TB/day
- 20% media messages → 200GB/day media storage
- Peak concurrent users = 10M
- WebSocket conn. persistence RAM est. = 10M x 0.5KB = 5GB

---

### ✅ 6. Caching Strategy

- Cache recent chats and message threads per user in Redis
- Use CDN edge caching for media
- Use presence cache for fast online status checks

---

### ✅ 7. API Design

- `POST /message`
- `GET /chat/{chat_id}/messages`
- `POST /upload`
- `GET /presence/{user_id}`
- `POST /read-receipt`

---

### ✅ 8. Fault Tolerance

- Use retry queues for undelivered messages
- Store offline messages in persistent DB
- Periodic media backup and message snapshots

---

### ✅ 9. Security

- End-to-End encryption with asymmetric keys
- Encrypted object storage links
- JWT with short TTL and refresh tokens
- Audit logs for admin operations

---

### ✅ 10. Monitoring & Alerts

- Alert on delivery delay, WebSocket disconnection rate
- Track avg. message latency
- Push error rate from FCM/APNS

---

### ✅ 11. Trade-offs

- Real-time delivery vs battery usage on mobile
- Eventual consistency for presence status
- WebSocket vs long-polling tradeoff under poor networks

---

### ✅ 12. Future Improvements

- Video/voice calling integration
- Message edit/delete support
- ML-based spam and abuse detection

---

🔄 Final Thoughts: Designing a messaging app demands real-time efficiency, low latency, high availability, and security. A microservices-based architecture with dedicated services for chat, presence, media, and delivery ensures modularity and scalability for global users.

