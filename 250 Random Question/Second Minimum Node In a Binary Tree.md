## 🌲 LeetCode 671 — Second Minimum Node in a Binary Tree

---

### 🎯 Problem Statement

Given a **special binary tree** where every node has either two or zero children, and for every parent node:

```
root.val <= root.left.val
root.val <= root.right.val
```

Find the **second smallest value** in the tree. If it does not exist, return `-1`.

**Example:**
```
Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, and the second smallest is 5.
```

---

### 💡 Intuition

The root node always holds the **minimum value** due to the tree property. To find the **second minimum**, we look for the **smallest value greater than root.val** in the tree.

Approach:
- Traverse all nodes.
- Track the **minimum value** (root value) and a **candidate second minimum**.
- If a node's value is greater than the root value, update the candidate.
- Return the smallest valid candidate found.

---

### 🧩 Pseudocode

```
FUNCTION findSecondMinimumValue(node):
    IF node IS NULL:
        RETURN -1

    rootVal = node.val
    RETURN DFS(node, rootVal)

FUNCTION DFS(node, minVal):
    IF node IS NULL:
        RETURN -1

    IF node.val > minVal:
        RETURN node.val

    left = DFS(node.left, minVal)
    right = DFS(node.right, minVal)

    IF left == -1:
        RETURN right
    IF right == -1:
        RETURN left

    RETURN MIN(left, right)
```

---

### 🔁 Flowchart of Pseudocode

```
           ┌─────────────────────────┐
           │       Start (root)      │
           └──────────┬──────────────┘
                      │
               root == NULL ?
                      │
               ┌──────▼───────┐
               │   Return -1  │
               └──────┬───────┘
                      │
                DFS(root, root.val)
                      │
           ┌──────────▼──────────┐
           │ node == NULL ?      │
           └──────────┬──────────┘
                      │Yes
                      ▼
                 Return -1
                      ▲
                      │No
          ┌───────────┴───────────┐
          │ node.val > minVal ?   │
          └──────────┬───────────┘
                      │Yes
                      ▼
              Return node.val
                      ▲
                      │No
      ┌───────────────┴──────────────┐
      │ Recurse left and right       │
      └───────────────┬──────────────┘
                      │
          ┌───────────▼────────────┐
          │Combine & return min > -1│
          └─────────────────────────┘
```

---

### 🧠 Step-by-Step Explanation

1. **Start at root:** The root value is always the smallest.
2. **DFS Traversal:** Recursively explore all nodes.
3. **Compare values:**
   - If a node value > root value → potential second minimum.
   - If not, continue exploring children.
4. **Combine results:** Use recursive returns to gather potential candidates and choose the smaller valid one.
5. If no candidate found, return `-1`.

---

### 💻 Java Code

```java
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int minVal) {
        if (node == null) return -1;

        if (node.val > minVal) return node.val;

        int left = dfs(node.left, minVal);
        int right = dfs(node.right, minVal);

        if (left == -1) return right;
        if (right == -1) return left;

        return Math.min(left, right);
    }
}
```

---

### 📊 Complexity Analysis

| Aspect | Complexity | Explanation |
|--------|-------------|-------------|
| Time Complexity | O(N) | Visits each node once |
| Space Complexity | O(H) | Recursive stack, H = height of tree |

---

### 💬 Interview Insights

- Key observation: The **root** holds the **minimum value**.
- You only need to track **values greater than root.val**.
- Avoid using extra data structures; recursion is clean.
- Edge case: All nodes have same value → return `-1`.

---

### 🧾 Key Takeaways

- Utilize the BST-like property (root is smallest) to limit search.
- DFS recursion is efficient and readable.
- Handles edge cases gracefully without additional data structures.
- Reinforces recursive tree traversal fundamentals.

