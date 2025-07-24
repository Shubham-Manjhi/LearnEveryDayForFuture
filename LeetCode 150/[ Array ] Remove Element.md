<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Remove Element (LeetCode 27)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>

<p>Given an array <code>nums</code> and a value <code>val</code>, remove all instances of that value <b>in-place</b> and return the new length. The order of elements can be changed. It doesn't matter what you leave beyond the new length.</p>

<pre><code class="language-java">Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,3,0,4,_,_,_]</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>

<ul>
<li><b>What is the concept?</b> <br> Remove matching values from an array in-place.</li>
<li><b>Why does it exist in Java?</b> <br> Java allows in-place mutation of arrays which saves memory and improves performance.</li>
<li><b>What problem does it solve?</b> <br> Helps efficiently reduce an array’s size based on a filter condition.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>

<p><b>Function signature:</b></p>
<pre><code class="language-java">public int removeElement(int[] nums, int val)</code></pre>

<p><b>Key points:</b></p>
<ul>
  <li>In-place mutation</li>
  <li>Return new length</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Two Pointer (Optimized)</h3>
<pre><code class="language-java">public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for placement

        // Step 1: Traverse entire array
        for (int j = 0; j < nums.length; j++) {
            // Step 2: If current element is not equal to val, keep it
            if (nums[j] != val) {
                nums[i] = nums[j]; // Step 3: Place it at the current i position
                i++;               // Step 4: Move placement pointer forward
            }
        }

        // Step 5: i is the new length of the array
        return i;
    }
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Swap with End (Fewer writes if val is rare)</h3>
<pre><code class="language-java">public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;

        // Step 1: Loop while i < n
        while (i < n) {
            if (nums[i] == val) {
                // Step 2: Replace nums[i] with last unprocessed item
                nums[i] = nums[n - 1];
                n--; // Step 3: Reduce size
            } else {
                i++; // Step 4: Move forward
            }
        }

        // Step 5: n is the new length
        return n;
    }
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>

<ul>
<li>First approach preserves order</li>
<li>Second approach is better when val is rare because it does fewer writes</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>

<ul>
<li>✔ Choose approach based on how frequent val appears</li>
<li>✔ Always return new length and ignore trailing values</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>

<ul>
<li>In-place algorithms</li>
<li>Filtering arrays</li>
<li>Two pointer technique</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>

<p><b>🧠 Interview:</b> Asked to assess in-place operations and pointer manipulation</p>
<p><b>🏢 Real-world:</b></p>
<ul>
<li>Log filtering</li>
<li>Sensor cleanup</li>
<li>Data normalization</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>

<ul>
<li>❌ Not updating the correct index</li>
<li>❌ Forgetting to handle edge cases like empty array</li>
</ul>

<p>🧪 <b>Debug Tip:</b> Print intermediate i, j and nums[] states</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>

<p>Java 8 Streams can be used but do not allow in-place mutation. Must copy instead.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>

<p>📝 <b>Practice on:</b></p>
<ul>
<li>LeetCode 27: Remove Element</li>
<li>Filter Arrays by Criteria</li>
</ul>

<p>🏗 <b>Apply in:</b></p>
<ul>
<li>ETL pipelines</li>
<li>Real-time data filtering systems</li>
</ul>

---

