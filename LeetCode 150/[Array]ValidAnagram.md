**Java Topic: LeetCode 242 - Valid Anagram**

---

✅ 1. Definition and Purpose

• What is the concept?\
Determine if two strings are anagrams of each other. An anagram uses the same characters with the same frequency but in any order.

• Why does it exist in Java?\
It helps solidify string manipulation and character frequency tracking using arrays or hash maps.

• What problem does it solve?\
Validates data equivalence, common in text comparison, file integrity, and form validations.

🧠 Example: s = "anagram", t = "nagaram" → Output: true

---

✅ 2. Syntax and Structure

• Define `boolean isAnagram(String s, String t)`\
• Use character count via arrays or hash maps

---

✅ 3. Practical Examples

🔹 Approach 1: Using Character Frequency Array (Optimized for lowercase letters)

```java
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
```

🔹 Approach 2: Using HashMap for General Unicode Support

```java
import java.util.*;

public class ValidAnagramMap {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return map.isEmpty();
    }
}
```

🖼️ ASCII Diagram – Anagram Check:

```
s = "anagram"
t = "nagaram"

Character counts:
a: 3
n: 1
g: 1
r: 1
m: 1

Same in both → Valid Anagram
```

---

✅ 4. Internal Working

• Array-based solution uses index math (`char - 'a'`) to track counts\
• HashMap-based version handles general characters and frequency updates

Time Complexity: O(n)

Space Complexity:

- O(1) for 26-letter array
- O(k) for map (k = number of unique characters)

---

✅ 5. Best Practices

✔ Use array for lowercase English strings\
✔ HashMap for multilingual strings\
✔ Always compare lengths first for early return

---

✅ 6. Related Concepts

- HashMap\


- Arrays\


- Character frequency counting\


- String.equals and sorting comparisons

🧠 Example: Word games, spell checkers, language parsers

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Common string question in early rounds

🏢 Real-world:

- Detecting file renames\


- Chat filter detection\


- Word similarity services

---

✅ 8. Common Errors & Debugging

❌ Forgetting to decrement counts for second string\
❌ Mismatched character cases\
❌ Assuming input is lowercase when it's not

🧪 Debug Tip:

- Print intermediate array/map after processing both strings

---

✅ 9. Java Version Updates

• Java 8+: Stream-based character collection if using sorting\
• Java 14+: Text blocks for testing multiline inputs

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #242\


- String hash/compare challenges

🏗 Apply in:

- Word puzzle solvers\


- Language auto-correct\


- File content comparison tools

