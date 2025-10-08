# 🔥 Set in Python

---

## 📘 Introduction

In Python, a **set** is an unordered collection of unique elements. Sets are useful when you need to store multiple items without duplicates and perform mathematical operations like union, intersection, and difference.

Key points:
- Sets are **unordered** (no index-based access).
- They contain **unique** elements (no duplicates).
- They are **mutable** (elements can be added/removed).
- Elements inside a set must be **hashable** (immutable types like numbers, strings, tuples).

```python
# Example
my_set = {1, 2, 3, 4, 4}
print(my_set)   # {1, 2, 3, 4} → duplicate removed
```

---

## 🔹 Creating Sets

### ✅ Methods of creating sets:

```python
# Using curly braces
s1 = {1, 2, 3}

# Using set() constructor
s2 = set([1, 2, 3, 4])

# Empty set (must use set(), not {})
s3 = set()
print(type(s3))  # <class 'set'>
```

⚠️ `{}` creates an **empty dictionary**, not a set.

---

## 🔹 Adding & Removing Elements

```python
s = {1, 2, 3}

# Add single element
s.add(4)
print(s)  # {1, 2, 3, 4}

# Add multiple elements
s.update([5, 6, 7])
print(s)  # {1, 2, 3, 4, 5, 6, 7}

# Remove element (error if not present)
s.remove(3)

# Discard element (no error if not present)
s.discard(10)

# Pop element (removes arbitrary element)
print(s.pop())

# Clear all elements
s.clear()
print(s)  # set()
```

---

## 🔹 Set Operations

Sets support **mathematical operations**:

```python
A = {1, 2, 3, 4}
B = {3, 4, 5, 6}

# Union
print(A | B)          # {1, 2, 3, 4, 5, 6}
print(A.union(B))

# Intersection
print(A & B)          # {3, 4}
print(A.intersection(B))

# Difference
print(A - B)          # {1, 2}
print(A.difference(B))

# Symmetric Difference
print(A ^ B)          # {1, 2, 5, 6}
print(A.symmetric_difference(B))
```

---

## 🔹 Set Membership & Iteration

```python
s = {1, 2, 3, 4}

# Membership check
print(2 in s)   # True
print(10 in s)  # False

# Iterating through set
for item in s:
    print(item)
```

---

## 🔹 Frozen Sets (Immutable Sets)

Python provides an **immutable version of sets** called `frozenset`.

```python
fs = frozenset([1, 2, 3, 4])
print(fs)

# fs.add(5)  # ❌ Error: cannot modify
```

Useful when you need **hashable sets** (e.g., dictionary keys).

---

## 🎯 Interview Q&A

**Q1. Difference between list, tuple, and set?**
- **List** → Ordered, mutable, allows duplicates.
- **Tuple** → Ordered, immutable, allows duplicates.
- **Set** → Unordered, mutable, no duplicates.

**Q2. When would you use a set over a list?**
- When uniqueness is required.
- When frequent membership checks are needed (`in` is O(1) in sets).

**Q3. What is the time complexity of set operations?**
- Add, remove, lookup → Average O(1), Worst O(n).

**Q4. Can a set contain another set?**
- No, because sets are mutable (unhashable).
- But a set can contain a `frozenset`.

```python
s = {frozenset([1, 2]), frozenset([3, 4])}
print(s)
```

---

## 🚀 Key Takeaways
- Sets are powerful for **unique collections** and **fast lookups**.
- Support **mathematical operations** like union, intersection.
- `frozenset` provides immutability when needed.
- Frequently used in problems involving **duplicate removal** or **fast membership testing**.

---

