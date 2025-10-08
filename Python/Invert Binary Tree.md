# 🌳 226. Invert Binary Tree

---

## 📘 Problem Statement
Given the root of a binary tree, invert the tree and return its root.

**Example 1:**
```
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

**Example 2:**
```
Input: root = [2,1,3]
Output: [2,3,1]
```

**Example 3:**
```
Input: root = []
Output: []
```

**Constraints:**
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

---

## 🔄 Approach 1: Recursive DFS
This is the most intuitive way — for each node:
- Swap left and right children.
- Recursively invert left and right subtrees.

### ✅ Python Code
```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        # swap children
        root.left, root.right = root.right, root.left
        
        # recursively invert subtrees
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root
```

### 🕒 Complexity
- **Time Complexity:** O(n) → visit each node once.
- **Space Complexity:** O(h) → recursion stack (h = tree height).

---

## 🔄 Approach 2: Iterative BFS (Queue)
We can perform a **level-order traversal** using a queue and swap children iteratively.

### ✅ Python Code
```python
from collections import deque

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        queue = deque([root])
        while queue:
            node = queue.popleft()
            node.left, node.right = node.right, node.left
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return root
```

### 🕒 Complexity
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) → for queue in worst case (complete binary tree).

---

## 🔄 Approach 3: Iterative DFS (Stack)
We can also simulate recursion using a stack.

### ✅ Python Code
```python
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        stack = [root]
        while stack:
            node = stack.pop()
            node.left, node.right = node.right, node.left
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return root
```

---

## 🎯 Interview Q&A

**Q1. Why is this problem often asked in interviews?**
- It tests recursion fundamentals, tree traversal, and iterative BFS/DFS knowledge.

**Q2. Which solution should you prefer in interviews?**
- Recursive DFS is the cleanest.
- Iterative BFS/DFS shows broader knowledge.

**Q3. Can we invert in-place?**
- Yes, all solutions invert the tree in-place, requiring no extra nodes.

**Q4. What is the edge case?**
- An empty tree (`root = None`) → simply return `None`.

---

## 🚀 Key Takeaways
- Recursive DFS is simplest for tree problems.
- BFS/DFS iterative approaches are useful if recursion depth is a concern.
- Problem helps test swapping logic, recursion, and traversal strategies.

---

✅ Now your binary tree is fully inverted! 🎉

