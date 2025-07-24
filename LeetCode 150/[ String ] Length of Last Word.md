<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Length of Last Word (LeetCode 58)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given a string <code>s</code> consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.</p>

<pre><code class="language-java">Input: s = "Hello World"
Output: 5

Input: s = "   fly me   to   the moon  "
Output: 4

Input: s = "luffy is still joyboy"
Output: 6</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> String manipulation and traversal to locate the last word and measure its length.</li>
  <li><b>Why does it exist in Java?</b> Java's String class provides efficient methods to handle such string problems.</li>
  <li><b>What problem does it solve?</b> Identifies and calculates the size of the last non-space segment in a sentence.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int lengthOfLastWord(String s)</code></pre>
<p>This function takes a string and returns the length of its last word.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Trim and Split</h3>
<pre><code class="language-java">public int lengthOfLastWord(String s) {
    String[] words = s.trim().split(" "); // Remove leading/trailing spaces and split by space
    return words[words.length - 1].length(); // Return the length of the last word
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n) (due to array creation)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Traverse Backward (Optimized)</h3>
<pre><code class="language-java">public int lengthOfLastWord(String s) {
    int length = 0;
    int i = s.length() - 1;
    
    // Step 1: Skip trailing spaces
    while (i >= 0 && s.charAt(i) == ' ') i--;
    
    // Step 2: Count characters until space or start
    while (i >= 0 && s.charAt(i) != ' ') {
        length++;
        i--;
    }
    return length;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Trim and Split: uses regex-based splitting and array allocation</li>
  <li>Traverse Backward: scans in reverse, skipping spaces, counting characters</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use Approach 2 for optimal space usage</li>
  <li>✔ Handle edge cases like multiple trailing spaces or single word input</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>String trimming and splitting</li>
  <li>Reverse string traversal</li>
  <li>Character operations in Java</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Assesses basic string processing and loop logic</p>
<p><b>🏢 Real-world:</b> Useful in word processing, formatting tools, command parsers</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not trimming input properly</li>
  <li>❌ Using split without accounting for empty strings or multiple spaces</li>
</ul>
<p><b>🧪 Tip:</b> Add debug prints for string indexes and current word segments</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No version-specific impact. Works from Java 7 onward</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 58</li>
  <li>Word counters</li>
  <li>Natural language processing text parsing</li>
</ul>

---

