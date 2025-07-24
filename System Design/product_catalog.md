**System Design: Product Catalog (eCommerce Platform)**

---

### 📅 1. Clarify the Requirements

**Functional Requirements:**
1. Create, update, and delete product listings.
2. Display product details (title, price, description, inventory, etc.).
3. Enable search and filtering by categories, attributes, or price.
4. Support product variations (size, color, etc.).
5. Manage stock and inventory levels.
6. Associate reviews, ratings, and Q&A.
7. Track product metadata (brand, category, warranty, etc.).

**Non-Functional Requirements:**
1. High availability for global access (99.99%).
2. Scalable to support millions of products.
3. Low-latency product search (<100ms).
4. ACID compliance for inventory updates.
5. Real-time inventory syncing across regions.
6. Secure access control for catalog updates.
7. Multi-language and multi-currency support.

---

### ✅ 2. High-Level Architecture (11+ Components)

```
+------------+     +---------------+     +-----------------+     +------------------+
| Web/Mobile | <-> | Load Balancer | <-> | API Gateway      | <-> | Auth Service     |
+------------+     +---------------+     +-----------------+     +------------------+
                                            |
                                            v
                                +------------------------+
                                | Product Catalog Service|
                                +------------------------+
                                            |
        +------------------+    +---------------------+    +--------------------+
        | Inventory Service| <- | Pricing Service     | <- | Review/Rating Svc  |
        +------------------+    +---------------------+    +--------------------+
                 |                          |                         |
                 v                          v                         v
         +---------------+         +----------------+         +------------------+
         | SQL Database  |         | Redis/Memcache |         | NoSQL DB (Reviews)|
         +---------------+         +----------------+         +------------------+

                            +---------------------+
                            | Product Search Index|
                            +---------------------+
                                     |
                                     v
                                +----------+
                                | Elasticsearch|
                                +----------+

                            +------------------+
                            | Media Storage CDN|
                            +------------------+
```

---

### ✅ 3. Component Deep Dive

1. **Web/Mobile Client**: Presents catalog data to end users. Enables browsing, searching, and viewing product detail pages (PDP). Also enables sellers to manage inventory and listings.

2. **Load Balancer**: Handles traffic routing to ensure even distribution across service instances for high availability.

3. **API Gateway**: Central point for request routing, rate limiting, and authentication. Routes client requests to appropriate microservices.

4. **Auth Service**: Manages user and admin authentication using JWT or OAuth2. Ensures only authorized users can update the catalog.

5. **Product Catalog Service**: Core service that maintains product details (title, description, category, etc.) and acts as the primary source for product listings.

6. **Inventory Service**: Tracks real-time stock levels. Ensures atomic updates when orders are placed or canceled. Handles alerts for low inventory.

7. **Pricing Service**: Manages price, discounts, and currency localization. Applies tiered pricing and regional promotions.

8. **Review/Rating Service**: Handles customer feedback, star ratings, comments, and Q&A. Used to influence search and recommendation.

9. **SQL Database**: Stores structured catalog data like product IDs, descriptions, and stock levels with relational integrity.

10. **Redis/Memcache**: Used to cache frequently accessed product info or inventory data for faster reads and to offload DB load.

11. **NoSQL DB (Reviews)**: Handles unstructured and high-volume review data, including star ratings, nested replies, and timestamps.

12. **Product Search Index (Elasticsearch)**: Full-text index for product name, attributes, and category for fast, filterable search experiences.

13. **Media Storage CDN**: Hosts product images and videos, distributed globally to reduce load time and improve user experience.

---

### ✅ 4. Database Design (3 Core Entities)

#### Product Entity
```json
{
  "product_id": "prod123",
  "title": "Wireless Headphones",
  "category": "Electronics",
  "brand": "SoundBliss",
  "description": "Noise-cancelling over-ear headphones.",
  "variants": ["Black", "Blue"],
  "media_urls": ["cdn.com/img1.jpg"],
  "created_at": "2025-07-16"
}
```

#### Inventory Entity
```json
{
  "product_id": "prod123",
  "variant": "Black",
  "region": "IN",
  "quantity": 120,
  "warehouse_id": "wh_456"
}
```

#### Review Entity
```json
{
  "review_id": "rev789",
  "product_id": "prod123",
  "user_id": "user456",
  "rating": 4,
  "comment": "Great sound quality!",
  "created_at": "2025-07-15"
}
```

---

### ✅ 5. Estimations

- Products: 10M
- Avg product size: 5KB → 50GB total
- Reviews: 100M → ~300GB in NoSQL
- Inventory writes: 5K/sec during sale events
- Search reads: 100K QPS (queries per second)
- Cache hit ratio: ~90%, DB reads reduced significantly

---

### ✅ 6. Fault Tolerance

- Retry logic in write flows (price, stock updates)
- DB replication and backup for recovery
- CDN fallback for image delivery
- Queue buffering for downstream indexing failures

---

### ✅ 7. Security

- Secure product update APIs with RBAC
- Input validation, CSRF/XSS protections on seller panel
- Token-based auth for APIs, encrypted media links

---

### ✅ 8. Monitoring & Alerts

- Inventory mismatch alerts
- High latency in search queries flagged
- Media CDN failures logged and retried

---

### ✅ 9. Trade-offs

- Real-time indexing vs. batch indexing (consistency vs. throughput)
- SQL for core catalog vs. NoSQL for reviews
- Sharding based on category or region to reduce contention

---

### ✅ 10. Future Enhancements

- Auto-generated SEO content via LLM
- Image search and visual recommendations
- Price optimization using demand elasticity models

---

🔄 Final Words: A scalable and performant product catalog must ensure rich metadata, fast retrieval, real-time inventory updates, and content flexibility. With search indexing, distributed caching, and modular microservices, this design serves both global buyers and sellers efficiently.

