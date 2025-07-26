# 📘 LeetCode 139: Word Break

---

## ✅ 0. Question with Explanation

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

### Example:

```java
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming, Recursion with Memoization
- **Why it exists**: To solve partition-based decision problems
- **Problem it solves**: Determines whether a string can be split into dictionary words

---

## ✅ 2. Syntax and Structure

```java
public boolean wordBreak(String s, List<String> wordDict);
```

- `s`: the input string
- `wordDict`: list of valid words (dictionary)
- Return: `true` if `s` can be split, `false` otherwise

---

## ✅ 3. Practical Examples

### Example:

```java
s = "catsandog";
wordDict = ["cats","dog","sand","and","cat"];
Output: false
```

### ASCII Diagram:

```
s = "catsandog"
      |
Check: "cats" -> and -> oops "og" not in dictionary -> false
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Dynamic Programming (Bottom-Up)

- Time: O(n^2), Space: O(n)

```java
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true; // empty string

    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
}
```

### Step-by-step Example:

```text
s = "leetcode", wordDict = ["leet", "code"]

DP: [T, F, F, F, T, F, F, F, T]
     0  1  2  3  4  5  6  7  8

Check dp[0] && "leet"? YES => dp[4] = true
Check dp[4] && "code"? YES => dp[8] = true
```

### ✅ Approach 2: Recursion with Memoization

- Time: O(n^2), Space: O(n) recursion + memo

```java
public boolean wordBreak(String s, List<String> wordDict) {
    return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
}

private boolean dfs(String s, Set<String> wordSet, int start, Boolean[] memo) {
    if (start == s.length()) return true;
    if (memo[start] != null) return memo[start];

    for (int end = start + 1; end <= s.length(); end++) {
        if (wordSet.contains(s.substring(start, end)) && dfs(s, wordSet, end, memo)) {
            return memo[start] = true;
        }
    }
    return memo[start] = false;
}
```

---

## ✅ 5. Best Practices

- Always use HashSet for quick dictionary lookup
- Memoize intermediate results to avoid TLE

---

## ✅ 6. Related Concepts

- Trie (Prefix Tree)
- Backtracking
- Substring checking

---

## ✅ 7. Interview & Real-world Use

- Appears frequently in software engineering interviews
- Useful for natural language processing, input validation

---

## ✅ 8. Common Errors & Debugging

- Not initializing dp[0] to true
- Off-by-one errors in substring range
- Not handling memoization properly in recursive approach

---

## ✅ 9. Java Version Updates

- Java 8: Use `Set.of(...)` for small dictionaries
- Java 9+: `List.of(...)` utility

---

## ✅ 10. Practice and Application

- LeetCode 139: Word Break
- LeetCode 140: Word Break II
- Hackerrank Dictionary problems

---

