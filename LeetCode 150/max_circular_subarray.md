# 🌳 LeetCode 230: Kth Smallest Element in a BST

---

## ✅ 0. Question

Given the root of a binary search tree, and an integer `k`, return the `k`th smallest value (1-indexed) of all the values of the nodes in the tree.

### Example:
```text
Input: root = [3,1,4,null,2], k = 1
Output: 1
```

```text
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
```

---

## ✅ 1. Definition and Purpose

This problem leverages the **in-order traversal** property of a BST (Binary Search Tree), which visits nodes in ascending order. It teaches traversal control and order-based node access.

---

## ✅ 2. Syntax and Structure

```java
public int kthSmallest(TreeNode root, int k);
```

Where:
- `TreeNode` is a class with `val`, `left`, and `right`.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: In-order Traversal (Iterative)

```java
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty()) {
        // Step 1: Traverse to the leftmost node
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        // Step 2: Visit node
        root = stack.pop();
        if (--k == 0) return root.val; // Found kth

        // Step 3: Move to right
        root = root.right;
    }

    return -1; // Not found
}
```

### 🔹 Approach 2: In-order with Recursion

```java
int count = 0;
int result = -1;

public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result;
}

private void inorder(TreeNode node, int k) {
    if (node == null) return;

    inorder(node.left, k);

    count++;
    if (count == k) {
        result = node.val;
        return;
    }

    inorder(node.right, k);
}
```

### ASCII Diagram:
```
         5
       /   \
      3     6
     / \
    2   4
   /
  1

In-order: 1 -> 2 -> 3 -> 4 -> 5 -> 6
k=3 => 3rd smallest = 3
```

---

## ✅ 4. Internal Working

- In-order traversal guarantees sorted values for BST.
- Use stack (iterative) or recursion to control traversal.
- Decrement `k` during traversal until `k == 0`.

Time Complexity: O(H + k) where H is tree height.
Space: O(H) for recursion/stack

---

## ✅ 5. Best Practices

- Use iterative for large trees (avoid stack overflow)
- Break recursion once k is reached
- Use mutable wrapper or class field to pass values

---

## ✅ 6. Related Concepts

- In-order traversal
- Tree recursion
- Binary Search Tree properties

---

## ✅ 7. Interview & Real-world Use

- Asked in FAANG interviews
- Used in tree analytics (e.g., leaderboard ranks, top-K stats)

---

## ✅ 8. Common Errors & Debugging

- Forgetting to decrement `k`
- Not breaking recursion early
- Misunderstanding in-order sequence for BST

---

## ✅ 9. Java Version Updates

- Java 8+: Use `Deque` instead of `Stack` if preferred
- Lambdas for tree processing

---

## ✅ 10. Practice and Application

- LeetCode 98: Validate BST
- LeetCode 173: BST Iterator
- LeetCode 703: Kth Largest in Stream

---

🌱 Mastering this problem helps in developing efficient traversal techniques and mastering BST operations.

