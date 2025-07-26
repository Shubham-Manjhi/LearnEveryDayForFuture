# 💡 LeetCode 67: Add Binary

---

## ✅ 1. Definition and Purpose

- Problem: Given two binary strings `a` and `b`, return their sum as a binary string.
- Purpose: Handle binary addition similar to manual addition (right to left with carry), essential in bit manipulation or low-level data ops.

---

## ✅ 2. Syntax and Structure

```java
public String addBinary(String a, String b)
```
- Input: Two non-empty binary strings of length ≤ 10⁴.
- Output: Binary sum string.

---

## ✅ 3. Practical Example

```java
Input: a = "1010", b = "1011"
Output: "10101"
```

### Manual Addition:
```
   1010
+  1011
-------
  10101
```

---

## ✅ 4. Approach: Two Pointer with StringBuilder

```java
public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    // Traverse both strings from end
    while (i >= 0 || j >= 0 || carry != 0) {
        int sum = carry;
        if (i >= 0) sum += a.charAt(i--) - '0';
        if (j >= 0) sum += b.charAt(j--) - '0';

        sb.append(sum % 2); // binary digit
        carry = sum / 2;    // carry for next digit
    }

    return sb.reverse().toString();
}
```

---

## ✅ 5. Internal Working

- We simulate manual addition from right to left.
- Use a StringBuilder to efficiently append digits.
- Carry is maintained and appended last if required.
- Time: O(max(n, m)), Space: O(max(n, m))

---

## ✅ 6. ASCII Diagram

```
   a:     1 0 1 0
   b:     1 0 1 1
   sum: 1 0 1 0 1
   idx:     ↑
           i j (pointers move left)
```

---

## ✅ 7. Best Practices

- Don’t convert to integers due to potential overflow.
- Use StringBuilder instead of `+` for string concatenation.
- Always check carry at the end.

---

## ✅ 8. Related Concepts

- Bit manipulation
- Character to digit conversion
- Carry-forward logic

---

## ✅ 9. Interview & Real-world Use

- Low-level string-based addition
- Useful in embedded/firmware level data computation
- Bitwise addition implementation for binary protocols

---

## ✅ 10. Common Errors & Debugging

- Forgetting to handle final carry
- Using `+` to concatenate (inefficient)
- Not converting characters correctly using `- '0'`

---

## ✅ 11. Practice and Application

- LeetCode 66: Plus One
- LeetCode 415: Add Strings
- Custom calculator apps (binary/hex)

---

✅ Understanding binary addition strengthens your grasp of bitwise operations and string manipulation.

