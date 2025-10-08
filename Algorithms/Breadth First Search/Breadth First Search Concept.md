<!--
  DSA Java Master Curriculum — BFS Expansion
-->

# 🌳 **Breadth-First Search (BFS)**

<div style="display:flex;align-items:center;gap:12px;">
  <div style="font-size:36px">🔎</div>
  <div>
    <h2 style="margin:0">Graphs — Breadth-First Search (BFS)</h2>
    <div style="color:#666">Core traversal algorithm • Java implementation • Examples • Complexity</div>
  </div>
</div>

---

******************************************************************************************
******************** Topics: Breadth-First Search (BFS)   ********************
******************************************************************************************

## 1. Definition

- **Breadth-First Search (BFS)**: A graph traversal algorithm that explores all neighbors of a vertex before moving to the next level.
- Works on **graphs** (directed/undirected) and **trees**.
- Uses a **queue** (FIFO) to process vertices level by level.

---

## 2. Why BFS?

- Finds the **shortest path** in an unweighted graph.
- Level-order traversal of trees is a BFS.
- Useful in problems like:
  - Shortest distance in grids (mazes, puzzles).
  - Social network analysis (degrees of connection).
  - Web crawlers.
  - Minimum number of operations (transformations).

---

## 3. Key Characteristics

- **Queue-based** (FIFO).
- Each vertex is marked **visited** once.
- Traverses graph in **layers**.

---

## 4. Java Implementation — BFS on Graph

```java
import java.util.*;

class BFSGraphMain {
    /* Example Execution:
       Graph: 0 -- 1 -- 2
              |    |
              3 -- 4

       BFS starting from 0 → Output: 0 1 3 2 4
    */
    public static void main(String[] args) {
        int vertices = 5;
        BFSGraph graph = new BFSGraph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        graph.bfs(0); // Start BFS from node 0
    }
}

class BFSGraph {
    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    BFSGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src); // Undirected graph
    }

    void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
```

---

## 5. BFS on a Binary Tree (Level Order Traversal)

```java
import java.util.*;

class BFSBinaryTreeMain {
    /* Example:
       Tree:        1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
       Output: 1 2 3 4 5 6 7
    */
    public static void main(String[] args) {
        BFSBinaryTreeNode root = new BFSBinaryTreeNode(1);
        root.left = new BFSBinaryTreeNode(2);
        root.right = new BFSBinaryTreeNode(3);
        root.left.left = new BFSBinaryTreeNode(4);
        root.left.right = new BFSBinaryTreeNode(5);
        root.right.left = new BFSBinaryTreeNode(6);
        root.right.right = new BFSBinaryTreeNode(7);

        BFSBinaryTreeTraversal.levelOrder(root);
    }
}

class BFSBinaryTreeNode {
    int val;
    BFSBinaryTreeNode left, right;
    BFSBinaryTreeNode(int val) { this.val = val; }
}

class BFSBinaryTreeTraversal {
    static void levelOrder(BFSBinaryTreeNode root) {
        if (root == null) return;
        Queue<BFSBinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BFSBinaryTreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }
}
```

---

## 6. Complexity Analysis

- **Time Complexity**: `O(V + E)` (visit all vertices and edges once).
- **Space Complexity**: `O(V)` (queue + visited array).

---

## 7. BFS Variants

- **Shortest path in unweighted graph**: Track distance with an array.
- **Grid BFS**: Each cell as node, moves as edges.
- **Multi-source BFS**: Initialize queue with multiple starting points.
- **Bidirectional BFS**: From source and target simultaneously.

---

## 8. Practice Problems

**Easy**
- Level order traversal of binary tree.
- Find if a path exists between two nodes.

**Medium**
- Shortest path in a binary maze.
- Number of islands (grid BFS).

**Hard**
- Word Ladder (transform one word to another).
- Snake and Ladders minimum moves.

---

## 9. Key Points Recap

- BFS explores **level by level** using a **queue**.
- Guarantees **shortest path in unweighted graphs**.
- Works for graphs, trees, and grids.
- Complexity: `O(V+E)` time, `O(V)` space.

---

✅ **Next Option**: Do you want me to expand **Depth-First Search (DFS)** next as a pair with BFS, or continue with the **Graph module** fully (DFS, Topological Sort, Shortest Paths)?

