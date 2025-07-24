<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Remove Duplicates from Sorted Array (LeetCode 26)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>

<p>Given an integer array <code>nums</code> sorted in non-decreasing order, remove the duplicates <b>in-place</b> such that each unique element appears only once. Return the new length of the array.</p>
<p>Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.</p>

<pre><code class="language-java">Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> In-place deduplication of sorted arrays.</li>
  <li><b>Why does it exist in Java?</b> Efficient memory usage when processing large datasets.</li>
  <li><b>What problem does it solve?</b> Removes redundant values, preserving uniqueness and order.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public int removeDuplicates(int[] nums)</code></pre>
<ul>
  <li>Uses two-pointer technique.</li>
  <li>Returns the number of unique elements.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Two Pointer (Optimized)</h3>
<pre><code class="language-java">public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0; // pointer for the last unique index

        // Step 1: loop through the array
        for (int j = 1; j < nums.length; j++) {
            // Step 2: if the current value is different from the last unique
            if (nums[j] != nums[i]) {
                i++; // move forward
                nums[i] = nums[j]; // copy unique value
            }
        }
        // Step 3: return number of unique elements
        return i + 1;
    }
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Overwrite with Set (Not In-Place)</h3>
<pre><code class="language-java">public class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) set.add(num);

        int i = 0;
        for (int val : set) nums[i++] = val;

        return set.size();
    }
}</code></pre>
<p><b>Note:</b> Not allowed in interviews if in-place required.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Only distinct elements copied forward</li>
  <li>Sorted nature simplifies comparison</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Check edge case: empty array</li>
  <li>✔ Return the length and ignore values beyond that</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Sorted array traversal</li>
  <li>Two pointer algorithm</li>
  <li>In-place modification</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Common for testing pointer logic and in-place memory skills</p>
<p><b>🏢 Real-world:</b></p>
<ul>
  <li>Cleaning sensor data</li>
  <li>Removing repeated time series entries</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Returning wrong index</li>
  <li>❌ Not checking for length 0 or 1</li>
</ul>
<p><b>🧪 Tip:</b> Add debug prints for i, j and array at each step</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>Java 8 Set streams available, but not valid for in-place logic.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 26</li>
  <li>Data cleaning and deduplication pipelines</li>
</ul>

---

