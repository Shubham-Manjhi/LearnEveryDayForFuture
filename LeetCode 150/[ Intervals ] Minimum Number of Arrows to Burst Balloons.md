# 🎯 LeetCode 452: Minimum Number of Arrows to Burst Balloons

---

## ✅ 0. Question

There are `n` balloons, each balloon is represented as a horizontal interval on the x-axis. You are given the array `points` where `points[i] = [x_start, x_end]` denotes a balloon that starts at `x_start` and ends at `x_end`.

You must shoot arrows at integer coordinates such that each balloon is burst by one arrow. An arrow can burst a balloon if it is shot at an x-coordinate between the start and end of the interval.

Return the minimum number of arrows needed to burst all balloons.

### Example:
```text
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: Arrows at x = 6 and x = 11 burst all balloons
```

---

## ✅ 1. Definition and Purpose

This problem focuses on interval overlap minimization. The task is to cover all intervals with the minimum number of arrows (overlapping intervals can be hit with a single arrow).

This is an application of greedy algorithms in interval scheduling/covering.

---

## ✅ 2. Syntax and Structure

```java
public int findMinArrowShots(int[][] points);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Greedy with Sorting by End Time (Optimal)

```java
public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;

    // Step 1: Sort by ending x-coordinate
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

    int arrows = 1;  // At least one arrow needed
    int end = points[0][1];

    for (int i = 1; i < points.length; i++) {
        // Step 2: If current balloon starts after 'end', new arrow needed
        if (points[i][0] > end) {
            arrows++;
            end = points[i][1];  // Reset the end
        }
    }

    return arrows;
}
```

### 🔹 Approach 2: Interval Merging Simulation

```java
public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;

    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

    int arrows = 1;
    int[] prev = points[0];

    for (int i = 1; i < points.length; i++) {
        if (points[i][0] <= prev[1]) {
            // Update overlapping range
            prev[0] = Math.max(prev[0], points[i][0]);
            prev[1] = Math.min(prev[1], points[i][1]);
        } else {
            arrows++;
            prev = points[i];
        }
    }

    return arrows;
}
```

### ASCII Diagram:
```
Input Intervals: [1---6], [2----8], [7----12], [10----16]
Sorted by end:  [1---6], [2----8], [7----12], [10----16]

Arrow @ 6 hits: [1---6], [2----8]
Arrow @ 12 hits: [7----12], [10----16]
Total: 2 Arrows
```

---

## ✅ 4. Internal Working

- Sort intervals based on end (greedy idea)
- Select arrow just before current balloon ends
- Avoids overlapping re-checks
- Time Complexity: O(n log n) for sorting
- Space Complexity: O(1)

---

## ✅ 5. Best Practices

- Always sort intervals before greedy loop
- Use `Integer.compare` to prevent overflow
- Initialize arrow count properly (usually 1)

---

## ✅ 6. Related Concepts

- Greedy Algorithms
- Interval Scheduling
- Activity Selection Problem

---

## ✅ 7. Interview & Real-world Use

- Used in job scheduling
- Similar to video ad scheduling or event deduplication

---

## ✅ 8. Common Errors & Debugging

- Off-by-one error in comparison (use `>` instead of `>=`)
- Not updating `end` correctly
- Sorting by start instead of end (less optimal)

---

## ✅ 9. Java Version Updates

- Java 8+: Lambda for comparator
- Java 11+: `var` support for loop simplification

---

## ✅ 10. Practice and Application

- LeetCode 435: Non-overlapping Intervals
- LeetCode 56: Merge Intervals
- LeetCode 1288: Remove Covered Intervals

---

🚀 Mastering this builds strong interval-greedy intuition, perfect for both coding interviews and real-world timeline/graph processing!

