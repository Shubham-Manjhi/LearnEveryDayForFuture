# 🎯 **Java Object-Oriented Programming (OOP) Concepts**

---

## 🧩 **Introduction to OOP in Java**

Object-Oriented Programming (OOP) is a **programming paradigm** based on the concept of **objects**, which can contain **data** (fields/attributes) and **methods** (functions/behavior).

Java is a **pure object-oriented language** (with a few primitive exceptions) that supports all major OOP principles:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

These principles make Java **modular, reusable, flexible, and scalable**, making it one of the most popular languages in enterprise applications.

---

## 🔒 **Encapsulation**

### 📌 Definition

Encapsulation is the process of **wrapping data (variables) and methods (functions)** into a single unit, i.e., a **class**. It restricts direct access to some components using **access modifiers**.

### ✅ Key Points

- Achieved by making fields **private** and providing **public getters and setters**.
- Improves **data security** and **code maintainability**.
- Ensures **controlled access** to data.

### 💻 Example in Java

```java
class BankAccount {
    private double balance; // private variable (hidden data)

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Getter method
    public double getBalance() {
        return balance;
    }

    // Setter method with validation
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());
    }
}
```

### 🎤 Interview Question

**Q: Why do we use encapsulation in Java?**\
👉 To ensure **data hiding**, **security**, and **controlled access** to fields.

---

## 🧬 **Inheritance**

### 📌 Definition

Inheritance is the mechanism by which one class (child/subclass) can **acquire properties and behavior** of another class (parent/superclass).

### ✅ Key Points

- Promotes **code reusability**.
- Supports **hierarchical relationships**.
- Types: **Single, Multilevel, Hierarchical, Hybrid (through interfaces)**.
- Java does **not support multiple inheritance with classes** (to avoid ambiguity), but supports it with **interfaces**.

### 💻 Example in Java

```java
class Vehicle {   // Parent class
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {   // Child class
    void drive() {
        System.out.println("Car is driving");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();   // Inherited method
        car.drive();   // Child method
    }
}
```

### 🎤 Interview Question

**Q: Why doesn’t Java support multiple inheritance using classes?**\
👉 To avoid the **Diamond Problem** (ambiguity when two parent classes have the same method).

---

## 🎭 **Polymorphism**

### 📌 Definition

Polymorphism means **many forms**. In Java, it allows one entity (method/operator) to behave differently in different scenarios.

### ✅ Types

1. **Compile-time Polymorphism (Method Overloading)**
2. **Runtime Polymorphism (Method Overriding)**

### 💻 Example: Method Overloading (Compile-time)

```java
class MathUtils {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        MathUtils utils = new MathUtils();
        System.out.println(utils.add(2, 3));
        System.out.println(utils.add(2.5, 3.5));
    }
}
```

### 💻 Example: Method Overriding (Runtime)

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Animal a = new Dog(); // Runtime polymorphism
        a.sound();
    }
}
}
```

### 🎤 Interview Question

**Q: Difference between Overloading and Overriding?**

- Overloading: Same method name, different parameters (compile-time).
- Overriding: Same method signature in parent & child class (runtime).

---

## 🕵️ **Abstraction**

### 📌 Definition

Abstraction is the process of **hiding implementation details** and showing only **essential features**.

### ✅ Key Points

- Achieved using **abstract classes** and **interfaces**.
- Helps achieve **loose coupling**.

### 💻 Example with Abstract Class

```java
abstract class Shape {
    abstract void draw(); // abstract method
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Shape shape = new Circle(); // reference of abstract class
        shape.draw();
    }
}
```

### 💻 Example with Interface

```java
interface Payment {
    void pay(int amount);
}

class CreditCardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.pay(5000);
    }
}
```

### 🎤 Interview Question

**Q: Difference between Abstract Class and Interface?**

- Abstract Class: Can have both **abstract & concrete methods**.
- Interface: Supports **multiple inheritance** and has only **abstract methods (till Java 7)**; from Java 8+, supports **default & static methods**.

---

## ⚡ **Other OOP Concepts in Java**

### 1. **Class & Object**

- **Class**: Blueprint/template of an object.
- **Object**: Instance of a class.

### 2. **Constructor**

- Special method used to initialize an object.
- Types: Default, Parameterized, Copy Constructor.

### 3. **Association, Aggregation, Composition**

- **Association**: Simple relationship (e.g., teacher-student).
- **Aggregation**: "Has-a" weak relationship.
- **Composition**: Strong ownership (object cannot exist without the other).

### 4. **Static Keyword**

- Belongs to **class rather than object**.
- Static variables, methods, and blocks are widely used in OOP.

---

## 🏆 **Conclusion**

Java OOP principles — **Encapsulation, Inheritance, Polymorphism, and Abstraction** — form the **foundation of modern enterprise applications**. Mastering these ensures strong **design patterns, maintainability, and scalability**.

**Interview Tip 🎤:** Always support your answers with **examples** and highlight **real-world analogies** (e.g., Car is a Vehicle → Inheritance, Bank Account → Encapsulation).

---

✨ This completes our **6+ page detailed guide on Java OOP Concepts with examples & interview Q&A**.

