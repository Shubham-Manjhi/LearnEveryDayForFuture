<div align="center">
  <h1 style="color: #2C3E50; font-size: 32px;">Java Topic: <u>Collections Utility Class</u></h1>
</div>

---

<h2 style="color: #1F618D; text-align: center;">✅ 0. Introduction</h2>
<p>The <code>java.util.Collections</code> class is a utility class that consists exclusively of static methods that operate on or return collections. It provides methods for searching, sorting, reversing, synchronizing, and performing other routine data manipulation tasks on collections such as Lists, Sets, and Maps.</p>

---

<h2 style="color: #1F618D; text-align: center;">✅ 2. Syntax and Structure (With Detailed Explanation)</h2>

<h3 style="color: #117864;">1. sort(List<T> list)</h3>
<p>Sorts the list into ascending order according to the natural ordering of its elements.</p>
<pre><code>List<Integer> nums = Arrays.asList(4, 2, 9, 1);
Collections.sort(nums); // [1, 2, 4, 9]</code></pre>

<h3 style="color: #117864;">2. sort(List<T> list, Comparator<? super T> c)</h3>
<p>Sorts the list using the provided comparator.</p>
<pre><code>Collections.sort(nums, Collections.reverseOrder()); // [9, 4, 2, 1]</code></pre>

<h3 style="color: #117864;">3. reverse(List<?> list)</h3>
<p>Reverses the order of elements.</p>
<pre><code>Collections.reverse(nums); // [1, 9, 2, 4] -> [4, 2, 9, 1]</code></pre>

<h3 style="color: #117864;">4. shuffle(List<?> list)</h3>
<p>Randomly permutes the list using default randomness.</p>
<pre><code>Collections.shuffle(nums); // Random order like [2, 9, 4, 1]</code></pre>

<h3 style="color: #117864;">5. swap(List<?> list, int i, int j)</h3>
<p>Swaps the elements at positions i and j.</p>
<pre><code>Collections.swap(nums, 0, 2); // swaps first and third element</code></pre>

<h3 style="color: #117864;">6. fill(List<? super T> list, T obj)</h3>
<p>Replaces all elements with the specified object.</p>
<pre><code>Collections.fill(nums, 0); // All elements become 0</code></pre>

<h3 style="color: #117864;">7. copy(List<? super T> dest, List<? extends T> src)</h3>
<p>Copies elements from source to destination. Dest must be at least as long.</p>
<pre><code>List<String> dest = Arrays.asList("x", "x", "x");
List<String> src = Arrays.asList("a", "b", "c");
Collections.copy(dest, src); // dest becomes ["a", "b", "c"]</code></pre>

<h3 style="color: #117864;">8. min(Collection<? extends T> coll)</h3>
<p>Returns the minimum element according to natural ordering.</p>
<pre><code>int minVal = Collections.min(nums);</code></pre>

<h3 style="color: #117864;">9. max(Collection<? extends T> coll)</h3>
<p>Returns the maximum element.</p>
<pre><code>int maxVal = Collections.max(nums);</code></pre>

<h3 style="color: #117864;">10. frequency(Collection<?> c, Object o)</h3>
<p>Counts how many times the object appears in the collection.</p>
<pre><code>int freq = Collections.frequency(nums, 2);</code></pre>

<h3 style="color: #117864;">11. disjoint(Collection<?> c1, Collection<?> c2)</h3>
<p>Returns true if the two collections have no elements in common.</p>
<pre><code>boolean result = Collections.disjoint(Arrays.asList(1, 2), Arrays.asList(3, 4)); // true</code></pre>

<h3 style="color: #117864;">12. binarySearch(List<? extends Comparable<? super T>> list, T key)</h3>
<p>Performs binary search on a sorted list.</p>
<pre><code>Collections.sort(nums);
int index = Collections.binarySearch(nums, 2);</code></pre>

<h3 style="color: #117864;">13. replaceAll(List<T> list, T oldVal, T newVal)</h3>
<p>Replaces all old values with new value.</p>
<pre><code>Collections.replaceAll(nums, 2, 20);</code></pre>

<h3 style="color: #117864;">14. rotate(List<?> list, int distance)</h3>
<p>Rotates the list elements the specified distance.</p>
<pre><code>Collections.rotate(nums, 2);</code></pre>

<h3 style="color: #117864;">15. synchronizedList(List<T> list)</h3>
<p>Returns thread-safe version of list.</p>
<pre><code>List<String> sync = Collections.synchronizedList(new ArrayList<>());</code></pre>

<h3 style="color: #117864;">16. unmodifiableList(List<? extends T> list)</h3>
<p>Returns a read-only list.</p>
<pre><code>List<Integer> readonly = Collections.unmodifiableList(nums);</code></pre>

<h3 style="color: #117864;">17. singleton(T o)</h3>
<p>Returns immutable set with a single element.</p>
<pre><code>Set<String> single = Collections.singleton("Java");</code></pre>

<h3 style="color: #117864;">18. nCopies(int n, T o)</h3>
<p>Returns immutable list with n copies of object.</p>
<pre><code>List<String> copies = Collections.nCopies(3, "Hi"); // [Hi, Hi, Hi]</code></pre>

<h3 style="color: #117864;">19. emptyList()</h3>
<p>Returns immutable empty list.</p>
<pre><code>List<String> empty = Collections.emptyList();</code></pre>

<h3 style="color: #117864;">20. indexOfSubList(List<?> source, List<?> target)</h3>
<p>Returns the starting position of first occurrence of sublist.</p>
<pre><code>List<String> source = Arrays.asList("a", "b", "c", "d");
List<String> target = Arrays.asList("b", "c");
int index = Collections.indexOfSubList(source, target); // returns 1</code></pre>

<h3 style="color: #117864;">21. lastIndexOfSubList(List<?> source, List<?> target)</h3>
<p>Finds the last occurrence index of a sublist.</p>
<pre><code>int lastIndex = Collections.lastIndexOfSubList(source, target);</code></pre>

<h3 style="color: #117864;">22. singletonList(T o)</h3>
<p>Returns an immutable list with one element.</p>
<pre><code>List<String> single = Collections.singletonList("One");</code></pre>

<h3 style="color: #117864;">23. singletonMap(K key, V value)</h3>
<p>Returns immutable map with one key-value pair.</p>
<pre><code>Map<String, Integer> singleMap = Collections.singletonMap("A", 1);</code></pre>

<h3 style="color: #117864;">24. emptyMap(), emptySet()</h3>
<p>Returns immutable empty map/set.</p>
<pre><code>Map<String, String> emptyMap = Collections.emptyMap();
Set<Integer> emptySet = Collections.emptySet();</code></pre>

---

