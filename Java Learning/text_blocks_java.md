**Java Topic: Text Blocks (Java 13+)**

---

### 1. Definition and Purpose

**What are Text Blocks?** Text Blocks are a multi-line string literal feature introduced in **Java 13** (as a preview) and made permanent in **Java 15**. It allows developers to create strings spanning multiple lines without escaping characters or manually adding newline symbols.

**Why does it exist in Java?** To improve the readability and maintainability of multi-line string literals (e.g., SQL, JSON, HTML) in Java code.

**Problem it Solves:**

- Reduces need for escape characters (`\n`, `\t`, etc.).
- Improves readability of embedded code or markup.
- Simplifies code involving multi-line content.

---

### 2. Syntax and Structure

**Basic Syntax:**

```java
String json = """
  {
    "name": "John",
    "age": 30
  }
""";
```

**Rules:**

- Starts and ends with three double quotes (`"""`).
- Content starts on a new line.
- Leading whitespace is normalized automatically.
- Escape sequences still work (`\n`, `\t`, etc.) but are often unnecessary.

---

### 3. Practical Examples

**Example: HTML Markup**

```java
String html = """
  <html>
    <body>
      <h1>Hello, World!</h1>
    </body>
  </html>
""";
```

**Example: SQL Query**

```java
String sql = """
  SELECT *
  FROM users
  WHERE age > 25
  ORDER BY name;
""";
```

**Mini-Project Use Case:**

- Creating REST responses with multi-line JSON.
- Generating HTML email templates within code.

---

### 4. Internal Working

- At compile-time, the Java compiler interprets the content inside a text block and compiles it into a regular `String` object.
- The JVM treats it like any other `String`, with all immutability and memory behaviors intact.
- Whitespace normalization trims incidental indentation to preserve structure.

---

### 5. Best Practices

**Dos:**

- Use for embedding readable multi-line content.
- Combine with `String.format()` for dynamic sections.

**Don'ts:**

- Avoid overly large blocks that hinder readability.
- Don’t mix dynamic logic into static blocks — keep them clean.

---

### 6. Related Concepts

- **String Literals**: Traditional string declarations.
- **StringBuilder**: Useful for dynamic content creation.
- **Formatted Strings**: Use `String.format()` with text blocks for templates.

---

### 7. Interview & Real-world Use

**Interview Questions:**

- What are text blocks and their benefits?
- When would you use a text block over `StringBuilder`?

**Real-world Use:**

- Java-based DSLs or scripts.
- Email templates and large SQL query generation.
- JSON or XML stubs in unit tests.

---

### 8. Common Errors & Debugging

**Mistakes:**

- Forgetting to place content on a new line after opening `"""`.
- Unexpected trimming of whitespace if indentation is inconsistent.

**Debug Tips:**

- Use `.strip()` to remove leading/trailing whitespace when necessary.
- Print with delimiters (`|`) to debug extra spaces or newlines.

---

### 9. Java Version Updates

- **Java 13**: Introduced as a preview.
- **Java 14**: Preview feature continued.
- **Java 15**: Made permanent.
- **Java 17+**: Widely adopted and stable for enterprise use.

---

### 10. Practice and Application

**Coding Practice:**

- Write multi-line HTML using a text block.
- Create a formatted SQL report.

**Real-world Application:**

- Unit testing JSON payloads.
- Embedding large templates without messy string escapes.
- Readable configuration injection in code.

