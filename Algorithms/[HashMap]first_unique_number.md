**Java Problem: First Unique Number in an Array**

---

✅ 0. Question & Explanation

You are given a non-empty array A of N integers. A unique number occurs exactly once.

Your task is to return the first unique number — the one with the lowest index among all unique numbers. If there are no unique numbers, return -1.

🧠 Example:
- Input: [1, 4, 3, 3, 1, 2] → Output: 4 (4 is the first number that appears only once)
- Input: [6, 4, 4, 6] → Output: -1 (no unique numbers)
- Input: [4, 10, 5, 4, 2, 10] → Output: 5 (5 is the first unique)

Constraints:
- N in [1..100,000]
- A[i] in [0..1,000,000,000]

---

✅ 1. Definition and Purpose

• What is the concept?\
Find the first element in an array that occurs only once.

• Why does it exist in Java?\
Important for problems involving frequency analysis and stream processing.

• What problem does it solve?\
Helps in tasks such as filtering noise, de-duplication, or priority selection.

---

✅ 2. Syntax and Structure

Use a HashMap<Integer, Integer> to store frequency of each number.
Then iterate the array to find the first element with frequency == 1.

Method signature:
```java
public int solution(int[] A)
```

---

✅ 3. Practical Examples

🔹 Java Code:

```java
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences
        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find first unique
        for (int num : A) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
}
```

📌 Example Walkthrough:
- A = [1, 4, 3, 3, 1, 2]
- countMap = {1:2, 4:1, 3:2, 2:1}
- Iterate → first unique = 4

---

✅ 4. Internal Working

• Uses HashMap to store frequency count — O(N) time and O(N) space\
• Sequential second pass to preserve order\
• Efficient for large input sizes

Time Complexity: O(N)

Space Complexity: O(N)

---

✅ 5. Best Practices

✔ Use getOrDefault for safe counting\
✔ Avoid sorting — it adds O(N log N) unnecessarily\
✔ Check edge cases: all repeating, one element, etc.

---

✅ 6. Related Concepts

- HashMap
- Frequency Counting
- Set/Map iteration

🧠 Example: First Non-Repeating Character in a String uses same idea

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Common in stream and frequency questions\
- Detecting anomalies or patterns

🏢 Real-world:
- Log analysis\
- User analytics (first-time action detection)

---

✅ 8. Common Errors & Debugging

❌ Modifying the map while iterating\
❌ Using only Set instead of Map (can't count frequency)

🧪 Debug Tip:
- Print countMap before second loop to inspect frequencies

---

✅ 9. Java Version Updates

• Java 8+: Supports getOrDefault()\
• Java 10+: Use var for local inference

Optional:
```java
Map<Integer, Long> freq = Arrays.stream(A)
    .boxed()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode: First Unique Character
- Codility: First Unique Element
- HackerRank: HashMap Frequency

🏗 Apply in:
- Streaming data processing
- Input deduplication
- Log or telemetry filtering

---

