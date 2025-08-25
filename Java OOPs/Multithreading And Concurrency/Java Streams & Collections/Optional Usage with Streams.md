# ⚡ **Optional Usage with Streams**

Java's `Optional` class is used to **handle potentially null values** and is often used with Streams to **avoid null checks and NullPointerExceptions**.

---

## ✨ **Why Optional with Streams?**

- Stream operations like `findFirst()`, `findAny()`, `max()`, `min()` return an `Optional`.
- Helps in **functional-style handling of absent values**.
- Avoids explicit null checks and improves readability.

---

## 🔵 **Common Optional Operations with Streams**

### 1. `findFirst()`

Returns an `Optional` describing the **first element** of the stream.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Optional<String> firstName = names.stream().findFirst();
firstName.ifPresent(System.out::println); // Alice
```

### 2. `findAny()`

Returns an `Optional` describing **any element** of the stream (useful for parallel streams).

```java
Optional<String> anyName = names.parallelStream().findAny();
anyName.ifPresent(System.out::println);
```

### 3. `max()` / `min()`

Finds the maximum or minimum element according to a comparator and returns an `Optional`.

```java
Optional<Integer> maxNumber = Arrays.asList(1, 3, 2, 5, 4).stream().max(Integer::compareTo);
maxNumber.ifPresent(System.out::println); // 5
```

### 4. `orElse()` and `orElseGet()`

Provide a **default value** if the Optional is empty.

```java
String name = names.stream()
                   .filter(n -> n.startsWith("Z"))
                   .findFirst()
                   .orElse("Default Name");
System.out.println(name); // Default Name
```

### 5. `ifPresent()` / `ifPresentOrElse()`

Perform an action if the value is present.

```java
names.stream()
     .filter(n -> n.startsWith("A"))
     .findFirst()
     .ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
```

### 6. `map()` with Optional

Transform the value inside Optional without unwrapping manually.

```java
Optional<String> upperName = names.stream()
                                  .filter(n -> n.startsWith("B"))
                                  .findFirst()
                                  .map(String::toUpperCase);
upperName.ifPresent(System.out::println); // BOB
```

---

## 🟢 **Best Practices**

1. Avoid returning `null` from Stream operations; return `Optional` instead.
2. Use `ifPresent()` and `orElse()` for concise null handling.
3. Combine `Optional` with Stream operations for **safe and readable code**.
4. Be mindful: **Optional should not be used in collections or method parameters**.

---

Using `Optional` with Streams allows **safer, more expressive, and null-free functional programming**, making it an essential concept for modern Java development.

