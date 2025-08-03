# 📘 LeetCode 918: Maximum Sum Circular Subarray

---

## ✅ 0. Question

Given a circular integer array `nums`, return the maximum possible sum of a non-empty subarray of `nums`.

A circular array means the end of the array connects to the beginning. A subarray may only include each element of the array at most once. Formally, the next element of `nums[i]` is `nums[(i + 1) % nums.length]`.

### Example:
```text
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum = 3

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] (circular) has maximum sum = 10

Input: nums = [-3,-2,-3]
Output: -2
```

---

## ✅ 1. Definition and Purpose

This problem is a variation of the classic Kadane's Algorithm. The twist is handling the circular case to find the maximum subarray sum that may wrap around the end of the array.

---

## ✅ 2. Syntax and Structure

```java
public int maxSubarraySumCircular(int[] nums);
```

---

## ✅ 3. Practical Examples

### Approach 1: Standard Kadane + Circular Case
```java
public int maxSubarraySumCircular(int[] nums) {
    int total = 0;
    int maxSum = nums[0];
    int curMax = 0;
    int minSum = nums[0];
    int curMin = 0;

    for (int n : nums) {
        total += n;

        // Step 1: Kadane's for max subarray sum
        curMax = Math.max(curMax + n, n);
        maxSum = Math.max(maxSum, curMax);

        // Step 2: Kadane's for min subarray sum
        curMin = Math.min(curMin + n, n);
        minSum = Math.min(minSum, curMin);
    }

    // Step 3: If all elements are negative, return maxSum (normal Kadane)
    if (maxSum < 0) return maxSum;

    // Step 4: Otherwise, return max of (maxSum, total - minSum)
    return Math.max(maxSum, total - minSum);
}
```

### ASCII Illustration:
```
Example: nums = [5, -3, 5]
- maxSubarraySum (non-circular) = 7 ([5])
- total = 7
- minSubarraySum = -3
- total - minSum = 10 (circular [5, 5])
Answer: max(7, 10) = 10
```

### Approach 2: Brute Force (Time Limit Exceeded for large input)
```java
public int maxSubarraySumCircular(int[] nums) {
    int n = nums.length;
    int maxSum = nums[0];

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[(i + j) % n];
            maxSum = Math.max(maxSum, sum);
        }
    }

    return maxSum;
}
```

---

## ✅ 4. Internal Working

- Kadane’s Algorithm finds max/min subarray in linear time.
- Wrapping sum = total - minSubarraySum
- If all numbers are negative, `total - minSum` would be 0, hence return regular maxSum.

---

## ✅ 5. Best Practices

- Check edge case: all elements negative
- Do not use brute force unless input is very small

---

## ✅ 6. Related Concepts

- Kadane's Algorithm
- Prefix sums
- Circular buffers

---

## ✅ 7. Interview & Real-world Use

- Used in circular scheduling
- Real-time monitoring windows
- Resource allocation in circular queues

---

## ✅ 8. Common Errors & Debugging

- Missing check for all-negative arrays
- Forgetting that circular max = total - minSubarray
- Incorrect initialization of maxSum/minSum (should start with nums[0])

---

## ✅ 9. Java Version Updates

- Java 8+ Stream API can simplify max/min tracking but for loop remains best for performance

---

## ✅ 10. Practice and Application

- LeetCode 53: Maximum Subarray
- LeetCode 918: Advanced variant of Kadane
- LeetCode 238: Product of Array Except Self (prefix/suffix tricks)

---

🚀 Mastering circular subarray sum teaches how to convert complex ranges into a linear solution using mathematical transformations.

