# ⚡ **Combining Multiple Collectors in Java Streams**

Java Streams allow combining collectors to perform **complex aggregations** using `Collectors.collectingAndThen` and other collector composition techniques.

---

## ✨ **1. Collectors.collectingAndThen**

- **Purpose:** Wraps an existing collector and applies a finishing transformation on the result.
- **Use Case:** Useful when you want to **post-process collected data**.

### Example - Collecting to an Unmodifiable List:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<String> unmodifiableNames = names.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.toList(), 
        Collections::unmodifiableList
    ));

System.out.println(unmodifiableNames); // [Alice, Bob, Charlie]
```

### Explanation:

- `Collectors.toList()` collects stream elements into a list.
- `collectingAndThen` applies `Collections::unmodifiableList` to make the list immutable.

---

## ✨ **2. Combining with Mapping Collector**

- `Collectors.mapping()` can be combined with `collectingAndThen` for **transformation before final collection**.

### Example - Uppercasing and Collecting:

```java
List<String> upperNames = names.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.mapping(String::toUpperCase, Collectors.toList()),
        Collections::unmodifiableList
    ));

System.out.println(upperNames); // [ALICE, BOB, CHARLIE]
```

---

## ✨ **3. Combining with Grouping Collector**

- Can combine `groupingBy()` with `collectingAndThen` to process grouped results.

### Example - Count names by first letter and convert map to unmodifiable:

```java
Map<Character, Long> nameCount = names.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()),
        Collections::unmodifiableMap
    ));

System.out.println(nameCount); // {A=1, B=1, C=1}
```

### Explanation:

- `groupingBy` groups names by first character and counts occurrences.
- `collectingAndThen` wraps the resulting map as unmodifiable.

---

## 🟢 **Best Practices**

1. Use `collectingAndThen` for **post-processing of collected results**.
2. Combine with `mapping`, `groupingBy`, or `summarizing` collectors for **powerful data transformations**.
3. Avoid excessive nesting of collectors for readability.
4. Prefer immutability when possible using `collectingAndThen` with unmodifiable collections.

---

Combining multiple collectors with `collectingAndThen` allows developers to **perform sophisticated transformations and aggregations** in a **concise and functional manner**.

