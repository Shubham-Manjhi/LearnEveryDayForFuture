# 🏁 **OOPs Concept: Final Keyword in Java**

---

## 🎯 **Introduction to Final Keyword**

The `final` keyword in Java is a **non-access modifier** that can be used with **variables, methods, and classes**. Its purpose is to apply restrictions in object-oriented programming to maintain **immutability, security, and consistency**.

It tells the compiler that the entity (variable/method/class) declared as `final` **cannot be changed, overridden, or inherited further**.

---

## 🔑 **Key Properties of Final Keyword**

- Final can be applied to **variables**, **methods**, and **classes**.
- Final keyword ensures **immutability** when used with variables.
- It prevents **method overriding** when applied to methods.
- It prevents **inheritance** when applied to classes.

---

## 📌 **Final Variables**

- A variable declared as `final` becomes a **constant**.
- Once assigned, the value cannot be reassigned.
- Must be initialized during declaration or inside a **constructor**.

### ✅ Example:

```java
class FinalVariableExample {
    final int MAX_VALUE = 100; // initialized at declaration
    final int MIN_VALUE;       // will be initialized in constructor

    FinalVariableExample() {
        MIN_VALUE = 1;
    }

    void displayValues() {
        System.out.println("MAX_VALUE: " + MAX_VALUE);
        System.out.println("MIN_VALUE: " + MIN_VALUE);
    }

    public static void main(String[] args) {
        FinalVariableExample obj = new FinalVariableExample();
        obj.displayValues();
    }
}
```

---

## 📌 **Final Methods**

- A `final` method cannot be **overridden** by child classes.
- Useful when we want to restrict subclass behavior.

### ✅ Example:

```java
class Parent {
    final void showMessage() {
        System.out.println("This is a final method in Parent.");
    }
}

class Child extends Parent {
    // ❌ Error: Cannot override final method
    // void showMessage() { }
}

public class FinalMethodExample {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.showMessage();
    }
}
```

---

## 📌 **Final Classes**

- A `final` class **cannot be inherited**.
- Useful for **security and immutability** (e.g., Java's `String` class is `final`).

### ✅ Example:

```java
  final class FinalClass {
      void display() {
          System.out.println("This is a final class.");
      }
  }

// ❌ Error: Cannot inherit from final class
// class SubClass extends FinalClass { }

public class FinalClassExample {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.display();
    }
}
```

---

## ⚡ **Final vs Finally vs Finalize**

| Keyword        | Purpose                                                        |
| -------------- | -------------------------------------------------------------- |
| **final**      | Used for variables, methods, and classes to apply restrictions |
| **finally**    | A block in exception handling that executes always             |
| **finalize()** | A method called by Garbage Collector before object destruction |

---

## 🚀 **Important Interview Questions**

### 🔹 Q1. Can we initialize a final variable later?

👉 Yes, but only inside a **constructor** or **static block**.

### 🔹 Q2. Why is the String class in Java final?

👉 To maintain **immutability, security, and performance optimizations** like String Pooling.

### 🔹 Q3. Can we declare constructors as final?

👉 No, because constructors are **not inherited** in Java.

### 🔹 Q4. What happens if we make a method final and try to override it?

👉 The compiler will throw an error.

### 🔹 Q5. Can abstract and final be used together?

👉 No, because `abstract` requires overriding while `final` prevents overriding.

---

## 📝 **Summary**

- `final` **variable** → Constant value (cannot be reassigned).
- `final` **method** → Cannot be overridden.
- `final` **class** → Cannot be inherited.
- Ensures **immutability, consistency, and restriction** in OOPs.

---

🔥 **Real-Life Analogy:**

- Think of `final` as a **sealed envelope** → Once sealed (final variable), you can’t change contents; you can read it but not replace it.
- A `final` method is like a **fixed rule** → Children must follow it, can’t override.
- A `final` class is like a **closed library** → You can use it, but you can’t expand or extend it.

---

