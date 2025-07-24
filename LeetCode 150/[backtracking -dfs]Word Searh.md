**Java Topic: LeetCode 79 - Word Search**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given a 2D board and a word, check if the word exists in the grid using horizontal and vertical adjacent letters. Letters may not be reused.

• Why does it exist in Java?\
This problem teaches grid traversal with backtracking, DFS, and visited-state tracking.

• What problem does it solve?\
It simulates search problems such as pathfinding, pattern matching, and maze solving.

🧠 Example: Search for word "ABCCED" in a board:
```
A B C E
S F C S
A D E E
```
Returns true.

---

✅ 2. Syntax and Structure

• Define `boolean exist(char[][] board, String word)`\
• Use recursive DFS with backtracking to search the grid.

---

✅ 3. Practical Examples

🔹 Approach 1: DFS with Backtracking

```java
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found = dfs(board, word, i+1, j, idx+1) ||
                        dfs(board, word, i-1, j, idx+1) ||
                        dfs(board, word, i, j+1, idx+1) ||
                        dfs(board, word, i, j-1, idx+1);

        board[i][j] = temp; // unmark
        return found;
    }
}
```

🖼️ ASCII Diagram – Recursive DFS:
```
Start at cell (0,0): 'A'
   A  B  C  E
-> S  F  C  S
   A  D  E  E

A → B → C → C → E → D
```
Explanation:
- DFS explores 4 directions recursively.
- Uses marking '#' to avoid revisiting.

🔹 Approach 2: Optimized DFS with Word Pruning (using Trie – for multiple word searches)
Useful for Word Search II but conceptually related for scalability.

---

✅ 4. Internal Working

• DFS explores each valid path recursively.\
• Visited cells are marked temporarily to avoid cycles.\
• Backtracking unmarks cells upon return.

Time Complexity: O(m * n * 4^L) where L = length of word

Space Complexity: O(L) for recursion stack

---

✅ 5. Best Practices

✔ Use temp variable to mark visited (not extra array)\
✔ Always unmark cells during backtrack\
✔ Return early when match found

---

✅ 6. Related Concepts

- DFS / Backtracking
- Grid traversal
- Maze solving

🧠 Example: Sudoku, Island Counting, Knight’s Tour

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Tests recursion and 2D array manipulation

🏢 Real-world:
- OCR pattern matching\
- Word/path validation in puzzles

---

✅ 8. Common Errors & Debugging

❌ Reusing the same cell twice\
❌ Not backtracking properly\
❌ Out-of-bound checks missed

🧪 Debug Tip:
- Print board state at each call\
- Use stack traces to debug call flow

---

✅ 9. Java Version Updates

• Java 8+: Functional utilities not typically used here\
• Java 11+: Efficient char[] string methods, but core logic unchanged

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #79\
- Word Search II (LeetCode #212)

🏗 Apply in:
- Puzzle games\
- Search algorithms\
- Input gesture/path validation

