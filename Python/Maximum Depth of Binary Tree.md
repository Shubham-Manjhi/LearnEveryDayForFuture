# 🎯 **104. Maximum Depth of Binary Tree** 🌳🐍

---

## 🔹 Introduction

The problem **"Maximum Depth of Binary Tree"** is a classic LeetCode question (No. 104). It asks us to determine the maximum depth (or height) of a binary tree. This is one of the most frequently asked interview questions, testing understanding of **recursion, depth-first search (DFS), and breadth-first search (BFS)**.

- **Problem Statement**: Given the `root` of a binary tree, return its maximum depth.
- **Definition of Depth**: The number of nodes along the longest path from the root node down to the farthest leaf node.

---

## 🔹 **Subtopic 1: Understanding the Problem** 💡

### 📘 Explanation

- Depth of a single-node tree = 1.
- Depth of an empty tree = 0.
- Depth of a general tree = `1 + max(depth(left), depth(right))`.

### ❓ Interview Q&A

**Q1: What is the difference between depth and height of a tree?**

- Both terms are often used interchangeably.
- Height = length of longest path from root to a leaf.

**Q2: Can this problem be solved iteratively?**

- Yes, using BFS with a queue.

---

## 🔹 **Subtopic 2: Recursive DFS Solution** 🔄

### 📘 Explanation

- Use recursion to compute the maximum depth.
- Formula: `maxDepth(root) = 1 + max(maxDepth(root.left), maxDepth(root.right))`.

### 🐍 Example (Recursive Solution)

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

# Example Tree: [3,9,20,null,null,15,7]
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20, TreeNode(15), TreeNode(7))

print(Solution().maxDepth(root))  # Output: 3
```

### ❓ Interview Q&A

**Q: Why is recursion a natural fit here?**

- Because the tree problem breaks into smaller subtrees naturally.

---

## 🔹 **Subtopic 3: Iterative BFS Solution** 🔁

### 📘 Explanation

- Use a queue to traverse level by level.
- Each level increases depth by 1.

### 🐍 Example (BFS Solution)

```python
from collections import deque

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        depth = 0
        queue = deque([root])
        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return depth

# Output for same tree: 3
```

### ❓ Interview Q&A

**Q: Which is better, DFS or BFS?**

- DFS (recursion) is simpler.
- BFS is useful when explicitly asked for level order.

---

## 🔹 **Subtopic 4: Edge Cases** ⚠️

- Empty Tree → Output = 0.
- Single Node Tree → Output = 1.
- Skewed Tree (like a linked list) → Output = `n`.
- Perfect Binary Tree → Depth = `log2(n+1)`.

### 🐍 Example (Skewed Tree)

```python
root = TreeNode(1)
root.right = TreeNode(2)
root.right.right = TreeNode(3)

print(Solution().maxDepth(root))  # Output: 3
```

---

## 🔹 **Subtopic 5: Time and Space Complexity** ⏱️

### 📘 Analysis

- **Time Complexity**: O(n) → Every node is visited once.
- **Space Complexity**:
  - DFS recursion: O(h) (where h = tree height).
  - BFS queue: O(w) (where w = max width of tree).

### ❓ Interview Q&A

**Q: What is the worst-case space complexity for DFS?**

- O(n), when the tree is skewed.

---

## 🔹 **Subtopic 6: Related Problems** 🔗

- Minimum Depth of Binary Tree (LeetCode 111).
- Balanced Binary Tree (LeetCode 110).
- Diameter of Binary Tree (LeetCode 543).
- Same Tree (LeetCode 100).

---

## 🎯 **Conclusion** 🏆

- Maximum Depth of Binary Tree is a fundamental problem in recursion and tree traversal.
- Two main solutions:
  - **DFS (Recursive)** → Elegant, natural for trees.
  - **BFS (Iterative)** → Useful for level-wise traversal.
- Understanding this builds a foundation for tackling more complex tree problems.

