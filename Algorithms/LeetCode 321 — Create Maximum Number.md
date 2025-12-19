## 💥 LeetCode 321 — Create Maximum Number

---

### 🎯 Problem Statement

You are given two integer arrays `nums1` and `nums2` representing two sequences of digits. Create the maximum number of length `k` (where `k ≤ len(nums1) + len(nums2)`) from digits of both arrays, maintaining the relative order of digits from each array.

**Example:**

```
Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
Output: [9,8,6,5,3]
```

---

### 🔹 Intuition

We must pick digits from both arrays to form the **largest possible lexicographical number**. This requires balancing between **choosing locally maximum digits** while **maintaining global order**.

The problem can be broken down into:
1. Choosing the best subsequence of size `i` from `nums1`.
2. Choosing the best subsequence of size `k - i` from `nums2`.
3. Merging both subsequences to form the largest possible result.
4. Trying all combinations of `i` from `0` to `k`.

---

### 🧩 Approach Breakdown

#### Step 1: Pick Maximum Subsequence from One Array
Use a **monotonic stack** to extract the maximum subsequence of length `t` while maintaining order.

```java
private int[] maxSubsequence(int[] nums, int k) {
    int[] stack = new int[k];
    int top = -1, remain = nums.length;
    for (int num : nums) {
        while (top >= 0 && stack[top] < num && remain > k - top - 1) top--;
        if (top + 1 < k) stack[++top] = num;
        remain--;
    }
    return stack;
}
```

#### Step 2: Merge Two Subsequences
To combine two subsequences into the lexicographically largest array, compare elements sequence-wise.

```java
private int[] merge(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int i = 0, j = 0, r = 0;
    while (i < nums1.length || j < nums2.length)
        res[r++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
    return res;
}

private boolean greater(int[] nums1, int i, int[] nums2, int j) {
    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) { i++; j++; }
    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
}
```

#### Step 3: Iterate Over All Splits
Try all possible divisions of `k` digits between `nums1` and `nums2`, and keep the lexicographically largest result.

```java
public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] best = new int[k];
    for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
        int[] subseq1 = maxSubsequence(nums1, i);
        int[] subseq2 = maxSubsequence(nums2, k - i);
        int[] candidate = merge(subseq1, subseq2);
        if (greater(candidate, 0, best, 0)) best = candidate;
    }
    return best;
}
```

---

### 🐍 Python Implementation

```python
class Solution:
    def maxNumber(self, nums1, nums2, k):
        def pick_max(nums, k):
            stack = []
            drop = len(nums) - k
            for num in nums:
                while drop and stack and stack[-1] < num:
                    stack.pop(); drop -= 1
                stack.append(num)
            return stack[:k]

        def merge(a, b):
            res = []
            while a or b:
                if a > b: res.append(a.pop(0))
                else: res.append(b.pop(0))
            return res

        best = []
        for i in range(max(0, k - len(nums2)), min(k, len(nums1)) + 1):
            cand = merge(pick_max(nums1, i), pick_max(nums2, k - i))
            best = max(best, cand)
        return best
```

---

### 🧮 Complexity Analysis

| Step               | Time Complexity | Space Complexity |
| ------------------ | ---------------- | ---------------- |
| Pick Max Subseq    | O(n)             | O(n)             |
| Merge              | O(k)             | O(k)             |
| Try All Splits     | O(k * (m + n))   | O(m + n)         |
| **Overall**        | **O(k * (m + n))** | **O(m + n)**     |

---

### 💬 Interview Questions

1. **Why is the problem not solvable greedily from both arrays at once?**  
   Because local maxima may not yield the globally largest number — order constraints matter.

2. **What’s the trickiest part?**  
   Lexicographical comparison during merge — you must compare suffixes, not just elements.

3. **Can we optimize comparisons?**  
   Yes, memoization can help, but not necessary for constraints.

4. **Why is the monotonic stack used?**  
   It efficiently finds the largest subsequence while preserving order.

---

### 🧩 Key Takeaways

- This problem combines **Greedy + Monotonic Stack + Merge Techniques**.
- Understanding lexicographical order and sequence merging is critical.
- Commonly asked in high-level interviews (Google, Amazon, ByteDance).
- Practice merging techniques to avoid O(k²) pitfalls.
- Variants appear in problems like **LeetCode 402 (Remove K Digits)** and **LeetCode 321-like custom tasks**.

