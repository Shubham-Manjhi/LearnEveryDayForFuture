# 📘 LeetCode 103: Binary Tree Zigzag Level Order Traversal

---

## ✅ 0. Question

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

### Example:
```java
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
```

---

## ✅ 1. Definition and Purpose

- This problem is a variant of the traditional level-order (BFS) traversal.
- It uses a flag to alternate the direction for each level.
- Highlights the versatility of queue-based traversal with direction flipping.

---

## ✅ 2. Syntax and Structure

```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root)
```
- Input: TreeNode (binary tree root)
- Output: List of levels, each in alternating direction

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: BFS using Queue and Direction Flag

```java
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
```

### Example Tree:
```
        3
       / \
      9  20
         / \
        15  7

Result:
Level 0 (L→R): [3]
Level 1 (R→L): [20, 9]
Level 2 (L→R): [15, 7]
```

---

## ✅ 4. Internal Working

- Uses queue to store nodes level-wise.
- A boolean flag tracks direction and adds values to either head or tail of LinkedList.
- Time Complexity: O(n)
- Space Complexity: O(n)

---

## ✅ 5. Best Practices

- Use LinkedList for level values for efficient head/tail insertion.
- Toggle direction flag after every level.
- Avoid reversing arrays each level (costly).

---

## ✅ 6. Related Concepts

- BFS traversal
- Tree traversal variations
- Level-order pattern problems

---

## ✅ 7. Interview & Real-world Use

- Asked in interviews to test depth of traversal understanding.
- Pattern applicable in UI rendering (e.g., row-based alternating layouts).

---

## ✅ 8. Common Errors & Debugging

- Not toggling `leftToRight` correctly.
- Not using LinkedList for flexible direction inserts.
- Skipping null node check.

---

## ✅ 9. Java Version Updates

- Compatible with all Java versions (basic collections).
- LinkedList and Queue are part of Java Collections Framework.

---

## ✅ 10. Practice and Application

- LeetCode 102: Level Order Traversal
- LeetCode 107: Bottom-Up Level Order Traversal
- Rendering UI rows in alternating order

---

🧠 Mastering Zigzag Traversal reinforces BFS logic and use of collections like Deque and LinkedList in traversal variants!

