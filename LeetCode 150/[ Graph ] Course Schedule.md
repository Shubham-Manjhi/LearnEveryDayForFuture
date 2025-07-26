# 📘 LeetCode 207: Course Schedule

---

## ✅ 1. Definition and Purpose

- Given `numCourses` and a list of prerequisites, determine if it's possible to finish all courses.
- This is a classic cycle detection problem in a directed graph.
- Models real-world scheduling problems with dependency chains.

---

## ✅ 2. Syntax and Structure

### Function Signature
```java
public boolean canFinish(int numCourses, int[][] prerequisites)
```

### Graph Representation
- Build an adjacency list of course prerequisites.
- Use DFS with a visited state array to detect cycles.

---

## ✅ 3. Practical Example

### Input:
```
numCourses = 4
prerequisites = [[1,0],[2,1],[3,2]]
```

### Output: true (no cycles)

### Input:
```
numCourses = 2
prerequisites = [[1,0],[0,1]]
```

### Output: false (cycle: 0 → 1 → 0)

---

## ✅ 4. Approach 1: DFS Cycle Detection

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] pair : prerequisites) graph.get(pair[1]).add(pair[0]);

    int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

    for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, graph, visited)) return false;
    }
    return true;
}

private boolean dfs(int node, List<List<Integer>> graph, int[] visited) {
    if (visited[node] == 1) return false; // cycle
    if (visited[node] == 2) return true;  // already done

    visited[node] = 1; // mark visiting
    for (int neighbor : graph.get(node)) {
        if (!dfs(neighbor, graph, visited)) return false;
    }
    visited[node] = 2;
    return true;
}
```

---

## ✅ 5. Approach 2: Topological Sort (BFS, Kahn's Algorithm)

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

    for (int[] pre : prerequisites) {
        graph.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }

    int count = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        for (int neighbor : graph.get(course)) {
            if (--indegree[neighbor] == 0) queue.offer(neighbor);
        }
    }

    return count == numCourses;
}
```

---

## ✅ 6. ASCII Diagram (Cycle Detection)

```
   0 → 1 → 2 → 3
         ↑    ↓
         ←----
Cycle detected if you reach a node marked as "visiting"
```

---

## ✅ 7. Internal Working

- DFS: Recursively explores and marks state.
- Kahn's BFS: Uses indegree to track prerequisites.
- Time Complexity: O(V + E)
- Space: O(V + E)

---

## ✅ 8. Best Practices

- For detection only, DFS is simpler.
- For course order, prefer topological sort.
- Always track visited states or indegrees properly.

---

## ✅ 9. Related Concepts

- Topological Sort
- Directed Graphs
- Cycle Detection
- Dependency Resolution

---

## ✅ 10. Interview & Real-World Use

- Scheduling jobs with dependencies
- Package installations
- Course scheduling in universities

---

## ✅ 11. Errors & Debugging

- Mistaking direction of edges
- Not marking visiting state in DFS
- Forgetting to decrement indegree

---

## ✅ 12. Practice & Applications

- LeetCode 210: Course Schedule II (return course order)
- Graph cycle detection problems
- Build systems (makefile dependencies)

---

✅ Course scheduling requires understanding of graph theory, cycles, and ordering — vital concepts in software dependencies, scheduling, and more!

