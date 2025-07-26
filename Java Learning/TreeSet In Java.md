# 🌲 TreeSet in Java (Full API + Custom Implementation)

---

## ✅ 1. Definition and Purpose

- `TreeSet` is a NavigableSet implementation based on a TreeMap.
- It stores elements in a **sorted** and **ascending** order by default.
- Does not allow duplicate elements.

---

## ✅ 2. Syntax and Structure

```java
TreeSet<Type> set = new TreeSet<>();
```

### 🎯 Constructors:
```java
TreeSet()
TreeSet(Collection<? extends E> c)
TreeSet(Comparator<? super E> comparator)
TreeSet(SortedSet<E> s)
```

---

## ✅ 3. Key Methods

```java
boolean add(E e)
boolean remove(Object o)
boolean contains(Object o)
void clear()
E first()
E last()
E ceiling(E e)
E floor(E e)
E higher(E e)
E lower(E e)
SortedSet<E> headSet(E toElement)
SortedSet<E> tailSet(E fromElement)
SortedSet<E> subSet(E fromElement, E toElement)
```

---

## ✅ 4. Example Usage

```java
TreeSet<Integer> set = new TreeSet<>();
set.add(30);
set.add(10);
set.add(20);
System.out.println(set); // [10, 20, 30]
System.out.println(set.first()); // 10
System.out.println(set.ceiling(15)); // 20
System.out.println(set.tailSet(20)); // [20, 30]
```

---

## ✅ 5. ASCII Diagram

```
    20
   /  \
 10    30
```

Elements arranged as per Binary Search Tree order (in-order traversal gives sorted order).

---

## ✅ 6. Internal Working

- Internally implemented using a **Red-Black Tree**.
- Maintains **O(log N)** time complexity for add, remove, and contains.
- Sorted either by natural ordering (Comparable) or custom Comparator.

---

## ✅ 7. Custom TreeSet-Like Implementation

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

class MyTreeSet {
    private TreeNode root;

    public boolean add(int val) {
        if (root == null) { root = new TreeNode(val); return true; }
        TreeNode cur = root, parent = null;
        while (cur != null) {
            parent = cur;
            if (val < cur.val) cur = cur.left;
            else if (val > cur.val) cur = cur.right;
            else return false; // duplicate
        }
        if (val < parent.val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);
        return true;
    }

    public boolean contains(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) cur = cur.left;
            else if (val > cur.val) cur = cur.right;
            else return true;
        }
        return false;
    }
}
```

---

## ✅ 8. Related Concepts

- `HashSet` (no order)
- `LinkedHashSet` (insertion order)
- `NavigableSet` and `SortedSet` interfaces

---

## ✅ 9. Best Practices

- Avoid inserting `null` values – `TreeSet` does not allow null elements.
- Use `Comparator` for custom ordering.
- Prefer `HashSet` if sorting is not needed.

---

## ✅ 10. Interview & Real-World Use

- Useful in scenarios where sorted unique data is required.
- Common in leaderboards, range queries, ceiling/floor searches.
- Used in interval trees and memory allocation problems.

---

## ✅ 11. Common Errors & Debugging

- Inserting duplicate elements: silently ignored
- NullPointerException if `null` is inserted without comparator
- ClassCastException if elements are not mutually comparable

---

## ✅ 12. Java Version Notes

- Available since Java 1.2 as part of the Collections Framework.
- Java 8+ supports lambda for comparators:
```java
TreeSet<String> set = new TreeSet<>((a, b) -> b.compareTo(a)); // Descending order
```

---

## ✅ 13. Practice and Application

- LeetCode: Contains Duplicate III, Summary Ranges, My Calendar I
- Competitive Programming: Range sets, ordered statistics

---

✅ TreeSet in Java is now fully documented with internals, API, custom implementation, and practice!

