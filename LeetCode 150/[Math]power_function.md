**Java Problem: LeetCode 50 – Pow(x, n)**

---

✅ 0. Question & Explanation

Implement a function to compute x raised to the power n (i.e., x^n). Return a double result. The algorithm must run in O(log n) time.

🧠 Examples:
- Input: x = 2.00000, n = 10 → Output: 1024.00000
- Input: x = 2.10000, n = 3 → Output: 9.26100
- Input: x = 2.00000, n = -2 → Output: 0.25000

---

✅ 1. Definition and Purpose

• What is the concept?\
Efficient exponentiation (also called fast power or exponentiation by squaring).

• Why does it exist in Java?\
To support mathematical operations with large powers efficiently.

• What problem does it solve?\
Reduces time complexity of computing powers from O(n) to O(log n).

---

✅ 2. Syntax and Structure

Method signature:
```java
public double myPow(double x, int n)
```

Core ideas:
- Recursive or iterative approach
- Handle negative exponents
- Avoid overflow for Integer.MIN_VALUE

---

✅ 3. Practical Examples

🔹 Recursive Approach:
```java
public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n < 0) {
        x = 1 / x;
        n = -n;
    }
    return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
}
```

🔹 Iterative Approach (Handles overflow):
```java
public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }
    double result = 1;
    while (N > 0) {
        if ((N % 2) == 1) result *= x;
        x *= x;
        N /= 2;
    }
    return result;
}
```

---

✅ 4. Internal Working

• Converts negative n to positive, adjusts base\
• Uses exponentiation by squaring:\
    - x^n = (x^2)^(n/2) when n is even\
    - x^n = x * (x^2)^(n/2) when n is odd

Time Complexity: O(log n)\
Space Complexity: O(1) for iterative, O(log n) for recursive

---

✅ 5. Best Practices

✔ Always cast n to long to handle Integer.MIN_VALUE\
✔ Prefer iterative for better stack safety\
✔ Validate for edge cases like x = 0, n = 0, etc.

---

✅ 6. Related Concepts

- Recursion
- Bit manipulation (checking parity)
- Divide and conquer

🧠 Related: Fibonacci with fast doubling

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Common binary recursion/optimization question\
- Shows mastery of time complexity reduction

🏢 Real-world:
- Scientific computing\
- Cryptography (modular exponentiation)

---

✅ 8. Common Errors & Debugging

❌ Ignoring overflow of int range when negating n\
❌ Infinite recursion for n = Integer.MIN_VALUE

🧪 Debug Tip:
Use long N = n to safely negate if n is negative

---

✅ 9. Java Version Updates

• Math.pow(x, n) exists but is less precise for custom logic\
• Java 8+ supports lambda-based math utils but not recommended here

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #50
- CodingNinjas Power and Recursion series

🏗 Apply in:
- Compiler design (expression evaluation)
- Cryptographic key generation

---

