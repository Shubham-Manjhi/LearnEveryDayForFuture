# 🎨 **Object-Oriented Programming (OOPs) in Java**

---

## 🌀 **OOPs Concept: Abstraction**

---

### 🌟 **Introduction to Abstraction**

Abstraction is one of the **four main pillars** of Object-Oriented Programming (OOPs) in Java. It refers to the **process of hiding the internal implementation details** of a class and only exposing the **necessary functionalities** to the outside world.

In simple words:

- **What it does** → Shown to the user.
- **How it does** → Hidden from the user.

Example from real life: When you use a **car**, you only know how to drive it using a steering wheel, brake, and accelerator (exposed functionality). But you don’t know the complex internal engine mechanism (hidden implementation).

---

### 🎯 **Why Abstraction is Important?**

- ✅ Hides implementation details.
- ✅ Improves code security by only exposing essentials.
- ✅ Provides flexibility to change code internally without affecting external code.
- ✅ Enhances maintainability and reduces complexity.
- ✅ Supports achieving loose coupling in code.

---

## 📚 **Ways to Achieve Abstraction in Java**

Java provides **two ways** to achieve abstraction:

### 1️⃣ **Abstract Class**

- Declared using the `abstract` keyword.
- Can have **abstract methods** (without body) and **concrete methods** (with body).
- Cannot be instantiated directly.
- A subclass must provide implementations for the abstract methods.

### 2️⃣ **Interface**

- Declared using the `interface` keyword.
- All methods are implicitly **abstract** (before Java 8).
- From **Java 8 onwards**, interfaces can also have **default** and **static methods**.
- A class can **implement multiple interfaces**.

---

## 🧑‍💻 **Example of Abstraction using Abstract Class**

```java
// Abstract class
abstract class Shape {
    // Abstract method (no body)
    abstract void draw();

    // Concrete method
    void info() {
        System.out.println("This is a shape");
    }
}

// Subclass 1
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Subclass 2
class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Main class
public class AbstractionDemo {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();

        shape1.draw();
        shape2.draw();
        shape1.info();
    }
}
```

**Output:**

```
Drawing a Circle
Drawing a Rectangle
This is a shape
```

---

## 🧑‍💻 **Example of Abstraction using Interface**

```java
// Interface
interface Animal {
    void sound(); // abstract method
}

// Class implementing interface
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.sound();
        cat.sound();
    }
}
```

**Output:**

```
Dog barks
Cat meows
```

---

## 🖼️ **Difference Between Abstract Class & Interface**

| Feature              | Abstract Class                             | Interface                              |
| -------------------- | ------------------------------------------ | -------------------------------------- |
| Keyword              | `abstract`                                 | `interface`                            |
| Methods              | Both abstract and concrete methods         | Only abstract (till Java 7)            |
| Multiple Inheritance | Not supported                              | Supported (a class can implement many) |
| Access Modifiers     | Can have `public`, `protected`, etc.       | Methods are `public` by default        |
| Variables            | Can have instance & static variables       | Only `public static final` constants   |
| Use Case             | When some common functionality is required | When only abstraction is required      |

---

## 🧩 **Real-Life Examples of Abstraction in Java**

1. **ATM Machine** → You interact with buttons, not the internal software.
2. **Car** → You drive using pedals, not by handling the engine.
3. **Database Driver (JDBC)** → Provides API methods, hides database communication complexity.

---

## 💡 **Key Points About Abstraction**

- Abstraction focuses on **hiding the implementation**.
- Achieved via **Abstract Classes** and **Interfaces**.
- Helps reduce code complexity.
- Supports loose coupling and maintainability.
- Interfaces allow **multiple inheritance**.

---

## 🎤 **Common Interview Questions on Abstraction**

### Q1. What is abstraction in Java?

**Answer:** Abstraction is the process of hiding implementation details and showing only the essential features. It is achieved using abstract classes and interfaces.

### Q2. How is abstraction different from encapsulation?

**Answer:**

- **Abstraction** hides the implementation details (focuses on *what*).
- **Encapsulation** hides the data using access modifiers (focuses on *how*).

### Q3. Can we create an object of an abstract class?

**Answer:** No, abstract classes cannot be instantiated directly. They must be subclassed.

### Q4. Can an abstract class have a constructor in Java?

**Answer:** Yes, abstract classes can have constructors, and they are used to initialize fields of the abstract class.

### Q5. Which is better: Abstract class or Interface?

**Answer:** It depends on the scenario:

- Use **Abstract Class** when you want to share common code among related classes.
- Use **Interface** when you want to achieve full abstraction and multiple inheritance.

### Q6. Can an interface extend another interface?

**Answer:** Yes, an interface can extend multiple interfaces in Java.

### Q7. Can we have variables in an interface?

**Answer:** Yes, but all variables in an interface are implicitly `public static final` (constants).

---

## 🏁 **Conclusion**

Abstraction in Java is a powerful OOPs principle that allows developers to design flexible and maintainable systems by hiding unnecessary implementation details and exposing only essential behavior. By combining **abstract classes** and **interfaces**, we can build scalable and robust applications.

