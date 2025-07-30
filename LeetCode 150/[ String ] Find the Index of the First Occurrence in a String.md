# 📘 LeetCode 28: Find the Index of the First Occurrence in a String

---

## ✅ 0. Question

Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.

### Example:
```text
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
```
```text
Input: haystack = "leetcode", needle = "leeto"
Output: -1
```

---

## ✅ 1. Definition and Purpose

- This problem asks us to locate the first index where a substring (needle) appears inside another string (haystack).
- Helps understand string matching and searching algorithms.

---

## ✅ 2. Syntax and Structure

```java
public int strStr(String haystack, String needle);
```

- Input: Two strings `haystack` and `needle`
- Output: Integer index of first occurrence, or -1

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Built-in Method
```java
public int strStr(String haystack, String needle) {
    // Step 1: Use Java's built-in method indexOf()
    return haystack.indexOf(needle);
}
```

### 🔹 Approach 2: Manual Sliding Window Search
```java
public int strStr(String haystack, String needle) {
    int hLen = haystack.length();
    int nLen = needle.length();

    // Step 1: Loop through each position where needle might start
    for (int i = 0; i <= hLen - nLen; i++) {
        // Step 2: Check if substring from i to i+nLen matches needle
        if (haystack.substring(i, i + nLen).equals(needle)) {
            return i; // Step 3: Return index if match found
        }
    }

    // Step 4: If no match found, return -1
    return -1;
}
```

---

## ✅ 4. Internal Working

- The built-in `indexOf()` uses efficient substring matching algorithms (like Boyer-Moore or Rabin-Karp internally).
- Manual approach performs naive sliding window comparison.

---

## ✅ 5. Best Practices

- Prefer built-in methods for simplicity unless custom logic is needed.
- Use `.substring()` carefully as it may create temporary objects.
- Avoid unnecessary operations in loops.

---

## ✅ 6. Related Concepts

- String Manipulation
- Sliding Window
- Substring Matching
- KMP Algorithm (for advanced pattern matching)

---

## ✅ 7. Interview & Real-world Use

- Common interview problem to test basic string handling.
- Applied in search engines, code parsers, and editors.

---

## ✅ 8. Common Errors & Debugging

- Index out of bounds in custom substring extraction
- Off-by-one errors in loop range
- Comparing `==` instead of `.equals()` for strings

---

## ✅ 9. Java Version Updates

- Java 7+: `indexOf()` highly optimized
- Java 9+: String internally uses byte[] instead of char[] for memory efficiency

---

## ✅ 10. Practice and Application

- LeetCode 14: Longest Common Prefix
- LeetCode 459: Repeated Substring Pattern
- LeetCode 686: Repeated String Match

---

🔍 This problem lays the foundation for string pattern search and is key for more advanced algorithms!

