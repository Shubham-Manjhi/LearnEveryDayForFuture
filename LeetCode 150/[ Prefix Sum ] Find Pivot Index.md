# 📘 LeetCode 724: Find Pivot Index

---

## ✅ 0. Question

Given an array of integers `nums`, return the **pivot index** of this array.

The **pivot index** is the index where the sum of all the numbers **strictly to the left** of the index is equal to the sum of all the numbers **strictly to the right** of the index.

If the index is on the edge of the array, the left or right sum will be 0.

If no such index exists, return -1.

### Example:
```java
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
  - left sum = 1 + 7 + 3 = 11
  - right sum = 5 + 6 = 11
```

---

## ✅ 1. Definition and Purpose

This problem tests prefix sum and iteration. A pivot index balances the left and right cumulative sum.

---

## ✅ 2. Syntax and Structure

- You need to calculate leftSum and rightSum efficiently.
- Java basics: `for` loop, `if` conditions, integer math.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force

```java
public class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) leftSum += nums[j];
            for (int j = i + 1; j < nums.length; j++) rightSum += nums[j];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
```

### 🔹 Approach 2: Optimized Prefix Sum (Single pass)

```java
public class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num; // Step 1: Calculate total sum

        int leftSum = 0; // Step 2: Iterate and check for pivot
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
```

---

## 📘 ASCII Diagram:

```
Index : 0   1   2   3   4   5
Nums  : 1   7   3   6   5   6
LeftS :     1   8  11 17 22
RightS: 27 20 17 11  6  0
Pivot :             ^
```

---

## ✅ 4. Internal Working

- The optimized version uses prefix sum from left
- Right sum = total - leftSum - current element

---

## ✅ 5. Best Practices

- Avoid recomputation by using prefix sum
- Keep variables clean: track `leftSum` and use `totalSum`

---

## ✅ 6. Related Concepts

- Prefix Sum Arrays
- Difference Array
- Equilibrium Index (in interviews)

---

## ✅ 7. Interview & Real-world Use

- Used in balancing load between servers
- Analyzing balance point in financial data or sequences

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors in index range
- Misunderstanding "strictly left" and "strictly right"

---

## ✅ 9. Java Version Updates

- Java Streams can compute total sum: `Arrays.stream(nums).sum()`

---

## ✅ 10. Practice and Application

- LeetCode 1991: Find the Middle Index in Array
- Useful in dynamic programming and partition-based problems

---

## 📊 Time and Space Complexity

| Approach       | Time Complexity | Space Complexity |
|----------------|------------------|------------------|
| Brute Force    | O(n^2)           | O(1)             |
| Optimized      | O(n)             | O(1)             |

Let me know if you'd like a PDF version or a visual diagram for this!

