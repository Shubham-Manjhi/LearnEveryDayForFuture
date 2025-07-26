# 🌊 LeetCode 200. Number of Islands

---

## ✅ 1. Definition and Purpose

- Problem: Count the number of connected land components (islands) in a 2D grid of '1's (land) and '0's (water).
- Purpose: Demonstrates traversal of connected components using DFS or BFS.
- Use Case: Mapping, flood-fill algorithms, connectivity problems in graphs.

---

## ✅ 2. Syntax and Structure

### Function Signature
```java
public int numIslands(char[][] grid)
```

### Traversal Directions
```java
int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}; // Right, Down, Left, Up
```

---

## ✅ 3. Practical Examples

### Input Grid
```
11110
11010
11000
00000
```
Output: 1 (One connected island)

```
11000
11000
00100
00011
```
Output: 3 (Three islands)

### DFS Code
```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
                dfs(grid, i, j);
                count++;
            }
        }
    }
    return count;
}

void dfs(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
    grid[i][j] = '0'; // mark as visited
    dfs(grid, i+1, j);
    dfs(grid, i-1, j);
    dfs(grid, i, j+1);
    dfs(grid, i, j-1);
}
```

---

## ✅ 4. Internal Working

- DFS visits each cell and its neighbors recursively.
- Each time DFS is triggered, it floods the island.
- After all land is marked visited, the main loop continues.

Time Complexity: O(M × N)  
Space Complexity: O(M × N) in worst case for recursive stack

---

## ✅ 5. ASCII Diagram

```
Input Grid:
[
 [1,1,0,0,0],
 [1,1,0,0,0],
 [0,0,1,0,0],
 [0,0,0,1,1]
]

Flooding Process:
DFS(0,0) ➝ marks connected 1's to 0
DFS(2,2) ➝ another island
DFS(3,3) ➝ another island
```

---

## ✅ 6. Best Practices

- Use DFS for recursion; BFS can avoid stack overflow.
- Modify grid in-place if allowed to save space.
- Otherwise, use a visited[][] boolean array.

---

## ✅ 7. Related Concepts

- Connected Components
- DFS/BFS
- Flood Fill
- Graph traversal on grid

---

## ✅ 8. Interview & Real-world Use

- Common in tech interviews
- Flood simulation
- Image processing (blob detection)
- Maze exploration

---

## ✅ 9. Common Errors & Debugging

- Missing visited check → stack overflow / infinite loop
- Not marking visited correctly → over-counting islands
- Forgetting edge checks in DFS

---

## ✅ 10. Java Version Updates

- No major version-specific APIs used
- Java 8: Can use lambda with BFS (optional)

---

## ✅ 11. Practice and Application

- LeetCode 695: Max Area of Island
- LeetCode 130: Surrounded Regions
- LeetCode 1020: Number of Enclaves
- Practice variants with diagonals or lakes

---

✅ Mastering DFS/BFS on grids builds a solid foundation for graph traversal and flood-fill based problems.

