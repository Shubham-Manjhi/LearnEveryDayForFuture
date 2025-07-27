# 📘 LeetCode 2352: Equal Row and Column Pairs

---

## ✅ 0. Question

Given a 2D integer array `grid` of size `n x n`, return the number of pairs `(ri, cj)` such that row `ri` and column `cj` are equal.

### Example:

```text
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1

Explanation:
Only row 1 and column 0 are equal: [1,7,6]
```

---

## ✅ 1. Definition and Purpose

This problem focuses on matrix manipulation. It highlights:

- Comparing rows and columns
- Efficient hash-based matching

Purpose: To practice comparing data in 2D space efficiently.

---

## ✅ 2. Syntax and Structure

- Nested arrays for matrix: `int[][] grid`
- Use `Map<List<Integer>, Integer>` to store row frequencies
- Loop over columns to match with stored rows

---

## ✅ 3. Practical Example

### 🔹 Approach 1: HashMap for Row Count

```java
public int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> rowMap = new HashMap<>();

    // Step 1: Convert each row into string and count occurrences
    for (int[] row : grid) {
        String key = Arrays.toString(row);
        rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
    }

    int count = 0;
    // Step 2: Convert each column into string and check in rowMap
    for (int j = 0; j < n; j++) {
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = grid[i][j];
        }
        String colKey = Arrays.toString(col);
        count += rowMap.getOrDefault(colKey, 0);
    }

    return count;
}
```

### 🔹 Approach 2: Brute Force Compare (Slower)

```java
public int equalPairs(int[][] grid) {
    int n = grid.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            boolean match = true;
            for (int k = 0; k < n; k++) {
                if (grid[i][k] != grid[k][j]) {
                    match = false;
                    break;
                }
            }
            if (match) count++;
        }
    }

    return count;
}
```

---

## ✅ 4. Internal Working

- **Approach 1** builds a hash map of row signatures.
- Then it traverses each column and checks if the column's signature matches any row.

---

## ✅ 5. Best Practices

- Use `Arrays.toString(row)` for consistent key formatting
- Hashing improves efficiency over brute-force comparison

---

## ✅ 6. Related Concepts

- Matrix manipulation
- Hash maps for pattern matching
- Transposing arrays

---

## ✅ 7. Interview & Real-world Use

- Common matrix-based pattern-matching question
- Used in image matching, symmetric matrix checks

---

## ✅ 8. Common Errors & Debugging

- Mixing up row vs column indices
- Forgetting to reset temporary column array
- Comparing object references vs values

---

## ✅ 9. Java Version Updates

- Java 8 streams can be used for cleaner code
- `List<Integer>` as key works but `Arrays.toString` is simpler and faster

---

## ✅ 10. Practice and Application

- LeetCode 54: Spiral Matrix
- LeetCode 73: Set Matrix Zeroes
- Useful for game board validation and AI grid analysis

---

✅ Matrix hash matching problems help reinforce grid traversal and hashing techniques!

