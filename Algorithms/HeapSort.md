# 📚 Heap Sort in Java

---

## ✅ 1. Definition and Purpose

- **Heap Sort** is a comparison-based sorting technique based on a Binary Heap data structure.
- It creates a max-heap or min-heap and repeatedly extracts the maximum (or minimum) element.
- It is an in-place algorithm but not stable.

### Why Heap Sort?
- Guarantees O(n log n) time in all cases (unlike QuickSort).
- No need for additional memory (unlike Merge Sort).

---

## ✅ 2. Syntax and Structure

```java
public void heapSort(int[] arr) {
    int n = arr.length;

    // Build max heap
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    // One by one extract elements from heap
    for (int i = n - 1; i > 0; i--) {
        // Swap root with end element
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // Heapify the reduced heap
        heapify(arr, i, 0);
    }
}

// To heapify a subtree rooted at index i
void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}
```

---

## ✅ 3. Practical Example

```java
int[] data = {4, 10, 3, 5, 1};
heapSort(data);
System.out.println(Arrays.toString(data));
// Output: [1, 3, 4, 5, 10]
```

---

## ✅ 4. Internal Working

- **Phase 1**: Build a max heap (parent node > children)
- **Phase 2**: Repeatedly extract the root (max) and reduce the heap

### ASCII Visualization:
Before Heapify:
```
       4
     /   \
   10     3
  /  \
 5    1
```
After building heap:
```
      10
     /  \
    5    3
   / \
  4   1
```

---

## ✅ 5. Best Practices

- Use heapify from bottom-up for optimal construction.
- Do not create a new array; sort in-place.
- Avoid using recursion if stack depth is a concern.

---

## ✅ 6. Related Concepts

- Binary Heap
- Priority Queue (Java's `PriorityQueue`)
- Complete Binary Tree
- Heapify process

---

## ✅ 7. Interview & Real-world Use

- Used in event-driven simulation, job schedulers.
- Frequently asked in interviews to test knowledge of heaps and in-place sorting.

---

## ✅ 8. Common Errors & Debugging

- Forgetting to call `heapify()` after every swap.
- Index out-of-bound errors while calculating left/right.
- Not building heap correctly from the bottom.

---

## ✅ 9. Java Version Updates

- Java's `PriorityQueue` internally uses heap (min-heap by default).
- Java 11+ has `Collectors.collectingAndThen` for heap post-processing.

---

## ✅ 10. Practice and Application

- LeetCode 215: Kth Largest Element in an Array
- LeetCode 703: Kth Largest Stream
- Sorting large datasets in constant space

---

✅ Heap Sort is a robust and predictable sorting technique with consistent time performance, ideal when memory usage and worst-case time are priorities.

