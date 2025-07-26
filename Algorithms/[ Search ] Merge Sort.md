# 📘 Merge Sort in Java

---

## ✅ 1. Definition and Purpose

- **Merge Sort** is a divide-and-conquer sorting algorithm.
- It divides the array into halves, sorts each half recursively, and merges them back together.
- **Purpose**: Offers O(n log n) worst-case performance and is a stable sort.
- Useful for sorting large datasets and external sorting (files, etc.).

---

## ✅ 2. Syntax and Structure

### Merge Sort Algorithm:

```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

public void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
    for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}
```

---

## ✅ 3. Practical Examples

```java
int[] nums = {38, 27, 43, 3, 9, 82, 10};
mergeSort(nums, 0, nums.length - 1);
System.out.println(Arrays.toString(nums));
```

Output:

```
[3, 9, 10, 27, 38, 43, 82]
```

---

## ✅ 4. Internal Working

- **Divide step**: Recursively split the array into halves.
- **Merge step**: Combine two sorted halves into a full sorted array.
- Time complexity: Always O(n log n)
- Space complexity: O(n) due to auxiliary arrays.

---

## ✅ 5. Best Practices

- Use Merge Sort for linked lists where insertion is costly.
- Be cautious of space complexity in memory-constrained environments.
- Combine with insertion sort for small arrays to optimize performance.

---

## ✅ 6. Related Concepts

- Quick Sort (also divide-and-conquer but in-place)
- Insertion Sort (used in hybrid algorithms)
- Merge algorithms for external sorting

---

## ✅ 7. Interview & Real-world Use

- Common algorithm question in coding interviews.
- Used in file sorting, parallel processing, and stable sorting needs.
- Java’s `Collections.sort()` uses a variant called TimSort (merge + insertion).

---

## ✅ 8. Common Errors & Debugging

- Forgetting base case in recursion (`left < right`)
- Wrong merging logic (indices mix-up)
- Not copying merged array back to original

---

## ✅ 9. Java Version Updates

- No direct changes to Merge Sort but Java 7+ uses TimSort for List sorting.
- Still useful for custom sorting logic.

---

## ✅ 10. Practice and Application

- LeetCode: Merge Intervals, Sort List
- HackerRank/Codeforces: Sorting problems
- Useful in hybrid algorithms and large data pipelines

---

## ✅ 11. ASCII Diagram

```
Initial: [38, 27, 43, 3, 9, 82, 10]

Divide:
[38, 27, 43]   |   [3, 9, 82, 10]
[38] [27, 43]  |   [3, 9] [82, 10]

Merge:
[27, 38, 43]   |   [3, 9, 10, 82]

Final:
[3, 9, 10, 27, 38, 43, 82]
```

---

✅ You've now mastered Merge Sort in Java!

