# 🟦 Object-Oriented Programming (OOPs) - `this` and `super` Keyword

---

## 🔹 `this` Keyword

The `this` keyword in Java is a reference variable that refers to the **current object** of the class. It helps to avoid naming conflicts, call current class methods/constructors, and pass the current object as an argument.

### ✅ Key Points of `this`
- Refers to the **current class object**.
- Used to differentiate between instance variables and parameters.
- Can be used to **call current class methods and constructors**.
- Can be passed as an **argument** to methods or constructors.

### 💻 Example: Using `this`
```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        // 'this' differentiates between instance and local variables
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Shubham", 25);
        s1.display();
    }
}
```

🔹 Output:
```
Name: Shubham, Age: 25
```

---

## 🔹 `super` Keyword

The `super` keyword in Java is a reference variable used to refer to the **immediate parent class object**. It is mainly used for inheritance to call parent class properties.

### ✅ Key Points of `super`
- Refers to the **parent class object**.
- Used to **call parent class variables and methods**.
- Can be used to call the **parent class constructor**.
- Helps when parent and child have the same variable/method name (avoids conflict).

### 💻 Example: Using `super`
```java
class Animal {
    String type = "Animal";

    Animal() {
        System.out.println("Animal constructor called");
    }

    void display() {
        System.out.println("This is an Animal");
    }
}

class Dog extends Animal {
    String type = "Dog";

    Dog() {
        // Calls parent class constructor
        super();
    }

    void show() {
        // Access parent variable
        System.out.println("Parent type: " + super.type);
        // Access parent method
        super.display();
        // Access child variable
        System.out.println("Child type: " + this.type);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.show();
    }
}
```

🔹 Output:
```
Animal constructor called
Parent type: Animal
This is an Animal
Child type: Dog
```

---

## 📊 Difference between `this` and `super`

| Feature            | `this` Keyword | `super` Keyword |
|--------------------|----------------|-----------------|
| Refers to          | Current class object | Parent class object |
| Constructor Call   | Calls current class constructor | Calls parent class constructor |
| Variable Access    | Current class variables | Parent class variables |
| Method Access      | Current class methods | Parent class methods |
| Usage Context      | Differentiating local and instance variables, passing object | Accessing parent class properties, avoiding overriding conflicts |

---

## 🚀 Real-world Analogy
- **`this`**: Like saying *“I am Shubham”* → Refers to the current person (object).
- **`super`**: Like saying *“My father is Ramesh”* → Refers to parent’s identity (parent object).

---

✅ `this` = Current class reference  
✅ `super` = Parent class reference

