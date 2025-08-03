# 📘 LeetCode 54: Spiral Matrix

---

## ✅ 0. Question

Given an m x n matrix, return all elements of the matrix in spiral order.

### Example:

Input:
```java
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
```
Output:
```java
[1, 2, 3, 6, 9, 8, 7, 4, 5]
```

---

## ✅ 1. Definition and Purpose

Spiral traversal is a common matrix traversal method used to visit each element in spiral order — top → right → bottom → left, layer by layer.

- Helps understand multi-directional traversal.
- Used in printing layouts, simulations, and game boards.

---

## ✅ 2. Syntax and Structure

Java structure:
```java
public List<Integer> spiralOrder(int[][] matrix);
```

Approach: Use boundaries — top, bottom, left, right — to track traversal.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Boundary Traversal (Optimized, O(m * n))
```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return result;

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    // Step 1: Traverse layer by layer
    while (top <= bottom && left <= right) {
        // ➡ Step 2: Traverse from Left to Right
        for (int i = left; i <= right; i++) result.add(matrix[top][i]);
        top++;

        // ⬇ Step 3: Traverse from Top to Bottom
        for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
        right--;

        // ⬅ Step 4: Traverse from Right to Left (if still valid)
        if (top <= bottom) {
            for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            bottom--;
        }

        // ⬆ Step 5: Traverse from Bottom to Top (if still valid)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            left++;
        }
    }
    return result;
}
```

### Example Trace:

```
1 → 2 → 3
          ↓
4         6
↓         ↓
7 ← 8 ← 9
```

---

## ✅ 4. Internal Working

- Top, Bottom, Left, Right are boundaries.
- Each iteration peels a spiral layer.
- Loop breaks when bounds collapse.

### Time Complexity:
- O(m * n) — each element is visited once.
### Space Complexity:
- O(1) extra (excluding output list).

---

## ✅ 5. Best Practices

- Always check bounds before inner loops.
- Use consistent update order: top → right → bottom → left.
- Avoid nested conditions.

---

## ✅ 6. Related Concepts

- Matrix Traversal
- Layered Simulation
- Two Pointers

---

## ✅ 7. Interview & Real-world Use

- Frequently asked by Google, Facebook.
- Used in image transformations, map rendering.

---

## ✅ 8. Common Errors & Debugging

- Infinite loop due to improper boundary updates.
- Missing checks when matrix is non-square.
- Index out of bounds when forgetting top ≤ bottom.

---

## ✅ 9. Java Version Updates

- No major impact from Java versions.
- Can use enhanced `List.of(...)` syntax (Java 9+).

---

## ✅ 10. Practice and Application

- LeetCode 59: Spiral Matrix II (fill instead of read)
- LeetCode 885: Spiral Matrix III (non-rectangular)

---

🎯 Mastering spiral matrix gives confidence in boundary-based traversal and directional indexing!

