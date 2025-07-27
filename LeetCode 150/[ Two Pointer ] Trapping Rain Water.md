# 📘 LeetCode 42: Trapping Rain Water

---

## ✅ 0. Question

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

### Example:
```text
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

---

## ✅ 1. Definition and Purpose

- Compute total units of water trapped between bars of varying height.
- This is a classic problem involving precomputation and two-pointer techniques.
- Used to teach prefix maxima, suffix minima, and greedy techniques.

---

## ✅ 2. Syntax and Structure

```java
public int trap(int[] height);
```

- Input: array representing elevation map
- Output: integer representing units of water trapped

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Precompute LeftMax and RightMax (O(n) time, O(n) space)
```java
public int trap(int[] height) {
    int n = height.length;
    if (n == 0) return 0;

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    // Step 1: Build leftMax
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    // Step 2: Build rightMax
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    // Step 3: Calculate trapped water
    int water = 0;
    for (int i = 0; i < n; i++) {
        water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return water;
}
```

### 🔹 Approach 2: Two Pointer (O(n) time, O(1) space)
```java
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int water = 0;

    // Step 1: Use two pointers to scan from both ends
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                water += leftMax - height[left];
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                water += rightMax - height[right];
            }
            right--;
        }
    }

    return water;
}
```

---

## ✅ Example Visualization

```text
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Trapped Water:
         █
     █~~█ █ █
 █~~█ █ █ █ █
------------------
 0  1 0 2 1 0 1 3 2 1 2 1
Total trapped water = 6 units
```

---

## ✅ 4. Internal Working

- Precompute leftMax and rightMax arrays to track boundaries.
- At each index, water trapped = min(leftMax, rightMax) - height[i].
- In two-pointer, compare boundaries dynamically without arrays.

---

## ✅ 5. Best Practices

- Handle edge cases where n <= 2 (cannot trap water)
- Always update leftMax/rightMax before computing trapped water
- Use two-pointer when space optimization is needed

---

## ✅ 6. Related Concepts

- Prefix/Suffix Arrays
- Two-pointer Technique
- Stack-based Histogram (variation)

---

## ✅ 7. Interview & Real-world Use

- Classic interview question for demonstrating pointer and array manipulation
- Used in terrain modeling, simulation, and water flow modeling

---

## ✅ 8. Common Errors & Debugging

- Not updating left/right max before subtracting
- Misunderstanding which side to move in two-pointer
- Not checking boundary conditions

---

## ✅ 9. Java Version Updates

- No language-specific updates affect this logic
- Functional solutions can be used with Java Streams, but not optimal

---

## ✅ 10. Practice and Application

- LeetCode 11: Container With Most Water
- LeetCode 84: Largest Rectangle in Histogram
- LeetCode 85: Maximal Rectangle

---

🌊 Mastering Trapping Rain Water helps you practice array transformation, greedy choice and efficient scanning!

