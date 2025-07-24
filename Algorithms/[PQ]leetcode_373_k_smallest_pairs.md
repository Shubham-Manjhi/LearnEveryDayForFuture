**LeetCode 373: Find K Pairs with Smallest Sums**

---

### 1. Problem Statement
Given two integer arrays `nums1` and `nums2` sorted in ascending order, and an integer `k`, return the `k` pairs `(u,v)` with the smallest sums, where `u` is from `nums1` and `v` is from `nums2`.

**Function Signature:**
```java
List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
```

---

### 2. Understanding the Problem
- Goal is to generate `k` smallest sum combinations from two sorted arrays
- Output must be sorted in increasing sum order

---

### 3. Optimal Approach (Min Heap + BFS-style Traversal)
Use a **min-heap** to efficiently pick the next smallest pair sum.

```java
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
    );

    for (int i = 0; i < Math.min(k, nums1.length); i++) {
        minHeap.offer(new int[]{i, 0}); // Pair of indices
    }

    while (k-- > 0 && !minHeap.isEmpty()) {
        int[] idx = minHeap.poll();
        int i = idx[0], j = idx[1];
        result.add(Arrays.asList(nums1[i], nums2[j]));

        if (j + 1 < nums2.length) {
            minHeap.offer(new int[]{i, j + 1});
        }
    }

    return result;
}
```

---

### 4. Complexity Analysis
- **Time Complexity:** O(k log k) if k < m * n (heap operations dominate)
- **Space Complexity:** O(k) for the heap and result list

---

### 5. Edge Cases to Consider
- Either array is empty → return empty list
- `k == 0` → return empty list
- `k` is larger than `nums1.length * nums2.length`

---

### 6. Example
```java
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
```

---

### 7. Best Practices
- Use index pairs instead of storing actual values in heap (saves space)
- Use early cut-off with `Math.min(k, nums1.length)` to limit heap size

---

### 8. Related Topics
- Heap / PriorityQueue
- Matrix BFS / 2D traversal
- Greedy algorithms

---

### 9. Interview Tip
> Emphasize use of priority queue to always pick the next best combination and explain why brute force (all combinations) is inefficient.

---

### 10. Follow-up
> Can you return results in a streaming fashion, or build a lazy-evaluated iterator? This is useful when dealing with very large arrays.

