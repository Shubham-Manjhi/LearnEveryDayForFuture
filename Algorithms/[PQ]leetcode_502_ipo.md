**LeetCode 502: IPO**

---

### 1. Problem Statement

You are given two integer arrays `profits` and `capital`. `profits[i]` is the profit you will gain from the ith project, and `capital[i]` is the minimum capital you need to start the ith project.

You start with `w` capital. You are allowed to do at most `k` distinct projects. Return the **maximum capital** you can accumulate after finishing at most `k` projects.

**Function Signature:**

```java
int findMaximizedCapital(int k, int w, int[] profits, int[] capital)
```

---

### 2. Understanding the Problem

- Each project has a required capital and a profit.
- You can only pick a project if your current capital >= required capital.
- Once picked, the project adds its profit to your capital.
- The goal is to maximize your capital after `k` projects.

---

### 3. Optimal Approach (Greedy with Min-Heap + Max-Heap)

**Idea:**

- Use a min-heap to sort projects by required capital.
- Use a max-heap to track available profitable projects that can be started with current capital `w`.
- At each step:
  1. Push all affordable projects into max-heap.
  2. Pick the one with the highest profit.

```java
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;

    PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(
        Comparator.comparingInt(a -> a[0])
    );
    PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
        minCapitalHeap.offer(new int[]{capital[i], profits[i]});
    }

    for (int i = 0; i < k; i++) {
        while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
            maxProfitHeap.offer(minCapitalHeap.poll()[1]);
        }

        if (maxProfitHeap.isEmpty()) break;

        w += maxProfitHeap.poll();
    }

    return w;
}
```

---

### 4. Complexity Analysis

- **Time Complexity:** O(n log n + k log n)
- **Space Complexity:** O(n) for both heaps

---

### 5. Edge Cases

- All `capital[i]` > `w`: Cannot start any project
- `k = 0`: Return original capital
- `profits` or `capital` is empty

---

### 6. Example

```java
Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4

Explanation:
Start with capital = 0
→ Pick project 0 (profit 1) → capital = 1
→ Now can afford project 1 or 2 → pick project 2 (profit 3) → capital = 4
```

---

### 7. Best Practices

- Always pick most profitable among affordable
- Maintain separate heaps for efficiency

---

### 8. Related Topics

- Greedy
- PriorityQueue
- Resource Allocation Problems

---

### 9. Interview Tip

> This is a variation of the **knapsack** problem with additional greedy optimization using heaps. Mention this in interviews.

---

### 10. Follow-up

> What if the profit takes time to realize and can only be used after t projects? Now it becomes a dynamic scheduling problem.

---

