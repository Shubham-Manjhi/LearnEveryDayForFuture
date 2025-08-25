# ⚡ **Infinite Streams in Java (Stream.generate, Stream.iterate)**

Java Streams support **infinite streams**, which are streams without a fixed size. They are particularly useful for **generating endless data sequences** on demand.

---

## ✨ **1. Stream.generate()**

- **Purpose:** Generates an infinite stream by repeatedly invoking a **Supplier**.
- **Use Case:** Useful for generating **random numbers**, constants, or repeated values.

### Example - Generating Random Numbers:
```java
import java.util.Random;
import java.util.stream.Stream;

Random random = new Random();
Stream<Integer> randomNumbers = Stream.generate(() -> random.nextInt(100));

// Limit to first 5 elements to avoid infinite output
randomNumbers.limit(5).forEach(System.out::println);
```

### Explanation:
- `Stream.generate()` repeatedly calls the Supplier to produce elements.
- Always use a **limiting operation** like `limit()` to avoid infinite loops.

---

## ✨ **2. Stream.iterate()**

- **Purpose:** Generates an infinite stream by **iteratively applying a unary operator** starting from an initial seed.
- **Use Case:** Useful for sequences, counting, or mathematical series.

### Example - Generating a Sequence:
```java
Stream<Integer> sequence = Stream.iterate(0, n -> n + 2);
sequence.limit(5).forEach(System.out::println); // 0, 2, 4, 6, 8
```

### Explanation:
- Starts with seed `0` and repeatedly applies `n -> n + 2`.
- `limit()` prevents the stream from being truly infinite during consumption.

---

## ✨ **3. Advanced iterate with Predicate (Java 9+)**

- Java 9 introduced `Stream.iterate(seed, hasNext, next)` to **safely control infinite streams**.

### Example - Controlled Iteration:
```java
Stream<Integer> controlled = Stream.iterate(0, n -> n < 10, n -> n + 2);
controlled.forEach(System.out::println); // 0, 2, 4, 6, 8
```

### Explanation:
- Iterates only while `n < 10`.
- Avoids explicit `limit()` and keeps code **more readable and safe**.

---

## 🟢 **Best Practices**

1. Always use **limit() or a controlling predicate** to avoid infinite processing.
2. Use `Stream.generate()` for **stateless generation**.
3. Use `Stream.iterate()` for **stateful, deterministic sequences**.
4. Infinite streams are excellent for **lazy evaluation**, generating data on demand without pre-allocating collections.

---

Infinite streams in Java allow developers to **produce unbounded sequences** while maintaining **lazy, functional evaluation**, making them ideal for simulations, sequences, and dynamic data generation.

