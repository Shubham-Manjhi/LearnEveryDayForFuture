<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Candy Distribution (LeetCode 135)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>There are <code>n</code> children standing in a line. Each child is assigned a rating value given in the integer array <code>ratings</code>.</p>
<p>You are giving candies to these children subjected to the following requirements:</p>
<ul>
  <li>Each child must have at least one candy.</li>
  <li>Children with a higher rating than their immediate neighbors must get more candies.</li>
</ul>
<p>Return the minimum number of candies you need to distribute to satisfy the above conditions.</p>

<pre><code class="language-java">Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate candies as follows: [2,1,2]

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate candies as follows: [1,2,1]</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Reward distribution with greedy strategy based on neighborhood comparisons.</li>
  <li><b>Why does it exist in Java?</b> Encourages mastery of greedy algorithms and array traversal.</li>
  <li><b>What problem does it solve?</b> Determines the minimal distribution that meets rating-based rules.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int candy(int[] ratings)</code></pre>
<p>This function returns the minimum number of candies needed.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Two Pass Greedy</h3>
<pre><code class="language-java">public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[n];
    Arrays.fill(candies, 1); // Step 1: Assign 1 candy to each child

    // Step 2: Left to Right
    for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }

    // Step 3: Right to Left
    for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }

    // Step 4: Sum total
    int sum = 0;
    for (int c : candies) sum += c;
    return sum;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Single Pass with Peaks & Valleys</h3>
<pre><code class="language-java">public int candy(int[] ratings) {
    int n = ratings.length, i = 0, total = 0;
    while (i < n) {
        int up = 0, down = 0;
        while (i + 1 < n && ratings[i] < ratings[i + 1]) { up++; i++; }
        while (i + 1 < n && ratings[i] > ratings[i + 1]) { down++; i++; }
        total += (up * (up + 1)) / 2 + (down * (down + 1)) / 2 + Math.max(up, down) + 1;
        if (i + 1 < n && ratings[i] == ratings[i + 1]) { total += 1; i++; }
    }
    return total;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Track increasing and decreasing sequences to assign candies.</li>
  <li>Ensure local peaks get max value between left and right passes.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Start with minimum 1 candy for every child.</li>
  <li>✔ Use two-pass approach for clarity; peak-valley for optimization.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Greedy algorithms</li>
  <li>Dynamic programming (alternative)</li>
  <li>Array traversal</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Common greedy problem that tests optimization and fairness logic</p>
<p><b>🏢 Real-world:</b> Reward distribution based on performance, priority queue modeling</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not updating both left and right passes properly</li>
  <li>❌ Missing equal-value neighbors handling</li>
</ul>
<p><b>🧪 Tip:</b> Visualize peaks and valleys with test cases like [1,2,3,2,1]</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No version-specific features used. Works on Java 7+</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 135: Candy</li>
  <li>Google/OA-type reward distribution questions</li>
  <li>Performance-to-reward scenarios in companies</li>
</ul>

---

