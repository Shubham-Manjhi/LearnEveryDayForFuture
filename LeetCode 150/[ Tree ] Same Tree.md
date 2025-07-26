# 🌳 LeetCode 100: Same Tree

---

## ✅ 1. Definition and Purpose

- Determine if two binary trees are structurally identical and the nodes have the same values.
- Helps in comparing hierarchical data structures like file systems, parse trees, etc.

---

## ✅ 2. Syntax and Structure

```java
public boolean isSameTree(TreeNode p, TreeNode q)
```
- Accepts roots of two trees.
- Returns true if both trees are the same.

---

## ✅ 3. Approach 1: Recursive DFS

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    // Step 1: If both nodes are null, return true
    if (p == null && q == null) return true;

    // Step 2: If either is null or values don't match, return false
    if (p == null || q == null || p.val != q.val) return false;

    // Step 3: Recur for left and right subtrees
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```

---

## ✅ 4. Approach 2: Iterative using Queue

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(p);
    queue.offer(q);

    while (!queue.isEmpty()) {
        TreeNode node1 = queue.poll();
        TreeNode node2 = queue.poll();

        if (node1 == null && node2 == null) continue;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;

        queue.offer(node1.left);
        queue.offer(node2.left);
        queue.offer(node1.right);
        queue.offer(node2.right);
    }
    return true;
}
```

---

## ✅ 5. ASCII Diagram Example

```
Tree P:        Tree Q:
   1              1
  / \            / \
 2   3          2   3

Result: TRUE

Tree P:        Tree Q:
   1              1
  /                \
 2                  2

Result: FALSE
```

---

## ✅ 6. Internal Working

- Recursively compare each pair of nodes.
- Short-circuits on mismatch or missing nodes.
- Time Complexity: O(N) — where N is the number of nodes.
- Space Complexity: O(H) for recursion stack.

---

## ✅ 7. Best Practices

- Always check nulls first.
- Avoid unnecessary comparisons by early returns.
- Use iterative method for very deep trees to avoid StackOverflowError.

---

## ✅ 8. Related Concepts

- Tree Traversal (DFS, BFS)
- Tree Serialization & Deserialization
- Structural Equivalence

---

## ✅ 9. Interview & Real-world Use

- Comparing document trees (XML, JSON)
- Version comparison in hierarchical structures
- Used in diff utilities and data validation pipelines

---

## ✅ 10. Common Errors & Debugging

- Not handling null checks correctly
- Not comparing both left and right subtrees
- Using == instead of .equals() in generalized objects

---

## ✅ 11. Practice & Application

- LeetCode 100: Same Tree
- LeetCode 572: Subtree of Another Tree
- Compare DOM elements, AST equivalence

---

✅ Mastering tree equality check helps in developing better recursive thinking and is frequently asked in interviews for its simplicity and depth.

