**Java Topic: LeetCode 4 - Median of Two Sorted Arrays**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

• Why does it exist in Java?\
This problem tests how well you can optimize across two sorted data structures and apply binary search logic across them.

• What problem does it solve?\
It solves efficient median calculation in combined datasets without merging them entirely.

🧠 Example: Input: nums1 = [1,3], nums2 = [2] → Output: 2.0

---

✅ 2. Syntax and Structure

• Define `double findMedianSortedArrays(int[] nums1, int[] nums2)`\
• Use binary search on the shorter array to find correct partition point

---

✅ 3. Practical Examples

🔹 Approach: Binary Search Partitioning

```java
public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int m = A.length, n = B.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : A[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : B[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                else
                    return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
```

🖼️ ASCII Diagram – Partitioning Example:

```
A: [1, 3]
B: [2, 4, 5, 6]

Partition:
A: [1] | [3]
B: [2, 4] | [5, 6]

MaxLeft = 4
MinRight = 5
Median = (4 + 5)/2 = 4.5
```

---

✅ 4. Internal Working

• Uses binary search to find the correct cut point in the smaller array\
• Ensures left half of merged array is ≤ right half

Time Complexity: O(log(min(m, n)))

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Always binary search the smaller array\
✔ Handle edge cases with min/max constants\
✔ Avoid full merge to retain performance

---

✅ 6. Related Concepts

- Binary Search on Partition Point
- Median and Order Statistics
- Two Pointer Technique (naive approach)

🧠 Example: Median of sensor readings from two devices

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- High frequency at FAANG interviews due to complexity\


- Great test of binary search under constraint

🏢 Real-world:

- Analytics on merged datasets\


- Median income/statistics reporting from merged sources

---

✅ 8. Common Errors & Debugging

❌ Using merged array (leads to O(m+n))\
❌ Wrong partition boundaries or index math\
❌ Not accounting for even/odd lengths correctly

🧪 Debug Tip:

- Print partitions and mid values\


- Simulate even and odd length scenarios

---

✅ 9. Java Version Updates

• No version-specific features required\
• Enhanced arithmetic and exception handling in newer versions

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #4\


- Hard-level binary search challenges

🏗 Apply in:

- Financial analytics\


- Comparative trend analysis\


- Statistical engines

