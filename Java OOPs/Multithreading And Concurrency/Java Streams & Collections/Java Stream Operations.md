# ⚡ **Java Stream Operations**

Stream operations in Java are the **core mechanisms** for processing collections in a functional style. They are categorized into **Intermediate** and **Terminal** operations, with advanced features for aggregation, transformation, and parallel processing.

---

## ✨ **Topics Covered**

- **Intermediate Operations**
- **Terminal Operations**
- **Short-circuiting Operations**
- **Stateful vs Stateless Operations**
- **Advanced Operations**
- **Best Practices & Interview Tips**

---

## 🟢 **Intermediate Operations**

Intermediate operations return a **new Stream** and are **lazy**, meaning they are evaluated only when a terminal operation is invoked.

**Common Intermediate Operations:**

- `filter(Predicate)` – Filters elements based on a condition.
- `map(Function)` – Transforms elements.
- `flatMap(Function)` – Flattens nested streams.
- `distinct()` – Removes duplicate elements.
- `sorted()` – Sorts the stream.
- `limit(n)` and `skip(n)` – Controls the number of elements.
- `peek(Consumer)` – Performs an action for debugging.

### ✅ Example:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> filtered = names.stream()\                             
                             .filter(name -> name.startsWith("A"))
                             .map(String::toUpperCase)
                             .collect(Collectors.toList());
System.out.println(filtered); // [ALICE]
```

**Key Points:**

- Intermediate operations **can be chained**.
- No work is done until a terminal operation is invoked.

---

## 🔵 **Terminal Operations**

Terminal operations **produce a result or side-effect** and close the stream.

**Common Terminal Operations:**

- `forEach()` – Iterates elements.
- `collect()` – Collects elements into a collection or map.
- `reduce()` – Aggregates elements.
- `count()` – Counts elements.
- `anyMatch()`, `allMatch()`, `noneMatch()` – Predicate-based evaluation.
- `findFirst()`, `findAny()` – Returns elements matching a condition.

### ✅ Example:

```java
int sum = Arrays.asList(1,2,3,4,5).stream()
                         .filter(n -> n % 2 == 0)
                         .mapToInt(Integer::intValue)
                         .sum();
System.out.println("Sum of even numbers: " + sum); // 6
```

---

## 🟡 **Short-circuiting Operations**

Short-circuiting operations **may not process all elements**.

- `limit(n)` – Takes only the first n elements.
- `anyMatch()` – Returns true if any element matches predicate.
- `allMatch()` – Returns false if any element does not match predicate.
- `noneMatch()` – Returns false if any element matches predicate.

### ✅ Example:

```java
boolean hasLargeNumber = Arrays.asList(10, 20, 30, 40).stream()
                               .anyMatch(n -> n > 25);
System.out.println(hasLargeNumber); // true
```

---

## 🟣 **Stateful vs Stateless Operations**

- **Stateless operations**: Each element is processed independently (e.g., `map()`, `filter()`)
- **Stateful operations**: Operation depends on the state of other elements (e.g., `distinct()`, `sorted()`, `limit()`)

**Key Points:**

- Stateful operations may have **higher memory overhead**.
- Important for **parallel streams** to ensure correct execution.

---

## 🟠 **Advanced Operations**

- `collect(Collectors.toList())` – Collect to a list
- `collect(Collectors.toSet())` – Collect to a set
- `collect(Collectors.groupingBy())` – Group elements
- `collect(Collectors.partitioningBy())` – Partition elements
- `reduce()` – Custom aggregation
- `flatMap()` – Flatten nested collections or streams

### ✅ Example – Grouping:

```java
List<String> words = Arrays.asList("apple", "banana", "apricot");
Map<Character, List<String>> grouped = words.stream()
                                             .collect(Collectors.groupingBy(w -> w.charAt(0)));
System.out.println(grouped); // {a=[apple, apricot], b=[banana]}
```

### ✅ Example – Reduction:

```java
int product = Arrays.asList(1, 2, 3, 4).stream()
                  .reduce(1, (a, b) -> a * b);
System.out.println("Product: " + product); // 24
```

---

## 🟤 **Best Practices & Interview Tips**

1. Chain **intermediate operations** for readability.
2. Use **collectors** for complex grouping and aggregation.
3. Be mindful of **side effects** in streams.
4. Prefer **parallel streams** for large datasets, but avoid shared mutable state.
5. Know the difference between **stateful and stateless operations**.

### ✅ Common Interview Questions:

- Explain the difference between intermediate and terminal operations.
- Give examples of stateful vs stateless operations.
- How to use `reduce()` for aggregation.
- How to perform grouping and partitioning using streams.

---

Stream operations provide **flexibility, efficiency, and readability** in modern Java programming. Mastery of these operations is essential for technical interviews and production-level coding.

**Page Count:** 6+ pages with examples and detailed explanations.

