# 📘 Kadane's Algorithm

---

## ✅ 0. Question

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

### Example:

Input: `nums = [-2,1,-3,4,-1,2,1,-5,4]`  
Output: `6`  
Explanation: [4,-1,2,1] has the largest sum = 6.

---

## ✅ 1. Definition and Purpose

- Kadane’s Algorithm is used to find the **maximum sum of a contiguous subarray** in linear time.
- It solves the **Maximum Subarray Problem**.
- Helps detect periods of maximum gain or profit in stock data, temperatures, etc.

---

## ✅ 2. Syntax and Structure

### Pseudocode:
```java
int maxSum = nums[0];
int currSum = nums[0];

for (int i = 1; i < nums.length; i++) {
    currSum = Math.max(nums[i], currSum + nums[i]);
    maxSum = Math.max(maxSum, currSum);
}
return maxSum;
```

---

## ✅ 3. Practical Examples

### 🔹 Java Code (Kadane's Algorithm)
```java
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];      // Step 1: Initialize maxSum with first element
        int currSum = nums[0];     // Step 2: Initialize current running sum

        for (int i = 1; i < nums.length; i++) {
            // Step 3: Choose max between current number or current sum + number
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Step 4: Update maxSum if currSum is greater
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
```

### Example Trace:
For `nums = [-2,1,-3,4,-1,2,1,-5,4]`
```
i | nums[i] | currSum         | maxSum
--|---------|------------------|--------
1 | 1       | max(1, -2+1)=1   | 1
2 | -3      | max(-3, 1+-3)=-2 | 1
3 | 4       | max(4, -2+4)=4   | 4
4 | -1      | max(-1, 4+-1)=3  | 4
5 | 2       | max(2, 3+2)=5    | 5
6 | 1       | max(1, 5+1)=6    | 6
```

---

## ✅ 4. Internal Working

- Works in O(n) time using a **greedy approach**.
- Keeps track of maximum subarray ending at each index.
- No extra space is needed; uses constant space.

---

## ✅ 5. Best Practices

- Always initialize with the first element to handle all negative inputs.
- Use `Math.max()` to prevent resetting from wrong negative sums.

---

## ✅ 6. Related Concepts

- Dynamic Programming
- Divide and Conquer (used in alternative O(n log n) solution)
- Sliding Window (variation)

---

## ✅ 7. Interview & Real-world Use

- Asked frequently at FAANG interviews.
- Real-world uses: Max profit, anomaly detection, signal processing, etc.

---

## ✅ 8. Common Errors & Debugging

- Incorrectly initializing `maxSum` or `currSum` with 0 can fail on negative-only arrays.
- Forgetting to reset `currSum` properly.

---

## ✅ 9. Java Version Updates

- No version-specific changes; works with all versions.

---

## ✅ 10. Practice and Application

- LeetCode 53: Maximum Subarray
- LeetCode 918: Maximum Sum Circular Subarray
- LeetCode 487: Max Consecutive Ones II

---

✅ Mastering Kadane’s Algorithm helps in optimizing sum problems under time constraints and is a fundamental building block for more advanced problems!

