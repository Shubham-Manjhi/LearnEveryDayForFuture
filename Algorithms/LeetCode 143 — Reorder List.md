## 🧩 LeetCode 143 — Reorder List

---

### 🎯 Problem Statement
Given the head of a singly linked list `L0 → L1 → … → Ln-1 → Ln`, reorder the list to become:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
```

The reordering must be done **in-place**, without modifying the nodes' values.

**Example:**
```
Input:  head = [1,2,3,4]
Output: [1,4,2,3]
```

---

### 🔹 Intuition
To reorder the list, we can think of it as **splitting the list into two halves**, reversing the second half, and then **merging them alternately**.

#### Steps:
1. **Find the middle** of the linked list using slow and fast pointers.
2. **Reverse the second half** of the linked list.
3. **Merge** the two halves in alternating fashion.

---

### 🧠 Step-by-Step Algorithm

1. **Find Middle:**
   - Use two pointers, `slow` and `fast`. Move `fast` twice as fast as `slow`.
   - When `fast` reaches the end, `slow` will be at the middle.

2. **Reverse Second Half:**
   - Starting from the node after `slow`, reverse the list in-place.

3. **Merge Lists:**
   - Merge nodes one by one from the first and reversed second half.

---

### 💻 Java Implementation
```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
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

---

### 🐍 Python Implementation
```python
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

        # Step 1: Find middle
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse second half
        prev, curr = None, slow.next
        slow.next = None
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        # Step 3: Merge two halves
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2
```

---

### ⚙️ Complexity Analysis
| Operation | Time Complexity | Space Complexity |
|------------|------------------|------------------|
| Find Middle | O(n) | O(1) |
| Reverse List | O(n/2) | O(1) |
| Merge Lists | O(n) | O(1) |
| **Overall** | **O(n)** | **O(1)** |

---

### 💬 Common Interview Questions
1. **Why reverse only the second half?**
   - To merge nodes alternately without extra space.

2. **Can we do it recursively?**
   - Yes, but iterative approach is preferred for O(1) space.

3. **How do we ensure no cycles?**
   - Explicitly set `slow.next = null` before merging.

4. **Is this stable?**
   - Stability isn't relevant since node order is explicitly rearranged.

---

### 🧩 Key Takeaways
- The problem tests **linked list manipulation** and **pointer mastery**.
- Pattern similar to:
  - Reverse Linked List
  - Middle of Linked List
  - Merge Two Lists
- Often appears as a **medium** question testing **three-pointer logic** and **in-place modification** skills.

