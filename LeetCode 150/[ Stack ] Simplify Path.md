# ✅ LeetCode 71: Simplify Path

---

## ✅ 0. Question: Simplify Path

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

### Example:
```java
Input: "/home/"
Output: "/home"

Input: "/a/./b/../../c/"
Output: "/c"

Input: "/../"
Output: "/"
```

### Rules:
- ".." → Move one directory up.
- "." → Stay in the same directory.
- "//" → Treated as a single "/"
- Always return the canonical path starting with "/" and no trailing slash (unless root).

---

## ✅ 1. Definition and Purpose

- The problem simplifies a Unix-style file path to its canonical form.
- Helps in resolving redundant navigation elements like `.` and `..`

### Why it exists:
- Useful in OS and filesystem design
- Needed for building file managers, CLI tools, and backend path resolvers

---

## ✅ 2. Syntax and Structure

### Java Stack-based Structure:
```java
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    for (String part : path.split("/")) {
        if (part.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else if (!part.isEmpty() && !part.equals(".")) {
            stack.push(part);
        }
    }
    return "/" + String.join("/", stack);
}
```

---

## ✅ 3. Approach 1: Stack-Based (Optimized)

### Steps:
1. Split the path by "/"
2. For each segment:
   - If "." → ignore
   - If ".." → pop from stack if not empty
   - Else → push into stack
3. Join the stack with "/" for canonical path

### Time Complexity: O(n), Space: O(n)

---

## ✅ 4. Approach 2: Using Deque (Same Idea)

```java
public String simplifyPath(String path) {
    Deque<String> deque = new LinkedList<>();
    for (String part : path.split("/")) {
        if (part.equals("..")) {
            if (!deque.isEmpty()) deque.removeLast();
        } else if (!part.isEmpty() && !part.equals(".")) {
            deque.addLast(part);
        }
    }
    return "/" + String.join("/", deque);
}
```

---

## ✅ 5. Internal Working

- Stack simulates directory traversal: push for descend, pop for ascend.
- Ignore redundant slashes or current-directory references.
- Empty stack → root directory

---

## ✅ 6. Best Practices

- Always split path using "/" safely.
- Avoid pushing "." or empty strings.
- Prefer `Deque` for performance over Stack if LIFO is enough.

---

## ✅ 7. Related Concepts

- Stack / Deque
- String splitting and manipulation
- File path resolution in Operating Systems

---

## ✅ 8. Interview & Real-world Use

- Common in system design and OS/file management tools
- Validating CLI input
- Web development: resolving URL paths

---

## ✅ 9. Common Errors & Debugging

- Not checking if stack/deque is empty before popping
- Forgetting to add root "/" at beginning
- Accidentally appending extra slash at the end

---

## ✅ 10. Java Version Updates

- Java 8: `String.join`, lambda-friendly
- Java 6+: `Deque` introduced with better performance than `Stack`

---

## ✅ 11. Practice and Application

- LeetCode 71
- CLI file explorers, file systems, URL normalization

---

## ✅ 12. ASCII Diagram

```
Input: /a/./b/../../c/

Split: ["", "a", ".", "b", "..", "..", "c"]

Step-by-step:
+ push("a")
+ "." → ignore
+ push("b")
+ ".." → pop("b")
+ ".." → pop("a")
+ push("c")

Final Stack: ["c"]
Result: "/c"
```

