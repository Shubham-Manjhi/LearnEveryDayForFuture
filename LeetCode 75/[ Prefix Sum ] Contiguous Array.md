# 📘 LeetCode 525: Contiguous Array

---

## ✅ 0. Question

Given a binary array `nums`, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

### Example:
```text
Input: nums = [0,1]
Output: 2

Input: nums = [0,1,0]
Output: 2
```

---

## ✅ 1. Definition and Purpose

- This problem checks prefix-sum knowledge, hash maps, and problem transformation
- We convert the problem into finding longest subarray with cumulative sum 0 (by treating 0 as -1)

---

## ✅ 2. Syntax and Structure

```java
public int findMaxLength(int[] nums);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force (O(n^2))

```java
public int findMaxLength(int[] nums) {
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
        int count = 0;
        for (int j = i; j < nums.length; j++) {
            // Convert 0 to -1 for tracking balance
            count += nums[j] == 1 ? 1 : -1;
            if (count == 0) {
                // If count == 0, we have equal number of 0s and 1s
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }
    return maxLength;
}
```

### Example Walkthrough
```
nums = [0, 1, 0]
Convert 0 to -1 ➔ [-1, 1, -1]
Try all subarrays:
  i=0 to j=1: sum = 0 ➔ valid ➔ length = 2
  i=1 to j=2: sum = 0 ➔ valid ➔ length = 2
Max = 2
```

### 🔹 Approach 2: HashMap and Prefix Sum (Optimized O(n))

```java
public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Base case: count 0 at index -1
    int maxLength = 0, count = 0;

    for (int i = 0; i < nums.length; i++) {
        // Step 1: convert 0 to -1 to track balanced prefix sum
        count += nums[i] == 1 ? 1 : -1;

        // Step 2: if count has been seen before, subarray between has net zero balance
        if (map.containsKey(count)) {
            int prevIndex = map.get(count);
            maxLength = Math.max(maxLength, i - prevIndex);
        } else {
            // Step 3: store first occurrence of this count
            map.put(count, i);
        }
    }

    return maxLength;
}
```

### Step-by-step Example
```
Input: [0, 1, 0]
Converted: [-1, 1, -1]

Iteration:
- i = 0: count = -1 ➔ store -1 at 0
- i = 1: count = 0  ➔ seen at -1 ➔ length = 1 - (-1) = 2
- i = 2: count = -1 ➔ seen at 0 ➔ length = 2

Output: 2
```

---

## ✅ 4. Internal Working

- HashMap tracks earliest occurrence of prefix count
- When count repeats, subarray between same count indices has zero net 0s/1s

---

## ✅ 5. Best Practices

- Use HashMap for prefix index tracking
- Convert 0 to -1 early in logic to avoid confusion
- Always initialize base count 0 to index -1

---

## ✅ 6. Related Concepts

- Prefix sums
- Hashing
- Subarray problems

---

## ✅ 7. Interview & Real-world Use

- Common interview prefix sum pattern
- Used in signal processing, parity-based optimization

---

## ✅ 8. Common Errors & Debugging

- Forgetting to add initial count 0 to map with index -1
- Using wrong value for 0 (must be -1)
- Off-by-one errors in calculating length

---

## ✅ 9. Java Version Updates

- `Map.putIfAbsent()` in Java 8+ can simplify logic

---

## ✅ 10. Practice and Application

- LeetCode 560: Subarray Sum Equals K
- LeetCode 974: Subarray Sums Divisible by K
- LeetCode 523: Continuous Subarray Sum

---

🚀 Understanding Contiguous Array strengthens your ability to solve prefix sum problems and use HashMap effectively.

