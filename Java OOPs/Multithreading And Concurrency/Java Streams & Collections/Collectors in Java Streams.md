# 🎯 Collectors in Java Streams

## 🌟 Purpose of Collectors
Collectors in Java Streams are utility methods provided by the **`java.util.stream.Collectors`** class that allow you to accumulate the elements of a stream into a collection, map, string, or even perform aggregation like sum, average, or grouping. They serve as powerful **terminal operations** to transform stream results into a desired data structure or summary.

---

## 🔑 Why Use Collectors?
- To gather stream elements into **collections** (`List`, `Set`, `Map`).
- To perform **aggregation operations** like counting, averaging, or summing.
- To enable **grouping** and **partitioning** of stream elements.
- To simplify **string concatenation** from stream data.
- To make stream pipelines **more expressive** and **readable**.

---

## 🛠️ Commonly Used Collector Factory Methods

### 1️⃣ **Collect to List or Set**
```java
List<String> names = people.stream()
    .map(Person::getName)
    .collect(Collectors.toList());

Set<Integer> uniqueAges = people.stream()
    .map(Person::getAge)
    .collect(Collectors.toSet());
```

### 2️⃣ **Collect to Map**
```java
Map<Integer, String> idToName = people.stream()
    .collect(Collectors.toMap(Person::getId, Person::getName));
```

### 3️⃣ **Counting Elements**
```java
long count = people.stream()
    .collect(Collectors.counting());
```

### 4️⃣ **Joining Strings**
```java
String names = people.stream()
    .map(Person::getName)
    .collect(Collectors.joining(", "));
```

### 5️⃣ **Summarizing (Sum, Average, Statistics)**
```java
double avgAge = people.stream()
    .collect(Collectors.averagingInt(Person::getAge));

IntSummaryStatistics stats = people.stream()
    .collect(Collectors.summarizingInt(Person::getAge));
```

### 6️⃣ **Grouping Elements**
```java
Map<String, List<Person>> peopleByCity = people.stream()
    .collect(Collectors.groupingBy(Person::getCity));
```

### 7️⃣ **Partitioning Elements**
```java
Map<Boolean, List<Person>> partitioned = people.stream()
    .collect(Collectors.partitioningBy(p -> p.getAge() > 30));
```

---

## ✅ Best Practices
- Use `Collectors.toUnmodifiableList()` or `toUnmodifiableSet()` when immutability is required.
- Prefer **groupingBy + downstream collectors** for nested aggregations.
- Avoid `Collectors.toMap()` without handling duplicate keys.
- For performance, consider using **parallel streams with collectors** when processing large datasets.

---

## 🚀 Summary
Collectors are **powerful terminal operations** in Java Streams that allow transformation, grouping, partitioning, and summarizing of data with concise and expressive syntax. They make Java Streams highly practical for real-world applications where you need to collect and organize results.

