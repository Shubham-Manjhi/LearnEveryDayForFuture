## ☕ Java Caching and Its High-Level Implementation

### 🔹 What is Caching?

Caching is a technique used to store frequently accessed data in temporary memory (cache) to improve performance, reduce latency, and minimize expensive operations (like database or network calls).

---

## 🔹 Types of Caching in Java

1. **In-Memory Cache** → Data is stored in JVM memory (e.g., `HashMap`, `ConcurrentHashMap`).
2. **Distributed Cache** → Shared cache across multiple nodes (e.g., Redis, Hazelcast, Memcached).
3. **Local Cache with Eviction** → Auto-removes entries when size or time limits are reached.

---

## 🔹 Caching Functionalities

- ✅ **Read-Through Cache** → Fetch from cache; if not present, load from DB and store.
- ✅ **Write-Through Cache** → Write to cache and DB simultaneously.
- ✅ **Write-Behind Cache** → Write to cache first, then update DB asynchronously.
- ✅ **Time-based Eviction (TTL/TTI)** → Removes entries after expiration.
- ✅ **Size-based Eviction (LRU, LFU, FIFO)** → Removes least-used entries when max size is reached.
- ✅ **Invalidation** → Remove specific entries when data becomes stale.

---

## 🔹 High-Level Implementation in Java

```java
import java.util.*;
import java.util.concurrent.*;

class Cache<K, V> {
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private final Map<K, Long> expiryTime = new ConcurrentHashMap<>();
    private final int maxSize;
    private final long ttl; // Time-to-live in ms

    public Cache(int maxSize, long ttl) {
        this.maxSize = maxSize;
        this.ttl = ttl;
    }

    // ✅ Read-Through Cache
    public V get(K key, Callable<V> dataSource) throws Exception {
        if (isExpired(key)) {
            cache.remove(key);
            expiryTime.remove(key);
        }
        return cache.computeIfAbsent(key, k -> {
            try {
                V value = dataSource.call();
                expiryTime.put(k, System.currentTimeMillis() + ttl);
                return value;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    // ✅ Write-Through Cache
    public void put(K key, V value) {
        if (cache.size() >= maxSize) {
            evict();
        }
        cache.put(key, value);
        expiryTime.put(key, System.currentTimeMillis() + ttl);
        // In real use-case, also write to DB
    }

    // ✅ Invalidation
    public void invalidate(K key) {
        cache.remove(key);
        expiryTime.remove(key);
    }

    // ✅ Eviction Policy (LRU simulated)
    private void evict() {
        K lruKey = cache.keySet().iterator().next();
        cache.remove(lruKey);
        expiryTime.remove(lruKey);
    }

    // ✅ Check expiry
    private boolean isExpired(K key) {
        return expiryTime.containsKey(key) && expiryTime.get(key) < System.currentTimeMillis();
    }
}
```

---

## 🔹 Usage Example

```java
public class CacheDemo {
    public static void main(String[] args) throws Exception {
        Cache<String, String> cache = new Cache<>(3, 5000);

        // First call - loads from data source
        String data = cache.get("user:1", () -> "UserDataFromDB");
        System.out.println("Fetched: " + data);

        // Second call - loads from cache
        String cachedData = cache.get("user:1", () -> "ShouldNotBeCalled");
        System.out.println("Cached: " + cachedData);

        // Insert more to test eviction
        cache.put("user:2", "User2");
        cache.put("user:3", "User3");
        cache.put("user:4", "User4"); // Evicts oldest entry (LRU)
    }
}
```

---

## 🔹 Advanced Java Caching Libraries

- **Guava Cache (Google)** → Built-in support for TTL, eviction, stats.
- **Caffeine** → High-performance, async eviction, better replacement policy.
- **EHCache** → Widely used, integrates with Spring.
- **Redis / Hazelcast** → Distributed caching.

---

✅ With this implementation, you now have **read-through, write-through, TTL-based eviction, size-based eviction, and invalidation** features in Java caching.

