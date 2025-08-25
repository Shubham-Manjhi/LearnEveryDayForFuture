# ⚡ **Synchronization in Java**

Synchronization is a core concept in Java concurrency to **control access to shared resources** by multiple threads, preventing **race conditions** and ensuring **thread safety**.

---

## ✨ **Topics Covered**

- **What is Synchronization?**
- **Synchronized Methods**
- **Synchronized Blocks**
- **Locks and ReentrantLock**
- **Static Synchronization**
- **Deadlocks**
- **Best Practices & Interview Tips**

---

## 🟢 **What is Synchronization?**

Synchronization ensures that only **one thread can access a resource at a time**, avoiding inconsistent data.

- **Race Condition:** Occurs when multiple threads modify shared data simultaneously.
- **Critical Section:** Code segment that accesses shared resources.

---

## 🟡 **Synchronized Methods**

Declaring a method with the `synchronized` keyword ensures **mutual exclusion** for the entire method.

### ✅ Example:

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SyncMethodDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++) counter.increment();
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++) counter.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + counter.getCount()); // 2000
    }
}
```

**Key Points:**

- Synchronization is at the object level.
- Only one thread can execute a synchronized method per object instance.

---

## 🔵 **Synchronized Blocks**

Synchronized blocks allow **fine-grained control** by locking only a specific block of code.

### ✅ Example:

```java
class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized(lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
```

**Key Points:**

- More efficient than synchronizing the entire method.
- Locks can be different objects for different blocks.

---

## 🟣 **Locks and ReentrantLock**

`ReentrantLock` provides advanced locking features beyond `synchronized`, such as **tryLock()**, **fairness**, and **interruptible locks**.

### ✅ Example:

```java
import java.util.concurrent.locks.*;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
```

**Key Points:**

- Must always release the lock in `finally` to avoid deadlocks.
- Supports **tryLock()** to attempt lock acquisition without blocking.

---

## 🟠 **Static Synchronization**

Static synchronized methods lock on the **Class object** rather than an instance, useful for **class-level data**.

### ✅ Example:

```java
class SharedResource {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
```

**Key Points:**

- Locks apply to all instances of the class.
- Useful for shared static data.

---

## 🔴 **Deadlocks**

Deadlocks occur when **two or more threads are waiting indefinitely** for each other's locks.

### ✅ Example:

```java
class DeadlockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void task1() {
        synchronized(lock1) {
            synchronized(lock2) {
                System.out.println("Task1 completed");
            }
        }
    }

    public void task2() {
        synchronized(lock2) {
            synchronized(lock1) {
                System.out.println("Task2 completed");
            }
        }
    }
}
```

**Key Points:**

- Avoid nested locks or acquire locks in a **consistent order**.
- Use `tryLock()` to prevent indefinite blocking.

---

## 🟤 **Best Practices & Interview Tips**

1. Prefer **synchronized blocks** over entire methods for efficiency.
2. Use **ReentrantLock** for advanced features and better control.
3. Minimize the scope of synchronized code to reduce contention.
4. Always release locks in **finally blocks**.
5. Understand potential for **deadlocks** and how to avoid them.

### ✅ Common Interview Questions:

- Difference between `synchronized` method and block.
- When to use ReentrantLock over synchronized.
- How to prevent deadlocks in Java.
- Explain static synchronization.

---

Synchronization ensures **thread safety** while maintaining performance in multithreaded Java applications. Mastery of these concepts is crucial for interviews and production systems.

**Page Count:** 5-6 pages with examples, explanations, and best practices.

---

> 📌 Next Steps: Provide the **next topic/question**, such as **Volatile Keyword, Atomic Variables, or Locks**, and I will continue expanding the advanced Java guide.

