# 📘 LeetCode 123: Best Time to Buy and Sell Stock III

---

## ✅ 0. Question with Explanation

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

Find the maximum profit you can achieve. You may complete at most two transactions.

**Note**: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

### Example:

```java
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation:
Buy on day 4 (price = 0) and sell on day 5 (price = 3), profit = 3.
Then buy on day 6 (price = 1) and sell on day 7 (price = 4), profit = 3.
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming & State Machine
- **Why it exists**: To maximize profit under a constraint of limited transactions.
- **Problem it solves**: Helps in decision-making for financial planning and stock investment algorithms.

---

## ✅ 2. Syntax and Structure

```java
public int maxProfit(int[] prices);
```

- Input: An integer array of prices
- Output: The maximum profit achievable with at most two transactions

---

## ✅ 3. Practical Examples

```java
Input: [1,2,3,4,5]
Output: 4
Explanation:
Buy on day 0 and sell on day 4, profit = 4.
Only one transaction needed.
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Two-pass DP (Split the array)

- Time: O(n)
- Space: O(n)

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    int[] left = new int[n];
    int[] right = new int[n];

    // Forward pass - max profit up to day i
    int minPrice = prices[0];
    for (int i = 1; i < n; i++) {
        minPrice = Math.min(minPrice, prices[i]);
        left[i] = Math.max(left[i - 1], prices[i] - minPrice);
    }

    // Backward pass - max profit from day i
    int maxPrice = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        maxPrice = Math.max(maxPrice, prices[i]);
        right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
    }

    // Combine two parts
    int maxProfit = 0;
    for (int i = 0; i < n; i++) {
        maxProfit = Math.max(maxProfit, left[i] + right[i]);
    }

    return maxProfit;
}
```

### ✅ Approach 2: Optimized 4 Variable State Tracking

- Time: O(n)
- Space: O(1)

```java
public int maxProfit(int[] prices) {
    int buy1 = Integer.MAX_VALUE;
    int sell1 = 0;
    int buy2 = Integer.MAX_VALUE;
    int sell2 = 0;

    for (int price : prices) {
        buy1 = Math.min(buy1, price);
        sell1 = Math.max(sell1, price - buy1);
        buy2 = Math.min(buy2, price - sell1);
        sell2 = Math.max(sell2, price - buy2);
    }

    return sell2;
}
```

---

## ✅ 5. Best Practices

- Always track state carefully in state machine problems.
- Be cautious with integer overflows and edge cases (e.g., empty array).
- Use variables when space optimization is key.

---

## ✅ 6. Related Concepts

- Dynamic Programming
- Kadane's Algorithm (for max subarray profit)
- State Machines

---

## ✅ 7. Interview & Real-world Use

- Common interview question to evaluate dynamic programming optimization
- Used in algorithmic trading, financial planning tools

---

## ✅ 8. Common Errors & Debugging

- Misunderstanding the difference between transactions and operations
- Forgetting that two transactions can't overlap

---

## ✅ 9. Java Version Updates

- No direct changes relevant to this algorithm in Java updates.

---

## ✅ 10. Practice and Application

- LeetCode 123 (2 transactions)
- LeetCode 188 (k transactions)
- LeetCode 122 (infinite transactions)

---

