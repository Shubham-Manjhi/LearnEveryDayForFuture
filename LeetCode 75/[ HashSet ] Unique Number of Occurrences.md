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

## ✅ 3. Practical Example

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

---

# 📘 LeetCode: Unique Number of Occurrences

## ✅ 0. Question

Given an array of integers `arr`, return `true` if the number of occurrences of each value in the array is unique or `false` otherwise.

### Example:

Input:

```java
arr = [1,2,2,1,1,3]
```

Output:

```java
true
```

Explanation:

```text
1 occurs 3 times, 2 occurs 2 times, 3 occurs once → all counts are unique
```

---

## ✅ 1. Definition and Purpose

We are checking the **frequency of each number** and verifying whether each frequency count is unique.

### Purpose:

- Learn how to use maps and sets for counting and uniqueness checks
- Practice frequency hash map + uniqueness with set

---

## ✅ 2. Syntax and Structure

```java
Map<Integer, Integer> freq = new HashMap<>();
Set<Integer> seen = new HashSet<>();
```

---

## ✅ 3. Practical Example

### 🔹 Approach 1: Frequency Map + Uniqueness Set

```java
public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1); // Count frequency
    }

    Set<Integer> seen = new HashSet<>();
    for (int count : freq.values()) {
        if (!seen.add(count)) return false; // Duplicate frequency
    }
    return true;
}
```

### Example Execution:

```
arr = [1,2,2,1,1,3]

Frequency Map: {1=3, 2=2, 3=1}
Seen Frequencies: [3,2,1] ✅ all unique
```

---

### 🔹 Approach 2: Sorting Based (Less Efficient)

```java
public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : arr) freq.put(n, freq.getOrDefault(n, 0) + 1);

    List<Integer> occurrences = new ArrayList<>(freq.values());
    Collections.sort(occurrences);

    for (int i = 1; i < occurrences.size(); i++) {
        if (occurrences.get(i).equals(occurrences.get(i-1))) return false;
    }
    return true;
}
```

---

## ✅ 4. Internal Working

- HashMap stores value frequency
- HashSet checks if frequency is already used
- Time: O(N) space: O(N)

---

## ✅ 5. Best Practices

- Use HashMap for frequency counting
- HashSet to quickly test uniqueness

---

## ✅ 6. Related Concepts

- Frequency counting
- Map and Set
- Array and Collection conversion

---

## ✅ 7. Interview & Real-world Use

- Commonly asked to test understanding of Maps, Sets
- Used in telemetry, analytics, data validation

---

## ✅ 8. Common Errors & Debugging

- Using nested loops unnecessarily
- Not checking for uniqueness correctly

---

## ✅ 9. Java Version Updates

- Java 8 Streams can also be used to solve this

---

## ✅ 10. Practice and Application

- LeetCode 1207: Unique Number of Occurrences
- Practice on arrays, sets, maps

