**LeetCode 86: Partition List**

---

### 1. Problem Statement
Given the `head` of a linked list and a value `x`, partition it such that all nodes less than `x` come before nodes greater than or equal to `x`.

You should preserve the original relative order of the nodes in each of the two partitions.

**Function Signature:**
```java
ListNode partition(ListNode head, int x)
```

---

### 2. Understanding the Problem
- Rearrange nodes around a pivot value `x`.
- Nodes < x should appear before nodes >= x.
- Preserve original order within each partition.
- The operation should be in-place.

---

### 3. Approach: Two Dummy Lists
**Idea:** Use two lists to separate values < x and >= x, then combine them.

```java
public ListNode partition(ListNode head, int x) {
    ListNode beforeHead = new ListNode(0);
    ListNode afterHead = new ListNode(0);
    ListNode before = beforeHead;
    ListNode after = afterHead;

    while (head != null) {
        if (head.val < x) {
            before.next = head;
            before = before.next;
        } else {
            after.next = head;
            after = after.next;
        }
        head = head.next;
    }
    after.next = null;  // end the list
    before.next = afterHead.next; // combine two lists
    return beforeHead.next;
}
```

---

### 4. Complexity Analysis
- **Time Complexity:** O(n) — one pass through the list.
- **Space Complexity:** O(1) — using constant extra space (no new nodes).

---

### 5. Edge Cases to Consider
- Empty list (head = null)
- All nodes < x
- All nodes >= x
- Duplicate values of x

---

### 6. Example
```java
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
```

---

### 7. Best Practices
- Use dummy nodes to simplify edge conditions.
- Ensure `after.next = null` to prevent cycles.
- Avoid changing node values—relink nodes instead.

---

### 8. Related Topics
- Linked List
- Two Pointer Technique
- Dummy Node Pattern

---

### 9. Interview Tip
> Emphasize in-place rearrangement and the use of **dummy head nodes** to simplify pointer handling and list concatenation.

