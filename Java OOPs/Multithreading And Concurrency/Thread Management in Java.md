# ⚡ **Thread Management in Java**

Thread management is crucial for controlling execution, resource utilization, and responsiveness in Java applications. Proper management ensures threads run efficiently and safely.

---

## ✨ **Topics Covered**

- **Thread Lifecycle Management**
- **Thread Scheduling and Priorities**
- **Daemon Threads**
- **Thread Group Management**
- **Executor Framework**
- **Best Practices & Interview Tips**

---

## 🟢 **Thread Lifecycle Management**

A thread moves through various states: **New, Runnable, Running, Waiting, Timed Waiting, and Terminated**. Managing these states ensures threads execute properly without deadlocks or starvation.

### ✅ Example:

```java
class LifecycleThread extends Thread {
    public void run() {
        System.out.println(getName() + " is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted");
        }
        System.out.println(getName() + " has finished");
    }
}

public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        LifecycleThread t1 = new LifecycleThread();
        t1.start();
        t1.join();
        System.out.println(t1.getName() + " state: " + t1.getState());
    }
}
```

**Key Points:**

- Use `join()` to wait for thread completion.
- Handle `InterruptedException` properly.

---

## 🟡 **Thread Scheduling and Priorities**

Threads have priorities from **1 (MIN)** to **10 (MAX)**. The JVM uses these priorities as hints for scheduling.

### ✅ Example:

```java
Thread high = new Thread(() -> System.out.println("High priority thread"));
Thread low = new Thread(() -> System.out.println("Low priority thread"));

high.setPriority(Thread.MAX_PRIORITY);
low.setPriority(Thread.MIN_PRIORITY);

high.start();
low.start();
```

**Key Points:**

- Scheduling depends on OS and JVM; not guaranteed.
- Higher priority threads may get more CPU time.

---

## 🔵 **Daemon Threads**

Daemon threads are **background threads** that do not prevent JVM exit.

### ✅ Example:

```java
Thread daemon = new Thread(() -> {
    while(true) {
        System.out.println("Daemon thread running");
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }
});
daemon.setDaemon(true);
daemon.start();
System.out.println("Main thread finished");
```

**Key Points:**

- Used for background tasks like logging or cleanup.
- JVM terminates daemon threads when all user threads finish.

---

## 🟣 **Thread Group Management**

Thread groups allow organizing multiple threads and controlling them as a single unit.

### ✅ Example:

```java
ThreadGroup group = new ThreadGroup("MyGroup");
Thread t1 = new Thread(group, () -> System.out.println("Thread 1"));
Thread t2 = new Thread(group, () -> System.out.println("Thread 2"));

t1.start();
t2.start();
System.out.println("Active threads: " + group.activeCount());
```

**Key Points:**

- Provides hierarchical thread control.
- Can set uncaught exception handlers for the group.

---

## 🟠 **Executor Framework**

For modern Java applications, **ExecutorService** manages threads efficiently.

### ✅ Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
for(int i = 1; i <= 5; i++) {
    int taskId = i;
    executor.submit(() -> System.out.println("Running task " + taskId + " by " + Thread.currentThread().getName()));
}
executor.shutdown();
```

**Key Points:**

- Handles thread pool creation and task execution.
- Reduces thread creation overhead.
- Supports `Callable` for tasks returning results.

---

## 🟤 **Best Practices & Interview Tips**

1. Prefer **ExecutorService** over manual thread management.
2. Avoid long-running tasks in the main thread.
3. Properly handle **thread interruptions and exceptions**.
4. Use **daemon threads** for background jobs.
5. Use **thread groups** to organize and monitor threads.

### ✅ Common Interview Questions:

- How to manage multiple threads efficiently in Java?
- Explain thread priorities and scheduling.
- Difference between daemon and user threads.
- How does ExecutorService improve thread management?

---

Thread management is crucial for writing **scalable, maintainable, and efficient multithreaded applications**. Mastering these concepts is highly valuable for interviews and real-world Java systems.

**Page Count:** 4-5 pages with examples and best practices.

---

> 📌 Next Steps: Provide the **next topic/question**, such as **Thread Synchronization or Locks**, and I will continue expanding the advanced Java guide.

