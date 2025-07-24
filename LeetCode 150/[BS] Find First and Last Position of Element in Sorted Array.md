**Java Topic: LeetCode 34 - Find First and Last Position of Element in Sorted Array**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given a sorted array of integers and a target value, return the first and last positions (indices) of the target in the array. If the target is not found, return [-1, -1].

• Why does it exist in Java?\
This problem showcases the use of modified binary search for range queries.

• What problem does it solve?\
Quickly finds the range of a repeating value in sorted data using logarithmic time.

🧠 Example: Input: nums = [5,7,7,8,8,10], target = 8 → Output: [3, 4]

---

✅ 2. Syntax and Structure

• Define `int[] searchRange(int[] nums, int target)`\
• Use two separate binary searches: one for the first occurrence and one for the last

---

✅ 3. Practical Examples

🔹 Approach: Two Binary Searches

```java
public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findBound(nums, target, true);
        result[1] = findBound(nums, target, false);
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
```

🖼️ ASCII Diagram – Range Finding:

```
Index:       0 1 2 3 4 5
Array:       5 7 7 8 8 10
Target: 8
First:  ←————→   (mid adjusts left)
Last:         ←————→   (mid adjusts right)
```

---

✅ 4. Internal Working

• Modified binary search updates result on match and keeps narrowing left/right bounds.\
• First search finds left bound, second search finds right.

Time Complexity: O(log n)

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Reuse binary search logic with a flag\
✔ Return [-1, -1] when no match found\
✔ Avoid linear scans for large inputs

---

✅ 6. Related Concepts

- Binary Search Range Queries
- Searching in Sorted Arrays

🧠 Example: Log scan ranges, time-window queries

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Common follow-up to basic binary search
- Tests fine-grain control over binary logic

🏢 Real-world:

- Log file scan for timestamp range\


- Product inventory ID lookups\


- Keyword highlight positions

---

✅ 8. Common Errors & Debugging

❌ Not checking left/right direction correctly\
❌ Forgetting to update result when target is found\
❌ Off-by-one in loop boundaries

🧪 Debug Tip:

- Log left, mid, right and update decision per iteration

---

✅ 9. Java Version Updates

• No change in core logic\
• Java 8+ allows for easier range collection post-processing

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #34\


- Binary Search edge cases\


- Sorted Array range problems

🏗 Apply in:

- Time range matching\


- Video/audio segment detection\


- Range-based data extraction

