**LeetCode 2: Add Two Numbers**

---

### 1. Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit.

Add the two numbers and return the sum as a **linked list**.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Function Signature:**

```java
ListNode addTwoNumbers(ListNode l1, ListNode l2)
```

---

### 2. Understanding the Problem

- Inputs: Two linked lists `l1` and `l2`.
- Each list node contains a digit in reverse order.
- Return a new list representing the sum (also in reverse order).

---

### 3. Optimal Approach

**Idea:** Traverse both lists, add corresponding digits and carry.

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;

    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;

        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }

    if (carry > 0) {
        curr.next = new ListNode(carry);
    }

    return dummyHead.next;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(max(m, n)) — Traverse both lists.
- **Space Complexity:** O(max(m, n)) — Resulting list length.

---

### 5. Edge Cases to Consider

- Different lengths of input lists.
- Final carry adds a new node (e.g., 5 + 5 = 10).
- One list is empty.

---

### 6. Example

```java
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
```

---

### 7. Best Practices

- Use dummy node to simplify logic.
- Always check nulls while traversing.
- Keep code modular and readable.

---

### 8. Related Topics

- Linked List
- Math
- Simulation

---

### 9. Interview Tip

> Clarify that digits are in reverse order. Explain your carry handling logic clearly and use examples to justify correctness.

---

### 10. Follow-up

> Can you solve the problem if the digits were stored in **forward order**? (Use stacks to reverse the process.)

