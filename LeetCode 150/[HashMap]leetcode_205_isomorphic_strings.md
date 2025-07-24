**LeetCode 205: Isomorphic Strings**

---

### 1. Problem Statement

Given two strings `s` and `t`, determine if they are isomorphic.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`.

- All occurrences of a character must be replaced with another character while preserving the order.
- No two characters may map to the same character, but a character may map to itself.

**Function Signature:**

```java
boolean isIsomorphic(String s, String t)
```

---

### 2. Understanding the Problem

- Characters in `s` must have a 1-to-1 mapping with characters in `t`.
- Order must be preserved.
- Mappings must be consistent.

---

### 3. Optimal Approach (Two Hash Maps or Single Array)

**Idea:** Use two maps to track mapping from `s` to `t` and from `t` to `s`.

```java
public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Character> mapST = new HashMap<>();
    Map<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char cs = s.charAt(i);
        char ct = t.charAt(i);

        if ((mapST.containsKey(cs) && mapST.get(cs) != ct) ||
            (mapTS.containsKey(ct) && mapTS.get(ct) != cs)) {
            return false;
        }

        mapST.put(cs, ct);
        mapTS.put(ct, cs);
    }

    return true;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n), where n = length of the strings
- **Space Complexity:** O(1) — bounded by alphabet size (at most 256 mappings)

---

### 5. Edge Cases to Consider

- Strings of different lengths
- Repeating characters
- Characters mapping to themselves

---

### 6. Example

```java
Input: s = "egg", t = "add"
Output: true

Input: s = "foo", t = "bar"
Output: false

Input: s = "paper", t = "title"
Output: true
```

---

### 7. Best Practices

- Maintain forward and backward mapping.
- Always check both maps to ensure 1-1 relationship.

---

### 8. Related Topics

- String
- Hash Map
- Bijective Functions

---

### 9. Interview Tip

> Highlight that you are validating a **bijective** (one-to-one and onto) character mapping. This demonstrates clarity in constraint reasoning.

---

### 10. Follow-up

> Can you extend this to Unicode characters or optimize using fixed-size arrays for lowercase ASCII?

