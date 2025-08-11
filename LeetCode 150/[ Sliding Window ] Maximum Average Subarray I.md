# 📘 LeetCode 643: Maximum Average Subarray I

---

## ✅ 0. Question

Given an integer array `nums` consisting of `n` elements and an integer `k`, find a contiguous subarray of length `k` that has the maximum average value and return this value. Any answer with a calculation error less than `10^-5` will be accepted.

### Example:
```text
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12 + -5 + -6 + 50) / 4 = 51 / 4 = 12.75
```

---

## ✅ 1. Definition and Purpose

This problem falls under the Sliding Window category. It teaches you how to maintain a rolling sum and adjust it efficiently to solve array-based optimization problems in linear time.

---

## ✅ 2. Syntax and Structure

```java
public double findMaxAverage(int[] nums, int k);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Sliding Window (Optimized)
```java
// ✅ Time Complexity: O(n), Space: O(1)
public double findMaxAverage(int[] nums, int k) {
    // Step 1: Initialize the sum of the first window
    double sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }

    // Step 2: Use a sliding window to track max sum of k-length subarray
    double maxSum = sum;
    for (int i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k]; // Slide the window forward
        maxSum = Math.max(maxSum, sum); // Track the max sum
    }

    return maxSum / k; // Step 3: Compute the average
}
```

### ASCII Visualization:
```
nums = [1,12,-5,-6,50,3], k = 4
Window 1: 1,12,-5,-6 => sum = 2
Window 2: 12,-5,-6,50 => sum = 51 (max)
Window 3: -5,-6,50,3 => sum = 42
```

---

### 🔹 Approach 2: Brute Force
```java
// ✅ Time Complexity: O(n*k), Space: O(1)
public double findMaxAverageBruteForce(int[] nums, int k) {
    double max = Double.NEGATIVE_INFINITY;

    // Try all possible windows of length k
    for (int i = 0; i <= nums.length - k; i++) {
        double sum = 0;
        for (int j = i; j < i + k; j++) {
            sum += nums[j]; // Compute the sum of this window
        }
        max = Math.max(max, sum); // Update maximum sum found
    }

    return max / k;
}
```

---

## ✅ 4. Internal Working

- In the optimized approach, the sum of each k-length window is computed by sliding the window: subtracting the leftmost element and adding the next rightmost element.
- Avoids re-computing the sum from scratch.

---

## ✅ 5. Best Practices

- Always use sliding window for fixed-size subarray problems.
- Check for edge conditions when nums.length < k.

---

## ✅ 6. Related Concepts

- Sliding Window
- Array Prefix Sum
- Two Pointers

---

## ✅ 7. Interview & Real-world Use

- Used in stream processing or live metrics (e.g., CPU usage average)
- Common in financial or sensor data analysis

---

## ✅ 8. Common Errors & Debugging

- Forgetting to cast to double when dividing
- Off-by-one errors in index calculation
- Not initializing sum correctly

---

## ✅ 9. Java Version Updates

- Java 8: `Stream` API for averaging arrays (less efficient here)
- Java 14+: Enhanced pattern matching (not useful here)

---

## ✅ 10. Practice and Application

- LeetCode 239: Sliding Window Maximum
- LeetCode 480: Sliding Window Median
- LeetCode 1456: Maximum Number of Vowels in a Substring of Given Length

---

🎯 Sliding Window is a crucial tool for time-sensitive data aggregation. This problem solidifies your understanding of window maintenance and optimization.

