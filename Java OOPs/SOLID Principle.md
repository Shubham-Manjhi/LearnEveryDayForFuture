# 🏗️ OOPs Design Principles: SOLID

---

## 🔹 Introduction

In Object-Oriented Programming, **SOLID principles** are a set of five design principles that help developers create **maintainable, scalable, and flexible software**. Following SOLID ensures **high cohesion, low coupling, and easier testing**.

**SOLID** stands for:

1. **S** - Single Responsibility Principle (SRP)
2. **O** - Open/Closed Principle (OCP)
3. **L** - Liskov Substitution Principle (LSP)
4. **I** - Interface Segregation Principle (ISP)
5. **D** - Dependency Inversion Principle (DIP)

---

## ⚡ Single Responsibility Principle (SRP)

📌 **Definition:** A class should have **only one reason to change**, meaning it should have only **one responsibility**.

### 💻 Example:

```java
class Invoice {
    void calculateTotal() {}
    void printInvoice() {}
}

// Better approach: Separate printing responsibility
class InvoicePrinter {
    void printInvoice(Invoice invoice) {}
}
```

- **Invoice** class handles calculation, **InvoicePrinter** handles printing.

---

## ⚡ Open/Closed Principle (OCP)

📌 **Definition:** Software entities (classes, modules, functions) should be **open for extension but closed for modification**.

### 💻 Example:

```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    double length, width;
    Rectangle(double l, double w) { length = l; width = w; }
    double area() { return length * width; }
}
```

- **New shapes** can be added without modifying existing code.

---

## ⚡ Liskov Substitution Principle (LSP)

📌 **Definition:** Objects of a superclass should be **replaceable with objects of its subclasses** without breaking the application.

### 💻 Example:

```java
class Bird {
    void fly() {}
}

class Sparrow extends Bird {}
class Ostrich extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}
```

- Violation of LSP occurs if a subclass cannot perform the behavior expected by the parent.

---

## ⚡ Interface Segregation Principle (ISP)

📌 **Definition:** Clients should **not be forced to depend on interfaces they do not use**. Create smaller, more specific interfaces.

### 💻 Example:

```java
interface Workable {
    void work();
}
interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() { System.out.println("Robot working"); }
}

class Human implements Workable, Eatable {
    public void work() { System.out.println("Human working"); }
    public void eat() { System.out.println("Human eating"); }
}
```

- **Robot** doesn’t implement `Eatable` → ISP respected.

---

## ⚡ Dependency Inversion Principle (DIP)

📌 **Definition:** High-level modules should **not depend on low-level modules**; both should depend on **abstractions**.

### 💻 Example:

```java
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class Notification {
    private MessageService service;
    Notification(MessageService service) { this.service = service; }
    void notifyUser(String msg) { service.sendMessage(msg); }
}

public class Main {
    public static void main(String[] args) {
        MessageService email = new EmailService();
        Notification notification = new Notification(email);
        notification.notifyUser("Hello User!");
    }
}
```

- **Notification** depends on abstraction (`MessageService`), not concrete implementation.

---

## 📊 Summary of SOLID Principles

| Principle | Purpose                                             |
| --------- | --------------------------------------------------- |
| SRP       | Single responsibility per class                     |
| OCP       | Open for extension, closed for modification         |
| LSP       | Subtypes must be substitutable for their base types |
| ISP       | Split interfaces to avoid forcing unused methods    |
| DIP       | Depend on abstractions, not concretions             |

---

## 🚀 Conclusion

- Applying SOLID principles leads to **better code maintainability, flexibility, and scalability**.
- These principles are the foundation for **clean architecture** and widely used in **enterprise-level Java applications**.

---

🔥 Real-life analogy:

- **SRP**: Each employee has a single role.
- **OCP**: New job roles can be added without changing existing roles.
- **LSP**: A substitute employee performs the same tasks as the original.
- **ISP**: Employees only follow interfaces relevant to their job.
- **DIP**: Employees depend on standard procedures, not specific tools.

