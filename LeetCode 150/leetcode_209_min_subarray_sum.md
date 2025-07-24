**LeetCode 209: Minimum Size Subarray Sum**

---

### 1. Problem Statement
Given an array of positive integers `nums` and a positive integer `target`, return the **minimal length of a contiguous subarray** of which the sum is greater than or equal to `target`. If there is no such subarray, return 0 instead.

---

### 2. Why It’s Asked in Interviews
- Tests **sliding window** pattern
- Real-world performance optimization (memory, time)
- Helps evaluate boundary condition handling

---

### 3. Brute Force Approach (Inefficient)
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
```
- **Time:** O(n^2)
- **Space:** O(1)

---

### 4. Optimal Approach: Sliding Window
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
```
- **Time:** O(n)
- **Space:** O(1)

---

### 5. ASCII Walkthrough Example
```
nums = [2,3,1,2,4,3], target = 7

Sliding window:
[2] → sum=2 → not enough
[2,3] → sum=5 → not enough
[2,3,1] → sum=6 → not enough
[2,3,1,2] → sum=8 → valid → minLen=4 → shrink
[3,1,2] → sum=6
[1,2,4] → sum=7 → valid → minLen=3
[2,4,3] → sum=9 → valid → shrink → minLen=2
→ Result: 2
```

---

### 6. Edge Cases
- Empty array → return 0
- All elements < target → return 0
- First subarray is optimal → early termination

---

### 7. Interview Tips
- Focus on **minimum length**, not max sum
- Always reset sum when shrinking window
- Don't forget to check for no-solution scenario

---

### 8. Practice More
- LeetCode 3: Longest Substring Without Repeating Characters
- LeetCode 76: Minimum Window Substring
- LeetCode 1004: Max Consecutive Ones III

---

✅ Summary:
- Use sliding window for O(n) solution
- Shrink window as soon as `sum >= target`
- Return 0 if no such subarray found

---

