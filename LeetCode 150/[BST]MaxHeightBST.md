**Java Topic: LeetCode 104 - Maximum Depth of Binary Tree**

---

✅ 1. Definition and Purpose

• What is the concept?\
Determine the maximum depth (or height) of a binary tree. The depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

• Why does it exist in Java?\
To reinforce recursive thinking and traversal patterns in tree-based data structures.

• What problem does it solve?\
Helps measure how deep or complex a tree structure is.

🧠 Example: Input: [3,9,20,null,null,15,7] → Output: 3

---

✅ 2. Syntax and Structure

• Define `int maxDepth(TreeNode root)`\
• Use either recursive depth-first traversal or iterative breadth-first traversal

---

✅ 3. Practical Examples

🔹 Approach 1: Recursive DFS

```java
public class MaxDepthRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

🔹 Approach 2: Iterative BFS using Queue

```java
import java.util.*;

public class MaxDepthBFS {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }

        return depth;
    }
}
```

🖼️ ASCII Diagram – Tree Depth:

```
      3
     / \
    9  20
       / \
      15  7

Depth = 3 (root → 20 → 15 or 7)
```

---

✅ 4. Internal Working

• DFS: Recursively calculates depth from root to leaves\
• BFS: Tracks each level using a queue and level size

Time Complexity: O(n) — every node visited once

Space Complexity:

- DFS: O(h) (height of tree)
- BFS: O(w) (maximum width of tree)

---

✅ 5. Best Practices

✔ Handle null root edge case\
✔ Use DFS for simplicity, BFS for clarity of level traversal

---

✅ 6. Related Concepts

- Tree Traversal (DFS/BFS)
- Recursion
- Queue-based level-order traversal

🧠 Example: Measuring complexity of dependency trees

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Common starter problem for tree traversal\

- Used to evaluate recursive and iterative thinking

🏢 Real-world:

- UI tree rendering\

- Parsing nested structures (e.g., XML, JSON)\

- Workflow or task depth analysis

---

✅ 8. Common Errors & Debugging

❌ Returning 0 instead of 1 + depth\
❌ Mismanaging queue level sizes in BFS\
❌ Confusing null leaf node as depth count

🧪 Debug Tip:

- Print level and node values at each recursion or loop step

---

✅ 9. Java Version Updates

• No breaking changes — consistent across Java versions\
• Java 14+: Use `record` for TreeNode if immutability desired

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #104\

- Recursive tree exploration

🏗 Apply in:

- Evaluating depth of XML/HTML/JSON structures\

- Game trees, AI decision graphs\

- Data structure visualizations

