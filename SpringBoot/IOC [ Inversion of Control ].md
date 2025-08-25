# 🌀 Inversion of Control (IoC)

---

# 🌟 Inversion of Control (IoC) in Java & Spring Boot

---

## 🎯 Introduction

Inversion of Control (IoC) is a **core principle** in software engineering, particularly in **Spring Framework** and **Spring Boot**. It helps in building **loosely coupled, maintainable, and testable applications**.

At its core:

- **IoC means giving the control of object creation and dependency management to a container/framework instead of handling it manually.**

In Java, this concept is often implemented using **Dependency Injection (DI)**.

---

# 🔑 Subtopics of IoC

1. 📖 What is IoC?
2. 🏗️ Types of IoC
3. ⚙️ Dependency Injection (DI) as IoC Implementation
4. 🔄 IoC in Spring Framework
5. 🧩 IoC Containers (BeanFactory & ApplicationContext)
6. 🛠️ Example of IoC with Java Code
7. ⚖️ Advantages of IoC
8. 🧪 IoC in Testing
9. ❓ Common Interview Questions on IoC

---

## 📖 1. What is IoC?

- In traditional Java, developers create and manage objects explicitly using the `new` keyword.
- With IoC, the **control is inverted** — the framework creates and injects required objects.

**Example (Without IoC):**

```java
class Service {
    Repository repository;

    public Service() {
        repository = new Repository(); // Tightly coupled
    }
}
```

**With IoC (Spring):**

```java
class Service {
    Repository repository;

    // Repository will be injected by the framework
    public Service(Repository repository) {
        this.repository = repository;
    }
}
```

👉 Here, control of object creation is given to the container.

---

## 🏗️ 2. Types of IoC

1. **Dependency Injection (DI):**

   - Objects are given dependencies at runtime.
   - Common forms:
     - Constructor Injection
     - Setter Injection
     - Field Injection

2. **Strategy Pattern:**

   - Behavior is injected at runtime instead of compile-time.

3. **Service Locator Pattern (older approach):**

   - IoC container provides dependencies via a lookup method (not recommended in Spring).

---

## ⚙️ 3. Dependency Injection (DI) as IoC Implementation

- **Constructor Injection:** Recommended by Spring.

```java
@Component
class Service {
    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }
}
```

- **Setter Injection:**

```java
@Component
class Service {
    private Repository repository;

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
```

- **Field Injection:** (Not recommended for testing)

```java
@Component
class Service {
    @Autowired
    private Repository repository;
}
```

---

## 🔄 4. IoC in Spring Framework

- Spring provides IoC through its **IoC Container**.
- Two main containers:
  - **BeanFactory:** Basic container, lazy initialization.
  - **ApplicationContext:** Advanced, supports enterprise features (events, AOP, internationalization).

Spring Boot automatically configures an **ApplicationContext** at startup.

```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApplication.class, args);
        Service service = context.getBean(Service.class);
        service.doSomething();
    }
}
```

---

## 🧩 5. IoC Containers (BeanFactory & ApplicationContext)

| Feature              | BeanFactory      | ApplicationContext    |
| -------------------- | ---------------- | --------------------- |
| Lazy Loading         | Yes              | No (eager by default) |
| Event Propagation    | No               | Yes                   |
| AOP Support          | No               | Yes                   |
| Internationalization | No               | Yes                   |
| Best Use             | Lightweight apps | Enterprise apps       |

---

## 🛠️ 6. Example of IoC with Java Code

### Example: Order Processing System

```java
@Component
class PaymentService {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}

@Component
class OrderService {
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        System.out.println("Placing order...");
        paymentService.processPayment();
    }
}

@SpringBootApplication
public class IoCExampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IoCExampleApplication.class, args);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();
    }
}
```

Output:

```
Placing order...
Processing payment...
```

👉 Here, Spring IoC container **creates and injects PaymentService into OrderService** automatically.

---

## ⚖️ 7. Advantages of IoC

- ✅ Loose coupling
- ✅ Easy testing (use mock dependencies)
- ✅ Better maintainability
- ✅ Reusability of components
- ✅ Improved scalability

---

## 🧪 8. IoC in Testing

IoC makes unit testing simpler:

```java
@Test
public void testOrderService() {
    PaymentService mockPayment = Mockito.mock(PaymentService.class);
    OrderService orderService = new OrderService(mockPayment);

    orderService.placeOrder();

    Mockito.verify(mockPayment).processPayment();
}
```

---

## ❓ 9. Common Interview Questions on IoC

1. **What is IoC and why is it important in Spring?**

   - IoC means framework controls object creation; important for loose coupling.

2. **Difference between IoC and DI?**

   - IoC is the principle, DI is the design pattern implementing IoC.

3. **How does Spring implement IoC?**

   - Through IoC containers (`BeanFactory`, `ApplicationContext`).

4. **Which injection is best?**

   - Constructor injection (recommended).

5. **Difference between BeanFactory and ApplicationContext?**

   - BeanFactory is basic, ApplicationContext is feature-rich.

6. **Can IoC be used outside Spring?**

   - Yes, via frameworks like Guice, CDI.

---

# 🎉 Conclusion

Inversion of Control (IoC) is a **fundamental concept** in Spring Boot development. It shifts responsibility of object creation from developer to framework, ensuring **flexibility, testability, and maintainability**. By leveraging **Dependency Injection and IoC Containers**, developers can focus more on business logic and less on managing dependencies.

---

