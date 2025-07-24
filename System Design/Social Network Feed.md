**System Design: Social Network Feed (e.g., Facebook, Instagram)**

---

### 📅 1. Clarify the Requirements

**Functional Requirements:**

1. Users can follow/unfollow other users.
2. Users can post text/images/videos.
3. Users should see a personalized, real-time feed.
4. Users can like, comment, and share posts.
5. Infinite scrolling with lazy loading.
6. Push notifications for new feed activity.
7. Content moderation and reporting tools.

**Non-Functional Requirements:**

1. High availability (99.99%) and low latency (<200ms feed load time).
2. Scalable to 1B+ users and 100M DAU.
3. Consistent feed ranking logic.
4. Real-time feed updates with minimal delay.
5. Strong security, including OAuth2 and data privacy.
6. Regional data compliance (e.g., GDPR).
7. System resilience and automated recovery.

---

### ✅ 2. High-Level Architecture (11+ Components)

```
+-------------+     +--------------+     +-----------------+     +---------------+
| Mobile/Web  | <-> | Load Balancer| <-> | API Gateway      | <-> | Auth Service   |
+-------------+     +--------------+     +-----------------+     +---------------+
                                              |
                                              v
             +--------------+     +--------------------+     +----------------------+
             | Feed Gen Svc | <-> | User Post Service  | --> | Media Processing Svc |
             +--------------+     +--------------------+     +-----------+----------+
                                                                     |
                                                                     v
                                                               +-----------+
                                                               | Blob Store|
                                                               +-----------+
                                                                     |
                                                                     v
                                                            +--------------+
                                                            | CDN Provider |
                                                            +--------------+

             +----------------+     +-------------------+     +---------------------+
             | Social Graph   | <-> | Notification Svc  | <-> | Analytics + Ranking  |
             +----------------+     +-------------------+     +---------------------+
```

---

### ✅ 3. Component Deep Dive

1. **Mobile/Web Clients**: User-facing interface enabling content consumption, uploads, scrolling, and social interaction (likes, comments).

2. **Load Balancer**: Distributes incoming requests to API services based on availability and routing rules, ensuring even load distribution.

3. **API Gateway**: Handles authentication, request routing, rate-limiting, and request validation. Connects users to backend microservices.

4. **Auth Service**: OAuth2/JWT-based service for secure user login, session management, and permission validation.

5. **Feed Generation Service**: Core component that assembles personalized feeds using social graph, user preferences, and ranking engine output.

6. **User Post Service**: Accepts new user content (text/image/video), stores metadata in a NoSQL store, and triggers downstream indexing or notifications.

7. **Media Processing Service**: Processes and compresses uploaded media, stores assets in a Blob Store (e.g., S3), and generates thumbnails.

8. **Blob Store + CDN**: High-durability object storage system to store user media, coupled with a CDN for fast delivery.

9. **Social Graph Service**: Maintains follow/unfollow relationships, used for real-time feed curation and privacy filtering.

10. **Notification Service**: Sends alerts for mentions, likes, new posts from followed users, etc., via push/email/webhooks.

11. **Analytics + Ranking Engine**: Gathers engagement stats and uses ML models to sort and rank posts based on relevance, freshness, and user interests.

---

### ✅ 4. Database Design (3 Key Entities)

#### User Entity:

```json
{
  "user_id": "u123",
  "name": "Alice",
  "followers": ["u234", "u345"],
  "following": ["u456"],
  "created_at": "2021-04-12"
}
```

#### Post Entity:

```json
{
  "post_id": "p789",
  "user_id": "u123",
  "type": "image",
  "content_url": "cdn.com/abc.jpg",
  "caption": "My sunset shot",
  "created_at": "2025-07-16T10:00:00Z"
}
```

#### Feed Entity:

```json
{
  "user_id": "u456",
  "feed": [
    {
      "post_id": "p789",
      "rank": 0.89,
      "seen": false
    },
    {
      "post_id": "p456",
      "rank": 0.82,
      "seen": true
    }
  ]
}
```

---

### ✅ 5. Estimations

- 100M DAU → avg 200 posts/day → 20B posts/day
- Avg post size = 2KB → 40TB/day
- Image/video storage = \~500TB/day
- Feed generation: \~5K QPS (queries per second) per region
- Write throughput = 250K posts/min → sharded NoSQL cluster

---

### ✅ 6. Fault Tolerance

- Feed generation backed by queue-based retries
- Multi-zone blob storage & database replication
- Dead-letter queue for notification failures

---

### ✅ 7. Security

- HTTPS + OAuth2 for all endpoints
- Role-based access for internal tools
- CSRF protection, post visibility settings, moderation logging

---

### ✅ 8. Monitoring & Alerts

- Feed latency > 200ms triggers alert
- Push notification failure rate > 2% flagged
- CDN cache miss rate monitored hourly

---

### ✅ 9. Trade-offs

- Push-vs-pull feed generation: push is fast but storage heavy, pull is flexible but slower
- Real-time updates via pub/sub vs. batch updates
- ML-based ranking improves engagement but adds latency

---

### ✅ 10. Future Enhancements

- Real-time collaborative posts
- Feed experimentation engine (A/B testing)
- Auto-summarized trending topics or community feeds

---

🔄 Final Words: A scalable social network feed must balance personalization, freshness, consistency, and latency. By leveraging a hybrid feed model, ML-based ranking, and distributed storage, we ensure real-time, engaging user experiences at global scale.

