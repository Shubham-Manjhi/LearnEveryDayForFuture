<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Best Time to Buy and Sell Stock II (LeetCode 122)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
<p>On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time, but you may buy it then sell it on the same day.</p>
<p>Return the maximum profit you can achieve.</p>

<pre><code class="language-java">Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price=1) and sell on day 3 (price=5), profit = 4.
Then buy on day 4 (price=3) and sell on day 5 (price=6), profit = 3.

Input: prices = [1,2,3,4,5]
Output: 4</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Multiple buy-sell transactions to accumulate profit from every rise.</li>
  <li><b>Why does it exist in Java?</b> Java arrays and loops enable efficient simulations of greedy strategies.</li>
  <li><b>What problem does it solve?</b> Solves the problem of maximizing profit through repeated transactions.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int maxProfit(int[] prices)</code></pre>
<p>Loop through the array, buy low and sell at every peak, add up all positive profits.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Brute Force (All Transaction Pairs)</h3>
<pre><code class="language-java">public int maxProfit(int[] prices) {
    int n = prices.length;
    int profit = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (prices[j] > prices[i]) {
                int currentProfit = prices[j] - prices[i];
                profit = Math.max(profit, currentProfit);
            }
        }
    }
    return profit;
}</code></pre>
<p><b>⏱ Time:</b> O(n<sup>2</sup>), <b>💾 Space:</b> O(1) — Not efficient</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Greedy One Pass (Optimized)</h3>
<pre><code class="language-java">public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1]; // Step 1: Accumulate profit on every rise
        }
    }
    return profit; // Step 2: Return total profit
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Loop compares each day's price to previous</li>
  <li>Accumulate all positive gains</li>
  <li>Greedy: Always take current profit if it exists</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Avoid nested loops for performance</li>
  <li>✔ Accumulate local increases — greedy is optimal here</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Greedy Algorithm</li>
  <li>Array traversals</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Checks for greedy understanding, loop logic, and state tracking.</p>
<p><b>🏢 Real-world:</b> Used in trade bots, finance simulations, market strategy models.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Trying to track every valley/peak explicitly</li>
  <li>❌ Forgetting to compare only when prices[i] > prices[i-1]</li>
</ul>
<p><b>🧪 Tip:</b> Print daily profit to validate logic in each step</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No major changes for this logic in Java updates. Loop logic is universally supported.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 122</li>
  <li>Market simulation engines</li>
</ul>

---

