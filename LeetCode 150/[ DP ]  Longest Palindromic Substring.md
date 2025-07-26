# 📘 LeetCode 5: Longest Palindromic Substring

---

## ✅ 0. Question with Explanation

Given a string `s`, return the longest palindromic substring in `s`.

### Example:

```java
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: s = "cbbd"
Output: "bb"
```

A palindrome is a string that reads the same backward as forward, like "racecar" or "madam".

---

## ✅ 1. Definition and Purpose

- **Concept**: String, Dynamic Programming, and Two Pointer Expansion
- **Why it exists**: Used in text-processing and pattern recognition problems
- **Problem it solves**: Extract the largest continuous sequence from a string that is a palindrome

---

## ✅ 2. Syntax and Structure

```java
public String longestPalindrome(String s);
```

- Input: A string s
- Output: A substring that is the longest palindromic portion of s

---

## ✅ 3. Practical Examples

```java
Input: "racecar"
Output: "racecar"

Input: "forgeeksskeegfor"
Output: "geeksskeeg"
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Expand Around Center (Optimized)

- Time: O(n^2), Space: O(1)
- Try expanding around each center (odd and even length)

```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandFromCenter(s, i, i);     // odd
        int len2 = expandFromCenter(s, i, i + 1); // even
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandFromCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}
```

### ✅ Approach 2: Dynamic Programming

- Time: O(n^2), Space: O(n^2)
- Build a dp table where dp[i][j] is true if substring from i to j is palindrome

```java
public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    String res = "";

    for (int l = 0; l < n; l++) {
        for (int i = 0; i + l < n; i++) {
            int j = i + l;
            if (s.charAt(i) == s.charAt(j) && (l < 2 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
                if (l + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
    }
    return res;
}
```

---

## ✅ 5. Best Practices

- Start with center expansion for O(1) space
- Use DP when you need to store intermediate results (interview safe)

---

## ✅ 6. Related Concepts

- Substring vs Subsequence
- Longest Palindromic Subsequence (not contiguous)

---

## ✅ 7. Interview & Real-world Use

- Common in interviews (Amazon, Google, Adobe)
- Used in DNA pattern recognition, search engines, spell checkers

---

## ✅ 8. Common Errors & Debugging

- Forgetting to expand both odd and even centers
- Off-by-one mistakes in substring indexes

---

## ✅ 9. Java Version Updates

- No specific improvements in newer Java versions for string DP
- Java 11+ offers new string utilities but not used here

---

## ✅ 10. Practice and Application

- LeetCode 5
- Longest Palindromic Subsequence (LC 516)
- Advanced: Manacher's algorithm (O(n))

---

