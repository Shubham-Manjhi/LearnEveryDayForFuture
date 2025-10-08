# 🗂️ HashMap (Dictionary) in Python

---

## 📘 Introduction

In Python, the equivalent of a **HashMap** (in Java) or **Map** (in other languages) is the **dictionary (`dict`)**. It is a collection of key-value pairs, where:

- Keys must be **unique** and **hashable** (immutable types like int, str, tuple).
- Values can be of any type.
- Dictionaries are **unordered** before Python 3.7, but from Python 3.7+ they maintain **insertion order**.

```python
# Example
my_dict = {"a": 1, "b": 2, "c": 3}
print(my_dict["a"])   # 1
```

---

## 🔹 Creating Dictionaries

```python
# Using curly braces
person = {"name": "Alice", "age": 25, "city": "New York"}

# Using dict() constructor
data = dict(x=10, y=20)

# Empty dictionary
empty = {}
```

---

## 🔹 Accessing & Modifying Data

```python
student = {"name": "Bob", "age": 21}

# Access value
print(student["name"])       # Bob

# Safe access with default
print(student.get("grade", "N/A"))

# Modify value
student["age"] = 22

# Add new key-value
student["grade"] = "A"

print(student)
```

---

## 🔹 Removing Elements

```python
my_dict = {"a": 1, "b": 2, "c": 3}

# Remove specific key
my_dict.pop("b")

# Remove last inserted key-value
my_dict.popitem()

# Delete by key
del my_dict["a"]

# Clear dictionary
my_dict.clear()
```

---

## 🔹 Iterating Over Dictionaries

```python
person = {"name": "Alice", "age": 25, "city": "NY"}

# Iterate keys
for key in person:
    print(key)

# Iterate values
for value in person.values():
    print(value)

# Iterate key-value pairs
for key, value in person.items():
    print(key, value)
```

---

## 🔹 Dictionary Methods

```python
user = {"id": 1, "name": "John"}

# Check existence
print("id" in user)    # True

# Copy
d = user.copy()

# Merge two dicts
user.update({"age": 30})

# Default values
defaults = {"role": "guest"}
user = {**defaults, **user}
```

---

## 🔹 Nested Dictionaries

```python
students = {
    1: {"name": "Alice", "age": 20},
    2: {"name": "Bob", "age": 22}
}

print(students[1]["name"])  # Alice
```

---

## 🔹 Dictionary Comprehension

```python
squares = {x: x**2 for x in range(5)}
print(squares)   # {0:0, 1:1, 2:4, 3:9, 4:16}
```

---

## 🔹 Interview Q&A

**Q1. Difference between HashMap in Java and dict in Python?**
- Both store key-value pairs.
- Python dict maintains **insertion order** (Java HashMap does not guarantee order).

**Q2. What is the time complexity of dictionary operations?**
- Insert, Delete, Lookup → **Average O(1)**, **Worst O(n)** due to hash collisions.

**Q3. Can a dictionary key be a list?**
- ❌ No, because lists are mutable (unhashable).
- ✅ Use tuples instead.

**Q4. How to implement a HashMap manually in Python?**
- By using **lists + hashing function** and handling collisions via **chaining**.

---

## 🚀 Key Takeaways
- Python dictionary = HashMap equivalent.
- Keys must be **unique & hashable**.
- Supports fast lookup, insert, delete operations.
- Very useful in **counting, caching, memoization, graph representation**.

---

