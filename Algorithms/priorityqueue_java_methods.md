**PriorityQueue in Java (with All Methods)**

---

### 1. Definition and Purpose

- **What is it?** `PriorityQueue` is a part of Java’s `java.util` package that implements a **heap-based priority queue**.
- **Why?** It provides efficient access to the smallest (min-heap) or largest (max-heap) element based on natural ordering or a custom comparator.
- **Problem it Solves:** Enables **ordered processing** of elements, used in scheduling, greedy algorithms, pathfinding, etc.

---

### 2. Syntax and Structure

```java
PriorityQueue<Type> pq = new PriorityQueue<>(); // Min-heap
PriorityQueue<Type> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
```

---

### 3. Common Methods

| Method               | Description                                 |
| -------------------- | ------------------------------------------- |
| `add(E e)`           | Inserts the specified element               |
| `offer(E e)`         | Same as `add()`, returns `false` on failure |
| `peek()`             | Retrieves but does not remove the head      |
| `poll()`             | Retrieves and removes the head              |
| `remove()`           | Removes a specific element                  |
| `contains(Object o)` | Checks if element exists                    |
| `size()`             | Returns number of elements                  |
| `clear()`            | Removes all elements                        |
| `toArray()`          | Converts queue to an array                  |
| `iterator()`         | Returns an iterator (no guaranteed order)   |

---

### 4. Example (Min Heap)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);

System.out.println(pq.poll()); // 1
System.out.println(pq.peek()); // 3
```

---

### 5. Example (Max Heap)

```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
maxPQ.offer(4);
maxPQ.offer(10);
maxPQ.offer(2);

System.out.println(maxPQ.poll()); // 10
```

---

### 6. Internal Working

- Uses a **binary heap** (array-based, complete binary tree)
- Time Complexity:
  - **add/offer**: O(log n)
  - **poll/peek**: O(log n) / O(1)
  - **contains**: O(n)
- **Not thread-safe** — use `PriorityBlockingQueue` for concurrency

---

### 7. Best Practices

- Prefer `offer()` over `add()` for safer failure handling
- Avoid iterating for ordering — use `poll()` repeatedly for sorted order
- Use custom `Comparator` for complex objects

---

### 8. Related Concepts

- `Deque`
- `TreeSet` (sorted but no duplicates)
- `Heap` (min and max heaps)

---

### 9. Interview & Real-world Use

- Dijkstra’s Algorithm (min heap)
- Kth Largest/Smallest elements
- Task scheduling in OS
- Huffman Encoding

---

### 10. Common Errors & Debugging

- Mistaking order of elements (no natural sort when iterating)
- Mutating elements used in Comparator
- Forgetting about duplicate entries

---

### 11. Java Version Notes

- Introduced in Java 1.5
- Enhanced lambda-based comparator usage in Java 8+

---

### 12. Practice & Application

- LeetCode: Kth Largest Element, Merge K Sorted Lists
- HackerRank, GFG: Job Scheduling, Path Finding
- Build custom classes with `compareTo()` or `Comparator`

---

### Bonus: Custom Object PriorityQueue Example

```java
class Task {
    int priority;
    String name;

    public Task(int p, String n) {
        this.priority = p;
        this.name = n;
    }
}

PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);
taskQueue.add(new Task(3, "Low"));
taskQueue.add(new Task(1, "High"));
System.out.println(taskQueue.poll().name); // High
```

---

PriorityQueue is a versatile tool that underpins many greedy and efficient algorithms in Java — mastering it is essential for competitive coding and production systems.

