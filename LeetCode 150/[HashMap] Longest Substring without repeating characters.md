**Java Topic: LeetCode 3 - Longest Substring Without Repeating Characters**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given a string, find the length of the longest substring without repeating characters.

• Why does it exist in Java?\
It teaches how to use sliding window techniques and hash-based structures efficiently.

• What problem does it solve?\
Efficiently detects the longest unique-character sequence in a string.

🧠 Example: Input: "abcabcbb" → Output: 3 (substring: "abc")

---

✅ 2. Syntax and Structure

• Define `int lengthOfLongestSubstring(String s)`\
• Use a sliding window with HashSet or HashMap to track characters

---

✅ 3. Practical Examples

🔹 Approach 1: Sliding Window with HashSet (Basic)

```java
import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
}
```

🔹 Approach 2: Optimized Sliding Window using HashMap (Fast Index Jump)

```java
import java.util.*;

public class LongestSubstringOptimized {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int right = 0, left = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
```

🖼️ ASCII Diagram – Sliding Window:

```
Input: "abcabcbb"

Step 1: [a, b, c] → valid (max = 3)
Step 2: [b] repeats → move left past duplicate
Continue: [c, a, b] → again valid (max still 3)
```

---

✅ 4. Internal Working

• Use sliding window (2 pointers) to define current substring\
• Update start pointer whenever duplicate is found\
• Use map to jump over repeated characters fast

Time Complexity: O(n)

Space Complexity: O(k), where k = number of unique characters

---

✅ 5. Best Practices

✔ Use HashMap to reduce time spent skipping duplicates\
✔ Keep window boundaries clean\
✔ Always compare and store max length

---

✅ 6. Related Concepts

- Sliding Window\


- HashMap\


- Two Pointer Technique\


- Substring operations

🧠 Example: Input field validation, streaming text processors

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Very common interview question for FAANG and product companies

🏢 Real-world:

- Keystroke input validation\


- Streaming character analysis\


- Longest pattern search in logs

---

✅ 8. Common Errors & Debugging

❌ Forgetting to update left pointer\
❌ Not removing characters from window correctly\
❌ Incorrect max calculation

🧪 Debug Tip:

- Print window range and max after each step

---

✅ 9. Java Version Updates

• Java 8+: Use `forEach` with lambda for visualization\
• Java 14+: Text blocks for multi-line testing

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #3\


- Sliding window problems

🏗 Apply in:

- Stream-based applications\


- Interactive CLI or editor software\


- Log monitoring tools

