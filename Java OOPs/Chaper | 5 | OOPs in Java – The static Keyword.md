# 🖥️ **OOPs in Java – The **``** Keyword**

---

## 🎯 **Topics Covered**

1. Introduction to `static`
2. Static Variables
3. Static Methods
4. Static Blocks
5. Static Nested Classes
6. Memory Allocation of `static`
7. Rules & Restrictions of `static`
8. Real-life Examples
9. Interview Questions & Answers

---

# 🌟 **1. Introduction to **``

- The `static` keyword in Java is a **non-access modifier** used for **memory management**.
- It can be applied to:
  - **Variables** (class variables)
  - **Methods** (class methods)
  - **Blocks** (static initialization)
  - **Nested Classes**
- Belongs to the **class**, not an object.
- Loaded into memory **once per class**, not per object.

👉 **Key Idea:** Anything declared `static` is **shared among all objects** of that class.

---

# 📦 **2. Static Variables (Class Variables)**

- Declared with the keyword `static` inside a class.
- Shared across all instances (objects).
- Memory allocated **once** when the class is loaded.

```java
class Counter {
    static int count = 0; // static variable

    Counter() {
        count++;
        System.out.println("Object created, Count: " + count);
    }

    public static void main(String[] args) {
        new Counter();
        new Counter();
        new Counter();
    }
}
```

**Output:**

```
Object created, Count: 1
Object created, Count: 2
Object created, Count: 3
```

👉 **Without **``, count would always reset to `1`.

---

# ⚙️ **3. Static Methods**

- Declared with the keyword `static`.
- Can be called **without creating an object**.
- Can **access static variables directly**, but **not non-static variables**.

```java
class MathUtil {
    static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        System.out.println("Square: " + MathUtil.square(5));
    }
}
```

👉 **Rule:** `static` methods cannot use `this` or `super`.

---

# 🧱 **4. Static Blocks**

- Used for **initialization of static variables**.
- Executes only **once** when the class is loaded into memory.

```java
class Demo {
    static int value;

    // static block
    static {
        value = 50;
        System.out.println("Static Block Executed!");
    }

    public static void main(String[] args) {
        System.out.println("Value: " + value);
    }
}
```

**Output:**

```
Static Block Executed!
Value: 50
```

---

# 🏗️ **5. Static Nested Classes**

- A class declared `static` inside another class.
- Can access **static members of the outer class**.
- Does not require an object of the outer class.

```java
class Outer {
    static int data = 100;

    static class Inner {
        void display() {
            System.out.println("Data: " + data);
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.display();
    }
}
```

---

# 🧠 **6. Memory Allocation of **``

- Stored in **Method Area (Class Area)** of JVM.
- Unlike instance variables, only **one copy** exists.
- Loaded during **class loading**, before any object is created.

Diagram:

```
Method Area:
   └── static variable (shared)
Heap:
   └── objects with instance variables
```

---

# 📜 **7. Rules & Restrictions of **``

✅ Allowed:

- Static methods can directly access other static members.
- Static variables are initialized only once.

❌ Restrictions:

- `static` methods cannot access **non-static variables/methods** directly.
- Cannot use `this` and `super` in static context.
- Overriding of static methods = **Method Hiding**, not true overriding.

---

# 🌍 **8. Real-life Examples**

### Example 1: Utility Class

```java
class MathLibrary {
    public static double PI = 3.14159;

    public static double areaOfCircle(double r) {
        return PI * r * r;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(MathLibrary.areaOfCircle(5));
    }
}
```

### Example 2: Singleton with Static

```java
class Singleton {
    private static Singleton instance;

    private Singleton() {} // private constructor

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

# ❓ **9. Interview Questions & Answers**

**Q1. What is the purpose of the **``** keyword?**

- Used for memory management, ensures members are class-level rather than object-level.

**Q2. Can we override static methods?**

- No. They are hidden, not overridden (method hiding).

**Q3. Can we access non-static members inside a static method?**

- No, because non-static members belong to objects, and static context loads before object creation.

**Q4. When is a static block executed?**

- When the class is loaded into JVM, before `main()`.

**Q5. Why can’t we use **``** inside static methods?**

- Because `this` refers to the current object, but static belongs to the class, not the object.

**Q6. What happens if we declare a constructor as static?**

- Not allowed. Constructors are for object initialization, static is for class-level.

**Q7. Where is static data stored in JVM?**

- Method Area (Class Area).

---

# ✅ **Summary**

- `static` is a keyword for class-level memory management.
- Used with variables, methods, blocks, and nested classes.
- Helps in writing **utility methods, constants, and design patterns**.
- Must be used wisely, otherwise can break OOP principles.

---

