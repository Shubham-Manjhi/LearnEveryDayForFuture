**Java Topic: Least Recently Used (LRU) Cache**

---

### 1. Definition and Purpose

**What is an LRU Cache?** An **LRU (Least Recently Used) Cache** is a data structure that stores a limited number of items and automatically removes the **least recently used** item when the capacity is exceeded.

**Why does it exist in Java?** To manage **limited memory or expensive I/O** situations like caching API responses, file data, or database results.

**Problem it Solves:**

- Optimizes retrieval time for frequently accessed data.
- Automatically manages memory usage.

---

### 2. Syntax and Structure

Java doesn't provide a direct LRU cache class, but it can be implemented using:

- `LinkedHashMap`
- `Deque + HashMap`

**Using LinkedHashMap:**

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
```

---

### 3. Practical Examples

**Use Case:**

```java
LRUCache cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
System.out.println(cache.get(1)); // returns 1
cache.put(3, 3); // evicts key 2
System.out.println(cache.get(2)); // returns -1 (not found)
```

**Mini Project Idea:**

- Web browser tab management (recently opened pages).
- In-memory database or file system cache.

---

### 4. Internal Working

- `LinkedHashMap` maintains insertion and access order.
- By setting `accessOrder = true`, recent usage affects order.
- `removeEldestEntry()` ensures oldest entries are removed when full.

---

### 5. Best Practices

**Dos:**

- Use `LinkedHashMap` for simplicity and readability.
- Synchronize access in multi-threaded contexts.

**Don'ts:**

- Avoid custom logic if `LinkedHashMap` can handle it.
- Don’t forget to override `removeEldestEntry()`.

---

### 6. Related Concepts

- **Cache Eviction Policies:** LFU, FIFO
- **Collections API:** LinkedHashMap, HashMap
- **Concurrency:** ConcurrentHashMap + LinkedList for thread-safe cache

---

### 7. Interview & Real-world Use

**Interview Questions:**

- How would you implement an LRU cache?
- What’s the difference between HashMap and LinkedHashMap in caching?

**Real-world Use:**

- In-memory caching (e.g., Redis clients)
- Image thumbnail caching in Android
- Query result caching in backend services

---

### 8. Common Errors & Debugging

**Mistakes:**

- Forgetting to enable accessOrder in constructor.
- Not overriding `removeEldestEntry()`.

**Debug Tips:**

- Print cache on each operation to observe eviction.
- Use unit tests to validate edge cases.

---

### 9. Java Version Updates

- Java 8+: Supports lambdas for clean syntax.
- Java 9+: Introduced `Map.of()` but not relevant for mutability/ordering.

---

### 10. Practice and Application

**Coding Practice:**

- Implement LRU using Deque and HashMap manually.
- Add expiry mechanism (TTL).

**Real-world Application:**

- API rate limiter cache
- Local disk-to-memory object caching
- MRU tab-switching in modern IDEs or editors

