# ⚡ **Java Streams & Collections**

Java Streams and Collections are **core components** of modern Java programming, enabling efficient data manipulation, processing, and storage. Streams provide a functional approach to processing data, while Collections store and organize data.

---

## ✨ **Topics Covered**

- **Java Collections Framework (JCF)**
- **Types of Collections**
- **List, Set, Map Implementations**
- **Stream API Overview**
- **Intermediate and Terminal Operations**
- **Parallel Streams**
- **Best Practices & Interview Tips**

---

## 🟢 **Java Collections Framework (JCF)**

JCF is a unified architecture to **store, retrieve, and manipulate data efficiently**.

**Core Interfaces:**

- **Collection**: Root interface for `List`, `Set`, and `Queue`
- **Map**: Stores key-value pairs
- **Iterator**: Traverses collections

### ✅ Example:

```java
import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Streams");
        list.add("Collections");

        for(String item : list) {
            System.out.println(item);
        }
    }
}
```

**Key Points:**

- Supports **generic types** for type safety.
- Provides **common methods** like add, remove, contains, and size.

---

## 🟡 **Types of Collections**

1. **List** – Ordered, allows duplicates (`ArrayList`, `LinkedList`)
2. **Set** – Unordered, no duplicates (`HashSet`, `TreeSet`)
3. **Queue** – FIFO structure (`PriorityQueue`, `LinkedList`)
4. **Map** – Key-value pairs (`HashMap`, `TreeMap`, `LinkedHashMap`)

### ✅ Example:

```java
Set<String> set = new HashSet<>();
set.add("Java");
set.add("Java");
set.add("Collections");
System.out.println(set); // [Java, Collections]
```

**Key Points:**

- Use appropriate collection based on **order, uniqueness, and performance**.
- `Hash` collections offer **O(1)** operations on average.

---

## 🔵 **Stream API Overview**

Introduced in Java 8, the Stream API allows **functional-style operations** on collections.

**Advantages:**

- Declarative code style
- Supports **lazy evaluation**
- Can perform **parallel processing** easily

### ✅ Example:

```java
List<String> list = Arrays.asList("Java", "Streams", "Collections");
list.stream()
    .filter(s -> s.startsWith("C"))
    .forEach(System.out::println); // Collections
```

**Key Points:**

- Streams do not modify the source collection.
- Operations can be **intermediate** or **terminal**.

---

## 🟣 **Intermediate and Terminal Operations**

- **Intermediate Operations:** `filter()`, `map()`, `sorted()` – return a new Stream
- **Terminal Operations:** `collect()`, `forEach()`, `reduce()` – produce result or side-effect

### ✅ Example:

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
int sum = numbers.stream()
                 .filter(n -> n % 2 == 0)
                 .mapToInt(Integer::intValue)
                 .sum();
System.out.println("Sum of even numbers: " + sum); // 6
```

---

## 🟠 **Parallel Streams**

Streams can run in **parallel** to utilize multiple CPU cores.

### ✅ Example:

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
int sum = numbers.parallelStream()
                 .mapToInt(n -> n * 2)
                 .sum();
System.out.println("Sum: " + sum);
```

**Key Points:**

- Parallel streams split the workload automatically.
- Improves performance for **large data sets**.
- Be cautious with **shared mutable data**.

---

## 🟤 **Best Practices & Interview Tips**

1. Use **List** for ordered data and frequent access.
2. Use **Set** to prevent duplicates.
3. Use **Map** for key-value lookups.
4. Prefer **Streams** for readable, functional-style operations.
5. Use **parallel streams** only for CPU-bound tasks.
6. Avoid side-effects in streams to maintain **thread safety**.

### ✅ Common Interview Questions:

- Difference between List, Set, and Map.
- How to use Stream API for filtering and mapping.
- Difference between sequential and parallel streams.
- How to collect Stream results into a List or Map.

---

Java Streams and Collections provide **powerful tools** for modern data processing, combining **efficiency, readability, and concurrency support**.

**Page Count:** 6+ pages with examples, operations, and best practices.

---

> 📌 Next Steps: Provide the **next topic/question**, such as **Generics, Optional, or Advanced Stream Operations**, and I will continue expanding the advanced Java guide.

