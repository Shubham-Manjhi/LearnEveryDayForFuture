<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Reverse Words in a String (LeetCode 151)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given an input string <code>s</code>, reverse the order of the words.</p>
<p>A word is defined as a sequence of non-space characters. The words in <code>s</code> will be separated by at least one space.</p>
<p>Return a string of the words in reverse order concatenated by a single space.</p>
<p>Note that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words and no leading or trailing spaces.</p>

<pre><code class="language-java">Input: s = "  the sky  is  blue  "
Output: "blue is sky the"

Input: s = "hello world"
Output: "world hello"

Input: s = "a good   example"
Output: "example good a"</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Split, clean, and reverse a string based on word boundaries.</li>
  <li><b>Why does it exist in Java?</b> Useful for text processing, reverse ordering, and parsing inputs.</li>
  <li><b>What problem does it solve?</b> Normalizes and reorders input strings for display or logic flow.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public String reverseWords(String s)</code></pre>
<p>This function returns the cleaned and reversed string of words.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Using Built-in Java APIs (Trim + Split + Reverse)</h3>
<pre><code class="language-java">public String reverseWords(String s) {
    // Step 1: Trim leading/trailing spaces and split on multiple spaces
    String[] words = s.trim().split("\\s+");
    StringBuilder result = new StringBuilder();

    // Step 2: Append words in reverse order
    for (int i = words.length - 1; i >= 0; i--) {
        result.append(words[i]);
        if (i > 0) result.append(" ");
    }
    return result.toString();
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: In-place Reversal Using Character Array</h3>
<pre><code class="language-java">public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    // Step 1: Reverse the entire string
    reverse(chars, 0, chars.length - 1);

    // Step 2: Reverse each word
    reverseWords(chars);

    // Step 3: Clean extra spaces
    return cleanSpaces(chars);
}

private void reverse(char[] chars, int i, int j) {
    while (i < j) {
        char temp = chars[i];
        chars[i++] = chars[j];
        chars[j--] = temp;
    }
}

private void reverseWords(char[] chars) {
    int n = chars.length;
    int i = 0;
    while (i < n) {
        while (i < n && chars[i] == ' ') i++;
        int j = i;
        while (j < n && chars[j] != ' ') j++;
        reverse(chars, i, j - 1);
        i = j;
    }
}

private String cleanSpaces(char[] chars) {
    int i = 0, j = 0, n = chars.length;
    while (j < n) {
        while (j < n && chars[j] == ' ') j++;
        while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
        while (j < n && chars[j] == ' ') j++;
        if (j < n) chars[i++] = ' ';
    }
    return new String(chars, 0, i);
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>First approach uses high-level string tools</li>
  <li>Second approach does detailed manipulation: reverse + trim</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use regex "\\s+" to handle multiple spaces</li>
  <li>✔ Avoid building string by + in loops; use StringBuilder</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>StringBuilder and mutable strings</li>
  <li>Two-pointer and character-based processing</li>
  <li>Regex patterns</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Popular string problem testing split, loop, and memory handling</p>
<p><b>🏢 Real-world:</b> Parsing user inputs, text formatting, cleaning logs</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not handling multiple or leading/trailing spaces</li>
  <li>❌ Using + for string append inside loops</li>
</ul>
<p><b>🧪 Tip:</b> Use .trim() + .split("\\s+") to sanitize inputs</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Compatible with Java 8+. Uses StringBuilder and regular Java methods</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 151: Reverse Words in a String</li>
  <li>String tokenizer and formatting apps</li>
  <li>Text pre-processing modules</li>
</ul>

---

