**Java Problem: Construct String with No Three Consecutive Characters**

---

✅ 0. Question & Explanation

Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same.

🧠 Examples:

- A = 5, B = 3 → Possible: "aabaabab"
- A = 3, B = 3 → Possible: "ababab"
- A = 1, B = 4 → Possible: "bbabb"

Constraints:

- A, B in [0..100]
- At least one valid solution always exists.

---

✅ 1. Definition and Purpose

• What is the concept?\
Greedy string construction by tracking character count and preventing triplet repeats.

• Why does it exist in Java?\
String building problems are common in Java interview questions and real-time scheduling algorithms.

• What problem does it solve?\
Prevents undesired sequences (e.g., long runs of a character) in communication, compression, or visual layouts.

---

✅ 2. Syntax and Structure

Function signature:

```java
public String solution(int A, int B)
```

Main logic:

- Use a StringBuilder
- Always append the character with the higher remaining count
- Prevent appending three consecutive identical characters

---

✅ 3. Practical Examples

🔹 Greedy Java Implementation:

```java
public class Solution {
    public String solution(int A, int B) {
        StringBuilder sb = new StringBuilder(); // Step 1: Initialize the result string
        char a = 'a', b = 'b';

        // Step 2: Ensure 'a' represents the character with more occurrences
        if (B > A) {
            int temp = A; A = B; B = temp;             // Swap counts
            char tempChar = a; a = b; b = tempChar;    // Swap characters
        }

        // Step 3: While we still have characters left to add
        while (A > 0 || B > 0) {
            int len = sb.length();
            boolean writeA = false; // Decide whether to write 'a' or 'b'

            // Step 4: If last two characters are same and are 'a', we must write 'b'
            if (len >= 2 && sb.charAt(len-1) == a && sb.charAt(len-2) == a) {
                writeA = false;
            }
            // Step 5: If A >= B (a is more frequent), we prefer writing 'a'
            else if (A >= B) {
                writeA = true;
            }
            // Step 6: Else write 'b'
            else {
                writeA = false;
            }

            // Step 7: Append the selected character and decrease its count
            if (writeA && A > 0) {
                sb.append(a); A--;
            } else if (!writeA && B > 0) {
                sb.append(b); B--;
            }
        }

        // Step 8: Return the constructed string
        return sb.toString();
    }
}
```

📌 Example: A = 4, B = 1 → Output: "aabaa"

---

✅ 4. Internal Working

• Greedy selection ensures we always add the more frequent character\
• We prevent "aaa" or "bbb" by checking last two characters before appending

Time Complexity: O(A + B)

---

✅ 5. Best Practices

✔ Swap variables to simplify logic (always keep larger count first)\
✔ Use StringBuilder for efficiency\
✔ Avoid appending without checking the last two characters

---

✅ 6. Related Concepts

- Greedy algorithms
- StringBuilder operations
- Queue-based character scheduling (extended)

🧠 Similar to: Reorganize String, Task Scheduler

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Great for testing greedy logic and string manipulation

🏢 Real-world:

- Token sequencing in compilers\

- Avoiding bias or spam in communication systems

---

✅ 8. Common Errors & Debugging

❌ Forgetting to check the last two characters\
❌ Not handling swapped characters (A vs B logic)

🧪 Debug Tip: Print partial result at each step to trace greedy behavior

---

✅ 9. Java Version Updates

Java 11+ offers String.repeat(), but logic here is better controlled manually

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode: Reorganize String
- HackerRank: Balanced Strings

🏗 Apply in:

- Layout generation\

- Controlled repetition in formatting engines

---

