# 📘 LeetCode 2215: Find the Difference of Two Arrays

---

## ✅ 0. Question

Given two 0-indexed integer arrays `nums1` and `nums2`, return a list of two lists:

- The first list contains all the integers in `nums1` that are not in `nums2`.
- The second list contains all the integers in `nums2` that are not in `nums1`.

Each integer should appear in the result lists only once, and the lists may be returned in any order.

### Example:
Input:
```java
nums1 = [1,2,3]
nums2 = [2,4,6]
```
Output:
```java
[[1,3],[4,6]]
```

---

## ✅ 1. Definition and Purpose

This problem is focused on set operations: determining unique differences between two integer arrays.

### Purpose:
- Practice using Java Sets for fast membership checks.
- Enhance knowledge of array-to-collection transformations.
- Understand difference operation between collections.

---

## ✅ 2. Syntax and Structure

- Use HashSet to store elements of each array.
- Iterate one set and check for absence in the other.

```java
Set<Integer> set1 = new HashSet<>(Arrays.asList(...));
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Using HashSet

```java
public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>(); // Step 1: store nums1
    Set<Integer> set2 = new HashSet<>(); // Step 2: store nums2

    for (int n : nums1) set1.add(n); // Step 3
    for (int n : nums2) set2.add(n); // Step 4

    List<Integer> list1 = new ArrayList<>(); // nums1 - nums2
    List<Integer> list2 = new ArrayList<>(); // nums2 - nums1

    for (int n : set1) {
        if (!set2.contains(n)) list1.add(n); // Step 5: find unique in nums1
    }

    for (int n : set2) {
        if (!set1.contains(n)) list2.add(n); // Step 6: find unique in nums2
    }

    return Arrays.asList(list1, list2); // Step 7: return results
}
```

### Example Execution:
```
nums1 = [1,2,3]
nums2 = [2,4,6]

set1 = {1,2,3}
set2 = {2,4,6}

set1 - set2 => [1,3]
set2 - set1 => [4,6]
```

---

### 🔹 Approach 2: Java Streams (Java 8+)

```java
public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

    List<Integer> diff1 = set1.stream().filter(n -> !set2.contains(n)).collect(Collectors.toList());
    List<Integer> diff2 = set2.stream().filter(n -> !set1.contains(n)).collect(Collectors.toList());

    return Arrays.asList(diff1, diff2);
}
```

---

## ✅ 4. Internal Working

- Sets provide O(1) average-time complexity for contains() lookup.
- Each element is checked once.
- Time Complexity: O(N + M), where N and M are lengths of nums1 and nums2.

---

## ✅ 5. Best Practices

- Use `Set` for fast membership tests.
- Always convert arrays to Sets for this type of operation.
- Avoid nested loops which result in O(N^2) time.

---

## ✅ 6. Related Concepts

- HashSet
- Stream API in Java
- Array-to-Collection conversion

---

## ✅ 7. Interview & Real-world Use

- Common question in interviews to test set operations.
- Used in applications requiring syncing or comparing configurations.

---

## ✅ 8. Common Errors & Debugging

- Not removing duplicates before comparison.
- Using nested loops instead of sets.

---

## ✅ 9. Java Version Updates

- Java 8 Stream API allows more concise functional code.
- `Collectors.toSet()` makes conversion from array easy.

---

## ✅ 10. Practice and Application

- Similar to problems like `Intersection of Two Arrays`, `Union`, `Symmetric Difference`
- LeetCode: 349, 350, 2215, 160

✅ Arrays-to-Sets approach is powerful for element-wise comparison in optimal time.

