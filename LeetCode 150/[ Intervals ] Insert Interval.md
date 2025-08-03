# 📘 LeetCode 57: Insert Interval

---

## ✅ 0. Question

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` sorted in ascending order by starti and an interval `newInterval = [start, end]`. Insert `newInterval` into `intervals` such that the result is still non-overlapping intervals sorted by start time.

### Example:
```text
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

---

## ✅ 1. Definition and Purpose

This problem is about interval manipulation, a common pattern in computational geometry, calendars, and time-range tracking systems. The challenge is to insert a new interval and merge overlaps efficiently.

---

## ✅ 2. Syntax and Structure

```java
public int[][] insert(int[][] intervals, int[] newInterval);
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Linear Merge

```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = intervals.length;

    // Step 1: Add all intervals before newInterval
    while (i < n && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }

    // Step 2: Merge overlapping intervals with newInterval
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    result.add(newInterval);

    // Step 3: Add all remaining intervals
    while (i < n) {
        result.add(intervals[i]);
        i++;
    }

    return result.toArray(new int[result.size()][]);
}
```

### ASCII Example:
```
Existing Intervals: [1,3] [6,9]
New: [2,5]
Step 1: [1,3] is overlapping -> Merge with [2,5] => [1,5]
Step 2: [6,9] is after -> Keep as-is
Result: [1,5] [6,9]
```

---

## ✅ 4. Internal Working

- Linear scan finds non-overlapping, overlapping, and after intervals
- Time complexity: O(n)
- Space complexity: O(n)

---

## ✅ 5. Best Practices

- Always handle edge cases (empty input, full overlap)
- Avoid sorting again if already sorted
- Use `List<int[]>` for flexibility

---

## ✅ 6. Related Concepts

- Merge Intervals (LC 56)
- Calendar Booking
- Sweep Line Algorithm

---

## ✅ 7. Interview & Real-world Use

- Calendar systems like Google Calendar
- Video timeline editing
- Reservation systems

---

## ✅ 8. Common Errors & Debugging

- Not merging all overlapping intervals
- Misplacing newInterval
- Returning wrong array format

---

## ✅ 9. Java Version Updates

- Java 8+: Streams can be used to simplify conversion

---

## ✅ 10. Practice and Application

- LeetCode 56: Merge Intervals
- LeetCode 986: Interval List Intersections
- Cracking the Coding Interview: Booking conflicts

---

🚀 Mastering this strengthens array, sorting, and greedy merging logic critical in system design.

