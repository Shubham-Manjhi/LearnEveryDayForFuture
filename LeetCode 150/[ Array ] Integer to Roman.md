# 📘 LeetCode 12: Integer to Roman

---

## ✅ 0. Question

Given an integer, convert it to a Roman numeral. Input is guaranteed to be within the range from 1 to 3999.

### Example:
```text
Input: 1994
Output: "MCMXCIV"
Explanation:
1994 = 1000 + 900 + 90 + 4 = M + CM + XC + IV
```

---

## ✅ 1. Definition and Purpose

- This problem focuses on converting a decimal integer to a Roman numeral string.
- Roman numerals use specific symbols for values and subtractive notation for values like 4, 9, etc.
- Helps reinforce greedy techniques and number-symbol mapping.

---

## ✅ 2. Syntax and Structure

```java
public String intToRoman(int num);
```

- Input: integer from 1 to 3999
- Output: Roman numeral string

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Greedy Algorithm
```java
public String intToRoman(int num) {
    // Step 1: Define Roman numeral mappings in descending order
    int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40, 10, 9,   5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder sb = new StringBuilder();

    // Step 2: Greedily subtract the largest values and append corresponding symbols
    for (int i = 0; i < values.length && num > 0; i++) {
        while (num >= values[i]) {
            num -= values[i]; // Step 3: Subtract value
            sb.append(symbols[i]); // Step 4: Append symbol
        }
    }

    return sb.toString();
}
```

### 🔹 Approach 2: Custom Map Lookup with StringBuilder
```java
public String intToRoman(int num) {
    // Step 1: Create arrays with fixed mappings of values and Roman letters
    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder result = new StringBuilder();

    // Step 2: Repeat mapping subtraction logic
    for (int i = 0; i < numbers.length; i++) {
        int count = num / numbers[i];
        num %= numbers[i];

        // Step 3: Append each letter 'count' times
        while (count-- > 0) {
            result.append(letters[i]);
        }
    }
    return result.toString();
}
```

---

## ✅ 4. Internal Working

- Roman numerals are built using a greedy technique: largest symbol values are subtracted from the input.
- Subtractive cases like 4 ("IV"), 9 ("IX"), 40 ("XL") etc. are handled explicitly.
- Uses string concatenation via StringBuilder for efficiency.

---

## ✅ 5. Best Practices

- Use `StringBuilder` instead of regular string concatenation.
- Always sort Roman values in descending order.
- Cover subtractive cases explicitly in mapping.

---

## ✅ 6. Related Concepts

- Greedy Algorithms
- Symbol mapping and encoding
- Data transformation

---

## ✅ 7. Interview & Real-world Use

- Common interview question for encoding/decoding logic
- Similar to currency breakdown problems
- Roman numeral conversion is a historical encoding problem

---

## ✅ 8. Common Errors & Debugging

- Missing subtractive combinations (e.g., IV, IX, etc.)
- Incorrect order of values
- Using string concatenation instead of a StringBuilder

---

## ✅ 9. Java Version Updates

- No specific Java version changes impact this logic
- StringBuilder is efficient since Java 1.5+

---

## ✅ 10. Practice and Application

- LeetCode 13: Roman to Integer (inverse problem)
- LeetCode 273: Integer to English Words
- Used in formatting systems, numeral systems conversion

---

🔢 Mastering Roman Numeral conversion sharpens greedy thinking and symbol processing!

