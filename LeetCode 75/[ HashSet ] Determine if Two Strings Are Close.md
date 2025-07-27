# 📘 LeetCode 1657: Determine if Two Strings Are Close

---

## ✅ 0. Question

Given two strings `word1` and `word2`, return `true` if `word1` and `word2` are close, and `false` otherwise.

Two strings are considered close if you can attain one from the other using the following operations:

1. Swap any two existing characters (e.g. changing "aacabb" to "bbcaaa")
2. Transform every occurrence of one existing character into another existing character, and do the same with the other character (e.g. "aacabb" to "bbcaaa"). You can only use this operation if the character you're transforming into already exists in the string.

### Example:
```java
Input: word1 = "abc", word2 = "bca"
Output: true

Input: word1 = "a", word2 = "aa"
Output: false

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
```

---

## ✅ 1. Definition and Purpose

This problem is about verifying whether two strings are transformable into each other using specific rules.

### Why It Matters:
- Helps practice frequency counting
- Involves set and multiset comparisons
- Tests understanding of string manipulation rules

---

## ✅ 2. Syntax and Structure

- Use frequency maps or arrays
- Use sets to check character availability
- Use multisets (sorted frequency values) to compare frequency distributions

---

## ✅ 3. Practical Example (Approach 1: Frequency and Set Comparison)

### ✅ Code (Step-by-step with Comments):
```java
public boolean closeStrings(String word1, String word2) {
    // Step 1: If lengths differ, cannot be transformed
    if (word1.length() != word2.length()) return false;

    // Step 2: Create frequency arrays
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();

    // Step 3: Count frequencies and characters in word1
    for (char c : word1.toCharArray()) {
        freq1[c - 'a']++;
        set1.add(c);
    }

    // Step 4: Count frequencies and characters in word2
    for (char c : word2.toCharArray()) {
        freq2[c - 'a']++;
        set2.add(c);
    }

    // Step 5: Compare character sets
    if (!set1.equals(set2)) return false;

    // Step 6: Sort frequencies and compare
    Arrays.sort(freq1);
    Arrays.sort(freq2);
    return Arrays.equals(freq1, freq2);
}
```

### Explanation:
- Set equality ensures transformability via mapping.
- Sorted frequency equality ensures rearrangement feasibility.

---

## ✅ 4. Internal Working

- Characters must be the same (operation 2 can't introduce new characters)
- Frequency values must match after sorting to support swapping

---

## ✅ 5. Best Practices
- Always check string lengths first
- Use sorted frequency arrays instead of HashMaps for faster comparison
- Avoid unnecessary operations once mismatch is found

---

## ✅ 6. Related Concepts
- Anagrams
- Multisets
- HashSet, HashMap vs Arrays

---

## ✅ 7. Interview & Real-world Use
- Real-world scenario: Word transformations
- Common in interviews to test string transformation and frequency logic

---

## ✅ 8. Common Errors & Debugging
- Comparing raw frequency values without sorting
- Using equals() for arrays instead of Arrays.equals()
- Forgetting that operation 2 needs both characters to exist already

---

## ✅ 9. Java Version Updates
- Java 8+ allows `Arrays.equals()` and `Arrays.sort()` on primitive arrays
- Can use Java Streams but primitive arrays are faster for 26-letter alphabet

---

## ✅ 10. Practice and Application
- LeetCode 242: Valid Anagram
- LeetCode 49: Group Anagrams
- LeetCode 383: Ransom Note

---

✅ Summary:
- Use Set to ensure valid characters
- Use frequency comparison to validate transformability
- O(n) time with O(1) space due to fixed 26 characters

