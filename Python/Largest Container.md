# 🏞️ Largest Container in Python

---

## 📘 Problem Explanation

You are given an array of integers where each value represents the height of a vertical line drawn on the x-axis. Two lines, together with the x-axis, can form a container. We need to find the **maximum area** of water that can be trapped between any two lines.

### Example
```python
Input: heights = [2, 7, 8, 3, 7, 6]
Output: 24
```

👉 The container is formed between height `8` at index 2 and height `7` at index 4.  
Width = (4 - 2) = 2, Height = min(8, 7) = 7, Area = 2 * 7 = 14.  
But the maximum comes between index 1 (height=7) and index 5 (height=6).  
Width = (5 - 1) = 4, Height = min(7, 6) = 6, Area = 24.

---

## 🔹 Approach 1: Brute Force

- Compare every pair of lines.
- Compute the area = min(height[i], height[j]) * (j - i).
- Keep track of the maximum.

```python
class Solution:
    def maxArea(self, height):
        n = len(height)
        max_area = 0
        for i in range(n):
            for j in range(i+1, n):
                area = min(height[i], height[j]) * (j - i)
                max_area = max(max_area, area)
        return max_area
```

✅ **Time Complexity**: `O(n^2)` (too slow for large input)
✅ **Space Complexity**: `O(1)`

---

## 🔹 Approach 2: Two-Pointer Technique (Optimal)

- Start with **two pointers**: left at the start, right at the end.
- Calculate the area.
- Move the pointer pointing to the **shorter line**, since area is limited by the shorter height.
- Keep track of the maximum.

```python
class Solution:
    def maxArea(self, height):
        left, right = 0, len(height) - 1
        max_area = 0
        while left < right:
            area = min(height[left], height[right]) * (right - left)
            max_area = max(max_area, area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(1)`

---

## 🔹 Dry Run Example

Input: `heights = [2, 7, 8, 3, 7, 6]`

| Left | Right | height[left] | height[right] | Width | Area | Max_Area |
|------|-------|--------------|---------------|-------|------|----------|
| 0    | 5     | 2            | 6             | 5     | 10   | 10       |
| 1    | 5     | 7            | 6             | 4     | 24   | 24       |
| 1    | 4     | 7            | 7             | 3     | 21   | 24       |
| 2    | 4     | 8            | 7             | 2     | 14   | 24       |
| 2    | 3     | 8            | 3             | 1     | 3    | 24       |

Final Answer = **24** ✅

---

## 🔹 Interview Questions & Answers

**Q1. Why do we move the pointer with the smaller height?**  
👉 Because the area is constrained by the smaller line; moving the larger line won’t help.

**Q2. Can the brute force solution work for large input (10^5 elements)?**  
👉 No, because `O(n^2)` is too slow. The two-pointer approach `O(n)` is optimal.

**Q3. What is the maximum area formula?**  
👉 `Area = min(height[i], height[j]) * (j - i)`

**Q4. How does this relate to the trapping rainwater problem?**  
👉 Both involve heights and area calculations, but trapping rainwater calculates total trapped water, while this calculates max container area.

---

## 🎯 Conclusion

- **Brute Force:** Simple but inefficient (`O(n^2)`).
- **Two-Pointer:** Efficient and elegant (`O(n)`).
- Always move the pointer at the shorter height.
- Common interview question in **FAANG**.

---

