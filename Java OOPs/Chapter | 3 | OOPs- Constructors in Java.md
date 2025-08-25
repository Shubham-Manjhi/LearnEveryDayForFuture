# 🔑 **OOPs: Constructors in Java**

---

## 🧩 **Introduction to Constructors**

In **Object-Oriented Programming (OOP)** with Java, a **constructor** is a special method that is used to **initialize objects**. It is called automatically at the time of object creation and sets up initial values for the object’s attributes.

Unlike regular methods:

- A constructor has the **same name as the class**.
- It **does not have a return type**, not even `void`.
- It is automatically invoked when an object is created with the `new` keyword.

---

## 🏷️ **Why Constructors are Important?**

- Ensures **automatic initialization** of objects.
- Helps in **overloading** to provide multiple ways of initializing objects.
- Makes the code **cleaner and more readable** compared to using separate setter methods.

---

## 🛠️ **Types of Constructors in Java**

### 1️⃣ Default Constructor

- Provided by the compiler if no constructor is explicitly defined.
- Initializes instance variables with **default values**.

```java
class Bike {
    String brand;
    int speed;

    // Default Constructor
    Bike() {
        brand = "Unknown";
        speed = 0;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed);
    }
}

public class DefaultConstructorExample {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.display();
    }
}
```

**Output:**

```
Brand: Unknown, Speed: 0
```

---

### 2️⃣ Parameterized Constructor

- Allows passing parameters to initialize objects with **custom values**.

```java
class Car {
    String brand;
    int year;

    // Parameterized Constructor
    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void display() {
        System.out.println("Car: " + brand + ", Year: " + year);
    }
}

public class ParameterizedConstructorExample {
    public static void main(String[] args) {
        Car c1 = new Car("Tesla", 2023);
        Car c2 = new Car("Toyota", 2020);

        c1.display();
        c2.display();
    }
}
```

**Output:**

```
Car: Tesla, Year: 2023
Car: Toyota, Year: 2020
```

---

### 3️⃣ Copy Constructor (User-defined)

- Java does not provide a built-in copy constructor.
- We can create one manually to copy values from another object.

```java
class Student {
    String name;
    int age;

    // Parameterized Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class CopyConstructorExample {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 21);
        Student s2 = new Student(s1); // Copy values from s1

        s1.display();
        s2.display();
    }
}
```

**Output:**

```
Alice - 21
Alice - 21
```

---

## 🧾 **Constructor Overloading**

Constructors can be **overloaded** (multiple constructors with different parameter lists).

```java
class Employee {
    String name;
    int age;

    // Default Constructor
    Employee() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized Constructor
    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class ConstructorOverloadingExample {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("John", 30);

        e1.display();
        e2.display();
    }
}
```

**Output:**

```
Unknown - 0
John - 30
```

---

## 🧠 **Important Rules of Constructors**

- If no constructor is defined, Java provides a **default constructor**.
- A constructor **cannot be abstract, static, final, or synchronized**.
- A class can have multiple constructors (overloading).
- If a parameterized constructor is defined, the **default constructor is not provided automatically**.

---

## 🎤 **Interview Questions on Constructors**

**Q1: What is the difference between constructor and method?**

- Constructor initializes an object, has no return type, and is called automatically.
- Method performs actions and requires explicit calling.

**Q2: Can a constructor be private?**

- Yes, commonly used in **Singleton Design Pattern**.

**Q3: Can constructors be overloaded?**

- Yes, multiple constructors with different parameter lists are allowed.

**Q4: What happens if we define only a parameterized constructor?**

- The compiler does not provide a default constructor. You must define it manually if needed.

**Q5: Can we call one constructor from another?**

- Yes, using the `` keyword.

---

## 🏆 **Conclusion**

Constructors in Java are essential for **object initialization**. With different types like **default, parameterized, and copy constructors**, they provide flexibility in creating objects with varied initial states. Understanding constructors is critical for mastering **OOP principles and design patterns**.

---

✨ This completes the **detailed guide on Constructors in Java with examples & interview Q&A**.

