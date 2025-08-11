# 📘 LeetCode 106: Construct Binary Tree from Inorder and Postorder Traversal

---

## ✅ 0. Question

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

### Example:

```text
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
```

---

## ✅ 1. Definition and Purpose

This problem tests your understanding of how binary tree traversal orders work. Reconstructing a binary tree from two traversals is fundamental in understanding tree structures and recursive construction.

---

## ✅ 2. Syntax and Structure

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: HashMap + Recursion (Standard)

```java
public class Solution {
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        // Build map to find index of inorder elements quickly
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Step 1: Pick current postIndex element as root
        TreeNode root = new TreeNode(postorder[postIndex--]);

        // Step 2: Locate the index of root in inorder
        int inorderIndex = inorderMap.get(root.val);

        // Step 3: Build right first (postorder is left -> right -> root)
        root.right = build(postorder, inorderIndex + 1, inEnd);
        root.left = build(postorder, inStart, inorderIndex - 1);

        return root;
    }
}
```

### ASCII Tree Construction:

```
Inorder:    [9, 3, 15, 20, 7]
Postorder:  [9, 15, 7, 20, 3]

Take 3 → Root
|_ Build Right Subtree: inorder[2..4] → [15, 20, 7] → root = 20
    |_ Right of 20: [7] → root = 7
    |_ Left of 20: [15] → root = 15
|_ Left Subtree: [9] → root = 9
```

---

### 🔹 Approach 2: Optimized Recursion using stop sentinel (Concise)

```java
public class Solution {
    int postIndex;
    int inIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inIndex = inorder.length - 1;
        return build(postorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] post, int[] in, int stop) {
        if (postIndex < 0) return null;

        if (in[inIndex] == stop) {
            inIndex--;
            return null;
        }

        TreeNode node = new TreeNode(post[postIndex--]);

        // Build right subtree first
        node.right = build(post, in, node.val);
        node.left = build(post, in, stop);

        return node;
    }
}
```

✅ Uses global postIndex and inIndex.
✅ Avoids HashMap by relying on sentinel values.
✅ Works because postorder’s root comes last.

---

## ✅ 4. Internal Working

- Postorder traversal gives us the root last.
- Inorder splits tree into left and right.
- Recursive divide-conquer builds subtrees from back to front.
- Optimized version avoids HashMap and saves space.

---

## ✅ 5. Best Practices

- Always build right subtree first for postorder.
- Use sentinel values to avoid unnecessary data structures.
- Use concise methods only if comfortable with recursion flow.

---

## ✅ 6. Related Concepts

- Tree Traversals
- Divide and Conquer
- Postorder vs Preorder tree building differences

---

## ✅ 7. Interview & Real-world Use

- Reconstructing tree from logs/traversals
- Understanding serialization/deserialization of trees

---

## ✅ 8. Common Errors & Debugging

- Reversing order of building subtrees
- Using wrong index for slicing subarrays
- Off-by-one errors in range

---

## ✅ 9. Java Version Updates

- Java 8+ allows cleaner lambda-based data manipulation
- Optional: records for tree structure if immutability is needed

---

## ✅ 10. Practice and Application

- LeetCode 105: Construct from Preorder + Inorder
- LeetCode 889: Preorder + Postorder
- Useful in tree reconstruction in file systems or graphics

---

✅ Time Complexity:
- O(n) — both approaches
✅ Space Complexity:
- O(n) for HashMap + Recursion stack (Approach 1)
- O(n) Recursion stack only (Approach 2)

Let me know if you'd like a diagram or PDF for this topic!

