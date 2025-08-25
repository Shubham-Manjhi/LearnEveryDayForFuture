# 🏷️ Spring Boot Annotations Deep Dive

---

# 🚀 Understanding Annotations in Spring Boot

---

## 🎯 Introduction

Annotations in **Spring Boot** are **metadata** that provide instructions to the framework about how to configure, wire, and manage components. They remove the need for verbose XML configuration and make applications more **readable, concise, and maintainable**.

In Spring Boot:

- **Annotations drive configuration.**
- **Annotations enable Dependency Injection (DI).**
- **Annotations define beans, request mappings, and configuration.**

👉 Mastering annotations is essential for interviews and real-world development.

---

# 🔑 Subtopics of Spring Boot Annotations

1. 📖 What are Annotations?
2. 🏗️ Core Spring Boot Annotations
3. ⚙️ Stereotype Annotations
4. 🔄 Dependency Injection Annotations
5. 🧩 Configuration & Bean Annotations
6. 🌐 Web & REST API Annotations
7. 🛠️ Testing Annotations
8. 📊 Actuator & Monitoring Annotations
9. ❓ Common Interview Questions on Annotations

---

## 📖 1. What are Annotations?

- **Annotations** are Java metadata tags prefixed with `@`.
- Used by the compiler and runtime environment to provide additional behavior.
- In Spring Boot, annotations replace XML-based configuration.

Example:

```java
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("Alice", "Bob");
    }
}
```

Here, `@RestController`, `@RequestMapping`, and `@GetMapping` are annotations.

---

## 🏗️ 2. Core Spring Boot Annotations

- `@SpringBootApplication` → Entry point annotation that combines:
  - `@Configuration`
  - `@EnableAutoConfiguration`
  - `@ComponentScan`

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

- `@EnableAutoConfiguration` → Enables auto-configuration.
- `@ComponentScan` → Scans for components in the package.

---

## ⚙️ 3. Stereotype Annotations

These mark classes as **Spring-managed components**:

- `@Component` → Generic component.
- `@Service` → Service layer class.
- `@Repository` → DAO layer (adds exception translation).
- `@Controller` → Web controller.
- `@RestController` → Combines `@Controller` + `@ResponseBody`.

```java
@Service
public class UserService {
    public String getUser() {
        return "Alice";
    }
}
```

---

## 🔄 4. Dependency Injection Annotations

- `@Autowired` → Automatically wires beans.
- `@Qualifier` → Chooses between multiple beans.
- `@Primary` → Marks default bean when multiple are available.
- `@Lazy` → Creates bean on first request.
- `@Value` → Injects values from properties.

```java
@Component
class OrderService {
    @Autowired
    private PaymentService paymentService;

    @Value("${app.name}")
    private String appName;
}
```

---

## 🧩 5. Configuration & Bean Annotations

- `@Configuration` → Defines configuration class.
- `@Bean` → Creates bean manually.
- `@PropertySource` → Loads properties file.
- `@ConfigurationProperties` → Binds properties to POJO.

```java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

---

## 🌐 6. Web & REST API Annotations

- `@RequestMapping` → Maps HTTP requests.
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` → Shorthand request mappings.
- `@PathVariable` → Extracts path values.
- `@RequestParam` → Extracts query params.
- `@RequestBody` → Maps JSON to Java object.
- `@ResponseBody` → Sends Java object as JSON.

Example:

```java
@RestController
@RequestMapping("/api")
class ProductController {

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable int id) {
        return "Product ID: " + id;
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody String product) {
        return "Added: " + product;
    }
}
```

---

## 🛠️ 7. Testing Annotations

- `@SpringBootTest` → Loads full application context.
- `@MockBean` → Creates mock beans.
- `@DataJpaTest` → Tests JPA repositories.
- `@WebMvcTest` → Tests controller layer only.
- `@TestConfiguration` → Defines beans only for tests.

```java
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetUser() {
        assertEquals("Alice", userService.getUser());
    }
}
```

---

## 📊 8. Actuator & Monitoring Annotations

- `@Endpoint` → Defines custom actuator endpoints.
- `@ReadOperation` → Marks read operation.
- `@WriteOperation` → Marks write operation.
- `@DeleteOperation` → Marks delete operation.

Example:

```java
@Component
@Endpoint(id = "customInfo")
public class CustomEndpoint {

    @ReadOperation
    public String customInfo() {
        return "Custom Actuator Endpoint";
    }
}
```

---

## ❓ 9. Common Interview Questions on Annotations

1. **What is the difference between **``**, **``**, **``**, and **``**?**

   - They are stereotype annotations with semantic meaning.

2. **What is the difference between **``** and **``**?**

   - `@RestController` = `@Controller` + `@ResponseBody`.

3. **When do you use **``** vs constructor injection?**

   - Constructor injection is recommended for immutability.

4. **How does **``** work internally?**

   - Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

5. **What is the difference between **``** and **``**?**

   - `@Bean` is used inside `@Configuration` classes, `@Component` is class-level.

6. **How do you load external configurations in Spring Boot?**

   - Using `@Value`, `@ConfigurationProperties`, or `@PropertySource`.

---

# 🎉 Conclusion

Spring Boot annotations are the **building blocks** of application development. By mastering them, developers can write **clean, maintainable, and production-ready applications** with ease. Understanding annotations is crucial for **interviews, real-world projects, and debugging complex Spring Boot systems**.

---

