**Java Topic: StringBuilder vs StringBuffer**

---

### 1. Definition and Purpose

**What are StringBuilder and StringBuffer?** Both are classes in the `java.lang` package that represent **mutable sequences of characters**. They allow efficient string manipulation, especially for concatenation and modification.

**Why do both exist in Java?**

- `StringBuffer` was introduced first (Java 1.0) and is **thread-safe**.
- `StringBuilder` was introduced later (Java 1.5) as a **faster** alternative for **single-threaded** environments.

**Problem They Solve:**

- Avoid the overhead of `String` immutability.
- Enable in-place string modification without creating new objects repeatedly.

---

### 2. Syntax and Structure

**StringBuilder Example:**

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);
```

**StringBuffer Example:**

```java
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World");
System.out.println(sbf);
```

**Common Methods (same for both):**

- `append()`, `insert()`, `replace()`, `delete()`, `reverse()`, `toString()`

---

### 3. Practical Examples

**Performance Benchmark Example:**

```java
long start = System.nanoTime();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) sb.append("x");
System.out.println("Time: " + (System.nanoTime() - start));
```

Repeat the same for `StringBuffer` to compare time.

**Multi-threaded Case:**

```java
StringBuffer sbf = new StringBuffer();
Runnable task = () -> {
    for (int i = 0; i < 5; i++) sbf.append(i);
};
new Thread(task).start();
new Thread(task).start();
```

---

### 4. Internal Working

| Feature       | StringBuilder   | StringBuffer                 |
| ------------- | --------------- | ---------------------------- |
| Thread-safe   | ❌ No            | ✅ Yes (synchronized methods) |
| Performance   | ✅ Faster        | ❌ Slower (due to locks)      |
| Introduced In | Java 1.5        | Java 1.0                     |
| Use Case      | Single-threaded | Multi-threaded               |

Both use a dynamically resizing `char[]` buffer and grow as needed.

---

### 5. Best Practices

**Use StringBuilder when:**

- Working in a single-threaded context.
- Performance is critical (like in loops).

**Use StringBuffer when:**

- You need thread-safe operations.
- You're sharing the buffer between threads.

---

### 6. Related Concepts

- **String (Immutable)**: For fixed, constant text.
- **Synchronization**: Ensures thread safety in `StringBuffer`.
- **StringJoiner / Streams**: Java 8+ alternatives for concatenation.

---

### 7. Interview & Real-world Use

**Interview Questions:**

- When should you prefer StringBuffer over StringBuilder?
- Why are strings immutable but StringBuffer is mutable?

**Real-world Use:**

- StringBuilder: Logging systems, report generation, response builders.
- StringBuffer: Legacy systems, multithreaded parsers, concurrent logging.

---

### 8. Common Errors & Debugging

**Common Mistakes:**

- Using `StringBuffer` in performance-critical single-threaded code.
- Forgetting thread safety when using `StringBuilder` in concurrent contexts.

**Debugging Tips:**

- Use `Thread.currentThread().getName()` when logging from threads.
- Monitor synchronization overhead with profilers.

---

### 9. Java Version Updates

- `StringBuffer`: Since Java 1.0.
- `StringBuilder`: Introduced in Java 1.5 for improved performance.
- No major changes since then but heavily used in internal APIs.

---

### 10. Practice and Application

**Coding Practice:**

- Write a function to reverse a sentence using both classes.
- Benchmark the performance of both for a string concatenation loop.

**Real-world Application:**

- Use StringBuilder for building dynamic queries.
- Use StringBuffer in thread-safe logging utilities.

