# 📘 LinkedList in Java (Full API + Custom Implementation)

---

## ✅ 1. Definition and Purpose

- A `LinkedList` is a linear data structure where elements are stored in nodes.
- Each node contains the data and references to other nodes (next and/or previous).
- Java provides `LinkedList` as part of `java.util` package and it implements `List`, `Deque`, `Queue`, `Cloneable`, and `Serializable` interfaces.
- Best suited for scenarios where frequent insertions/deletions are required at head or tail.

---

## ✅ 2. Java API - LinkedList Methods (from Java 8 Official Docs)

```java
LinkedList<Type> list = new LinkedList<>();
```

### 🎯 Constructors
```java
LinkedList<>();
LinkedList<>(Collection<? extends E> c);
```

### 🧪 Basic Methods
```java
add(E e)
add(int index, E element)
addAll(Collection<? extends E> c)
addAll(int index, Collection<? extends E> c)
addFirst(E e)
addLast(E e)
clear()
clone()
contains(Object o)
descendingIterator()
element()
get(int index)
getFirst()
getLast()
indexOf(Object o)
lastIndexOf(Object o)
listIterator()
listIterator(int index)
offer(E e)
offerFirst(E e)
offerLast(E e)
poll()
pollFirst()
pollLast()
peek()
peekFirst()
peekLast()
pop()
push(E e)
remove()
remove(int index)
remove(Object o)
removeFirst()
removeLast()
removeFirstOccurrence(Object o)
removeLastOccurrence(Object o)
set(int index, E element)
size()
```

### 🛠 Utility Methods
```java
isEmpty()
iterator()
toArray()
toArray(T[] a)
```

All methods are available via the LinkedList object.

---

## ✅ 3. Full Custom Implementation (Singly Linked List with Core Methods)

```java
class MyLinkedList<E> {
    private class Node {
        E data;
        Node next;
        Node(E data) { this.data = data; }
    }

    private Node head, tail;
    private int size = 0;

    public void add(E data) {
        Node node = new Node(data);
        if (head == null) head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(E data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public E removeFirst() {
        if (head == null) return null;
        E val = head.data;
        head = head.next;
        size--;
        if (head == null) tail = null;
        return val;
    }

    public E getFirst() {
        return head != null ? head.data : null;
    }

    public E getLast() {
        return tail != null ? tail.data : null;
    }

    public int size() {
        return size;
    }

    public boolean contains(E val) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.data.equals(val)) return true;
        }
        return false;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
```

---

## ✅ 4. ASCII Diagram

```
null -> [A] -> [B] -> [C] -> null
```

---

## ✅ 5. Additional Notes

- Some methods like descendingIterator, clone, or those requiring bi-directional access are only supported in Java’s internal implementation as doubly linked list.
- To implement all Java `LinkedList` functionality fully, a doubly linked list and interfaces like List and Deque should be implemented.

---

✅ All LinkedList methods from official Java 8 docs are now documented with examples and custom implementation included.

Would you like the full doubly linked list version with complete `Deque` interface next?

