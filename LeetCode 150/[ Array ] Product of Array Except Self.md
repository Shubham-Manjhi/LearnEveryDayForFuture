# 📘 LeetCode 238: Product of Array Except Self

---

## ✅ 0. Question

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The solution must be done without using division and in O(n) time.

### Example:
```text
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

---

## ✅ 1. Definition and Purpose

- Computes product of array elements excluding self.
- Key challenge: No division, and must run in linear time.
- Useful in statistical and mathematical modeling, data pre-processing.

---

## ✅ 2. Syntax and Structure

```java
public int[] productExceptSelf(int[] nums);
```

- Input: array of integers
- Output: array where each index holds product of all other elements

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Prefix and Suffix Product (O(n) time, O(n) space)
```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] answer = new int[n];

    // Step 1: Compute prefix product
    left[0] = 1;
    for (int i = 1; i < n; i++) {
        left[i] = left[i - 1] * nums[i - 1];
    }

    // Step 2: Compute suffix product
    right[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        right[i] = right[i + 1] * nums[i + 1];
    }

    // Step 3: Multiply left and right products
    for (int i = 0; i < n; i++) {
        answer[i] = left[i] * right[i];
    }
    return answer;
}
```

### 🔹 Approach 2: Optimized Space (O(n) time, O(1) extra space)
```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    // Step 1: Fill answer with prefix product
    answer[0] = 1;
    for (int i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }

    // Step 2: Multiply suffix product directly
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
        answer[i] *= suffix;
        suffix *= nums[i];
    }
    return answer;
}
```

---

## ✅ Example Execution
```text
nums = [1,2,3,4]
Left:   [1, 1, 2, 6]
Right:  [24,12,4,1]
Output: [24,12,8,6]
```

---

## ✅ 4. Internal Working

- Build prefix product left[i] = product of all before i
- Build suffix product right[i] = product of all after i
- Combine both for each index
- Optimized approach stores left in result, suffix in single variable

---

## ✅ 5. Best Practices

- Avoid extra arrays if possible
- Prevent integer overflow by using long if needed
- Ensure zero handling if question allows it

---

## ✅ 6. Related Concepts

- Prefix sum/product
- Dynamic programming
- In-place updates

---

## ✅ 7. Interview & Real-world Use

- Asked often in FAANG interviews for testing optimization
- Useful in analytics pipelines for normalizing metrics

---

## ✅ 8. Common Errors & Debugging

- Off-by-one errors in prefix/suffix loops
- Forgetting to initialize prefix/suffix correctly
- Misplacing multiplication orders

---

## ✅ 9. Java Version Updates

- Java 8+ handles large streams and functional style, but array processing remains fastest for this problem

---

## ✅ 10. Practice and Application

- LeetCode 66: Plus One
- LeetCode 53: Maximum Subarray
- LeetCode 560: Subarray Sum Equals K

---

🚀 Mastering this problem sharpens your prefix-suffix manipulation and space optimization skills!

