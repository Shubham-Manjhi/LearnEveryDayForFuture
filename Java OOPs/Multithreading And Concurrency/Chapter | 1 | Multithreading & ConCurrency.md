# ⚡ **Multithreading & Concurrency in Java**

Multithreading and concurrency are fundamental in Java to perform **multiple tasks simultaneously** and efficiently utilize CPU cores. They help in building high-performance, scalable applications.

---

## ✨ **Topics Covered**
- **Introduction to Multithreading & Concurrency**
- **Thread Lifecycle**
- **Creating Threads**
- **Synchronization & Locks**
- **Executor Framework**
- **Callable & Future**
- **Fork/Join Framework**
- **Concurrency Utilities**
- **Best Practices & Interview Tips**

---

## 🟢 **Introduction to Multithreading & Concurrency**

- **Multithreading:** Execution of multiple threads concurrently.
- **Concurrency:** Dealing with multiple tasks at once, not necessarily executing simultaneously.
- **Parallelism:** Actual simultaneous execution on multiple CPU cores.

**Advantages:**
1. Better CPU utilization
2. Improved performance in I/O and computation
3. Responsive applications

**Challenges:**
- Race conditions
- Deadlocks
- Thread interference
- Resource contention

---

## 🟡 **Thread Lifecycle**

A Java thread has the following states:
1. **New** – Thread object created but not started.
2. **Runnable** – Ready to run.
3. **Running** – Thread scheduler picks it.
4. **Waiting/Timed Waiting** – Waiting for another thread.
5. **Terminated** – Execution finished.

### ✅ Example:
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class ThreadLifeCycleDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
```

---

## 🔵 **Creating Threads**

### 1. Extending Thread class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}

public class Demo {
    public static void main(String[] args) {
        new MyThread().start();
    }
}
```

### 2. Implementing Runnable interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Running in " + Thread.currentThread().getName());
    }
}

public class DemoRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

### 3. Using Lambda expression
```java
Thread t = new Thread(() -> System.out.println("Lambda Thread: " + Thread.currentThread().getName()));
t.start();
```

---

## 🟣 **Synchronization & Locks**

**Problem:** When multiple threads access shared resources, race conditions occur.

**Solution:** Use synchronization to ensure **mutual exclusion**.

### ✅ Example with synchronized keyword:
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

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> { for(int i=0;i<1000;i++) counter.increment(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<1000;i++) counter.increment(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + counter.getCount()); // 2000
    }
}
```

### 🔐 Locks (ReentrantLock):
```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```

---

## 🟠 **Executor Framework**

Instead of manually creating threads, Java provides the **Executor Framework**.

### ✅ Example:
```java
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Task executed by: " + Thread.currentThread().getName()));
executor.shutdown();
```

---

## 🟤 **Callable & Future**

Unlike Runnable, `Callable<T>` returns a result and can throw exceptions.

### ✅ Example:
```java
Callable<Integer> task = () -> 10 * 2;
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(task);
System.out.println("Result: " + future.get()); // 20
executor.shutdown();
```

---

## 🟢 **Fork/Join Framework**

The **Fork/Join Framework** is designed for **divide-and-conquer algorithms**.

### ✅ Example:
```java
class SumTask extends RecursiveTask<Integer> {
    private int[] arr;
    private int start, end;

    SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start <= 2) {
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        }
        int mid = (start + end) / 2;
        SumTask left = new SumTask(arr, start, mid);
        SumTask right = new SumTask(arr, mid, end);
        left.fork();
        return right.compute() + left.join();
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] arr = {1,2,3,4,5,6};
        int result = pool.invoke(new SumTask(arr, 0, arr.length));
        System.out.println("Sum: " + result); // 21
    }
}
```

---

## 🔵 **Concurrency Utilities**

- `CountDownLatch` – waits until certain tasks are completed
- `CyclicBarrier` – waits until all threads reach a common barrier
- `Semaphore` – controls access to resources
- `ConcurrentHashMap` – thread-safe map

### ✅ Example with CountDownLatch:
```java
CountDownLatch latch = new CountDownLatch(3);
for (int i = 0; i < 3; i++) {
    new Thread(() -> {
        System.out.println("Thread finished: " + Thread.currentThread().getName());
        latch.countDown();
    }).start();
}
latch.await();
System.out.println("All threads finished");
```

---

## 🟠 **Best Practices & Interview Tips**

1. Prefer **ExecutorService** over manual thread management.
2. Use **volatile** for visibility but not atomicity.
3. Avoid deadlocks by ordering locks consistently.
4. Use **Concurrent Collections** instead of synchronized collections.
5. Understand difference between **synchronized**, **Lock**, and **atomic variables**.
6. Be familiar with **Fork/Join** and **CompletableFuture**.

### ✅ Common Interview Question:
**Q:** What’s the difference between `synchronized` and `ReentrantLock`?
- `synchronized` is simpler, implicit lock management.
- `ReentrantLock` provides advanced features like tryLock(), fairness, interruptibility.

---

Multithreading & Concurrency in Java are **core interview topics**. Mastering synchronization, executor services, and concurrency utilities is essential for real-world systems.

**Page Count:** 6+ (Detailed explanations, code examples, and best practices).

---

> 📌 Next Steps: Provide the **next topic/question** and I’ll continue expanding the advanced Java expert guide in the same format.

