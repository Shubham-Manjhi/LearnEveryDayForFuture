<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Longest Common Prefix (LeetCode 14)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Write a function to find the longest common prefix string amongst an array of strings.</p>
<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<pre><code class="language-java">Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Find the longest starting substring shared by all strings in an array.</li>
  <li><b>Why does it exist in Java?</b> Often needed in parsing, search engines, dictionary lookups, and autocomplete systems.</li>
  <li><b>What problem does it solve?</b> Reduces search space and helps establish data structure patterns.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public String longestCommonPrefix(String[] strs)</code></pre>
<p>This function returns the longest prefix shared by all strings.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Horizontal Scanning</h3>
<pre><code class="language-java">public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    String prefix = strs[0];
    // Step 1: Compare with each word
    for (int i = 1; i < strs.length; i++) {
        // Step 2: Trim prefix until match
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}</code></pre>
<p><b>⏱ Time:</b> O(S), S = sum of all characters, <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Vertical Scanning (Character by Character)</h3>
<pre><code class="language-java">public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    for (int i = 0; i < strs[0].length(); i++) {
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
            if (i >= strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);
        }
    }
    return strs[0];
}</code></pre>
<p><b>⏱ Time:</b> O(S), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Horizontal: Shrinks prefix until all strings match it</li>
  <li>Vertical: Checks each character position across strings</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Return early when prefix becomes empty</li>
  <li>✔ Choose vertical for better worst-case performance</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Trie data structure</li>
  <li>String comparison</li>
  <li>Character arrays</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Checks string manipulation and loop handling</p>
<p><b>🏢 Real-world:</b> Search optimization, autocomplete, DNA sequence alignment</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not handling empty input</li>
  <li>❌ Off-by-one errors in substring trimming</li>
</ul>
<p><b>🧪 Tip:</b> Add debug print in each loop to trace current prefix</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Compatible with Java 8+. No version-specific methods used.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 14: Longest Common Prefix</li>
  <li>Useful in real-time suggestions and predictive text systems</li>
</ul>

---

