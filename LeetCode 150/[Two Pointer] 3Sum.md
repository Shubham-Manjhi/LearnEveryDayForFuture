# 👉 LeetCode 15: 3Sum

---

## ✅ 0. Question: 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that:

- i != j, i != k, and j != k
- nums[i] + nums[j] + nums[k] == 0

Notice that the solution set must not contain duplicate triplets.

### Example:
```java
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

---

## ✅ 1. Definition and Purpose

- This problem explores finding combinations of three elements in an array that add up to zero.
- It's a foundational problem in learning about two-pointer technique, array sorting, and duplicate handling.

### Why it exists in Java:
- Java's collections and arrays offer low-level iteration performance that makes this type of problem very educational for learning algorithms and data manipulation.

---

## ✅ 2. Syntax and Structure

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Important for two-pointer
    ... // logic
    return result;
}
```

---

## ✅ 3. Approach 1: Brute Force (Time Complexity: O(n^3))

### Idea:
- Try every triplet (i, j, k)
- Check if nums[i] + nums[j] + nums[k] == 0
- Store results if not already present

### Code:
```java
public List<List<Integer>> threeSumBrute(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(triplet);
                    set.add(triplet);
                }
            }
        }
    }
    return new ArrayList<>(set);
}
```

---

## ✅ 4. Approach 2: Optimized Two-Pointer (Time Complexity: O(n^2))

### Steps:
1. Sort the array
2. For each index `i`:
   - Skip duplicate `nums[i]`
   - Use two pointers: `left` = i+1, `right` = end
   - Check `nums[i] + nums[left] + nums[right]` and move pointers accordingly

### Code:
```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate

        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    return res;
}
```

---

## ✅ 5. Internal Working

- Sorting allows use of the two-pointer method.
- Set or duplicate checks prevent repeated triplets.
- Avoids nested loop overhead using controlled pointer movement.

---

## ✅ 6. Best Practices

- Always sort before using two-pointer.
- Use `Set` only when unable to control duplicates otherwise.
- For LeetCode, avoid `Set` as it increases space complexity.

---

## ✅ 7. Related Concepts

- Two Pointers
- Sorting
- Subset Generation
- Duplicate Elimination

---

## ✅ 8. Interview & Real-world Use

- Common in product-based interviews (Amazon, Google)
- Used in data analysis pipelines, fraud detection, pattern finding

---

## ✅ 9. Common Errors & Debugging

- Forgetting to skip duplicates
- Using incorrect pointer increments
- Overflow issues if using very large integers (handle via long if needed)

---

## ✅ 10. Java Version Updates

- Java 8+: Streams may be used but are not performant for nested loop logic
- Java 11+: Still most efficient using simple for-loops and List API

---

## ✅ 11. Practice and Application

- LeetCode #15
- Cracking the Coding Interview: Chapter on Arrays
- HackerRank Combination Practice

---

## ✅ 12. Diagram: Pointer Movement Example

Initial Array: `[-4, -1, -1, 0, 1, 2]`
```
i = 0
left = 1
right = 5
Check: -4 + (-1) + 2 = -3 < 0 → move left to 2
```

```
i = 1
left = 2
right = 5
Check: -1 + (-1) + 2 = 0 ✔
Add [-1, -1, 2] to result
Skip duplicates
```

---

Feel free to generate a PDF or request a visual chart next!

