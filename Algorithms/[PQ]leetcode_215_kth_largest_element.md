**LeetCode 215: Kth Largest Element in an Array**

---

### 1. Problem Statement

Given an integer array `nums` and an integer `k`, return the `k`th largest element in the array.

**Note:** It's the `k`th largest **number**, not necessarily the `k`th **distinct** element.

**Function Signature:**

```java
int findKthLargest(int[] nums, int k)
```

---

### 2. Understanding the Problem

- Input: Unsorted array `nums`, integer `k`
- Output: The `k`th largest number
- Must be efficient; sorting the array is acceptable for small sizes but not optimal for large inputs

---

### 3. Optimal Approach (Min Heap of size k)

**Idea:** Maintain a min heap of size `k`. The root will be the kth largest element.

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
        minHeap.add(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    return minHeap.peek();
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n log k)
- **Space Complexity:** O(k)

---

### 5. Alternative Approach (Quickselect)

A variation of QuickSort that partitions the array to find the kth largest in average O(n) time.

```java
public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
}

private int quickSelect(int[] nums, int left, int right, int kSmallest) {
    if (left == right) return nums[left];

    int pivotIndex = partition(nums, left, right);

    if (kSmallest == pivotIndex) {
        return nums[kSmallest];
    } else if (kSmallest < pivotIndex) {
        return quickSelect(nums, left, pivotIndex - 1, kSmallest);
    } else {
        return quickSelect(nums, pivotIndex + 1, right, kSmallest);
    }
}

private int partition(int[] nums, int left, int right) {
    int pivot = nums[right];
    int i = left;
    for (int j = left; j < right; j++) {
        if (nums[j] <= pivot) {
            swap(nums, i, j);
            i++;
        }
    }
    swap(nums, i, right);
    return i;
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

---

### 6. Edge Cases to Consider

- `k = 1`: return max element
- `k = nums.length`: return min element
- Array with duplicate elements

---

### 7. Best Practices

- Use heap for simplicity and guaranteed performance
- Use quickselect for performance-critical, average-case optimal scenarios

---

### 8. Related Topics

- Heap / Priority Queue
- Sorting
- QuickSort / Partitioning

---

### 9. Interview Tip

> Clarify whether the elements are unique and whether full sorting is acceptable. Always offer heap and quickselect as trade-offs.

---

### 10. Follow-up

> How would you solve this in a streaming setup, where the array is too large to fit in memory? Use a min heap of size `k` to continuously track top k elements.

---

### Example

```java
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

