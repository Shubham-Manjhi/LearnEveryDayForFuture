**Java Topic: LeetCode 33 - Search in Rotated Sorted Array**

---

✅ 1. Definition and Purpose

• What is the concept?\
Given a rotated sorted array and a target, return the index of the target if found. Otherwise, return -1. The array is rotated at some unknown pivot.

• Why does it exist in Java?\
This problem is essential to demonstrate how binary search logic can be adapted to more complex array arrangements.

• What problem does it solve?\
Efficiently finds a target in rotated sorted arrays where the naive linear search takes O(n).

🧠 Example: Input: nums = [4,5,6,7,0,1,2], target = 0 → Output: 4

---

✅ 2. Syntax and Structure

• Define `int search(int[] nums, int target)`\
• Implement a modified binary search\
• Determine if left or right half is sorted at each step

---

✅ 3. Practical Examples

🔹 Approach 1: Modified Binary Search

```java
public class RotatedSearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // Left part is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
```

🖼️ ASCII Diagram – Rotation Logic:
```
Original:      [0, 1, 2, 4, 5, 6, 7]
Rotated at 3:  [4, 5, 6, 7, 0, 1, 2]
```

---

🔹 Approach 2: Find Pivot then Binary Search

```java
public class RotatedSearchWithPivot {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (pivot == 0 || target < nums[0]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
```

🖼️ ASCII Diagram – Pivot Based Strategy:
```
Find pivot where nums[mid] > nums[right]:
Left-sorted: nums[0] to nums[pivot-1]
Right-sorted: nums[pivot] to nums[n-1]
Search target in the correct half
```

---

✅ 4. Internal Working

• Modified binary search adjusts bounds based on sorted half\
• Pivot method separates search into two sorted segments

Time Complexity: O(log n) in both methods

Space Complexity: O(1)

---

✅ 5. Best Practices

✔ Handle edge cases like length 1\
✔ Avoid overflow in mid calculation\
✔ Avoid unnecessary comparisons by checking bounds first

---

✅ 6. Related Concepts

- Binary Search
- Rotated Array Analysis
- Divide and Conquer

🧠 Example: Search in circular arrays, optimized time window queries

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:
- Common question at top tech companies\
- Tests logical condition handling with binary search

🏢 Real-world:
- Circular log indexing\
- Real-time clocking systems\
- Snapshot version retrieval

---

✅ 8. Common Errors & Debugging

❌ Not detecting sorted half correctly\
❌ Infinite loops from wrong mid updates\
❌ Not handling no match (return -1)

🧪 Debug Tip:
- Print left, mid, right in each iteration\
- Add logs for branch taken: left-sorted or right-sorted

---

✅ 9. Java Version Updates

• Java 8+: Use streams for testing/debugging arrays\
• Core algorithm unchanged since Java 7

---

✅ 10. Practice and Application

📝 Practice on:
- LeetCode #33\
- GFG Rotated Array Problems\
- Binary Search variations

🏗 Apply in:
- Clock-based UI sliders\
- Log file rollovers\
- Snapshot record systems

