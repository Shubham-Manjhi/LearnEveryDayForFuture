**Java Topic: Regex Use Cases**

---

### 1. Definition and Purpose
**What are Regex Use Cases?**
Regex (Regular Expressions) can be applied across a wide range of tasks involving pattern-based string searching, parsing, validation, and transformation.

**Why is it important in Java?**
Java's `java.util.regex` package allows for regex-based solutions in real-world applications like data processing, web scraping, and user input validation.

**Problem it Solves:**
- Automates complex string matching.
- Reduces code complexity in string manipulation.
- Useful for input validation and dynamic filtering.

---

### 2. Syntax and Structure
**Key Components in Java Regex API:**
- `Pattern`: Compiles regex string.
- `Matcher`: Applies the pattern on input text.
- `String.matches()`, `split()`, `replaceAll()` are regex-enabled.

**Basic Structure:**
```java
Pattern pattern = Pattern.compile("regex");
Matcher matcher = pattern.matcher("input string");
while (matcher.find()) {
    System.out.println(matcher.group());
}
```

---

### 3. Practical Use Cases
**1. Email Validation:**
```java
String regex = "^[\w.-]+@[\w.-]+\.\w{2,}$";
"user@example.com".matches(regex); // true
```

**2. Extracting Dates:**
```java
Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
Matcher matcher = pattern.matcher("DOB: 25/12/1995");
if (matcher.find()) System.out.println(matcher.group());
```

**3. Log File Parsing:**
```java
Pattern p = Pattern.compile("ERROR.*");
Matcher m = p.matcher(logContent);
while (m.find()) System.out.println(m.group());
```

**4. Phone Number Validation:**
```java
String regex = "^\\+91[- ]?\\d{10}$";
"+91-9876543210".matches(regex); // true
```

**5. Web Scraping HTML Tags:**
```java
Pattern p = Pattern.compile("<title>(.*?)</title>");
Matcher m = p.matcher(html);
if (m.find()) System.out.println(m.group(1));
```

---

### 4. Internal Working
- The compiled `Pattern` object builds a finite state machine.
- Matching operations involve character-by-character traversal.
- Supports backtracking, greedy/lazy quantifiers, and capture groups.

---

### 5. Best Practices
**Dos:**
- Precompile patterns for reuse.
- Use anchors (`^`, `$`) to restrict full string match.
- Use character classes and quantifiers wisely.

**Don'ts:**
- Avoid overcomplicating patterns.
- Don’t use regex when simple `String` methods suffice.

---

### 6. Related Concepts
- **Pattern Matching**: Useful in switch statements (Java 17+).
- **Streams + Regex**: Combine with Java Streams for log filtering.
- **Named Groups**: Supported via manual parsing or 3rd-party libs.

---

### 7. Interview & Real-world Use
**Interview Questions:**
- How would you extract all emails from a document?
- What regex would validate a 6-digit OTP code?

**Real-world Use:**
- Web scraping
- NLP tokenization and preprocessing
- Data migration tools (cleaning & transforming data)

---

### 8. Common Errors & Debugging
**Mistakes:**
- Forgetting to escape special characters.
- Using `matches()` instead of `find()` for partial matches.

**Debug Tips:**
- Use `Pattern.quote()` for literal matches.
- Visualize regex with online testers.
- Log captured groups during development.

---

### 9. Java Version Updates
- Java 1.4 introduced `Pattern` and `Matcher` classes.
- Java 9+ enhanced Unicode support and performance.
- Java 17: Pattern matching for `switch` (not regex but complementary).

---

### 10. Practice and Application
**Coding Practice:**
- Extract hashtags from social media posts.
- Parse logs to extract timestamps and log levels.

**Real-world Application:**
- Build a form validation engine.
- Use in data anonymization pipelines (mask sensitive fields).
- Regex-based ETL tools for text file transformation.

