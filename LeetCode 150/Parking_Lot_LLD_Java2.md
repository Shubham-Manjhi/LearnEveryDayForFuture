# 🅻🅻🅳: Design a Parking Lot System (Java Version)

---

## ✅ Step 1: Clarify Requirements

### ❓ Functional Requirements:
- A vehicle can enter and exit the parking lot.
- System should assign nearest available slot based on vehicle type.
- Multiple floors with multiple parking slots per floor.
- Support different vehicle types: Bike, Car, Truck.
- Payment calculation based on time spent.
- Display available slots for each vehicle type.

### ❗ Non-Functional Requirements:
- Scalable for large multi-level parking lots.
- Concurrent vehicle entry/exit handling.
- Real-time slot availability tracking.

### 🤝 Assumptions:
- Vehicles are uniquely identified by license plate.
- Entry and exit are managed by a gate system.
- Payment is done at the exit gate.
- System records entry and exit timestamps.

---

## ✅ Step 2: Identify Core Components

| Component        | Responsibility                                               |
|------------------|--------------------------------------------------------------|
| `ParkingLot`     | Main controller that manages floors and slots                |
| `ParkingFloor`   | Contains multiple slots and manages availability             |
| `ParkingSlot`    | Represents an individual slot                                |
| `Vehicle`        | Represents vehicles with type and number                     |
| `Ticket`         | Issued at entry, contains vehicle info and timestamps        |
| `Gate`           | Entry/Exit gate that generates and closes tickets            |
| `Payment`        | Handles billing and payment logic                            |
| `DisplayBoard`   | Shows real-time availability                                 |

---

## ✅ Step 3: Design the Interactions

### Entry Flow

Vehicle -> EntryGate : enter()

EntryGate -> ParkingLot : assignSlot(vehicle)

ParkingLot -> ParkingFloor : findAvailableSlot(vehicleType)

ParkingFloor -> ParkingSlot : markOccupied()

ParkingLot -> TicketSystem : generateTicket(vehicle, slot)

TicketSystem -> Vehicle : provideTicket()

### Exit Flow

Vehicle -> ExitGate : exit(ticket)

ExitGate -> TicketSystem : calculateFee(ticket)

ExitGate -> PaymentSystem : pay(fee)

ExitGate -> ParkingSlot : markAvailable()

---

## ✅ Step 4: Define Classes and Methods (Java)

### 🔧 `Vehicle`
```java
public class Vehicle {
    private String licensePlate;
    private VehicleType type;

    // Constructor, getters, setters
}

🔧 ParkingSlot

public class ParkingSlot {
    private String slotId;
    private VehicleType type;
    private boolean isOccupied;

    public void assignVehicle(Vehicle vehicle) {
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.isOccupied = false;
    }
}

🔧 ParkingFloor

public class ParkingFloor {
    private String floorId;
    private List<ParkingSlot> slots;

    public ParkingSlot findAvailableSlot(VehicleType type) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.getType() == type) {
                return slot;
            }
        }
        return null;
    }
}

🔧 ParkingLot

public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingSlot assignSlot(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle.getType());
            if (slot != null) {
                slot.assignVehicle(vehicle);
                return slot;
            }
        }
        return null;
    }

    public void releaseSlot(Ticket ticket) {
        ticket.getSlot().removeVehicle();
    }
}

🔧 Ticket

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSlot slot;

    // Constructor, getters, setters
}

🔧 PaymentService

public class PaymentService {
    public double calculateFee(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        return duration.toHours() * 20.0; // Assume $20/hour
    }

    public boolean processPayment(Ticket ticket, double amount) {
        // Process logic here
        return true;
    }
}


⸻

✅ Step 5: Consider Edge Cases

⚠️ Edge Cases and Handling
	•	All Slots Full → Display “No Slot Available”.
	•	Wrong Exit Ticket → Validate ticket ID before processing.
	•	Lost Ticket → Charge maximum penalty.
	•	System Failure → Maintain local logs or backups.
	•	Vehicle Type Mismatch → Prevent assigning smaller slot to larger vehicle.

🔁 Trade-offs

Choice	Pros	Cons
Pre-assigned slots	Fast entry	Less efficient space
Centralized vs Distributed logic	Easier to manage	Single point failure
Flat fee vs Time-based billing	Easy to implement	May overcharge users


⸻

✅ Step 6: Review and Refine

✅ Final Design Checklist:
	•	Multiple floors and vehicle types.
	•	Slot assignment and release.
	•	Ticketing and payment process.
	•	Java-based design for structure and behavior.
	•	Edge cases discussed and covered.

⸻

📘 Optional: Class Diagram (ASCII UML Style)

+----------------+        +-----------------+
|  ParkingLot    |<>------| ParkingFloor    |
+----------------+        +-----------------+
| List<floor>    |        | List<slot>      |
+----------------+        +-----------------+

+----------------+        +---------------+
| ParkingSlot    |<>------| Vehicle       |
+----------------+        +---------------+
| isOccupied     |        | licensePlate  |
| slotId         |        | type          |
+----------------+        +---------------+

+----------------+
| Ticket         |
+----------------+
| ticketId       |
| entryTime      |
| ParkingSlot    |
| Vehicle        |
+----------------+

+----------------+
| PaymentService |
+----------------+
| calculateFee() |
| processPayment() |
+----------------+


⸻

🚀 What’s Next?

You can further enhance this design by:
	•	✅ Adding concurrency handling using synchronized, ReentrantLock, or ConcurrentHashMap.
	•	✅ Extending the model to support REST APIs (e.g., Spring Boot Controllers for entry/exit).
	•	✅ Converting this LLD into a PlantUML diagram or exporting it as a polished PDF.

Let me know if you want to implement any of these — I’m ready to help!

---

Would you like the **REST API structure** added next (with sample endpoints and controller classes)?