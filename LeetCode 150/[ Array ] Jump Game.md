<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Jump Game (LeetCode 55)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given an array of non-negative integers <code>nums</code>, you are initially positioned at the first index of the array.</p>
<p>Each element in the array represents your maximum jump length at that position.</p>
<p>Return <b>true</b> if you can reach the last index, or <b>false</b> otherwise.</p>

<pre><code class="language-java">Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
Explanation: No matter what, you will always arrive at index 3 with a jump length 0.
</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Dynamic reachability: determine if a path to the end exists from the beginning using jump capacity.</li>
  <li><b>Why does it exist in Java?</b> Java provides arrays, loops, and conditionals to evaluate reachability step-by-step.</li>
  <li><b>What problem does it solve?</b> Ensures that a player or token can traverse a series of jumps to a target.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public boolean canJump(int[] nums)</code></pre>
<p>Traverse the array from left to right, tracking the farthest index reachable at each step.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Greedy - Track Farthest Reachable Index</h3>
<pre><code class="language-java">public boolean canJump(int[] nums) {
    int maxReach = 0; // Step 1: Maximum index we can currently reach
    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false; // Step 2: If we are beyond maxReach, we can't move forward
        maxReach = Math.max(maxReach, i + nums[i]); // Step 3: Update reachable index
    }
    return true; // Step 4: If we finish loop, we can reach the end
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Backward Traversal (Optimized)</h3>
<pre><code class="language-java">public boolean canJump(int[] nums) {
    int goal = nums.length - 1; // Step 1: Start from the last index
    for (int i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= goal) {
            goal = i; // Step 2: Update goal to new reachable position
        }
    }
    return goal == 0; // Step 3: If goal is 0, we can reach start from end
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Greedy forward tracks the farthest jump</li>
  <li>Backward tracks if the goal is reachable from previous points</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Always check if index surpasses the maxReach in greedy</li>
  <li>✔ Use backward traversal for early optimization and reduced complexity</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Greedy Algorithms</li>
  <li>Array Range Checking</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Asked in companies like Amazon, Google, Meta to test greedy logic understanding.</p>
<p><b>🏢 Real-world:</b> Network packet transmission, memory block allocation simulations.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not checking max reach properly</li>
  <li>❌ Using DFS/backtracking (too slow)</li>
</ul>
<p><b>🧪 Tip:</b> Print maxReach or goal at each iteration to trace your logic.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No special updates needed. Loops and math logic apply to all Java versions.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 55: Jump Game</li>
  <li>Game movement simulations</li>
  <li>Path planning problems</li>
</ul>

---

