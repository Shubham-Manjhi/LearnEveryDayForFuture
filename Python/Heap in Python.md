# 🛠️ Heap in Python

---

## 🔹 Introduction to Heap
A **heap** is a specialized tree-based data structure that satisfies the **heap property**:
- In a **Min-Heap**, the parent node is always **less than or equal to** its children.
- In a **Max-Heap**, the parent node is always **greater than or equal to** its children.

In Python, the built-in **`heapq`** module provides an efficient implementation of the **min-heap**.

📌 **Key Points:**
- Heaps are commonly used in **priority queues**.
- Supports **insertion** and **extraction** in **O(log n)**.
- Useful in problems like **finding the k-th largest/smallest element**, **heap sort**, and **scheduling algorithms**.

---

## 🔹 Operations in Heap (using `heapq`)

### 1. Creating a Heap
```python
import heapq

nums = [5, 3, 8, 1, 2]
heapq.heapify(nums)  # converts list into min-heap
print(nums)  # [1, 2, 8, 5, 3] (internal order may vary)
```

### 2. Insertion (`heappush`)
```python
heapq.heappush(nums, 0)
print(nums)  # [0, 1, 8, 5, 3, 2]
```

### 3. Deletion (`heappop`)
```python
min_val = heapq.heappop(nums)
print(min_val)  # 0
print(nums)  # [1, 2, 8, 5, 3]
```

### 4. Peek Minimum
```python
print(nums[0])  # 1 (smallest element)
```

### 5. Max-Heap Simulation
Python only supports min-heaps, but we can simulate max-heap:
```python
max_heap = []
heapq.heappush(max_heap, -5)
heapq.heappush(max_heap, -1)
heapq.heappush(max_heap, -10)

print(-heapq.heappop(max_heap))  # 10
```

---

## 🔹 Advanced Heap Operations

### 1. Finding K Smallest & Largest Elements
```python
nums = [7, 10, 4, 3, 20, 15]

print(heapq.nsmallest(3, nums))  # [3, 4, 7]
print(heapq.nlargest(3, nums))   # [20, 15, 10]
```

### 2. Heap Sort
```python
def heap_sort(iterable):
    h = []
    for value in iterable:
        heapq.heappush(h, value)
    return [heapq.heappop(h) for _ in range(len(h))]

nums = [5, 1, 9, 3]
print(heap_sort(nums))  # [1, 3, 5, 9]
```

### 3. Priority Queue Example
```python
import heapq

class PriorityQueue:
    def __init__(self):
        self.queue = []

    def push(self, item, priority):
        heapq.heappush(self.queue, (priority, item))

    def pop(self):
        return heapq.heappop(self.queue)[1]

pq = PriorityQueue()
pq.push("task1", 2)
pq.push("task2", 1)

print(pq.pop())  # task2 (highest priority = lowest number)
```

---

## 🔹 Interview Questions & Answers

### Q1. What is the time complexity of heap operations?
- **Insertion**: `O(log n)`
- **Deletion (pop)**: `O(log n)`
- **Peek**: `O(1)`
- **Heapify**: `O(n)`

### Q2. Difference between Heap and Binary Search Tree?
| Feature | Heap | BST |
|---------|------|-----|
| Structure | Complete Binary Tree | Binary Tree |
| Order | Only heap property maintained | BST property maintained |
| Search | O(n) | O(log n) |
| Use Case | Priority Queue | Searching |

### Q3. How do you implement Max Heap in Python?
- By pushing negative values into `heapq`.

### Q4. Real-life applications of Heap?
- Job scheduling
- Dijkstra’s algorithm (shortest path)
- Priority queues
- Event simulation

---

## 🔹 Real-World Example: Dijkstra’s Algorithm (Shortest Path)
```python
import heapq

def dijkstra(graph, start):
    pq = [(0, start)]  # (distance, node)
    dist = {node: float('inf') for node in graph}
    dist[start] = 0

    while pq:
        current_dist, node = heapq.heappop(pq)

        if current_dist > dist[node]:
            continue

        for neighbor, weight in graph[node]:
            distance = current_dist + weight
            if distance < dist[neighbor]:
                dist[neighbor] = distance
                heapq.heappush(pq, (distance, neighbor))
    return dist

# Graph represented as adjacency list
graph = {
    'A': [('B', 1), ('C', 4)],
    'B': [('C', 2), ('D', 6)],
    'C': [('D', 3)],
    'D': []
}

print(dijkstra(graph, 'A'))
# Output: {'A': 0, 'B': 1, 'C': 3, 'D': 6}
```

---

## 🎯 Conclusion
- **Heap** is a **tree-based data structure** mainly used for priority queues.
- Python provides **`heapq`** which implements a **min-heap**.
- Supports **O(log n)** insertion & deletion.
- Can be extended to **max-heaps**, **priority queues**, and algorithms like **Dijkstra’s shortest path**.

---

