# ✅ LeetCode 155: Min Stack

---

## ✅ 0. Question: Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

### Implement the following operations:
- void push(int val)
- void pop()
- int top()
- int getMin()

### Example:
```java
Input:
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output:
[null,null,null,null,-3,null,0,-2]
```

---

## ✅ 1. Definition and Purpose

- The goal is to track the minimum value at any state of the stack in constant time.
- Useful in scenarios that require min-element lookup during LIFO operations.

---

## ✅ 2. Syntax and Structure

```java
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

---

## ✅ 3. Approach 1: Dual Stack (Optimized)

- Maintain two stacks:
  - `stack`: stores all values
  - `minStack`: stores the minimum value up to that point
- Time Complexity: O(1) for all operations

---

## ✅ 4. Approach 2: Single Stack with Pair (Custom Class)

```java
class MinStack {
    private Stack<int[]> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
```

---

## ✅ 5. Internal Working

- Each `minStack` entry mirrors or updates the lowest value at that point in `stack`
- For single-stack approach, we store both current value and min in the same entry

---

## ✅ 6. Best Practices

- Always use equals() to compare objects (like Integer)
- Pop from `minStack` only if it matches the popped value
- Avoid unnecessary minStack pushes if duplicate min exists

---

## ✅ 7. Related Concepts

- Stack
- Design pattern (state tracking)
- Monotonic stack pattern

---

## ✅ 8. Interview & Real-world Use

- Common interview question in design rounds (Google, Meta, Amazon)
- Useful in stock span, histogram area, and min-range problems

---

## ✅ 9. Common Errors & Debugging

- Using `==` instead of `.equals()` with Integer
- Not checking for empty stack
- Forgetting to sync `minStack` on pop()

---

## ✅ 10. Java Version Updates

- Java 8: Lambda/Streams not needed here
- Java 5+: Enhanced Stack and generics

---

## ✅ 11. Practice and Application

- LeetCode 155, 84, 496, 907
- Real-time price monitoring, min-range data tracking

---

## ✅ 12. ASCII Diagram

```
Input: push(2), push(0), push(3), push(0)

Stack:     [2, 0, 3, 0]
MinStack:  [2, 0, 0, 0]

getMin() → 0
pop() → remove 0
getMin() → 0
pop() → remove 3
getMin() → 0
pop() → remove 0
getMin() → 2
```

