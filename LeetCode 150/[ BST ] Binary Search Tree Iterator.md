# 📘 LeetCode 173: Binary Search Tree Iterator

---

## ✅ 0. Question

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST).

### Your BSTIterator class should implement:

```java
BSTIterator(TreeNode root) // Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor.
boolean hasNext() // Returns true if there exists a next smallest number in the BST.
int next() // Returns the next smallest number in the BST.
```

### Example:
```java
Input:
root = [7, 3, 15, null, null, 9, 20]
Operations: ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
Output: [null, 3, 7, true, 9, true, 15, true, 20, false]
```

---

## ✅ 1. Definition and Purpose

- Simulates an in-order traversal without recursion.
- Provides a memory-efficient way to iterate a BST lazily.
- Emulates how iterators work in collections.

---

## ✅ 2. Syntax and Structure

```java
class BSTIterator {
    public BSTIterator(TreeNode root);
    public int next();
    public boolean hasNext();
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Stack-Based Lazy In-order Traversal

```java
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root); // Initialize with leftmost nodes
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop(); // Get next smallest node
        pushLeft(node.right); // Explore right subtree
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
```

### Example Execution:
```text
Input Tree:     7
               / \
              3  15
                 /  \
                9   20

Stack evolves as we traverse: [7, 3] → pop 3 → [7, 15, 9] → pop 7 → ...
```

---

## ✅ 4. Internal Working

- Maintains a stack of left ancestors.
- `next()` pops from stack and pushes leftmost path from right child.
- Efficient simulation of recursive in-order using O(h) space.

---

## ✅ 5. Best Practices

- Avoid full traversal/storage in constructor.
- Use helper method to push left path.
- Validate tree state before calling `next()`.

---

## ✅ 6. Related Concepts

- Inorder traversal
- Stack-based tree traversal
- Java Iterator design

---

## ✅ 7. Interview & Real-world Use

- Asked in Google, Amazon, Meta interviews.
- Useful in database/tree cursor APIs where ordered access is needed.

---

## ✅ 8. Common Errors & Debugging

- Not checking null on left/right pointers.
- Forgetting to push right subtree in `next()`.
- Calling `next()` when `hasNext()` is false.

---

## ✅ 9. Java Version Updates

- Java 8+ supports lambda and streams, but this manual stack approach is more efficient for controlled traversal.

---

## ✅ 10. Practice and Application

- LeetCode 230: Kth Smallest in BST (can be built using this iterator)
- Tree-based databases / indexes
- Building tree readers with lazy loading

---

🧠 Mastering BSTIterator improves your control over traversal logic, memory-optimization, and iterator pattern implementation!

