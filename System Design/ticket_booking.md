**System Design: Online Ticket Booking System (e.g., BookMyShow, Ticketmaster)**

---

### 📅 1. Clarify the Requirements

**Functional Requirements:**

1. Users can browse movies/events and available seats.
2. Users can select seats and book tickets in real time.
3. Handle multiple events and venues simultaneously.
4. Payment gateway integration with transactional safety.
5. Prevent double booking of the same seat.
6. Support for offers and coupons.
7. Allow cancellation and refunds (as per policy).

**Non-Functional Requirements:**

1. Low-latency seat lock and booking operations (<200ms).
2. Scalability to handle spikes during popular event releases.
3. High availability (target: 99.99% uptime).
4. Strong consistency for seat booking operations.
5. Secure payments and user data protection.
6. Real-time availability and updates.
7. Logging and monitoring of user and booking activities.

---

### ✅ 2. High-Level Architecture (13 Components)

```
+-------------+     +--------------+     +-----------------+     +---------------+
| Web/Mobile  | <-> | Load Balancer| <-> | API Gateway      | <-> | Auth Service   |
+-------------+     +--------------+     +-----------------+     +---------------+
                                              |
                                              v
                                      +--------------------+
                                      | Booking Service     |
                                      | (Seat & Order Logic)|
                                      +-----+------+--------+
                                            |      |
             +-----------------------------+      +----------------------------+
             |                                                           |
   +-------------------+                               +------------------------+
   | Seat Inventory DB |                               | Orders/Payments Service|
   +-------------------+                               +------------------------+
             |                                                           |
             v                                                           v
   +--------------------------+                               +------------------------+
   | Redis (Seat Lock Cache)  |                               | Payment Gateway Adapter|
   +--------------------------+                               +------------------------+
             |                                                           |
             v                                                           v
   +-------------------------+                               +------------------------+
   | Notification Service    |                               | Coupon Service         |
   +-------------------------+                               +------------------------+
             |                                                           |
             v                                                           v
   +-------------------------+                               +------------------------+
   | Event Management System |                               | Reporting & Analytics   |
   +-------------------------+                               +------------------------+
```

---

### ✅ 3. Component Deep Dive

1. **Web/Mobile Client**: UI for browsing, selecting seats, and confirming bookings. Provides responsive design and input validation.

2. **Load Balancer**: Distributes requests to avoid overload and maximize reliability.

3. **API Gateway**: Routes requests to microservices (Auth, Booking, Orders) and applies rate limiting, logging, and authentication checks.

4. **Auth Service**: Manages user sessions, login (JWT/OAuth), roles (user/admin), and access control.

5. **Booking Service**: Handles core logic for checking seat availability, locking, confirmation, timeout logic for abandoned bookings.

6. **Seat Inventory DB**: Stores per-event/per-venue seating layout and real-time availability, often in a SQL/transactional store.

7. **Redis (Seat Lock Cache)**: Temporary in-memory store that holds locks on seats while user is in payment phase (TTL based).

8. **Order & Payment Service**: Handles booking records, generates invoice, calls payment adapter (Razorpay/Stripe) and manages success/failure states.

9. **Payment Gateway Adapter**: Integrates third-party payment APIs with success/failure callbacks, ensures idempotent handling.

10. **Notification Service**: Sends email/SMS confirmations, booking alerts, or cancellation confirmations.

11. **Event Management System**: Admin interface or service for uploading events, movies, venues, show timings, price tiers, and seat layout.

12. **Coupon Service**: Manages discount codes, eligibility checks, and redemption tracking.

13. **Reporting & Analytics Service**: Generates revenue reports, booking trends, failure rate analysis, and system KPIs for internal stakeholders.

---

### ✅ 4. Database Design (3 Key Entities)

#### Seat Entity:

```json
{
  "seat_id": "A10",
  "screen_id": "screen22",
  "event_id": "event989",
  "status": "available",
  "type": "premium"
}
```

#### Booking Entity:

```json
{
  "booking_id": "bkg1234",
  "user_id": "user5678",
  "event_id": "event989",
  "seats": ["A10", "A11"],
  "status": "confirmed",
  "amount": 560,
  "payment_id": "pay_abc789"
}
```

#### Payment Entity:

```json
{
  "payment_id": "pay_abc789",
  "booking_id": "bkg1234",
  "status": "success",
  "method": "credit_card",
  "timestamp": "2025-07-16T16:30:00Z"
}
```

---

### ✅ 5. Caching Strategy

- Lock seats in Redis with TTL (e.g., 5 mins).
- Cache showtimes, venues, movie listings.
- Use write-through cache for recent bookings.

---

### ✅ 6. API Design

- `GET /events` → list events by city/date
- `GET /events/{id}/seats` → seat layout
- `POST /booking` → book selected seats
- `POST /payment` → confirm payment
- `GET /booking/{id}` → booking summary

---

### ✅ 7. Estimations

- 10M users/day, avg 2 bookings → 20M seat locks/day
- Avg seat record: 100B → \~2GB/day seat lock data
- Booking records: 1KB → 20M KB = \~20GB/day
- Payment callbacks: peak 5K/sec → scale payment handler

---

### ✅ 8. Fault Tolerance

- Retry on payment callback failure
- Dead-letter queue for failed orders
- Redis replication for seat cache
- Dual writes (DB + Kafka) for booking log

---

### ✅ 9. Security

- TLS everywhere + secure tokens
- Rate limit on seat lock & booking APIs
- OTP/email verification for cancellation
- PCI-DSS compliance for card payments

---

### ✅ 10. Monitoring & Alerts

- Alert on booking failure spikes
- Dashboard on seat lock TTL expiries
- Track abandoned cart rate

---

### ✅ 11. Trade-offs

- Locking in Redis vs DB — favors speed over persistence
- Eventual consistency post-payment vs strict seat updates
- Trade UX convenience for consistency in refunds

---

### ✅ 12. Future Enhancements

- Integrate loyalty points / rewards
- Support group bookings & referrals
- Seat recommendation engine based on preferences

---

🔄 Final Words: Designing a real-time, consistent, scalable booking system requires precise concurrency control (e.g., seat locks), fault-tolerant payment pipelines, and a robust retry+monitoring strategy. Redis + SQL + async payment flow enables millions of smooth user experiences daily.

