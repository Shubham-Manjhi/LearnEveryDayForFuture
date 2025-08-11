# 📘 LeetCode 278: First Bad Version

---

## ✅ 0. Question

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API:
```java
boolean isBadVersion(int version);
```
which returns whether version is bad.

Implement a function to find the first bad version. You should minimize the number of calls to the API.

---

## ✅ 1. Definition and Purpose

The problem demonstrates the binary search application to minimize API calls. This is crucial for performance and reducing overhead when working with expensive queries like external API calls.

---

## ✅ 2. Syntax and Structure

We use binary search, narrowing the range until the first bad version is found.

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Binary Search (Optimized)
```java
// API is assumed to be defined
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2; // prevent overflow
            if (isBadVersion(mid)) {
                high = mid; // Move to left half
            } else {
                low = mid + 1; // Move to right half
            }
        }
        return low; // or high
    }
}
```

### 🔹 Approach 2: Linear Scan (Brute Force)
```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return -1; // This shouldn't happen if at least one version is bad
    }
}
```

---

## 📘 ASCII Visualization
```
Versions: 1 2 3 4 5 6 7 8 9
States:   G G G G B B B B B   (G=Good, B=Bad)
                      ^
Binary search narrows here.
```

---

## ✅ 4. Internal Working

Binary search checks the midpoint version to determine whether to go left (toward earlier versions) or right (toward later versions). The key is to shrink the interval efficiently.

---

## ✅ 5. Best Practices
- Use mid = low + (high - low) / 2 to avoid integer overflow
- Binary search ensures O(log n) performance
- Avoid unnecessary API calls

---

## ✅ 6. Related Concepts
- Binary Search
- External API call optimization
- Searching in monotonic arrays

---

## ✅ 7. Interview & Real-world Use
- Asked frequently at Facebook, Amazon
- Real-world: Identify earliest point of failure in logs, tests, or production builds

---

## ✅ 8. Common Errors & Debugging
- Forgetting to update high/low correctly
- Infinite loops if mid computation or loop condition is wrong
- Using mid = (low + high) may cause overflow

---

## ✅ 9. Java Version Updates
- Java doesn’t provide default mid computation; must manually avoid overflow
- Consider using Streams in more advanced versions for logging

---

## ✅ 10. Practice and Application
- Similar Problems: LeetCode 34, 35
- Practice on HackerRank, GFG

---

## 📊 Time and Space Complexity
| Approach | Time Complexity | Space Complexity |
|----------|------------------|------------------|
| Binary Search | O(log n)          | O(1)              |
| Linear Scan   | O(n)              | O(1)              |

