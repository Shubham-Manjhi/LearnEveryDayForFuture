# 📘 LeetCode 213: House Robber II

---

## ✅ 0. Question with Explanation

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money. All houses form a circle. This means the first and last houses are neighbors.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

### Example:

```java
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and house 3 (money = 2), because they are adjacent.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 2 (money = 2) and house 4 (money = 1), total = 2 + 1 = 3
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Circular Dynamic Programming
- **Why it exists**: Extends the classic House Robber problem to handle circular adjacency
- **Problem it solves**: Maximum non-adjacent sum where ends are also adjacent

---

## ✅ 2. Syntax and Structure

```java
public int rob(int[] nums);
```

- Input: Array of integers
- Output: Maximum money that can be robbed

---

## ✅ 3. Practical Examples

```java
Input: [1,2,3,1] => Output: 4
Input: [2,3,2] => Output: 3
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Circular DP by Splitting Range

- Time: O(n), Space: O(1)
- Since house 0 and house n-1 cannot be robbed together, we split the problem into two:
  - Rob houses from 0 to n-2
  - Rob houses from 1 to n-1

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    return Math.max(robRange(nums, 0, nums.length - 2),
                    robRange(nums, 1, nums.length - 1));
}

private int robRange(int[] nums, int start, int end) {
    int prev1 = 0, prev2 = 0;
    for (int i = start; i <= end; i++) {
        int temp = Math.max(prev1, prev2 + nums[i]);
        prev2 = prev1;
        prev1 = temp;
    }
    return prev1;
}
```

---

## ✅ 5. Best Practices

- Always check for length 1 as a special case
- Use helper function to reduce duplication and improve clarity

---

## ✅ 6. Related Concepts

- House Robber I (LeetCode 198)
- Maximum Circular Subarray

---

## ✅ 7. Interview & Real-world Use

- Asked in FAANG interviews
- Similar logic in circular scheduling problems

---

## ✅ 8. Common Errors & Debugging

- Forgetting the circular condition
- Incorrectly indexing split ranges (off-by-one)

---

## ✅ 9. Java Version Updates

- Works on all Java versions
- Java 8+ lambdas possible but not ideal here

---

## ✅ 10. Practice and Application

- LeetCode 213: House Robber II
- LeetCode 198: House Robber
- LeetCode 740: Delete and Earn

---

