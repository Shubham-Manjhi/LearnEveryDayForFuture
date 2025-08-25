# ⚡ **Terminal Operations in Java Streams**

Terminal operations in Java Streams **produce a result or a side-effect** and close the stream. They trigger the evaluation of all preceding intermediate operations.

---

## ✨ **Common Terminal Operations**

### 1. `forEach(Consumer)`

Performs an action for each element of the stream.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream().forEach(name -> System.out.println(name));
```

### 2. `collect(Collector)`

Collects elements into a collection, map, string, or other container.

```java
List<String> upperNames = names.stream()
                               .map(String::toUpperCase)
                               .collect(Collectors.toList());
System.out.println(upperNames); // [ALICE, BOB, CHARLIE]
```

### 3. `reduce(BinaryOperator)`

Reduces the elements to a single value using an associative accumulation function.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream().reduce(0, (a, b) -> a + b);
System.out.println("Sum: " + sum); // 15
```

### 4. `count()`

Returns the number of elements in the stream.

```java
long count = names.stream().count();
System.out.println("Count: " + count); // 3
```

### 5. `anyMatch(Predicate)`

Returns `true` if any element matches the given predicate.

```java
boolean hasA = names.stream().anyMatch(name -> name.startsWith("A"));
System.out.println(hasA); // true
```

### 6. `allMatch(Predicate)`

Returns `true` if all elements match the given predicate.

```java
boolean allStartWithUpper = names.stream().allMatch(name -> Character.isUpperCase(name.charAt(0)));
System.out.println(allStartWithUpper); // true
```

### 7. `noneMatch(Predicate)`

Returns `true` if no elements match the given predicate.

```java
boolean noneStartWithZ = names.stream().noneMatch(name -> name.startsWith("Z"));
System.out.println(noneStartWithZ); // true
```

**Key Points:**

- Terminal operations **trigger lazy evaluation**.
- They **return a value** or produce a **side-effect**.
- Cannot be reused after a terminal operation is invoked on a stream.

---

Terminal operations are essential for **consuming stream data** and producing results in functional-style programming.

