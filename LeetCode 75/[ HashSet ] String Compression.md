# 📘 LeetCode 443: String Compression

---

## ✅ 0. Question

Given an array of characters chars, compress it using the following algorithm:

- Begin with an empty string `s`. For each group of consecutive repeating characters in `chars`:
    - Append the character to `s`
    - If the group length is > 1, append the group length to `s`.

Modify the input array in-place and return the new length of the array.

### Example:
```java
Input: chars = ['a','a','b','b','c','c','c']
Output: Return 6, and the first 6 characters of chars should be: ['a','2','b','2','c','3']
```

---

## ✅ 1. Definition and Purpose

This problem focuses on in-place array manipulation and is often asked to test your understanding of:
- Two-pointer technique
- In-place string compression without additional space

---

## ✅ 2. Syntax and Structure

- Use two pointers:
  - `i` to read the array
  - `index` to write the compressed result
- Use a loop to count characters

```java
int i = 0; // Reader pointer
int index = 0; // Writer pointer
```

---

## ✅ 3. Practical Example

### 🔹 Approach 1: Two-pointer Technique (Optimal)

```java
public int compress(char[] chars) {
    int index = 0; // Step 1: Write pointer
    int i = 0; // Step 2: Read pointer

    while (i < chars.length) {
        char currentChar = chars[i]; // Step 3: Current character
        int count = 0;

        // Step 4: Count group size
        while (i < chars.length && chars[i] == currentChar) {
            i++;
            count++;
        }

        // Step 5: Write the character
        chars[index++] = currentChar;

        // Step 6: Write count if > 1
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[index++] = c;
            }
        }
    }
    return index;
}
```

### 🔹 Approach 2: StringBuilder + Copy Back (Not In-Place Optimized)

```java
public int compress(char[] chars) {
    StringBuilder sb = new StringBuilder();
    int i = 0;

    while (i < chars.length) {
        char currentChar = chars[i];
        int count = 0;
        while (i < chars.length && chars[i] == currentChar) {
            i++;
            count++;
        }
        sb.append(currentChar);
        if (count > 1) sb.append(count);
    }

    for (int j = 0; j < sb.length(); j++) {
        chars[j] = sb.charAt(j);
    }

    return sb.length();
}
```

### 🔹 Example Execution:
```
Input: ['a','a','a','b','b','c']
Output: ['a','3','b','2','c']
```

### ASCII Representation:
```
Initial: [a, a, a, b, b, c]
         ^
Loop1:   Write 'a', count 3 → write '3'
Loop2:   Write 'b', count 2 → write '2'
Loop3:   Write 'c'
Final:   [a, 3, b, 2, c]
```

---

## ✅ 4. Internal Working

- We iterate once over chars (O(n))
- We maintain a `count` for each group
- We overwrite the input array using the write pointer
- Space complexity:
  - Approach 1: O(1)
  - Approach 2: O(n) (extra space)

---

## ✅ 5. Best Practices

- Avoid creating new arrays or strings if asked for in-place modification
- Use `String.valueOf(count).toCharArray()` for digit conversion
- Always test edge cases: single char, all same, no repeat

---

## ✅ 6. Related Concepts

- Two Pointer Pattern
- Run-length Encoding (Compression technique)
- In-place operations

---

## ✅ 7. Interview & Real-world Use

- Asked in Google, Microsoft, Amazon
- Useful in embedded systems or constrained environments
- Run-length encoding in image compression, transmission

---

## ✅ 8. Common Errors & Debugging

- Forgetting to restore the pointer correctly
- Not writing multi-digit numbers correctly
- Mutating array out-of-bounds due to missing pointer checks

---

## ✅ 9. Java Version Updates

- Enhanced for-loop and String API methods used here are stable since Java 7+
- No major change specific to Java 8+ for this pattern

---

## ✅ 10. Practice and Application

- LeetCode 38: Count and Say
- LeetCode 605: Can Place Flowers (Two-pointer)
- Compressing log streams, real-time analytics

---

✅ String compression questions reinforce your two-pointer skills and low-level memory handling.

