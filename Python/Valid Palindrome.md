# 🔄 Valid Palindrome in Python

---

## 📘 Problem Explanation

A **palindrome** is a sequence of characters that reads the same forward and backward.  
We need to **determine if a string is a palindrome** after removing all non-alphanumeric characters (spaces, punctuation, symbols) and ignoring case.

### Example 1
```python
Input: s = "a dog! a panic in a pagoda."
Output: True
```

### Example 2
```python
Input: s = "abc123"
Output: False
```

### Constraints
- Input string may contain lowercase/uppercase letters, numbers, spaces, and punctuation.
- Must ignore non-alphanumeric characters.
- Case-insensitive comparison.

---

## 🔹 Approach 1: Two-Pointer Technique

- Use **two pointers** (left and right) starting from the ends of the string.
- Skip non-alphanumeric characters.
- Compare characters (ignoring case).
- If mismatch → return `False`.
- Continue until pointers meet.

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            if s[left].lower() != s[right].lower():
                return False
            left, right = left + 1, right - 1
        return True
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(1)`

---

## 🔹 Approach 2: Preprocessing + Reverse Check

- Filter only alphanumeric characters.
- Convert to lowercase.
- Check if processed string equals its reverse.

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:
        filtered = "".join(ch.lower() for ch in s if ch.isalnum())
        return filtered == filtered[::-1]
```

✅ **Time Complexity**: `O(n)`  
✅ **Space Complexity**: `O(n)` (extra string storage)

---

## 🔹 Approach 3: Using Regular Expressions

- Use regex to remove non-alphanumeric characters.
- Compare string with its reverse.

```python
import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub(r'[^a-zA-Z0-9]', '', s).lower()
        return s == s[::-1]
```

---

## 🔹 Interview Questions & Answers

**Q1. Why is `isalnum()` used here?**  
👉 To filter only alphanumeric characters (letters and numbers).

**Q2. Which approach is more space efficient?**  
👉 The **two-pointer approach** since it avoids creating a new string.

**Q3. How would you modify the code to allow ignoring numbers too?**  
👉 Update filter condition to include only alphabetic characters using `isalpha()`.

**Q4. Can this be extended to linked lists or streams?**  
👉 Yes, but we’d need different strategies (e.g., slow/fast pointers, stack, or two-pass methods).

---

## 🎯 Conclusion
- **Two-pointer method** is most space-efficient.
- **Preprocessing + reverse check** is simpler but uses extra memory.
- **Regex** offers concise code.
- Common interview variations: check only alphabetic palindromes, check palindrome for linked lists.

---

