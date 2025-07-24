**LeetCode 295: Find Median from Data Stream**

---

### 1. Problem Statement
Design a data structure that supports adding numbers from a stream and finding the median efficiently.

Implement the `MedianFinder` class:
- `void addNum(int num)` adds a number to the stream.
- `double findMedian()` returns the median of all elements so far.

**Function Signatures:**
```java
public class MedianFinder {
    public void addNum(int num)
    public double findMedian()
}
```

---

### 2. Purpose and Motivation
- Useful in real-time systems like analytics, dashboards, stock monitoring.
- The challenge is to maintain a dynamic median efficiently as elements come in.

---

### 3. Optimal Approach: Two Heaps (Max Heap + Min Heap)
- **Max Heap (left)**: stores the smaller half of numbers
- **Min Heap (right)**: stores the larger half
- Invariant:
  - `maxHeap.size()` == `minHeap.size()` or one more
  - All elements in maxHeap ≤ all elements in minHeap

```java
class MedianFinder {
    PriorityQueue<Integer> maxHeap; // left
    PriorityQueue<Integer> minHeap; // right

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
```

---

### 4. Example Walkthrough
Input: [6, 10, 2, 6, 5]

ASCII representation:
```
Step-by-step insertion:
Insert 6 → maxHeap: [6], minHeap: [] → Median: 6
Insert 10 → max: [6], min: [10] → Median: (6+10)/2 = 8.0
Insert 2 → max: [6,2], min: [10] → Median: 6
Insert 6 → max: [6,2], min: [6,10] → Median: (6+6)/2 = 6.0
Insert 5 → max: [6,2,5], min: [6,10] → Median: 6
```

---

### 5. Complexity
- **Time Complexity:**
  - `addNum()` → O(log n) for heap insertion
  - `findMedian()` → O(1)
- **Space Complexity:** O(n)

---

### 6. Edge Cases
- No elements: return 0.0 or throw exception depending on requirements
- Duplicates: allowed
- Negative numbers: supported

---

### 7. Best Practices
- Keep heaps balanced after every insertion
- Use `Collections.reverseOrder()` for max heap

---

### 8. Related Concepts
- Heaps / PriorityQueue
- Sliding Window Median
- Order statistics

---

### 9. Interview Tip
> Discuss tradeoffs with alternate approaches: sort array (O(n log n)), use TreeMap (O(log n) insert + median calc), etc.

---

### 10. Follow-up
> How would you support deletion from the stream? Use lazy deletion with TreeMap or Indexed Heaps.

