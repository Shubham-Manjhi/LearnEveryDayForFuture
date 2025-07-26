# 📘 LeetCode 212: Word Search II

---

## ✅ 0. Question: Problem Statement

Given an m x n board of characters and a list of strings words, return all words on the board that are in the given list.

### Constraints:

- Words can be constructed from letters of sequentially adjacent cells (up/down/left/right).
- Same letter cell may not be used more than once per word.

---

## ✅ 1. Definition and Purpose

**Word Search II** is a combination of backtracking (DFS) and prefix searching. To speed up the lookup of the word list, we can use a **Trie** data structure.

- Avoids repeating search for common prefixes.
- Efficiently eliminates unpromising paths.

---

## ✅ 2. Syntax and Structure

```java
// TrieNode definition
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null; // Store word at the end node
}

// DFS Search
void backtrack(char[][] board, boolean[][] visited, TrieNode node, int i, int j) {
    // Explore neighbors
}
```

---

## ✅ 3. Practical Examples

### 🔹 Approach 1: Trie + DFS (Optimized)

```java
class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // store complete word
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, result);
            }
        }
        return result;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || !node.children.containsKey(c)) return; // Step 1: Invalid path

        node = node.children.get(c);
        if (node.word != null) {
            result.add(node.word); // Step 2: Word found
            node.word = null; // Avoid duplicates
        }

        board[i][j] = '#'; // Step 3: Mark visited
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d], nj = j + dy[d];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length)
                backtrack(board, ni, nj, node, result);
        }

        board[i][j] = c; // Step 4: Restore
    }
}
```

### 🔹 Approach 2: Set + DFS (Slower for Large Input)

```java
public List<String> findWords(char[][] board, String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words) {
        if (exist(board, word)) set.add(word);
    }
    return new ArrayList<>(set);
}

public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (dfs(board, word, 0, i, j)) return true;
        }
    }
    return false;
}

private boolean dfs(char[][] board, String word, int idx, int i, int j) {
    if (idx == word.length()) return true;
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;

    char temp = board[i][j];
    board[i][j] = '#';
    boolean found = dfs(board, word, idx + 1, i + 1, j) ||
                    dfs(board, word, idx + 1, i - 1, j) ||
                    dfs(board, word, idx + 1, i, j + 1) ||
                    dfs(board, word, idx + 1, i, j - 1);
    board[i][j] = temp;
    return found;
}
```

---

## ✅ 4. Internal Working

- Trie stores prefix relationships
- DFS explores neighbors recursively
- Words are collected as they match

### ASCII Example:

Board:

```
o a t h
r a e r
c d e m
```

Words: ["oath", "eat", "ream"]

Traversal:

```
Start at 'o' -> 'a' -> 't' -> 'h' => "oath"
```

---

## ✅ 5. Best Practices

- Use Trie for fast prefix elimination
- Mark cells as visited and restore later
- Remove found words from Trie to avoid repetition

---

## ✅ 6. Related Concepts

- Trie
- DFS / Backtracking
- HashSet for deduplication

---

## ✅ 7. Interview & Real-world Use

- Trie-based dictionary search
- Word puzzle games, crosswords
- NLP text mining from character grids

---

## ✅ 8. Common Errors & Debugging

- Re-visiting same cell in DFS
- Missing word reset in Trie
- Not restoring board characters

---

## ✅ 9. Java Version Updates

- Java 8 Stream usage for result collection
- Lambdas for traversal (less readable here)

---

## ✅ 10. Practice and Application

- LeetCode 79: Word Search I
- Google Interview: Boggle solver
- Scrabble and Wordament solvers

---

✅ Word Search II is a hybrid problem combining Trie data structures and DFS backtracking with smart pruning and optimal recursion.

