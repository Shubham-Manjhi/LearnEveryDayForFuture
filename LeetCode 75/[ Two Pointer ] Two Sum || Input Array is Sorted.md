# 📘 LeetCode 167: Two Sum II - Input Array Is Sorted

---

## ✅ 0. Question

Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array `answer[]` of length 2.

You may not use the same element twice.

Assume that there is exactly one solution.

### Example:
```java
Input: numbers = [2,7,11,15], target = 9
Output: [1,2] // Because numbers[0] + numbers[1] == 9
```

---

## ✅ 1. Definition and Purpose

- Solves the classic "Two Sum" problem, but optimized for sorted arrays.
- Leverages sorted nature for a more efficient two-pointer strategy.
- Helps reinforce binary search and two-pointer mastery.

---

## ✅ 2. Syntax and Structure

```java
public int[] twoSum(int[] numbers, int target);
```

- Input: Sorted array and a target sum
- Output: Indices (1-based) of the two numbers that add up to target

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Two Pointer (Optimized O(n))

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1; // Step 1: Initialize pointers

    while (left < right) {
        int sum = numbers[left] + numbers[right]; // Step 2: Check sum of current pointers

        if (sum == target) {
            return new int[]{left + 1, right + 1}; // Step 3: Return 1-indexed result
        } else if (sum < target) {
            left++; // Step 4: Move left pointer to increase sum
        } else {
            right--; // Step 5: Move right pointer to decrease sum
        }
    }
    return new int[]{-1, -1}; // Not expected as problem guarantees a solution
}
```

### 🔹 Approach 2: Binary Search for Complement (O(n log n))

```java
public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
        int complement = target - numbers[i]; // Step 1: Find what's needed

        // Step 2: Binary search in the remaining part of the array
        int left = i + 1, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == complement) {
                return new int[]{i + 1, mid + 1};
            } else if (numbers[mid] < complement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return new int[]{-1, -1};
}
```

### Step-by-Step Walkthrough (Example)
```
numbers = [2, 7, 11, 15], target = 9
Two Pointer:
left=0 (2), right=1 (7) => 2+7 = 9 => return [1,2]
```

---

## ✅ 4. Internal Working

- Two-pointer approach works because the array is sorted.
- Pointer movement mimics binary search direction without recomputation.

---

## ✅ 5. Best Practices

- Always leverage the sorted property using two-pointer strategy.
- Avoid nested loops when possible.

---

## ✅ 6. Related Concepts

- Two-pointer technique
- Binary search
- Sliding window (variant)

---

## ✅ 7. Interview & Real-world Use

- Useful for searching value pairs in sorted lists or logs.
- Appears in financial data, log analytics, and backend validation.

---

## ✅ 8. Common Errors & Debugging

- Returning 0-indexed instead of 1-indexed.
- Not handling complement search boundaries correctly.

---

## ✅ 9. Java Version Updates

- No changes specific to Java 8+, but stream-based filtering is possible.

---

## ✅ 10. Practice and Application

- LeetCode 1: Two Sum
- LeetCode 15: 3Sum
- LeetCode 18: 4Sum

---

🚀 Mastering Two-Pointer strategies with sorted input opens the door to many efficient array algorithms!

