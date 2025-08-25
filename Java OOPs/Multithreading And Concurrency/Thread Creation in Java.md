# ⚡ **Thread Creation in Java**

Creating threads is fundamental to building concurrent Java applications. Java provides multiple ways to create and manage threads efficiently.

---

## ✨ **Topics Covered**

- **Extending the Thread Class**
- **Implementing Runnable Interface**
- **Using Callable and Future**
- **Using Lambda Expressions**
- **Thread Creation Examples**
- **Best Practices & Interview Tips**

---

## 🟢 **Extending the Thread Class**

You can create a thread by **extending the **``** class** and overriding its `run()` method.

### ✅ Example:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
```

**Key Points:**

- Use `start()` to initiate a thread; `run()` should not be called directly.
- Each instance of `MyThread` is a separate thread.

---

## 🟡 **Implementing Runnable Interface**

Implementing the `Runnable` interface is a **preferred approach** as it allows **extending another class** and **separates task from thread**.

### ✅ Example:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}
```

**Key Points:**

- Allows for task and thread to be decoupled.
- Supports multiple threads executing the same task.

---

## 🔵 **Using Callable and Future**

`Callable<T>` allows returning a result and throwing exceptions. `Future<T>` retrieves the result asynchronously.

### ✅ Example:

```java
import java.util.concurrent.*;

class MyTask implements Callable<Integer> {
    public Integer call() throws Exception {
        return 10 + 20;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyTask());
        System.out.println("Result: " + future.get()); // 30
        executor.shutdown();
    }
}
```

**Key Points:**

- Useful when thread needs to return a value.
- Works seamlessly with **ExecutorService**.

---

## 🟣 **Using Lambda Expressions**

Since Java 8, **lambda expressions** simplify thread creation, especially with `Runnable`.

### ✅ Example:

```java
public class LambdaThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        t1.start();
    }
}
```

**Key Points:**

- Reduces boilerplate code.
- Improves readability.

---

## 🟠 **Best Practices & Interview Tips**

1. Prefer **Runnable or Callable** over extending Thread.
2. Always use **start()** to begin thread execution.
3. For tasks that return values, use **Callable with Future**.
4. Use **lambda expressions** for concise code.
5. Understand difference between `run()` and `start()`.

### ✅ Common Interview Questions:

- Explain different ways to create a thread in Java.
- Difference between `Thread` and `Runnable`.
- When to use `Callable` over `Runnable`.
- How lambda expressions simplify thread creation.

---

Thread creation is a foundational skill for Java concurrency. Mastering all methods ensures **flexibility, readability, and scalability** in applications.

**Page Count:** 3-4 pages with examples and best practices.

---

> 📌 Next Steps: Provide the **next topic/question**, such as **Thread Synchronization**, and I will continue expanding the advanced Java guide in `.md` format.

