# 🌳 LeetCode 112: Path Sum

---

## ✅ 1. Definition and Purpose

- Given a binary tree and a target sum, determine if the tree has a root-to-leaf path that sums up to the given target.
- Useful in decision tree validation, path traversal, and solving constraint-based logic in trees.

---

## ✅ 2. Syntax and Structure

```java
public boolean hasPathSum(TreeNode root, int targetSum)
```
- Parameters: TreeNode root, int targetSum
- Returns true if any root-to-leaf path adds up to targetSum.

---

## ✅ 3. Approach 1: Recursive DFS

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    // If it's a leaf node, check if the remaining sum equals node's value
    if (root.left == null && root.right == null) {
        return root.val == targetSum;
    }

    // Recurse on left and right subtree with reduced sum
    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
}
```

---

## ✅ 4. Approach 2: Iterative using Stack

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<Integer> sumStack = new Stack<>();
    nodeStack.push(root);
    sumStack.push(root.val);

    while (!nodeStack.isEmpty()) {
        TreeNode current = nodeStack.pop();
        int currentSum = sumStack.pop();

        if (current.left == null && current.right == null && currentSum == targetSum) {
            return true;
        }

        if (current.right != null) {
            nodeStack.push(current.right);
            sumStack.push(currentSum + current.right.val);
        }
        if (current.left != null) {
            nodeStack.push(current.left);
            sumStack.push(currentSum + current.left.val);
        }
    }

    return false;
}
```

---

## ✅ 5. ASCII Diagram Example

```
    5
   / \
  4   8
 /   / \
11  13  4
/  \
7    2

Target = 22 → 5→4→11→2 = 22 ✔️
```

---

## ✅ 6. Internal Working

- DFS recursively or using stack to explore all paths.
- Subtract node value from target at each step.
- When reaching leaf, check if remaining sum is 0.
- Time: O(N), Space: O(H) where H = height of tree.

---

## ✅ 7. Best Practices

- Always check leaf condition explicitly.
- Avoid premature returns before reaching a leaf.
- Track cumulative path sums correctly.

---

## ✅ 8. Related Concepts

- Tree Traversals (DFS, BFS)
- Backtracking
- Subtree Sum Problems (e.g., Path Sum II)

---

## ✅ 9. Interview & Real-world Use

- Used in puzzle validation (e.g. maze weights)
- Decision logic flow validation (root-to-decision paths)
- Tree recursion assessments

---

## ✅ 10. Common Errors & Debugging

- Not checking for leaf node when comparing sum
- Incorrectly subtracting node values
- Infinite loop in iterative approach without popping stacks

---

## ✅ 11. Practice & Application

- LeetCode 112: Path Sum
- LeetCode 113: Path Sum II (collect all valid paths)
- LeetCode 437: Path Sum III (path sum from any node)

---

✅ Mastering Path Sum enhances understanding of root-to-leaf traversal patterns — foundational for many recursive and DFS-based problems in trees.

