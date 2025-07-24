<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">Java Problem: <u>Rotate Array (LeetCode 189)</u></h1>
</div>

---

<h2 style="color: #117A65; text-align: center;">✅ 0. Question & Explanation</h2>
<p>Given an integer array <code>nums</code>, rotate the array to the right by <code>k</code> steps, where <code>k</code> is non-negative.</p>
<pre><code class="language-java">Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]</code></pre>

---

<h2 style="color: #117A65; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><b>What is the concept?</b> Circularly shifting elements of an array.</li>
  <li><b>Why does it exist in Java?</b> Useful for cyclic data structures, queues, buffer rotation.</li>
  <li><b>What problem does it solve?</b> Implements a logical data rotation without creating new arrays.</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 2. Syntax and Structure</h2>
<pre><code class="language-java">public void rotate(int[] nums, int k)</code></pre>
<ul>
  <li>In-place operation (space optimized)</li>
  <li>Uses reverse strategy or cyclic replacement</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 3. Practical Examples</h2>

<h3 style="color: #5D6D7E;">🔹 Approach 1: Using Reverse (Optimized)</h3>
<pre><code class="language-java">public void rotate(int[] nums, int k) {
    k = k % nums.length; // Step 1: Normalize k if > length
    reverse(nums, 0, nums.length - 1);         // Step 2: Reverse entire array
    reverse(nums, 0, k - 1);                   // Step 3: Reverse first part
    reverse(nums, k, nums.length - 1);         // Step 4: Reverse second part
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(1)</p>

<h3 style="color: #5D6D7E;">🔹 Approach 2: Using Extra Array</h3>
<pre><code class="language-java">public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[(i + k) % n] = nums[i]; // Step 1: Shift index using modulo
    }
    for (int i = 0; i < n; i++) {
        nums[i] = result[i]; // Step 2: Copy back to original
    }
}</code></pre>
<p><b>⏱ Time:</b> O(n), <b>💾 Space:</b> O(n)</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 4. Internal Working</h2>
<ul>
  <li>Reverse method flips portions of the array efficiently</li>
  <li>Modulo ensures circular indexing</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 5. Best Practices</h2>
<ul>
  <li>✔ Normalize k to avoid unnecessary loops</li>
  <li>✔ Prefer reverse technique for in-place rotation</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 6. Related Concepts</h2>
<ul>
  <li>Array manipulation</li>
  <li>Two-pointer techniques</li>
  <li>Modulo arithmetic</li>
</ul>

---

<h2 style="color: #117A65; text-align: center;">✅ 7. Interview & Real-world Use</h2>
<p><b>🧠 Interview:</b> Frequently used to test array manipulation and space/time optimization.</p>
<p><b>🏢 Real-world:</b>
<ul>
  <li>Log file rotations</li>
  <li>Buffer cycling in streaming systems</li>
</ul>
</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 8. Common Errors & Debugging</h2>
<ul>
  <li>❌ Not using modulo on k</li>
  <li>❌ Confusing in-place vs extra array approaches</li>
</ul>
<p><b>🧪 Tip:</b> Add debug prints for k and array states after each reverse</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 9. Java Version Updates</h2>
<p>No API-level update. Java 8 streams are not suitable for in-place modifications.</p>

---

<h2 style="color: #117A65; text-align: center;">✅ 10. Practice and Application</h2>
<ul>
  <li>LeetCode 189</li>
  <li>Stream buffer management</li>
</ul>

---

