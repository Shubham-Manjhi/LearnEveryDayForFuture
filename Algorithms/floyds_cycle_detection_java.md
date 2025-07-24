**Floyd's Cycle Detection Algorithm in Java**

---

### 1. Definition and Purpose

- **What is it?** Floyd’s Cycle Detection (Tortoise and Hare) is a pointer algorithm to detect cycles in a sequence.
- **Why?** It is used to check for infinite loops, especially in linked lists or any sequence of states.
- **Problem it Solves:** Detecting cycles in constant space, where extra memory (like HashSet) isn't ideal.

---

### 2. Syntax and Structure

- Two pointers:
  - `slow`: moves 1 step at a time
  - `fast`: moves 2 steps at a time
- If `slow == fast`, a cycle exists.

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) return true;
    }
    return false;
}
```

---

### 3. Practical Examples

**Use Case 1: Linked List Cycle Detection**

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

**Use Case 2: Happy Number**

```java
int slow = n, fast = getNext(n);
while (fast != 1 && slow != fast) {
    slow = getNext(slow);
    fast = getNext(getNext(fast));
}
```

---

### 4. Internal Working

- The fast pointer moves faster and will eventually enter a cycle if it exists.
- When `fast == slow`, both pointers are inside the cycle.
- If `fast` reaches `null`, there's no cycle.

---

### 5. Best Practices

- Always check for nulls (`fast != null && fast.next != null`).
- Use this when memory is constrained.
- Ensure pointers don't skip over nodes.

---

### 6. Related Concepts

- HashSet-based cycle detection
- Two-pointer technique
- Linked Lists, Function Iteration (e.g., Happy Number)

---

### 7. Interview & Real-world Use

- Commonly asked in Linked List problems.
- Used in detecting loops in state machines, number theory (Happy Number), etc.

---

### 8. Common Errors & Debugging

- Forgetting `fast.next != null` leads to `NullPointerException`
- Misplacing pointer moves — wrong order or skipping steps

---

### 9. Java Version Updates

- No specific updates; algorithm uses basic language features.

---

### 10. Practice and Application

- LeetCode: 141 (Linked List Cycle), 202 (Happy Number)
- Other platforms: HackerRank, GFG, Codeforces
- Apply in any repetitive state detection problem with potential loops

---

### Summary

Floyd’s Cycle Detection is a powerful algorithm to identify cycles without extra space. Ideal for linked lists or repeated-state functions, it is both efficient and elegant.

