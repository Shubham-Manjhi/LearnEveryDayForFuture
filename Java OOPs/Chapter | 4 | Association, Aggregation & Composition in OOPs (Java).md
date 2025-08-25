# 🎯 Association, Aggregation & Composition in OOPs (Java)

---

## 🏷️ **Main Topic: Association, Aggregation, and Composition in OOP**

Object-Oriented Programming (OOP) provides multiple ways to establish relationships between classes. These relationships define **how objects communicate and depend on each other**. In Java, the most common types of relationships are:

- **Association**
- **Aggregation**
- **Composition**

Understanding these is crucial for system design and Java interviews.

---

# 🌐 **Association**

### 📌 Definition:

Association represents a **relationship between two separate classes** that is established through their objects. It describes how two or more classes are related but still independent.

- It is a **Has-A relationship**.
- Association can be **unidirectional** or **bidirectional**.

### ✅ Example in Java:

```java
class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Dr. Smith");
        Student student = new Student("Shubham");

        // Association (teacher teaches student)
        System.out.println(teacher.name + " teaches " + student.name);
    }
}
```

### 📌 Key Points:

- Association shows **relationship**, not ownership.
- Both objects can exist **independently**.

### 🔑 Real-life Example:

- A **Bank** and an **Employee**.
- An **Author** and a **Book**.

---

# 🧩 **Aggregation**

### 📌 Definition:

Aggregation is a **special type of Association** where one class is a **container** for another class, but both can **exist independently**.

- Known as a **Has-A relationship** (weak association).
- It represents a **whole-part relationship** but without ownership.
- If the container object is destroyed, contained objects can still exist.

### ✅ Example in Java:

```java
class Address {
    String city, state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}

class Employee {
    String name;
    Address address; // Aggregation

    Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(name + " lives in " + address.city + ", " + address.state);
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Address addr = new Address("Delhi", "India");
        Employee emp = new Employee("Shubham", addr);
        emp.display();
    }
}
```

### 📌 Key Points:

- Aggregation implies **ownership** but not strong lifecycle dependency.
- Useful in **reusing objects**.

### 🔑 Real-life Example:

- A **Library** has **Books** (Books can exist without Library).
- A **Department** has **Professors**.

---

# 🏗️ **Composition**

### 📌 Definition:

Composition is a **stronger form of Aggregation** where the contained objects **cannot exist without the container**.

- Known as **Part-Of relationship** (strong association).
- If the container object is destroyed, contained objects are also destroyed.
- Represents **ownership**.

### ✅ Example in Java:

```java
class Engine {
    void start() {
        System.out.println("Engine starts...");
    }
}

class Car {
    private Engine engine; // Composition

    Car() {
        engine = new Engine(); // Engine created inside Car
    }

    void startCar() {
        engine.start();
        System.out.println("Car is running...");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
```

### 📌 Key Points:

- Composition represents **ownership + lifecycle dependency**.
- Strong relationship compared to Aggregation.

### 🔑 Real-life Example:

- A **House** has **Rooms** (if house is destroyed, rooms do not exist).
- A **Car** has an **Engine**.

---

# ⚖️ **Association vs Aggregation vs Composition**

| Feature        | Association          | Aggregation                       | Composition                         |
| -------------- | -------------------- | --------------------------------- | ----------------------------------- |
| **Type**       | General relationship | Whole-Part (weak)                 | Whole-Part (strong)                 |
| **Dependency** | Independent objects  | Contained object can exist alone  | Contained object cannot exist alone |
| **Ownership**  | No ownership         | Has ownership but weak dependency | Strong ownership + dependency       |
| **Example**    | Teacher – Student    | Library – Books                   | Car – Engine                        |

---

# 🎤 **Interview Questions & Answers**

### ❓ Q1. What is the difference between Association, Aggregation, and Composition?

**Answer:**

- **Association**: General relationship, independent objects.
- **Aggregation**: Has-A relationship, but independent lifecycle.
- **Composition**: Strong Has-A, dependent lifecycle.

### ❓ Q2. Can Aggregation be considered a special form of Association?

**Answer:** Yes, Aggregation is a specialized form of Association with a whole-part relationship.

### ❓ Q3. Which is stronger – Aggregation or Composition?

**Answer:** Composition is stronger because the child object cannot exist without the parent.

### ❓ Q4. Give a real-world example of Aggregation vs Composition.

**Answer:**

- Aggregation: University and Students (students can exist without university).
- Composition: Human and Heart (heart cannot exist without human).

### ❓ Q5. Why is Composition preferred over Inheritance?

**Answer:**

- Promotes **code reuse**.
- Avoids **tight coupling**.
- More **flexible** since behavior can be changed at runtime.

---

# 🚀 **Conclusion**

- **Association** is the base relationship.
- **Aggregation** is a weak ownership relationship.
- **Composition** is a strong ownership relationship.

👉 Understanding these concepts is crucial for designing maintainable and scalable systems in Java.

---

