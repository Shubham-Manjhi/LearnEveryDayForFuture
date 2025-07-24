**LeetCode 202: Happy Number**

---

### 1. Problem Statement

Write an algorithm to determine if a number `n` is a happy number.

A **happy number** is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1.

If it ends in 1, the number is happy.

**Function Signature:**

```java
boolean isHappy(int n)
```

---

### 2. Understanding the Problem

- The process continues until either:
  - The result is 1 (happy), or
  - A cycle is detected (not happy)

---

### 3. Optimal Approach (Floyd's Cycle Detection)

**Idea:** Use slow/fast pointer to detect cycles, similar to linked list cycle detection.

```java
public boolean isHappy(int n) {
    int slow = n;
    int fast = getNext(n);

    while (fast != 1 && slow != fast) {
        slow = getNext(slow);
        fast = getNext(getNext(fast));
    }

    return fast == 1;
}

private int getNext(int n) {
    int sum = 0;
    while (n > 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
    }
    return sum;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(log n) per iteration (based on number of digits), and usually converges quickly
- **Space Complexity:** O(1) using Floyd’s algorithm

---

### 5. Edge Cases to Consider

- Input = 1 → true
- Input = 0 → false (loop)
- Numbers with repeating digits like 19, 7 (known happy numbers)

---

### 6. Example

```java
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
```

---

### 7. Best Practices

- Use helper method for digit square sum
- Avoid using `HashSet` if optimizing for space

---

### 8. Related Topics

- Math
- Hashing
- Cycle Detection

---

### 9. Interview Tip

> Be ready to explain both Floyd's algorithm and a HashSet-based approach. HashSet is more intuitive, but Floyd’s is more space-efficient.

Alternative using HashSet:

```java
public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (n != 1 && !seen.contains(n)) {
        seen.add(n);
        n = getNext(n);
    }
    return n == 1;
}
```

---

### 10. Follow-up

> Can you optimize the runtime or reduce memory usage for larger inputs? Try using mathematical bounds or caching results.

