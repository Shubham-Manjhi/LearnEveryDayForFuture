**Java Topic: LeetCode 78 - Subsets**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given an integer array of distinct integers, return all possible subsets (the power set).

• Why does it exist in Java?\
It’s a foundational problem for understanding recursion, bitmasking, and subset generation.

• What problem does it solve?\
It’s useful in situations where you need to explore all combinations of input elements — such as feature selection, access rights, or combinations in games.

🧠 Example: Input: [1,2] → Output: [[],[1],[2],[1,2]]

---

✅ 2. Syntax and Structure

• Define `subsets(int[] nums)` that returns `List<List<Integer>>`\
• You can use backtracking or bitmasking.

🧠 Example: Backtracking to choose/exclude each element

---

✅ 3. Practical Examples

🔹 Approach 1: Backtracking (DFS-style)

```java
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
```

🖼️ ASCII Diagram – Backtracking Tree for Input [1, 2]:

```
Start at index 0:
          []
         /  \
       [1]  []
       / \     \
   [1,2] [1]   [2]
```
Explanation:
- At each level, decide to include or skip the current number.
- The tree explores all 2^n subsets by branching "include/exclude" decisions.

---

🔹 Approach 2: Bitmasking (Iterative)

```java
public class SubsetsBitmask {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int total = 1 << n; // 2^n subsets

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
```

🖼️ ASCII Diagram – Bitmasking for Input [1, 2]:

```
Binary    Mask Result
------------------------
00        => []
01        => [1]
10        => [2]
11        => [1,2]
```
Explanation:
- Use bits of each number from 0 to 2^n - 1 to decide inclusion.
- Bit 1 means "include nums[i]" in current subset.

---

✅ 4. Internal Working

• Backtracking explores a binary tree of decisions: include or exclude an element\
• Bitmasking loops over all 2^n combinations using binary representations

Time Complexity: O(2^n * n)

Space Complexity: O(2^n * n) for storing all subsets

---

✅ 5. Best Practices

✔ Always add a copy of the current subset (not reference)\
✔ Use recursion only when you understand call stack behavior\
✔ Bitmasking is more performant for larger `n`

---

✅ 6. Related Concepts

- Combinations
- Backtracking
- Powerset generation
- Bitmasking

🧠 Example: Subset sum problems, combinations of permissions/access rights

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Common question to test recursive thinking\
- Understanding exponential branching problems

🏢 Real-world:
- Feature flag combinations\
- Machine learning feature selection\
- Combination testing in QA

---

✅ 8. Common Errors & Debugging

❌ Modifying list without backtracking\
❌ Adding references instead of new objects\
❌ Not covering all mask values (off-by-one)

🧪 Debug Tip:
- Print current subset and mask for small inputs\
- Visualize decision tree recursion

---

✅ 9. Java Version Updates

• Java 8+ supports lambda expressions (could be used for mapping/streaming)\
• Enhanced List API features in Java 11+ but not required for core logic

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #78
- GFG/CodeStudio subsets and combinations problems

🏗 Apply in:
- Decision tree branching\
- Permissions modeling\
- A/B test variant generation

