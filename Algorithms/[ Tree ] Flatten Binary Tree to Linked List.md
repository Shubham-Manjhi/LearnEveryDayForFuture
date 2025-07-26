# 🌲 LeetCode 114: Flatten Binary Tree to Linked List

---

## ✅ 1. Definition and Purpose

- Convert a binary tree to a flattened linked list in-place.
- The linked list should follow the same order as a pre-order traversal.
- Useful in tree serialization, memory layout transformation, and algorithm optimization.

---

## ✅ 2. Syntax and Structure

```java
public void flatten(TreeNode root)
```
- Modifies the tree in-place to flatten it into a linked list (right-skewed).

---

## ✅ 3. Approach 1: Recursive Post-order (Bottom-Up)

```java
TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}
```

### 🔍 Explanation
- Post-order ensures we handle right subtree before left.
- We keep track of the previous node and wire the current node's right to it.
- Efficient and clean.

---

## ✅ 4. Approach 2: Iterative using Stack

```java
public void flatten(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode current = stack.pop();
        if (current.right != null) stack.push(current.right);
        if (current.left != null) stack.push(current.left);

        if (!stack.isEmpty()) {
            current.right = stack.peek();
        }
        current.left = null;
    }
}
```

### 🔍 Explanation
- Simulates pre-order traversal using a stack.
- Rewires left and right pointers to mimic linked list.

---

## ✅ 5. ASCII Diagram

```
Before:
    1
   / \
  2   5
 / \   \
3   4   6

After:
1
 \
 2
  \
   3
    \
     4
      \
       5
        \
         6
```

---

## ✅ 6. Internal Working

- Reverse post-order traversal (Right → Left → Node)
- Uses a pointer (prev) to build the flattened tree from leaves up
- Stack-based solution simulates traversal explicitly
- Time: O(n), Space: O(h)

---

## ✅ 7. Best Practices

- Use recursive if call stack depth is manageable
- Prefer iterative for large/deep trees to avoid stack overflow
- Set left child to null to form right-skewed list

---

## ✅ 8. Related Concepts

- Pre-order traversal
- Linked list creation
- Tree-to-array serialization

---

## ✅ 9. Interview & Real-world Use

- Common tree flattening or hierarchy linearization
- Used in memory layout optimizations
- Asked in almost every tree-based coding interview set

---

## ✅ 10. Common Errors & Debugging

- Not nullifying left pointers
- Rewiring order mistake (connecting to wrong node)
- Stack not handling nulls properly

---

## ✅ 11. Practice & Application

- LeetCode 114: Flatten Binary Tree to Linked List
- LeetCode 116, 117: Populating Next Right Pointers
- Tree transformations in compilers, DOM traversal

---

✅ Mastering tree flattening techniques boosts your ability to convert recursive structures into linear forms — a foundational skill in modern systems and problem-solving.

