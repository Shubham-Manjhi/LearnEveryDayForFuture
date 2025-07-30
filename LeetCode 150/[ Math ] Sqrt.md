# 📘 LeetCode 69: Sqrt(x)

---

## ✅ 0. Question

Implement `int sqrt(int x)`, where `x` is a non-negative integer. The computed square root should be truncated (i.e., rounded down to the nearest integer).

### Example:
```java
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want only the integer part, the answer is 2.
```

---

## ✅ 1. Definition and Purpose

- Calculating integer square root is common in problems involving distance, area, and constraints on growth.
- Java lacks a built-in integer-only version of square root that guarantees no floating-point rounding.
- Truncated square root is useful for search, geometry, optimization.

---

## ✅ 2. Syntax and Structure

```java
public int mySqrt(int x)
```
- Input: non-negative integer x
- Output: truncated square root of x

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Binary Search (Optimized)

```java
public int mySqrt(int x) {
    if (x < 2) return x;
    int left = 1, right = x / 2;
    int ans = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        // Use long to prevent overflow
        long sq = (long) mid * mid;
        if (sq == x) return mid;
        else if (sq < x) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}
```

⏱ Time: O(log x), 🔁 Space: O(1)

### 🔹 Approach 2: Newton’s Method (Iterative Convergence)

```java
public int mySqrt(int x) {
    if (x == 0) return 0;
    long r = x;
    while (r * r > x) {
        r = (r + x / r) / 2;
    }
    return (int) r;
}
```

⏱ Time: O(log x), 🔁 Space: O(1), ✅ Fast convergence

---

## ✅ 4. Internal Working

### Binary Search:
- Divides [1, x/2] to find `mid * mid <= x`
- Tracks closest smaller square using `ans`

### Newton:
- Iteratively improves guess using: r = (r + x/r) / 2
- Converges faster than binary search

---

## ✅ 5. Best Practices

- Prevent integer overflow using `long` during square multiplication.
- Avoid Math.sqrt + cast: may cause floating-point errors.
- Use Newton when high performance is needed.

---

## ✅ 6. Related Concepts

- Binary Search Pattern
- Floating Point Arithmetic
- Convergence Algorithms

---

## ✅ 7. Interview & Real-world Use

- Frequently asked in coding interviews
- Used in geometric problems, optimization, root finding
- Seen in LeetCode, HackerRank, Google, Amazon rounds

---

## ✅ 8. Common Errors & Debugging

- Overflow with `mid * mid` when `x` is large (use `long`)
- Infinite loop in Newton's method if initial guess is poor (rare)
- Not handling x == 0 or x == 1 as special cases

---

## ✅ 9. Java Version Updates

- No direct support for integer square roots.
- Math.sqrt() exists (returns double), use only if rounding acceptable

---

## ✅ 10. Practice and Application

- LeetCode 367: Valid Perfect Square
- LeetCode 441: Arranging Coins
- Geometry: radius/diameter calculations, Pythagoras

---

🧠 Learn both Binary Search & Newton’s for mastery. Know when each shines based on input size, platform, and rounding requirements.

