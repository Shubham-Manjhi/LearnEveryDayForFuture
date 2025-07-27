# 📘 LeetCode 380: Insert Delete GetRandom O(1)

---

## ✅ 0. Question

Design a data structure that supports all following operations in average O(1) time:
- `insert(val)`: Inserts an item val to the set if not already present.
- `remove(val)`: Removes an item val from the set if present.
- `getRandom()`: Returns a random element from current set of elements. Each element must have the same probability of being returned.

### Example:
```text
RandomizedSet randomSet = new RandomizedSet();
randomSet.insert(1); // true
randomSet.remove(2); // false
randomSet.insert(2); // true
randomSet.getRandom(); // 1 or 2
randomSet.remove(1); // true
randomSet.insert(2); // false
randomSet.getRandom(); // 2
```

---

## ✅ 1. Definition and Purpose

- To design a data structure that supports constant time insert, delete, and random access.
- Traditional collections don’t support all three in O(1).
- Solves performance problems in randomized sampling, gaming, load balancing.

---

## ✅ 2. Syntax and Structure

```java
class RandomizedSet {
    public boolean insert(int val);
    public boolean remove(int val);
    public int getRandom();
}
```

- Constructor initializes data structures.
- Uses HashMap and ArrayList to maintain O(1) insert, remove and random access.

---

## ✅ 3. Practical Examples

### 🔹 Java Code:
```java
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>(); // maps value -> index
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
```

### Example Trace:
```text
insert(1) → list: [1], map: {1=0}
insert(2) → list: [1,2], map: {1=0, 2=1}
remove(1) → list: [2], map: {2=0}
getRandom() → random choice from list
```

---

## ✅ 4. Internal Working

- `insert`: Adds to list and maps value to index.
- `remove`: Swaps target element with last, updates map, and removes last.
- `getRandom`: Uses `Random` to get a uniform index from list.

---

## ✅ 5. Best Practices

- Always sync list and map during insert/remove.
- Random must use list size, not map.
- Avoid iterating map or list directly.

---

## ✅ 6. Related Concepts

- HashMap + ArrayList combo
- Set and Map operations
- Uniform random selection

---

## ✅ 7. Interview & Real-world Use

- Asked frequently in interviews for design & optimization.
- Real-life uses in gaming, load balancers, randomized decisions.

---

## ✅ 8. Common Errors & Debugging

- Forgetting to update map after swap.
- Random access from empty list.
- Not checking presence before insert/remove.

---

## ✅ 9. Java Version Updates

- `Random` class stable from Java 7+
- Java 8+ supports `ThreadLocalRandom` as a faster alternative.

---

## ✅ 10. Practice and Application

- LeetCode 381: Insert Delete GetRandom O(1) - Duplicates allowed
- LeetCode 710: Random Pick with Blacklist
- Implement randomized load balancer

---

🚀 Mastering RandomizedSet helps develop constant-time optimized data structures!

