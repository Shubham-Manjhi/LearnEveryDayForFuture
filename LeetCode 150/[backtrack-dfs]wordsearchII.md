**Java Topic: LeetCode 212 - Word Search II**

---

✅ 1. Definition and Purpose

• What is the concept?\
LeetCode 212 requires you to find all words from a given list that exist in a 2D board of characters. A word can be constructed from sequentially adjacent letters (horizontal or vertical), and each letter cell may not be reused.

• Why does it exist in Java?\
This problem emphasizes combining Trie data structures with backtracking and grid traversal.

• What problem does it solve?\
It addresses the need for efficient prefix-based pruning in multi-word searches on a 2D plane.

🧠 Example:

```
Board:
[ ["o","a","a","n"],
  ["e","t","a","e"],
  ["i","h","k","r"],
  ["i","f","l","v"] ]

Words = ["oath","pea","eat","rain"]
Output: ["oath","eat"]
```

---

✅ 2. Syntax and Structure

• Define `List<String> findWords(char[][] board, String[] words)`\
• Build a Trie from words\
• Backtrack from each board cell if prefix exists in Trie

---

✅ 3. Practical Examples

🔹 Approach: Trie + DFS + Backtracking

```java
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
}

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || !node.children.containsKey(c)) return;
        node = node.children.get(c);
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // prevent duplicates
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        board[i][j] = c;
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
}
```

🖼️ ASCII Diagram – Trie Construction:

```
Insert: oath, pea, eat, rain

        root
        /   \
      o       p
      |       |
      a       e
      |       |
      t       a
      |       |
      h       - (word complete)
```

🖼️ ASCII Diagram – Search Flow on Board:

```
[o a a n]
[e t a e]
[i h k r]
[i f l v]

Start at (0,0): 'o'
→ 'a' → 't' → 'h' = match "oath"
→ 'e' → 'a' → 't' = match "eat"
```

---

✅ 4. Internal Working

• Construct Trie of input words\
• Run DFS from each board cell\
• Backtrack while pruning based on Trie prefixes

Time Complexity: O(N \* 4^L) where N = number of board cells, L = max word length

Space Complexity: O(W \* L) for Trie storage and recursion stack

---

✅ 5. Best Practices

✔ Nullify matched word in Trie to prevent duplicates\
✔ Use '#' as visited marker for cells\
✔ Free memory by deleting leaf nodes if needed (optimization)

---

✅ 6. Related Concepts

- Trie (Prefix Tree)
- DFS / Backtracking
- 2D Matrix Search

🧠 Example: Autocomplete, dictionary lookup, image labeling

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Tests knowledge of multiple data structures: Trie + DFS\

- Recursion and pruning

🏢 Real-world:

- Predictive text input\

- Word puzzle engines\

- Path optimization in AI

---

✅ 8. Common Errors & Debugging

❌ Forgetting to unmark visited cells\
❌ Missing Trie node null checks\
❌ Not preventing duplicate additions to result

🧪 Debug Tip:

- Print Trie before starting DFS\

- Log (i,j) during each DFS step

---

✅ 9. Java Version Updates

• Java 8+: Supports lambda usage in Trie node creation\
• Java 11+: Improved performance with String/Map utilities

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #212\

- GFG Trie problems

🏗 Apply in:

- Grid-based prediction engines\

- Scrabble/word games\

- Autocorrect systems

