## 📘 Java Topic: BigDecimal Class

---

### ✅ 0. Introduction

BigDecimal is a Java class from the `java.math` package used to handle high-precision arithmetic operations. It's especially useful in financial and scientific computations where accuracy is critical.

---

### ✅ 1. Definition and Purpose

- **What is it?** BigDecimal is an immutable, arbitrary-precision signed decimal number.
- **Why does it exist in Java?** To avoid floating-point precision issues in calculations.
- **What problem does it solve?** Provides precision in operations involving large numbers or exact decimal values (e.g., currency, tax).

---

### ✅ 2. Syntax and Structure

```java
import java.math.BigDecimal;

BigDecimal num1 = new BigDecimal("10.25");
BigDecimal num2 = new BigDecimal("3.75");
BigDecimal result = num1.add(num2);
```

---

### ✅ 3. Practical Examples

```java
public class BigDecimalExample {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.05");
        BigDecimal b = new BigDecimal("0.95");

        // Addition
        BigDecimal sum = a.add(b);
        System.out.println("Sum: " + sum);

        // Subtraction
        BigDecimal diff = a.subtract(b);
        System.out.println("Difference: " + diff);

        // Multiplication
        BigDecimal prod = a.multiply(b);
        System.out.println("Product: " + prod);

        // Division with scale and rounding mode
        BigDecimal div = a.divide(b, 2, RoundingMode.HALF_UP);
        System.out.println("Division: " + div);
    }
}
```

---

### ✅ 4. Internal Working

- BigDecimal stores numbers as `unscaledValue × 10^(-scale)`.
- Internally uses `BigInteger` for unscaled values.
- Immutable design: any operation returns a new instance.

---

### ✅ 5. Best Practices

- Always use String constructor to avoid float/double issues.
- Specify rounding mode and scale explicitly during division.
- Avoid chaining multiple operations without intermediate variables.

---

### ✅ 6. Related Concepts

- `BigInteger` for integer-only precision.
- `MathContext` for specifying precision and rounding.
- `RoundingMode` enum: defines rounding behavior (HALF\_UP, CEILING, etc).

---

### ✅ 7. Interview & Real-world Use

- Common in finance applications (e.g., billing, currency conversion).
- Appears in interview questions related to precision and correctness.

---

### ✅ 8. Common Errors & Debugging

- Division without specifying scale and rounding mode throws `ArithmeticException`.
- Instantiating with `double` may introduce rounding error:
  - Use `new BigDecimal("0.1")` instead of `new BigDecimal(0.1)`.

---

### ✅ 9. Java Version Updates

- Java 5+ introduced new `valueOf(double)` to mitigate float constructor issues.
- Java 8+ improved performance and added utility methods like `stripTrailingZeros()`.

---

### ✅ 10. BigDecimal Class Methods (with Explanation)

| Method                                                             | Description                                                                          |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `add(BigDecimal augend)`                                           | Returns a BigDecimal whose value is `(this + augend)`                                |
| `subtract(BigDecimal subtrahend)`                                  | Returns a BigDecimal whose value is `(this - subtrahend)`                            |
| `multiply(BigDecimal multiplicand)`                                | Returns a BigDecimal whose value is `(this * multiplicand)`                          |
| `divide(BigDecimal divisor)`                                       | Divides `this` by the divisor. Throws ArithmeticException if non-terminating decimal |
| `divide(BigDecimal divisor, int scale, RoundingMode roundingMode)` | Returns quotient rounded to given scale and rounding mode                            |
| `remainder(BigDecimal divisor)`                                    | Returns remainder of this divided by divisor                                         |
| `pow(int n)`                                                       | Returns `this^n`                                                                     |
| `negate()`                                                         | Returns a BigDecimal whose value is `(-this)`                                        |
| `abs()`                                                            | Returns absolute value                                                               |
| `compareTo(BigDecimal val)`                                        | Compares two BigDecimals. Returns -1, 0, or 1                                        |
| `equals(Object x)`                                                 | Checks for equality                                                                  |
| `min(BigDecimal val)`                                              | Returns smaller of this and val                                                      |
| `max(BigDecimal val)`                                              | Returns larger of this and val                                                       |
| `movePointLeft(int n)`                                             | Moves decimal point `n` places to the left                                           |
| `movePointRight(int n)`                                            | Moves decimal point `n` places to the right                                          |
| `scale()`                                                          | Returns scale of the BigDecimal                                                      |
| `setScale(int newScale)`                                           | Returns a BigDecimal with the given scale                                            |
| `stripTrailingZeros()`                                             | Removes trailing zeros from the value                                                |
| `toPlainString()`                                                  | Returns string without scientific notation                                           |
| `toEngineeringString()`                                            | Returns string using engineering notation                                            |
| `toString()`                                                       | Returns string representation                                                        |
| `valueOf(long val)`                                                | Converts long to BigDecimal                                                          |
| `valueOf(double val)`                                              | Converts double to BigDecimal using canonical string representation                  |

---

### ✅ 11. Practice and Application

- Use in backend accounting systems (Spring Boot, Hibernate).
- Solve high-precision math problems on HackerRank, LeetCode.
- Integrate in REST APIs that deal with money or tax calculations.

---

