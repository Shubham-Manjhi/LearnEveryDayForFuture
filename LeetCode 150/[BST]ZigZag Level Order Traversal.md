**Java Topic: LeetCode 103 - Binary Tree Zigzag Level Order Traversal**

---

✅ 1. Definition and Purpose

• What is the concept?\
Traverse a binary tree level-by-level, but alternate the direction of traversal at each level (left-to-right, then right-to-left).

• Why does it exist in Java?\
To teach level-order traversal with direction alternation using queues and stacks.

• What problem does it solve?\
Enhances understanding of breadth-first traversal with variations.

🧠 Example: Input: [3,9,20,null,null,15,7] → Output: [[3],[20,9],[15,7]]

---

✅ 2. Syntax and Structure

• Define `List<List<Integer>> zigzagLevelOrder(TreeNode root)`\
• Use a queue for level-order traversal, flip direction after each level

---

✅ 3. Practical Examples

🔹 Approach: BFS with Direction Toggle

```java
import java.util.*;

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
```

🖼️ ASCII Diagram – Zigzag Traversal:
```
      3
     / \
    9  20
       / \
      15  7

Zigzag: [[3], [20, 9], [15, 7]]
```

---

✅ 4. Internal Working

• BFS with queue maintains level order\
• Use a LinkedList to allow addFirst and addLast for zigzag behavior\
• Flip direction flag after each level

Time Complexity: O(n)

Space Complexity: O(n)

---

✅ 5. Best Practices

✔ Use LinkedList for level buffer\
✔ Toggle boolean for direction instead of complex logic\
✔ Keep logic inside one while-loop block

---

✅ 6. Related Concepts

- BFS and DFS\
- Tree Traversal Variants\
- Level-order Encoding

🧠 Example: UI rendering, outline views, reporting trees

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- A common variant asked in BFS rounds

🏢 Real-world:
- Alternating processing workflows\
- Rendering hierarchical data\
- Scheduling dependency graphs

---

✅ 8. Common Errors & Debugging

❌ Using array instead of LinkedList for zigzag logic\
❌ Forgetting to flip direction\
❌ Incorrect insertion order per level

🧪 Debug Tip:
- Print each level and direction at each iteration

---

✅ 9. Java Version Updates

• Java 8+: Stream can be used for level flattening\
• Java 14+: `record` for TreeNode for immutability

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #103\
- BFS and tree traversal problems

🏗 Apply in:
- Dashboard grid layouts\
- Log visualization trees\
- Zigzag-encoded storage formats

