**Java Topic: Binary Search**

---

### 1. Definition and Purpose

**What is Binary Search?** Binary Search is an efficient algorithm for finding an item from a sorted list of elements by repeatedly dividing the search interval in half.

**Why does it exist in Java?** Java provides binary search implementations for sorted arrays and collections (like `Arrays.binarySearch()` and `Collections.binarySearch()`) to support quick data lookups.

**Problem it Solves:** Linear search has O(n) time complexity. Binary search reduces it to O(log n), making it highly scalable for large datasets.

---

### 2. Syntax and Structure

**Basic Conditions:**

- The array must be **sorted**.
- Operates with **low, mid, high** indices.

**Iterative Version:**

```java
public int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```

**Recursive Version:**

```java
public int binarySearchRecursive(int[] arr, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target)
        return binarySearchRecursive(arr, target, mid + 1, high);
    else
        return binarySearchRecursive(arr, target, low, mid - 1);
}
```

---

### 3. Practical Examples

**Example 1: Search in Sorted Array**

```java
int[] nums = {1, 3, 5, 7, 9, 11};
int index = binarySearch(nums, 7); // Output: 3
```

**Example 2: Java Built-in Method**

```java
import java.util.Arrays;
int[] nums = {10, 20, 30, 40, 50};
int index = Arrays.binarySearch(nums, 30); // Output: 2
```

**Mini-Project Use Case:**

- Searching for usernames in a sorted user list.
- Optimizing lookups in a leaderboard or product catalog.

---

### 4. Internal Working

- Binary Search divides the array by calculating mid = low + (high - low) / 2.
- Avoids overflow issues that may arise from (low + high) / 2.
- Time Complexity: O(log n)
- Space: O(1) for iterative, O(log n) for recursive (due to call stack).

---

### 5. Best Practices

**Dos:**

- Always ensure the input array is sorted.
- Use `low + (high - low)/2` to avoid overflow.
- Prefer built-in methods when applicable.

**Don'ts:**

- Don’t use binary search on unsorted data.
- Avoid recursive solutions for very large arrays to prevent stack overflow.

---

### 6. Related Concepts

- **Linear Search**: Less efficient, O(n).
- **Sorting Algorithms**: Sorting before searching (e.g., Arrays.sort()).
- **Divide and Conquer**: Strategy used by binary search.
- **Tree-based Search**: Like Binary Search Tree (BST) where similar logic applies.

---

### 7. Interview & Real-world Use

**Interview Tips:**

- Expect variations like: first/last occurrence, rotated sorted array, lower bound.
- Explain edge cases like duplicates and empty arrays.

**Enterprise Use:**

- Backend APIs often use binary search for filtering.
- Search logic in database query result handling.

---

### 8. Common Errors & Debugging

**Common Mistakes:**

- Using binary search on unsorted arrays.
- Off-by-one errors (e.g., mid = (low + high) / 2).

**Debug Tips:**

- Use logging to print `low`, `mid`, `high` at each step.
- Add edge case tests: empty array, target not found.

---

### 9. Java Version Updates

- `Arrays.binarySearch()` and `Collections.binarySearch()` exist since early Java versions (Java 1.2).
- No major updates, but now support `Comparator` in newer versions:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Collections.binarySearch(names, "Charlie", Comparator.naturalOrder());
```

---

### 10. Practice and Application

**Coding Practice:**

- LeetCode: Search Insert Position, First Bad Version.
- HackerRank: Binary Search Tree challenges.

**Real-world Application:**

- Use in pagination logic for sorted datasets.
- Efficient filtering in large-scale data microservices.

