<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Best Time to Buy and Sell Stock (LeetCode 121)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
<p>You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.</p>
<p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.</p>

<pre><code class="language-java">Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5

Input: prices = [7,6,4,3,1]
Output: 0</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Track minimum price to buy and compute max profit on-the-go.</li>
  <li><b>Why does it exist in Java?</b> Java enables efficient linear scan with constant memory tracking for stock analysis problems.</li>
  <li><b>What problem does it solve?</b> Solves optimal buy/sell strategy in a time-series array.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int maxProfit(int[] prices)</code></pre>
<p>Use a single pass loop maintaining a running minimum and checking max profit at each step.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Brute Force (Compare All Pairs)</h3>
<pre><code class="language-java">public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
    }
    return maxProfit;
}</code></pre>
<p><b>⏱ Time:</b> O(n<sup>2</sup>), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: One Pass (Optimized)</h3>
<pre><code class="language-java">public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price; // Step 1: Track minimum so far
        } else {
            maxProfit = Math.max(maxProfit, price - minPrice); // Step 2: Compare potential profit
        }
    }
    return maxProfit;
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Track minimum price seen so far</li>
  <li>At each day, compute profit = current - minPrice</li>
  <li>Update max profit if better found</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Use single loop with minimum tracker</li>
  <li>✔ Avoid unnecessary array copies or nested loops</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Sliding window (fixed left, moving right)</li>
  <li>Dynamic minimum tracking</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Used to test greedy approaches and linear-time reasoning</p>
<p><b>🏢 Real-world:</b> Stock trading signal processing and historical data analysis</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Forgetting to update min before checking profit</li>
  <li>❌ Initializing minPrice to 0 instead of MAX_VALUE</li>
</ul>
<p><b>🧪 Tip:</b> Log each price, minPrice, and maxProfit during loop to trace errors</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Java 8 Streams can be used to iterate and filter, but not optimal for stateful tracking problems like this.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 121</li>
  <li>Stock signal analyzer</li>
</ul>

---

