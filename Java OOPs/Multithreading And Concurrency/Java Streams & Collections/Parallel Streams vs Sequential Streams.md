# ⚡ **Parallel Streams vs Sequential Streams**

Java Streams can be processed either sequentially or in parallel. Understanding the difference is crucial for performance optimization.

---

## ✨ **Sequential Streams**

- **Definition:** Processes elements one at a time in a single thread.
- **Default Stream Behavior:** `stream()` creates a sequential stream.
- **Use Cases:** Ideal for **small datasets** or when order matters.

### ✅ Example:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```

**Key Points:**

- Maintains **encounter order** unless explicitly sorted.
- Simpler and predictable behavior.

---

## 🔵 **Parallel Streams**

- **Definition:** Splits data into multiple substreams and processes them concurrently using **ForkJoinPool**.
- **Use Case:** Best for **large datasets** and CPU-intensive operations.

### ✅ Example:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
int sum = numbers.parallelStream()
                 .map(n -> n * 2)
                 .reduce(0, Integer::sum);
System.out.println("Sum of doubled numbers: " + sum);
```

**Key Points:**

- Improves performance by utilizing **multiple cores**.
- **Order may not be maintained** for some operations.
- Requires **thread-safe operations** to avoid side effects.

---

## 🟢 **Comparison Table**

| Feature     | Sequential Stream              | Parallel Stream                                  |
| ----------- | ------------------------------ | ------------------------------------------------ |
| Threads     | Single thread                  | Multiple threads (ForkJoinPool)                  |
| Order       | Maintained                     | May not be maintained                            |
| Performance | Suitable for small datasets    | Suitable for large datasets or CPU-bound tasks   |
| Complexity  | Simple                         | Slightly complex due to concurrency              |
| Use Case    | Ordered processing, small data | Large data processing, parallelizable operations |

---

**Best Practices:**

1. Use parallel streams **only when performance gain is clear**.
2. Avoid shared mutable state to prevent race conditions.
3. Measure performance before and after parallelization.
4. Prefer sequential streams for **I/O-bound tasks**.

Parallel streams in Java provide a **powerful way to leverage multicore processors**, but careful consideration of task characteristics is essential for safe and effective use.

