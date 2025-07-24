**LeetCode 128: Longest Consecutive Sequence**

---

### 1. Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

**Function Signature:**

```java
int longestConsecutive(int[] nums)
```

---

### 2. Understanding the Problem

- The numbers must be consecutive **integers**, not adjacent in array.
- Order in the array does **not** matter.
- The result is the **length** of the longest streak, not the sequence itself.

---

### 3. Optimal Approach (HashSet)

**Idea:** Use a `HashSet` to achieve O(1) lookups. Start counting only from the beginning of a possible sequence.

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
        numSet.add(num);
    }

    int longestStreak = 0;

    for (int num : numSet) {
        if (!numSet.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }

    return longestStreak;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

---

### 5. Edge Cases to Consider

- Empty array → return 0
- Array with all duplicates → return 1
- Negative numbers, unsorted data

---

### 6. Example

```java
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest sequence is [1, 2, 3, 4]
```

---

### 7. Best Practices

- Avoid sorting to stay within O(n) constraint
- Use `HashSet` for O(1) lookups
- Only start streak when `num - 1` is not in the set

---

### 8. Related Topics

- Hashing
- Arrays
- Set
- Sequence Detection

---

### 9. Interview Tip

> Clarify whether the input is sorted, and stress that your solution avoids sorting. Highlight that you only begin streaks from potential sequence starts (`num - 1` not in set).

---

### 10. Follow-up

> Can you reconstruct the actual longest sequence? (Store streak elements and print them in a second pass.)

