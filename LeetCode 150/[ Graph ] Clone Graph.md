# 🔁 LeetCode 133: Clone Graph

---

## ✅ 1. Definition and Purpose

- Given a reference node of a connected undirected graph, return a deep copy (clone) of the graph.
- Every node contains a value and a list of its neighbors.
- Purpose: Tests understanding of graph traversal and copy with hash mapping.

---

## ✅ 2. Syntax and Structure

### Node Class Definition (LeetCode)
```java
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
```

### Function Signature
```java
public Node cloneGraph(Node node)
```

---

## ✅ 3. Two Approaches: DFS and BFS

### 🔹 DFS (Recursive)
```java
Map<Node, Node> visited = new HashMap<>();

public Node cloneGraph(Node node) {
    if (node == null) return null;
    if (visited.containsKey(node)) return visited.get(node);

    Node clone = new Node(node.val);
    visited.put(node, clone);
    for (Node neighbor : node.neighbors) {
        clone.neighbors.add(cloneGraph(neighbor));
    }
    return clone;
}
```

### 🔹 BFS (Queue)
```java
public Node cloneGraph(Node node) {
    if (node == null) return null;

    Map<Node, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    map.put(node, new Node(node.val));

    while (!queue.isEmpty()) {
        Node curr = queue.poll();
        for (Node neighbor : curr.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new Node(neighbor.val));
                queue.offer(neighbor);
            }
            map.get(curr).neighbors.add(map.get(neighbor));
        }
    }
    return map.get(node);
}
```

---

## ✅ 4. ASCII Diagram: Sample Graph

```
Graph:
   1
  / \
 2   4
 |   |
 3---+

cloneGraph(1): DFS/BFS traverses and clones nodes and their edges
```

---

## ✅ 5. Internal Working

- DFS uses recursion and hash map for visited.
- BFS uses queue and map to build iteratively.
- Each node is visited once: O(N + E) time.

Time: O(N + E)  
Space: O(N) for visited map

---

## ✅ 6. Best Practices

- Always store visited clones to prevent infinite cycles.
- Do not clone neighbor if already cloned.
- Validate null or empty input early.

---

## ✅ 7. Related Concepts

- Deep Copy vs Shallow Copy
- Graph Traversal: DFS/BFS
- HashMap, Queue

---

## ✅ 8. Interview & Real-world Use

- Common in graph-related interviews
- Useful in object deep cloning
- Cloning structures like org charts, social networks

---

## ✅ 9. Common Errors & Debugging

- Forgetting to map original to clone → duplicated/missing nodes
- Infinite recursion in cycles
- Shallow copy of neighbors list

---

## ✅ 10. Java Version Updates

- Java 8+: Enhanced for-loops and Lambdas may improve readability

---

## ✅ 11. Practice and Application

- LeetCode 133: Clone Graph
- LeetCode 138: Copy List with Random Pointer
- Variants with graph copy and mutation

---

✅ Cloning graphs is a classic way to test your understanding of traversal and state preservation. Choose DFS for simplicity or BFS for iterative clarity!

