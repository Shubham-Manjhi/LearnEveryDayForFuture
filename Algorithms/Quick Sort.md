🎯 **Quick Sort — In-Depth Expert Guide (Java + Python)**

---

## ⚙️ Overview
Quick Sort is a **divide-and-conquer** sorting algorithm. It works by selecting a *pivot* element from the array and partitioning the other elements into two subarrays—those less than the pivot and those greater than the pivot.

### 🔹 Key Characteristics
- **Algorithm Type:** Divide and Conquer
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n²)
- **Space Complexity:** O(log n)
- **Stability:** Not stable

---

## 🧩 How Quick Sort Works
1. **Choose a pivot** (e.g., first, last, middle, or random element).
2. **Partition** the array into two halves:
   - Left half: elements < pivot
   - Right half: elements > pivot
3. **Recursively sort** both halves.
4. **Combine results** — the array is sorted in-place.

### 🔍 Example Walkthrough
Array: `[10, 80, 30, 90, 40, 50, 70]`
1. Choose pivot = 70
2. Partition: `[10, 30, 40, 50] [70] [80, 90]`
3. Recurse on left and right subarrays.
4. Final Sorted Array: `[10, 30, 40, 50, 70, 80, 90]`

---

## 🧠 Partitioning Strategies

### 1. **Lomuto Partition Scheme**
- Pivot = last element
- Iterate through array, swap smaller elements before pivot.

### 2. **Hoare Partition Scheme**
- Pivot = first element
- Two pointers move inward from both ends.
- Swap when left > pivot and right < pivot.

| Scheme | Pivot | Swap Condition | Space | Stability |
|:--------|:------|:---------------|:-------|:-----------|
| Lomuto | Last element | i < j & arr[i] > pivot | O(log n) | No |
| Hoare | First element | left < right | O(log n) | No |

---

## 💬 Interview Questions & Answers

### Q1. Why is Quick Sort preferred over Merge Sort?
**A:** Quick Sort is often faster in practice due to better cache performance and in-place sorting, requiring less memory.

### Q2. When does Quick Sort perform poorly?
**A:** When the pivot always results in highly unbalanced partitions (e.g., sorted or reverse-sorted input).

### Q3. How can we optimize Quick Sort?
**A:**
- Use **randomized pivot selection**.
- Switch to **Insertion Sort** for small subarrays.
- Tail call elimination to optimize recursion.

### Q4. Is Quick Sort stable?
**A:** No. Equal elements may change relative positions after sorting.

### Q5. Can Quick Sort be used for linked lists?
**A:** Yes, but Merge Sort is generally more efficient for linked lists.

---

## 💻 Java Implementation
```java
public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

---

## 🐍 Python Implementation
```python
def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

def quick_sort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quick_sort(arr, low, pi - 1)
        quick_sort(arr, pi + 1, high)

arr = [10, 7, 8, 9, 1, 5]
quick_sort(arr, 0, len(arr) - 1)
print(arr)
```

---

## ⚡ Optimizations
- **Random Pivot Selection** — prevents O(n²) worst-case.
- **Hybrid Sorting (Quick + Insertion Sort)** — better for small partitions.
- **Tail Recursion Optimization** — reduces recursion depth.

---

## 📊 Complexity Analysis
| Case | Time Complexity | Space Complexity |
|:-----|:----------------|:----------------|
| Best | O(n log n) | O(log n) |
| Average | O(n log n) | O(log n) |
| Worst | O(n²) | O(log n) |

---

## 🧭 Real-World Applications
- **Database Query Optimization**
- **Search Engine Indexing**
- **Data Analytics Pipelines**
- **Memory-Constrained Environments**

---

## 🔑 Key Takeaways
- Quick Sort is one of the **fastest general-purpose sorting algorithms**.
- Works **in-place** and performs well on large datasets.
- Needs careful **pivot strategy** to avoid worst-case.
- Commonly used in **C, Java, and Python libraries** for internal sorting mechanisms.

