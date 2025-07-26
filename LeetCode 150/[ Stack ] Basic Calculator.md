# ✅ LeetCode 224: Basic Calculator

---

## ✅ 0. Question: Basic Calculator

Implement a basic calculator to evaluate a simple expression string containing only:
- non-negative integers,
- '+', '-', '(', ')', and
- empty spaces.

The expression is always valid. Assume the result is in the range of a 32-bit signed integer.

### Example:
```java
Input: "1 + 1"
Output: 2

Input: " 2-1 + 2 "
Output: 3

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
```

---

## ✅ 1. Definition and Purpose

- This problem is a classic parsing and stack problem.
- The goal is to simulate arithmetic evaluation using stack-based methods.
- It forms the foundation for interpreting arithmetic expressions.

---

## ✅ 2. Syntax and Structure

```java
public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0, number = 0, sign = 1;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            number = number * 10 + (c - '0');
        } else if (c == '+') {
            result += sign * number;
            number = 0;
            sign = 1;
        } else if (c == '-') {
            result += sign * number;
            number = 0;
            sign = -1;
        } else if (c == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            sign = 1;
        } else if (c == ')') {
            result += sign * number;
            number = 0;
            result *= stack.pop(); // sign
            result += stack.pop(); // result before parenthesis
        }
    }
    return result + sign * number;
}
```

---

## ✅ 3. Approach 1: Stack-Based Evaluation (Optimal)

- Use a stack to remember previous results and signs when entering a new parenthesis.
- Time: O(n), Space: O(n)

---

## ✅ 4. Approach 2: Recursive Descent Parsing (Advanced)

- Use recursion to handle nested parentheses.
- Each recursive call evaluates a subexpression.
- Not implemented here due to verbosity.

---

## ✅ 5. Internal Working

- Parse each character:
  - If digit: accumulate it.
  - If '+' or '-': commit the last number with sign.
  - If '(': save current result and sign.
  - If ')': resolve the subexpression.

---

## ✅ 6. Best Practices

- Always commit the previous number before changing sign/operator.
- Carefully handle parentheses nesting.
- Clean up remaining number after the loop.

---

## ✅ 7. Related Concepts

- Stack
- Expression Evaluation
- Recursion
- DFS parsing

---

## ✅ 8. Interview & Real-world Use

- Core parser logic for interpreters and compilers
- Common in interviews for parsing and recursion skills

---

## ✅ 9. Common Errors & Debugging

- Missing the last number at end of loop
- Forgetting to reset number after evaluation
- Not applying sign correctly inside parentheses

---

## ✅ 10. Java Version Updates

- Java 5+: Autoboxing support in Stack
- Java 8+: Stream API not relevant here

---

## ✅ 11. Practice and Application

- LeetCode 224, 227 (Basic Calculator II), 772 (Basic Calculator III)
- Building interpreters, scripting engines, math evaluators

---

## ✅ 12. ASCII Diagram

```
Expression: (1 + (4 + 5 + 2) - 3) + (6 + 8)

Stack Steps:
[(1+(4+5+2)-3)+(6+8)]
 → push(0), push(+)
 → 1 → + → push(1)
 → push(+)
 → 4 + 5 + 2 → commit(11)
 → -3 → commit(11 - 3)
 → pop sign & previous result
 → final result = 23
```

