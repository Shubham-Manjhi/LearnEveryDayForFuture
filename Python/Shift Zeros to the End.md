# 🔄 Shift Zeros to the End in Python

---

## 📘 Problem Explanation

We are given an array of integers. The task is to **move all zeros to the end** of the array while maintaining the relative order of the non-zero elements. This must be done **in-place** without returning a new array.

### Example
```python
Input: nums = [0, 1, 0, 3, 2]
Output: [1, 3, 2, 0, 0]
```

---

## 🔹 Approach 1: Extra Array (Not In-Place)

- Create a new list for non-zeros.
- Append zeros at the end.
- Not valid in strict interview sense (not in-place), but useful to explain.

```python
def moveZeroes(nums):
    result = [x for x in nums if x != 0]
    result += [0] * (len(nums) - len(result))
    return result
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(n)` (extra array)

---

## 🔹 Approach 2: Two-Pointer Technique (In-Place Optimal)

- Maintain two pointers:
  - `last_non_zero` → points to the position where next non-zero should be placed.
  - `i` → iterates through the list.
- Swap non-zero elements with `last_non_zero` index.

```python
def moveZeroes(nums):
    last_non_zero = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[last_non_zero], nums[i] = nums[i], nums[last_non_zero]
            last_non_zero += 1
```

Example Dry Run: `nums = [0, 1, 0, 3, 2]`

| Step | i | nums              | last_non_zero |
|------|---|-------------------|----------------|
| Init |   | [0, 1, 0, 3, 2]   | 0              |
| 1    | 1 | [1, 0, 0, 3, 2]   | 1              |
| 2    | 3 | [1, 3, 0, 0, 2]   | 2              |
| 3    | 4 | [1, 3, 2, 0, 0]   | 3              |

Final Answer = `[1, 3, 2, 0, 0]` ✅

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(1)` (in-place)

---

## 🔹 Approach 3: Count Zeros

- Count number of zeros.
- Overwrite array with non-zero elements in order.
- Fill remaining with zeros.

```python
def moveZeroes(nums):
    count = 0
    for num in nums:
        if num != 0:
            nums[count] = num
            count += 1
    while count < len(nums):
        nums[count] = 0
        count += 1
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(1)`

---

## 🔹 Interview Questions & Answers

**Q1. Why not use `.sort()` to move zeros?**  
👉 Sorting will change the order of non-zero elements, violating the requirement.

**Q2. Which approach is best for interviews?**  
👉 The **two-pointer in-place swap** method. It’s efficient and elegant.

**Q3. How is this problem different from partitioning (like QuickSort)?**  
👉 Similar concept: moving elements based on condition, but here order of non-zeros must be preserved.

**Q4. Can this be extended to move all negative numbers to the end?**  
👉 Yes, just change the condition `nums[i] != 0` to `nums[i] >= 0`.

---

## 🎯 Conclusion

- **Brute Force with extra array** is simple but not valid for in-place constraint.
- **Two-Pointer Swap** is the most optimal solution.
- **Counting Method** is another in-place solution.
- Commonly asked in interviews to test array manipulation & in-place operations.

---

