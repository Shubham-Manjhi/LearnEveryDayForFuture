# <div align="center">🎯 Question (LeetCode 42: Trapping Rain Water)</div>

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute **how much water it can trap after raining**.

**Example:**

- Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
- Output: 6
- Explanation: The water trapped is 6 units.

- Input: height = [4,2,0,3,2,5]
- Output: 9

---

# 🏷 Trapping Rain Water

## 📂 1. Definition and Purpose

- Calculate the total water trapped between bars after raining.
- Useful in simulations, terrain analysis, and water flow modeling.

## 📂 2. Syntax and Structure (Python)

```python
# height: list of non-negative integers representing bar heights
```

## 📂 3. Two Approaches

### 🧾 Approach 1: Brute Force

- For each bar, calculate the max height to its left and right.
- Water trapped at bar = min(max_left, max_right) - height[i]

```python
def trap_bruteforce(height):
    n = len(height)
    water = 0
    for i in range(n):
        max_left = max(height[:i+1])
        max_right = max(height[i:])
        water += min(max_left, max_right) - height[i]
    return water
```
- **Time Complexity:** O(n^2)
- **Space Complexity:** O(1)

### 🧾 Approach 2: Optimized (Two Pointers)

- Use two pointers to traverse from both ends.
- Track left_max and right_max while moving pointers inward.
- O(n) time, O(1) space.

## 📂 4. Optimized Pseudocode

```
left = 0, right = n-1
left_max = 0, right_max = 0
water = 0
while left < right:
    if height[left] < height[right]:
        if height[left] >= left_max:
            left_max = height[left]
        else:
            water += left_max - height[left]
        left += 1
    else:
        if height[right] >= right_max:
            right_max = height[right]
        else:
            water += right_max - height[right]
        right -= 1
return water
```

## 📂 5. Python Implementation with Detailed Comments

```python
def trap(height: list[int]) -> int:
    """
    Calculate trapped rain water using two-pointer approach.
    """
    left, right = 0, len(height) - 1  # Initialize pointers
    left_max, right_max = 0, 0        # Initialize max heights
    water = 0                          # Initialize water trapped

    while left < right:
        if height[left] < height[right]:
            if height[left] >= left_max:
                left_max = height[left]  # Update left max
            else:
                water += left_max - height[left]  # Add trapped water
            left += 1
        else:
            if height[right] >= right_max:
                right_max = height[right]  # Update right max
            else:
                water += right_max - height[right]  # Add trapped water
            right -= 1

    return water

# Example Usage
height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(trap(height))  # Output: 6
```

## 📂 6. Internal Working

- Left and right pointers move toward the center.
- left_max and right_max track the highest bars from each side.
- Water is trapped where current bar is lower than the max of its side.
- Single pass ensures O(n) efficiency.

## 📂 7. Best Practices

- Use two-pointer approach for large input arrays.
- Avoid nested loops for efficiency.
- Ensure input is non-negative integers.

## 📂 8. Related Concepts

- Two-pointer technique
- Array traversal
- Prefix/suffix maximum concepts

## 📂 9. Complexity Analysis

- **Optimized Approach:**
  - Time: O(n)
  - Space: O(1)
- **Brute Force Approach:**
  - Time: O(n^2)
  - Space: O(1)

## 📂 10. Practice and Application

- LeetCode: 42 Trapping Rain Water
- Applications in terrain analysis, water trapping simulations, and game development.

