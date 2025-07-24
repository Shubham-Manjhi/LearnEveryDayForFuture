**Java Topic: LeetCode 74 - Search a 2D Matrix**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given an m x n matrix where each row is sorted and the first integer of each row is greater than the last integer of the previous row, determine if a target value exists in the matrix.

• Why does it exist in Java?\
To teach binary search adaptations across 2D arrays using linearized access.

• What problem does it solve?\
Efficiently finds a target value in a sorted 2D matrix without flattening it.

🧠 Example: Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 → Output: true

---

✅ 2. Syntax and Structure

• Define `boolean searchMatrix(int[][] matrix, int target)`\
• Treat 2D matrix as 1D array and use binary search.

---

✅ 3. Practical Examples

🔹 Approach: Binary Search via Flattened Index

```java
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) return true;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
```

🖼️ ASCII Diagram – Flattening Matrix:

```
Matrix:
[ [1,  3,  5,  7],
  [10,11,16,20],
  [23,30,34,60] ]

Flattened View:
Index:  0   1   2   3   4   5   6   7   8   9  10  11
Value:  1   3   5   7  10  11 16  20  23  30  34  60
```

Explanation:

- Index = mid
- Access as: matrix[mid / n][mid % n]

---

✅ 4. Internal Working

• Binary search is done on virtual 1D space from 0 to m\*n - 1\
• Mid is translated into matrix[row][col] via division and modulo

Time Complexity: O(log(m \* n))

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Use integer division and modulus for row/column mapping\
✔ Prevent overflow in mid calculation\
✔ Return immediately on match

---

✅ 6. Related Concepts

- Matrix Traversal
- Binary Search
- Coordinate Mapping

🧠 Example: Efficient search in spreadsheets or tables

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Classic mid-level binary search challenge

🏢 Real-world:

- Row-column indexed lookup\


- Table cell search in spreadsheets\


- Range-based grid lookups

---

✅ 8. Common Errors & Debugging

❌ Wrong mid-to-row/col conversion\
❌ Matrix index out of bounds\
❌ Using linear scan instead of binary search

🧪 Debug Tip:

- Print mid, row, col values each iteration

---

✅ 9. Java Version Updates

• Java 8+: No special enhancements required\
• Java 11+: Optional/stream not needed here

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #74\


- Binary Search on 2D grids

🏗 Apply in:

- Search on database table views\


- Warehouse item mapping\


- Heatmap data grid queries

