**LeetCode 290: Word Pattern**

---

### 1. Problem Statement
Given a `pattern` and a string `s`, find if `s` follows the same pattern.

Here, follow means a full match:
- there is a bijection between a letter in `pattern` and a non-empty word in `s`.

**Function Signature:**
```java
boolean wordPattern(String pattern, String s)
```

---

### 2. Understanding the Problem
- Each letter in `pattern` must map to **one and only one word** in `s`
- Each word in `s` must map to **one and only one character** in `pattern`
- Think of one-to-one mapping, like dictionary keys and values

---

### 3. Optimal Approach (Two HashMaps or One HashMap + Set)

```java
public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;

    Map<Character, String> map = new HashMap<>();
    Set<String> seen = new HashSet<>();

    for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
        String word = words[i];

        if (!map.containsKey(c)) {
            if (seen.contains(word)) return false;
            map.put(c, word);
            seen.add(word);
        } else {
            if (!map.get(c).equals(word)) return false;
        }
    }
    return true;
}
```

---

### 4. Complexity Analysis
- **Time Complexity:** O(n), where n = number of characters/words
- **Space Complexity:** O(k), where k = number of unique letters/words

---

### 5. Edge Cases to Consider
- Mismatch in number of words and pattern characters
- Duplicate pattern letters pointing to different words
- Empty strings

---

### 6. Example
```java
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
```

---

### 7. Best Practices
- Use HashMap for character-to-word mapping
- Use HashSet to detect duplicate value mappings

---

### 8. Related Topics
- Hashing
- String
- Pattern Matching

---

### 9. Interview Tip
> Clarify whether pattern-to-word and word-to-pattern mapping should be unique. Talk about bijective mapping and give real-life analogies.

---

### 10. Follow-up
> How would you solve it if pattern and `s` were streamed character by character and word by word? Think of sliding-window + streaming HashMap approach.

