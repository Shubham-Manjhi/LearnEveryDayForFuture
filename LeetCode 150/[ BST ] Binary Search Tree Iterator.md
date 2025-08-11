# 📘 LeetCode 173: Binary Search Tree Iterator

---

## ✅ 0. Question: Definition

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling `next()` will return the next smallest number in the BST. The iterator must run in average O(1) time and use O(h) memory, where h is the height of the tree.

### Example:

```text
Input:
       7
      / \
     3   15
         / \
        9   20

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
```

---

## ✅ 1. Definition and Purpose
- A BST Iterator traverses the binary search tree in ascending order.
- It mimics the in-order traversal and exposes only next() and hasNext().
- This is useful in cases where you want to traverse a BST lazily, without flattening the whole tree upfront.

---

## ✅ 2. Syntax and Structure

```java
public class BSTIterator {
    public BSTIterator(TreeNode root);
    public int next();
    public boolean hasNext();
}
```

---

## ✅ 3. Practical Examples (Two Approaches)

### 🔹 Approach 1: Stack-based In-order Traversal

```java
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    // Constructor: Push all left nodes onto the stack
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    // Helper method to push all left children
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);           // 💬 Step 1: Add node to stack
            node = node.left;           // 💬 Step 2: Move to left child
        }
    }

    public int next() {
        TreeNode node = stack.pop();     // 💬 Step 3: Pop from stack (smallest)
        if (node.right != null) {
            pushLeft(node.right);       // 💬 Step 4: If right exists, push all lefts of right subtree
        }
        return node.val;                // 💬 Step 5: Return the node value
    }

    public boolean hasNext() {
        return !stack.isEmpty();         // 💬 Step 6: If stack not empty, has next
    }
}
```

### 🔹 Approach 2: Morris Traversal (Optimized Space O(1))

```java
class BSTIterator {
    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        this.curr = root;
    }

    public int next() {
        int val = -1;
        while (curr != null) {
            if (curr.left == null) {
                val = curr.val;               // 💬 Step 1: No left, process and go right
                curr = curr.right;
                break;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;       // 💬 Step 2: Find rightmost in left subtree
                }
                if (pred.right == null) {
                    pred.right = curr;       // 💬 Step 3: Create thread
                    curr = curr.left;
                } else {
                    pred.right = null;       // 💬 Step 4: Remove thread
                    val = curr.val;
                    curr = curr.right;
                    break;
                }
            }
        }
        return val;
    }

    public boolean hasNext() {
        return curr != null;                 // 💬 Step 5: Check if more nodes
    }
}
```

---

## 📘 ASCII Diagram:

```
       7
      / \
     3   15
         / \
        9   20

In-order: 3 → 7 → 9 → 15 → 20

Stack Top → [7]
Next(): pops 3, pushes right subtree if exists
```

---

## 📊 4. Time and Space Complexity

| Approach        | Time per `next()` | Space       |
|----------------|-------------------|-------------|
| Stack-based    | O(1) (amortized)  | O(h)         |
| Morris         | O(1) (amortized)  | O(1)         |

---

## ✅ 5. Best Practices
- Stack-based is cleaner and preferred unless you absolutely need O(1) space.
- Always clean up temporary threads in Morris traversal.

---

## ✅ 6. Related Concepts
- In-order traversal
- Recursion vs Iteration
- Tree threading (Morris Traversal)

---

## ✅ 7. Interview & Real-world Use
- BST iterator is common in DB engines and ordered traversal APIs.
- Appears in Facebook, Amazon interviews.

---

## ✅ 8. Common Errors & Debugging
- Forgetting to push right subtrees.
- Not maintaining thread links in Morris traversal.
- Misplacing hasNext logic (stack.isEmpty or curr != null).

---

## ✅ 9. Java Version Updates
- Java 8+ can use lambda-based traversal using Stream.
- Deque over Stack recommended in production.

---

## ✅ 10. Practice and Application
- LeetCode 173: BST Iterator
- LeetCode 230: Kth Smallest in BST
- LeetCode 285: Inorder Successor in BST

