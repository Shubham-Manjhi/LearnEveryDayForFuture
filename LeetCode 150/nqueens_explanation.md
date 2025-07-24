**Java Topic: LeetCode 51 - N-Queens**

---

✅ 1. Definition and Purpose

• What is the concept?\
The N-Queens problem asks us to place N queens on an N×N chessboard such that no two queens threaten each other. That means no two queens share the same row, column, or diagonal.

• Why does it exist in Java?\
It's a classic example of constraint satisfaction and backtracking, essential for understanding recursion and efficient state-space exploration in Java.

• What problem does it solve?\
It solves resource allocation problems where constraints must be enforced between elements.

🧠 Example: Placing queens such that they don’t attack each other represents many real-world scheduling or placement constraints.

---

✅ 2. Syntax and Structure

• Understand the basic syntax used to implement the concept.\
• Java uses recursion and backtracking with arrays and ArrayLists to track state.

🧠 Example: Define `solveNQueens(int n)` to return a `List<List<String>>`.

---

✅ 3. Practical Examples

🔹 Approach 1: Backtracking with Safety Checks

```java
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, results);
        return results;
    }

    private void backtrack(int row, char[][] board, List<List<String>> results) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            results.add(solution);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, results);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
}
```

🔹 Approach 2: Optimized Backtracking Using Bitmasking (O(n!) but faster in practice)

```java
public class NQueensBitmask {
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        solve(n, 0, 0, 0, 0, new ArrayList<>(), new char[n][n]);
        return results;
    }

    private void solve(int n, int row, int cols, int d1, int d2, List<String> boardSoFar, char[][] board) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board)
                list.add(new String(r));
            results.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int colMask = 1 << col, d1Mask = 1 << (row - col + n), d2Mask = 1 << (row + col);
            if ((cols & colMask) != 0 || (d1 & d1Mask) != 0 || (d2 & d2Mask) != 0) continue;
            board[row][col] = 'Q';
            solve(n, row + 1, cols | colMask, d1 | d1Mask, d2 | d2Mask, boardSoFar, board);
            board[row][col] = '.';
        }
    }
}
```

---

✅ 4. Internal Working

• Backtracking explores all configurations recursively and abandons invalid paths early.\
• Bitmasking compresses state into integers for fast conflict checking, especially beneficial for larger `n`.

---

✅ 5. Best Practices

✔ Use char[][] instead of String[][] to reduce object creation overhead.\
✔ Prefer bitmasking for larger boards (`n > 10`).\
✔ Keep code modular: separate `isSafe()` and backtracking logic.

---

✅ 6. Related Concepts

- Backtracking
- Bitmasking
- Recursion
- Constraint Satisfaction Problems (CSP)

🧠 Example: Sudoku solver, graph coloring

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Common in backtracking interviews
- Bitmasking solution impresses interviewers

🏢 Real-world:

- Scheduling resources under constraints
- Circuit board layout placement

---

✅ 8. Common Errors & Debugging

❌ Forgetting to reset board[row][col] = '.' ❌ Invalid boundary check on diagonals ❌ Incorrect bitmask logic (not shifting properly)

🧪 Debug Tip:

- Print board state at each recursion level
- Log bitmask integer values

---

✅ 9. Java Version Updates

• Java 8+ provides lambdas/streams for list transformations\
• No language-specific change needed for N-Queens logic\
• Java 14+ Records can simplify result encapsulation (if needed)

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #51
- GFG backtracking module
- HackerRank recursion problems

🏗 Apply in:

- Constraint-driven layouts (UI design)
- AI for decision pruning
- Rule-based engines

