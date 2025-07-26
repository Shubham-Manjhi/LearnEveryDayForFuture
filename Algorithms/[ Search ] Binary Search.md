# 📘 Binary Search in Java

---

## ✅ 1. Definition and Purpose

- **Binary Search** is a divide-and-conquer algorithm that efficiently finds the position of a target element in a sorted array.
- **Purpose**: Significantly reduces time complexity compared to linear search (O(log n) vs O(n)).
- **Why Java uses it**: Foundational in APIs like `Collections.binarySearch()` or `Arrays.binarySearch()`.

---

## ✅ 2. Syntax and Structure

### Iterative Binary Search:

```java
public int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1; // not found
}
```

### Recursive Binary Search:

```java
public int binarySearchRecursive(int[] arr, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] > target)
        return binarySearchRecursive(arr, target, low, mid - 1);
    else
        return binarySearchRecursive(arr, target, mid + 1, high);
}
```

---

## ✅ 3. Practical Examples

```java
int[] nums = {1, 3, 5, 7, 9, 11};
int target = 7;
System.out.println(binarySearch(nums, target)); // Output: 3
```

```java
System.out.println(Arrays.binarySearch(nums, 11)); // Output: 5
```

---

## ✅ 4. Internal Working

- **Divide-and-conquer**: Each step reduces search space by half.
- Works only on **sorted data**.
- Avoids integer overflow: `mid = low + (high - low) / 2`.

---

## ✅ 5. Best Practices

- Always ensure array is sorted before applying binary search.
- Use built-in methods like `Arrays.binarySearch()` when possible.
- Consider edge cases: duplicates, negative numbers, empty array.

---

## ✅ 6. Related Concepts

- Ternary Search (splits array into 3 parts)
- Interpolation Search (better on uniformly distributed values)
- Lower Bound / Upper Bound using Binary Search

---

## ✅ 7. Interview & Real-world Use

- Foundational for algorithm-based interviews.
- Used in Java libraries: Arrays.binarySearch(), TreeMap.floorKey(), etc.
- Employed in performance-critical systems and search engines.

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors (e.g., `<=` vs `<`)
- Not checking if array is sorted
- Wrong mid-calculation causing overflow

---

## ✅ 9. Java Version Updates

- Java 5+: Generics in `Collections.binarySearch(List<T> list, T key)`
- Java 8+: Stream APIs with binary search combined (but no native stream binary search)

---

## ✅ 10. Practice and Application

- LeetCode: 704, 34, 35, 852, 162
- Used in Range Search, Peak Element, Search Rotated Array

---

## ✅ 11. ASCII Diagram

Example:

```
Array: [1, 3, 5, 7, 9, 11], target: 7

Step 1:
low = 0, high = 5, mid = 2 -> arr[2]=5 < 7, move low to mid+1

Step 2:
low = 3, high = 5, mid = 4 -> arr[4]=9 > 7, move high to mid-1

Step 3:
low = 3, high = 3, mid = 3 -> arr[3]=7 == target, return 3
```

---

✅ You’ve now mastered Binary Search in Java with code, internal logic, and examples.

