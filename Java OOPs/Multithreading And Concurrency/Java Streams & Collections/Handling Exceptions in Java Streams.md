# Handling Exceptions in Java Streams

In Java Streams, handling exceptions can be tricky because lambda expressions used in Stream operations do not allow checked exceptions directly. Below are strategies and best practices:

---

## 1. **Unchecked vs Checked Exceptions**
- **Unchecked Exceptions (RuntimeException):**
  - Can be directly thrown inside streams without compilation issues.
- **Checked Exceptions:**
  - Not allowed directly in lambdas; must be handled or wrapped.

Example:
```java
List<String> data = Arrays.asList("10", "20", "invalid", "30");

List<Integer> result = data.stream()
    .map(s -> {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1; // fallback value
        }
    })
    .collect(Collectors.toList());

System.out.println(result); // [10, 20, -1, 30]
```

---

## 2. **Wrapper Method for Checked Exceptions**
We can create a helper function that converts a checked exception into a runtime exception.

```java
@FunctionalInterface
interface CheckedFunction<T, R> {
    R apply(T t) throws Exception;
}

static <T, R> Function<T, R> wrap(CheckedFunction<T, R> func) {
    return t -> {
        try {
            return func.apply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}

// Usage
List<String> lines = Files.lines(Paths.get("data.txt"))
    .map(wrap(line -> line.toUpperCase()))
    .collect(Collectors.toList());
```

---

## 3. **Using Utility Libraries (Vavr, Apache Commons)**
- Libraries like **Vavr** provide functional constructs to handle exceptions gracefully in streams.
- Example with Vavr:
```java
List<String> values = List.of("42", "invalid");

List<Integer> numbers = values.stream()
    .map(Try.of(() -> Integer.parseInt(s))
             .getOrElse(-1))
    .toList();
```

---

## 4. **Custom Error Handling Strategies**
- **Log & Skip:** Log the error and continue stream processing.
- **Fallback Values:** Provide defaults for invalid cases.
- **Collect Errors Separately:** Use a custom collector to store both successful and failed results.

Example (logging and skipping):
```java
List<String> input = Arrays.asList("5", "x", "15");

List<Integer> numbers = input.stream()
    .flatMap(s -> {
        try {
            return Stream.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + s);
            return Stream.empty();
        }
    })
    .collect(Collectors.toList());

System.out.println(numbers); // [5, 15]
```

---

## 5. **Best Practices**
- Prefer **unchecked exceptions** inside streams for simplicity.
- Use **wrapper methods** to handle checked exceptions.
- Apply **fallback strategies** (default values, logging, skipping).
- Avoid cluttering lambdas with heavy exception-handling logic.
- Consider **functional libraries** for more elegant solutions.

---

✅ **Summary:**
Exception handling in Streams requires wrapping checked exceptions or using strategies like fallback values, logging, or external libraries. Clean wrapper functions help keep lambdas concise and maintainable.

