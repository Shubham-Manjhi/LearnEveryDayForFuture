# 📘 LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal

---

## ✅ 0. Question

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

### Example:
```text
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

---

## ✅ 1. Definition and Purpose

Constructing a binary tree from its traversal orders is a classical problem in recursion and divide-and-conquer algorithms. It demonstrates how different traversal sequences provide structure to rebuild the tree uniquely.

---

## ✅ 2. Syntax and Structure

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Recursive + HashMap

```java
public class Solution {
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a value-to-index map for inorder to access root positions in O(1)
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null; // Base case

        // Step 1: Take current value from preorder as root
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Step 2: Find root position in inorder to split left and right subtree
        int mid = inorderMap.get(rootVal);

        // Step 3: Recursively build left and right subtree
        root.left = build(preorder, inStart, mid - 1);
        root.right = build(preorder, mid + 1, inEnd);

        return root;
    }
}
```

### ⏱ Time Complexity: O(n)
### 📦 Space Complexity: O(n) (HashMap + recursion stack)

---

### 📘 ASCII Tree Reconstruction
```
Preorder:  [3, 9, 20, 15, 7]
Inorder:   [9, 3, 15, 20, 7]

1. Pick 3 as root
2. 9 is left of 3, subtree = [9]
3. 20 is right of 3, subtree = [15, 20, 7]
   └ 15 left, 7 right

Final tree:
      3
     / \
    9   20
        / \
      15   7
```

---

### 🔹 Approach 2: Optimized Recursion using Sentinel (Concise)

```java
public class Solution {
    int p = 0, i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // Step 1: End condition
        if (p >= preorder.length) return null;

        // Step 2: If inorder[i] == stop, this is end of subtree
        if (inorder[i] == stop) {
            i++;
            return null;
        }

        // Step 3: Create root from preorder
        TreeNode node = new TreeNode(preorder[p++]);

        // Step 4: Build left subtree until current node is hit in inorder
        node.left = build(preorder, inorder, node.val);

        // Step 5: Build right subtree until sentinel
        node.right = build(preorder, inorder, stop);

        return node;
    }
}
```

### ⏱ Time Complexity: O(n)
### 📦 Space Complexity: O(n) (recursion only)

---

## ✅ 4. Internal Working
- Preorder provides root values sequentially.
- Inorder splits tree into left and right.
- Recursion simulates tree growth from root outward.
- Sentinel-based recursion avoids map and index searching.

---

## ✅ 5. Best Practices
- Prefer building right subtree after left for preorder.
- Use HashMap to avoid repeated searches.
- In space-optimized solutions, ensure correct boundary (sentinel) logic.

---

## ✅ 6. Related Concepts
- Tree traversals: Inorder, Preorder, Postorder
- Divide-and-Conquer
- Recursive tree building

---

## ✅ 7. Interview & Real-world Use
- Common in system design for parsing, AST building
- Essential for serializing/deserializing trees

---

## ✅ 8. Common Errors & Debugging
- Wrong index updates on traversal arrays
- Reversed left-right subtree build order
- Ignoring base conditions and sentinels

---

## ✅ 9. Java Version Updates
- Java 8+: lambdas and streams may help in test input processing
- Java Records (since 14) can make immutable TreeNode definitions

---

## ✅ 10. Practice and Application
- LeetCode 106: Inorder + Postorder
- LeetCode 889: Preorder + Postorder
- Parsing binary tree input and reconstructing in editors

---

Let me know when you're ready for the next problem (e.g., LeetCode 106 or 889) ✅

