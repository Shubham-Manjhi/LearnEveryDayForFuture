**Java Problem: Parking Fee Calculation**

---

✅ 0. Question & Explanation

You parked your car in a parking lot. The billing rules are:

- Entrance fee: 2
- First hour (or part of it): 3
- Each subsequent hour (or part of it): 4

Input: Two strings E and L in the format "HH\:MM" representing entry and exit time on the same day.

Return the total cost of the parking.

🧠 Example:

- Input: E = "10:00", L = "13:21"
- Output: 17
  - Time diff = 3 hours 21 mins → 4 hours (rounded up)
  - Cost: 2 (entrance) + 3 (first hr) + 3×4 = 17

---

✅ 1. Definition and Purpose

• What is the concept?\
Calculate total time spent and use rules to compute cost.

• Why does it exist in Java?\
Useful for billing systems, scheduling, rentals, etc.

• What problem does it solve?\
Automates calculation of charges based on time difference.

---

✅ 2. Syntax and Structure

• Use java.time or manual parsing for "HH\:MM" • Compute duration in minutes • Convert to hours, apply rounding logic

Method signature:

```java
public int solution(String E, String L)
```

---

✅ 3. Practical Examples

🔹 Using manual string parsing:

```java
public class Solution {
    public int solution(String E, String L) {
        String[] eParts = E.split(":"), lParts = L.split(":");
        int eHour = Integer.parseInt(eParts[0]), eMin = Integer.parseInt(eParts[1]);
        int lHour = Integer.parseInt(lParts[0]), lMin = Integer.parseInt(lParts[1]);

        int start = eHour * 60 + eMin;
        int end = lHour * 60 + lMin;
        int duration = end - start;

        int hours = duration / 60;
        if (duration % 60 != 0) hours++;

        if (hours == 0) hours = 1; // minimum 1 hour billing

        return 2 + 3 + (hours - 1) * 4;
    }
}
```

📌 Example:

```
Input: E = "09:42", L = "11:42" → duration = 120 mins = 2 hrs
Cost = 2 + 3 + 4 = 9
```

---

✅ 4. Internal Working

• Converts HH\:MM → total minutes\
• Calculates rounded-up duration\
• Applies tiered cost logic

Uses only primitive arithmetic and String methods — no library overhead.

---

✅ 5. Best Practices

✔ Avoid floating-point operations for time\
✔ Use integer arithmetic for minutes and hours\
✔ Split input cleanly and validate format if necessary

---

✅ 6. Related Concepts

- Time arithmetic (mod, division)
- Billing logic
- Rounding up durations

🧠 Related in Java:

- LocalTime and Duration (java.time)
- String.split(), Integer.parseInt()

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Tests ability to parse and compute time
- Good exercise for string manipulation and control flow

🏢 Real-world:

- Car parking systems\

- Hotel booking duration pricing\

- Event ticketing systems

---

✅ 8. Common Errors & Debugging

❌ Not rounding up for partial hours\
❌ Not handling exact zero durations\
❌ Using floating points unnecessarily

🧪 Debug Tip:

- Print total minutes and derived hours to verify correctness

---

✅ 9. Java Version Updates

• Java 8+ provides java.time.LocalTime and Duration\
• Prior to Java 8, manual parsing was the norm

Optional alternative:

```java
LocalTime entry = LocalTime.parse(E);
LocalTime exit = LocalTime.parse(L);
long minutes = Duration.between(entry, exit).toMinutes();
```

---

✅ 10. Practice and Application

📝 Practice on:

- HackerRank (parking problems)
- Codility assessments
- Internal microservice billing simulators

🏗 Apply in:

- Smart parking apps
- Billing modules for rentals
- Service-based billing systems

---

