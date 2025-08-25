# ⚡ **Intermediate Operations in Java Streams**

Intermediate operations in Java Streams allow **lazy, functional-style transformations** on a stream of elements. They return a new stream and are executed only when a terminal operation is invoked.

---

## ✨ **Common Intermediate Operations**

### 1. `filter(Predicate)`
Filters elements based on a given condition.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> filtered = names.stream()\                             
                             .filter(name -> name.startsWith("A"))
                             .collect(Collectors.toList());
System.out.println(filtered); // [Alice]
```

### 2. `map(Function)`
Transforms each element of the stream into another object.

```java
List<String> upperNames = names.stream()
                               .map(String::toUpperCase)
                               .collect(Collectors.toList());
System.out.println(upperNames); // [ALICE, BOB, CHARLIE, DAVID]
```

### 3. `flatMap(Function)`
Flattens nested streams or collections into a single stream.

```java
List<List<String>> nested = Arrays.asList(
    Arrays.asList("A", "B"),
    Arrays.asList("C", "D")
);
List<String> flatList = nested.stream()
                              .flatMap(List::stream)
                              .collect(Collectors.toList());
System.out.println(flatList); // [A, B, C, D]
```

### 4. `distinct()`
Removes duplicate elements from the stream.

```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
List<Integer> distinctNumbers = numbers.stream()
                                       .distinct()
                                       .collect(Collectors.toList());
System.out.println(distinctNumbers); // [1, 2, 3, 4, 5]
```

### 5. `sorted()`
Sorts elements in natural order or using a comparator.

```java
List<String> sortedNames = names.stream()
                                .sorted()
                                .collect(Collectors.toList());
System.out.println(sortedNames); // [Alice, Bob, Charlie, David]
```

### 6. `peek(Consumer)`
Performs an action on each element of the stream, useful for debugging.

```java
names.stream()
     .peek(name -> System.out.println("Processing: " + name))
     .map(String::toUpperCase)
     .collect(Collectors.toList());
```

**Key Points:**
- Intermediate operations can be **chained**.
- Execution is **lazy** and triggered only by terminal operations.
- Proper use can **optimize performance** and improve **readability**.

---

These operations form the **building blocks of functional programming in Java**, enabling concise and expressive stream-based data manipulation.

