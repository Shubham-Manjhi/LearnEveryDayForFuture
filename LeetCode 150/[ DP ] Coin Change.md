# 📘 LeetCode 322: Coin Change

---

## ✅ 0. Question with Explanation

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

### Example:
```java
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1
```

---

## ✅ 1. Definition and Purpose

- **Concept**: Dynamic Programming (Unbounded Knapsack)
- **Why it exists**: To solve optimization problems where you minimize or maximize using overlapping subproblems
- **Problem it solves**: Finding the minimum number of coins to form a given amount

---

## ✅ 2. Syntax and Structure

```java
public int coinChange(int[] coins, int amount);
```

- Input: array of coin values and the total amount
- Output: minimum number of coins to make up the amount

---

## ✅ 3. Practical Examples

```java
Input: coins = [1, 2, 5], amount = 11
Output: 3

Input: coins = [1], amount = 0
Output: 0

Input: coins = [2], amount = 1
Output: -1
```

---

## ✅ 4. Internal Working

### ✅ Approach 1: Bottom-Up DP
- Time: O(amount * n), Space: O(amount)

```java
public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);  // Initialize to a large number
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (i - coin >= 0) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] == max ? -1 : dp[amount];
}
```

### ✅ Approach 2: Top-Down DP with Memoization
- Time: O(amount * n), Space: O(amount)

```java
public int coinChange(int[] coins, int amount) {
    Integer[] memo = new Integer[amount + 1];
    int res = dp(amount, coins, memo);
    return res == Integer.MAX_VALUE ? -1 : res;
}

private int dp(int rem, int[] coins, Integer[] memo) {
    if (rem < 0) return Integer.MAX_VALUE;
    if (rem == 0) return 0;
    if (memo[rem] != null) return memo[rem];

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
        int res = dp(rem - coin, coins, memo);
        if (res != Integer.MAX_VALUE) {
            min = Math.min(min, res + 1);
        }
    }
    memo[rem] = min;
    return min;
}
```

---

## ✅ 5. Best Practices

- Always initialize the DP array with a value greater than `amount`
- Bottom-up is generally more space-efficient and avoids stack overflow

---

## ✅ 6. Related Concepts

- Unbounded Knapsack Problem
- Minimum Cost Path Problems

---

## ✅ 7. Interview & Real-world Use

- Common in optimization scenarios
- Used in finance (coin denominations, change-making)

---

## ✅ 8. Common Errors & Debugging

- Forgetting to check `i - coin >= 0`
- Returning incorrect values when no solution is found

---

## ✅ 9. Java Version Updates

- Java 8+ allows for streams but not preferred here due to performance

---

## ✅ 10. Practice and Application

- LeetCode 322: Coin Change
- LeetCode 518: Coin Change II
- Knapsack patterns

---

