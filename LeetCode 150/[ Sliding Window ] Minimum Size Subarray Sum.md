# 🚀 LeetCode 209: Minimum Size Subarray Sum

---

## ✅ 0. Question

Given an array of positive integers `nums` and an integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return 0 instead.

### Example:
```text
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

---

## ✅ 1. Definition and Purpose

This problem is a classic example of using the sliding window technique to find optimal subarray ranges in linear time. The goal is to improve performance beyond brute force.

---

## ✅ 2. Syntax and Structure

```java
public int minSubArrayLen(int target, int[] nums);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Sliding Window (Optimized)
```java
// ✅ Time: O(n), Space: O(1)
public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right]; // Expand window by moving right

        // Shrink window from the left as long as sum >= target
        while (sum >= target) {
            minLength = Math.min(minLength, right - left + 1);
            sum -= nums[left++];
        }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

### 🔹 Approach 2: Brute Force (for understanding)
```java
// ✅ Time: O(n^2), Space: O(1)
public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                break;
            }
        }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

### ASCII Illustration:
```
Input: [2,3,1,2,4,3], target = 7
Window moves:
[2,3,1,2] => sum = 8 ➝ shrink
[3,1,2]   => sum = 6
[1,2,4]   => sum = 7 => valid (length = 3)
[4,3]     => sum = 7 => valid (length = 2 ✅)
```

---

## ✅ 4. Internal Working

- The sliding window expands the right boundary to add elements
- Once the sum crosses the target, it shrinks the window from the left to minimize the length
- Greedy logic ensures smallest qualifying window is tracked

---

## ✅ 5. Best Practices

- Always check edge cases (empty array or very high target)
- Reset sum correctly when shrinking
- Compare and update minimum only when condition is met

---

## ✅ 6. Related Concepts

- Sliding Window
- Two Pointers
- Subarray Sum Problems

---

## ✅ 7. Interview & Real-world Use

- Performance tracking within time windows
- Rate limiting systems and buffer overflow analysis
- Data streaming windows

---

## ✅ 8. Common Errors & Debugging

- Forgetting to update left pointer in while loop
- Not checking if minLength was ever updated
- Mixing up left and right window pointers

---

## ✅ 9. Java Version Updates

- Java 8+: Stream API can summarize subarrays, but is slower than sliding window

---

## ✅ 10. Practice and Application

- LeetCode 3: Longest Substring Without Repeating Characters
- LeetCode 76: Minimum Window Substring
- LeetCode 1004: Max Consecutive Ones III

---

🔥 Mastering sliding window problems is essential for efficient array processing in real-time or streaming data scenarios.

