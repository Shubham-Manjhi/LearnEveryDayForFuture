**Java Collections: ArrayList**

---

### 1. Definition and Purpose

**ArrayList** is a part of the Java Collection Framework. It is a **resizable array** implementation of the `List` interface.

- Dynamically grows or shrinks in size
- Allows **random access** via index
- Stores **objects**, including duplicates and nulls

🧠 *Why it exists:* To provide a more flexible alternative to arrays.

---

### 2. Syntax and Structure

```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.get(0); // Returns "A"
list.remove("B");
```

Common Methods:

- `add()`, `get()`, `set()`, `remove()`
- `size()`, `contains()`, `clear()`
- `isEmpty()`, `indexOf()`, `lastIndexOf()`

---

### 3. Practical Example

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

for (int num : numbers) {
    System.out.println(num);
}
```

✅ **Real Use Case:** Holding search results or user inputs where size is not predetermined.

---

### 4. Internal Working

- **Backed by an array**
- Default capacity = 10
- When full, it grows by 50% of current size (Java 8+)
- Uses `System.arraycopy()` for resizing

---

### 5. Best Practices

- Prefer `List<String> list = new ArrayList<>();` (coding to interface)
- Avoid frequent random `insert(i, value)` as it's O(n)
- Use `trimToSize()` to reduce memory if list won’t grow

---

### 6. Related Concepts

- `LinkedList` (sequential access, better inserts/deletes)
- `Vector` (synchronized version of ArrayList)
- `Stack` (LIFO, built on Vector)
- `Arrays.asList()` returns fixed-size list

---

### 7. Interview & Real-World Use

- **Interview Question:** What is the difference between ArrayList and LinkedList?
- **Real-world Use:** Shopping cart items, logs buffer, user history, etc.

---

### 8. Common Errors & Debugging

- `IndexOutOfBoundsException`: Accessing beyond list size
- `ConcurrentModificationException`: Modifying while iterating
  - Fix with `Iterator` or use `CopyOnWriteArrayList`

---

### 9. Java Version Updates

- Java 9+: `List.of(...)` returns immutable list
- Java 10+: Type inference with `var list = new ArrayList<String>();`

---

### 10. Practice and Application

- LeetCode problems using dynamic arrays
- Convert arrays to lists: `Arrays.asList(array)`
- Use in real-time UI rendering, like dropdown options or table rows

---

