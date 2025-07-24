**LeetCode 49: Group Anagrams**

---

### 1. Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

Two strings are anagrams if they contain the same characters with the same frequencies.

**Function Signature:**

```java
List<List<String>> groupAnagrams(String[] strs)
```

---

### 2. Understanding the Problem

- Input: List of strings
- Output: Groups (lists) of strings where each group contains anagrams
- Characters may not be in order but their frequency counts must match

---

### 3. Optimal Approach (Sort and HashMap)

**Idea:**

- Sort each string → use sorted string as a key
- Group strings with the same sorted representation together

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(map.values());
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n \* k log k), where:
  - n = number of strings
  - k = max length of a string (for sorting)
- **Space Complexity:** O(n \* k), for the result and map

---

### 5. Edge Cases to Consider

- Empty string list → return empty list
- Duplicate strings
- Strings with single character

---

### 6. Example

```java
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

---

### 7. Best Practices

- Use `computeIfAbsent()` for cleaner grouping
- Use sorted keys only if character set is small (like a–z)

---

### 8. Related Topics

- HashMap
- String
- Sorting
- Frequency Counting

---

### 9. Interview Tip

> Always explain why a sorted string can act as a unique key for anagram groups. Mention that for Unicode or large alphabets, frequency arrays (or counts) might be more optimal.

Alternative (Frequency-Count Key):

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int freq : count) {
            sb.append('#');
            sb.append(freq);
        }
        String key = sb.toString();
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
}
```

---

### 10. Follow-up

> How would you scale this for billions of strings in distributed systems?

- Use consistent hashing
- Pre-group based on hash keys
- Perform reducer-side grouping in distributed frameworks like Hadoop/Spark

