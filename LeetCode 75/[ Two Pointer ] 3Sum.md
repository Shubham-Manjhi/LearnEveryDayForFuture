# 📘 LeetCode 15: 3Sum

---

## ✅ 0. Question

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that:

- i != j, i != k, and j != k
- nums[i] + nums[j] + nums[k] == 0

Notice that the solution set must not contain duplicate triplets.

### Example:
```text
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

---

## ✅ 1. Definition and Purpose

- The 3Sum problem is a classic variation of the Two Sum problem.
- Helps practice array traversal, sorting, and two-pointer strategies.
- Optimizing performance while avoiding duplicates is key.

---

## ✅ 2. Syntax and Structure

```java
public List<List<Integer>> threeSum(int[] nums);
```

- Input: Array of integers
- Output: List of unique triplets summing to zero

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Brute Force (O(n³)) – For Reference Only
```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    int[] temp = new int[]{nums[i], nums[j], nums[k]};
                    Arrays.sort(temp);
                    String key = temp[0] + "," + temp[1] + "," + temp[2];
                    if (!seen.contains(key)) {
                        result.add(Arrays.asList(temp[0], temp[1], temp[2]));
                        seen.add(key);
                    }
                }
            }
        }
    }
    return result;
}
```

### 🔹 Approach 2: Optimized Using Two Pointers (O(n²))
```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Step 1: Sort array to handle duplicates and enable two-pointer
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue; // Step 2: Skip duplicates

        int left = i + 1, right = n - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // Step 3: Skip duplicates
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;

                left++;
                right--;
            } else if (sum < 0) {
                left++; // Step 4: Increase left if sum too small
            } else {
                right--; // Step 5: Decrease right if sum too large
            }
        }
    }

    return result;
}
```

### Example Walkthrough:
```text
Input: [-1, 0, 1, 2, -1, -4]
Sorted: [-4, -1, -1, 0, 1, 2]

i=0: -4 + (-1) + 5 > skip
...
i=1: nums[i]=-1, left=2, right=5
Check: -1 + (-1) + 2 = 0 => Add [-1, -1, 2]
```

---

## ✅ 4. Internal Working

- Sorting helps efficiently skip duplicates
- Two-pointer avoids checking every pair
- Result stored in List of Lists while ensuring uniqueness

---

## ✅ 5. Best Practices

- Always sort and skip duplicates for efficiency
- Handle edge cases (length < 3)
- Don't use Set<List<Integer>> directly due to ordering issue

---

## ✅ 6. Related Concepts

- Two Sum
- Sorting
- Two-pointer sliding window

---

## ✅ 7. Interview & Real-world Use

- Common problem to test reasoning and optimization
- Appears in FAANG interviews and algorithmic contests

---

## ✅ 8. Common Errors & Debugging

- Forgetting to sort
- Not skipping duplicate triplets
- Using reference equality for List comparison

---

## ✅ 9. Java Version Updates

- Enhanced Collections and Stream APIs can simplify code, though less performant

---

## ✅ 10. Practice and Application

- LeetCode 1: Two Sum
- LeetCode 18: 4Sum
- LeetCode 16: 3Sum Closest

---

🚀 Mastering 3Sum strengthens your fundamentals in sorting, two-pointer logic, and duplicate handling!

