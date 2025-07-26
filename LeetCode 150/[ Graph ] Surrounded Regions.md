# 🌀 LeetCode 130: Surrounded Regions

---

## ✅ 1. Definition and Purpose

- Given a 2D board with 'X' and 'O', capture all regions surrounded by 'X'.
- A region is captured if it is surrounded on all sides by 'X'.
- Purpose: Explore DFS/BFS and border-connected component handling.

---

## ✅ 2. Syntax and Structure

### Method Signature
```java
public void solve(char[][] board)
```

### Idea:
- Don't capture 'O' connected to the border.
- Temporarily mark safe 'O's (border-connected) as something else (e.g., 'T').
- Post-traversal, flip:
  - All 'O' → 'X' (captured)
  - All 'T' → 'O' (safe)

---

## ✅ 3. Practical Example

### Input:
```
X X X X
X O O X
X X O X
X O X X
```

### Output:
```
X X X X
X X X X
X X X X
X O X X
```

Only the region [1][1], [1][2], [2][2] is surrounded. [3][1] is connected to border → safe.

### Java Code:
```java
public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    // 1. Mark border-connected 'O' as 'T'
    for (int i = 0; i < m; i++) {
        dfs(board, i, 0);
        dfs(board, i, n - 1);
    }
    for (int j = 0; j < n; j++) {
        dfs(board, 0, j);
        dfs(board, m - 1, j);
    }

    // 2. Flip all 'O' → 'X', and 'T' → 'O'
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'O') board[i][j] = 'X';
            else if (board[i][j] == 'T') board[i][j] = 'O';
        }
    }
}

private void dfs(char[][] board, int i, int j) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;
    board[i][j] = 'T';
    dfs(board, i+1, j);
    dfs(board, i-1, j);
    dfs(board, i, j+1);
    dfs(board, i, j-1);
}
```

---

## ✅ 4. Internal Working

- Use DFS to flood all safe 'O' from borders.
- Mark them as temporary ('T').
- In final sweep, convert captured regions.

Time: O(M × N)  
Space: O(M × N) worst case recursion stack

---

## ✅ 5. ASCII Diagram

```
Initial Board:
X X X X
X O O X
X X O X
X O X X

Step 1 (Mark 'T'):
X X X X
X T T X
X X T X
X O X X

Step 2 (Flip):
X X X X
X X X X
X X X X
X O X X
```

---

## ✅ 6. Best Practices

- Avoid extra visited matrix by using in-place marking.
- Use BFS (queue) for large boards to avoid stack overflow.
- Don't flood from non-border cells initially.

---

## ✅ 7. Related Concepts

- DFS/BFS on 2D grid
- Flood fill
- Connected component
- Border expansion

---

## ✅ 8. Interview & Real-world Use

- Classic grid flood-fill interview problem
- Game design (flood fill tools)
- Map zone coloring, terrain classification

---

## ✅ 9. Common Errors & Debugging

- Forgetting to mark border-connected 'O' → miss safe zones
- Forgetting to revert 'T' → 'O'
- Stack overflow on large boards (use BFS)

---

## ✅ 10. Java Version Updates

- No version-specific features
- Optional: Use `Deque` for BFS

---

## ✅ 11. Practice and Application

- LeetCode 200: Number of Islands
- LeetCode 1020: Number of Enclaves
- LeetCode 733: Flood Fill

---

✅ Surrounded Regions teaches defensive boundary-based DFS/BFS and region isolation. Mastering this unlocks numerous grid-based classification problems!

