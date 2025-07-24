**System Design: Elevator System (Multi-Floor, Multi-Elevator Controller)**

---

### 📅 1. Clarify the Requirements

**Functional Requirements:**
1. Support multiple elevators across multiple floors
2. Handle both internal and external elevator requests
3. Optimize elevator allocation to minimize wait time
4. Prioritize requests in the direction of current movement
5. Emergency stop and overload handling
6. Floor indicator and direction displays per elevator
7. Admin panel to monitor and override elevator status

**Non-Functional Requirements:**
1. Sub-second response time for button events
2. High availability for 24x7 usage
3. Fault tolerance and manual override support
4. Modular and pluggable scheduler algorithms
5. Load-balanced control logic in case of multiple shafts
6. Secure firmware communication between controller and hardware
7. Scalable to 100+ elevators in commercial buildings

---

### ✅ 2. High-Level Architecture (11+ Components)

```
+----------------+     +---------------------+     +------------------+     +------------------+
| Floor Panels   | <-> | Elevator Controller | <-> | Elevator Cabin UI| <-> | Cabin Sensors    |
+----------------+     +---------------------+     +------------------+     +------------------+
                                  |                            |
                                  v                            v
                          +------------------+     +----------------------+
                          | Scheduler Service|     | Safety & Emergency   |
                          +------------------+     +----------------------+
                                  |
                          +---------------------+
                          | Status Tracker DB   |
                          +---------------------+
                                  |
                          +--------------------+
                          | Monitoring Service |
                          +--------------------+
                                  |
                          +-----------------+
                          | Admin Dashboard |
                          +-----------------+
```

---

### ✅ 3. Component Deep Dive (Interview Style)

**1. Floor Panels**  
"Floor Panels are user interfaces placed on each floor to register upward or downward requests. Once pressed, the request is sent to the Elevator Controller. The buttons illuminate until the request is served, giving feedback to the user. These panels must be durable, fast, and able to function offline temporarily."

**2. Elevator Controller**  
"This is the brain of the system. It collects input from Floor Panels and Cabin UIs, and forwards them to the Scheduler. It also receives instructions from the Scheduler and forwards commands to Elevator motors and UI panels. It ensures concurrent inputs are handled without collision and is fault-tolerant to avoid critical failures."

**3. Elevator Cabin UI**  
"Inside every elevator, the Cabin UI includes floor selection buttons, open/close door controls, emergency buttons, and floor indicators. These interfaces also communicate with the Elevator Controller to report selections and status."

**4. Cabin Sensors**  
"These include weight sensors (to detect overloads), door sensors, and position encoders. These send real-time data to the Elevator Controller and Emergency Service. For example, if an elevator is overloaded, it won’t move until weight is within limits."

**5. Scheduler Service**  
"This component handles request prioritization. We implement algorithms like SCAN (elevator algorithm), LOOK, or even ML-based demand prediction. It queues requests and allocates them to the optimal elevator — minimizing both wait time and travel distance. We also allow dynamic re-prioritization in real-time."

**6. Safety & Emergency Service**  
"This is isolated from the main Scheduler to ensure real-time overrides during fire alarms, earthquakes, or overload. It can lock elevator movement, override normal scheduling, or return all elevators to ground level automatically. It’s also integrated with fire panel alerts."

**7. Status Tracker DB**  
"A centralized, in-memory DB (like Redis) stores real-time elevator status — current floor, direction, door status, and requests queue. It allows the Scheduler to make quick decisions and Admin panel to query live state. The DB is write-heavy and optimized for frequent updates."

**8. Monitoring Service**  
"It logs elevator state changes, service durations, request fulfillment latency, and sensor warnings. Built-in alerting notifies maintenance if anomalies or slowdowns occur."

**9. Admin Dashboard**  
"A real-time UI for maintenance and control room staff to monitor elevator operations. Supports forceful overrides, disabling elevators, running diagnostics, and exporting daily usage reports. It also shows health summaries of elevators and pending requests."

**10. Logs DB**  
"Stores all past elevator rides, button presses, emergency triggers, and overrides. Useful for audits, debugging issues, and safety compliance. It’s append-only and supports indexing by elevator ID and time."

**11. Elevator Hardware Interface**  
"Translates logical commands from the controller into hardware actions — motor control, door operations, and panel signals. We use PLCs (Programmable Logic Controllers) or microcontrollers here with real-time communication and fallback mechanisms."

---

### ✅ 4. Core Entities (Sample JSON)

**Elevator State**
```json
{
  "elevator_id": "E3",
  "current_floor": 7,
  "direction": "up",
  "requests": [9, 10, 11],
  "load_percentage": 60,
  "status": "moving"
}
```

**Floor Request**
```json
{
  "floor": 4,
  "direction": "down",
  "timestamp": "2025-07-16T10:42:00Z"
}
```

**Emergency Alert**
```json
{
  "elevator_id": "E1",
  "event": "overload",
  "weight": 620,
  "threshold": 600,
  "triggered_at": "2025-07-16T10:45:23Z"
}
```

---

### ✅ 5. Estimations
- 10 elevators per building × 50 buildings = 500 elevators
- Avg. 3 requests/min/elevator → 1,500 events/min = 25 events/sec
- Redis/Cache can handle 50,000+ ops/sec easily
- Logs DB: ~2 KB per ride → 2M rides/day → ~4GB/day → 1.5TB/year

---

### ✅ 6. Fault Tolerance
- Fallback logic on controller: cached schedule during Redis failure
- Manual override for elevators via hardware panel
- Retry queues for sensor readings
- Backup emergency power and fire-safe idle states

---

### ✅ 7. Security
- Signed firmware updates for hardware
- Role-based access for dashboard
- Encrypted messaging over MQTT for controller–sensor communication

---

### ✅ 8. Monitoring
- Track each elevator’s uptime, request queue size, error frequency
- Trigger alerts if stuck floors >30 sec, excessive door open time, etc.

---

### ✅ 9. Trade-offs
- We chose in-memory DB (Redis) over SQL for real-time updates
- Hardware control loops are kept separate from scheduling for safety
- Trade-off between global optimal vs. local fastest scheduler

---

### ✅ 10. Future Enhancements
- AI-based adaptive scheduling during peak times
- Mobile app to summon elevator in advance
- Predictive maintenance using sensor history

---

🧠 Final Note: This system separates core real-time logic from UI and monitoring components to allow safe, predictable scheduling and maximum uptime.

