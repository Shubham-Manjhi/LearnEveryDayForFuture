# ☕ Java Caching and Its Implementation

Caching is a technique used to store frequently accessed data in memory to improve application performance by reducing expensive operations like database queries, API calls, or file reads.

---

## 📌 Why Caching?
- **Performance**: Faster data retrieval.
- **Reduced Load**: Decreases database/API hits.
- **Scalability**: Supports handling more requests.
- **Cost Efficiency**: Minimizes resource consumption.

---

## ⚙️ Types of Caching

### 1. **In-Memory Caching**
- Data is stored in memory (RAM).
- Fastest type of caching.
- Example: `HashMap`, `ConcurrentHashMap`, **Guava Cache**, **Caffeine**.

### 2. **Distributed Caching**
- Cache is shared across multiple servers.
- Ensures scalability in microservices.
- Examples: **Redis**, **Memcached**, **Hazelcast**.

### 3. **Persistent Caching**
- Data is cached on disk for long-term usage.
- Slower than in-memory, but durable.

---

## 🛠️ Implementation Approaches

### 1. **Using Java Collections (Basic)**
```java
import java.util.*;

public class SimpleCache {
    private final Map<String, String> cache = new HashMap<>();

    public String getData(String key) {
        if (cache.containsKey(key)) {
            return cache.get(key); // return from cache
        }
        String data = "ExpensiveDataFor:" + key; // simulate expensive call
        cache.put(key, data);
        return data;
    }
}
```

### 2. **Using ConcurrentHashMap (Thread-Safe)**
```java
import java.util.concurrent.*;

public class ConcurrentCache {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public String getData(String key) {
        return cache.computeIfAbsent(key, k -> "ExpensiveDataFor:" + k);
    }
}
```

### 3. **Using Guava Cache (Google Library)**
```java
import com.google.common.cache.*;
import java.util.concurrent.TimeUnit;

public class GuavaCacheExample {
    private final Cache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public String getData(String key) throws Exception {
        return cache.get(key, () -> "ExpensiveDataFor:" + key);
    }
}
```

### 4. **Using Caffeine Cache (High-Performance)**
```java
import com.github.benmanes.caffeine.cache.*;
import java.util.concurrent.TimeUnit;

public class CaffeineCacheExample {
    private final Cache<String, String> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public String getData(String key) {
        return cache.get(key, k -> "ExpensiveDataFor:" + k);
    }
}
```

### 5. **Using Spring Boot Caching**
```java
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable("users")
    public String getUserById(String userId) {
        return "ExpensiveUserDataFor:" + userId;
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clearCache() {
        System.out.println("Cache cleared!");
    }
}
```

`application.properties`:
```properties
spring.cache.type=simple
```
Or use `redis` for distributed caching.

---

## 📊 Best Practices
- Choose **in-memory** for small apps, **distributed caching** for microservices.
- Use **eviction policies** (LRU, LFU, FIFO) to prevent memory overflow.
- Set **TTL (Time-To-Live)** to refresh stale data.
- Ensure **thread safety**.
- Monitor cache hit/miss ratios.

---

## ✅ Summary
- Caching improves **performance & scalability**.
- Implementations can be:
  - Simple (`HashMap`, `ConcurrentHashMap`).
  - Libraries (**Guava**, **Caffeine**).
  - Framework-based (**Spring Boot Cache**).
  - Distributed (**Redis**, **Hazelcast**).
- Always balance between **memory usage** and **performance**.

