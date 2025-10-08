# ⚡ Cache Implementation in Python

---

## 📘 Problem Explanation

A **cache** is a temporary storage layer that stores frequently accessed data in memory to speed up subsequent requests. Instead of recalculating or fetching the same data repeatedly, the cache serves it directly.

We’ll explore different ways to implement cache in Python:
1. Manual implementation with dictionaries.
2. Using `functools.lru_cache`.
3. Building a custom **LRU (Least Recently Used) Cache** with `OrderedDict`.
4. Using `cachetools` library.

---

## 🔹 Approach 1: Dictionary as a Simple Cache

We can store key-value pairs in a dictionary to mimic a cache.

```python
cache = {}

def get_data(x):
    if x in cache:
        print("Cache hit!")
        return cache[x]
    else:
        print("Cache miss! Computing...")
        result = x * x  # Simulate heavy computation
        cache[x] = result
        return result

print(get_data(5))  # Cache miss
print(get_data(5))  # Cache hit
```

✅ **Pros:** Simple and fast.  
❌ **Cons:** No eviction policy (cache can grow indefinitely).

---

## 🔹 Approach 2: Using `functools.lru_cache`

Python provides a built-in decorator for caching function results.

```python
from functools import lru_cache

@lru_cache(maxsize=3)
def square(n):
    print(f"Computing square of {n}")
    return n * n

print(square(2))  # Computed
print(square(2))  # Cached
print(square(3))  # Computed
print(square(4))  # Computed
print(square(2))  # Still cached
print(square(5))  # Evicts least recently used
```

✅ **Pros:** Automatic cache management, LRU eviction.  
❌ **Cons:** Works only on functions, limited control.

---

## 🔹 Approach 3: Custom LRU Cache with `OrderedDict`

```python
from collections import OrderedDict

class LRUCache:
    def __init__(self, capacity: int):
        self.cache = OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key)  # mark as recently used
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key] = value
        if len(self.cache) > self.capacity:
            self.cache.popitem(last=False)  # remove least recently used

# Example usage
lru = LRUCache(2)
lru.put(1, 1)
lru.put(2, 2)
print(lru.get(1))  # returns 1
lru.put(3, 3)      # evicts key 2
print(lru.get(2))  # returns -1 (not found)
```

✅ **Pros:** Customizable, interview-friendly implementation.  
❌ **Cons:** Slightly more complex.

---

## 🔹 Approach 4: Using `cachetools`

The `cachetools` library provides various cache strategies like LRU, LFU.

```python
from cachetools import LRUCache

cache = LRUCache(maxsize=3)

cache[1] = 'A'
cache[2] = 'B'
cache[3] = 'C'

print(cache)
cache[4] = 'D'  # Evicts least recently used (1)
print(cache)
```

✅ **Pros:** Rich caching strategies, production-ready.  
❌ **Cons:** Requires external library.

---

## 🔹 Dry Run Example (Custom LRUCache)

```python
Capacity = 2
Put(1, 1) → Cache = {1=1}
Put(2, 2) → Cache = {1=1, 2=2}
Get(1)    → Returns 1, Cache = {2=2, 1=1}
Put(3, 3) → Evicts 2, Cache = {1=1, 3=3}
Get(2)    → Returns -1 (not found)
```

---

## 🔹 Interview Questions & Answers

**Q1. What is the difference between LRU and LFU cache?**  
👉 LRU removes least recently used items, LFU removes least frequently used.

**Q2. Why do we use OrderedDict in custom LRU cache?**  
👉 To maintain insertion order and update recent usage efficiently.

**Q3. What’s the time complexity of get/put in LRU cache?**  
👉 `O(1)` using OrderedDict or HashMap + Doubly Linked List.

**Q4. Which Python built-in helps with caching?**  
👉 `functools.lru_cache`.

---

## 🎯 Conclusion

- **Dictionary**: Basic caching.
- **lru_cache**: Easiest solution for functions.
- **Custom LRU**: Best for interviews.
- **cachetools**: Best for production-level caching with flexible policies.

---

