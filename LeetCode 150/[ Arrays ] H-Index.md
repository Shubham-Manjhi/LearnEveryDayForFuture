# 📘 LeetCode 274: H-Index

---

## ✅ 0. Question

Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their i-th paper, return the researcher's H-index.

The H-index is defined as the maximum value `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.

### Example:
```text
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] sorted is [0,1,3,5,6]. There are 3 papers with at least 3 citations.
```

---

## ✅ 1. Definition and Purpose

- The H-index quantifies scientific research output.
- Used to assess academic impact based on citation counts.
- Solves the problem of evaluating research productivity.

---

## ✅ 2. Syntax and Structure

```java
public int hIndex(int[] citations);
```

- Takes an array of integers.
- Returns the H-index as an integer.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Sorting (O(n log n))
```java
public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;

    // Traverse sorted citations from highest to lowest
    for (int i = 0; i < n; i++) {
        int h = n - i; // papers with at least citations[i] citations
        if (citations[i] >= h) {
            return h;
        }
    }
    return 0;
}
```

### 🔹 Approach 2: Counting (O(n))
```java
public int hIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];

    // Count how many papers have exactly i citations
    for (int c : citations) {
        if (c >= n) count[n]++;
        else count[c]++;
    }

    int total = 0;
    for (int i = n; i >= 0; i--) {
        total += count[i];
        if (total >= i) return i;
    }

    return 0;
}
```

---

## ✅ 4. Internal Working

- In the sorting method, the index in the sorted array gives how many papers have citations ≥ citations[i].
- In the counting approach, we build a histogram of citation counts and backtrack to find the highest index `i` such that `i` papers have ≥ `i` citations.

---

## ✅ 5. Best Practices

- Prefer counting approach for linear time complexity when dealing with large datasets.
- Always test edge cases like `[0]`, `[100]`, `[1, 1, 1, 1]`.

---

## ✅ 6. Related Concepts

- Histogram-based counting
- Sorting arrays
- Greedy and search techniques

---

## ✅ 7. Interview & Real-world Use

- Real-world metric used in academia.
- Common in interviews to test understanding of custom metric problems and greedy logic.

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors when counting or sorting.
- Misunderstanding the definition: h papers with at least h citations each.

---

## ✅ 9. Java Version Updates

- Uses basic Java features such as `Arrays.sort()` and array indexing.
- No specific version dependency.

---

## ✅ 10. Practice and Application

- LeetCode 275: H-Index II (binary search variant)
- LeetCode 135: Candy (similar greedy metric concept)

---

🚀 The H-Index teaches you how to work with data aggregation and comparison metrics!

