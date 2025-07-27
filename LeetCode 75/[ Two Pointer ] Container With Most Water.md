# 📘 LeetCode 11: Container With Most Water

---

## ✅ 0. Question

Given `n` non-negative integers `height[0], height[1], ..., height[n-1]` where each represents a vertical line on the x-axis, find two lines such that they together with the x-axis form a container that holds the most water.

Return the maximum amount of water a container can store.

### Example:
```text
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
```

---

## ✅ 1. Definition and Purpose

- This is an optimization problem: maximize area = min(height[i], height[j]) * (j - i)
- Highlights two-pointer technique to optimize brute-force area comparisons

---

## ✅ 2. Syntax and Structure

```java
int maxArea(int[] height);
```

- Inputs: array of heights
- Output: maximum area of water contained

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force (O(n^2))

```java
public int maxArea(int[] height) {
    int max = 0;
    // Step 1: Try every pair of lines
    for (int i = 0; i < height.length; i++) {
        for (int j = i + 1; j < height.length; j++) {
            // Step 2: Calculate area using width and minimum height
            int area = (j - i) * Math.min(height[i], height[j]);
            // Step 3: Keep track of the maximum area
            max = Math.max(max, area);
        }
    }
    return max;
}
```

### 🔹 Approach 2: Two Pointer (Optimized O(n))

```java
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int max = 0;

    // Step 1: Initialize two pointers at the ends
    while (left < right) {
        // Step 2: Calculate the area formed by the current two lines
        int area = (right - left) * Math.min(height[left], height[right]);
        // Step 3: Update max area if current area is greater
        max = Math.max(max, area);

        // Step 4: Move the pointer pointing to the shorter line inward
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return max;
}
```

### Example Execution
```text
left = 0, right = 8 => area = 8 * min(1,7) = 8
left = 1, right = 8 => area = 7 * min(8,7) = 49 (max)
... continue until left meets right
```

---

## ✅ 4. Internal Working

- Area is determined by width (distance between lines) and height (shorter line)
- Shrinking the window from the shorter height ensures possibility of finding a taller wall

---

## ✅ 5. Best Practices

- Use two-pointer to avoid nested loops
- Always compare current area with max
- Move the pointer of the shorter line

---

## ✅ 6. Related Concepts

- Two-pointer technique
- Sliding window (variant)
- Greedy decisions (moving only when potential increases)

---

## ✅ 7. Interview & Real-world Use

- Popular question in system optimization, memory allocation, wall modeling
- Appears frequently in technical interviews for FAANG companies

---

## ✅ 8. Common Errors & Debugging

- Not updating max area properly
- Moving both pointers instead of the shorter one
- Integer overflow (if heights are large)

---

## ✅ 9. Java Version Updates

- No major impact from Java 8+, though `Math.max()` and `Math.min()` improved internally

---

## ✅ 10. Practice and Application

- LeetCode 42: Trapping Rain Water
- LeetCode 84: Largest Rectangle in Histogram
- Related to graphical memory visualization, physical simulations

---

🚀 Container With Most Water helps you master greedy and two-pointer strategies efficiently!

