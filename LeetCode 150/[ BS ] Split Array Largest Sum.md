# 📘 LeetCode 410: Split Array Largest Sum

---

## ✅ 0. Question

Given an array `nums` which consists of non-negative integers and an integer `k`, split the array into `k` non-empty continuous subarrays. Minimize the largest sum among these `k` subarrays.

### Example:
```text
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation:
    [7,2,5] and [10,8] => Max sum = 14 vs 18 => Choose 18 as the minimum max
```

---

## ✅ 1. Definition and Purpose
This problem tests how to apply binary search on the result and greedy subarray partitioning to achieve optimal performance. It teaches problem-solving on partitioning and minimizing maximum ranges.

---

## ✅ 2. Syntax and Structure
You will need:
- Binary Search
- Greedy Subarray Counting
- Helper Function

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Binary Search + Greedy (Optimized)

```java
public class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // Step 1: Binary Search boundaries between max and sum
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; // Try smaller max sum
            } else {
                left = mid + 1; // Need larger sum to split into k
            }
        }
        return left;
    }

    // Step 2: Check how many subarrays needed if maxSum allowed is 'maxSum'
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}
```

### 📘 ASCII Diagram:
```
Array: [7, 2, 5, 10, 8]
Try maxSum = 18
Partition:
  - [7,2,5] => sum=14
  - [10,8] => sum=18 (ok)
```

---

### 🔹 Approach 2: DP (Bottom-up) — Less Efficient but Classic

```java
public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], prefix[i] - prefix[j]));
                }
            }
        }
        return dp[n][m];
    }
}
```

---

## ✅ 4. Internal Working
- Binary Search is applied on possible result values (min = max of nums, max = sum of nums)
- Greedy splits into subarrays while counting number of splits
- DP builds all valid partitions and records minimal max

---

## ✅ 5. Best Practices
- Always use prefix sums in DP for range-sum calculation
- Binary search on result is a very common trick in advanced problems

---

## ✅ 6. Related Concepts
- Prefix Sum
- Greedy with Binary Search
- DP on partitions

---

## ✅ 7. Interview & Real-world Use
- Used in chunking workloads, memory paging, task assignment
- Common in Amazon and Google system design rounds

---

## ✅ 8. Common Errors & Debugging
- Off-by-one in prefix sums
- Not updating the DP table correctly
- Using linear search instead of binary search on result

---

## ✅ 9. Java Version Updates
- Java 8 Streams can simplify prefix sums
- Arrays.fill and Arrays.setAll for cleaner initialization

---

## ✅ 10. Practice and Application
- LeetCode 1011: Capacity to Ship Packages
- LeetCode 1482: Minimum Days to Make m Bouquets

---

## 📊 Time & Space Complexity
| Approach         | Time Complexity     | Space Complexity |
|------------------|---------------------|------------------|
| Binary + Greedy  | O(n * log(sum))     | O(1)             |
| DP Bottom-Up     | O(n^2 * k)          | O(n*k)           |

Let me know if you'd like to generate a PDF or diagram for visualization!

