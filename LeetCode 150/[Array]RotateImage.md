**Java Topic: LeetCode 48 - Rotate Image**

---

✅ 1. Definition and Purpose

• What is the concept?\
Rotate a given n x n 2D matrix (image) by 90 degrees clockwise in-place.

• Why does it exist in Java?\
It demonstrates mastery over 2D arrays, matrix transformations, and in-place algorithms.

• What problem does it solve?\
Common in graphics manipulation, game design, and spatial data rotation.

🧠 Example: Input: [[1,2,3],[4,5,6],[7,8,9]] → Output: [[7,4,1],[8,5,2],[9,6,3]]

---

✅ 2. Syntax and Structure

• Define `void rotate(int[][] matrix)`\
• Transpose the matrix and reverse each row

---

✅ 3. Practical Examples

🔹 Approach 1: Transpose + Reverse Rows (In-place)

```java
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
```

🔹 Approach 2: Layer-by-layer Rotation

```java
public class RotateImageLayered {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
```

🖼️ ASCII Diagram – Transpose and Reverse:
```
Original:
1 2 3
4 5 6
7 8 9

Transpose:
1 4 7
2 5 8
3 6 9

Reverse Rows:
7 4 1
8 5 2
9 6 3
```

---

✅ 4. Internal Working

• Transposition swaps matrix[i][j] with matrix[j][i]\
• Row reversal swaps left and right in each row

Time Complexity: O(n²)

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ In-place swap carefully\
✔ Always check matrix is square\
✔ Separate transpose and reverse logic for clarity

---

✅ 6. Related Concepts

- Matrix Transposition\
- Array Rotation\
- In-place Algorithms

🧠 Example: Image processing, game grid mechanics

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Common array manipulation question

🏢 Real-world:
- Image editing\
- Game development\
- 2D UI rendering

---

✅ 8. Common Errors & Debugging

❌ Forgetting matrix must be square\
❌ Confusing i vs j during swaps\
❌ Incorrect row indexing when reversing

🧪 Debug Tip:
- Print matrix after transpose and after reversal

---

✅ 9. Java Version Updates

• No direct changes, works across Java versions\
• Java 8+: Stream for flattening but not in-place

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #48\
- Matrix in-place problems

🏗 Apply in:
- Photo filters\
- Data visualization dashboards\
- Puzzle board games

