# 🗑️ Remove the Kth Last Node from a Linked List

---

## 📘 Problem Explanation

We are given the head of a singly linked list. The task is to **remove the kth node from the end** of the list and return the modified head.

### Example

```python
Input: head = 1 → 2 → 3 → 4 → 5 → None, k = 2
Output: 1 → 2 → 3 → 5 → None
```

👉 The 2nd node from the end is `4`, so we remove it.

---

## 🔹 Approach 1: Two-Pointer Technique (Optimal)

- Use two pointers: `fast` and `slow`.
- Move `fast` pointer `k` steps ahead.
- Then move both `fast` and `slow` one step at a time until `fast.next` is `None`.
- Now `slow` is just before the target node. Remove it.

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0, head)
        fast, slow = dummy, dummy

        # Move fast k+1 steps ahead
        for _ in range(k+1):
            fast = fast.next

        # Move both until fast reaches the end
        while fast:
            fast = fast.next
            slow = slow.next

        # Remove kth node
        slow.next = slow.next.next
        return dummy.next
```

✅ **Time Complexity**: `O(n)`\
✅ **Space Complexity**: `O(1)`

---

## 🔹 Approach 2: Find Length First

- Traverse the list to get its length `n`.
- The node to remove is at position `(n - k)` from the start.
- Traverse again to that node and remove it.

```python
class Solution:
    def removeKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0, head)
        length = 0
        curr = head
        while curr:
            length += 1
            curr = curr.next

        # Position to remove from start
        length -= k
        curr = dummy
        while length > 0:
            length -= 1
            curr = curr.next

        curr.next = curr.next.next
        return dummy.next
```

✅ **Time Complexity**: `O(n)` (two passes)\
✅ **Space Complexity**: `O(1)`

---

## 🔹 Dry Run Example

Input: `1 → 2 → 3 → 4 → 5`, k = 2

| Step               | fast pointer | slow pointer | List Status |
| ------------------ | ------------ | ------------ | ----------- |
| Init               | dummy        | dummy        | 0→1→2→3→4→5 |
| Fast moves 3 steps | 3            | dummy        | 0→1→2→3→4→5 |
| Move both          | 4            | 1            |             |
| Move both          | 5            | 2            |             |
| Move both          | None         | 3            |             |

Remove `slow.next = 4` → Result = `1 → 2 → 3 → 5`

---

## 🔹 Interview Questions & Answers

**Q1. Why do we use a dummy node?**\
👉 To handle edge cases like removing the head itself.

**Q2. Can we do this in a single traversal?**\
👉 Yes, with the two-pointer approach (`O(n)` time, one pass).

**Q3. What if k = length of the list?**\
👉 Then we remove the head node.

**Q4. What happens if k > length of the list?**\
👉 Invalid input; in interviews clarify assumptions or handle gracefully.

---

## 🎯 Conclusion

- **Two-pointer approach** is optimal for one-pass solution.
- **Length-based approach** is simpler but requires two traversals.
- Always use a **dummy node** to simplify edge cases.
- Common Linked List interview problem.

---

