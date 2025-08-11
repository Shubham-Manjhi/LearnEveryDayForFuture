# 📘 LeetCode 104: Maximum Depth of Binary Tree

---

## ✅ 0. Question

Given the root of a binary tree, return its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Example:
```text
Input: root = [3,9,20,null,null,15,7]
Output: 3
Explanation: The longest path is 3 -> 20 -> 15 or 3 -> 20 -> 7
```

---

## ✅ 1. Definition and Purpose

- This problem asks us to measure the longest path from the root to any leaf node in a binary tree.
- It's a classic example of recursion and binary tree traversal.
- It helps understand depth-first search and stack/recursion behavior in Java.

---

## ✅ 2. Syntax and Structure

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public int maxDepth(TreeNode root);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Recursive DFS (Top-down)
```java
public int maxDepth(TreeNode root) {
    // Base case: empty tree has depth 0
    if (root == null) return 0;

    // Step 1: Recursively get left and right depths
    int left = maxDepth(root.left);   // depth of left subtree
    int right = maxDepth(root.right); // depth of right subtree

    // Step 2: Return the maximum + 1 for current node
    return 1 + Math.max(left, right);
}
```

🕟 Time Complexity: O(n) — visit each node once  
📂 Space Complexity: O(h) — height of tree due to recursion stack

### 🔹 Approach 2: Iterative BFS (Level Order Traversal)
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;

    // Step 1: Level-order traversal using queue
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode current = queue.poll();
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        // Step 2: Increment depth after processing a level
        depth++;
    }

    return depth;
}
```

🕟 Time Complexity: O(n)  
📂 Space Complexity: O(w) — width of tree (max number of nodes at any level)

---

## ✅ 4. Internal Working

- Recursive DFS builds the result from bottom-up.
- BFS uses a queue to traverse level by level and count layers.

### ASCII Diagram:
```text
      3
     / \
    9  20
       / \
      15  7
```
DFS recurses to leaves and returns 1 + max(left, right)  
BFS processes levels one by one and increments depth after each layer

---

## ✅ 5. Best Practices
- Use recursion for elegance in tree traversal
- BFS is better when you want shortest paths or per-level logic

---

## ✅ 6. Related Concepts
- DFS, BFS
- Recursion and Queue usage

---

## ✅ 7. Interview & Real-world Use
- Helps with directory structure traversal
- Used to measure nested JSON/XML structures

---

## ✅ 8. Common Errors & Debugging
- Forgetting base case for null
- Confusing height with number of edges instead of nodes

---

## ✅ 9. Java Version Updates
- Java 8+: Functional BFS possible using streams

---

## ✅ 10. Practice and Application
- LeetCode 111: Minimum Depth of Binary Tree
- LeetCode 543: Diameter of Binary Tree
- LeetCode 226: Invert Binary Tree

