**Java Topic: LeetCode 9 – Palindrome Number**

---

✅ 1. Definition and Purpose

• What is the concept?\
Determine whether an integer is a palindrome. A palindrome reads the same backward as forward.

• Why does it exist in Java?\
This reinforces control structures, integer manipulation, and mathematical string logic.

• What problem does it solve?\
Checks for numerical symmetry without converting the integer to a string.

🧠 Example: Input: 121 → Output: true | Input: -121 → Output: false

---

✅ 2. Syntax and Structure

• Method signature: `boolean isPalindrome(int x)`\
• Use math (modulus, division) or string conversion

---

✅ 3. Practical Examples

🔹 Approach 1: Reverse Half Integer (Optimal, No String)

📌 Idea:

- Revert half the digits and compare with the other half
- Stop once reversed >= original/remaining

```java
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }
}
```

📌 Example:

```
Input: 1221
x = 12, reversed = 12
Return true
```

🔹 Approach 2: Convert to String (Simple)

```java
public class PalindromeNumberString {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
```

📌 Why Less Optimal:

- Uses extra space for string\

- Violates "no extra space" constraint in some interview prompts

---

✅ 4. Internal Working

• Reversed integer avoids extra memory\
• Only half the digits are reversed for efficiency\
• Division and modulus extract digits

Time Complexity: O(log₁₀n)

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Avoid converting to string if asked\
✔ Handle edge cases like negatives or ending in 0

---

✅ 6. Related Concepts

- Integer math\

- Modulo and division\

- Palindrome patterns in strings and arrays

🧠 Example: Same logic used in linked list palindrome problems

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Classic warm-up problem\

- Used to evaluate stringless logic and math confidence

🏢 Real-world:

- Used in data validation\

- Number format detection (e.g., numeric symmetry)

---

✅ 8. Common Errors & Debugging

❌ Integer overflow when reversing full integer\
❌ Reversing entire number when only half needed

🧪 Debug Tip:

- Print intermediate values: reversed, x, mod

---

✅ 9. Java Version Updates

• No changes needed\
• Use Math.floorDiv() if working with Java integer division in edge cases

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #9\

- Stringless palindrome problems\

- LinkedList or number palindrome variants

🏗 Apply in:

- Symmetric ID detection\

- Numeric structure checks\

- UI validation routines

---

