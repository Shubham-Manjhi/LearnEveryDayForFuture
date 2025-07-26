# 🌳 LeetCode 236: Lowest Common Ancestor of a Binary Tree

---

## ✅ 1. Definition and Purpose

- Given a binary tree and two nodes `p` and `q`, the goal is to find their lowest common ancestor (LCA).
- The LCA is the lowest node in the tree that has both `p` and `q` as descendants (a node can be a descendant of itself).
- Important in hierarchical trees, file systems, organization charts, etc.

---

## ✅ 2. Syntax and Structure

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
```

- Returns the TreeNode which is the lowest common ancestor.

---

## ✅ 3. Approach 1: Recursive DFS

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

### 🔍 Explanation
- If we reach either `p` or `q`, we return that node.
- If both left and right return non-null, current node is LCA.
- Else propagate non-null child up.

---

## ✅ 4. Approach 2: Parent Pointers + HashSet

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    parent.put(root, null);

    while (!parent.containsKey(p) || !parent.containsKey(q)) {
        TreeNode node = stack.pop();
        if (node.left != null) {
            parent.put(node.left, node);
            stack.push(node.left);
        }
        if (node.right != null) {
            parent.put(node.right, node);
            stack.push(node.right);
        }
    }

    Set<TreeNode> ancestors = new HashSet<>();
    while (p != null) {
        ancestors.add(p);
        p = parent.get(p);
    }
    while (!ancestors.contains(q)) {
        q = parent.get(q);
    }
    return q;
}
```

### 🔍 Explanation
- Traverse tree and map each node to its parent.
- Collect all ancestors of `p` in a set.
- Traverse `q`'s ancestry until finding common node.

---

## ✅ 5. ASCII Tree Diagram

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

## ✅ 6. Internal Working

- Recursive solution traverses both branches.
- Unwinds call stack and bubbles up LCA.
- Time: O(N), Space: O(H) or O(N) if parent mapping used.

---

## ✅ 7. Best Practices

- Always check base case: `root == null || root == p || root == q`
- Use iterative method for large trees to avoid recursion limit.
- Validate both nodes exist in tree beforehand in real-world use.

---

## ✅ 8. Related Concepts

- Binary Tree recursion
- DFS traversal
- Tree ancestor paths

---

## ✅ 9. Interview & Real-world Use

- Common problem in Google, Amazon, Meta interviews
- Used in filesystems, version trees, taxonomy & hierarchy systems

---

## ✅ 10. Common Errors & Debugging

- Returning null too early in recursion
- Forgetting ancestor node can be one of `p` or `q`
- Mismanaging HashMap parent pointers

---

## ✅ 11. Practice & Application

- LeetCode 236: Lowest Common Ancestor
- LeetCode 1123: Lowest Common Ancestor of Deepest Leaves
- Git tree merging, taxonomy classification

---

✅ Understanding LCA in binary trees is key to solving ancestry, lineage, and structural problems efficiently using recursion or hash-based strategies.

