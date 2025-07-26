# ⚖️ LeetCode 399: Evaluate Division

---

## ✅ 1. Definition and Purpose

- Given equations like `a / b = 2.0` and queries like `a / c`, evaluate the result.
- Return -1.0 if the answer does not exist.
- Used for evaluating division across connected variables.

---

## ✅ 2. Syntax and Structure

### Function Signature
```java
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
```

- Use a graph with weighted edges: a → b (weight = value), b → a (weight = 1 / value).

---

## ✅ 3. Approach 1: DFS

```java
Map<String, Map<String, Double>> graph = new HashMap<>();

public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    buildGraph(equations, values);
    double[] results = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
        String start = queries.get(i).get(0);
        String end = queries.get(i).get(1);
        Set<String> visited = new HashSet<>();
        results[i] = dfs(start, end, 1.0, visited);
    }
    return results;
}

private double dfs(String curr, String target, double prod, Set<String> visited) {
    if (!graph.containsKey(curr) || !visited.add(curr)) return -1.0;
    if (curr.equals(target)) return prod;

    for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
        double res = dfs(neighbor.getKey(), target, prod * neighbor.getValue(), visited);
        if (res != -1.0) return res;
    }
    return -1.0;
}

private void buildGraph(List<List<String>> equations, double[] values) {
    for (int i = 0; i < equations.size(); i++) {
        String a = equations.get(i).get(0);
        String b = equations.get(i).get(1);
        double val = values[i];

        graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, val);
        graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1 / val);
    }
}
```

---

## ✅ 4. Approach 2: Union Find with Weights

```java
Map<String, String> parent = new HashMap<>();
Map<String, Double> ratio = new HashMap<>();

public double[] calcEquationUF(List<List<String>> equations, double[] values, List<List<String>> queries) {
    for (int i = 0; i < equations.size(); i++) {
        String a = equations.get(i).get(0);
        String b = equations.get(i).get(1);
        union(a, b, values[i]);
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
        String a = queries.get(i).get(0);
        String b = queries.get(i).get(1);
        if (!parent.containsKey(a) || !parent.containsKey(b) || !find(a).equals(find(b))) {
            res[i] = -1.0;
        } else {
            res[i] = ratio.get(a) / ratio.get(b);
        }
    }
    return res;
}

private void union(String a, String b, double value) {
    if (!parent.containsKey(a)) {
        parent.put(a, a);
        ratio.put(a, 1.0);
    }
    if (!parent.containsKey(b)) {
        parent.put(b, b);
        ratio.put(b, 1.0);
    }

    String rootA = find(a);
    String rootB = find(b);
    if (!rootA.equals(rootB)) {
        parent.put(rootA, rootB);
        ratio.put(rootA, ratio.get(b) * value / ratio.get(a));
    }
}

private String find(String x) {
    if (!x.equals(parent.get(x))) {
        String origParent = parent.get(x);
        String newParent = find(origParent);
        ratio.put(x, ratio.get(x) * ratio.get(origParent));
        parent.put(x, newParent);
    }
    return parent.get(x);
}
```

---

## ✅ 5. ASCII Diagram Example

```
Equations:
a / b = 2.0
b / c = 3.0

Graph:
a --2.0--> b --3.0--> c

Query:
a / c → 2.0 * 3.0 = 6.0
```

---

## ✅ 6. Internal Working

- DFS recursively searches paths and accumulates ratios.
- Union Find compresses and stores ratios from node to root.
- Time: O(Q * V) (DFS), O(Q * α(N)) for Union-Find

---

## ✅ 7. Best Practices

- Handle missing variables or cycles.
- Use visited set in DFS to avoid infinite loops.
- For multiple queries, prefer Union-Find for performance.

---

## ✅ 8. Related Concepts

- Graph Traversal
- Union Find (Disjoint Sets)
- Weighted Graphs

---

## ✅ 9. Interview & Real-world Use

- Google, Amazon, Facebook graph & system dependency problems
- Currency exchange, variable substitution, network latency

---

## ✅ 10. Common Errors & Debugging

- Incorrect path multiplication
- Missing inverse relationships (a→b but not b→a)
- Wrong parent linking in Union-Find

---

## ✅ 11. Practice & Application

- LeetCode 399: Evaluate Division
- LeetCode 684, 990 (Union-Find variations)
- Graph traversal based evaluation

---

✅ This problem blends graphs and disjoint sets elegantly. Master both DFS and Union-Find to tackle a variety of graph-based evaluation questions.

