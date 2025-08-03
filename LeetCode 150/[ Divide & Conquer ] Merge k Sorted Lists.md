# 📘 LeetCode 23: Merge k Sorted Lists

---

## ✅ 0. Question

You are given an array of `k` linked-lists, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.

### Example:

```text
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
```

---

## ✅ 1. Definition and Purpose

This is a classic problem for practicing divide and conquer or heap-based merging. It is widely used in merging logs, event streams, and files from different sorted sources.

---

## ✅ 2. Syntax and Structure

```java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public ListNode mergeKLists(ListNode[] lists);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Priority Queue (Min-Heap)

```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

    // Step 1: Add head of each list to minHeap
    for (ListNode node : lists) {
        if (node != null) minHeap.offer(node);
    }

    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;

    // Step 2: Extract min and push next node from that list
    while (!minHeap.isEmpty()) {
        ListNode curr = minHeap.poll(); // Smallest node
        tail.next = curr;
        tail = curr;
        if (curr.next != null) minHeap.offer(curr.next);
    }

    return dummy.next;
}
```

### ASCII Explanation:

```
Lists:
[1 -> 4 -> 5]
[1 -> 3 -> 4]
[2 -> 6]

MinHeap Simulation:
1, 1, 2 -> pick 1, add 4
1, 2, 4 -> pick 1, add 3
...
Final: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
```

### 🔹 Approach 2: Divide and Conquer

```java
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    return mergeHelper(lists, 0, lists.length - 1);
}

private ListNode mergeHelper(ListNode[] lists, int left, int right) {
    if (left == right) return lists[left];
    int mid = left + (right - left) / 2;
    ListNode l1 = mergeHelper(lists, left, mid);
    ListNode l2 = mergeHelper(lists, mid + 1, right);
    return mergeTwoLists(l1, l2);
}

private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }
    tail.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

---

## ✅ 4. Internal Working

- MinHeap keeps next smallest element from all heads
- Divide & Conquer merges pairs of lists recursively like Merge Sort

---

## ✅ 5. Best Practices

- Use MinHeap for large number of short lists
- Use divide & conquer when number of lists is small but length is large
- Always check for null before inserting into heap

---

## ✅ 6. Related Concepts

- Merge Sort
- Heap / Priority Queue
- Linked List Traversal

---

## ✅ 7. Interview & Real-world Use

- Merging multiple server logs
- K-way merge in external sorting
- Used in Apache Hadoop, Spark, Lucene

---

## ✅ 8. Common Errors & Debugging

- Not checking if list node is null before pushing to heap
- Infinite loops if you don't move pointer
- Forgetting to attach remainder list

---

## ✅ 9. Java Version Updates

- Java 8+: lambdas simplify comparator for PriorityQueue

---

## ✅ 10. Practice and Application

- LeetCode 21: Merge Two Sorted Lists
- LeetCode 148: Sort List
- LeetCode 373: Find K Pairs with Smallest Sums

---

🚀 Mastering this teaches you k-way merging and is foundational for scalable distributed systems.

