# 📘 LeetCode 719: Find K-th Smallest Pair Distance

---

## ✅ 0. Question

Given an integer array `nums` and an integer `k`, return the k-th smallest distance among all the pairs `nums[i]` and `nums[j]` where `0 <= i < j < nums.length`.

### Example:
```text
Input: nums = [1,3,1], k = 1
Output: 0
Explanation: The only pairs are (1,3), (1,1), (3,1), and the distances are 2, 0, 2. The 1st smallest is 0.
```

---

## ✅ 1. Definition and Purpose

This problem finds the k-th smallest pairwise distance in an array. It's a great problem to master techniques like binary search on the answer and sliding window.

---

## ✅ 2. Syntax and Structure

- Java PriorityQueue for brute-force
- Binary search combined with two-pointer counting for optimization

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force with Priority Queue
```java
public int smallestDistancePair(int[] nums, int k) {
    // Step 1: Store all distances in a list
    List<Integer> distances = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            distances.add(Math.abs(nums[i] - nums[j]));
        }
    }

    // Step 2: Sort the distances
    Collections.sort(distances);

    // Step 3: Return the k-th smallest
    return distances.get(k - 1);
}
```

⏱️ Time Complexity:
- O(n^2 log n)
- Space: O(n^2) for storing all distances

### 🔹 Approach 2: Binary Search on Answer (Optimized)
```java
public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums); // Step 1: Sort the array
    int n = nums.length;
    int low = 0;
    int high = nums[n - 1] - nums[0];

    // Step 2: Binary search the answer range
    while (low < high) {
        int mid = low + (high - low) / 2;
        int count = countPairs(nums, mid);

        if (count < k) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    return low; // Step 3: Minimum distance with at least k pairs
}

// Count pairs with distance <= mid using sliding window
private int countPairs(int[] nums, int mid) {
    int count = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
        while (nums[right] - nums[left] > mid) {
            left++;
        }
        count += right - left;
    }
    return count;
}
```

⏱️ Time Complexity:
- O(n log n + n log W), where W is the distance range
- Space: O(1)

---

## ✅ 4. Internal Working
- The brute force approach compares every pair and sorts distances.
- The optimized approach binary searches the minimum distance `d` such that at least `k` pairs exist with distance ≤ `d`.
- Counting is done via sliding window.

---

## ✅ 5. Best Practices
- Use binary search on value space for problems involving sorted data with counts.
- Use two-pointer counting for efficiency.

---

## ✅ 6. Related Concepts
- Binary Search
- Sliding Window
- PriorityQueue

---

## ✅ 7. Interview & Real-world Use
- Used in clustering, similarity search
- Asked in many FAANG interviews for testing understanding of advanced binary search

---

## ✅ 8. Common Errors & Debugging
- Off-by-one errors in pair counting
- Not sorting the array before binary search

---

## ✅ 9. Java Version Updates
- Java 8+: Lambda for PriorityQueue or Comparator

---

## ✅ 10. Practice and Application
- LeetCode 378: Kth Smallest Element in a Sorted Matrix
- LeetCode 4: Median of Two Sorted Arrays

---

📌 Remember:
- Always sort input when working with distance constraints
- Think about value-based binary search when indices are not the focus

