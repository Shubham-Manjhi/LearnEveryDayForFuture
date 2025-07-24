**LeetCode 560: Subarray Sum Equals K**

---

### 1. Problem Statement
Given an array of integers `nums` and an integer `k`, return the **total number of continuous subarrays** whose sum equals to `k`.

---

### 2. Why It’s Asked in Interviews
- Emphasizes optimized subarray techniques
- Tests hashmap-based prefix sum approach
- Covers linear-time problem solving with memory trade-offs

---

### 3. Naive Approach (Brute Force - TLE)
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
```
- **Time:** O(n^2)
- **Space:** O(1)

---

### 4. Optimized Approach: Prefix Sum + HashMap

**Key Insight:** If `sum[i] - sum[j] == k`, then `sum[j] = sum[i] - k` → Use hashmap to count prefix sums

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // prefix sum = 0 has one count
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```

- **Time:** O(n)
- **Space:** O(n)

---

### 5. ASCII Flow Example
```
nums = [1, 1, 1], k = 2

prefixSum map:
0 -> 1 (initial)
1 -> 1
2 -> 1

sum = 0
count = 0

sum += 1 → 1, map has (1 - 2) = -1 → no
sum += 1 → 2, map has (2 - 2) = 0 → count += 1
sum += 1 → 3, map has (3 - 2) = 1 → count += 1

=> Total count = 2
```

---

### 6. Edge Cases
- `nums` has negative numbers
- Empty array (return 0)
- `k = 0`

---

### 7. Interview Tips
- Always check for hashmap initialization (`map.put(0,1)`)
- Clarify whether subarrays must be contiguous (they must be)
- Use dry-run to verify prefix sum logic

---

### 8. Practice More
- LeetCode 974: Subarray Sums Divisible by K
- LeetCode 525: Contiguous Array
- LeetCode 437: Path Sum III

---

✅ Summary:
- Use prefix sum + hashmap to reduce to O(n)
- Track count of each prefix sum for quick lookup
- Brute-force is only acceptable for small arrays

---

