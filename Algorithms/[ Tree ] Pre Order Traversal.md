# 🌲 Pre-order Traversal of Binary Tree

---

## ✅ 1. Definition and Purpose

- Pre-order traversal visits nodes in the order: Root → Left → Right.
- Used in tree serialization, copying, and expression tree evaluation.
- It helps in building or recreating binary trees from traversal data.

---

## ✅ 2. Syntax and Structure

```java
void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " "); // Visit root
    preorder(root.left);
    preorder(root.right);
}
```

---

## ✅ 3. Iterative Pre-order Traversal

```java
void preorderIterative(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " ");
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
```

---

## ✅ 4. ASCII Diagram

```
      1
     / \
    2   3
   / \
  4   5

Pre-order: 1 2 4 5 3
```

---

## ✅ 5. Internal Working

- Stack/recursion is used to track traversal path.
- Visit root, then explore left subtree, then right.
- Recursive calls are internally managed via system stack.

---

## ✅ 6. Best Practices

- Use recursion for clarity, iteration for large trees.
- Pre-order is ideal for problems that need root-first decision.
- Don’t forget to check for null nodes to avoid NullPointerException.

---

## ✅ 7. Related Concepts

- In-order, Post-order, Level-order Traversal
- Tree serialization and deserialization
- Depth First Search (DFS)

---

## ✅ 8. Interview & Real-world Use

- Expression evaluation trees
- Serialization: convert tree to array or string
- UI rendering trees (DOM traversal)

---

## ✅ 9. Common Errors & Debugging

- Pushing right child before left in iterative approach
- Forgetting to handle null roots
- Not printing root before children

---

## ✅ 10. Java Version Notes

- Use Stack<TreeNode> from java.util for non-recursive approach
- Java 8+ Streams not commonly used for traversal logic

---

## ✅ 11. Practice & Application

- LeetCode 144. Binary Tree Preorder Traversal
- Tree-based coding interviews
- Tree exploration and hierarchy representation

---

✅ Mastering pre-order traversal provides a foundation for manipulating trees, recursive algorithms, and efficient structure representation.

