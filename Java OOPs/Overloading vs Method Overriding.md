# 🎯 OOPs Concept: Method Overloading vs Method Overriding

---

## 🔹 **Introduction**

In Java, **Polymorphism** is one of the most important OOPs concepts, and it comes in two main types:

- **Compile-time polymorphism** → Method Overloading
- **Runtime polymorphism** → Method Overriding

Both are used to achieve flexibility and reusability in code, but they differ in their behavior, purpose, and execution.

---

## ⚡ **Method Overloading (Compile-time Polymorphism)**

📌 **Definition:** When two or more methods in the same class have the **same name** but **different parameter lists (number, type, or order)**, it is called **method overloading**.

✅ **Key Points:**

- Happens **within the same class**.
- Return type can be same or different, but parameters **must** be different.
- Occurs at **compile-time** (decided by compiler).
- Improves **readability** and **code reusability**.

📌 **Example:**

```java
class Calculator {
    // Method with 2 int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with 3 int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with double parameters
    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(10, 20));       // Calls 1st method
        System.out.println(calc.add(10, 20, 30));   // Calls 2nd method
        System.out.println(calc.add(5.5, 6.5));     // Calls 3rd method
    }
}
```

---

## ⚡ **Method Overriding (Runtime Polymorphism)**

📌 **Definition:** When a **subclass** provides its own implementation of a method that is already defined in its **parent class**, it is called **method overriding**.

✅ **Key Points:**

- Must be **inherited** from parent class.
- Method name, parameters, and return type must be **exactly same**.
- Only **access modifiers** can be changed (but not narrowed).
- Occurs at **runtime** (decided by JVM).
- Supports **dynamic polymorphism**.

📌 **Example:**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Overriding the method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();  // Runtime polymorphism
        Animal a2 = new Cat();

        a1.sound();  // Dog barks
        a2.sound();  // Cat meows
    }
}
```

---

## 📊 **Difference Between Method Overloading and Method Overriding**

| Feature               | Method Overloading                      | Method Overriding                            |
| --------------------- | --------------------------------------- | -------------------------------------------- |
| **Polymorphism Type** | Compile-time                            | Runtime                                      |
| **Class Involved**    | Within same class                       | Requires inheritance (subclass & superclass) |
| **Parameters**        | Must be different                       | Must be same                                 |
| **Return Type**       | Can be different (if parameters differ) | Must be same (or covariant)                  |
| **Access Modifier**   | Can be anything                         | Cannot be more restrictive than parent       |
| **Static Methods**    | Can be overloaded                       | Cannot be overridden (can only be hidden)    |
| **Execution**         | Decided at compile-time                 | Decided at runtime                           |

---

## 📝 **Conclusion**

- **Overloading** → Same method name, different parameter list, compile-time decision.
- **Overriding** → Same method signature in subclass, runtime decision.

👉 Together, they make Java more flexible, readable, and object-oriented.

---

