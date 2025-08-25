# 💎 Diamond Problem in Java

---

## 🔹 Introduction
The **Diamond Problem** is a well-known issue in **Object-Oriented Programming (OOPs)** that arises when a class inherits from multiple classes that have a common ancestor. This creates **ambiguity** because the compiler cannot determine which path to follow for the inherited members.

In Java, **multiple inheritance of classes** is not supported directly to avoid the Diamond Problem. Instead, Java allows multiple inheritance using **interfaces**.

---

## 🔹 Why is it called the Diamond Problem?
Consider a scenario where:
- Class **A** is a parent class.
- Class **B** and **C** inherit from **A**.
- Class **D** inherits from both **B** and **C**.

This structure forms a **diamond shape**:

```
      A
     / \
    B   C
     \ /
      D
```

- If **A** has a method and both **B** and **C** override it, then **D** inherits two versions of the same method, leading to ambiguity.  

---

## 🔹 Diamond Problem in C++ vs Java
- **C++** supports multiple inheritance, so the Diamond Problem exists in C++ unless handled explicitly with the `virtual` keyword.
- **Java** does not allow multiple inheritance with classes, hence avoids this problem at the class level.
- However, **Java interfaces** can lead to a **similar issue** when a class implements multiple interfaces with the same default method.

---

## 🔹 Diamond Problem Example in Java (with Classes)
```java
// ❌ This will not compile in Java
class A {
    void display() {
        System.out.println("Class A method");
    }
}

class B extends A {
    void display() {
        System.out.println("Class B method");
    }
}

class C extends A {
    void display() {
        System.out.println("Class C method");
    }
}

// Java does not allow multiple inheritance
class D extends B, C {  // ❌ Compilation Error
}
```

➡ Java compiler prevents this scenario to **avoid ambiguity**.

---

## 🔹 Diamond Problem with Interfaces in Java
Even though Java avoids it with classes, interfaces with **default methods** can create the same situation.

```java
interface A {
    default void show() {
        System.out.println("Interface A show");
    }
}

interface B {
    default void show() {
        System.out.println("Interface B show");
    }
}

class C implements A, B {
    @Override
    public void show() {
        // Resolving ambiguity by explicitly choosing
        A.super.show();
        B.super.show();
        System.out.println("Class C show");
    }
}

public class DiamondProblemDemo {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
```

### ✅ Output:
```
Interface A show
Interface B show
Class C show
```

---

## 🔹 How Java Resolves Diamond Problem
1. **No Multiple Inheritance with Classes** → Java avoids ambiguity at compile time.
2. **Interfaces with Default Methods** → If two interfaces define the same default method, the implementing class must override and explicitly resolve the conflict.

---

## 🔹 Interview Questions on Diamond Problem

### ❓ Why does Java not support multiple inheritance with classes?
👉 To avoid ambiguity caused by the Diamond Problem and to keep the language simple and less error-prone.

### ❓ Can Diamond Problem occur in Java?
👉 Yes, it can occur with **interfaces that have default methods**, but Java forces the implementing class to resolve the conflict.

### ❓ How can you resolve Diamond Problem in Java?
👉 By overriding the conflicting method in the implementing class and using `InterfaceName.super.methodName()`.

### ❓ Does Diamond Problem exist in C++?
👉 Yes, it does. C++ resolves it using **virtual inheritance**.

---

## 🔹 Key Takeaways
- Java avoids the Diamond Problem by **disallowing multiple inheritance of classes**.
- The problem can occur with **interfaces having default methods**.
- The solution is to **override the conflicting method** and specify explicitly which interface method to use.

---

✅ **Conclusion:** The Diamond Problem highlights the challenges of multiple inheritance. Java’s design avoids it with classes but provides flexibility with interfaces, ensuring that developers handle ambiguities explicitly.

