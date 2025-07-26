# 🌳 Depth First Search (DFS) in Java

---

## ✅ 1. Definition and Purpose

- DFS is a graph traversal algorithm that explores as far as possible along a branch before backtracking.
- Used in searching, solving puzzles (like mazes), and topological sorting.
- DFS can be applied to both trees and graphs (directed or undirected).

---

## ✅ 2. Syntax and Structure

### Recursive DFS Template (Graph)
```java
void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited, graph);
        }
    }
}
```

### DFS on Tree (Binary Tree)
```java
void dfs(TreeNode root) {
    if (root == null) return;
    System.out.println(root.val); // Pre-order
    dfs(root.left);
    dfs(root.right);
}
```

---

## ✅ 3. Practical Examples

### Example 1: DFS on Binary Tree
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

void dfs(TreeNode node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    dfs(node.left);
    dfs(node.right);
}
```

### Example 2: DFS on Graph (Adjacency List)
```java
void dfsGraph(int v, List<List<Integer>> adj, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int u : adj.get(v)) {
        if (!visited[u]) {
            dfsGraph(u, adj, visited);
        }
    }
}
```

---

## ✅ 4. Internal Working

- **Recursive**: Uses the system call stack to go deep.
- **Iterative**: Uses an explicit stack data structure.
- Time Complexity: O(V + E)
- Space Complexity: O(V) (due to visited array and recursion stack)

---

## ✅ 5. ASCII Diagram

```
Graph:

0 - 1
|   |
2 - 3

DFS(0):
Visit 0 → 1 → 3 → 2
```

---

## ✅ 6. Best Practices

- Always use a visited set/array to avoid cycles.
- Use iterative DFS if stack overflow is a concern (deep trees).
- For disconnected components, loop through all nodes.

---

## ✅ 7. Related Concepts

- Breadth First Search (BFS)
- Topological Sort
- Connected Components
- Backtracking

---

## ✅ 8. Interview & Real-world Use

- Maze Solvers (LeetCode: 695, 200)
- Pathfinding (DFS vs BFS choice)
- Topological sorting
- Finding articulation points, bridges in networks

---

## ✅ 9. Common Errors & Debugging

- Not marking nodes as visited → infinite recursion
- Modifying the graph during traversal → ConcurrentModificationException
- StackOverflowError on large trees (use iterative)

---

## ✅ 10. Java Version Notes

- Enhanced for-loops simplify traversal
- Java 8+ Streams can sometimes help in graph modeling

---

## ✅ 11. Practice and Application

- LeetCode: 200. Number of Islands, 130. Surrounded Regions
- Competitive: Grid traversal, maze escape
- Game AI: Move simulation, state space exploration

---

✅ DFS is a foundational algorithm that underpins many complex problems involving traversal and searching. Mastering recursive and iterative implementations is key to solving many interview and real-world problems.

