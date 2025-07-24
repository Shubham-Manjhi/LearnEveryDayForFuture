**Java Topic: LeetCode 17 - Letter Combinations of a Phone Number**

---

✅ 1. Definition and Purpose

• What is the concept?\
This problem asks us to return all possible letter combinations that the number string could represent based on a phone keypad mapping (like on old mobile phones).

• Why does it exist in Java?\
It's a standard backtracking problem used to understand recursive tree building and how to manage state in recursion.

• What problem does it solve?\
It solves problems involving permutations and combinations with constraints, similar to code generation or keypad-based navigation logic.

🧠 Example: Input "23" maps to ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

---

✅ 2. Syntax and Structure

• Understand the basic syntax used to implement the concept.\
• Use recursion (backtracking) or iterative queue-based BFS structure.

🧠 Example: Define `letterCombinations(String digits)` and return `List<String>`.

---

✅ 3. Practical Examples

🔹 Approach 1: Backtracking (Recursive DFS)

```java
public class LetterCombinations {
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
```

🔹 Approach 2: BFS Using Queue (Iterative)

```java
public class LetterCombinationsIterative {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (char digit : digits.toCharArray()) {
            String letters = map[digit - '0'];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();
                for (char c : letters.toCharArray()) {
                    queue.offer(combination + c);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
```

---

✅ 4. Internal Working

• Recursive approach uses DFS to build combinations.\
• Iterative queue approach uses BFS to build strings level by level.\
• Both run in O(4^n \* n) time where n = digits.length().

---

✅ 5. Best Practices

✔ Always check for null or empty input\
✔ Use StringBuilder for efficient string mutation in recursion\
✔ Use queue to avoid call stack overhead for very deep digit chains

---

✅ 6. Related Concepts

- Backtracking
- BFS/DFS
- StringBuilder
- Queue

🧠 Example: Word search, keypad-based word suggestion

---

✅ 7. Interview & Real-world Use

🧠 Interview Use:

- Classic backtracking + recursion combo
- Tests state handling and tree depth traversal

🏢 Real-world:

- SMS keyboard suggestion systems\


- Predictive text engines\


- Code/password generation

---

✅ 8. Common Errors & Debugging

❌ Not handling empty input\
❌ Using String concatenation inside loop (inefficient)\
❌ Not backtracking (forgetting to remove last character)

🧪 Debug Tip:

- Print recursion stack\


- Log intermediate queue state

---

✅ 9. Java Version Updates

• Java 8+ provides streams but not critical here\
• StringBuilder preferred over string concat for performance\
• Java 14+ Records can be used for immutable pair tracking if needed

---

✅ 10. Practice and Application

📝 Practice on:

- LeetCode #17
- GFG backtracking and recursion

🏗 Apply in:

- Keyboard autocomplete systems\


- AI-based word generation\


- Graph/tree traversal utilities

