**Java Problem: Merge Sorted Array (LeetCode 88)**

---

✅ 0. Question & Explanation

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n representing the number of elements in nums1 and nums2 respectively. Merge nums2 into nums1 as one sorted array in-place.

Note:

- nums1 has a size of m + n, where the first m elements denote the elements that should be merged, and the last n elements are 0 and should be ignored.
- nums2 has a size of n.

🧠 Example:

```java
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

---

✅ 1. Definition and Purpose

• What is the concept?\
Merging two sorted arrays into one, preserving the sorted order.

• Why does it exist in Java?\
This is a common problem in algorithms, frequently used in merge sort, databases, and external sorting.

• What problem does it solve?\
Efficiently combines two datasets without using extra space.

---

✅ 2. Syntax and Structure

Function signature:

```java
public void merge(int[] nums1, int m, int[] nums2, int n)
```

Core ideas:

- Traverse from the end to avoid overwriting elements in nums1
- Compare from back to front for in-place merge

---

✅ 3. Practical Examples

🔹 Approach 1: Merge from End (Optimized - In-place)

```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;           // Last valid element in nums1
        int j = n - 1;           // Last element in nums2
        int k = m + n - 1;       // Last position in nums1

        // Step 1: Merge from back to front
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // Step 2: Copy larger element
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Step 3: If elements in nums2 remain
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```

⏱ Time: O(m + n) | 💾 Space: O(1)

---

🔹 Approach 2: Use Extra Array (Straightforward)

```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n]; // Step 1: Create temporary array
        int i = 0, j = 0, k = 0;

        // Step 2: Merge nums1 and nums2
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < m) result[k++] = nums1[i++];
        while (j < n) result[k++] = nums2[j++];

        // Step 3: Copy back to nums1
        for (int l = 0; l < m + n; l++) {
            nums1[l] = result[l];
        }
    }
}
```

⏱ Time: O(m + n) | 💾 Space: O(m + n)

---

✅ 4. Internal Working

• In-place merge avoids using additional memory\
• Comparing from the back ensures space for insertion

---

✅ 5. Best Practices

✔ Always check edge cases when one array is empty\
✔ Use reverse merge to minimize writes and optimize space

---

✅ 6. Related Concepts

- Merge sort
- Two pointer technique
- In-place algorithms

---

✅ 7. Interview & Real-world Use

🧠 Interview:

- Classic problem to test algorithmic thinking and in-place modification

🏢 Real-world:

- Log file merging\

- Combining sorted streams\

- In-memory DB joins

---

✅ 8. Common Errors & Debugging

❌ Overwriting elements in nums1 from the start\
❌ Not handling remaining elements of nums2

🧪 Debug Tip: Use print statements to trace from back

---

✅ 9. Java Version Updates

• Java 8+ arrays library supports copying and sorting, but merge must be done manually for in-place logic

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode 88: Merge Sorted Array
- Merge Two Sorted Lists

🏗 Apply in:

- Data ingestion pipelines
- External sorting algorithms

---

