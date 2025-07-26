# 📘 LeetCode 210: Course Schedule II

---

## ✅ 1. Definition and Purpose

- Given `numCourses` and a list of prerequisites, return an ordering of courses such that all prerequisites are completed before a course is taken.
- If there are multiple valid orders, return any of them.
- If it’s not possible to finish all courses, return an empty array.
- Purpose: Return topological ordering for a directed graph.

---

## ✅ 2. Syntax and Structure

### Function Signature
```java
public int[] findOrder(int numCourses, int[][] prerequisites)
```

### Representation
- Use adjacency list for graph.
- Use indegree array or DFS for ordering.

---

## ✅ 3. Approach 1: BFS - Kahn’s Algorithm (Topological Sort)

```java
public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    int[] indegree = new int[numCourses];

    for (int[] pre : prerequisites) {
        graph.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }

    int[] order = new int[numCourses];
    int index = 0;

    while (!queue.isEmpty()) {
        int curr = queue.poll();
        order[index++] = curr;
        for (int next : graph.get(curr)) {
            if (--indegree[next] == 0) queue.offer(next);
        }
    }

    return index == numCourses ? order : new int[0];
}
```

---

## ✅ 4. Approach 2: DFS with Stack

```java
public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] pre : prerequisites) graph.get(pre[1]).add(pre[0]);

    boolean[] visited = new boolean[numCourses];
    boolean[] onStack = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, graph, visited, onStack, stack)) return new int[0];
    }

    int[] result = new int[numCourses];
    int i = 0;
    while (!stack.isEmpty()) result[i++] = stack.pop();
    return result;
}

private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onStack, Stack<Integer> stack) {
    if (onStack[node]) return false; // cycle
    if (visited[node]) return true;

    visited[node] = true;
    onStack[node] = true;

    for (int neighbor : graph.get(node)) {
        if (!dfs(neighbor, graph, visited, onStack, stack)) return false;
    }

    onStack[node] = false;
    stack.push(node);
    return true;
}
```

---

## ✅ 5. ASCII Diagram (Topological Sort)

```
Graph:
0 ← 1 ← 2
        ↑
        3

Order: [3,2,1,0] or any valid topological sort
```

---

## ✅ 6. Internal Working

- BFS uses queue and indegree to process nodes with no dependencies.
- DFS uses call stack and a separate tracking array to avoid cycles.
- Time: O(V + E)
- Space: O(V + E)

---

## ✅ 7. Best Practices

- Always check for cycles before accepting topological order.
- Use BFS for iterative solutions.
- Initialize graph and arrays properly.

---

## ✅ 8. Related Concepts

- Course Schedule I (207)
- Topological Sort
- DAG (Directed Acyclic Graph)
- Kahn’s Algorithm

---

## ✅ 9. Interview & Real-world Use

- Dependency Resolution
- Job Scheduling
- Build Systems (make, Maven)

---

## ✅ 10. Common Errors & Debugging

- Mistaking direction of edges in prerequisites
- Returning invalid order when cycle exists
- Forgetting to check if order size matches course count

---

## ✅ 11. Practice & Application

- LeetCode 207: Course Schedule I
- LeetCode 329: Longest Increasing Path in Matrix
- Competitive programming problems with prerequisites

---

✅ Mastering topological sorting and cycle detection is critical in managing dependencies, compilers, build tools, and academic scheduling systems!

