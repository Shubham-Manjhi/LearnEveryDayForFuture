# 🔗 LinkedHashSet in Java (API + Internal Working + Examples)

---

## ✅ 1. Definition and Purpose

- `LinkedHashSet` is a class in Java that extends `HashSet` and maintains insertion order.
- Implements the `Set` interface.
- It is backed by a **hash table and linked list**.
- Ensures that elements are unique and appear in the order in which they were inserted.

---

## ✅ 2. Syntax and Structure

```java
LinkedHashSet<Type> set = new LinkedHashSet<>();
```

### 🎯 Constructors:

```java
LinkedHashSet()
LinkedHashSet(Collection<? extends E> c)
LinkedHashSet(int initialCapacity)
LinkedHashSet(int initialCapacity, float loadFactor)
```

---

## ✅ 3. Key Methods

```java
boolean add(E e)
boolean remove(Object o)
boolean contains(Object o)
void clear()
int size()
boolean isEmpty()
Iterator<E> iterator()
```

### 🧠 Example:

```java
LinkedHashSet<String> animals = new LinkedHashSet<>();
animals.add("Dog");
animals.add("Cat");
animals.add("Elephant");
System.out.println(animals); // [Dog, Cat, Elephant]
```

---

## ✅ 4. Internal Working

- Maintains a **doubly-linked list** across all entries.
- Uses a hash table for fast access, and a linked list for maintaining insertion order.
- Like HashSet, it relies on `hashCode()` and `equals()` to prevent duplicates.

---

## ✅ 5. ASCII Diagram

```
Insertion Order:  [ Dog ] <-> [ Cat ] <-> [ Elephant ]
                            ^   ^   ^
                            |   |   |
                          HashTable Buckets
```

---

## ✅ 6. Use Case and Custom Implementation (Simplified)

### Custom Implementation Idea:

- Use `HashMap` to store keys.
- Use a linked list or track order using `LinkedList`.

```java
class MyLinkedHashSet {
    private Map<Integer, Object> map = new LinkedHashMap<>();
    private static final Object DUMMY = new Object();

    public void add(int val) {
        map.put(val, DUMMY);
    }

    public boolean contains(int val) {
        return map.containsKey(val);
    }

    public void remove(int val) {
        map.remove(val);
    }

    public void display() {
        for (int key : map.keySet()) {
            System.out.print(key + " ");
        }
    }
}
```

---

## ✅ 7. Related Concepts

- `HashSet` – no insertion order
- `TreeSet` – sorted order
- `LinkedHashMap` – similar internal design

---

## ✅ 8. Best Practices

- Prefer `LinkedHashSet` when order of insertion matters.
- Avoid adding mutable objects that may change their hashCode after insertion.

---

## ✅ 9. Interview & Real-World Use

- Caching recent items (preserve order)
- Maintaining ordered unique entries (e.g., tags, visited URLs)
- Configuration files where order matters

---

## ✅ 10. Common Errors & Debugging

- Forgetting insertion order is preserved may lead to bugs.
- Adding `null` is allowed, but only once.
- Iteration order differs from `HashSet`.

---

## ✅ 11. Java Version Notes

- Available since Java 1.4
- Works well with enhanced for-loops and Java 8 streams

---

## ✅ 12. Practice and Application

- LeetCode: Longest Substring Without Repeating Characters (track characters seen)
- Competitive Programming: History of moves/events without duplicates

---

✅ `LinkedHashSet` combines the power of hash access and order tracking!

