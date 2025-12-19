## 🔗 LeetCode 160 — Intersection of Two Linked Lists

---

### 🎯 Problem Statement

Given the heads of two singly linked lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection, return `null`.

**Note:** The intersection is defined based on **reference**, not value — that is, the same memory node must be shared.

**Example:**

```
Input:  listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
Output: Reference of node with value = 8
Explanation: The two lists intersect at node with value 8.
```

---

### 🔹 Intuition

If the two linked lists intersect, they share the same tail portion. By aligning both lists so they have equal length before traversal, we can find the intersection point efficiently.

---

### 🧠 Step-by-Step Algorithm

#### Approach 1: Length Difference Method

1. **Find the lengths** of both lists.
2. **Advance the longer list** by the difference in lengths.
3. **Move both pointers** one step at a time until they meet.
4. If pointers are equal, that node is the intersection.

#### Approach 2: Two Pointer Switching (Optimized)

1. Initialize two pointers, `a` at `headA` and `b` at `headB`.
2. Traverse both lists:
   - When `a` reaches the end, move it to `headB`.
   - When `b` reaches the end, move it to `headA`.
3. If the lists intersect, `a` and `b` will meet at the intersection node.
4. If not, both will become `null` at the same time.

This elegant approach equalizes path lengths without explicitly calculating them.

---

### 💻 Java Implementation

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // Either intersection node or null
    }
}
```

---

### 🐍 Python Implementation

```python
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        a, b = headA, headB
        while a != b:
            a = headB if not a else a.next
            b = headA if not b else b.next
        return a
```

---

### 🧮 Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| ---------- | ---------------- | ---------------- |
| Traversal  | O(m + n)         | O(1)             |
| Overall    | **O(m + n)**     | **O(1)**         |

Where `m` and `n` are lengths of the two lists.

---

### 💬 Interview Questions

1. **Can there be multiple intersection points?**
   - No, once lists intersect, all subsequent nodes are shared.

2. **Why not use a HashSet approach?**
   - It uses extra O(n) space. The two-pointer approach achieves O(1) space.

3. **What if there’s no intersection?**
   - Both pointers become `null` simultaneously.

4. **Why does switching heads work?**
   - It ensures both pointers traverse the same total number of nodes.

---

### 🧩 Key Takeaways

- The **two-pointer switching method** is the most optimal and elegant solution.
- Avoids explicit length calculation and additional space.
- Useful pattern for other linked list problems involving alignment or intersection detection.
- Frequently asked in top-tier company interviews like **Google, Amazon, and Meta**.

