# ⚡ **Thread & Lifecycle in Java**

Understanding **threads and their lifecycle** is fundamental to Java concurrency. A thread is a **lightweight process** that allows execution of code in parallel.

---

## ✨ **Topics Covered**

- **Thread Definition**
- **Thread States & Lifecycle**
- **Thread Methods**
- **Thread Priorities**
- **Daemon Threads**
- **Thread Example with Lifecycle Demonstration**
- **Best Practices & Interview Tips**

---

## 🟢 **Thread Definition**

A **thread** is the smallest unit of execution in a program. Java supports multithreading using the `Thread` class and `Runnable` interface.

**Advantages of Threads:**

1. Enables parallel execution
2. Improves application responsiveness
3. Efficient CPU utilization

---

## 🟡 **Thread States & Lifecycle**

A thread in Java moves through **various states** during its lifecycle:

1. **New:** Thread object is created but not started.
2. **Runnable:** Thread is ready to run; waiting for CPU scheduling.
3. **Running:** Thread is executing code.
4. **Blocked/Waiting/Timed Waiting:** Thread is paused, waiting for resources or another thread.
5. **Terminated/Dead:** Thread execution is finished.

### ✅ Example with State Printing:

```java
class LifeCycleThread extends Thread {
    public void run() {
        System.out.println(getName() + " is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " is finished");
    }
}

public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        LifeCycleThread t1 = new LifeCycleThread();
        System.out.println("State after creation: " + t1.getState()); // NEW

        t1.start();
        System.out.println("State after start: " + t1.getState()); // RUNNABLE

        t1.join();
        System.out.println("State after completion: " + t1.getState()); // TERMINATED
    }
}
```

---

## 🔵 **Thread Methods**

| Method                | Description                                                |
| --------------------- | ---------------------------------------------------------- |
| `start()`             | Starts thread execution.                                   |
| `run()`               | Contains the code executed by the thread.                  |
| `sleep(ms)`           | Pauses thread for given milliseconds.                      |
| `join()`              | Waits for thread to finish execution.                      |
| `yield()`             | Suggests thread scheduler to give chance to other threads. |
| `interrupt()`         | Interrupts a thread.                                       |
| `setName()/getName()` | Sets or gets thread name.                                  |

### ✅ Example:

```java
Thread t = new Thread(() -> System.out.println("Hello from thread"));
t.setName("WorkerThread");
t.start();
System.out.println(t.getName());
```

---

## 🟣 **Thread Priorities**

Threads have priorities that influence **CPU scheduling**:

- `Thread.MIN_PRIORITY` = 1
- `Thread.NORM_PRIORITY` = 5
- `Thread.MAX_PRIORITY` = 10

### ✅ Example:

```java
Thread t1 = new Thread(() -> System.out.println("Low priority"));
Thread t2 = new Thread(() -> System.out.println("High priority"));

t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.MAX_PRIORITY);

t1.start(); t2.start();
```

> Note: Thread priority is a suggestion; actual scheduling depends on JVM and OS.

---

## 🟠 **Daemon Threads**

Daemon threads are **background threads** that do not prevent JVM from exiting. Examples include garbage collector, timer tasks.

### ✅ Example:

```java
Thread daemonThread = new Thread(() -> {
    while(true) {
        System.out.println("Daemon running");
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }
});
daemonThread.setDaemon(true);
daemonThread.start();
System.out.println("Main thread finished");
```

- Once the main thread finishes, JVM terminates daemon threads automatically.

---

## 🟢 **Thread Example with Lifecycle Demonstration**

```java
class DemoThread extends Thread {
    public void run() {
        System.out.println(getName() + " is in RUNNING state");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted");
        }
        System.out.println(getName() + " is TERMINATED");
    }
}

public class ThreadDemoMain {
    public static void main(String[] args) throws InterruptedException {
        DemoThread t1 = new DemoThread();
        System.out.println(t1.getName() + " state: " + t1.getState());
        t1.start();
        t1.join();
          System.out.println(t1.getName() + " final state: " + t1.getState());
    }
}
```

---

## 🟠 **Best Practices & Interview Tips**

1. Prefer **Runnable** or **Callable** over extending Thread.
2. Avoid using **sleep()** for synchronization.
3. Use **join()** to wait for thread completion safely.
4. Keep daemon threads for background tasks only.
5. Be aware of thread states and transitions; often asked in interviews.

### ✅ Common Interview Questions:

- Explain the **thread lifecycle with states**.
- Difference between **user threads** and **daemon threads**.
- How `join()`, `sleep()`, and `yield()` work.

---

Thread lifecycle is a **crucial concept for multithreading interviews**. Understanding it thoroughly ensures better design and debugging in concurrent applications.

**Page Count:** 4-5 pages with explanations and examples.

---

> 📌 Next Steps: Provide the **next topic/question** for the advanced Java guide, and I will continue building the detailed `.md` documentation.

