**LeetCode 141: Linked List Cycle**

---

### 1. Problem Statement

Given the `head` of a linked list, determine if the linked list has a **cycle** in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer.

**Function Signature:**

```java
boolean hasCycle(ListNode head)
```

---

### 2. Understanding the Problem

- Need to detect a **cycle**, not return the starting point or length.
- Return `true` if a cycle is present, otherwise `false`.

---

### 3. Optimal Approach: Floyd’s Cycle Detection Algorithm

**Idea:** Use two pointers (slow and fast). If there is a cycle, they will meet.

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
        if (fast == null || fast.next == null) return false;
        slow = slow.next;
        fast = fast.next.next;
    }

    return true;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n) — Each node is visited at most twice.
- **Space Complexity:** O(1) — No extra space used.

---

### 5. Edge Cases to Consider

- Empty list
- Single node with or without cycle
- Long list with cycle near the end

---

### 6. Example

```java
Input: head = [3,2,0,-4], pos = 1 (tail connects to node index 1)
Output: true
```

---

### 7. Best Practices

- Always check for `null` to avoid `NullPointerException`.
- Use Floyd’s algorithm for constant space detection.
- Avoid using HashSet unless explicitly allowed.

---

### 8. Related Topics

- Linked List
- Two Pointers
- Fast and Slow Pointer Technique

---

### 9. Interview Tip

> Interviewers often expect Floyd’s Tortoise and Hare algorithm due to its efficiency. If time allows, mention alternate methods like using a `HashSet` to track visited nodes.

```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    while (head != null) {
        if (visited.contains(head)) return true;
        visited.add(head);
        head = head.next;
    }
    return false;
}
```

