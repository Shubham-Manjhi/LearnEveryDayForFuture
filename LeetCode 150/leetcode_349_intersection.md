**LeetCode 349: Intersection of Two Arrays**

---

### 1. Problem Statement

Given two integer arrays `nums1` and `nums2`, return an array of their **unique** intersection elements. Each element in the result must be **distinct**. You may return the result in **any order**.

---

### 2. Why It’s Asked in Interviews

- Tests understanding of `Set` operations
- Focuses on deduplication and hash-based lookups
- Easy to extend into follow-ups like duplicates (LeetCode 350)

---

### 3. Optimal Approaches

#### ✅ **Approach 1: HashSet-Based (Best for Unsorted Arrays)**

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
```

- **Time:** O(n + m)
- **Space:** O(n) for hash set

---

#### ✅ **Approach 2: Two Pointers for Sorted Arrays**

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> resultSet = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) {
            result[idx++] = num;
        }
        return result;
    }
}
```

- **Time:** O(n log n + m log m)
- **Space:** O(k) for result set

---

### 4. ASCII Walkthrough Example

```
nums1 = [4, 9, 5]
nums2 = [9, 4, 9, 8, 4]

set1: {4, 9, 5}
nums2 iterates:
  9 -> match -> resultSet: {9}
  4 -> match -> resultSet: {9, 4}
  9 -> already in resultSet
  8 -> no match
  4 -> already in resultSet

Output: [9, 4] or [4, 9]
```

---

### 5. Edge Cases

- One array is empty → return empty
- No common elements → return empty
- Identical arrays → return unique elements

---

### 6. Interview Tips

- Clarify if duplicates should be removed
- Ask if arrays are already sorted (to use two-pointer approach)
- Focus on time vs space trade-offs

---

### 7. Practice More

- LeetCode 350: Intersection of Two Arrays II (with duplicates)
- LeetCode 1: Two Sum
- LeetCode 217: Contains Duplicate

---

✅ Summary:

- Use HashSet for clean and fast O(n + m) solution
- Use Two Pointers when arrays are sorted
- Always deduplicate results

---

