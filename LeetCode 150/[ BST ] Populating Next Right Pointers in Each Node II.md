# 📘 LeetCode 117: Populating Next Right Pointers in Each Node II

---

## ✅ 0. Question

Given a binary tree:

```text
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.

This binary tree is not perfect, unlike LeetCode 116.

---

## ✅ 1. Definition and Purpose

In this problem, we need to connect nodes at the same level. Since the tree isn't perfect, we must dynamically determine the next right node.

This enhances tree traversal capabilities and is useful for real-time data processing.

---

## ✅ 2. Syntax and Structure

```java
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}
```

---

## ✅ 3. Practical Examples & Approaches

### 🔹 Approach 1: Level-order Traversal using Queue (BFS)

```java
// Time: O(n), Space: O(n)
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            // Process current level
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Step 1: Link previous node with current node
                if (prev != null) prev.next = node;
                prev = node;

                // Step 2: Add children for next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
```

---

### 🔹 Approach 2: O(1) Space - Dummy Node Pointer Traversal

```java
// Time: O(n), Space: O(1)
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0); // Temporary head of the next level
            Node tail = dummy;

            // Traverse current level
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left; // Link tail to left
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right; // Link tail to right
                    tail = tail.next;
                }
                curr = curr.next; // Move to next node in current level
            }
            curr = dummy.next; // Go to next level
        }
        return root;
    }
}
```

---

### 📘 ASCII Tree Example:

```
Before:
    1
   / \
  2   3
 / \   \
4   5   7

After:
    1 -> NULL
   / \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
```

---

## ✅ 4. Internal Working

- BFS uses queue to process levels.
- O(1) solution uses dummy node as anchor to connect children.
- Traverses current level using already populated next pointers.

---

## ✅ 5. Best Practices

- Prefer O(1) approach when space matters.
- Be cautious with null pointers.
- Dummy tail technique is reusable for similar problems.

---

## ✅ 6. Related Concepts

- Binary Tree Traversals
- Linked List next pointers
- BFS / DFS Tree Processing

---

## ✅ 7. Interview & Real-world Use

- Important for interview rounds testing tree manipulation
- Practical for pointer wiring in object graphs

---

## ✅ 8. Common Errors & Debugging

- Forgetting to reset dummy and tail
- Not moving curr to dummy.next after each level
- Null checks for left/right children

---

## ✅ 9. Java Version Updates

- Java 8+ makes it easy to write helper methods
- Java 14+ allows Records for immutable trees (not used here)

---

## ✅ 10. Practice and Application

- LeetCode 116: Perfect binary tree
- LeetCode 133: Clone Graph (uses similar pointer wiring)

---

✅ Let me know if you'd like a PDF or visual diagram of this solution!

