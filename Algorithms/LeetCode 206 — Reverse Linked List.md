## 🔁 LeetCode 206 — Reverse Linked List

---

### 🎯 Problem Statement

Given the head of a singly linked list, reverse the list, and return the reversed list.

**Example:**

```
Input:  head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

---

### 🔹 Intuition

Reversing a linked list means making every node point to its previous node instead of the next one. We iteratively change the direction of the `next` pointer while keeping track of the current and previous nodes.

There are two common ways to solve this:

- **Iterative approach (O(1) space)** — using three pointers.
- **Recursive approach (O(n) space)** — reversing from the tail backward.

---

### 🧠 Step-by-Step Algorithm

#### Approach 1: Iterative (Three-Pointer Method)

1. Initialize three pointers:
   - `prev = null`
   - `curr = head`
   - `next = null`
2. While `curr` is not null:
   - Store next node → `next = curr.next`
   - Reverse the link → `curr.next = prev`
   - Move forward → `prev = curr`, `curr = next`
3. Return `prev` as the new head.

#### Approach 2: Recursive Method

1. Base Case: If head is null or `head.next` is null, return head.
2. Recursively reverse the rest of the list.
3. Adjust the next pointer of the following node: `head.next.next = head`.
4. Set `head.next = null`.

---

### 💻 Java Implementation

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
```

#### Recursive Version

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```

---

### 🐍 Python Implementation

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev
```

#### Recursive Version

```python
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head
```

---

### 🧮 Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Iterative | O(n)            | O(1)             |
| Recursive | O(n)            | O(n) (stack)     |

---

### 💬 Interview Questions

1. **How to detect if a linked list is circular after reversing?**
   - Use Floyd’s cycle detection algorithm before or after reversal.
2. **Can we reverse only a part of the list (e.g., between positions m and n)?**
   - Yes, this is a variant: *LeetCode 92 — Reverse Linked List II*.
3. **What happens if head is null?**
   - The function returns null safely.
4. **How to reverse in groups of k?**
   - Solve using recursion or iteration — see *LeetCode 25 — Reverse Nodes in k-Group*.

---

### 🧩 Key Takeaways

- The three-pointer method is the most efficient and clean way to reverse a linked list.
- Master both iterative and recursive versions — both are frequently asked in interviews.
- Core problem to understand **pointer manipulation** and **recursion fundamentals**.
- Common follow-ups include:
  - Reverse in groups
  - Reverse partial sublists
  - Detect cycles and reverse safely

