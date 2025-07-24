**LeetCode 219: Contains Duplicate II**

---

### 1. Problem Statement

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that:

- `nums[i] == nums[j]`, and
- `abs(i - j) <= k`

**Function Signature:**

```java
boolean containsNearbyDuplicate(int[] nums, int k)
```

---

### 2. Understanding the Problem

- You need to find a duplicate element in the array such that its two occurrences are at most `k` indices apart.
- Focus on window of size `k`.

---

### 3. Optimal Approach (Sliding Window using HashSet)

**Idea:** Use a sliding window of size `k`. Store elements in a `HashSet` and remove the oldest when size exceeds `k`.

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) return true;
        set.add(nums[i]);
        if (set.size() > k) {
            set.remove(nums[i - k]);
        }
    }
    return false;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(min(n, k))

---

### 5. Edge Cases to Consider

- `k = 0` → never valid
- `nums.length <= 1` → false
- Large arrays with small `k`

---

### 6. Example

```java
Input: nums = [1,2,3,1], k = 3
Output: true

Input: nums = [1,0,1,1], k = 1
Output: true

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```

---

### 7. Best Practices

- Use a sliding window to reduce space.
- Early return if duplicate found.
- Maintain readability.

---

### 8. Related Topics

- Hashing
- Sliding Window
- Set

---

### 9. Interview Tip

> This problem tests your understanding of sliding windows and hash sets. Explain why linear scan with a hash set is efficient.

---

### 10. Follow-up

> What if you need to return the **indices** of the first such duplicate instead of a boolean? You can modify the code to track positions in a HashMap.

