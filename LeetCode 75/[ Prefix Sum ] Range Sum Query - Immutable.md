# 📘 LeetCode 303: Range Sum Query - Immutable

---

## ✅ 0. Question

Given an integer array `nums`, handle multiple queries of the following type:

- Calculate the sum of the elements of `nums` between indices `left` and `right` inclusive, where `left <= right`.

Implement the `NumArray` class:

```java
NumArray(int[] nums) initializes the object with the integer array nums.
int sumRange(int left, int right) returns the sum of the elements of nums between indices left and right inclusive.
```

### Example:
```java
Input:
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]

Output:
[null, 1, -1, -3]
```

---

## ✅ 1. Definition and Purpose

- This problem focuses on optimizing range sum queries using prefix sum technique.
- Purpose is to avoid recalculating sums repeatedly by preprocessing cumulative sums.

---

## ✅ 2. Syntax and Structure

```java
class NumArray {
    public NumArray(int[] nums) { }
    public int sumRange(int left, int right) { }
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force (O(n) per query)

```java
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
```

### 🔹 Approach 2: Prefix Sum (Optimized O(1) per query)

```java
class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        // Step 1: Create prefix array with one extra element
        prefix = new int[nums.length + 1];

        // Step 2: Fill prefix[i] with cumulative sum up to nums[i-1]
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // Step 3: Get sum using prefix array
        return prefix[right + 1] - prefix[left];
    }
}
```

### Step-by-Step Walkthrough
```
nums = [-2, 0, 3, -5, 2, -1]
prefix = [0, -2, -2, 1, -4, -2, -3]

sumRange(0, 2) = prefix[3] - prefix[0] = 1 - 0 = 1
sumRange(2, 5) = prefix[6] - prefix[2] = -3 - (-2) = -1
```

---

## ✅ 4. Internal Working

- Prefix sum array allows sum from i to j to be calculated in constant time.
- Reduces time complexity from O(n) per query to O(1).

---

## ✅ 5. Best Practices

- Use prefix sum for immutable arrays
- Initialize prefix array during construction to save computation later

---

## ✅ 6. Related Concepts

- Prefix Sum
- Range Queries
- Immutable Arrays

---

## ✅ 7. Interview & Real-world Use

- Useful in game scoring systems, data analytics, database optimizations
- Common in competitive programming and data structure design

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors while calculating prefix indexes
- Forgetting that prefix[i] includes sum up to index i-1

---

## ✅ 9. Java Version Updates

- Java 8+ supports `IntStream.range()` for functional prefix construction

---

## ✅ 10. Practice and Application

- LeetCode 304: Range Sum Query 2D - Immutable
- Segment Trees and Binary Indexed Trees for mutable arrays

---

🚀 Mastering prefix sum techniques gives you constant time query power with minimal preprocessing!

