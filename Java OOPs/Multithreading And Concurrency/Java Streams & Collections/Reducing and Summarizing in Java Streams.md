# ⚡ **Reducing and Summarizing in Java Streams**

Java Streams provide **powerful reduction and summarization operations** for performing aggregate calculations such as sum, average, min, max, and other statistical operations.

---

## ✨ **1. reduce()**

- **Purpose:** Aggregates stream elements into a single result.
- **Output:** Returns a single value, often using a **BinaryOperator**.

### Example - Sum of numbers:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, Integer::sum);
System.out.println("Sum: " + sum); // 15
```

### Example - Product of numbers:

```java
int product = numbers.stream()
                     .reduce(1, (a, b) -> a * b);
System.out.println("Product: " + product); // 120
```

**Key Points:**

- `reduce()` is versatile for **custom aggregation**.
- Supports **identity value** and **accumulator function**.

---

## ✨ **2. summarizingInt, summarizingDouble, summarizingLong**

- **Purpose:** Collects statistics such as count, sum, min, max, and average.

### Example:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
IntSummaryStatistics stats = numbers.stream()
                                   .collect(Collectors.summarizingInt(Integer::intValue));
System.out.println(stats);
// Output: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
```

**Key Points:**

- Convenient for **multiple summary statistics** in one operation.
- Works for `IntStream`, `LongStream`, `DoubleStream`.

---

## ✨ **3. sum()**

- **Purpose:** Computes the sum of numeric elements.
- **Example:**

```java
int sum = numbers.stream().mapToInt(Integer::intValue).sum();
System.out.println("Sum: " + sum); // 15
```

---

## ✨ **4. average()**

- **Purpose:** Computes the average of numeric elements.
- **Example:**

```java
OptionalDouble avg = numbers.stream().mapToInt(Integer::intValue).average();
avg.ifPresent(a -> System.out.println("Average: " + a)); // 3.0
```

---

## ✨ **5. min() / max()**

- **Purpose:** Finds the minimum or maximum element based on natural order or comparator.

### Example - Min and Max:

```java
Optional<Integer> min = numbers.stream().min(Integer::compareTo);
Optional<Integer> max = numbers.stream().max(Integer::compareTo);
min.ifPresent(m -> System.out.println("Min: " + m)); // 1
max.ifPresent(m -> System.out.println("Max: " + m)); // 5
```

---

## 🟢 **Best Practices**

1. Use `reduce()` for **custom aggregation**.
2. Use `Collectors.summarizingInt()` for **multiple summary statistics** efficiently.
3. Prefer `mapToInt()` / `mapToDouble()` for numeric streams to avoid boxing overhead.
4. Always handle `Optional` results to **prevent NullPointerException**.

---

Reducing and summarizing operations in Java Streams allow developers to **perform powerful aggregate computations** with concise, readable, and functional-style code.

