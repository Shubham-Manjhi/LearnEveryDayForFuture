# 📘 LeetCode 287: Find the Duplicate Number

---

## ✅ 0. Question

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and use only constant extra space.

### Example:
```text
Input: nums = [1,3,4,2,2]
Output: 2
```

---

## ✅ 1. Definition and Purpose

- The task is to find a duplicate number in a read-only array using O(1) space.
- This helps understand pointer-based cycle detection (Floyd’s Tortoise and Hare).
- Prevents using extra data structures or sorting.

---

## ✅ 2. Syntax and Structure

```java
public int findDuplicate(int[] nums);
```

- Input: array with one duplicate in range [1, n]
- Output: the duplicate number

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Floyd’s Cycle Detection (O(n) time, O(1) space)
```java
public int findDuplicate(int[] nums) {
    // Step 1: Detect the cycle using slow and fast pointers
    int slow = nums[0];
    int fast = nums[0];

    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);

    // Step 2: Find the entry point of the cycle (duplicate)
    slow = nums[0];
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }

    return slow;
}
```

### 🔹 Approach 2: Binary Search on Value (O(n log n) time, O(1) space)
```java
public int findDuplicate(int[] nums) {
    int low = 1, high = nums.length - 1;

    while (low < high) {
        int mid = (low + high) / 2;

        int count = 0;
        for (int num : nums) {
            if (num <= mid) count++;
        }

        // If count > mid, the duplicate must be in the lower half
        if (count > mid) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }

    return low;
}
```

---

## ✅ 4. Internal Working

- Floyd’s algorithm treats numbers as pointers to indices to detect cycles.
- Binary Search counts values to locate the duplicate range.

---

## ✅ 5. Best Practices

- Always validate array constraints.
- Prefer Floyd's cycle detection for better runtime and simplicity.
- Avoid modifying the input.

---

## ✅ 6. Related Concepts

- Cycle detection in Linked List
- Pigeonhole Principle
- Binary Search on answer

---

## ✅ 7. Interview & Real-world Use

- Common in system diagnostics where data cannot be copied or altered.
- Good test for mastering O(1) space solutions.

---

## ✅ 8. Common Errors & Debugging

- Not understanding why array elements point to indices
- Failing to reset slow pointer correctly
- Counting incorrectly in binary search approach

---

## ✅ 9. Java Version Updates

- No impact from Java versions
- Uses basic loop, conditionals, and array access

---

## ✅ 10. Practice and Application

- LeetCode 142: Linked List Cycle II
- LeetCode 268: Missing Number
- LeetCode 442: Find All Duplicates in an Array

---

🚀 Mastering cycle detection and binary search opens up powerful memory-efficient solutions!

