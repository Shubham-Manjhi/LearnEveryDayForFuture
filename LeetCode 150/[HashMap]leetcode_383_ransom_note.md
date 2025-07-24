**LeetCode 383: Ransom Note**

---

### 1. Problem Statement

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.

**Function Signature:**

```java
boolean canConstruct(String ransomNote, String magazine)
```

---

### 2. Understanding the Problem

- Every letter in `ransomNote` must appear in `magazine`.
- Each character in `magazine` can be used only once.
- Case-sensitive: 'A' and 'a' are different.

---

### 3. Optimal Approach (Using Frequency Array)

**Idea:** Count frequency of letters in `magazine`, then check if `ransomNote` can be formed.

```java
public boolean canConstruct(String ransomNote, String magazine) {
    int[] freq = new int[26];
    for (char c : magazine.toCharArray()) {
        freq[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
        if (--freq[c - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(m + n), where m = length of `magazine`, n = length of `ransomNote`
- **Space Complexity:** O(1), constant space for 26 lowercase English letters

---

### 5. Edge Cases to Consider

- `ransomNote` is empty → always true
- `magazine` is empty and `ransomNote` is not → false
- Same letters, different frequencies

---

### 6. Example

```java
Input: ransomNote = "a", magazine = "b"
Output: false

Input: ransomNote = "aa", magazine = "aab"
Output: true
```

---

### 7. Best Practices

- Use an integer array for lowercase character count.
- Avoid using HashMap unless you handle Unicode or large character sets.

---

### 8. Related Topics

- String
- Hashing
- Frequency Counter Pattern

---

### 9. Interview Tip

> Interviewers expect you to choose the most efficient method. Discuss array vs hashmap trade-offs and why fixed-size array works best here.

---

### 10. Follow-up

> What if characters were Unicode? You would need to use a HashMap instead of an array to store frequencies.

