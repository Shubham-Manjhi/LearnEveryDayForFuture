**Java Problem: Array Rotation (LeetCode Style)**

---

✅ 0. Question & Explanation

Write a function that rotates an array A of N integers to the right K times. Each rotation shifts all elements of A one step to the right, and the last element moves to the front.

🧠 Examples:

- A = [3, 8, 9, 7, 6], K = 3 → Output: [9, 7, 6, 3, 8]
- A = [0, 0, 0], K = 1 → Output: [0, 0, 0]
- A = [1, 2, 3, 4], K = 4 → Output: [1, 2, 3, 4]

Constraints:

- 0 ≤ N, K ≤ 100
- Elements of A in [−1000..1000]

---

✅ 1. Definition and Purpose

• What is the concept?\
Array rotation: shifting the positions of elements to the right.

• Why does it exist in Java?\
Used for simulations, time-based data rotation, cyclic scheduling, etc.

• What problem does it solve?\
Helps manage circular data structures, memory-efficient scrolling data, etc.

---

✅ 2. Syntax and Structure

Function signature:

```java
public int[] solution(int[] A, int K)
```

Core concepts:

- Handle empty arrays or zero rotations
- Use modulo to prevent unnecessary full rotations
- Rotate with or without extra space

---

✅ 3. Practical Examples

🔹 Approach 1: Extra Array (Simple & Clear)

```java
public class Solution {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0 || K % N == 0) return A; // Step 1: handle edge case

        K = K % N; // Step 2: reduce extra rotations
        int[] rotated = new int[N]; // Step 3: create new array

        for (int i = 0; i < N; i++) {
            int newIndex = (i + K) % N; // Step 4: calculate new index
            rotated[newIndex] = A[i]; // Step 5: copy to new position
        }

        return rotated; // Step 6: return result
    }
}
```

⏱ Time Complexity: O(N),  💾 Space Complexity: O(N)

---

🔹 Approach 2: In-place Rotation (Optimized Space)

```java
public class Solution {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0 || K % N == 0) return A; // Step 1: edge check

        K %= N; // Step 2: reduce K

        // Step 3: Reverse whole array
        reverse(A, 0, N - 1);
        // Step 4: Reverse first K elements
        reverse(A, 0, K - 1);
        // Step 5: Reverse remaining elements
        reverse(A, K, N - 1);

        return A; // Step 6: return in-place rotated array
    }

    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
```

⏱ Time Complexity: O(N),  💾 Space Complexity: O(1)

📌 Example: A = [3, 8, 9, 7, 6], K = 3 → Output: [9, 7, 6, 3, 8]

---

✅ 4. Internal Working

• Extra array uses index mapping with modulo\
• Optimized uses three-step reverse trick to rotate in place

---

✅ 5. Best Practices

✔ Always normalize K using modulo\
✔ Use extra space if clarity is more important than memory\
✔ Reverse-based in-place rotation is optimal for space

---

✅ 6. Related Concepts

- Modulo arithmetic
- Circular queues
- In-place array manipulation

🧠 Related: Rotate Image, Reverse Array

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Array manipulation
- Understanding indexing
- Time-efficient and space-efficient solutions

🏢 Real-world:

- Round-robin scheduling\

- Ring buffers\

- Circular shifting in memory operations

---

✅ 8. Common Errors & Debugging

❌ Forgetting to normalize K\
❌ In-place swaps without bounds check\
❌ Using array[i + K] without % N

🧪 Debug Tip: Print mappings or array snapshots after each step in reverse-based method

---

✅ 9. Java Version Updates

• Java 8+ streams could be used for concise expressions\
• But in-place methods and for-loops remain faster and more readable

---

✅ 10. Practice and Application

📝 Practice on:

- Codility Cyclic Rotation
- LeetCode: Rotate Array

🏗 Apply in:

- Game development (circular buffer)
- Time-based event modeling

---

