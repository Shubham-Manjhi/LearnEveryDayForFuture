# 🌳 In-order Traversal in BST (Binary Search Tree)

---

## ✅ 0. Question

Perform an in-order traversal on a Binary Search Tree (BST), which means visiting the left subtree, the current node, then the right subtree. Return the values in ascending order.

### Example Tree:
```
      4
     / \
    2   6
   / \ / \
  1  3 5  7
```

### In-order Output:
```
[1, 2, 3, 4, 5, 6, 7]
```

---

## ✅ 1. Definition and Purpose

In-order traversal is a depth-first search technique used to traverse a binary tree. For BSTs, this traversal yields nodes in sorted order.

Purpose:
- Retrieve sorted values
- Validate BST property
- Used in rank/select operations

---

## ✅ 2. Syntax and Structure

```java
public List<Integer> inorderTraversal(TreeNode root)
```

Where `TreeNode` is:
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Recursive

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
}

private void traverse(TreeNode node, List<Integer> result) {
    if (node == null) return;
    traverse(node.left, result);
    result.add(node.val);
    traverse(node.right, result);
}
```

### 🔹 Approach 2: Iterative using Stack

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        result.add(current.val);
        current = current.right;
    }

    return result;
}
```

### ASCII Diagram
```
          4
        /   \
      2       6
     / \     / \
    1   3   5   7

Traversal Path: 1 → 2 → 3 → 4 → 5 → 6 → 7
```

---

## ✅ 4. Internal Working

- Recursion uses function call stack
- Iteration uses explicit Stack
- Follows: left → node → right

---

## ✅ 5. Best Practices

- Use recursion for small trees or simple use
- Use iteration to avoid stack overflow
- Break traversal early if searching

---

## ✅ 6. Related Concepts

- Pre-order, Post-order
- DFS
- BST validation

---

## ✅ 7. Interview & Real-world Use

- Used for sorted order retrieval from BSTs
- Tree-based analytics (ranking, searching)
- Core of many tree algorithms

---

## ✅ 8. Common Errors & Debugging

- Infinite loop in iterative if pointer not updated
- Stack overflow with deep recursion
- Misorder: left → root → right must be preserved

---

## ✅ 9. Java Version Updates

- Java 8+: Lambdas can simplify tree traversal logic (streams if tree is transformed)

---

## ✅ 10. Practice and Application

- LeetCode 94: Binary Tree Inorder Traversal
- LeetCode 230: Kth Smallest Element in BST
- LeetCode 173: BST Iterator

---

🚀 Mastering in-order traversal is key to understanding how BSTs are structured and traversed efficiently.

