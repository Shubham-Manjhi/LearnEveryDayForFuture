# 🧩 OOPs Concept: Object Cloning & Copy Constructors

---

## 🔹 Introduction

In Java, **creating copies of objects** is a common task. This can be achieved using **Object Cloning** or **Copy Constructors**. Both provide ways to duplicate objects, but they differ in implementation and behavior.

- **Object Cloning**: Creates a copy of an object using the `clone()` method.
- **Copy Constructor**: Creates a copy by passing an existing object to a constructor of the same class.

---

## ⚡ Object Cloning

📌 **Definition:** Object cloning in Java is the process of creating a new object that is an **exact copy** of an existing object.

### ✅ Key Points:

- Java provides a `clone()` method in the `Object` class.
- The class must implement `` interface to allow cloning.
- Can be **shallow copy** (default) or **deep copy** (custom implementation).
- Throws `CloneNotSupportedException` if `Cloneable` is not implemented.

### 💻 Example: Shallow Cloning

```java
class Student implements Cloneable {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding clone() method
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("Shubham", 25);
        Student s2 = (Student) s1.clone();  // Cloning object

        System.out.println(s1.name + ", " + s1.age);
        System.out.println(s2.name + ", " + s2.age);
    }
}
```

🔹 Output:

```
Shubham, 25
Shubham, 25
```

### 💡 Notes:

- **Shallow Copy**: Copies primitive fields and references (both objects share referenced objects).
- **Deep Copy**: Creates copies of referenced objects as well to avoid shared references.

---

## ⚡ Copy Constructors

📌 **Definition:** A copy constructor is a **constructor that initializes an object using another object of the same class**.

### ✅ Key Points:

- Does **not require **``.
- Provides **control over deep or shallow copying**.
- Can be used with **immutable objects**.

### 💻 Example: Copy Constructor

```java
class Student {
    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }

    void display() {
        System.out.println(name + ", " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Shubham", 25);
        Student s2 = new Student(s1);  // Using copy constructor

        s1.display();
        s2.display();
    }
}
```

🔹 Output:

```
Shubham, 25
Shubham, 25
```

---

## 📊 Differences Between Object Cloning and Copy Constructor

| Feature            | Object Cloning                      | Copy Constructor                        |
| ------------------ | ----------------------------------- | --------------------------------------- |
| Implementation     | Uses `clone()` method               | Uses a constructor                      |
| Interface Required | Must implement `Cloneable`          | No interface required                   |
| Exception          | Throws `CloneNotSupportedException` | No exception                            |
| Shallow/Deep Copy  | Shallow by default, deep optional   | Can implement shallow or deep easily    |
| Flexibility        | Less control, requires casting      | More control and readability            |
| Performance        | Slightly faster                     | Slightly slower due to constructor call |

---

## 🚀 Conclusion

- Use **object cloning** for quick duplication of simple objects.
- Use **copy constructors** for **better control**, especially for **deep copying** or immutable objects.
- Both methods ensure **object reusability and flexibility** in Java OOPs design.

---

🔥 Real-life analogy:

- **Cloning**: Making a photocopy of a document (exact duplicate, may share references).
- **Copy Constructor**: Writing a new document by copying the original manually (full control over content).

