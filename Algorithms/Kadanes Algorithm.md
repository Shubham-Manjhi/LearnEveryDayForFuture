**Java Topic: Kadane's Algorithm – Maximum Subarray Sum**

---

✅ 1. Definition and Purpose

• What is the concept?\
Kadane’s Algorithm finds the contiguous subarray within a 1D array of numbers that has the largest sum.

• Why does it exist in Java?\
It exemplifies dynamic programming through a linear pass and optimizes brute-force subarray checks.

• What problem does it solve?\
Efficiently solves the maximum sum subarray problem in O(n) time.

🧠 Example: Input: [-2,1,-3,4,-1,2,1,-5,4] → Output: 6 (subarray: [4,-1,2,1])

---

✅ 2. Syntax and Structure

• Define `int maxSubArray(int[] nums)`\
• Maintain a running max ending at current position and update global max

---

✅ 3. Practical Examples

🔹 Approach 1: Standard Kadane’s Algorithm

```java
public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
```

🔹 Approach 2: Kadane with Subarray Indices (Optional for traceability)

```java
public class KadaneWithIndices {
    public int[] maxSubArrayWithIndices(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        return new int[] {maxSum, start, end};
    }
}
```

🖼️ ASCII Diagram – Kadane Visualization:
```
Array:     -2  1 -3  4 -1  2  1 -5  4
Running:    ↓     ↓     ↓     ↓
CurrSum:   -2 → 1 → -2 → 4 → 3 → 5 → 6 → 1 → 5
MaxSum:    -2 → 1 → 1 → 4 → 4 → 5 → 6 → 6 → 6
Best Subarray: [4, -1, 2, 1]
```

---

✅ 4. Internal Working

• Iterates through the array updating `currentSum` and `maxSum`\
• Chooses between starting new subarray vs. extending existing\
• Uses Math.max to select better option at each step

Time Complexity: O(n)

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Initialize `currentSum` and `maxSum` with first element\
✔ Do not reset to 0 unless problem explicitly allows\
✔ Track indices only when needed

---

✅ 6. Related Concepts

- Dynamic Programming\
- Greedy Algorithms\
- Prefix Sums\
- Sliding Window (for fixed-size variant)

🧠 Example: Used in financial data trend analysis, real-time sensor values

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Classic algorithm question, especially with negative numbers

🏢 Real-world:
- Max profit/loss segments\
- CPU usage peaks\
- Analytics over continuous data feeds

---

✅ 8. Common Errors & Debugging

❌ Starting `currentSum` at 0 when array may contain negatives\
❌ Forgetting to track subarray bounds if needed\
❌ Using incorrect comparison between `nums[i]` and `currentSum`

🧪 Debug Tip:
- Log `currentSum` and `maxSum` at every iteration

---

✅ 9. Java Version Updates

• Java 8+: Streams for summary statistics (though not in-place)\
• Java 14+: Switch expressions to clean conditional logic

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #53\
- Any DP pattern challenges

🏗 Apply in:
- Real-time analytics (like stock fluctuations)\
- Continuous error signal detection\
- Game scoring streaks and patterns

