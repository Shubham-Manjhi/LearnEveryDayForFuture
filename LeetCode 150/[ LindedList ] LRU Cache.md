# ✅ LeetCode 146: LRU Cache

---

## ✅ 0. Question: LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the `LRUCache` class:

```java
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if it exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
```

### Constraints:
- 1 <= capacity <= 3000
- 0 <= key <= 104
- 0 <= value <= 105
- The functions get and put must each run in O(1) average time complexity.

---

## ✅ 1. Definition and Purpose

- LRU stands for Least Recently Used.
- It is used to maintain a cache of fixed size.
- When the cache exceeds its limit, it removes the least recently accessed item.

### Why in Java:
- Java’s `LinkedHashMap` supports insertion/access order, which makes LRU easy to implement.

---

## ✅ 2. Syntax and Structure

Using LinkedHashMap:
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

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
```

---

## ✅ 3. Practical Example: Custom DLL + HashMap

### Steps:
1. Use HashMap to store keys and references to nodes.
2. Use Doubly Linked List to keep track of usage.
3. Move node to head on access, remove tail on overflow.

### Code:
```java
class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insertToHead(node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
```

---

## ✅ 4. Internal Working

- Doubly Linked List maintains the order.
- HashMap gives O(1) access to nodes.
- Head is most recently used; tail is least.
- When adding a new node, it goes to head.
- When capacity exceeded, tail is removed.

---

## ✅ 5. Best Practices

- Always unlink a node from the DLL before re-inserting.
- Avoid using Java’s built-in LinkedList for LRU due to O(n) operations.
- Use LinkedHashMap if custom eviction policy isn’t needed.

---

## ✅ 6. Related Concepts

- HashMap
- Doubly Linked List
- Queue behavior
- Java Collections (LinkedHashMap)

---

## ✅ 7. Interview & Real-world Use

- Very popular interview problem (Amazon, Google, Facebook)
- Used in browser history, CPU page replacement, database buffer pool

---

## ✅ 8. Common Errors & Debugging

- Forgetting to update DLL on access
- Not removing the tail node correctly
- Null pointer errors in DLL manipulation

---

## ✅ 9. Java Version Updates

- Java 1.4+: LinkedHashMap added with removeEldestEntry()
- Java 8+: Lambdas can help in compact syntax, but OOP is clearer here

---

## ✅ 10. Practice and Application

- LeetCode 146
- System Design LRU questions
- Implementing a disk cache or web proxy cache

---

Would you like an ASCII diagram or PDF next?

