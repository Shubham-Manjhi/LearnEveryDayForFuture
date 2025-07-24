**Java Topic: LeetCode 230 - Kth Smallest Element in a BST**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given the root of a binary search tree (BST) and an integer k, return the k-th smallest value among all the nodes in the tree.

• Why does it exist in Java?\
To demonstrate in-order traversal in BSTs and efficient tree-based selection algorithms.

• What problem does it solve?\
Efficiently finds the k-th ordered value in sorted binary data structures.

🧠 Example: Input: root = [3,1,4,null,2], k = 1 → Output: 1

---

✅ 2. Syntax and Structure

• Define `int kthSmallest(TreeNode root, int k)`\
• Use in-order traversal (left → root → right)

---

✅ 3. Practical Examples

🔹 Approach 1: In-order DFS with counter

```java
public class KthSmallestBST {
    private int count = 0;
    private int result = -1;

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
}
```

🔹 Approach 2: Iterative In-order Traversal (Stack-based)

```java
public class KthSmallestBSTIterative {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        return -1; // k is invalid
    }
}
```

🖼️ ASCII Diagram – In-order Traversal:

```
      5
     / \
    3   6
   / \
  2   4
 /
1

In-order: 1 → 2 → 3 → 4 → 5 → 6
k = 3 → Output = 3
```

---

✅ 4. Internal Working

• In-order traversal visits nodes in ascending order in BST\
• Counter keeps track of how many nodes have been visited

Time Complexity:

- Average: O(H + k), where H is the height of the tree
- Worst-case: O(n) for unbalanced BST

Space Complexity:

- O(H) for stack in recursion or iteration

---

✅ 5. Best Practices

✔ Always validate if tree is balanced\
✔ Use iterative traversal in memory-constrained environments\
✔ Avoid global state if possible by encapsulating counters

---

✅ 6. Related Concepts

- In-order Tree Traversal
- BST Properties
- Stack-based DFS

🧠 Example: Ranking systems, leaderboard retrieval

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Highlights understanding of tree traversal and in-order properties

🏢 Real-world:

- Dynamic leaderboard ranking\

- Efficient range queries\

- Auto-suggestion ranked filters

---

✅ 8. Common Errors & Debugging

❌ Forgetting to stop traversal after k-th element\
❌ Off-by-one error in counter\
❌ Misuse of recursion state

🧪 Debug Tip:

- Print counter and node value during traversal

---

✅ 9. Java Version Updates

• Java 8+: Lambdas can be used to encapsulate traversal\
• Java 14+: Use records for immutable TreeNode representation

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #230\

- Tree DFS problems\

- BST validation and traversal

🏗 Apply in:

- Leaderboard APIs\

- Navigation trees\

- Data query engines

