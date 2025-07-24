**LeetCode 350: Intersection of Two Arrays II**

---

### 1. Problem Statement

Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result should appear as many times as it shows in both arrays. You may return the result in any order.

---

### 2. Why It’s Asked in Interviews

- Tests understanding of hash-based frequency counting
- Highlights memory vs time trade-offs
- Variants relate to multiset and hashmap skills

---

### 3. Optimal Approaches

#### ✅ **Approach 1: HashMap Frequency Count (Best for Unsorted Arrays)**

- Build a frequency map from the smaller array.
- Iterate over the larger array to collect matches.

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
```

- **Time:** O(n + m)
- **Space:** O(min(n, m))

---

#### ✅ **Approach 2: Two Pointers (Best for Sorted Arrays)**

- Sort both arrays (if not already sorted).
- Use two pointers to iterate.

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
```

- **Time:** O(n log n + m log m) (due to sorting)
- **Space:** O(1) if sorting in-place

---

### 4. ASCII Flow (Example)

```
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]

HashMap -> freq = {1:2, 2:2}

Iterate nums2:
2 → result: [2]
2 → result: [2, 2]
```

For Sorted Two Pointer:

```
nums1 = [1,1,2,2]
nums2 = [2,2]
         i     j
 → result: [2, 2]
```

---

### 5. Edge Cases

- One array is empty → return empty
- No common elements → return empty
- Large duplicate counts

---

### 6. Interview Tips

- Ask if arrays are sorted
- Ask about memory limits
- Clarify whether duplicates must be preserved

---

### 7. Practice More

- LeetCode 349: Intersection of Two Arrays (no duplicates)
- LeetCode 1: Two Sum
- LeetCode 1002: Find Common Characters

---

✅ Summary:

- Use HashMap for unsorted arrays (optimal O(n + m))
- Use Two Pointers if arrays are sorted
- Brute-force is discouraged due to O(n\*m) time

---

