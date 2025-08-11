# 📘 LeetCode 3: Longest Substring Without Repeating Characters

---

## ✅ 0. Question

Given a string s, find the length of the longest substring without repeating characters.

### Example:
```text
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

---

## ✅ 1. Definition and Purpose

This problem tests your understanding of character tracking and sliding window techniques. It's crucial in scenarios involving stream processing, pattern matching, and data deduplication.

---

## ✅ 2. Syntax and Structure

```java
public int lengthOfLongestSubstring(String s);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Sliding Window with HashSet
```java
// ✅ Time: O(n), Space: O(n)
// We expand right pointer to add characters, and shrink left to maintain uniqueness
public int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>(); // Step 1: stores characters seen in current window
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        // Step 2: shrink window until character at right is unique
        while (seen.contains(s.charAt(right))) {
            seen.remove(s.charAt(left++)); // remove and move left forward
        }
        seen.add(s.charAt(right)); // Step 3: expand window
        maxLen = Math.max(maxLen, right - left + 1); // Step 4: update max length
    }
    return maxLen;
}
```

### 🔹 Approach 2: Sliding Window with HashMap (Tracks Last Seen Index)
```java
// ✅ Time: O(n), Space: O(128) ~ O(1)
// This method uses a map to store index of last seen character
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLen = 0;
    for (int right = 0, left = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        // Step 1: If character was seen, move left just past last occurrence
        if (map.containsKey(c)) {
            left = Math.max(left, map.get(c) + 1); // jump left pointer
        }
        // Step 2: Update last seen index for character
        map.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1); // Step 3: update max
    }
    return maxLen;
}
```

### ASCII Visual Walkthrough:
```
s = "abcabcbb"
        ^       → current char = 'a'
Seen = [a, b, c] → valid: length = 3
Reset window after repeat 'a'
→ Seen = [b, c, a] → continues...
```

---

## ✅ 4. Internal Working

- Uses two pointers (left/right) to define a sliding window
- HashSet avoids duplicates in the current window
- HashMap allows skipping unnecessary positions
- Both approaches scan each character at most once → O(n) time

---

## ✅ 5. Best Practices

- When characters can repeat, always track latest position
- Use Math.max to prevent moving the left pointer backward
- Choose HashMap over Set if character frequency/index is needed

---

## ✅ 6. Related Concepts

- Sliding Window
- HashSet / HashMap
- Two Pointers
- String Manipulation

---

## ✅ 7. Interview & Real-world Use

- Used in data compression and log parsing
- Widely asked in interviews (FAANG, startups)
- Critical for network packet parsing and tokenization

---

## ✅ 8. Common Errors & Debugging

- Forgetting to update the left pointer correctly
- Allowing duplicate characters in window
- Not updating maxLen in each iteration
- Not checking for empty or null input

---

## ✅ 9. Java Version Updates

- Java 8+: lambdas and Streams are available, but use imperative for performance
- Java 14+: Use switch expression if categorizing characters

---

## ✅ 10. Practice and Application

- LeetCode 76: Minimum Window Substring
- LeetCode 30: Substring with Concatenation of All Words
- LeetCode 159: Longest Substring with At Most Two Distinct Characters

---

🎯 Mastering this helps you solve many string parsing problems involving uniqueness, repetition, and indexing.

