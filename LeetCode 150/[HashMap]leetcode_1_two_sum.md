**LeetCode 1: Two Sum**

---

### 1. Problem Statement

Given an array of integers `nums` and an integer `target`, return **indices** of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

**Function Signature:**

```java
int[] twoSum(int[] nums, int target)
```

---

### 2. Understanding the Problem

- Return indices of two elements whose sum equals `target`.
- Exactly one valid solution exists.
- Elements are not necessarily sorted.

---

### 3. Optimal Approach (Using HashMap)

**Idea:** Store values and their indices in a hashmap as we iterate.

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n) — single pass.
- **Space Complexity:** O(n) — hashmap storage.

---

### 5. Edge Cases to Consider

- Negative numbers in input
- Target is zero
- Large numbers

---

### 6. Example

```java
Input: nums = [2,7,11,15], target = 9
Output: [0,1] // because nums[0] + nums[1] = 2 + 7 = 9
```

---

### 7. Best Practices

- Use meaningful variable names.
- Always check map for `containsKey` before accessing.

---

### 8. Related Topics

- Hashing
- Arrays
- Two Pointers (in sorted variant)

---

### 9. Interview Tip

> Be sure to explain why you use a HashMap and its lookup advantages. Interviewers look for efficient logic and knowledge of space-time tradeoffs.

---

### 10. Follow-up

> What if you want to return **all** pairs that sum up to the target? (Use HashSet + List for storing pairs.)

