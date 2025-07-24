**LeetCode 909: Snakes and Ladders**

---

### 1. Problem Statement

You are given an `n x n` board where each square is labeled from 1 to n² in a Boustrophedon style (alternating left-to-right and right-to-left in each row).

Each cell may contain a **ladder** or **snake** that moves the player to a different square. You start at square 1 and want to reach square `n²` in the **fewest number of moves**. On each turn, you roll a die (1 to 6) and move forward. If the destination has a ladder or snake, you must move to the destination.

Return the minimum number of moves to reach the end, or -1 if unreachable.

---

### 2. Purpose and Real Use

- Simulates board games and grid transformations
- Graph shortest path problem on an implicit graph

---

### 3. Key Observations

- The board is essentially a graph
- Each cell is a node, and dice rolls define edges
- Use **BFS** to find the shortest path from cell 1 to n²

---

### 4. Java Code (BFS)

```java
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6 && curr + dice <= n * n; dice++) {
                    int next = curr + dice;
                    int[] pos = getCoordinates(next, n);
                    if (board[pos[0]][pos[1]] != -1) {
                        next = board[pos[0]][pos[1]];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
```

---

### 5. ASCII Diagram (Flattened)

```
36 ← 35 ← 34 ← 33 ← 32 ← 31
25 → 26 → 27 → 28 → 29 → 30
24 ← 23 ← 22 ← 21 ← 20 ← 19
13 → 14 → 15 → 16 → 17 → 18
12 ← 11 ← 10 ←  9 ←  8 ←  7
 1 →  2 →  3 →  4 →  5 →  6
```

**BFS levels**: Starting at 1, roll dice → move to 2\~7 → then queue new cells from there

---

### 6. Complexity

- **Time:** O(n²) since each cell is visited once
- **Space:** O(n²) for visited and queue

---

### 7. Edge Cases

- All cells are -1 (no snakes/ladders)
- Ladder leads backward → treat like normal jump
- Multiple paths: BFS ensures shortest is found

---

### 8. Best Practices

- Flatten board to simplify access (optional)
- Always use `visited[]` to prevent cycles
- Convert between 1D → 2D carefully using Boustrophedon rule

---

### 9. Related Concepts

- BFS on grid
- Graph traversal with transformation
- Encoding/decoding positions

---

### 10. Practice More

- LeetCode 773: Sliding Puzzle
- LeetCode 542: 01 Matrix
- LeetCode 286: Walls and Gates
- LeetCode 1091: Shortest Path in Binary Matrix

