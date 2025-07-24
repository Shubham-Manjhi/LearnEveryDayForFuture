**LeetCode 567: Permutation in String**

---

### 1. Problem Statement
Given two strings `s1` and `s2`, return `true` if `s2` contains a **permutation** of `s1`, or `false` otherwise. In other words, return true if one of `s1`'s permutations is the substring of `s2`.

---

### 2. Why It’s Asked in Interviews
- Tests sliding window and character frequency tracking
- Requires efficient substring comparison
- Mix of array/hashmap + window logic

---

### 3. Optimal Approach: Sliding Window + Frequency Comparison
```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                windowFreq[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
```
- **Time:** O(n)
- **Space:** O(1) (fixed 26-letter array)

---

### 4. ASCII Flow Example
```
s1 = "ab", s2 = "eidbaooo"

s1Freq: [1,1,...]
window of size 2:
"ei" → [e,i] ≠ [a,b]
"id" → [i,d] ≠ [a,b]
"db" → [d,b] ≠ [a,b]
"ba" → match → return true
```

---

### 5. Edge Cases
- `s1` length > `s2` → immediately return false
- Empty `s1` → treat as always valid? (clarify in interview)
- Case-sensitive comparisons

---

### 6. Interview Tips
- Explain how sliding window shrinks by removing left char
- Optimize with int array instead of HashMap
- Compare arrays using `Arrays.equals()`

---

### 7. Practice More
- LeetCode 438: Find All Anagrams in a String
- LeetCode 76: Minimum Window Substring
- LeetCode 3: Longest Substring Without Repeating Characters

---

✅ Summary:
- Use a sliding window of size `s1.length()` over `s2`
- Compare frequency maps at each step
- Avoid brute force with efficient sliding window updates

---

