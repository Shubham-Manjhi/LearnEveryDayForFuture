# ✅ LeetCode 150: Evaluate Reverse Polish Notation (RPN)

---

## ✅ 0. Question: Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

### Example:
```java
Input: ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Input: ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

---

## ✅ 1. Definition and Purpose

- Reverse Polish Notation is a mathematical notation in which every operator follows all of its operands.
- RPN eliminates the need for parentheses to define order of operations.
- Widely used in calculators and stack-based virtual machines.

---

## ✅ 2. Syntax and Structure

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
        if (isOperator(token)) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(applyOperator(a, b, token));
        } else {
            stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
}

private boolean isOperator(String token) {
    return "+-*/".contains(token);
}

private int applyOperator(int a, int b, String op) {
    switch (op) {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": return a / b;
    }
    return 0;
}
```

---

## ✅ 3. Approach 1: Stack-Based Evaluation (Optimized)

- Use a stack to store operands.
- When encountering an operator, pop two elements, apply the operator, and push the result back.
- Time: O(n), Space: O(n)

---

## ✅ 4. Approach 2: Manual Tracking (Index-based without Stack) [Not Recommended]

This is a harder-to-implement method and not space efficient.

---

## ✅ 5. Internal Working

- RPN is evaluated left-to-right.
- Operators always apply to the two most recent operands.
- No precedence rules required.

---

## ✅ 6. Best Practices

- Always validate operator before applying
- Use `Integer.parseInt()` safely with try-catch for robustness
- Keep functions modular: token parsing, operator handling

---

## ✅ 7. Related Concepts

- Stack Data Structure
- Expression Parsing
- Postfix Evaluation

---

## ✅ 8. Interview & Real-world Use

- Common interview question to test stack understanding
- Used in interpreters and postfix calculators

---

## ✅ 9. Common Errors & Debugging

- Popping from empty stack
- Division by zero (handle in production)
- Parsing errors from malformed inputs

---

## ✅ 10. Java Version Updates

- Java 8: Lambda-friendly if you want to build a function map
- Java 5+: Enhanced Stack and Generics

---

## ✅ 11. Practice and Application

- LeetCode 150, 224, 227
- Expression Evaluators, VM engines

---

## ✅ 12. ASCII Diagram

```
Input: ["2","1","+","3","*"]

Initial Stack: []
Push 2 → [2]
Push 1 → [2, 1]
Operator + → Pop 1 & 2 → Push (2+1)=3 → [3]
Push 3 → [3, 3]
Operator * → Pop 3 & 3 → Push (3*3)=9 → [9]

Result: 9
```

