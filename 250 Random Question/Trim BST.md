## 🌳 LeetCode 669 — Trim a Binary Search Tree

---

### 🎯 Problem Statement

Given the root of a **Binary Search Tree (BST)** and two integers `low` and `high`, return the **BST after trimming** so that all its elements lie within `[low, high]`.

The trimming should not change the **relative structure** of the remaining elements — meaning the result should still be a valid BST.

**Example:**
```
Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
```

---

### 💡 Intuition

A Binary Search Tree has the property:
- Left subtree contains values smaller than the root.
- Right subtree contains values greater than the root.

So, when we encounter:
- **Node < low:** all nodes in its left subtree will also be < low → we move to the **right subtree**.
- **Node > high:** all nodes in its right subtree will also be > high → we move to the **left subtree**.
- Otherwise, the node lies within range `[low, high]` → we **keep** it and trim both subtrees.

---

### 🧩 Pseudocode

```
FUNCTION trimBST(node, low, high):
    IF node IS NULL:
        RETURN NULL

    IF node.value < low:
        RETURN trimBST(node.right, low, high)

    IF node.value > high:
        RETURN trimBST(node.left, low, high)

    node.left = trimBST(node.left, low, high)
    node.right = trimBST(node.right, low, high)

    RETURN node
```

---

### 🔁 Flowchart of Pseudocode

```
        ┌────────────────────┐
        │   Start (node)     │
        └───────┬────────────┘
                │
         ┌──────▼───────┐
         │ node == NULL │
         └──────┬───────┘
                │Yes
                ▼
         Return NULL
                ▲
                │No
        ┌───────┴────────┐
        │ node.val < low │
        └───────┬────────┘
                │Yes
                ▼
 Return trimBST(node.right)
                ▲
                │No
        ┌───────┴────────┐
        │ node.val > high│
        └───────┬────────┘
                │Yes
                ▼
 Return trimBST(node.left)
                ▲
                │No
     ┌──────────┴──────────┐
     │ Recurse both sides  │
     │ trim left & right   │
     └──────────┬──────────┘
                │
                ▼
            Return node
```

---

### 🧠 Step-by-Step Explanation

1. **Base Case:** If the node is `null`, return `null` (end of tree path).
2. **If value < low:** Since the entire left subtree will be smaller, discard it. Move to the right subtree.
3. **If value > high:** Since the entire right subtree will be larger, discard it. Move to the left subtree.
4. **If value within [low, high]:** The node is valid.
   - Recursively trim its left and right subtrees.
   - Link them back to the node.
5. Return the trimmed node as the valid root.

---

### 💻 Java Code

```java
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low)
            return trimBST(root.right, low, high);

        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
```

---

### 📊 Complexity Analysis

| Aspect | Complexity | Explanation |
|--------|-------------|--------------|
| Time Complexity | O(N) | Each node is visited once. |
| Space Complexity | O(H) | Due to recursive call stack; H = height of tree. |

For a balanced tree: `O(log N)` space.  
For a skewed tree: `O(N)` space.

---

### 💬 Interview Insights

- This is a **recursive traversal problem** exploiting BST properties.
- You only need to visit each node once, pruning unnecessary branches early.
- An **iterative solution** using a stack is possible but less intuitive.
- Common follow-up: Modify logic to **count** trimmed nodes.

---

### 🧾 Key Takeaways

- Understand BST property for efficient pruning.
- Recursive approach gives a clean and readable solution.
- Always check base conditions first.
- This problem is a great test of **tree recursion mastery** and **BST intuition**.

