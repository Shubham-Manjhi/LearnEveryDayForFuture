# ✅ LeetCode 392: Is Subsequence

---

## ✅ 0. Question: Is Subsequence

Given two strings `s` and `t`, return true if `s` is a subsequence of `t`, or false otherwise.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

### Example:
```java
Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false
```

---

## ✅ 1. Definition and Purpose

- This problem verifies whether one string appears in another in order (not necessarily contiguous).
- It's commonly used to understand pointer manipulation and greedy traversal techniques.

### Why it exists in Java:
- Helps assess understanding of string manipulation and iteration logic.

---

## ✅ 2. Syntax and Structure

```java
public boolean isSubsequence(String s, String t) {
    ...
}
```

---

## ✅ 3. Approach 1: Two-Pointer Technique (Optimal)

### Idea:
- Use two pointers: one on `s`, one on `t`
- If characters match, move both pointers
- If not, move pointer in `t`

### Code:
```java
public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) {
            i++; // Match found, move both
        }
        j++; // Always move j
    }
    return i == s.length(); // True if all of s was matched
}
```

### Time: O(n), Space: O(1)

---

## ✅ 4. Approach 2: Dynamic Programming (for many subsequence checks)

### Idea:
- Pre-process `t` to store index of next character occurrence for each position.
- Use binary search (if needed) to speed up multiple queries.

Useful when checking many `s` strings against same `t`.

---

## ✅ 5. Internal Working

- The two-pointer method scans left to right ensuring that every character of `s` can be found in `t` in order.
- No need to store intermediate results; match is decided on pointer alignment.

---

## ✅ 6. Best Practices

- Handle edge cases: empty `s` (should return true), `t` shorter than `s` (false)
- Avoid using `contains()` or `indexOf()` inside loop, as it can degrade performance

---

## ✅ 7. Related Concepts

- Two Pointers
- Greedy Matching
- String traversal
- Dynamic Programming (for multiple queries)

---

## ✅ 8. Interview & Real-world Use

- Asked in string manipulation rounds at Amazon, Facebook
- Used in input filtering, sequence matching, and pattern search systems

---

## ✅ 9. Common Errors & Debugging

- Forgetting to move pointers correctly
- Missing base case when `s` is empty
- Infinite loop by not moving pointer `j`

---

## ✅ 10. Java Version Updates

- Java 8+: Functional approaches using streams, not suitable for performance
- Java 11+: Still best to use index-based string traversal

---

## ✅ 11. Practice and Application

- LeetCode #392
- Cracking the Coding Interview: String section
- Used in DNA sequence matching

---

## ✅ 12. Visual Diagram

```
s =  "abc"
t = "ahbgdc"

Pointer i -> a   b   c
Pointer j -> a h b g d c
            ✔   ✔       ✔
```

- i reaches end of `s`, so return true

---

Let me know if you'd like to generate a PDF or proceed to the next topic!

