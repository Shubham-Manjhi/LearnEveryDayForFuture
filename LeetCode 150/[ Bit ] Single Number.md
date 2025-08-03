# 📘 LeetCode 136: Single Number

---

## ✅ 0. Question

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

### Examples:
```java
Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4

Input: nums = [1]
Output: 1
```

---

## ✅ 1. Definition and Purpose

The Single Number problem is about identifying the unique element in an array where all other elements appear exactly twice. It focuses on bitwise operations, efficient counting, and memory optimization.

Purpose:
- Identify non-repeating elements using optimal methods
- Train bit manipulation and hashing concepts

---

## ✅ 2. Syntax and Structure

```java
public int singleNumber(int[] nums)
```
- Input: int[] nums
- Output: int — the single unique number

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Using XOR (Optimal O(n) Time, O(1) Space)
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        // Step: XOR-ing all numbers cancels duplicates
        result ^= num;
    }
    return result;
}
```

### Example Trace:
```
Input: [4, 1, 2, 1, 2]
result = 0
Step 1: 0 ^ 4 = 4
Step 2: 4 ^ 1 = 5
Step 3: 5 ^ 2 = 7
Step 4: 7 ^ 1 = 6
Step 5: 6 ^ 2 = 4 (final result)
```

---

### 🔹 Approach 2: Using HashSet (O(n) Time, O(n) Space)
```java
public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        // Step: Add to set if not present, remove if already added
        if (!set.add(num)) {
            set.remove(num);
        }
    }
    // Step: Only one number remains
    return set.iterator().next();
}
```

---

## ✅ 4. Internal Working

- XOR logic: a^a = 0 and a^0 = a, so all pairs cancel out
- Only the unique number remains

Time Complexity:
- Approach 1: O(n)
- Approach 2: O(n)

Space Complexity:
- Approach 1: O(1)
- Approach 2: O(n)

---

## ✅ 5. Best Practices

- Use XOR approach when constrained by space
- Avoid sorting which takes O(n log n)
- HashSet is easier to understand but not optimal for space

---

## ✅ 6. Related Concepts

- Bit Manipulation
- Hashing
- Set operations
- Duplicate removal

---

## ✅ 7. Interview & Real-world Use

- Common question in interviews to test optimal solutions
- Real-world: checksum, error detection, ID uniqueness

---

## ✅ 8. Common Errors & Debugging

- Misunderstanding XOR properties
- Using map incorrectly by counting instead of leveraging XOR
- Missing single element if using HashSet improperly

---

## ✅ 9. Java Version Updates

- No special Java version features required
- Works from Java 5+ (enhanced for loop)

---

## ✅ 10. Practice and Application

- LeetCode 137: Single Number II
- LeetCode 260: Single Number III
- Bitwise and space-optimized techniques

---

🧠 The XOR trick is a powerful tool in competitive coding and interview puzzles — concise, elegant, and optimal.

