**LeetCode 20: Valid Parentheses**

---

### 1. Problem Statement
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

An input string is valid if:
- Open brackets are closed by the same type of brackets.
- Open brackets are closed in the correct order.
- Every closing bracket has a corresponding opening bracket of the same type.

**Function Signature:**
```java
boolean isValid(String s)
```

---

### 2. Understanding the Problem
- This is a stack-based matching problem.
- You push opening brackets and match them when closing brackets are encountered.

---

### 3. Optimal Approach (Stack + HashMap)
**Idea:**
Use a stack to track opening brackets. Use a map to associate closing brackets with their correct opening ones.

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    for (char ch : s.toCharArray()) {
        if (map.containsKey(ch)) {
            char top = stack.isEmpty() ? '#' : stack.pop();
            if (top != map.get(ch)) return false;
        } else {
            stack.push(ch);
        }
    }

    return stack.isEmpty();
}
```

---

### 4. Complexity Analysis
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) (stack size in worst case)

---

### 5. Edge Cases to Consider
- Empty string → valid
- Only closing brackets → invalid
- Unmatched brackets

---

### 6. Example
```java
Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([)]"
Output: false
```

---

### 7. Best Practices
- Always check for empty stack before popping
- Use a `HashMap` or `switch` for matching pairs

---

### 8. Related Topics
- Stack
- String
- HashMap

---

### 9. Interview Tip
> Mention use of stack for LIFO structure. Compare with evaluating expressions or compilers where similar matching logic is needed.

---

### 10. Follow-up
> Can you validate expressions with wildcard characters like `*`, where `*` could be treated as any bracket or empty? Consider advanced parsing techniques or recursive validation.

