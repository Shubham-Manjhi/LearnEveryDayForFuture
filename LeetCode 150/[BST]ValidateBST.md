**Java Topic: LeetCode 98 - Validate Binary Search Tree**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given the root of a binary tree, determine if it is a valid binary search tree (BST). A BST is valid if for every node, all nodes in its left subtree are smaller, and all nodes in its right subtree are larger.

• Why does it exist in Java?\
It enforces understanding of BST invariants and recursive tree traversal.

• What problem does it solve?\
Checks correctness of tree structures used in storage, indexing, and searching.

🧠 Example: Input: [2,1,3] → Output: true

---

✅ 2. Syntax and Structure

• Define `boolean isValidBST(TreeNode root)`\
• Use recursion to check node value constraints

---

✅ 3. Practical Examples

🔹 Approach 1: Recursive with Bounds

```java
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
```

🔹 Approach 2: In-order Traversal (store previous node)

```java
public class ValidateBSTInOrder {
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}
```

🖼️ ASCII Diagram – BST Validation:

```
      5
     / \
    3   8
   / \   \
  2   4   9

Valid BST: All left < root < all right
In-order: 2 → 3 → 4 → 5 → 8 → 9 (sorted)
```

---

✅ 4. Internal Working

• Recursively compare node values within min-max bounds\
• In-order traversal checks ascending order

Time Complexity: O(n) where n = nodes in tree

Space Complexity:

- O(h) for recursion stack (h = height of tree)

---

✅ 5. Best Practices

✔ Use long for bounds to handle Integer.MIN\_VALUE edge case\
✔ Avoid storing entire traversal result — just track previous value

---

✅ 6. Related Concepts

- In-order Traversal
- Tree Recursion
- Min/Max Constraints

🧠 Example: Validating deserialized binary trees

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- High-frequency BST concept test\

- Requires recursion, bounds, and order understanding

🏢 Real-world:

- Database indexing structures\

- Sorted range query trees\

- Binary storage validation

---

✅ 8. Common Errors & Debugging

❌ Not checking strict inequality\
❌ Using Integer instead of long for bounds\
❌ Forgetting to update previous node

🧪 Debug Tip:

- Print min, max, node values at each recursive step

---

✅ 9. Java Version Updates

• Java 14+: Use `record TreeNode(int val, TreeNode left, TreeNode right)` for immutable structure\
• Java 8+: Optional or lambdas for clean recursion

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #98\

- Tree validation problems\

- Custom tree serialization validation

🏗 Apply in:

- File system integrity\

- Binary decision trees\

- Balanced database structures

