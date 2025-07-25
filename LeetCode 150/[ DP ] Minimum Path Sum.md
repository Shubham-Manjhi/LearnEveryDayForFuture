<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Minimum Path Sum (LeetCode 64)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given a <code>m x n</code> grid filled with non-negative numbers, find a path from top-left to bottom-right, which minimizes the sum of all numbers along its path.</p>
<p>You can only move either down or right at any point in time.</p>

<pre><code class="language-java">Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Input: grid = [[1,2,3],[4,5,6]]
Output: 12</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Dynamic Programming on a 2D grid to find optimal path sum.</li>
  <li><b>Why does it exist in Java?</b> To solve matrix traversal and optimization problems efficiently.</li>
  <li><b>What problem does it solve?</b> Helps compute shortest or minimum-cost paths in matrices.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int minPathSum(int[][] grid)</code></pre>
<p>Use a 2D DP table or in-place update of the grid to store minimum costs.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: DP with Extra Matrix</h3>
<pre><code class="language-java">public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];

    dp[0][0] = grid[0][0];
    // Fill first row
    for (int i = 1; i < n; i++) {
        dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    // Fill first column
    for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    // Fill the rest
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
    }
    return dp[m - 1][n - 1];
}</code></pre>
<p><b>⏱ Time:</b> O(mn), <b>💾 Space:</b> O(mn)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: In-Place DP (Optimized)</h3>
<pre><code class="language-java">public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) continue;
            else if (i == 0)
                grid[i][j] += grid[i][j - 1];
            else if (j == 0)
                grid[i][j] += grid[i - 1][j];
            else
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
    }
    return grid[m - 1][n - 1];
}</code></pre>
<p><b>⏱ Time:</b> O(mn), <b>💾 Space:</b> O(1) (in-place)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Top-down dynamic programming</li>
  <li>Build solution incrementally using subproblem results</li>
  <li>Store cumulative costs in grid or separate DP array</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use in-place optimization when memory is constrained</li>
  <li>✔ Always initialize the first row and column</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Dynamic Programming</li>
  <li>Matrix traversal</li>
  <li>Memoization</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Often used to test DP, matrix traversal, or space optimization skills</p>
<p><b>🏢 Real-world:</b> Used in robotics path planning, grid-based routing algorithms</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Forgetting to initialize first row and column</li>
  <li>❌ Overwriting original values incorrectly</li>
</ul>
<p><b>🧪 Tip:</b> Print DP matrix after computation to validate path cost calculation</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Compatible with all Java versions. Java 8+ allows using Streams, but not ideal for this imperative pattern.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 64</li>
  <li>Game pathfinding, delivery robots, map grid traversal</li>
</ul>

---

