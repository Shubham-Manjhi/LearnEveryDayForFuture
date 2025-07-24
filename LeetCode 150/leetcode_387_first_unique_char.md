**LeetCode 387: First Unique Character in a String**

---

### 1. Problem Statement
Given a string `s`, find the **first non-repeating character** in it and return its index. If it does not exist, return -1.

---

### 2. Why It’s Asked in Interviews
- Evaluates character frequency counting
- Highlights efficient string traversal
- Requires minimal space/time trade-offs

---

### 3. Optimal Approaches

#### ✅ **Approach 1: Frequency Map + Two Passes**
```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
```
- **Time:** O(n)
- **Space:** O(1) for 26 characters

---

#### ✅ **Approach 2: HashMap + Queue (for index)**
```java
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
```
- **Time:** O(n)
- **Space:** O(n)

---

### 4. ASCII Walkthrough Example
```
s = "leetcode"

freq:
'l' = 1
'e' = 3
't' = 1
'c' = 1
'o' = 1
'd' = 1

First char with freq 1 = 'l' at index 0 → return 0
```

---

### 5. Edge Cases
- Empty string → return -1
- All characters repeated → return -1
- First character is unique → early return

---

### 6. Interview Tips
- Clarify case sensitivity ('A' vs 'a')
- Ask if only lowercase letters are expected
- Discuss trade-off between HashMap and array

---

### 7. Practice More
- LeetCode 451: Sort Characters by Frequency
- LeetCode 242: Valid Anagram
- LeetCode 383: Ransom Note

---

✅ Summary:
- Use frequency counting with either array or map
- Two passes needed to track first unique index
- Choose best data structure based on constraints

---

