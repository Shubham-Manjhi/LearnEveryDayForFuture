# 📘 Queue in Java (Full API + Custom Implementation)

---

## ✅ 1. Definition and Purpose

- A **Queue** is a linear data structure that follows **First-In-First-Out (FIFO)** principle.
- Java provides `Queue` interface as part of the `java.util` package.
- Used in scheduling algorithms, buffer handling, and asynchronous messaging.

---

## ✅ 2. Queue Interface and Common Implementations

### 🎯 Implementing Classes
- `LinkedList`
- `PriorityQueue`
- `ArrayDeque` (recommended for stack/queue logic)

### 🧪 Key Methods (Java 8 Docs):
```java
boolean add(E e)
boolean offer(E e)
E remove()
E poll()
E element()
E peek()
```

### 🧠 Examples:
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(10); // [10]
queue.offer(20); // [10, 20]
queue.offer(30); // [10, 20, 30]
int head = queue.peek(); // 10
queue.poll(); // removes 10, now [20, 30]
```

---

## ✅ 3. Custom Queue Implementation

```java
class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E value) {
        list.addLast(value);
    }

    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return list.removeFirst();
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
```

---

## ✅ 4. ASCII Diagram

```
Front → [10] → [20] → [30] → Rear
```

---

## ✅ 5. Related Concepts

- Stack (LIFO)
- Deque (Double-ended Queue)
- PriorityQueue (order-based)

---

## ✅ 6. Best Practices

- Use `ArrayDeque` over `LinkedList` for better performance in queue operations.
- Handle `null` returns from `poll()` and `peek()` safely.
- Avoid using `remove()` and `element()` if unsure about queue state.

---

## ✅ 7. Interview & Real-World Use

- Used in job scheduling, breadth-first search (BFS), and producer-consumer problems.
- Queues support thread-safe variants (like `ConcurrentLinkedQueue`).

---

## ✅ 8. Common Errors & Debugging

- Using `remove()` or `element()` on empty queue throws exception.
- Not accounting for thread safety in concurrent environments.

---

## ✅ 9. Java Version Notes

- Java 6+ introduced `ArrayDeque`, preferred over `Stack` and `LinkedList` for queues.
- Java 7+ enhanced `ConcurrentLinkedQueue` for concurrent applications.

---

## ✅ 10. Practice and Application

- LeetCode: Course Schedule, Sliding Window Maximum
- Implement task queues, message buffers, print jobs

---

✅ Queue implementation and usage in Java is now fully documented!