# 📘 LeetCode 137: Single Number II

---

## ✅ 0. Question

Given an integer array `nums` where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with linear runtime complexity and constant extra space.

### Examples:
```java
Input: nums = [2,2,3,2]
Output: 3

Input: nums = [0,1,0,1,0,1,99]
Output: 99
```

---

## ✅ 1. Definition and Purpose

This problem is an extension of LeetCode 136, where we used XOR to cancel out duplicates. Here, each element occurs three times except one. 

We need to find the unique element using bitwise manipulation with constant space.

---

## ✅ 2. Syntax and Structure

```java
public int singleNumber(int[] nums)
```

- Input: Array of integers with all elements occurring 3 times except one
- Output: The single unique number

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Bit Manipulation with Two Variables (Readable Version)
```java
public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for (int num : nums) {
        // Step 1: Add to 'twos' if already present in 'ones'
        twos |= ones & num;

        // Step 2: XOR 'num' into 'ones'
        ones ^= num;

        // Step 3: Mask out bits that appear in both ones and twos (i.e., 3 times)
        int common_mask = ~(ones & twos);

        // Step 4: Remove common bits from 'ones' and 'twos'
        ones &= common_mask;
        twos &= common_mask;
    }
    return ones;
}
```

### 🔹 Approach 2: Bit Masking Optimized Form (Most Optimized)
```java
public int singleNumber(int[] nums) {
    int once = 0, twice = 0;
    for (int n : nums) {
        // Step 1: Update `once` by XORing current number and ANDing with inverse of `twice`
        once = (n ^ once) & ~twice;

        // Step 2: Update `twice` by XORing current number and ANDing with inverse of new `once`
        twice = (n ^ twice) & ~once;
    }
    // Step 3: `once` holds the number that appeared once
    return once;
}
```

### 🔹 Approach 3: Count Bits at Each Position (Brute but Constant Space)
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        int sum = 0;
        for (int num : nums) {
            if (((num >> i) & 1) == 1) {
                sum++;
            }
        }
        if (sum % 3 != 0) {
            result |= (1 << i);
        }
    }
    return result;
}
```

---

## ✅ 4. Internal Working

### Approach 1 & 2:
- Track bits appearing once and twice using finite-state transition
- Clear bits that appear 3 times using masks

### Approach 3:
- Count bits at each index across all numbers
- Use `mod 3` to isolate the unique element’s bits

Time: O(n), Space: O(1)

---

## ✅ 5. Best Practices

- Use bitmask technique for performance and space efficiency
- Keep variable names descriptive (e.g., once, twice)
- Handle signed integers with care in bit counting

---

## ✅ 6. Related Concepts

- Bitwise logic
- Finite state machines
- XOR properties
- LeetCode 136, 260

---

## ✅ 7. Interview & Real-world Use

- Common in interviews focused on bit manipulation
- Used in memory-efficient unique pattern detection

---

## ✅ 8. Common Errors & Debugging

- Forgetting to mask after XOR operations
- Sign bit miscalculation when using 32nd bit
- Confusing how XOR cancels duplicates

---

## ✅ 9. Java Version Updates

- Compatible across all Java versions
- No special library dependency

---

## ✅ 10. Practice and Application

- LeetCode 136: Single Number
- LeetCode 260: Single Number III
- Bitmask practice on HackerRank, Codeforces

---

🧠 Tip: The state machine-style mask approach is among the most elegant constant-space algorithms for this class of problems.

