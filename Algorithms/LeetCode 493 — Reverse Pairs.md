🎯 **LeetCode 493 — Reverse Pairs (Java + Python Expert Guide)**

---

## ⚙️ Overview
The problem asks for the **number of reverse pairs** in an array, where a reverse pair is defined as `(i, j)` such that `i < j` and `nums[i] > 2 * nums[j]`. This is a **classic divide-and-conquer problem** suitable for advanced sorting algorithms like Merge Sort.

### 🔹 Key Characteristics
- **Algorithm Type:** Divide and Conquer / Modified Merge Sort
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)
- **Space Complexity:** O(n)
- **Stability:** Not relevant (counting problem)

---

## 🧩 How Reverse Pairs Works
1. Divide the array into two halves.
2. Recursively count reverse pairs in the left and right halves.
3. Count cross pairs where `nums[i] > 2 * nums[j]` for `i` in left half and `j` in right half.
4. Merge the two halves in sorted order.

This allows counting reverse pairs **efficiently in O(n log n)** rather than O(n²).

### 🔍 Example Walkthrough
Array: `[1,3,2,3,1]`

- Divide: `[1,3,2]` and `[3,1]`
- Count in left: 1 pair
- Count in right: 1 pair
- Count cross pairs: 2 pairs
- Total reverse pairs: 4

---

## 🧠 Algorithm (Merge Sort Based)
1. Implement **merge sort** that returns the count of reverse pairs.
2. During merge step, for each element in left half, use a pointer to find how many elements in right half satisfy `nums[i] > 2 * nums[j]`.
3. Sum counts from left, right, and cross pairs.
4. Merge arrays to maintain sorted order.

Time Complexity: `O(n log n)`
Space Complexity: `O(n)`

---

## 💻 Java Implementation
```java
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) j++;
            count += j - (mid + 1);
        }
        merge(nums, left, mid, right);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(new ReversePairs().reversePairs(nums)); // Output: 2
    }
}
```

---

## 🐍 Python Implementation
```python
def reversePairs(nums):
    def merge_sort(start, end):
        if start >= end:
            return 0
        mid = (start + end) // 2
        count = merge_sort(start, mid) + merge_sort(mid+1, end)
        j = mid + 1
        for i in range(start, mid+1):
            while j <= end and nums[i] > 2 * nums[j]:
                j += 1
            count += j - (mid + 1)
        nums[start:end+1] = sorted(nums[start:end+1])
        return count
    return merge_sort(0, len(nums) - 1)

# example
print(reversePairs([1,3,2,3,1]))  # Output: 2
```

---

## ⚡ Key Points & Optimizations
- Use **long or 2L multiplication** in Java to prevent integer overflow.
- Sorting in-place is optional; temporary array is sufficient.
- Alternative approaches: **Binary Indexed Tree (Fenwick)** or **Segment Tree** for dynamic counting.
- Avoid naive O(n²) double loop; only feasible for small arrays.

---

## 📊 Complexity Analysis
| Case      | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| All cases | O(n log n)      | O(n)             |

---

## 🔑 Takeaways
- Reverse Pairs is a classic **merge sort counting problem**.
- Efficient counting uses sorted halves to compute cross pairs.
- Familiarity with this pattern helps in other **counting problems** like inversion count, smaller numbers after self, and related LeetCode problems.

