# 🌲 LeetCode 222: Count Complete Tree Nodes

---

## ✅ 1. Definition and Purpose

- Given the root of a complete binary tree, return the number of the nodes in the tree.
- A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled and all nodes are as far left as possible.
- Goal: Return the total number of nodes efficiently.

---

## ✅ 2. Syntax and Structure

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public int countNodes(TreeNode root)
```

---

## ✅ 3. Approach 1: Simple DFS Traversal

```java
public int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

- Time: O(n)
- Space: O(h), due to recursion stack

---

## ✅ 4. Approach 2: Optimized Binary Search + Tree Height

```java
public int countNodes(TreeNode root) {
    if (root == null) return 0;

    int leftDepth = getLeftDepth(root);
    int rightDepth = getRightDepth(root);

    if (leftDepth == rightDepth) {
        // It's a perfect tree
        return (1 << leftDepth) - 1;
    } else {
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

private int getLeftDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
        depth++;
        node = node.left;
    }
    return depth;
}

private int getRightDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
        depth++;
        node = node.right;
    }
    return depth;
}
```

- Time: O(logN * logN)
- Space: O(logN)

---

## ✅ 5. ASCII Tree Diagram

```
         1
       /   \
      2     3
     / \   /
    4   5 6

Total nodes = 6
```

---

## ✅ 6. Internal Working

- DFS simply traverses all nodes.
- Optimized approach calculates depth on both sides. If equal, the tree is perfect and node count = 2^depth - 1.
- Recursively handles subtrees otherwise.

---

## ✅ 7. Best Practices

- Use bit shifting for 2^depth for performance.
- Always check base cases (null root).
- Consider optimized approach for large trees.

---

## ✅ 8. Related Concepts

- Complete Binary Tree
- Tree Height
- Bit Manipulation
- Recursion

---

## ✅ 9. Interview & Real-world Use

- Tree processing problems
- Storage layout problems (heap simulation)
- Often appears as a twist on binary search + recursion

---

## ✅ 10. Common Errors & Debugging

- Confusing complete vs full tree
- Incorrect base case
- Off-by-one in depth calculation
- Forgetting to use bit-shifting in final formula

---

## ✅ 11. Practice and Application

- LeetCode 222: Count Complete Tree Nodes
- LeetCode 110: Balanced Binary Tree
- LeetCode 199: Binary Tree Right Side View

---

✅ Understanding complete binary trees and optimizing recursive solutions with height and depth logic can significantly improve performance!

