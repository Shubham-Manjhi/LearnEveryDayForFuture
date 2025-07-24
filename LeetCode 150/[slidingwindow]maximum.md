**Java Topic: 239. Sliding Window Maximum**

---

### 1. Definition and Purpose

**What is it?** LeetCode Problem 239: Given an integer array `nums` and a window size `k`, return an array of the maximum values in each sliding window of size `k` as it moves from left to right.

**Why does it exist in Java?** This problem demonstrates how to use Java collections (like `Deque` and `PriorityQueue`) to optimize sliding window operations.

**Problem it Solves:** Improves upon brute-force O(n\*k) approach by reducing time complexity to O(n), suitable for high-performance applications.

---

### 2. Syntax and Structure

**Function Signature:**

```java
public int[] maxSlidingWindow(int[] nums, int k)
```

**Key Structures Used:**

- `Deque<Integer>` to store indices of useful elements
- Arrays to store result

**Code Example (Using Deque):**

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0) return new int[0];
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        // Remove indices that are out of the window
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1)
            deque.pollFirst();

        // Remove elements smaller than current
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            deque.pollLast();

        deque.offerLast(i);

        if (i >= k - 1)
            result[i - k + 1] = nums[deque.peekFirst()];
    }

    return result;
}
```

---

### 3. Practical Examples

**Example 1:**

```java
int[] nums = {1,3,-1,-3,5,3,6,7};
int k = 3;
System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // [3,3,5,5,6,7]
```

**Use Cases:**

- CPU usage tracking in a time window
- Real-time analytics in dashboards
- Stock price peak in rolling time window

---

### 4. Internal Working

- Maintains a Deque of useful indices in descending value order
- Removes outdated indices outside the window
- The front of the deque always contains the index of the max value in current window

**Complexity:**

- Time: O(n)
- Space: O(k) for deque + result array

---

### 5. Best Practices

✅ Store indices, not values, in the deque\
✅ Always check and remove stale/outdated indices\
✅ Clean up deque before inserting a new element

❌ Don’t use brute-force for large arrays\
❌ Avoid storing values directly (leads to inefficiency)

---

### 6. Related Concepts

- Monotonic Queue
- Sliding Window Pattern
- Priority Queue (alternative slower solution)
- Two-pointer Technique

---

### 7. Interview & Real-world Use

🧠 Interview Prep:

- Popular at FAANG and other top tech companies
- Variants: Sliding window min, median, or k-th largest

🏢 Enterprise Use:

- Real-time anomaly detection (logs, sensors)
- Monitoring time-series metrics
- Alerting systems for thresholds

---

### 8. Common Errors & Debugging

❌ Forgetting to remove outdated indices (outside the window)\
❌ Not handling i >= k - 1 condition properly\
❌ Confusing values vs. indices in deque

🔍 Debug Tip:

- Log `deque` contents, current `i`, and `result[]` at each step for clarity

---

### 9. Java Version Updates

- No significant change in core logic since Java 8
- Java 8+ provides `Deque` (ArrayDeque) efficiently
- Streams/Lambdas can be used for pre/post-processing, not core algorithm

---

### 10. Practice and Application

📝 Practice On:

- LeetCode 239
- HackerRank: Deque Challenges
- GeeksforGeeks Sliding Window problems

🏗 Apply In:

- Real-time monitoring tools (e.g. Prometheus window functions)
- Log stream aggregation
- ML feature extraction in time-series analysis

