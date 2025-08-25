# 🎓 OOPs Concept: **Inheritance in Java**

---

## 🏷️ **Topics Covered**

- 🌟 Introduction to Inheritance
- 🏛️ Types of Inheritance in Java
- 🧩 Syntax and Rules
- ⚙️ How Inheritance Works in Java
- 📦 `super` Keyword in Inheritance
- 🛠️ Constructors in Inheritance
- 📜 Method Overriding
- ❌ Multiple Inheritance Problem
- 🧮 Example Programs
- 📝 Interview Questions & Answers

---

# 🌟 **Introduction to Inheritance**

- **Definition:** Inheritance is an **OOPs mechanism** in which one class (child class) acquires the properties and behaviors (fields & methods) of another class (parent class).
- It promotes **reusability** of code and establishes a natural **IS-A relationship**.

➡️ Example: A `Dog` is an `Animal`.

---

# 🏛️ **Types of Inheritance in Java**

1. **Single Inheritance** → One parent, one child.
2. **Multilevel Inheritance** → Parent → Child → Grandchild.
3. **Hierarchical Inheritance** → One parent, multiple children.

⚠️ **Note:** Java does not support **Multiple Inheritance (class to class)** to avoid ambiguity (Diamond Problem). Instead, it is achieved using **Interfaces**.

---

# 🧩 **Syntax and Rules**

```java
class Parent {
    int value = 10;
    void display() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child class method");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.display(); // Accessing Parent method
        c.show();    // Accessing Child method
    }
}
```

✅ Output:

```
Parent class method
Child class method
```

---

# ⚙️ **How Inheritance Works in Java**

- The `` keyword is used to establish inheritance.
- Child class can **access non-private fields and methods** of the parent.
- Constructors are **not inherited**, but they are invoked implicitly.

---

# 📦 ``** Keyword in Inheritance**

- **Usage:**
  1. Access parent class variables.
  2. Access parent class methods.
  3. Call parent class constructor.

```java
class Animal {
    String color = "White";
    Animal() {
        System.out.println("Animal constructor");
    }
    void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    String color = "Black";
    Dog() {
        super(); // Calls parent constructor
        System.out.println("Dog constructor");
    }
    void eat() {
        super.eat(); // Calls parent method
        System.out.println("Dog eats");
    }
    void printColor() {
        System.out.println(super.color); // Access parent variable
        System.out.println(color);
    }
}

public class TestSuper {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.printColor();
    }
}
```

✅ Output:

```
Animal constructor
Dog constructor
Animal eats
Dog eats
White
Black
```

---

# 🛠️ **Constructors in Inheritance**

- When a child object is created, **parent constructor is called first**.
- If not explicitly called, Java inserts an implicit `super()` call in child constructor.

---

# 📜 **Method Overriding**

- Child class provides **its own implementation** of a parent class method.
- Rules:
  1. Method name must be same.
  2. Parameters must be same.
  3. Return type must be same (or covariant).
  4. Access modifier should not be more restrictive.

```java
class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {
    @Override
    void run() {
        System.out.println("Bike is running safely");
    }
}

public class MainOverride {
    public static void main(String[] args) {
        Vehicle v = new Bike(); // Runtime polymorphism
        v.run();
    }
}
```

✅ Output:

```
Bike is running safely
```

---

# ❌ **Multiple Inheritance Problem**

- If Java allowed multiple inheritance (class to class), ambiguity could occur:

```
   Class A   Class B
      \     /
       Class C
```

➡️ Which method should Class C inherit if both A and B define the same method?

👉 To avoid this **Diamond Problem**, Java supports multiple inheritance only through **Interfaces**.

---

# 🧮 **Example Programs**

### Example 1: Single Inheritance

```java
class Employee {
    float salary = 40000;
}
class Programmer extends Employee {
    int bonus = 10000;
}
public class TestInheritance {
    public static void main(String[] args) {
        Programmer p = new Programmer();
        System.out.println("Salary: " + p.salary);
        System.out.println("Bonus: " + p.bonus);
    }
}
```

### Example 2: Multilevel Inheritance

```java
class Animal { void eat(){ System.out.println("eating..."); } }
class Dog extends Animal { void bark(){ System.out.println("barking..."); } }
class Puppy extends Dog { void weep(){ System.out.println("weeping..."); } }

public class TestMultilevel {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();
        p.bark();
        p.weep();
    }
}
```

### Example 3: Hierarchical Inheritance

```java
class Animal { void eat(){ System.out.println("eating..."); } }
class Dog extends Animal { void bark(){ System.out.println("barking..."); } }
class Cat extends Animal { void meow(){ System.out.println("meowing..."); } }

public class TestHierarchical {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat(); d.bark();

        Cat c = new Cat();
        c.eat(); c.meow();
    }
}
```

---

# 📝 **Inheritance Interview Questions & Answers**

### Q1: What is inheritance in Java?

**A:** Mechanism where one class acquires properties of another using `extends` keyword.

### Q2: Why does Java not support multiple inheritance through classes?

**A:** To avoid ambiguity (Diamond Problem). Instead, Java uses **Interfaces**.

### Q3: Are constructors inherited?

**A:** No, but parent constructors are called implicitly using `super()`.

### Q4: Difference between `super()` and `this()`?

- `super()` → calls parent constructor.
- `this()` → calls another constructor in the same class.

### Q5: Can a child class override all parent methods?

**A:** No, `final`, `static`, and `private` methods cannot be overridden.

### Q6: What is runtime polymorphism in context of inheritance?

**A:** When a parent reference points to a child object and overridden method is executed at runtime.

### Q7: Difference between IS-A and HAS-A relationship?

- **IS-A:** Inheritance (`Dog` IS-A `Animal`).
- **HAS-A:** Association/Composition (`Car` HAS-A `Engine`).

---

✅ **Conclusion:** Inheritance in Java is a powerful OOP concept that allows reusability, polymorphism, and structured class hierarchies. Mastering inheritance is crucial for designing maintainable and scalable Java applications.

