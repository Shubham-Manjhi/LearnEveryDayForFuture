<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Trapping Rain Water (LeetCode 42)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.</p>

<pre><code class="language-java">Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation:
           |
       |   |||
     | ||||||||
     012345678901  <- index
Trapped water: Positions 2, 4, 5, 6, 8, 10 each store 1 unit of water.
</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Water can be trapped between bars if a shorter bar is between taller bars on both sides.</li>
  <li><b>Why does it exist in Java?</b> Efficient memory and loop structures allow solving array-based problems easily.</li>
  <li><b>What problem does it solve?</b> Computes total units of water held in valleys between bars after rain.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int trap(int[] height)</code></pre>
<p>This function calculates total trapped water using either precomputed boundaries or two-pointer method.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Precompute Left/Right Max Arrays</h3>
<pre><code class="language-java">public int trap(int[] height) {
    int n = height.length;
    if (n == 0) return 0;
    
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    int water = 0;
    for (int i = 0; i < n; i++) {
        water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return water;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Two Pointers (Optimized)</h3>
<pre><code class="language-java">public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) leftMax = height[left];
            else water += leftMax - height[left];
            left++;
        } else {
            if (height[right] >= rightMax) rightMax = height[right];
            else water += rightMax - height[right];
            right--;
        }
    }
    return water;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Track maximum height from left and right boundaries</li>
  <li>For each index, find the minimum of the two and subtract height[i] to get trapped water</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use two-pointer approach for constant space</li>
  <li>✔ Avoid recomputing max boundaries during iteration</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Two-pointer techniques</li>
  <li>Prefix maximum/suffix maximum arrays</li>
  <li>Valley and peak analysis</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Tests dynamic tracking and space optimization</p>
<p><b>🏢 Real-world:</b> Terrain modeling, fluid simulations, urban drainage simulations</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Forgetting to handle zero-length input</li>
  <li>❌ Misusing max or min while computing boundaries</li>
</ul>
<p><b>🧪 Tip:</b> Print leftMax, rightMax, and index to trace logic</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No special changes; compatible with Java 7+.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 42</li>
  <li>Geography simulations</li>
  <li>Urban planning and water retention problems</li>
</ul>

---