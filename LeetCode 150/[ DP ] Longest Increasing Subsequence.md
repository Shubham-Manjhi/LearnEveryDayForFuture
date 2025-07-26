# 📘 LeetCode 300: Longest Increasing Subsequence

---

## ✅ 0. Question with Explanation

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence is derived by deleting some or no elements without changing the order of the remaining elements.

### Example:
```java
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101].

Input: nums = [0,1,0,3,2,3]
Output: 4
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming / Binary Search
- **Why it exists**: To find the longest chain of increasing elements
- **Problem it solves**: Tracking sequences and optimizing decisions over time

---

## ✅ 2. Syntax and Structure

```java
public int lengthOfLIS(int[] nums);
```

- Input: array of integers `nums`
- Output: integer representing the length of the longest increasing subsequence

---

## ✅ 3. Practical Examples

### Example 1:
```java
Input: nums = [1,3,6,7,9,4,10,5,6]
Output: 6
Explanation: LIS is [1,3,4,5,6,10]
```

ASCII Diagram:
```
Index:   0  1  2  3  4  5  6  7  8
Array:   1  3  6  7  9  4 10  5  6
LIS -->  1  3     4     5     6
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Dynamic Programming (Tabulation)
- Time: O(n^2), Space: O(n)
- Strategy: For every i, look back at j < i and see if nums[i] > nums[j]

```java
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // Step 1: Every element has LIS of at least 1
    int maxLen = 1;

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1); // Step 2: Choose longer sequence
            }
        }
        maxLen = Math.max(maxLen, dp[i]); // Step 3: Track overall max length
    }
    return maxLen;
}
```

Example for `nums = [10,9,2,5,3,7,101,18]`
```text
Step-by-step dp update:

Initial dp:  [1,1,1,1,1,1,1,1]
nums[i] > nums[j]: update dp[i] = max(dp[i], dp[j]+1)
Final dp:    [1,1,1,2,2,3,4,4]
LIS Length: 4
```

### ✅ Approach 2: Binary Search Optimization
- Time: O(n log n), Space: O(n)
- Strategy: Maintain list "sub" where sub[i] is the smallest possible tail for LIS of length i+1

```java
public int lengthOfLIS(int[] nums) {
    List<Integer> sub = new ArrayList<>();
    for (int num : nums) {
        int i = Collections.binarySearch(sub, num);
        if (i < 0) i = -(i + 1); // Step 1: Find position to replace
        if (i == sub.size()) sub.add(num); // Step 2: Append if larger than all
        else sub.set(i, num); // Step 3: Replace element to keep sub optimized
    }
    return sub.size();
}
```

### ASCII Example for nums = [10,9,2,5,3,7,101,18]
```
Iterations:
Add 10  --> [10]
Replace 9  --> [9]
Replace 2  --> [2]
Add 5  --> [2,5]
Replace 3  --> [2,3]
Add 7  --> [2,3,7]
Add 101 --> [2,3,7,101]
Replace 18 --> [2,3,7,18]
```

---

## ✅ 5. Best Practices

- Use binary search approach for large datasets
- Avoid modifying original array unless explicitly asked
- Comment your steps for readability and debugging

---

## ✅ 6. Related Concepts

- Patience Sorting
- Longest Common Subsequence
- Subsequence vs Substring

---

## ✅ 7. Interview & Real-world Use

- Common interview question to test DP and optimization
- Useful in predictive analytics and sequential pattern mining

---

## ✅ 8. Common Errors & Debugging

- Confusing subsequence with contiguous subarray
- Wrong initialization of DP array (e.g. using 0 instead of 1)
- Forgetting binarySearch can return negative index for insert position

---

## ✅ 9. Java Version Updates

- Java 8+ Collections API helps with `binarySearch`
- Java 16+ allows for `List.of()` initialization if needed for fixed test cases

---

## ✅ 10. Practice and Application

- LeetCode 300: Longest Increasing Subsequence
- LeetCode 354: Russian Doll Envelopes
- Competitive programming practice

---

