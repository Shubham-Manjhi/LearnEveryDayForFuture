<div align="center">
  <h1 style="color: #2874A6; font-size: 32px;">Java Problem: <u>Letter Combinations of a Phone Number (LeetCode 17)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.</p>
<p>A mapping of digits to letters (just like on the telephone buttons) is given below:</p>
<pre><code>2 - abc     3 - def
4 - ghi     5 - jkl     6 - mno
7 - pqrs    8 - tuv     9 - wxyz</code></pre>
<pre><code class="language-java">Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><strong>What is the concept?</strong> It’s a backtracking/DFS problem to generate combinations based on mapping.</li>
  <li><strong>Why does it exist in Java?</strong> Used in permutations, string generation problems, and input prediction.</li>
  <li><strong>What problem does it solve?</strong> Generates all character sequences for a digit string like a phone dial pad.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public List<String> letterCombinations(String digits)</code></pre>
<p>This method returns a list of all valid letter combinations mapped to the digits.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Backtracking</h3>
<pre><code class="language-java">public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) return result;

```
String[] map = {
    "",     "",     "abc",  "def",
    "ghi",  "jkl",  "mno",  "pqrs",
    "tuv",  "wxyz"
};

backtrack(result, new StringBuilder(), digits, 0, map);
return result;
```

}

private void backtrack(List<String> result, StringBuilder current, String digits, int index, String\[] map) {
if (index == digits.length()) {
result.add(current.toString());
return;
}
String letters = map\[digits.charAt(index) - '0'];
for (char c : letters.toCharArray()) {
current.append(c);
backtrack(result, current, digits, index + 1, map);
current.deleteCharAt(current.length() - 1); // backtrack step
}
}</code></pre>

<h3 style="color: #5D6D7E;">🔹 Approach 2: BFS (Queue Based)</h3>
<pre><code class="language-java">public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) return new ArrayList<>();

```
String[] map = {
    "",     "",     "abc",  "def",
    "ghi",  "jkl",  "mno",  "pqrs",
    "tuv",  "wxyz"
};

Queue<String> queue = new LinkedList<>();
queue.offer("");

for (char digit : digits.toCharArray()) {
    String letters = map[digit - '0'];
    int size = queue.size();
    while (size-- > 0) {
        String prefix = queue.poll();
        for (char c : letters.toCharArray()) {
            queue.offer(prefix + c);
        }
    }
}
return new ArrayList<>(queue);
```

}</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li><strong>Backtracking:</strong> Uses recursion to explore each path.</li>
  <li><strong>BFS:</strong> Explores all levels digit by digit using a queue.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Don’t forget to handle the base case of empty input</li>
  <li>✔ Prefer <code>StringBuilder</code> over <code>String</code> in backtracking</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Permutations and combinations</li>
  <li>Recursive tree traversal</li>
  <li>Phone keypad mapping</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><strong>🧠 Interview:</strong> Very common question for backtracking and recursive state building.</p>
<p><strong>🏢 Real-world:</strong> Auto-suggestion systems, predictive text, keypad inputs</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not resetting the path after each recursive call</li>
  <li>❌ Forgetting to check for empty input string</li>
</ul>
<p><strong>🧪 Debug Tip:</strong> Print current string before/after recursive call to track generation</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Compatible with Java 8+. Uses <code>StringBuilder</code>, <code>List</code>, and lambda-style looping is possible in higher versions.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 17: Letter Combinations of a Phone Number</li>
  <li>Backtracking and BFS coding patterns</li>
  <li>Autocomplete and prediction features</li>
</ul>

---
