**LeetCode 424: Longest Repeating Character Replacement**

---

### 1. Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. Perform this operation at most `k` times. Return the length of the **longest substring** containing the same letter you can get after performing the above operations.

---

### 2. Why It’s Asked in Interviews

- Focuses on **sliding window** mastery
- Balances window expansion vs character frequency
- Tests greedy thinking and substring manipulation

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
- **Space:** O(1) (fixed-size 26-letter array)

---

### 4. ASCII Walkthrough Example

```
s = "AABABBA", k = 1

Sliding window:
[0,3] → "AABA" → maxFreq = 3 → length = 4 → valid
[1,4] → "ABAB" → maxFreq = 2 → length = 4 → invalid → shrink
[2,5] → "BABB" → maxFreq = 3 → valid
[3,6] → "ABBA" → maxFreq = 2 → invalid → shrink
Result: maxLen = 4
```

---

### 5. Edge Cases

- All same characters → return full length
- k >= length → return full length
- k = 0 → just count longest identical substring

---

### 6. Interview Tips

- Emphasize the formula: `window size - maxFreq <= k`
- Greedy choice: maximize `maxFreq` while keeping window valid
- Don’t re-scan for maxFreq on every shrink — this is key to O(n)

---

### 7. Practice More

- LeetCode 3: Longest Substring Without Repeating Characters
- LeetCode 1004: Max Consecutive Ones III
- LeetCode 159: Longest Substring with At Most Two Distinct Characters

---

✅ Summary:

- Use sliding window to track valid substring
- Track most frequent character in window
- Shrink window when changes needed exceed `k`
- Result is max length found

---

