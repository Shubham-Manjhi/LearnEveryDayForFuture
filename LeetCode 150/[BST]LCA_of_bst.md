**Java Topic: LeetCode 236 - Lowest Common Ancestor of a Binary Tree**

---

✅ 1. Definition and Purpose

• What is the concept?\
Find the lowest common ancestor (LCA) of two nodes in a binary tree. The LCA is the lowest node that has both nodes as descendants.

• Why does it exist in Java?\
Helps understand recursion and path tracing in tree data structures.

• What problem does it solve?\
Identifies hierarchical relationships in trees and resolves paths between nodes.

🧠 Example: Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 → Output: 3

---

✅ 2. Syntax and Structure

• Define `TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)`\
• Use post-order recursion to check node containment

---

✅ 3. Practical Examples

🔹 Approach: Recursive Traversal

```java
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}
```

🖼️ ASCII Diagram – LCA Tree:

```
        3
       / \
      5   1
     / \ / \
    6  2 0  8
      / \
     7   4

p = 5, q = 1 → LCA = 3
p = 5, q = 4 → LCA = 5
```

---

✅ 4. Internal Working

• Traverse tree recursively\
• Return node if it's p, q, or null\
• If both subtrees return non-null → current node is LCA

Time Complexity: O(n)

Space Complexity: O(h), where h = height of tree (recursion stack)

---

✅ 5. Best Practices

✔ Always check for base null/p/q conditions\
✔ Handle skewed tree scenarios carefully\
✔ Don't perform unnecessary recursion after LCA found

---

✅ 6. Related Concepts

- Post-order Tree Traversal
- Path Finding in Trees
- Ancestor Mapping

🧠 Example: Role hierarchy or access control management

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Common high-impact question for recursion mastery

🏢 Real-world:

- Organizational chart processing\

- File system path resolution\

- Workflow engine hierarchy tracing

---

✅ 8. Common Errors & Debugging

❌ Returning null instead of propagating found node\
❌ Forgetting to check root == p/q as base condition\
❌ Confusing root.left vs root.right recursion logic

🧪 Debug Tip:

- Print traversal entry/exit and node values

---

✅ 9. Java Version Updates

• Java 14+: Define TreeNode as a `record`\
• Java 8+: Use Optional for null-safety checks

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #236\

- Tree traversal and ancestor problems

🏗 Apply in:

- Cloud permission graph lookup\

- Organizational chart traversal\

- Taxonomy tree lookups

