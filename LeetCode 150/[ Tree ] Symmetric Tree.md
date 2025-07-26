# 🌳 LeetCode 101: Symmetric Tree

---

## ✅ 1. Definition and Purpose

- Determine whether a binary tree is a mirror of itself (symmetric around its center).
- Important in parsing symmetric expressions, layout mirroring, and recursive tree validation.

---

## ✅ 2. Syntax and Structure

```java
public boolean isSymmetric(TreeNode root)
```
- Returns true if the tree is symmetric.

---

## ✅ 3. Approach 1: Recursive Mirror Check

```java
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}

private boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null || t1.val != t2.val) return false;
    return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
}
```

---

## ✅ 4. Approach 2: Iterative using Queue

```java
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root.left);
    queue.offer(root.right);

    while (!queue.isEmpty()) {
        TreeNode t1 = queue.poll();
        TreeNode t2 = queue.poll();

        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        queue.offer(t1.left);
        queue.offer(t2.right);
        queue.offer(t1.right);
        queue.offer(t2.left);
    }

    return true;
}
```

---

## ✅ 5. ASCII Diagram Example

```
Symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

Asymmetric:
    1
   / \
  2   2
   \   \
   3    3
```

---

## ✅ 6. Internal Working

- Mirror the left and right subtree at every level.
- Recursive: call mirror(left, right).
- Iterative: use a queue to compare opposite children.
- Time Complexity: O(N), Space: O(H) (stack or queue).

---

## ✅ 7. Best Practices

- Null checks before value comparison.
- Use iterative for deep trees.
- Avoid reversing nodes manually.

---

## ✅ 8. Related Concepts

- Invert Binary Tree (226)
- Tree Traversals (DFS, BFS)
- Palindrome logic in trees

---

## ✅ 9. Interview & Real-world Use

- Validate layout mirror symmetry
- Useful in JSON/XML comparison engines
- Recursion mastery test in interviews

---

## ✅ 10. Common Errors & Debugging

- Incorrect order of comparisons (left vs right symmetry)
- Skipping null checks
- Assuming both subtrees share structure

---

## ✅ 11. Practice & Application

- LeetCode 101: Symmetric Tree
- Mirror image validation in UI rendering
- Tree mirroring logic simulation

---

✅ Symmetric Tree problem strengthens the ability to visualize trees and apply recursive symmetry patterns essential in many structural comparison tasks.

