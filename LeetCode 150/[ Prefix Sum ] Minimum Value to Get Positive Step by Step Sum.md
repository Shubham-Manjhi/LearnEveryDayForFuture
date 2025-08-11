# 📘 LeetCode 1413: Minimum Value to Get Positive Step by Step Sum

---

## ✅ 0. Question

Given an array of integers `nums`, return the **minimum positive value** `startValue` such that the **step by step sum** of `startValue + sum of elements from left to right` is **never less than 1**.

### Example:
```java
Input: nums = [-3, 2, -3, 4, 2]
Output: 5
Explanation:
- Starting with 5:
  step 1: 5 - 3 = 2
  step 2: 2 + 2 = 4
  step 3: 4 - 3 = 1
  step 4: 1 + 4 = 5
  step 5: 5 + 2 = 7 (Never below 1)
```

---

## ✅ 1. Definition and Purpose

This problem focuses on prefix sum tracking and finding the minimum cumulative value needed to avoid a negative sum. It helps understand bounds on accumulation problems.

---

## ✅ 2. Syntax and Structure

- Use a running `prefixSum` and track the **minimum** value it ever reaches.
- Java basics: `for` loop, `Math.min()`, integer addition.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Prefix Sum Tracking

```java
public class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE; // Step 1: Track the minimum prefix sum

        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum); // Step 2: Update minimum
        }

        return minSum >= 1 ? 1 : 1 - minSum; // Step 3: Adjust start value
    }
}
```

### 🔹 Approach 2: Brute Force (Just for Comparison)

```java
public class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        while (true) {
            int sum = startValue;
            boolean valid = true;
            for (int num : nums) {
                sum += num;
                if (sum < 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) return startValue;
            startValue++;
        }
    }
}
```

---

## 📘 ASCII Diagram:

```
nums = [-3, 2, -3, 4, 2]
Prefix sum:  -3 -> -1 -> -4 -> 0 -> 2
Min sum = -4 => startValue = 1 - (-4) = 5
```

---

## ✅ 4. Internal Working

- Accumulate sum left to right
- Track minimum value reached
- Adjust `startValue` such that minimum + `startValue` >= 1

---

## ✅ 5. Best Practices

- Prefer prefix sum technique over brute force
- Use meaningful variable names: `sum`, `minPrefix`, etc.

---

## ✅ 6. Related Concepts

- Prefix Sum
- Cumulative sum bounds
- Simulation problems

---

## ✅ 7. Interview & Real-world Use

- Budget balancing
- Ensuring safety thresholds in simulations and accounting

---

## ✅ 8. Common Errors & Debugging

- Forgetting to compare prefix sum correctly
- Not resetting sum in brute force loop

---

## ✅ 9. Java Version Updates

- Java Streams can compute prefix sums using reduce

---

## ✅ 10. Practice and Application

- LeetCode 724: Pivot Index
- LeetCode 1991: Middle Index in Array

---

## 📊 Time and Space Complexity

| Approach     | Time Complexity | Space Complexity |
|--------------|------------------|------------------|
| Brute Force  | O(n * K)         | O(1)             |
| Prefix Sum   | O(n)             | O(1)             |

