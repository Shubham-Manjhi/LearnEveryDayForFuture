# 📘 LeetCode 148: Sort List

---

## ✅ 0. Question

Sort a linked list in O(n log n) time using constant space complexity.

### Example:
Input: `4 -> 2 -> 1 -> 3`
Output: `1 -> 2 -> 3 -> 4`

Input: `-1 -> 5 -> 3 -> 4 -> 0`
Output: `-1 -> 0 -> 3 -> 4 -> 5`

---

## ✅ 1. Definition and Purpose

- Goal: Sort a singly linked list in-place in O(n log n) time.
- Real-world usage: Sorting records by ID, timestamps, etc. in memory-efficient systems.
- Merge sort is ideal due to non-random access limitations of linked lists.

---

## ✅ 2. Syntax and Structure

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public ListNode sortList(ListNode head);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Merge Sort (Recursive)
```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    // Step 1: Split list in half
    ListNode slow = head, fast = head, prev = null;
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = null; // Disconnect the two halves

    // Step 2: Recursively sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // Step 3: Merge the sorted halves
    return merge(l1, l2);
}

private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    current.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

### 🔹 Approach 2: Bottom-up Merge Sort (Iterative)
```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    // Step 1: Get length of list
    int length = 0;
    ListNode node = head;
    while (node != null) {
        length++;
        node = node.next;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // Step 2: Iteratively merge sublists of size 1, 2, 4...
    for (int size = 1; size < length; size <<= 1) {
        ListNode curr = dummy.next;
        ListNode tail = dummy;

        while (curr != null) {
            ListNode left = curr;
            ListNode right = split(left, size);
            curr = split(right, size);
            tail = merge(left, right, tail);
        }
    }
    return dummy.next;
}

// Split the list into two parts and return the head of the second part
private ListNode split(ListNode head, int size) {
    while (head != null && --size > 0) {
        head = head.next;
    }
    if (head == null) return null;
    ListNode second = head.next;
    head.next = null;
    return second;
}

// Merge two sorted lists and append to tail, return new tail
private ListNode merge(ListNode l1, ListNode l2, ListNode tail) {
    ListNode curr = tail;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;
    while (curr.next != null) curr = curr.next;
    return curr;
}
```

---

## ✅ 4. Internal Working

- Recursive Merge Sort splits using slow/fast pointers.
- Bottom-up builds from size=1 and merges pairs, doubling each time.
- Time Complexity: O(n log n)  |  Space: O(log n) for recursion, O(1) for bottom-up

---

## ✅ 5. Best Practices

- Prefer bottom-up for true constant space.
- Recursive merge sort is easier to implement but uses stack space.
- Always disconnect halves when splitting to avoid cycles.

---

## ✅ 6. Related Concepts

- Linked List Splitting
- Divide and Conquer
- Sorting Techniques

---

## ✅ 7. Interview & Real-world Use

- Frequently asked in top-tier company interviews.
- Useful in systems with memory limits or no random access.

---

## ✅ 8. Common Errors & Debugging

- Forgetting to set next = null when splitting.
- Infinite loops from improper list merging.
- Skipping null checks.

---

## ✅ 9. Java Version Updates

- No version-specific changes; pure algorithm.
- Works with basic ListNode structure.

---

## ✅ 10. Practice and Application

- LeetCode 21: Merge Two Sorted Lists
- LeetCode 23: Merge k Sorted Lists
- LeetCode 92: Reverse Linked List II

---

🧠 Mastering `Sort List` prepares you for manipulating linked lists and implementing efficient algorithms under space constraints!

