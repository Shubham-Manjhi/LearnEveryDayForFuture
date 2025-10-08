<div align="center">

# 🎯 **400. Nth Digit — Problem Breakdown & Interview Canvas** 🔢

**_Find the n-th digit of the infinite integer sequence: 123456789101112..._**

</div>

---

# 🔹 Table of Contents

1. Problem statement
2. Intuition & key observation
3. Step-by-step algorithm
4. Python solution (clean, production-ready)
5. Complexity analysis
6. Edge cases & test cases
7. Common interview follow-ups and Q&A
8. Variations & related problems
9. Quick reference (cheat-sheet)

---

# 🔹 1) Problem statement

Given an integer `n`, return the `n`-th digit of the infinite integer sequence formed by concatenating the positive integers:

```
S = "123456789101112131415..."
```

The digits are 1-indexed: the 1st digit is `1`, the 9th digit is `9`, the 10th digit is `1` (from `10`), the 11th digit is `0` (from `10`), etc.

**Example**
- Input: `n = 11` → Output: `0` (because the sequence up to that point is `12345678910`, and the 11th digit is `0`).

**Goal:** Provide a correct and efficient function that returns the digit as an integer (0–9).

---

# 🔹 2) Intuition & Key Observation 🧭

The concatenated sequence is built of blocks of numbers grouped by their **digit length**:

- 1-digit numbers: `1`–`9` → 9 numbers → contributes `9 * 1 = 9` digits
- 2-digit numbers: `10`–`99` → 90 numbers → contributes `90 * 2 = 180` digits
- 3-digit numbers: `100`–`999` → 900 numbers → contributes `900 * 3 = 2700` digits
- and so on...

The approach is to:
1. Determine which digit-length block contains the `n`-th digit (1-digit, 2-digit, 3-digit, ...).
2. Find the exact integer within that block that holds the `n`-th digit.
3. Extract the specific digit from that integer.

This avoids building the sequence (which would be infeasible for large `n`) and computes the result using arithmetic.

---

# 🔹 3) Step-by-step algorithm (concise)

1. Start with `digit_length = 1`, `count = 9` (how many numbers of this digit length), `start = 1` (first number with that digit length), and remaining `n`.
2. While `n > digit_length * count`:
   - subtract `digit_length * count` from `n` (skip that whole block)
   - increment `digit_length` by 1
   - update `count *= 10` (next block has 10× more numbers)
   - update `start *= 10` (first number of next block)
3. After the loop, we know the target digit is within the block of numbers that have `digit_length` digits.
4. Compute the actual number that contains the `n`-th digit using:
   - `index = (n - 1) // digit_length`  (0-based index into the block)
   - `number = start + index`
5. The digit's position inside `number` is `(n - 1) % digit_length`. Convert `number` to string (or extract arithmetically) and pick that digit.
6. Return the integer value of that digit.

Note: using `(n - 1)` makes indexing easier because digits are 1-indexed in the problem but easier to handle zero-based offsets.

---

# 🔹 4) Python solution (clear, production-ready) 🐍

```python
# code/python
# Problem: 400. Nth Digit
# Clean, efficient implementation with explanatory comments.

class NthDigitSolver:
    """Class wrapper providing solution and helper methods for clarity and testing."""

    @staticmethod
    def find_nth_digit(n: int) -> int:
        """Return the nth digit in the concatenated sequence '123456789101112...'.

        Args:
            n: 1-indexed position of the digit to retrieve (n >= 1).

        Returns:
            int: the digit at position n (0..9).
        """
        if n < 1:
            raise ValueError("n must be >= 1")

        digit_length = 1          # current group digit length (1 for 1..9, 2 for 10..99, ...)
        count = 9                 # number of integers in this group (9, 90, 900, ...)
        start = 1                 # first integer in this group (1, 10, 100, ...)

        # Find the group that contains the nth digit
        while n > digit_length * count:
            n -= digit_length * count
            digit_length += 1
            count *= 10
            start *= 10

        # index (0-based) of the number within the group that contains the desired digit
        index = (n - 1) // digit_length
        number = start + index

        # position of the digit within the number (0-based)
        digit_index = (n - 1) % digit_length

        # extract digit: convert to string for simplicity and clarity
        s = str(number)
        return int(s[digit_index])


# Example usage (uncomment to run locally):
# print(NthDigitSolver.find_nth_digit(11))  # expected 0
```

