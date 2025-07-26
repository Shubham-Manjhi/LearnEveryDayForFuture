# 🎯 Java Strings - Core Concepts

📚 References:
- [TutorialsPoint - Java Strings](https://www.tutorialspoint.com/java/java_strings.htm)
- [Oracle Java 8 Docs - String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

---

## ✅ 1. Definition and Purpose

- The `String` class in Java represents a sequence of characters.
- Strings in Java are **immutable** — once created, their values cannot be changed.
- Widely used in file paths, user input, messages, logging, and APIs.

### Why it exists:
- Java doesn’t use primitive `char[]` arrays for string manipulation directly, but wraps them in the powerful `String` class for security, memory efficiency, and utility functions.

---

## ✅ 2. Syntax and Structure

### Declaration:
```java
String str = "Hello, World!";
String str2 = new String("Java");
```

- String literals are stored in the **String pool** (heap memory optimization).
- `String` class is final (cannot be extended).

### Common Constructors:
```java
String();
String(String original);
String(char[] value);
String(char[] value, int offset, int count);
String(byte[] bytes);
```

---

## ✅ 3. Practical Examples

### Example 1: Basic Operations
```java
String s = "OpenAI";
System.out.println(s.length()); // Output: 6
System.out.println(s.charAt(0)); // Output: O
System.out.println(s.substring(1, 4)); // Output: pen
```

### Example 2: Comparison
```java
String a = "hello";
String b = new String("hello");
System.out.println(a == b); // false (reference check)
System.out.println(a.equals(b)); // true (value check)
```

---

## ✅ 4. Internal Working

- Strings are backed by a `char[]` internally (until Java 8).
- After Java 9, internally uses `byte[]` with a `coder` (LATIN1 or UTF16).
- Stored in **String Pool** when declared as literals.
- JVM reuses the same string object for identical literals.

### ASCII Diagram:
```
+-----------+
| "Java"    |<--+     (String Pool)
+-----------+   |
                 +-- Multiple references to same literal
```

### Memory Efficiency:
- Pooling ensures only one object exists per literal.
- Reduces memory overhead.

---

## ✅ 5. Best Practices

- Use `.equals()` for string comparison, not `==`
- Avoid concatenation in loops (use `StringBuilder` instead)
- Prefer string literals for reuse and pooling
- Use `.trim()` to sanitize input
- Avoid excessive substring chaining which may lead to readability issues

---

## ✅ 6. Related Concepts

- `StringBuilder` and `StringBuffer`: Mutable alternatives
- `CharSequence` Interface
- Regular Expressions
- `Pattern` and `Matcher` classes

---

## ✅ 7. Interview & Real-world Use

- Common in system design, backend APIs, and validation
- Frequently tested for:
  - Immutability
  - Memory optimization via String pool
  - Comparison pitfalls (== vs equals)
- Used in data serialization, JSON/XML handling

---

## ✅ 8. Common Errors & Debugging

- Using `==` instead of `.equals()`
- Forgetting immutability: `s.replace()` returns a new string
- Index out of bounds in `charAt()` or `substring()`
- NullPointerExceptions when not checking for nulls before calling methods

---

## ✅ 9. Java Version Updates

- Java 7+: `String` in `switch` statements
- Java 8+: Improved performance of `.join()` and `.chars()`
- Java 9+: Compact Strings (`byte[]` and `coder` optimizations)
- Java 13+: Text Blocks (multi-line string literals using `"""`)

---

## ✅ 10. Practice and Application

- LeetCode: Longest Palindromic Substring, Valid Anagram
- HackerRank: String Manipulation
- Build:
  - Input parsers
  - Tokenizers
  - String validation utilities
- Use in Spring Boot: `@RequestParam`, logging, exception messages

---

## ✅ 11. Complete List of String Methods (as per Java 8)

```java
String s = "Example";

// Basic Info
s.length();
s.isEmpty();
s.charAt(0);
s.codePointAt(0);
s.codePointBefore(1);
s.codePointCount(0, s.length());
s.offsetByCodePoints(0, 1);

// Comparison
s.equals("Example");
s.equalsIgnoreCase("example");
s.compareTo("test");
s.compareToIgnoreCase("test");
s.startsWith("Ex");
s.endsWith("le");
s.regionMatches(0, "Example", 0, 3);
s.contains("amp");

// Searching
s.indexOf('a');
s.lastIndexOf('a');
s.indexOf("amp");
s.lastIndexOf("amp");

// Substring and Extraction
s.substring(0, 4);
s.subSequence(0, 4);

// Modification
s.concat(" String");
s.replace('a', 'A');
s.replace("amp", "AMP");
s.replaceAll("a", "A");
s.replaceFirst("a", "A");

// Trimming and Case
s.trim();
s.toLowerCase();
s.toUpperCase();

// Conversion
s.toCharArray();
s.getBytes();
s.getBytes("UTF-8");

// Matching and Splitting
s.matches(".*amp.*");
s.split("a");
s.split("a", 2);

// Formatting and Static Utility
String.format("%s %d", "Age:", 30);
String.join("-", "A", "B", "C");

// Interning and Identity
s.intern();
s.hashCode();

// Stream APIs
s.chars();
s.codePoints();
```

---

