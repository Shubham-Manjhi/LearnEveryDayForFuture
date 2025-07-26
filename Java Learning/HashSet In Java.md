# 📘 HashSet in Java (Full API + Custom Implementation)

---

## ✅ 1. Definition and Purpose

- `HashSet` is a collection in Java that implements the `Set` interface, backed by a hash table.
- Stores unique elements only — no duplicates allowed.
- Offers constant-time performance for add, remove, contains, and size operations on average.

---

## ✅ 2. Syntax and Structure

```java
HashSet<Type> set = new HashSet<>();
```

### 🎯 Constructors
```java
HashSet()
HashSet(Collection<? extends E> c)
HashSet(int initialCapacity)
HashSet(int initialCapacity, float loadFactor)
```

---

## ✅ 3. Core Methods

```java
boolean add(E e)
boolean contains(Object o)
boolean remove(Object o)
void clear()
boolean isEmpty()
int size()
Iterator<E> iterator()
```

### 🧠 Example:
```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Apple"); // Duplicate, ignored
System.out.println(fruits.contains("Banana")); // true
fruits.remove("Apple");
```

---

## ✅ 4. Internal Working

- Based on **HashMap** internally.
- Each added element is stored as a key in the internal HashMap with a constant dummy value.
- HashSet uses hashCode() and equals() methods for uniqueness.

```java
transient HashMap<E,Object> map;
private static final Object PRESENT = new Object();
```

---

## ✅ 5. ASCII Diagram

```
HashSet (buckets with hashed indices):
Index 0:  → [Orange]
Index 1:  → [Mango] → [Apple] (if hash collision)
```

---

## ✅ 6. Custom HashSet Implementation (Simplified)

```java
class MyHashSet {
    private static final int SIZE = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null) buckets[index] = new LinkedList<>();
        if (!buckets[index].contains(key)) buckets[index].add(key);
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] != null) buckets[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }
}
```

---

## ✅ 7. Related Concepts

- HashMap (underlying data structure)
- TreeSet (sorted set)
- LinkedHashSet (maintains insertion order)

---

## ✅ 8. Best Practices

- Use proper `equals()` and `hashCode()` implementations for custom objects.
- Avoid storing mutable objects that affect hashCode().
- Use `LinkedHashSet` or `TreeSet` if order is important.

---

## ✅ 9. Interview & Real-World Use

- Detecting duplicates in arrays/lists
- Maintaining sets of visited nodes (e.g., DFS/BFS)
- Caching unique keys/records

---

## ✅ 10. Common Errors & Debugging

- Overriding equals() without hashCode() breaks uniqueness.
- Inserting null multiple times still counts as one.
- Poor hashCode() causes collisions and performance drop.

---

## ✅ 11. Java Version Notes

- Java 8+ improved bucket treeification for large collisions.
- Java 16+ introduced compact HashMap/Set implementations.

---

## ✅ 12. Practice and Application

- LeetCode: Contains Duplicate, Happy Number
- Use to eliminate duplicates, track seen values, unique constraints

---

✅ HashSet is now fully documented with theory, internal structure, and coding patterns!