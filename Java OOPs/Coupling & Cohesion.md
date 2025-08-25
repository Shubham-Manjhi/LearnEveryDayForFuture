# 🔗 OOPs Concept: Coupling & Cohesion

---

## 🔹 Introduction
In Object-Oriented Programming, **Coupling** and **Cohesion** are important principles for designing robust, maintainable, and scalable systems. They measure how classes and modules interact with each other and how focused a class/module is.

- **Cohesion**: Measures how **related and focused the responsibilities** of a single class/module are.
- **Coupling**: Measures how **dependent one class/module is on another**.

High cohesion and low coupling are considered best practices in OOPs design.

---

## ⚡ Cohesion

📌 **Definition:**
Cohesion refers to the **degree to which the elements of a class/module belong together**. A highly cohesive class has a **single responsibility** and performs all tasks related to that responsibility.

### ✅ Key Points:
- **High cohesion** is desirable.
- Each class should have **a focused responsibility**.
- Improves **maintainability, readability, and reusability**.
- Low cohesion leads to **complex, hard-to-maintain code**.

### 💻 Example: High Cohesion
```java
class Invoice {
    void calculateTotal() {
        // logic to calculate total
    }

    void printInvoice() {
        // logic to print invoice
    }
}
```
- **Invoice class** has a focused responsibility: handling invoices.

### 💻 Example: Low Cohesion
```java
class Utility {
    void calculateTotal() {}
    void printInvoice() {}
    void sendEmail() {}
    void generateReport() {}
}
```
- **Utility class** handles multiple unrelated tasks → low cohesion.

---

## ⚡ Coupling

📌 **Definition:**
Coupling refers to the **degree of dependency between classes/modules**. Lower coupling is better because **changes in one class minimally affect others**.

### ✅ Types of Coupling:
1. **Tight Coupling**: Classes/modules are heavily dependent on each other.
2. **Loose Coupling**: Classes/modules have minimal dependencies and interact through interfaces or abstractions.

### 💻 Example: Tight Coupling
```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    Engine engine = new Engine(); // Car depends directly on Engine
    void startCar() {
        engine.start();
    }
}
```
- **Car** is tightly coupled with **Engine** → Hard to replace or test.

### 💻 Example: Loose Coupling
```java
interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

class Car {
    Engine engine;  // depends on interface, not concrete class

    Car(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new PetrolEngine();
        Car car = new Car(engine);
        car.startCar();
    }
}
```
- **Car** is loosely coupled → Can work with any engine implementing the interface.

---

## 📊 Differences Between Coupling and Cohesion

| Feature          | Cohesion                               | Coupling                                   |
|------------------|----------------------------------------|-------------------------------------------|
| Definition       | Degree of relatedness within a class   | Degree of dependency between classes      |
| Goal             | Focused, single responsibility         | Minimal dependency                        |
| High/Low         | High cohesion is good                  | Low coupling is good                        |
| Effect           | Better maintainability & readability  | Better flexibility & reusability         |
| Example          | Invoice class focusing on invoice tasks| Car depending on Engine interface        |

---

## 🚀 Conclusion
- **High Cohesion** → Each class/module does one task well.
- **Low Coupling** → Classes/modules depend minimally on each other.
- Following these principles ensures **clean, maintainable, and scalable OOPs design**.

---

🔥 Real-life analogy:
- **Cohesion**: A restaurant chef specializes in cooking → focused skill.
- **Coupling**: The chef uses standardized kitchen tools (interface) instead of being tightly bound to a specific brand → flexible and replaceable.

