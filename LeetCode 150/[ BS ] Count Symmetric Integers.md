# 📘 LeetCode 2843: Count Symmetric Integers

---

## ✅ 0. Question

You are given two positive integers low and high.
An integer x is said to be symmetric if:
- It has an even number of digits.
- The sum of the first half of the digits is equal to the sum of the second half.

Return the number of symmetric integers in the range [low, high].

### Example:
```java
Input: low = 1, high = 100
Output: 9
Explanation: All symmetric integers between 1 and 100 are: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
```

---

## ✅ 1. Definition and Purpose
This problem tests iteration, string manipulation, and numeric reasoning.
It reinforces the concept of working with digits and implementing custom rules.

---

## ✅ 2. Syntax and Structure
You will use:
- Looping over a range
- Converting numbers to strings or processing digits
- Splitting the digits and summing

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force (String-based)
```java
public class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 0) {
                int half = s.length() / 2;
                int leftSum = 0, rightSum = 0;
                for (int j = 0; j < half; j++) leftSum += s.charAt(j) - '0';
                for (int j = half; j < s.length(); j++) rightSum += s.charAt(j) - '0';
                if (leftSum == rightSum) count++;
            }
        }
        return count;
    }
}
```

---

### 🔹 Approach 2: Digit-based without Strings (Optimized)
```java
public class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            int len = (int)Math.log10(i) + 1;
            if (len % 2 != 0) continue;

            int[] digits = new int[len];
            int temp = i;
            for (int j = len - 1; j >= 0; j--) {
                digits[j] = temp % 10;
                temp /= 10;
            }

            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < len / 2; j++) sumLeft += digits[j];
            for (int j = len / 2; j < len; j++) sumRight += digits[j];

            if (sumLeft == sumRight) count++;
        }
        return count;
    }
}
```

---

## ✅ 4. Internal Working
- Iterate from low to high
- Check if the number has even digits
- Split digits into left/right and compute sums
- Compare the sums to determine symmetry

---

## ✅ 5. Best Practices
- Avoid unnecessary conversions (e.g., String.valueOf) when performance matters
- Use array-based digit parsing when needed

---

## ✅ 6. Related Concepts
- Digit Manipulation
- String and Array splitting
- Math.log10 for digit length calculation

---

## ✅ 7. Interview & Real-world Use
- A good test of low-level iteration and manipulation
- Can be used in validation logic or palindrome-like digit operations

---

## ✅ 8. Common Errors & Debugging
- Forgetting to check even digit count
- Incorrect summing ranges
- Off-by-one errors in loops

---

## ✅ 9. Java Version Updates
- No specific new features required. Works on all Java versions

---

## ✅ 10. Practice and Application
- Similar problems: Palindrome Numbers, Digit Sum Equality
- Practice: LeetCode 9, 1012, etc.

---

## 📊 Time and Space Complexity
| Approach | Time Complexity | Space Complexity |
|----------|------------------|------------------|
| Brute Force | O(N * D) where D is max number of digits | O(1) |
| Optimized  | O(N * D) | O(D) for digit array |

---

Let me know if you'd like a PDF export or if you'd like to proceed to the next problem!

