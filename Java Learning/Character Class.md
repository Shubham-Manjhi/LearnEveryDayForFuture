# 🎯 Java Character Class - Core Concepts

📚 References:

- [TutorialsPoint - Java Characters](https://www.tutorialspoint.com/java/java_characters.htm)
- [Oracle Java 8 Docs - Character](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html)

---

## ✅ 1. Definition and Purpose

- The `Character` class wraps a primitive `char` value into an object.
- Part of the **java.lang** package.
- Provides numerous utility methods to work with characters: checking type (letter, digit, etc.), conversion, case manipulation.

### Why it exists:

- To enable usage of `char` as an object when necessary (e.g., in collections).
- Useful for parsing, processing input, or implementing lexical analyzers.

---

## ✅ 2. Syntax and Structure

### Declaration:

```java
char ch = 'A';
Character c = new Character('A');
Character c2 = 'B'; // Autoboxing
```

### Character literals:

```java
char a = 'a';
char newline = '\n'; // escape sequences
```

---

## ✅ 3. Practical Examples

### Example 1: Type Checks

```java
char ch = '9';
System.out.println(Character.isDigit(ch)); // true
System.out.println(Character.isLetter(ch)); // false
```

### Example 2: Case Conversion

```java
char upper = 'a';
System.out.println(Character.toUpperCase(upper)); // A
```

### Example 3: Unicode checks

```java
char emoji = '\u263A';
System.out.println(emoji); // ☺
```

---

## ✅ 4. Internal Working

- Internally stores `char` as a 16-bit Unicode character.
- Java uses UTF-16 encoding for characters.
- Autoboxing and unboxing convert between `char` and `Character` automatically in most cases.

---

## ✅ 5. Best Practices

- Prefer primitive `char` unless object-oriented usage is required.
- Use Character utility methods for type checks instead of manual range checks.
- Use constants from `Character` class (like `Character.MIN_VALUE`, `Character.MAX_VALUE`).

---

## ✅ 6. Related Concepts

- `char` primitive type
- Unicode and UTF-16 encoding
- `String` and `StringBuilder`
- Autoboxing/Unboxing in Java

---

## ✅ 7. Interview & Real-world Use

- Input validation (e.g., `Character.isDigit`, `isLetter`)
- String processing/parsing
- Lexical analysis and compilers
- GUI applications that require fine-grained keyboard event handling

---

## ✅ 8. Common Errors & Debugging

- Using single quotes (' ') for Strings instead of double quotes
- Confusion between `char` and `String`
- Using equality with `==` instead of `equals()` when dealing with `Character` objects

---

## ✅ 9. Java Version Updates

- Java 5+: Autoboxing support for `char` ↔ `Character`
- Java 7+: Enhanced Unicode support
- Java 9+: Minor API documentation improvements

---

## ✅ 10. Practice and Application

- HackerRank: Character classification
- LeetCode: Palindrome problems, string sanitization
- Implementing text tokenizers
- Form input validation

---

## ✅ 11. Complete List of Character Methods

```java
// Type checks
Character.isDigit(char);
Character.isLetter(char);
Character.isLetterOrDigit(char);
Character.isLowerCase(char);
Character.isUpperCase(char);
Character.isWhitespace(char);
Character.isDefined(char);
Character.isJavaIdentifierPart(char);
Character.isJavaIdentifierStart(char);
Character.isUnicodeIdentifierPart(char);
Character.isUnicodeIdentifierStart(char);
Character.isIdentifierIgnorable(char);
Character.isSpaceChar(char);

// Conversion
Character.toLowerCase(char);
Character.toUpperCase(char);
Character.toTitleCase(char);
Character.toString(char);

// Code point
Character.codePointAt(char[] a, int index);
Character.codePointBefore(char[] a, int index);
Character.codePointCount(char[] a, int offset, int count);
Character.highSurrogate(int codePoint);
Character.lowSurrogate(int codePoint);
Character.toChars(int codePoint);

// Constants
Character.MIN_VALUE; // '\u0000'
Character.MAX_VALUE; // '\uffff'
```

---

