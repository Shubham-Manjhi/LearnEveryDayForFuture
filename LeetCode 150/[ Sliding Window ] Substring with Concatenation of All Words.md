# 📘 LeetCode 30: Substring with Concatenation of All Words

---

## ✅ 0. Question

You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, without any intervening characters, in any order.

### Example:
```text
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
```

---

## ✅ 1. Definition and Purpose

This problem combines string search with hashing and sliding window logic. It's helpful in text searching, token indexing, and NLP token pattern extraction.

---

## ✅ 2. Syntax and Structure

```java
public List<Integer> findSubstring(String s, String[] words);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute-force Sliding Window with HashMap
```java
// ✅ Time: O((N - WL * WN + 1) * WL * WN), Space: O(WN)
// Where N = s.length(), WL = word length, WN = number of words
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (words.length == 0 || s.length() == 0) return result;

    int wordLen = words[0].length();           // Step 1: length of each word
    int wordCount = words.length;              // Step 2: number of words
    int totalLen = wordLen * wordCount;        // Step 3: total length to match

    Map<String, Integer> wordFreq = new HashMap<>(); // Step 4: frequency map of words
    for (String word : words) wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

    // Step 5: iterate over every possible starting point
    for (int i = 0; i <= s.length() - totalLen; i++) {
        Map<String, Integer> seen = new HashMap<>();
        int j = 0;
        while (j < wordCount) {
            int wordStart = i + j * wordLen;
            String part = s.substring(wordStart, wordStart + wordLen);
            if (!wordFreq.containsKey(part)) break;
            seen.put(part, seen.getOrDefault(part, 0) + 1);
            if (seen.get(part) > wordFreq.get(part)) break;
            j++;
        }
        if (j == wordCount) result.add(i); // All words matched
    }
    return result;
}
```

### 🔹 Approach 2: Optimized Offset-based Sliding Window
```java
// ✅ Time: O(WL * (N - totalLen)), Space: O(WN)
// Optimizes by only iterating over word length offsets
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (words.length == 0 || s.length() == 0) return result;

    int wordLen = words[0].length();
    int wordCount = words.length;
    int totalLen = wordLen * wordCount;

    Map<String, Integer> wordFreq = new HashMap<>();
    for (String word : words) wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);

    // Iterate over all starting points within word length window
    for (int i = 0; i < wordLen; i++) {
        int left = i, count = 0;
        Map<String, Integer> seen = new HashMap<>();

        for (int right = i; right <= s.length() - wordLen; right += wordLen) {
            String word = s.substring(right, right + wordLen);
            if (wordFreq.containsKey(word)) {
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                // Slide window if a word exceeds expected frequency
                while (seen.get(word) > wordFreq.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) result.add(left);
            } else {
                seen.clear();
                count = 0;
                left = right + wordLen;
            }
        }
    }
    return result;
}
```

### ASCII Visual Example:
```
s = "barfoothefoobarman"
          ^
Window length = 6
Slide 3-char steps: "bar" → "foo" → "the"...
Match "barfoo" or "foobar" → record index
```

---

## ✅ 4. Internal Working

- Use hash maps to track required vs seen word frequency
- Traverse s with multiple start offsets (0 to wordLen - 1)
- Avoid re-checking same sequences with optimized window shifting

---

## ✅ 5. Best Practices

- Validate all assumptions (non-null input, equal word lengths)
- Optimize inner loops using window tracking
- Avoid redundant substring operations

---

## ✅ 6. Related Concepts

- Hashing
- Sliding Window
- String Manipulation
- Two Pointers

---

## ✅ 7. Interview & Real-world Use

- Common in text pattern matching and NLP
- Used in log analysis for detecting event patterns
- Asked in FAANG interviews regularly

---

## ✅ 8. Common Errors & Debugging

- Not accounting for repeated words in the list
- Overlapping windows not handled correctly
- Forgetting to reset pointers/state between offsets

---

## ✅ 9. Java Version Updates

- Java 8+: Lambdas can simplify map merging
- Java 9+: Map.of() is handy for immutable map creation

---

## ✅ 10. Practice and Application

- LeetCode 3: Longest Substring Without Repeating Characters
- LeetCode 76: Minimum Window Substring
- LeetCode 187: Repeated DNA Sequences

---

🎯 Understanding this gives you deep insight into sliding window algorithms mixed with frequency counting and substring parsing.

