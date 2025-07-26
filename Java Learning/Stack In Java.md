# 📘 Stack in Java (Full API + Custom Implementation)

---

## ✅ 1. Definition and Purpose

- A **Stack** is a linear data structure that follows **Last-In-First-Out (LIFO)** principle.
- Java provides `Stack` class as part of `java.util` package.
- Primarily used in function call handling, expression evaluation, undo features, etc.

---

## ✅ 2. Stack Class in Java API

### 🎯 Constructors
```java
Stack<E> stack = new Stack<>();
```

### 🧪 Methods from Java 8 Docs:

```java
boolean empty()
E peek()
E pop()
E push(E item)
int search(Object o)
```

### 🧠 Examples:
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);  // [10]
stack.push(20);  // [10, 20]
int top = stack.peek(); // 20
stack.pop();     // returns 20, now stack: [10]
boolean isEmpty = stack.empty();
int pos = stack.search(10); // returns 1 (from top)
```

---

## ✅ 3. Custom Stack Implementation

```java
class MyStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void push(E value) {
        list.addFirst(value);
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeFirst();
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public int search(E value) {
        int index = 1;
        for (E item : list) {
            if (item.equals(value)) return index;
            index++;
        }
        return -1;
    }
}
```

---

## ✅ 4. ASCII Diagram

```
Top → [30]
       [20]
       [10]
```

---

## ✅ 5. Related Concepts

- Queue
- LinkedList (used internally in custom implementation)
- Deque (Double-ended queue)

---

## ✅ 6. Best Practices

- Prefer `Deque` (via `ArrayDeque`) for stack implementation.
- Avoid using `Stack` class in multi-threaded environment without synchronization.
- Handle `EmptyStackException` properly.

---

## ✅ 7. Interview & Real-World Use

- Used in expression parsing (Postfix, Prefix)
- Function call stack, Undo/Redo operations
- Browser back/forward navigation

---

## ✅ 8. Common Errors & Debugging

- Calling pop() or peek() on empty stack causes `EmptyStackException`
- Confusing stack search position (1-based from top)

---

## ✅ 9. Java Version Notes

- Java recommends using `Deque` for stack operations in modern Java (Java 6+).
- Stack extends Vector, which is synchronized and thus may be slower.

---

## ✅ 10. Practice and Application

- LeetCode: Valid Parentheses, Min Stack, Reverse Polish Notation
- Implement call stack, browser history

---

✅ Stack implementation and usage in Java is now fully documented!

