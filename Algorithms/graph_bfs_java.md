**Graph BFS in Java**

---

### 1. Definition and Purpose
- **What is it?** Breadth-First Search (BFS) is a graph traversal algorithm that explores nodes level by level.
- **Why BFS?** It's used for finding the shortest path in unweighted graphs, traversing components, and solving puzzle-like problems (e.g., word ladders).
- **What it Solves:**
  - Checks connectivity
  - Finds shortest paths
  - Used in cycle detection, web crawling, etc.

---

### 2. Syntax and Structure
```java
// Graph representation using adjacency list
Map<Integer, List<Integer>> graph = new HashMap<>();
Queue<Integer> queue = new LinkedList<>();
Set<Integer> visited = new HashSet<>();
```

---

### 3. BFS Template Code
```java
void bfs(int start, Map<Integer, List<Integer>> graph) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
    }
}
```

---

### 4. Example Input & BFS Flow
Graph:
```
    1
   / \
  2   3
 /     \
4       5
```
Adjacency List:
```java
{
  1: [2, 3],
  2: [4],
  3: [5],
  4: [],
  5: []
}
```
**BFS starting from 1:** `1 → 2 → 3 → 4 → 5`

ASCII Visualization:
```
Queue: [1]
Visited: {1}
→ Pop 1, add 2 and 3
Queue: [2, 3]
→ Pop 2, add 4
Queue: [3, 4]
→ Pop 3, add 5
Queue: [4, 5]
→ Pop 4
Queue: [5]
→ Pop 5
```

---

### 5. Time and Space Complexity
- **Time:** O(V + E), where V = nodes, E = edges
- **Space:** O(V) for visited + queue

---

### 6. Use Cases
- Shortest path in unweighted graphs
- Level order traversal of trees
- Connected components
- Finding cycles

---

### 7. Best Practices
- Use `Set<Integer>` to track visited nodes
- For weighted graphs, use Dijkstra instead of BFS
- For multi-source BFS, enqueue all starting nodes initially

---

### 8. Related Concepts
- DFS (Depth-First Search)
- Dijkstra's Algorithm
- Topological Sort
- Bi-directional BFS

---

### 9. Interview Tips
- Be clear about visited tracking to avoid infinite loops
- Mention edge cases (disconnected graph, empty input)
- Use adjacency list for sparse graphs

---

### 10. Practice Problems
- LeetCode 200: Number of Islands
- LeetCode 286: Walls and Gates
- LeetCode 1091: Shortest Path in Binary Matrix
- LeetCode 127: Word Ladder