**Notes about implementation choices**
- Converting `number` to `str` uses negligible extra time relative to the arithmetic operations and simplifies extracting the digit.
- The method validates `n >= 1` and raises a `ValueError` for invalid inputs — a small defensive programming touch useful for production code.

---

# 🔹 5) Complexity Analysis 📈

- **Time complexity:** O(log10(n)).
  - The algorithm increases `digit_length` and divides the remaining `n` by roughly a factor of 10 in terms of the block size each iteration — the number of iterations is at most the number of digits in the target number, which is `O(log10(n))`.
- **Space complexity:** O(1) additional space (strings used are of length at most ~log10(n) for the extracted number). Converting `number` to `str` uses O(digit_length) transient space.

---

# 🔹 6) Edge cases & test cases ✅

**Edge cases to consider**
- Smallest `n` = 1: expected `1`.
- Values where `n` is exactly at the boundary between blocks, e.g., 9, 10, 189, 190, 2889, etc.
- Very large `n` (e.g., `n = 2_147_483_647`) — algorithm handles large `n` efficiently because it works with arithmetic only.
- Invalid `n` (e.g., `n <= 0`) — the implementation raises an exception.

**Representative tests**

| n | Sequence snippet | Expected digit |
|---:|---|---:|
| 1 | 1... | 1 |
| 9 | 123456789 | 9 |
| 10 | 12345678910 | 1 |
| 11 | 12345678910 | 0 |
| 189 | ... up to 99 | 9 |  # last digit of the 2-digit block
| 190 | first digit of 100 (3-digit block) | 1 |

**Sample assertions (pytest style)**

```python
def test_examples():
    assert NthDigitSolver.find_nth_digit(1) == 1
    assert NthDigitSolver.find_nth_digit(9) == 9
    assert NthDigitSolver.find_nth_digit(10) == 1
    assert NthDigitSolver.find_nth_digit(11) == 0
    assert NthDigitSolver.find_nth_digit(190) == 1
```

---

# 🔹 7) Common interview follow-ups & Q&A 💬

**Q — Could you extract the digit without converting the number to a string?**

**A —** Yes. You can extract arithmetically by dividing/using modulo operations. Example: to get the `k`-th digit (0-based from left) of `number` with `digit_length` digits:

```python
# arithmetic extraction (0-based k from left)
left_shifts = digit_length - 1 - k
digit = (number // (10 ** left_shifts)) % 10
```

This avoids the string conversion and is fully arithmetic; both approaches are acceptable in interviews — mention trade-offs (clarity vs micro-optimization).

**Q — How does this scale for very large `n` (e.g., 64-bit `n`)?**

**A —** The algorithm uses only integer arithmetic and runs in O(log10(n)) steps (a small number of iterations). It works for 64-bit `n` as long as language integers support it (Python integers are unbounded). Careful: intermediate `10**k` may grow large but still manageable in Python.

**Q — What if `n` were 0-indexed instead?**

**A —** Minor adjustments: use `index = n // digit_length` and `digit_index = n % digit_length` after deciding conventions. The `(n - 1)` trick used in this implementation handles the 1-indexed input neatly.

---

# 🔹 8) Variations & related problems 🔁

- **Find the k-th digit after concatenating only even numbers** — similar block-based thinking but different counts and starts.
- **Leetcode 400** itself is a classic; related problems include digit-manipulation or sequence-indexing problems such as "find nth character in a compressed string" or "find kth digit in concatenated primes".

---

# 🔹 9) Quick reference (cheat-sheet) 🧾

**Key formulas**
- `count` (numbers with `d` digits) = `9 * (10**(d-1))`
- `digits_in_block(d)` = `count * d`
- After skipping earlier full blocks: `index = (n-1) // d`, `number = start + index`, `digit = str(number)[(n-1) % d]`.

**One-line core loop (conceptual)**

```python
while n > d*9*10**(d-1):
    n -= d*9*10**(d-1)
    d += 1
```

---

# Closing notes

This canvas explains the thought process, a robust implementation, complexity, edge cases, follow-ups, and variations — everything you need for interview readiness on **LeetCode 400 — Nth Digit**.

If you want:
- A step-by-step visual showing how `n` traverses blocks for a particular `n` (I can add example tracing for specific `n`),
- The purely arithmetic variant (no `str` conversion) implemented and benchmarked,
- Or a downloadable notebook with tests,

tell me which one and I will add it to this canvas.

