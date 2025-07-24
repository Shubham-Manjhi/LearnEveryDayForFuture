**LeetCode 27: Remove Element**

---

### 1. Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place and return the new length of the array.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

**Function Signature:**

```java
int removeElement(int[] nums, int val)
```

---

### 2. Understanding the Problem

- Modify the array in-place.
- The function returns the count of elements not equal to `val`.
- You can overwrite any elements beyond the new length.

---

### 3. Naive Approach (O(n) time, O(n) space)

```java
public int removeElement(int[] nums, int val) {
    int[] temp = new int[nums.length];
    int k = 0;
    for (int num : nums) {
        if (num != val) {
            temp[k++] = num;
        }
    }
    for (int i = 0; i < k; i++) {
        nums[i] = temp[i];
    }
    return k;
}
```

**Drawback:** Uses extra space.

---

### 4. Optimal Approach (Two Pointers, In-place)

```java
public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[k++] = nums[i];
        }
    }
    return k;
}
```

**Alternative Approach (for unordered result):**

```java
public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1];
            n--;
        } else {
            i++;
        }
    }
    return n;
}
```

---

### 5. Complexity Analysis

- **Time:** O(n)
- **Space:** O(1)
- **Stable:** First approach is stable (preserves order), second is not

---

### 6. Edge Cases to Consider

- Empty array
- All elements equal to `val`
- No occurrence of `val`
- Single element array

---

### 7. Example

```java
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,...]

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,...]
```

---

### 8. Best Practices

- Favor the two-pointer method for in-place modification.
- Do not worry about elements beyond returned length.

---

### 9. Related Topics

- Arrays
- Two Pointers
- In-place Algorithms

---

### 10. Interview Tip

> Emphasize **in-place modification** and **space efficiency**. Clearly explain how you're managing indices and overwriting elements during traversal.

