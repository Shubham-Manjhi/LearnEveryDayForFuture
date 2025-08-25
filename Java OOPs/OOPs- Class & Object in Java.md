# 🏗️ **OOPs: Class & Object in Java**

---

## 🧩 **Introduction to Class & Object**

In **Object-Oriented Programming (OOP)**, the two most fundamental concepts are **Class** and **Object**.

- A **Class** is a **blueprint or template** that defines the structure and behavior (fields and methods) of objects.
- An **Object** is a **real-world entity** and an **instance of a class** created in memory at runtime.

Java applications are essentially a collection of **objects that interact** with each other.

---

## 🏷️ **Class in Java**

### 📌 Definition

A **Class** in Java is a user-defined data type that acts as a **blueprint** for creating objects. It encapsulates **data members (variables)** and **methods (functions)** that operate on the data.

### ✅ Key Points

- Declared using the \`\`\*\* keyword\*\*.
- Can contain **fields, methods, constructors, nested classes, and blocks**.
- Can be public, default (package-private), abstract, final.

### 💻 Example

```java
class Car {
    // Data members (fields)
    String brand;
    int year;

    // Constructor
    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Method
    void displayDetails() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}
```

---

## 🚗 **Object in Java**

### 📌 Definition

An **Object** is a **runtime instance of a class**. When a class is instantiated using the \`\`\*\* keyword\*\*, an object is created in the heap memory.

### ✅ Key Points

- Objects occupy **memory**.
- Each object has **identity, state, and behavior**.
  - **Identity**: Unique reference.
  - **State**: Values of its attributes.
  - **Behavior**: Methods that can be invoked.

### 💻 Example

```java
public class ObjectExample {
    public static void main(String[] args) {
        // Creating objects of Car class
        Car car1 = new Car("Toyota", 2020);
        Car car2 = new Car("Tesla", 2023);

        // Accessing object methods
        car1.displayDetails();
        car2.displayDetails();
    }
}
```

**Output:**

```
Brand: Toyota, Year: 2020
Brand: Tesla, Year: 2023
```

---

## 🛠️ **How to Create Objects in Java**

1. **Using ****\`\`**** keyword (most common)**

```java
Car car = new Car("BMW", 2021);
```

2. **Using ****\`\`**** and Reflection**

```java
Car car = (Car) Class.forName("Car").newInstance();
```

3. **Using ****\`\`**** method** (when class implements `Cloneable`)

```java
Car car2 = (Car) car1.clone();
```

4. **Using Object Deserialization** (from file/stream)

---

## 🧾 **Memory Representation of Class & Object**

- **Class**: Stored in **method area** of JVM.
- **Object**: Stored in **heap memory**.
- **Reference variable**: Stored in **stack memory**.

Example:

```java
Car car = new Car("Audi", 2022);
```

- `car` → reference variable in stack.
- `new Car("Audi", 2022)` → object in heap.
- Class `Car` → loaded in method area.

---

## 🔑 **Constructors in Class & Object Creation**

- Special methods used to **initialize objects**.
- Same name as the class.
- No return type.

### Types of Constructors

1. **Default Constructor** (automatically provided if no constructor is defined).
2. **Parameterized Constructor** (accepts arguments).
3. **Copy Constructor** (not built-in, but can be user-defined).

### Example

```java
class Student {
    String name;
    int age;

    // Default Constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Alice", 20);

        s1.display();
        s2.display();
    }
}
```

**Output:**

```
Unknown - 0
Alice - 20
```

---

## 🎤 **Interview Questions on Class & Object**

**Q1: What is the difference between Class and Object?**

- Class: Blueprint/template.
- Object: Instance of a class.

**Q2: Can we create multiple objects from one class?**

- Yes, a class can have multiple instances with different states.

**Q3: What is the default value of object reference in Java?**

- `null` if not initialized.

**Q4: Difference between **``** in object comparison?**

- `==` compares **references**.
- `equals()` compares **values** (if overridden).

**Q5: Can a class exist without objects?**

- Yes, static methods and fields can be accessed without objects.

---

## 🏆 **Conclusion**

- **Class** = Blueprint.
- **Object** = Instance created from class.
- Objects give life to classes in runtime.
- Understanding **class-object relationship** is the foundation for mastering **OOP in Java**.

---

✨ This completes the **detailed guide on Class & Object in Java with examples & interview Q&A**.

