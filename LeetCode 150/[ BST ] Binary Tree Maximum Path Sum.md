# 📘 LeetCode 124: Binary Tree Maximum Path Sum

---

## ✅ 0. Question

Given a non-empty binary tree, find the maximum path sum.

A path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

### Example:
```text
Input: [1,2,3]
Output: 6
Explanation: 2 → 1 → 3 is the maximum path sum.

Input: [-10,9,20,null,null,15,7]
Output: 42
Explanation: 15 → 20 → 7 is the maximum path sum.
```

---

## ✅ 1. Definition and Purpose

- The problem requires identifying a maximum path sum across any part of the binary tree.
- The path can start and end at any node and must follow parent-child connections.
- It tests advanced recursion and tree traversal concepts.

---

## ✅ 2. Syntax and Structure

```java
public int maxPathSum(TreeNode root);
```

- `TreeNode` is the standard binary tree node class.
- Returns the maximum path sum found in the binary tree.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Postorder Traversal + Recursion with Global Max

```java
class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Step 1: Recur on left & right subtree
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Step 2: Current max path including node
        int currentMaxPath = node.val + leftGain + rightGain;

        // Step 3: Update global max if needed
        maxSum = Math.max(maxSum, currentMaxPath);

        // Step 4: Return max gain to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
```

### Example Walkthrough:
```text
Tree:
      -10
     /   \
    9    20
         / \
        15  7

maxPath: 15 → 20 → 7 = 42
```

---

## ✅ 4. Internal Working

- Uses post-order traversal to compute maximum gain for each subtree.
- Left and right subtree gains are calculated.
- At each node, the possible path through it is checked against a global max.
- Only one of the gains is returned to the parent to preserve the path constraint.

---

## ✅ 5. Best Practices

- Always ignore negative path contributions using `Math.max(..., 0)`.
- Use global state to track maximum value through traversal.
- Handle base case (null nodes) early to simplify logic.

---

## ✅ 6. Related Concepts

- Binary Tree Postorder Traversal
- Divide and conquer
- Recursion with auxiliary/global state

---

## ✅ 7. Interview & Real-world Use

- Common high-difficulty problem in interviews (used by Google, Facebook, etc.)
- Real-world example: Longest profit path in hierarchy trees

---

## ✅ 8. Common Errors & Debugging

- Forgetting to clamp left/right gain with zero
- Not maintaining global max
- Returning total sum (both sides) to parent — only one side is allowed

---

## ✅ 9. Java Version Updates

- Compatible with all Java versions.
- Java 8+ lambda streams can be used for alternate solutions but not recommended for clarity.

---

## ✅ 10. Practice and Application

- LeetCode 543: Diameter of Binary Tree
- LeetCode 687: Longest Univalue Path
- LeetCode 124, 543, 437 combine to form a powerful tree traversal practice set

---

🧠 Mastering Binary Tree Maximum Path Sum gives you expert-level insight into tree recursion and greedy decision-making inside recursive chains.

