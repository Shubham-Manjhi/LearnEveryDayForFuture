# 📘 LeetCode 127: Word Ladder

---

## ✅ 0. Question

Given two words `beginWord` and `endWord`, and a dictionary `wordList`, return the number of words in the shortest transformation sequence from `beginWord` to `endWord`, such that:

- Only one letter can be changed at a time.
- Each transformed word must exist in the word list.

> Return 0 if no such transformation sequence exists.

### Example:
Input:
```text
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```
Output: `5`
Explanation:
```text
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
```

---

## ✅ 1. Definition and Purpose

This problem is solved using **Graph Traversal**. Each word is a node; two words are connected if they differ by one character.

### Purpose:
- To practice BFS on an implicit graph
- Understand shortest path on unweighted graphs

---

## ✅ 2. Syntax and Structure

- BFS using Queue
- Use Set for `wordList`
- Use Set for `visited`

```java
Queue<String> queue = new LinkedList<>();
Set<String> visited = new HashSet<>();
```

---

## ✅ 3. Practical Example

### 🔹 Approach 1: Standard BFS
```java
// Step-by-step BFS from beginWord
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0; // Step 1: Check if endWord is reachable

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord); // Step 2: Start BFS with beginWord

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int level = 1; // Step 3: Count transformations

    while (!queue.isEmpty()) {
        int size = queue.size(); // Step 4: Traverse current level
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            char[] arr = word.toCharArray();

            for (int j = 0; j < arr.length; j++) {
                char original = arr[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[j] = c;
                    String newWord = new String(arr);

                    if (newWord.equals(endWord)) return level + 1; // Step 5: Found path

                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(newWord);
                        visited.add(newWord); // Step 6: Add valid next word
                    }
                }
                arr[j] = original; // Step 7: Restore word
            }
        }
        level++; // Step 8: Move to next level
    }
    return 0; // No transformation path
}
```

### Example Execution:
```
Level 1: "hit"
Level 2: "hot"
Level 3: "dot", "lot"
Level 4: "dog", "log"
Level 5: "cog" ✅
```

---

### 🔹 Approach 2: Bi-directional BFS
```java
// Faster BFS by starting from both ends
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    if (!dict.contains(endWord)) return 0;

    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();

    beginSet.add(beginWord);
    endSet.add(endWord);
    int level = 1;

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        if (beginSet.size() > endSet.size()) {
            Set<String> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        }

        Set<String> nextLevel = new HashSet<>();

        for (String word : beginSet) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String next = new String(chars);

                    if (endSet.contains(next)) return level + 1; // Step: Connection found

                    if (dict.contains(next) && !visited.contains(next)) {
                        nextLevel.add(next);
                        visited.add(next);
                    }
                }
                chars[i] = old; // Restore
            }
        }

        beginSet = nextLevel; // Move to next level
        level++;
    }
    return 0;
}
```

### ASCII Trace:
```
Begin: "hit"     End: "cog"
Step 1: "hot"     Step 1: "log"
Step 2: "dot"     Step 2: "dog"
Connection: "dog" connects to "dot"
```

---

## ✅ 4. Internal Working

- Each word is treated as a node.
- Edges exist between words that differ by one letter.
- BFS expands neighbors level-by-level.
- Bi-directional BFS reduces total expansion.

---

## ✅ 5. Best Practices
- Always check `endWord` in dictionary.
- Use visited set to avoid loops.
- Bi-directional BFS when both start and end known.

---

## ✅ 6. Related Concepts
- BFS (single-source shortest path)
- Graph modeling using HashMap or adjacency lists
- Bi-directional Search

---

## ✅ 7. Interview & Real-world Use
- Seen in Facebook/Google interviews
- Useful for shortest connection in social networks, word games

---

## ✅ 8. Common Errors & Debugging
- Mutating word array without restoring
- Not using visited set efficiently
- Checking wordSet after transformation, not before

---

## ✅ 9. Java Version Updates
- Java 8 Set/Queue useful for this graph processing
- Java Streams not commonly used in this type for performance

---

## ✅ 10. Practice and Application
- LeetCode 126: Word Ladder II (return all paths)
- Facebook HackerCup, Word Graph transformations
- Useful in NLP word mutations

---

✅ Word Ladder challenges BFS skills, graph modeling and efficient set operations.
Both BFS and bi-directional BFS are essential tools in competitive coding and real-world path finding.

