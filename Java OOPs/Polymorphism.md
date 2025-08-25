# 🧩 OOPs Concept: **Polymorphism**

---

## 🎯 Introduction to Polymorphism

Polymorphism is one of the four main pillars of Object-Oriented Programming (OOP). The word **Polymorphism** means *"many forms"*. It allows objects to be represented in multiple forms depending on the context.

In Java, polymorphism enables a single action to behave differently based on the object that invokes it.

➡️ **Example in real life:** The word *"run"* can mean different things depending on context:

- A person runs 🏃
- A car engine runs 🚗
- A program runs 💻

---

## ⚡ Types of Polymorphism in Java

### 🔹 Compile-Time Polymorphism (Static Polymorphism)

- Achieved by **Method Overloading**.
- The method resolution happens at **compile time**.
- Same method name, but **different parameter list** (number or type of arguments).

✅ **Example: Method Overloading**

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));     // calls int version
        System.out.println(calc.add(5.5, 10.5)); // calls double version
    }
}
```

---

### 🔹 Runtime Polymorphism (Dynamic Polymorphism)

- Achieved by **Method Overriding**.
- The method resolution happens at **runtime**.
- Child class provides a **specific implementation** of a method already defined in parent class.

✅ **Example: Method Overriding**

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

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound(); // Dog barks
        a2.sound(); // Cat meows
    }
}
```

---

## 🛠️ Key Characteristics of Polymorphism

- Same interface, different implementations.
- Helps achieve **code reusability**.
- Reduces code complexity.
- Increases flexibility and maintainability.

---

## 📌 Advantages of Polymorphism

- **Flexibility**: One interface, multiple implementations.
- **Reusability**: Common code structure used for different objects.
- **Maintainability**: Easy to extend and modify code.
- **Readability**: Code is more natural and intuitive.

---

## 🗂️ Real-Life Examples

- **Payment System**: Payment can be made using a card, UPI, or net banking, but all are treated as a *Payment*.
- **Shape Example**: Circle, Rectangle, and Triangle all extend *Shape* class and implement their own `draw()` method.

---

## 🎤 Common Interview Questions

❓ What is polymorphism in Java? ➡️ It is the ability of a method or object to take many forms, allowing the same method name to perform different tasks depending on the context.

❓ Difference between overloading and overriding?

- **Overloading** → Compile-time, different parameter list, same class.
- **Overriding** → Runtime, same method signature, different class (inheritance).

❓ Can constructors be overloaded? ➡️ Yes ✅

❓ Can constructors be overridden? ➡️ No ❌

---

## 🚀 Conclusion

Polymorphism is a powerful OOPs concept that makes Java flexible and extensible. By supporting both **compile-time (overloading)** and **runtime (overriding)** polymorphism, it allows developers to write clean, reusable, and scalable code.

