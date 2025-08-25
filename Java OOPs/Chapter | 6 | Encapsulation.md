# 🟢 OOPs Concept: Encapsulation in Java

---

## 🎯 **Introduction to Encapsulation**

Encapsulation is one of the four fundamental **Object-Oriented Programming (OOPs)** concepts in Java, alongside **Inheritance, Polymorphism, and Abstraction**. It is the process of **wrapping variables (data) and methods (code) together into a single unit (class)** while restricting direct access to the data.

In simple words, **Encapsulation = Data Hiding + Controlled Access**.

---

## 📌 **Key Points about Encapsulation**

1. **Data Hiding** → Instance variables are declared `private`.
2. **Controlled Access** → Public methods (getters & setters) are used to access/update private variables.
3. **Improved Security** → Prevents unauthorized access/modification of data.
4. **Flexibility & Maintainability** → Internal implementation can change without affecting external code.
5. **Reusability** → Well-encapsulated classes are easy to reuse in different applications.

---

## 🏗️ **Structure of Encapsulation in Java**

```java
class Student {
    // Step 1: Private data members (Data Hiding)
    private String name;
    private int age;

    // Step 2: Public getter and setter methods (Controlled Access)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) { // Validation logic (Encapsulation advantage)
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Student s1 = new Student();

        // Access data using setters
        s1.setName("Shubham");
        s1.setAge(23);

        // Access data using getters
        System.out.println("Student Name: " + s1.getName());
        System.out.println("Student Age: " + s1.getAge());
    }
}
```

✅ Output:

```
Student Name: Shubham
Student Age: 23
```

---

## 🔑 **Advantages of Encapsulation**

- Protects data from unauthorized access.
- Data can be made **read-only** (only getters) or **write-only** (only setters).
- Improves code **maintainability** and **modularity**.
- Enables data validation before assignment.
- Facilitates **loose coupling** between classes.

---

## 🆚 **Encapsulation vs Abstraction**

| Feature        | Encapsulation                     | Abstraction                   |
| -------------- | --------------------------------- | ----------------------------- |
| Focus          | How data is hidden                | Hides implementation details  |
| Achieved using | Access Modifiers, Getters/Setters | Abstract Classes & Interfaces |
| Level          | Implementation level              | Design level                  |

---

## 📘 **Types of Encapsulation**

1. **Data Encapsulation** → Wrapping variables and methods inside a class.
2. **Method Encapsulation** → Using `private` methods inside a class that are hidden from outside.

Example:

```java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    // Private method (hidden from outside world)
    private void logTransaction(String msg) {
        System.out.println("Transaction: " + msg);
    }
}
```

---

## ❓ **Common Interview Questions on Encapsulation**

### 1. **What is Encapsulation in Java?**

Encapsulation is the process of wrapping data (variables) and code (methods) into a single unit (class) and restricting direct access to data using access modifiers.

---

### 2. **How is Encapsulation implemented in Java?**

- Declare variables as **private**.
- Provide **public getters and setters** for controlled access.

---

### 3. **Difference between Encapsulation and Data Hiding?**

- **Data Hiding** is achieved by declaring variables as `private`.
- **Encapsulation** includes **data hiding + getters/setters** for controlled access.

---

### 4. **Can you achieve Encapsulation without getters and setters?**

No, because encapsulation means restricting direct access. Without getters/setters, private fields cannot be accessed outside the class.

---

### 5. **Can we have read-only or write-only fields in Encapsulation?**

Yes.

- **Read-only** → Provide only `getter` method.
- **Write-only** → Provide only `setter` method.

```java
class Employee {
    private double salary;

    // Read-only
    public double getSalary() {
        return salary;
    }

    // Write-only
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

---

### 6. **Why is Encapsulation called a protective shield?**

Because it hides sensitive data (like passwords, salary, etc.) from outside classes and provides controlled access only via methods.

---

## 🔮 **Real-World Example of Encapsulation**

- **ATM Machine**: Users can only perform limited operations (deposit, withdraw, check balance). They cannot access bank's internal code or database.
- **Car Engine**: A driver can start/stop the car, but internal engine operations are hidden.

```java
class ATM {
    private double balance = 10000;

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful. Balance: " + balance);
        } else {
            System.out.println("Invalid transaction!");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class ATMTest {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw(2000);
        System.out.println("Current Balance: " + atm.checkBalance());
    }
}
```

---

## 🎓 **Conclusion**

Encapsulation in Java is a **fundamental OOPs concept** that ensures **data security, reusability, flexibility, and maintainability**. By hiding sensitive fields and exposing them only through controlled methods, it promotes clean and secure design.

👉 Always declare variables as `private` and use **getters/setters** to achieve **true encapsulation**.

---

✅ **Next Step** → Would you like me to prepare the same deep dive for **Inheritance** (the next OOPs pillar)?

