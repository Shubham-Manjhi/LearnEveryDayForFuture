## 📘 Java Topic: Arithmetic Operators

---

### ✅ 0. Introduction

Java Arithmetic Operators are used to perform basic mathematical operations. These operators work with primitive data types like `int`, `float`, `double`, etc.

---

### ✅ 1. Definition and Purpose

- **What is it?** Arithmetic operators are symbols that perform mathematical operations.
- **Why does it exist in Java?** To enable developers to perform basic math in programs.
- **What problem does it solve?** Allows easy computation and expression evaluation in logic.

---

### ✅ 2. Syntax and Structure

| Operator | Description    | Example (a=10, b=5) | Result |
| -------- | -------------- | ------------------- | ------ |
| +        | Addition       | a + b               | 15     |
| -        | Subtraction    | a - b               | 5      |
| \*       | Multiplication | a \* b              | 50     |
| /        | Division       | a / b               | 2      |
| %        | Modulus        | a % b               | 0      |

---

### ✅ 3. Practical Examples

```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10, b = 5;

        System.out.println("Addition: " + (a + b));        // 15
        System.out.println("Subtraction: " + (a - b));     // 5
        System.out.println("Multiplication: " + (a * b));  // 50
        System.out.println("Division: " + (a / b));        // 2
        System.out.println("Modulus: " + (a % b));         // 0
    }
}
```

---

### ✅ 4. Internal Working

Java evaluates arithmetic operators using JVM's operand stack. Integer operations are done using bytecode like `iadd`, `isub`, etc.

---

### ✅ 5. Best Practices

- Use parentheses to enforce precedence.
- Be careful with division: dividing integers truncates decimals.
- Avoid division by zero.

---

### ✅ 6. Related Concepts

- Compound assignment: `+=`, `-=`, etc.
- Unary operators: `++`, `--`
- Operator precedence

---

### ✅ 7. Interview & Real-world Use

- Often used in loops, counters, calculations in finance, gaming, etc.
- Common interview questions: precedence and result prediction.

---

### ✅ 8. Common Errors & Debugging

- Dividing by zero: throws `ArithmeticException`
- Using `int` instead of `double` may lose precision

---

### ✅ 9. Java Version Updates

No changes in arithmetic operators across versions. Remains consistent.

---

### ✅ 10. Practice and Application

- Try evaluating expressions on platforms like CodingBat or HackerRank.
- Use operators in building billing logic, statistics calculator, or game scores.

---

