# 🔄 Reverse a Singly Linked List in Python

---

## 📘 Problem Explanation

We are given the head of a singly linked list. The task is to **reverse the linked list** and return the new head.

### Example
```python
Input: 1 → 2 → 3 → 4 → 5 → None
Output: 5 → 4 → 3 → 2 → 1 → None
```

---

## 🔹 Approach 1: Iterative Reversal (Optimal)

- Maintain three pointers:
  - `prev` (initially `None`)
  - `curr` (initially `head`)
  - `next_node` (to store the next node temporarily)
- Iterate until `curr` is `None`.
- Reverse the link by pointing `curr.next` to `prev`.
- Move forward: update `prev = curr` and `curr = next_node`.
- At the end, `prev` will be the new head.

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(1)`

---

## 🔹 Approach 2: Recursive Reversal

- Base case: if `head` is `None` or `head.next` is `None`, return `head`.
- Recurse on the rest of the list.
- Reverse the link after recursion.

```python
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(n)` (recursion stack)

---

## 🔹 Dry Run Example

Input: `1 → 2 → 3 → None`

| Step | prev   | curr   | next_node | List So Far         |
|------|--------|--------|-----------|---------------------|
| 1    | None   | 1      | 2         | None ← 1            |
| 2    | 1      | 2      | 3         | None ← 1 ← 2        |
| 3    | 2      | 3      | None      | None ← 1 ← 2 ← 3    |

Final Output = `3 → 2 → 1 → None` ✅

---

## 🔹 Interview Questions & Answers

**Q1. Which approach is preferred in interviews?**  
👉 Iterative method, because it’s space efficient (`O(1)`).

**Q2. Can this be extended to doubly linked lists?**  
👉 Yes, but you need to swap both `next` and `prev` pointers.

**Q3. How would you reverse only a portion of the list (between positions m and n)?**  
👉 Use the same iterative approach but track the sublist boundaries.

**Q4. What if the list has a cycle?**  
👉 Detect the cycle first (using Floyd’s cycle detection), then proceed with reversal.

---

## 🎯 Conclusion

- **Iterative approach** is most optimal (`O(n)` time, `O(1)` space).
- **Recursive approach** is elegant but uses extra stack space.
- Variations: reverse in groups of k, reverse partial sublists.
- Very common **Linked List interview question**.

---

