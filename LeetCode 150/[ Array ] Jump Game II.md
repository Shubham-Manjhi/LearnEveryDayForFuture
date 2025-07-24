<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Jump Game II (LeetCode 45)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given an array of non-negative integers <code>nums</code>, where each element represents the maximum jump length at that position, return the minimum number of jumps required to reach the last index.</p>

<pre><code class="language-java">Input: nums = [2,3,1,1,4]
Output: 2
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [2,3,0,1,4]
Output: 2</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Dynamic greedy approach to determine the fewest jumps needed to reach the last index.</li>
  <li><b>Why does it exist in Java?</b> Java supports fast iteration and optimization with clean syntax for greedy traversal.</li>
  <li><b>What problem does it solve?</b> Helps find the shortest path (minimum jumps) to the end using local optimal decisions.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int jump(int[] nums)</code></pre>
<p>Track the current range of reach and update jumps when range is exceeded.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Greedy (Optimized)</h3>
<pre><code class="language-java">public int jump(int[] nums) {
    int jumps = 0, currentEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currentEnd) {
            jumps++; // Increase the jump count
            currentEnd = farthest; // Set new boundary
        }
    }
    return jumps;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Dynamic Programming</h3>
<pre><code class="language-java">public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
            dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
        }
    }
    return dp[nums.length - 1];
}</code></pre>
<p><b>⏱ Time:</b> O(n^2), <b>💾 Space:</b> O(n)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Greedy expands window based on max reach</li>
  <li>Jump count increases each time we complete a window</li>
  <li>DP stores and updates minimum jumps required for each index</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use greedy for best performance</li>
  <li>✔ Use DP only for understanding or small inputs</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Greedy window expansion</li>
  <li>Dynamic Programming</li>
  <li>Graph reachability (in array form)</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Great for testing greedy optimization and range-based logic</p>
<p><b>🏢 Real-world:</b> Network packet routing, task prioritization, jump navigation systems</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Forgetting to stop loop at nums.length - 1</li>
  <li>❌ Incorrectly updating jump or range variables</li>
</ul>
<p><b>🧪 Tip:</b> Print currentEnd and farthest at each step for debugging</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No major updates specific to this logic in recent Java versions</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 45</li>
  <li>Smart pacing systems</li>
  <li>Minimum operation simulations</li>
</ul>

---

