# 🧩 LeetCode 88: Merge Sorted Array

---

## ✅ 0. Question

You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively. Merge `nums2` into `nums1` as one sorted array in-place.

Note: `nums1` has sufficient space (size that is equal to m + n) to hold additional elements from `nums2`.

### Example:
```text
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
```

---

## ✅ 1. Definition and Purpose

This problem reinforces in-place array manipulation while maintaining order. It tests understanding of two-pointer techniques and edge case management in array merging scenarios.

---

## ✅ 2. Syntax and Structure

```java
public void merge(int[] nums1, int m, int[] nums2, int n)
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Two Pointers from End (Optimized)
```java
// ✅ Time: O(m + n), Space: O(1)
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Step 1: Initialize three pointers
    int i = m - 1; // Pointer for nums1
    int j = n - 1; // Pointer for nums2
    int k = m + n - 1; // Fill from the end of nums1

    // Step 2: Merge while both arrays have elements
    while (i >= 0 && j >= 0) {
        // Compare and place the larger at the end
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    // Step 3: If nums2 still has elements left
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}
```

### ASCII Illustration
```
nums1: [1,2,3,0,0,0]
nums2:       [2,5,6]

Start from back:
Compare 3 and 6 -> put 6 at end
Compare 3 and 5 -> put 5 at position 4
Compare 3 and 2 -> put 3...
...
Result: [1,2,2,3,5,6]
```

### 🔹 Approach 2: Append + Sort (Brute-force)
```java
// ✅ Time: O((m+n) log(m+n)), Space: O(1) extra (in-place sort)
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Step 1: Copy nums2 into nums1 starting at index m
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    // Step 2: Sort the resulting array
    Arrays.sort(nums1);
}
```

---

## ✅ 4. Internal Working

- Optimized approach avoids extra space by starting from end
- Sorting approach leverages built-in sorting algorithms (TimSort)
- In-place sorting prevents additional memory use

---

## ✅ 5. Best Practices

- Use reverse merging technique to avoid overwriting elements
- Don't forget edge case where nums2 has elements and nums1 has none (m = 0)
- Avoid unnecessary sorting for already sorted input

---

## ✅ 6. Related Concepts

- Two Pointers
- In-place Sorting
- Merge Sort’s merge step

---

## ✅ 7. Interview & Real-world Use

- Merging logs, sorted datasets, pagination
- Common in database merge join algorithms

---

## ✅ 8. Common Errors & Debugging

- Not handling leftover elements in nums2
- Overwriting values in nums1 before they’re processed
- Incorrectly updating pointer indices

---

## ✅ 9. Java Version Updates

- Java 8+: Arrays.sort supports lambda for custom object sorting

---

## ✅ 10. Practice and Application

- LeetCode 21: Merge Two Sorted Lists
- LeetCode 56/57: Merge Intervals / Insert Interval
- Sorting datasets from multiple sources

---

🚀 Mastering this teaches efficient in-place operations and helps in optimizing for time & space.

