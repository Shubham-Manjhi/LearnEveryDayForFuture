<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Triangle Minimum Path Sum (LeetCode 120)</u></h1>
</div>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given a triangle array, return the minimum path sum from top to bottom.</p>
<p>Each step you may move to adjacent numbers on the row below.</p>
<pre><code class="language-java">Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: 2 + 3 + 5 + 1 = 11</code></pre>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><strong>What is the concept?</strong> Use Dynamic Programming to track the minimum path sum from the bottom to the top.</li>
  <li><strong>Why does it exist in Java?</strong> Java’s efficient list structures and control flow support bottom-up transformations.</li>
  <li><strong>What problem does it solve?</strong> Efficiently computes the shortest path in a triangular grid with minimal overhead.</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int minimumTotal(List_List triangle)</code></pre>
<p>We use either top-down recursion + memo or bottom-up in-place transformation.</p>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>


<h3 style="color: #5D6D7E;">🔹 Approach 1: Bottom-Up Dynamic Programming (Optimized)</h3>
<pre><code class="language-java">public int minimumTotal(List_List triangle) {
    int n = triangle.size();
    int[] dp = new int[n + 1];


// Start from bottom row and move upwards
for (int i = n - 1; i >= 0; i--) {
    for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j); // Choose min adjacent and add current
    }
}
return dp[0]; // Top element holds the final result

}

<p><b>⏱ Time:</b> O(n²), <b>💾 Space:</b> O(n)</p>


<h3 style="color: #5D6D7E;">🔹 Approach 2: Top-Down Recursion with Memoization</h3>
<pre><code class="language-java">public int minimumTotal(List_List triangle) {
    int[][] memo = new int[triangle.size()][triangle.size()];
    for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
    return helper(triangle, 0, 0, memo);
}


private int helper(List<List> t, int i, int j, int[][] memo) {
if (i == t.size()) return 0;
if (memo[i][j] != Integer.MAX_VALUE) return memo[i][j];

int left = helper(t, i + 1, j, memo);
int right = helper(t, i + 1, j + 1, memo);
memo[i][j] = t.get(i).get(j) + Math.min(left, right); // Store result
return memo[i][j];

}

<p><b>⏱ Time:</b> O(n²), <b>💾 Space:</b> O(n²)</p>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Each level of triangle is processed to accumulate the shortest path using DP.</li>
  <li>Bottom-up reuses the same array for minimal space use.</li>
  <li>Top-down explores all paths recursively but stores interim results to save time.</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Always initialize memo arrays to max value or null.</li>
  <li>✔ Use bottom-up if space optimization is key.</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Dynamic Programming</li>
  <li>Divide & Conquer</li>
  <li>Memoization vs Tabulation</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><strong>🧠 Interview:</strong> Classic DP test of recursion vs iteration trade-off</p>
<p><strong>🏢 Real-world:</strong> Resource scheduling, minimal pathfinding, risk assessments</p>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not handling index boundaries correctly in top-down</li>
  <li>❌ Forgetting to reuse dp array for bottom-up optimization</li>
</ul>
<p><b>🧪 Tip:</b> Print memo or dp[] at each step to visualize transitions</p>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No version-specific changes. Java 8+ supports lambda streams but not required here.</p>



⸻


<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 120</li>
  <li>Daily travel cost optimizations</li>
</ul>



⸻
