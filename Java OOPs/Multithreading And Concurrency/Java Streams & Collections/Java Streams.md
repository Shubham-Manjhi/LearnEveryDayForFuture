# ⚡ **Java Streams**

Java Streams are a **powerful functional-style abstraction** for processing sequences of elements. They enable **declarative, concise, and parallel-ready data manipulation**.

---

## ✨ **Topics Covered**

- **What is a Stream?**
- **Creating Streams**
- **Intermediate Operations**
- **Terminal Operations**
- **Parallel Streams**
- **Advanced Stream Operations**
- **Best Practices & Interview Tips**

---

## 🟢 **What is a Stream?**

- A Stream is a **sequence of elements** supporting **functional-style operations**.
- **Not a data structure:** Streams do not store data; they process data from a source like Collections, arrays, or I/O channels.
- **Lazy Evaluation:** Operations are performed **on-demand**.

**Key Points:**

- Streams are **single-use**; they cannot be reused.
- Designed for **functional programming** in Java 8+.

---

## 🟡 **Creating Streams**

Streams can be created from collections, arrays, or generator functions.

### ✅ Examples:

```java
import java.util.*;
import java.util.stream.*;

public class StreamCreationDemo {
    public static void main(String[] args) {
        // From Collection
        List<String> list = Arrays.asList("Java", "Streams", "API");
        Stream<String> stream1 = list.stream();

        // From Array
        String[] arr = {"A", "B", "C"};
        Stream<String> stream2 = Arrays.stream(arr);

        // From Stream.of
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4);

        stream1.forEach(System.out::println);
    }
}
```

**Key Points:**

- `stream()` creates a sequential stream.
- `parallelStream()` creates a parallel-ready stream.

---

## 🔵 **Intermediate Operations**

Intermediate operations **return a new Stream** and are **lazy**.

**Common Intermediate Operations:**

- `filter(Predicate)` – Filters elements
- `map(Function)` – Transforms elements
- `sorted()` – Sorts elements
- `distinct()` – Removes duplicates
- `limit(n)` – Truncates stream

### ✅ Example:

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
List<Integer> squaredEven = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .map(n -> n * n)
                                   .collect(Collectors.toList());
System.out.println(squaredEven); // [4, 16]
```

---

## 🟣 **Terminal Operations**

Terminal operations **produce a result or side-effect** and close the stream.

**Common Terminal Operations:**

- `forEach()` – Iterates elements
- `collect()` – Collects elements into a collection
- `reduce()` – Reduces elements to a single value
- `count()` – Counts elements
- `anyMatch()/allMatch()/noneMatch()` – Predicate evaluation

### ✅ Example:

```java
int sum = numbers.stream()
                 .filter(n -> n % 2 != 0)
                 .mapToInt(Integer::intValue)
                 .sum();
System.out.println("Sum of odd numbers: " + sum); // 9
```

---

## 🟠 **Parallel Streams**

Parallel streams **split tasks across multiple cores**.

### ✅ Example:

```java
int sum = numbers.parallelStream()
                 .mapToInt(n -> n * 2)
                 .sum();
System.out.println("Sum of doubled numbers: " + sum);
```

**Key Points:**

- Improves performance for CPU-intensive operations.
- Avoid **shared mutable state** to prevent race conditions.

---

## 🔴 **Advanced Stream Operations**

- `flatMap()` – Flattens nested structures
- `peek()` – Debug intermediate operations
- `groupingBy()` – Groups elements into maps
- `partitioningBy()` – Divides elements into two groups
- `reduce(BinaryOperator)` – Custom aggregation

### ✅ Example – Grouping:

```java
List<String> words = Arrays.asList("apple", "banana", "apricot");
Map<Character, List<String>> grouped = words.stream()
                                             .collect(Collectors.groupingBy(w -> w.charAt(0)));
System.out.println(grouped); // {a=[apple, apricot], b=[banana]}
```

---

## 🟤 **Best Practices & Interview Tips**

1. Prefer **Streams** over loops for readability and functional-style programming.
2. Use **parallel streams** for CPU-bound large datasets.
3. Avoid modifying external state inside streams.
4. Understand **lazy evaluation** of intermediate operations.
5. Familiarize with **collectors**, `reduce`, `flatMap`, and `groupingBy` for advanced operations.

### ✅ Common Interview Questions:

- Difference between intermediate and terminal operations.
- How to create streams from collections, arrays, and generators.
- When to use parallel streams.
- How to use `flatMap` and `groupingBy`.

---

Java Streams provide **concise, readable, and efficient data processing** capabilities. Mastery of streams is crucial for modern Java programming and technical interviews.

**Page Count:** 5-6 pages with examples, advanced operations, and best practices.

---

> 📌 Next Steps: Provide the **next topic/question**, such as **Generics, Optional, or Functional Interfaces**, and I will continue expanding the advanced Java guide.

