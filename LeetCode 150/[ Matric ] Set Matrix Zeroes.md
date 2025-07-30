# 📘 LeetCode 73: Set Matrix Zeroes

---

## ✅ 0. Question

Given an `m x n` integer matrix, if an element is 0, set its entire row and column to 0.
You must do it in-place.

### Example:
```text
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
```

---

## ✅ 1. Definition and Purpose

- The problem tests in-place transformation and matrix manipulation.
- Focuses on optimizing space while modifying matrix structure.

---

## ✅ 2. Syntax and Structure

```java
public void setZeroes(int[][] matrix);
```

- Input: 2D matrix of integers
- Output: modified matrix (in-place)

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force with Extra Space (O(m+n) space)

```java
public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();

    // Step 1: Identify all rows and columns that need to be zeroed
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                rows.add(i);
                cols.add(j);
            }
        }
    }

    // Step 2: Set entire row and column to zero
    for (int i : rows) {
        Arrays.fill(matrix[i], 0);
    }
    for (int j : cols) {
        for (int i = 0; i < m; i++) {
            matrix[i][j] = 0;
        }
    }
}
```

### 🔹 Approach 2: Optimal In-place with First Row & Column as Markers (O(1) space)

```java
public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;

    // Step 1: Check if first row or column need to be zeroed
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) firstColZero = true;
    }
    for (int j = 0; j < n; j++) {
        if (matrix[0][j] == 0) firstRowZero = true;
    }

    // Step 2: Use first row and column to mark zero rows/cols
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // Step 3: Zero rows and cols based on markers
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Step 4: Handle first row and column separately
    if (firstRowZero) {
        for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }
    if (firstColZero) {
        for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}
```

### Example Execution:
```text
Initial matrix:
[
 [1, 1, 1],
 [1, 0, 1],
 [1, 1, 1]
]

Markers set at: matrix[1][0] and matrix[0][1]
Final result:
[
 [1, 0, 1],
 [0, 0, 0],
 [1, 0, 1]
]
```

---

## ✅ 4. Internal Working

- In-place solution reuses matrix’s first row/col as markers.
- Avoids extra memory except for a few boolean flags.
- Preserves original row/col structure until overwrite.

---

## ✅ 5. Best Practices

- Avoid modifying matrix while scanning unless you're sure of markers.
- Use first row/col if allowed for marker efficiency.
- Be careful with first row/col overwrite edge cases.

---

## ✅ 6. Related Concepts

- Matrix transformation
- In-place algorithms
- Flag-based memory optimization

---

## ✅ 7. Interview & Real-world Use

- Commonly asked in interviews to test matrix logic.
- Seen in UI systems (grid resets), image processing (pixel block resets).

---

## ✅ 8. Common Errors & Debugging

- Forgetting to update first row/col
- Accidentally overwriting matrix values before needed
- Not handling 1-row or 1-column matrices properly

---

## ✅ 9. Java Version Updates

- No dependency on new features
- Compatible with Java 5+ (basic arrays and conditionals)

---

## ✅ 10. Practice and Application

- LeetCode 289: Game of Life (in-place cell update)
- Matrix zeroing in spreadsheet-like systems
- Dynamic UI refresh based on state triggers

---

🧠 Mastering Set Matrix Zeroes trains you in space-efficient transformations and 2D array manipulation for interviews and real-world system work!

