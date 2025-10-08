# 🎯 **Binary Search in Python** 🔍🐍

---

## 🔹 Introduction

Binary Search is one of the most fundamental and efficient searching algorithms used to find the position of a target element in a **sorted array**. It reduces the time complexity to **O(log n)** by repeatedly dividing the search space into half.

This guide will explore:

- Basics of Binary Search
- Iterative vs Recursive Implementations
- Variants of Binary Search (first/last occurrence, upper/lower bound)
- Applications in real-world problems
- Common pitfalls and interview questions

---

## 🔹 **Subtopic 1: What is Binary Search?** 💡

### 📘 Explanation

- **Definition**: Binary Search is a divide-and-conquer algorithm used on sorted arrays/lists.
- **Key Principle**: Compare the target with the middle element and eliminate half of the search space each time.
- **Requirements**: The input data must be **sorted**.

### ❓ Interview Q&A

**Q1: Why is binary search faster than linear search?**

- Linear search takes O(n) time.
- Binary search reduces search space by half, giving O(log n) time.

**Q2: Can binary search work on unsorted data?**

- No, unless the data is sorted beforehand.

### 🐍 Example (Basic Binary Search)

```python
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

arr = [1, 3, 5, 7, 9, 11]
print(binary_search(arr, 7))  # Output: 3
```

---

## 🔹 **Subtopic 2: Recursive Binary Search** 🔄

### 📘 Explanation

- Uses function recursion to repeatedly divide the array.
- Less space efficient due to call stack usage.

### ❓ Interview Q&A

**Q1: Which is better: iterative or recursive binary search?**

- Iterative is usually preferred due to constant space complexity.

### 🐍 Example

```python
def recursive_binary_search(arr, left, right, target):
    if left > right:
        return -1
    mid = (left + right) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return recursive_binary_search(arr, mid + 1, right, target)
    else:
        return recursive_binary_search(arr, left, mid - 1, target)

arr = [2, 4, 6, 8, 10, 12]
print(recursive_binary_search(arr, 0, len(arr)-1, 8))  # Output: 3
```

---

## 🔹 **Subtopic 3: Variants of Binary Search** 🎭

### 📘 Explanation

- Binary Search can be modified to solve different problems:
  - **First Occurrence**
  - **Last Occurrence**
  - **Lower Bound (smallest index ≥ target)**
  - **Upper Bound (smallest index > target)**

### ❓ Interview Q&A

**Q1: How do you modify binary search to find the first occurrence of a duplicate?**

- Continue searching on the left even after finding the target.

### 🐍 Example (First Occurrence)

```python
def first_occurrence(arr, target):
    left, right = 0, len(arr) - 1
    result = -1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            result = mid
            right = mid - 1  # Keep searching left
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return result

arr = [1, 2, 2, 2, 3, 4]
print(first_occurrence(arr, 2))  # Output: 1
```

---

## 🔹 **Subtopic 4: Applications of Binary Search** 🚀

### 📘 Use Cases

- Searching in sorted arrays.
- Finding square root of a number.
- Searching in rotated sorted arrays.
- Peak finding in mountain arrays.
- Efficient solutions in competitive programming.

### ❓ Interview Q&A

**Q1: Can binary search be applied to monotonic functions?**

- Yes, as long as the function output is sorted or monotonic.

**Q2: How does binary search help in optimization problems?**

- Used in minimizing/maximizing problems with sorted search space.

### 🐍 Example (Square Root using Binary Search)

```python
def sqrt_binary(n):
    left, right = 0, n
    result = -1
    while left <= right:
        mid = (left + right) // 2
        if mid * mid == n:
            return mid
        elif mid * mid < n:
            result = mid
            left = mid + 1
        else:
            right = mid - 1
    return result

print(sqrt_binary(17))  # Output: 4 (floor of sqrt(17))
```

---

## 🔹 **Subtopic 5: Common Pitfalls** ⚠️

### 📘 Issues to Avoid

- Infinite loops due to incorrect mid updates.
- Integer overflow in mid calculation (`(left + right) // 2`).
- Forgetting sorted array requirement.
- Not handling duplicates correctly.

### ❓ Interview Q&A

**Q1: How do you prevent overflow in binary search mid calculation?**

- Use `mid = left + (right - left) // 2` instead of `(left + right) // 2`.

**Q2: How do you handle duplicates?**

- Modify binary search to continue searching left/right based on requirement.

---

## 🔹 **Subtopic 6: Time and Space Complexity** ⏱️

### 📘 Analysis

- **Best Case**: O(1) (when mid is target).
- **Average Case**: O(log n).
- **Worst Case**: O(log n).
- **Space Complexity**:
  - Iterative: O(1)
  - Recursive: O(log n) (due to call stack)

### ❓ Interview Q&A

**Q1: Why is binary search O(log n)?**

- Because the search space is halved at each step.

**Q2: Can binary search achieve O(1)?**

- Only if the middle element is the target on the first check.

---

## 🎯 **Conclusion** 🏆

- Binary Search is a powerful algorithm based on **divide-and-conquer**.
- Efficiently reduces search space, making it a go-to algorithm in interviews.
- Variants like first/last occurrence and lower/upper bound are crucial.
- Mastery of binary search is essential for solving advanced algorithmic problems.

