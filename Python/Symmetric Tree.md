# 🌳 101. Symmetric Tree

---

## 📘 Problem Statement

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

**Example 1:**

```
Input: root = [1,2,2,3,4,4,3]
Output: true
```

**Example 2:**

```
Input: root = [1,2,2,null,3,null,3]
Output: false
```

**Constraints:**

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`

---

## 🔄 Approach 1: Recursive DFS

The tree is symmetric if:

- The left subtree is a mirror of the right subtree.
- This means:
  - `left.val == right.val`
  - `left.left` mirrors `right.right`
  - `left.right` mirrors `right.left`

### ✅ Python Code

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        def isMirror(t1, t2):
            if not t1 and not t2:
                return True
            if not t1 or not t2:
                return False
            return (t1.val == t2.val and
                    isMirror(t1.left, t2.right) and
                    isMirror(t1.right, t2.left))
        
        return isMirror(root.left, root.right)
```

### 🕒 Complexity

- **Time Complexity:** O(n) → visit each node once.
- **Space Complexity:** O(h) → recursion stack (h = tree height).

---

## 🔄 Approach 2: Iterative BFS (Queue)

We use a queue to compare nodes level by level.

### ✅ Python Code

```python
from collections import deque

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True

        queue = deque([(root.left, root.right)])
        while queue:
            t1, t2 = queue.popleft()
            if not t1 and not t2:
                continue
            if not t1 or not t2:
                return False
            if t1.val != t2.val:
                return False
            queue.append((t1.left, t2.right))
            queue.append((t1.right, t2.left))
        return True
```

### 🕒 Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n) → queue in worst case.

---

## 🔄 Approach 3: Iterative DFS (Stack)

Similar to BFS, but using a stack.

### ✅ Python Code

```python
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        stack = [(root.left, root.right)]
        while stack:
            t1, t2 = stack.pop()
            if not t1 and not t2:
                continue
            if not t1 or not t2:
                return False
            if t1.val != t2.val:
                return False
            stack.append((t1.left, t2.right))
            stack.append((t1.right, t2.left))
        return True
```

---

## 🎯 Interview Q&A

**Q1. What is the difference between checking if a tree is symmetric vs checking if two trees are identical?**

- Identical tree: both structure and values must be the same in both trees.
- Symmetric tree: one subtree is the mirror image of the other.

**Q2. Why recursion is a natural choice here?**

- Because symmetry inherently requires comparing mirrored subtrees.

**Q3. Can you solve it iteratively?**

- Yes, using BFS (queue) or DFS (stack).

**Q4. Edge cases?**

- Empty tree → symmetric.
- Single node → symmetric.

---

## 🚀 Key Takeaways

- Symmetry check = mirror property between left and right subtrees.
- Recursive DFS is elegant and concise.
- BFS/DFS iterative methods are great to avoid recursion limits.
- This problem is often followed by variations like **“Same Tree”** or **“Subtree of Another Tree.”**

