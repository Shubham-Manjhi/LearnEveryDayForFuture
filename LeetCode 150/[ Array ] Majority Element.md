<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Majority Element (LeetCode 169)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>

<p>Given an array <code>nums</code> of size n, return the majority element.</p>
<p>The majority element is the element that appears more than <code>n / 2</code> times. You may assume that the majority element always exists in the array.</p>

<pre><code class="language-java">Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Find the element that appears more than half the time in the array.</li>
  <li><b>Why does it exist in Java?</b> Java provides efficient structures like HashMap or constant-time logic to track frequency.</li>
  <li><b>What problem does it solve?</b> Identifies dominant elements in a data stream or list.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int majorityElement(int[] nums)</code></pre>
<p>Options include frequency map or optimized Boyer-Moore Voting algorithm.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: HashMap Counting</h3>
<pre><code class="language-java">public int majorityElement(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    int majority = nums.length / 2;
    
    for (int num : nums) {
        count.put(num, count.getOrDefault(num, 0) + 1);
        if (count.get(num) > majority) {
            return num;
        }
    }
    return -1; // Should never hit
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Boyer-Moore Voting Algorithm (Optimized)</h3>
<pre><code class="language-java">public int majorityElement(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        count += (num == candidate) ? 1 : -1;
    }

    return candidate;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>HashMap tracks each value’s frequency</li>
  <li>Boyer-Moore maintains a candidate and count pair to find majority efficiently</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use Boyer-Moore for space efficiency</li>
  <li>✔ Confirm assumption: majority always exists</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Voting algorithms</li>
  <li>Hash-based frequency counting</li>
  <li>Divide & conquer</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Common test for optimized reasoning and data frequency patterns</p>
<p><b>🏢 Real-world:</b></p>
<ul>
  <li>Detect most common action from logs</li>
  <li>Filter frequent queries in search history</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not validating if majority assumption holds (in variant problems)</li>
  <li>❌ Forgetting to reset candidate when count = 0</li>
</ul>
<p><b>🧪 Tip:</b> Use print statements to trace candidate and count evolution</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No major change. Java Streams can count but not in O(1) space.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 169: Majority Element</li>
  <li>System log aggregation & top usage analytics</li>
</ul>

---

