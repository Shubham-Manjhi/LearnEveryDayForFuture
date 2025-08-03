# 📘 LeetCode 56: Merge Intervals

---

## ✅ 0. Question

Given an array of intervals where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

### Example:
```text
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
```

---

## ✅ 1. Definition and Purpose

The merge intervals problem involves condensing overlapping intervals into fewer or singular ranges. It is common in scheduling, database queries, and timeline manipulations.

---

## ✅ 2. Syntax and Structure

```java
public int[][] merge(int[][] intervals);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force with Sorting (Less Optimized)

```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    boolean[] merged = new boolean[intervals.length];
    List<int[]> result = new ArrayList<>();

    for (int i = 0; i < intervals.length; i++) {
        if (merged[i]) continue;
        int start = intervals[i][0];
        int end = intervals[i][1];

        for (int j = i + 1; j < intervals.length; j++) {
            if (!merged[j] && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                merged[j] = true;
            }
        }

        result.add(new int[]{start, end});
    }

    return result.toArray(new int[result.size()][]);
}
```

### 🔹 Approach 2: Optimized - Sort + Merge (Recommended)

```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;

    // Step 1: Sort intervals by starting time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
        // Step 2: Check if intervals overlap
        if (current[1] >= intervals[i][0]) {
            // Merge intervals
            current[1] = Math.max(current[1], intervals[i][1]);
        } else {
            result.add(current);
            current = intervals[i];
        }
    }

    result.add(current);
    return result.toArray(new int[result.size()][]);
}
```

### ASCII Trace:
```
Input:  [1,3] [2,6] [8,10] [15,18]
Sort:   [1,3] [2,6] [8,10] [15,18]
Merge:  [1,6] [8,10] [15,18]
```

---

## ✅ 4. Internal Working

- Both approaches sort the input by start time.
- Brute force checks overlapping intervals by scanning every following interval.
- Optimized approach keeps track of current merged interval and appends when overlap ends.
- Time Complexity:
  - Brute Force: O(n^2)
  - Optimized: O(n log n)
- Space Complexity: O(n) in both for result storage.

---

## ✅ 5. Best Practices

- Always sort intervals before merging.
- Use optimized merging for larger datasets.
- Prefer in-place modification if allowed.

---

## ✅ 6. Related Concepts

- Sweep Line Algorithm
- Greedy Merge
- Sorting Intervals

---

## ✅ 7. Interview & Real-world Use

- Merging time ranges in calendar applications
- Allocating resource slots
- Compressing ranges in file systems

---

## ✅ 8. Common Errors & Debugging

- Forgetting to add the last interval
- Incorrect merge logic (not updating max end)
- Not sorting by start time before merge

---

## ✅ 9. Java Version Updates

- Java 8+: Use lambda with Arrays.sort
- Java 11+: `var` can simplify loop declarations

---

## ✅ 10. Practice and Application

- LeetCode 57: Insert Interval
- LeetCode 986: Interval List Intersections
- Real-world: Calendar invite conflict resolution

---

🚀 Mastering this builds confidence in greedy techniques and interval sorting—key for interviews and backend system design.

