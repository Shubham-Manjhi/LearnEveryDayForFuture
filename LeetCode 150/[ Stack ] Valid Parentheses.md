# ✅ LeetCode 20: Valid Parentheses

---

## ✅ 0. Question: Valid Parentheses

Given a string s containing just the characters `'(', ')', '{', '}', '['` and `']'`, determine if the input string is valid.

A string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

### Examples:
```java
Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false
```

---

## ✅ 1. Definition and Purpose

- This problem is used to validate bracket matching using a stack.
- Ensures correct pairing and nesting of parentheses — common in expression parsing.

### Why it exists:
- It's foundational for compiler design, syntax parsing, and code interpretation.

---

## ✅ 2. Syntax and Structure

Using Stack:
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(') stack.push(')');
        else if (ch == '{') stack.push('}');
        else if (ch == '[') stack.push(']');
        else if (stack.isEmpty() || stack.pop() != ch) return false;
    }
    return stack.isEmpty();
}
```

---

## ✅ 3. Approach 1: Stack (Optimized)

### Logic:
- Push expected closing brackets onto the stack.
- If incoming character doesn’t match the top, return false.
- Stack should be empty at the end.

### Time: O(n), Space: O(n)

---

## ✅ 4. Approach 2: Replace in Loop (Less Optimal)

```java
public boolean isValid(String s) {
    int length;
    do {
        length = s.length();
        s = s.replace("()", "").replace("[]", "").replace("{}", "");
    } while (s.length() != length);
    return s.isEmpty();
}
```

### Time: O(n^2), Space: O(1)
- Not suitable for long strings but simple to write.

---

## ✅ 5. Internal Working

- Stack stores the correct closing character for each opening one.
- The order of the stack ensures nested structure is validated.

---

## ✅ 6. Best Practices

- Always use stack for nested matching.
- Return early on mismatch for performance.
- Don't forget to check if stack is empty at the end.

---

## ✅ 7. Related Concepts

- Stack
- Expression parsing
- Tree traversal
- Balanced symbols checking

---

## ✅ 8. Interview & Real-world Use

- Common in parsing expressions, HTML tags, mathematical expressions
- Popular in interviews: Amazon, Microsoft, Facebook

---

## ✅ 9. Common Errors & Debugging

- Forgetting to check for empty stack before pop()
- Not checking stack is empty at end (unbalanced openers)
- Using wrong match mapping (e.g. '(' expecting '}' is wrong)

---

## ✅ 10. Java Version Updates

- Java 5+: Enhanced for-loop
- Java 8+: Streams available, but imperative logic clearer for this case

---

## ✅ 11. Practice and Application

- LeetCode 20
- Validating XML/JSON tags
- Syntax checking in IDEs and compilers

---

## ✅ 12. ASCII Diagram

```
Example: "{[()]}"

Stack:
Push } -> Stack: }
Push ] -> Stack: }, ]
Push ) -> Stack: }, ], )
Match ) -> pop()
Match ] -> pop()
Match } -> pop()

Final stack: empty → ✅ VALID
```

