**Java Topic: Java Records (Java 14+ Only)**

---

### 1. Definition and Purpose
**What are Java Records?**
Java Records are a special kind of class introduced in Java 14 (as a preview) and finalized in Java 16. Records are designed to be a **concise, immutable data carrier** that eliminates boilerplate code for common data-holding classes.

**Why do they exist in Java?**
To reduce verbosity and enforce immutability while preserving clarity and strong typing for plain data structures.

**Problem it Solves:**
- Eliminates the need to manually write `getters`, `constructors`, `equals()`, `hashCode()`, and `toString()`.
- Encourages immutability and cleaner design for DTOs.

---

### 2. Syntax and Structure
**Basic Syntax:**
```java
public record Person(String name, int age) {}
```

**What the above generates automatically:**
- A canonical constructor `Person(String name, int age)`
- Getters `name()` and `age()`
- Overridden `equals()`, `hashCode()`, and `toString()`

**Compact Constructor:**
```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
    }
}
```

---

### 3. Practical Examples
**Example: Using a Record in a List**
```java
List<Person> people = List.of(new Person("Alice", 25), new Person("Bob", 30));
for (Person p : people) {
    System.out.println(p.name() + " is " + p.age() + " years old.");
}
```

**Mini-Project Use Case:**
- Return value objects in REST APIs.
- Representing key-value pairs in configuration.

---

### 4. Internal Working
- Records extend `java.lang.Record`.
- Fields are `private final`.
- Compiler auto-generates boilerplate code.
- Cannot extend another class (records are implicitly final).

---

### 5. Best Practices
**Dos:**
- Use for simple immutable data containers.
- Use with validation logic in compact constructors if needed.

**Don'ts:**
- Don’t use records for entities with behavior/state.
- Don’t mutate fields via reflection or hacks.

---

### 6. Related Concepts
- **Lombok @Data**: Previously used to reduce boilerplate in POJOs.
- **Immutability**: Central to the design of records.
- **Value-Based Classes**: Records follow this design principle.

---

### 7. Interview & Real-world Use
**Interview Questions:**
- How are Java records different from classes?
- Can a record implement an interface?

**Real-world Use:**
- DTOs in Spring Boot or Jakarta EE applications.
- Storing rows of immutable configuration or input data.

---

### 8. Common Errors & Debugging
**Mistakes:**
- Trying to declare mutable fields (not allowed).
- Forgetting that you can't extend a class with a record.

**Debug Tips:**
- Use `.toString()` for logging record data.
- Breakpoints in compact constructors for validation.

---

### 9. Java Version Updates
- **Java 14**: Preview feature.
- **Java 15**: Second preview.
- **Java 16**: Standardized.
- Works seamlessly with Java 17 LTS and above.

---

### 10. Practice and Application
**Coding Practice:**
- Convert an existing POJO to a record.
- Implement a record that validates input in a compact constructor.

**Real-world Application:**
- Use in microservice APIs for response payloads.
- Immutable config or cache entries.
- As keys in `Map<RecordKey, Value>` structures.

