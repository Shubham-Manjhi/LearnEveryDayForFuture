# 📘 LeetCode 63: Unique Paths II

---

## ✅ 0. Question with Explanation
You are given an m x n integer array `obstacleGrid`. There is a robot initially located at the top-left corner (i.e., `obstacleGrid[0][0]`). The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner (i.e., `obstacleGrid[m - 1][n - 1]`).

An obstacle and space are marked as `1` and `0` respectively in the grid. A path that the robot takes cannot pass through obstacles.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming on a 2D grid with constraints (obstacles).
- **Why it exists**: To calculate the number of ways to reach a destination in a grid when some cells are blocked.
- **Problem it solves**: Real-world pathfinding problems in maps, robotics, logistics, and game development.

---

## ✅ 2. Syntax and Structure

```java
public int uniquePathsWithObstacles(int[][] obstacleGrid);
```

- Input: 2D integer array `obstacleGrid` where 1 = obstacle, 0 = free cell
- Output: Integer representing the number of unique paths

---

## ✅ 3. Practical Examples

```java
Input: obstacleGrid = [
  [0,0,0],
  [0,1,0],
  [0,0,0]
];
Output: 2

Paths:
1. Right → Right → Down → Down
2. Down → Down → Right → Right
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: DP with 2D Matrix
- Time: O(m * n)
- Space: O(m * n)

```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1) return 0;

    int[][] dp = new int[m][n];
    dp[0][0] = 1;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                dp[i][j] = 0; // obstacle
            } else {
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
    }
    return dp[m - 1][n - 1];
}
```

### ✅ Approach 2: Space Optimized (1D DP Array)
- Time: O(m * n)
- Space: O(n)

```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];
    dp[0] = grid[0][0] == 0 ? 1 : 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                dp[j] = 0;
            } else if (j > 0) {
                dp[j] += dp[j - 1];
            }
        }
    }
    return dp[n - 1];
}
```

---

## ✅ 5. Best Practices
- Always check if the start or end cells are blocked.
- Avoid redundant memory usage — use space optimization.
- Add null/empty grid checks in production code.

---

## ✅ 6. Related Concepts
- Dynamic Programming (Tabulation)
- Grid-based algorithms
- Combinatorics with constraints
- BFS in pathfinding (alternative approach if grid weights vary)

---

## ✅ 7. Interview & Real-world Use
- Common interview question to test dynamic programming and grid traversal logic.
- Used in robotics navigation, maze solvers, and traffic routing.

---

## ✅ 8. Common Errors & Debugging
- Forgetting to check for obstacle at start/end.
- Not resetting dp[j] to 0 on encountering an obstacle.
- Off-by-one index errors.

---

## ✅ 9. Java Version Updates
- No direct impact of Java version; however, in Java 8+ you could use Streams for compact code (not recommended for performance-critical code).

---

## ✅ 10. Practice and Application
- LeetCode 63, 62 (no obstacle version)
- HackerRank Grid Paths
- Extend to diagonal movement / weighted grids

---

