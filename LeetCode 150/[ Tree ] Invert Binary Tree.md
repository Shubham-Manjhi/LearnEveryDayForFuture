# 🌳 LeetCode 226: Invert Binary Tree

---

## ✅ 1. Definition and Purpose

- Invert a binary tree: swap every left child with the right child recursively.
- Useful in visual tree manipulations, image mirroring, and symmetry checks.

---

## ✅ 2. Syntax and Structure

```java
public TreeNode invertTree(TreeNode root)
```
- Accepts root of the tree.
- Returns the root of the inverted binary tree.

---

## ✅ 3. Approach 1: Recursive DFS

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    // Step 1: Invert left and right subtrees
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    // Step 2: Swap them
    root.left = right;
    root.right = left;

    return root;
}
```

---

## ✅ 4. Approach 2: Iterative BFS using Queue

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();

        // Swap left and right
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;

        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
    }

    return root;
}
```

---

## ✅ 5. ASCII Diagram Example

```
Original Tree:
    4
   / \
  2   7
 / \ / \
1  3 6  9

Inverted Tree:
    4
   / \
  7   2
 / \ / \
9  6 3  1
```

---

## ✅ 6. Internal Working

- Recursively (or iteratively) traverse each node and swap its children.
- Time Complexity: O(N) — must visit all nodes.
- Space Complexity: O(H) — H is height of the tree (stack or queue).

---

## ✅ 7. Best Practices

- Choose iterative approach for very deep trees to avoid stack overflow.
- Validate the tree before modifying in-place.
- Ensure left/right pointers are reassigned.

---

## ✅ 8. Related Concepts

- Tree traversal (pre-order, level-order)
- Mirror trees
- Tree equality (used in LeetCode 100)

---

## ✅ 9. Interview & Real-world Use

- Graphics: mirroring shapes
- UI development: flip layouts
- Recursion and tree manipulation assessment in interviews

---

## ✅ 10. Common Errors & Debugging

- Forgetting to return the root
- Not swapping correctly — missing a subtree reference
- Swapping values instead of references (wrong logic)

---

## ✅ 11. Practice & Application

- LeetCode 226: Invert Binary Tree
- LeetCode 101: Symmetric Tree (compare original & mirrored)
- Binary tree manipulation exercises

---

✅ Understanding tree inversion builds recursive skills and strengthens traversal and manipulation logic — a core topic in many technical interviews.

