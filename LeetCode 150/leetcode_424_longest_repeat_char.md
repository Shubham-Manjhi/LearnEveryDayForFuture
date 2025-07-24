**LeetCode 424: Longest Repeating Character Replacement**

---

### 1. Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. Perform this operation at most `k` times. Return the length of the **longest substring** containing the same letter you can get after performing the above operations.

---

### 2. Why It’s Asked in Interviews

- Focuses on sliding window mastery
- Balances window expansion vs character frequency
- Tests understanding of greedy and window shrinking

---

### 3. Optimal Approach: Sliding Window + Frequency Array

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

- **Time:** O(n)
- **Space:** O(1) (fixed 26 character array)

---

### 4. ASCII Flow Example

```
s = "AABABBA", k = 1

Sliding window:
- At i=0: A → window = A
- At i=1: A → window = AA
- At i=2: B → AAB → maxFreq = 2 → valid
- At i=3: A → AABA → maxFreq = 3 → valid
- At i=4: B → AABAB → invalid (5-3 > 1) → shrink
- Shrink from left → window = ABAB
- Continue → result = 4
```

---

### 5. Edge Cases

- All characters same → return length
- k ≥ length of string → can convert all
- k = 0 → longest run of identical characters

---

### 6. Interview Tips

- Emphasize window size vs max frequency
- Avoid re-scanning entire frequency table
- Think greedy: maxFreq gives most efficient choice

---

### 7. Practice More

- LeetCode 3: Longest Substring Without Repeating Characters
- LeetCode 1004: Max Consecutive Ones III
- LeetCode 159: Longest Substring with At Most Two Distinct Characters

---

✅ Summary:

- Use sliding window to track valid substring
- Shrink window when invalid condition met
- Maintain max frequency to validate quickly

---

