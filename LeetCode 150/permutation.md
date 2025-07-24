**Java Topic: LeetCode 46 - Permutations**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given an array of distinct integers, return all possible permutations of the array.

• Why does it exist in Java?\
To demonstrate recursive tree traversal, backtracking, and the ability to track used state efficiently.

• What problem does it solve?\
Permutations are essential in scenarios involving reordering, pathfinding, optimization problems, and combinatorics.

🧠 Example: Input [1,2,3] → Output [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

---

✅ 2. Syntax and Structure

• Define `permute(int[] nums)` and return a `List<List<Integer>>`\
• Use a backtracking template or iterative method with queue or stacks.

🧠 Example: `List<List<Integer>> permute(int[] nums)` with helper method and used flags

---

✅ 3. Practical Examples

🔹 Approach 1: Backtracking with Boolean Visited Array

```java
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, path, result, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
```

🔹 Approach 2: Backtracking via Swapping In-place (O(n!))

```java
public class PermutationsInPlace {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) current.add(num);
            result.add(current);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

---

✅ 4. Internal Working

• Backtracking generates a tree of possible states by choosing unused elements.\
• In-place swapping avoids extra space for visited tracking.

Time Complexity: O(n!) for both approaches\
Space: O(n) auxiliary stack for recursion

---

✅ 5. Best Practices

✔ Use ArrayList to avoid fixed-size arrays\
✔ Avoid duplicate tracking with unnecessary structures\
✔ Reuse helper methods for swap/backtrack

---

✅ 6. Related Concepts

- Backtracking
- Recursion
- DFS Tree Traversal
- Permutations with/without duplicates

🧠 Example: Solving puzzles, Sudoku, travel route enumerations

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Very common permutation-style question\

- Tests candidate's understanding of recursion and state management

🏢 Real-world:

- Route or order arrangements\

- Load balancing options\

- Combinatorial test generation

---

✅ 8. Common Errors & Debugging

❌ Forgetting to backtrack (remove element after recursion)\
❌ Not marking used elements properly\
❌ Misplacing swap/restore logic in in-place method

🧪 Debug Tip:

- Print the path or array after each recursive call\

- Use breakpoints to track index and call depth

---

✅ 9. Java Version Updates

• Java 8+ streams can convert arrays to lists easily\
• Java 11+ introduces better memory management but no API change affecting logic here

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #46, #47 (permutations with duplicates)\

- HackerRank, GFG permutations series

🏗 Apply in:

- Game design sequences\

- Resource allocation\

- Experiment control permutations

