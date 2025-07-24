**Java Topic: Introduction to Regex**

---

### 1. Definition and Purpose
**What is Regex?**
Regex (short for **Regular Expression**) is a powerful tool for pattern matching and text processing. In Java, regex is primarily used via the `java.util.regex` package.

**Why does it exist in Java?**
To allow developers to search, validate, extract, or replace text efficiently based on complex patterns.

**Problem it Solves:**
- Matches flexible string patterns (e.g., emails, dates).
- Cleans, transforms, or extracts data from text.
- Enables powerful search functionality in files, logs, and APIs.

---

### 2. Syntax and Structure
**Basic Regex Syntax:**
```java
.   // Any character
*   // Zero or more occurrences
+   // One or more occurrences
?   // Zero or one occurrence
[a-z] // Character range
\d  // Any digit
\w  // Any word character (alphanumeric + _)
\s  // Whitespace
```

**Java Usage:**
```java
import java.util.regex.*;

Pattern pattern = Pattern.compile("\d{3}-\d{2}-\d{4}");
Matcher matcher = pattern.matcher("123-45-6789");
boolean match = matcher.matches();
```

---

### 3. Practical Examples
**Example 1: Validate Email**
```java
String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
Pattern pattern = Pattern.compile(emailRegex);
Matcher matcher = pattern.matcher("test@example.com");
System.out.println(matcher.matches()); // true
```

**Example 2: Extract Words**
```java
String input = "Java is powerful";
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group());
}
```

**Mini-Project Use Case:**
- Log parsing for error patterns.
- Scraping emails or phone numbers from a document.

---

### 4. Internal Working
- `Pattern` compiles the regex into a pattern object.
- `Matcher` applies the pattern to a string.
- Regex engine scans text from left to right, using finite automata.
- Supports backtracking and greedy/lazy quantifiers.

---

### 5. Best Practices
**Dos:**
- Always compile the pattern once when reusing it.
- Use anchors (`^`, `$`) to restrict full matches.
- Use `matcher.find()` for substring matches.

**Don'ts:**
- Avoid complex nested patterns when simpler ones will do.
- Don’t forget to double-escape backslashes in Java strings (`"\\d"`).

---

### 6. Related Concepts
- **String.matches()**: Shortcut method for quick pattern checks.
- **split() and replaceAll()**: String methods that support regex.
- **Lookahead/Lookbehind**: Advanced regex constructs.

---

### 7. Interview & Real-world Use
**Interview Questions:**
- How do you validate an email with regex?
- What's the difference between `matches()` and `find()`?

**Real-world Use:**
- Input validation (emails, phone numbers).
- Text extraction in NLP pipelines.
- Filtering logs or command-line output.

---

### 8. Common Errors & Debugging
**Mistakes:**
- Using `matches()` instead of `find()` for partial matches.
- Forgetting to escape special characters.

**Debug Tips:**
- Test patterns using online regex testers.
- Log matcher groups to inspect pattern behavior.

---

### 9. Java Version Updates
- Core regex API (`Pattern`, `Matcher`) stable since Java 1.4.
- Java 9+: Unicode character classes (`\p{}`) support improved.

---

### 10. Practice and Application
**Coding Practice:**
- Validate IP addresses, dates, and credit card numbers.
- Extract hashtags or mentions from social media text.

**Real-world Application:**
- Build a regex-powered input validator.
- Implement a log analyzer that flags critical errors using patterns.

