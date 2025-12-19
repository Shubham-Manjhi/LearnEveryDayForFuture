🎯 **Binary Search — Complete Expert Guide (Java + Python)**

---

## ⚙️ Overview
Binary Search is one of the most efficient searching algorithms used to find the position of a target element within a **sorted array**. It repeatedly divides the search interval in half until the target element is found or the interval is empty.

### 🔹 Key Characteristics
- **Algorithm Type:** Divide and Conquer
- **Best Case:** O(1)
- **Average Case:** O(log n)
- **Worst Case:** O(log n)
- **Space Complexity:** O(1) for iterative, O(log n) for recursive
- **Stability:** Not applicable (searching algorithm)

---

## 🧩 How Binary Search Works
1. **Start** with the entire sorted array.
2. **Find the middle** element of the array.
3. If the middle element equals the target → return its index.
4. If the target < middle → search in the left half.
5. If the target > middle → search in the right half.
6. Repeat steps 2–5 until the element is found or range becomes empty.

### 🔍 Example Walkthrough
Array: `[2, 3, 4, 10, 40]`, Target = 10

1. Low = 0, High = 4 → Mid = 2 → arr[2] = 4 (Target > 4)
2. Search right half → Low = 3, High = 4 → Mid = 3 → arr[3] = 10 (Found)

✅ Output: Element 10 found at index 3.

---

## 🧠 Types of Binary Search

### 1. **Iterative Binary Search**
- Implemented using a loop.
- Efficient in terms of memory usage.

### 2. **Recursive Binary Search**
- Uses recursion to divide the array.
- Easier to understand but uses extra stack space.

| Type | Space Complexity | Implementation | Advantage |
| ---- | ---------------- | -------------- | ---------- |
| Iterative | O(1) | Uses loop | Memory efficient |
| Recursive | O(log n) | Uses recursion | Cleaner logic |

---

## 💬 Interview Questions & Answers

### Q1. Why must the array be sorted for Binary Search?
**A:** Because binary search works by eliminating half of the array each step. Without sorting, the elimination logic fails.

### Q2. How do you find the first or last occurrence of an element using Binary Search?
**A:** Modify the condition to continue searching on one side even after finding the target.
- First occurrence → Move left (`high = mid - 1`)
- Last occurrence → Move right (`low = mid + 1`)

### Q3. What are the limitations of Binary Search?
**A:**
- Works only on **sorted data**.
- Not suitable for **linked lists** due to random access requirement.
- May lead to **stack overflow** in deep recursion (for very large arrays).

### Q4. Can Binary Search be used on decreasingly sorted arrays?
**A:** Yes. Modify the comparison logic accordingly.

### Q5. What is the time complexity of Binary Search Tree (BST) search?
**A:** O(log n) for balanced trees, O(n) for skewed trees.

---

## 💻 Java Implementation (Iterative)
```java
public class BinarySearch {
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch(arr, target);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}
```

---

## 🐍 Python Implementation (Recursive)
```python
def binary_search(arr, low, high, target):
    if high >= low:
        mid = low + (high - low) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            return binary_search(arr, low, mid - 1, target)
        else:
            return binary_search(arr, mid + 1, high, target)
    else:
        return -1

arr = [2, 3, 4, 10, 40]
target = 10
result = binary_search(arr, 0, len(arr) - 1, target)
if result != -1:
    print(f"Element found at index {result}")
else:
    print("Element not found")
```

---

## ⚡ Advanced Variants

### 1. **Lower Bound / Upper Bound Search**
Finds first/last position of element greater or smaller than the target.

### 2. **Search in Rotated Sorted Array**
Used when the sorted array is rotated; determine which half is sorted before applying binary search.

### 3. **Binary Search on Infinite Array**
Gradually expand search space until target lies within bounds.

### 4. **Binary Search in Matrix**
Treat a 2D matrix as a 1D array and apply binary search.

---

## 📊 Complexity Analysis
| Case    | Time Complexity | Space Complexity | Remarks |
| ------- | --------------- | ---------------- | -------- |
| Best    | O(1)            | O(1)             | Element found at mid |
| Average | O(log n)        | O(1) / O(log n)  | Iterative vs Recursive |
| Worst   | O(log n)        | O(log n)         | When target not found |

---

## 🧭 Real-World Applications
- **Database Indexing**
- **Compiler Optimization** (symbol lookup)
- **Auto-suggestion Systems**
- **Version Control (Git bisect)**
- **Gaming (AI search logic)**

---

## 🔑 Key Takeaways
- Binary Search reduces problem size by **half each iteration**.
- Works efficiently on **sorted data structures**.
- Core logic behind algorithms like **search in rotated arrays** and **square root approximation**.
- Used in **competitive programming** and **system design** for performance-critical searches.

