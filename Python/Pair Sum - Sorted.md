# 🔢 Pair Sum - Sorted (Easy)

---

## 📘 Problem Statement

Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

**Example 1:**
```python
Input: nums = [1, 2, 3, 4, 6], target = 6
Output: [1, 3]   # nums[1] + nums[3] = 2 + 4 = 6
```

**Example 2:**
```python
Input: nums = [2, 3, 4], target = 6
Output: [0, 2]   # nums[0] + nums[2] = 2 + 4 = 6
```

**Example 3:**
```python
Input: nums = [1, 5, 10], target = 20
Output: []   # No such pair exists
```

---

## 🔹 Approach 1: Two-Pointer Technique

Since the array is **sorted**, we can use the two-pointer approach:
- Start with `left = 0` and `right = len(nums)-1`.
- Compute `current_sum = nums[left] + nums[right]`.
- If `current_sum == target`, return `[left, right]`.
- If `current_sum < target`, move `left` forward.
- If `current_sum > target`, move `right` backward.

### ✅ Python Code
```python
from typing import List

class Solution:
    def pairSumSorted(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1
        while left < right:
            current_sum = nums[left] + nums[right]
            if current_sum == target:
                return [left, right]
            elif current_sum < target:
                left += 1
            else:
                right -= 1
        return []
```

### 🕒 Complexity
- **Time Complexity:** O(n) → single pass.
- **Space Complexity:** O(1) → no extra space.

---

## 🔹 Approach 2: Hash Map (Alternative)

If the array was **not sorted**, we could use a hash map.

### ✅ Python Code
```python
class Solution:
    def pairSumUnsorted(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i
        return []
```

### 🕒 Complexity
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) → extra hash map storage.

---

## 🎯 Interview Q&A

**Q1. Why is the two-pointer approach optimal here?**
- Because the array is sorted, we can adjust pointers intelligently in O(n) time.

**Q2. What if the array was not sorted?**
- We would need to either **sort first** (O(n log n)) or use a **hash map** (O(n) time, O(n) space).

**Q3. What are the edge cases?**
- Array length < 2 → return [].
- No valid pair exists → return [].
- Multiple pairs exist → return any one.

**Q4. Is it possible to solve in O(log n)?**
- Not generally, since we may need to scan through all elements. O(n) is optimal.

---

## 🚀 Key Takeaways
- Two-pointer method is best for **sorted arrays**.
- Hash map method works for **unsorted arrays**.
- Time complexity: O(n), Space: O(1) (for two-pointer).
- Always consider **edge cases** and **array order** in interview discussions.

---

