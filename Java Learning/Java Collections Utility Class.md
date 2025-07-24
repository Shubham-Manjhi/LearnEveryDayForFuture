<div align="center">
  <h1 style="color: #2C3E50; font-size: 32px;">Java Topic: <u>Collections Utility Class</u></h1>
</div>

---

<h2 style="color: #1F618D; text-align: center;">✅ 0. Introduction</h2>
<p>The <code>java.util.Collections</code> class is a utility class that consists exclusively of static methods that operate on or return collections. It provides methods for searching, sorting, reversing, synchronizing, and performing other routine data manipulation tasks on collections such as Lists, Sets, and Maps.</p>

---

<h2 style="color: #1F618D; text-align: center;">✅ 1. Definition and Purpose</h2>
<ul>
  <li><strong>What is it?</strong> Collections is a final class in <code>java.util</code> package that contains static methods to manipulate collections.</li>
  <li><strong>Why does it exist?</strong> It simplifies common operations such as sorting, shuffling, min/max finding, etc., without rewriting boilerplate logic.</li>
  <li><strong>What problem does it solve?</strong> Helps avoid repetitive code and provides thread-safe and efficient manipulations of collections.</li>
</ul>

---

<h2 style="color: #1F618D; text-align: center;">✅ 2. Syntax and Structure</h2>
<p>The class is declared as:</p>
<pre><code class="language-java">public class Collections extends Object</code></pre>
<p>Methods include:</p>
<ul>
  <li><code>sort(List<T> list)</code> - Sorts list in natural order.</li>
  <li><code>sort(List<T> list, Comparator<? super T> c)</code> - Sorts list using Comparator.</li>
  <li><code>reverse(List<?> list)</code> - Reverses order of elements.</li>
  <li><code>shuffle(List<?> list)</code> - Randomizes list order.</li>
  <li><code>shuffle(List<?> list, Random rnd)</code> - Shuffles using Random generator.</li>
  <li><code>swap(List<?> list, int i, int j)</code> - Swaps two elements.</li>
  <li><code>fill(List<? super T> list, T obj)</code> - Replaces all elements with obj.</li>
  <li><code>copy(List<? super T> dest, List<? extends T> src)</code> - Copies source to destination.</li>
  <li><code>min(Collection<? extends T> coll)</code> - Returns minimum.</li>
  <li><code>min(Collection<? extends T> coll, Comparator<? super T> comp)</code> - With comparator.</li>
  <li><code>max(Collection<? extends T> coll)</code> - Returns maximum.</li>
  <li><code>max(Collection<? extends T> coll, Comparator<? super T> comp)</code> - With comparator.</li>
  <li><code>frequency(Collection<?> c, Object o)</code> - Count occurrences of object.</li>
  <li><code>disjoint(Collection<?> c1, Collection<?> c2)</code> - Checks if no common elements.</li>
  <li><code>binarySearch(List<? extends Comparable<? super T>> list, T key)</code> - Binary search.</li>
  <li><code>binarySearch(List<? extends T> list, T key, Comparator<? super T> c)</code> - Binary search with comparator.</li>
  <li><code>indexOfSubList(List<?> source, List<?> target)</code> - Finds first sublist index.</li>
  <li><code>lastIndexOfSubList(List<?> source, List<?> target)</code> - Finds last sublist index.</li>
  <li><code>replaceAll(List<T> list, T oldVal, T newVal)</code> - Replaces all occurrences.</li>
  <li><code>rotate(List<?> list, int distance)</code> - Rotates elements.</li>
  <li><code>synchronizedList(List<T> list)</code> - Thread-safe list.</li>
  <li><code>synchronizedMap(Map<K,V> m)</code> - Thread-safe map.</li>
  <li><code>synchronizedSet(Set<T> s)</code> - Thread-safe set.</li>
  <li><code>unmodifiableList(List<? extends T> list)</code> - Read-only list.</li>
  <li><code>unmodifiableMap(Map<? extends K,? extends V> m)</code> - Read-only map.</li>
  <li><code>unmodifiableSet(Set<? extends T> s)</code> - Read-only set.</li>
  <li><code>singleton(T o)</code> - Immutable singleton set.</li>
  <li><code>singletonList(T o)</code> - Immutable singleton list.</li>
  <li><code>singletonMap(K key, V value)</code> - Immutable singleton map.</li>
  <li><code>nCopies(int n, T o)</code> - Immutable list with n copies of element.</li>
  <li><code>emptyList()</code>, <code>emptySet()</code>, <code>emptyMap()</code> - Immutable empty collections.</li>
</ul>

---

<h2 style="color: #1F618D; text-align: center;">✅ 3. Practical Examples</h2>
<pre><code class="language-java">List<Integer> list = Arrays.asList(5, 3, 9, 1);
Collections.sort(list);
Collections.reverse(list);
int min = Collections.min(list);
int max = Collections.max(list);
Collections.rotate(list, 2);
Collections.fill(list, 7);
Collections.replaceAll(list, 7, 1);
List<String> sync = Collections.synchronizedList(new ArrayList<>());
Map<String, String> singleton = Collections.singletonMap("key", "value");
boolean disjoint = Collections.disjoint(list1, list2);
</code></pre>

---

