# 📘 LeetCode 72: Edit Distance

---

## ✅ 0. Question with Explanation

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

Example:

```java
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
- horse -> rorse (replace 'h' with 'r')
- rorse -> rose (remove 'r')
- rose -> ros (remove 'e')
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming (DP)
- **Why it exists**: To find the minimum cost (edit operations) to convert one string into another.
- **Problem it solves**: String comparison in NLP, diff tools, spell checkers, etc.

---

## ✅ 2. Syntax and Structure

```java
public int minDistance(String word1, String word2);
```

- Input: Two strings
- Output: Minimum number of operations to make the strings equal

---

## ✅ 3. Practical Examples

```java
word1 = "intention", word2 = "execution"
Output: 5
Steps: intention → inention → enention → exention → exection → execution
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: DP Matrix (Bottom-Up Tabulation)

Time: O(m \* n), Space: O(m \* n)

```java
public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            if (i == 0) {
                dp[i][j] = j; // Insert all
            } else if (j == 0) {
                dp[i][j] = i; // Remove all
            } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(
                    dp[i - 1][j - 1], // Replace
                    Math.min(dp[i][j - 1], // Insert
                             dp[i - 1][j]) // Delete
                );
            }
        }
    }
    return dp[m][n];
}
```

### ✅ Approach 2: Optimized DP with 2 Arrays

Time: O(m \* n), Space: O(n)

```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[] prev = new int[n + 1];
    int[] curr = new int[n + 1];

    for (int j = 0; j <= n; j++) prev[j] = j;

    for (int i = 1; i <= m; i++) {
        curr[0] = i;
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1))
                curr[j] = prev[j - 1];
            else
                curr[j] = 1 + Math.min(
                    prev[j - 1], // Replace
                    Math.min(prev[j], // Delete
                             curr[j - 1]) // Insert
                );
        }
        int[] temp = prev;
        prev = curr;
        curr = temp;
    }
    return prev[n];
}
```

---

## ✅ 5. Best Practices

- Start from base cases (empty string).
- Always compare characters from i-1 and j-1 in strings.
- Optimize space to O(n) if matrix not required.

---

## ✅ 6. Related Concepts

- Longest Common Subsequence (LCS)
- Sequence Alignment in Bioinformatics
- Spell Checkers / Autocorrect

---

## ✅ 7. Interview & Real-world Use

- Common DP question in FAANG interviews
- Used in diff tools (Git), spell correction engines, text comparison

---

## ✅ 8. Common Errors & Debugging

- Off-by-one indexing
- Forgetting initialization (base cases)
- Misunderstanding which operation applies (insert/delete/replace)

---

## ✅ 9. Java Version Updates

- No significant change related to language version.
- Modern Java (14+) may use `record` for tuple-style return in variations.

---

## ✅ 10. Practice and Application

- LeetCode 72
- HackerRank Edit Distance
- Dynamic programming grid practice

---

