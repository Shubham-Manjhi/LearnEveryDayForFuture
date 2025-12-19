## 💫 LeetCode 670 — Maximum Swap

---

### 🎯 Problem Statement

You are given an integer `num`. You can **swap two digits at most once** to get the maximum possible value. Return the maximum value you can get.

**Example:**
```
Input: num = 2736
Output: 7236
Explanation: Swap 2 and 7.
```

---

### 💡 Intuition

We want to find two digits in the number such that swapping them yields the **largest possible number**.

Key idea:
- To maximize the number, we should bring the **largest possible digit** to the **leftmost smaller position**.
- This means we find the **first place from left** where a **smaller digit** exists and a **larger digit appears later**.

---

### 🧩 Pseudocode

```
FUNCTION maximumSwap(num):
    digits = convert num to char array
    last = array of size 10  // stores last index of each digit (0–9)

    FOR i = 0 to len(digits)-1:
        last[digits[i] - '0'] = i

    FOR i = 0 to len(digits)-1:
        current = digits[i] - '0'
        FOR d = 9 down to current+1:
            IF last[d] > i:
                SWAP digits[i] and digits[last[d]]
                RETURN convert digits to integer

    RETURN num
```

---

### 🔁 Flowchart of Pseudocode

```
 ┌────────────────────────┐
 │       Start            │
 └──────────┬─────────────┘
            │
    Convert num → digits[]
            │
    Record last index of each digit
            │
   ┌────────▼────────┐
   │  Traverse digits│
   └────────┬────────┘
            │
   For each i, check if a larger digit exists later
            │
     ┌──────▼───────┐
     │ Found larger │──Yes──▶ Swap & return result
     └──────┬───────┘
            │No
            ▼
     Continue loop
            │
            ▼
       Return original num
```

---

### 🧠 Step-by-Step Explanation

1. Convert the number to an array of digits for easy manipulation.
2. Create an array `last[10]` where `last[d]` stores the **last occurrence index** of digit `d`.
3. Traverse digits from left to right:
   - For each digit, check from 9 down to (digit+1) if a **larger digit appears later**.
   - If found, swap the two digits.
   - Convert the array back to an integer and return it immediately.
4. If no swap can increase the value, return the original number.

---

### 💻 Java Code

```java
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];

        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            int current = digits[i] - '0';
            for (int d = 9; d > current; d--) {
                if (last[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
```

---

### 📊 Complexity Analysis

| Aspect | Complexity | Explanation |
|--------|-------------|-------------|
| Time Complexity | O(n * 10) ≈ O(n) | At most 10 comparisons per digit |
| Space Complexity | O(10) | Only stores last occurrence indices |

---

### 💬 Interview Insights

- The trick lies in **recording the last index** of each digit for quick lookup.
- Greedy approach — always try to swap with the **rightmost largest digit**.
- Common mistake: Swapping with the **first** larger digit instead of the **rightmost** one.

---

### 🧾 Key Takeaways

- Greedy strategy ensures maximum gain with one swap.
- Preprocessing the last occurrence of each digit helps achieve O(n) time.
- Great example of combining **digit manipulation + greedy logic**.

