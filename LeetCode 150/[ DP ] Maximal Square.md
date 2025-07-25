# 📘 LeetCode 221: Maximal Square

---

## ✅ 0. Question with Explanation

Given a 2D binary matrix filled with `0`s and `1`s, find the largest square containing only `1`s and return its area.

### Example:

```java
Input:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
Explanation: The largest square of 1s is 2x2 (area = 4)
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming on 2D Matrix
- **Why it exists**: Efficiently finds the largest square of 1s
- **Problem it solves**: Used in image analysis, pattern detection, and grid-based optimization problems

---

## ✅ 2. Syntax and Structure

```java
public int maximalSquare(char[][] matrix);
```

- Input: 2D character array matrix with '0' and '1'
- Output: Area (in square units) of the largest square formed only with '1'

---

## ✅ 3. Practical Examples

```java
Input:
1 1
1 1
Output: 4

Input:
0 1
1 0
Output: 1
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: 2D Dynamic Programming

- Create a dp matrix where dp[i][j] represents the side of the largest square ending at (i,j)
- Transition: `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`
- Track the max side length found so far

```java
public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[][] dp = new int[rows + 1][cols + 1];
    int maxSide = 0;

    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= cols; j++) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
    }

    return maxSide * maxSide;
}
```

- Time Complexity: O(m \* n)
- Space Complexity: O(m \* n)

---

### ✅ Approach 2: Space-Optimized DP (Single row)

```java
public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[] dp = new int[cols + 1];
    int maxSide = 0, prev = 0;

    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= cols; j++) {
            int temp = dp[j];
            if (matrix[i - 1][j - 1] == '1') {
                dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                maxSide = Math.max(maxSide, dp[j]);
            } else {
                dp[j] = 0;
            }
            prev = temp;
        }
    }

    return maxSide * maxSide;
}
```

- Time Complexity: O(m \* n)
- Space Complexity: O(n)

---

## ✅ 5. Best Practices

- Pad the dp array to avoid boundary checks
- Reset dp[j] to 0 when matrix[i][j] is '0'

---

## ✅ 6. Related Concepts

- 2D prefix sum
- Largest Rectangle in Histogram (LeetCode 85)

---

## ✅ 7. Interview & Real-world Use

- Common in image processing
- Asked in Google, Microsoft, and Adobe interviews

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors when indexing matrix vs dp array
- Forgetting to update `prev` before assignment

---

## ✅ 9. Java Version Updates

- Use `char[][]` rather than `String[]` for performance
- Java 8+: Use streams for parsing matrix input (optional)

---

## ✅ 10. Practice and Application

- LeetCode 221
- LeetCode 85 (Maximal Rectangle)
- Competitive programming DP problems

---

