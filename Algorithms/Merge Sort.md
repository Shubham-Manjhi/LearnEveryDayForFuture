# 🎯 Merge Sort — Concise Expert Guide (Java 🧠 + Python 🐍)

---

## 🔹 Quick TOC

- Overview
- Algorithm (steps)
- Properties (complexity, stability, space)
- Implementations
  - Java: Top‑Down (generic, single temp reuse)
  - Java: Bottom‑Up (iterative)
  - Java: Linked‑List variant
  - Java: Count inversions (merge-based)
  - Python equivalents (concise)
- Optimizations & variations
- When to use / tradeoffs
- Interview Q&A (compact answers)
- Testing & common pitfalls

---

## 🔹 Overview (1-paragraph)

Merge Sort is a classic **divide-and-conquer** sorting algorithm: split the array in half, recursively sort both halves, then merge the two sorted halves. It guarantees **O(n log n)** time in best/average/worst cases and is **stable** (preserves equal-element order) when implemented carefully.

---

## 🔹 Algorithm (steps)

1. If the range has ≤1 element, return.
2. Split at `mid = left + (right-left)/2`.
3. Recursively sort left and right halves.
4. Merge the two sorted halves into a temporary buffer and copy back.

---

## 🔹 Key Properties

| Property                       | Value                                                    |
| ------------------------------ | -------------------------------------------------------- |
| Time complexity                | **O(n log n)**                                           |
| Space complexity (array)       | **O(n)** (auxiliary array)                               |
| Space complexity (linked list) | **O(log n)** recursion (or O(1) iterative)               |
| Stable                         | **Yes**                                                  |
| In-place                       | **No** (for arrays; linked-list merge can be O(1) extra) |

---

## 🔹 Java — Top‑Down (recommended production pattern)

- Uses one temporary array reused across recursion to minimize allocations.

```java
import java.util.Arrays;

public class MergeSort {
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        if (a == null || a.length < 2) return;
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Comparable[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, tmp, left, mid);
        mergeSort(a, tmp, mid + 1, right);
        merge(a, tmp, left, mid, right);
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (a[i].compareTo(a[j]) <= 0) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= right) tmp[k++] = a[j++];
        System.arraycopy(tmp, left, a, left, right - left + 1);
    }

    // small demo
    public static void main(String[] args) {
        Integer[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

**Notes:** reuse `tmp` to avoid repeated allocations; use `<=` in comparison to keep stability.

---

## 🔹 Java — Bottom‑Up (iterative)

- Useful when recursion overhead is a concern or when you want non-recursive implementation.

```java
public static <T extends Comparable<? super T>> void mergeSortIterative(T[] a) {
    int n = a.length;
    @SuppressWarnings("unchecked") T[] tmp = (T[]) new Comparable[n];
    for (int width = 1; width < n; width *= 2) {
        for (int i = 0; i < n; i += 2 * width) {
            int left = i;
            int mid = Math.min(i + width - 1, n - 1);
            int right = Math.min(i + 2 * width - 1, n - 1);
            if (mid < right) merge(a, tmp, left, mid, right);
        }
    }
}
```

(Uses the same `merge` implementation shown earlier.)

---

## 🔹 Java — Linked‑List Merge Sort (O(1) extra memory)

- Merge sort is the go-to for singly-linked lists because splitting and merging are O(1) extra space.

```java
static class ListNode { int val; ListNode next; ListNode(int v){val=v;} }

public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    // split
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
    ListNode mid = slow.next; slow.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return mergeList(left, right);
}

private static ListNode mergeList(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0), cur = dummy;
    while (a != null && b != null) {
        if (a.val <= b.val) { cur.next = a; a = a.next; }
        else { cur.next = b; b = b.next; }
        cur = cur.next;
    }
    cur.next = (a != null) ? a : b;
    return dummy.next;
}
```

---

## 🔹 Java — Count Inversions (classic interview twist)

- Count number of pairs `(i,j)` with `i < j` and `a[i] > a[j]` via merge step.

```java
public static long countInversions(int[] a) {
    int n = a.length;
    int[] tmp = new int[n];
    return countInv(a, tmp, 0, n - 1);
}

private static long countInv(int[] a, int[] tmp, int left, int right) {
    if (left >= right) return 0;
    int mid = left + (right - left) / 2;
    long inv = countInv(a, tmp, left, mid) + countInv(a, tmp, mid + 1, right);
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
        if (a[i] <= a[j]) tmp[k++] = a[i++];
        else { tmp[k++] = a[j++]; inv += (mid - i + 1); }
    }
    while (i <= mid) tmp[k++] = a[i++];
    while (j <= right) tmp[k++] = a[j++];
    System.arraycopy(tmp, left, a, left, right - left + 1);
    return inv;
}
```

---

## 🔹 Python — Compact equivalents

```python
# Top-down
def merge_sort(a):
    if len(a) <= 1: return a
    mid = len(a)//2
    L = merge_sort(a[:mid])
    R = merge_sort(a[mid:])
    i=j=0; res=[]
    while i<len(L) and j<len(R):
        if L[i] <= R[j]: res.append(L[i]); i+=1
        else: res.append(R[j]); j+=1
    res.extend(L[i:]); res.extend(R[j:])
    return res

# Inversion count
def count_inversions(a):
    def sort_count(a):
        if len(a) <= 1: return a,0
        mid = len(a)//2
        L,li = sort_count(a[:mid])
        R,ri = sort_count(a[mid:])
        i=j=0; merged=[]; inv=li+ri
        while i<len(L) and j<len(R):
            if L[i] <= R[j]: merged.append(L[i]); i+=1
            else: merged.append(R[j]); j+=1; inv += len(L)-i
        merged += L[i:] + R[j:]
        return merged, inv
    _, inv = sort_count(a)
    return inv
```

---

## 🔹 Optimizations & Variations (quick bullets)

- **Temp reuse**: allocate one buffer and reuse across recursion.
- **Insertion sort cutoff**: for small arrays (e.g., size ≤ 16) use insertion sort — faster in practice.
- **Natural mergesort**: exploit existing runs in input to reduce work.
- **Parallel mergesort**: use ForkJoinPool / parallel streams for large arrays (careful about memory).
- **External merge sort**: for datasets larger than RAM — sort chunks, write runs, then k-way merge.
- **In-place merge**: complicated O(1) extra algorithms exist but are rarely worth it in interviews.

---

## 🔹 When to use / Tradeoffs

- Prefer Merge Sort when stability is required, sorting linked lists, or when worst-case O(n log n) is desirable.
- Quicksort often has better constant factors and is in-place; mergesort uses extra memory but is stable and predictable.

---

## 🔹 Common Interview Questions (short answers)

1. **Why is mergesort stable?** — During merge, when elements compare equal we take from the left first; relative order preserved.
2. **Complexity derivation?** — T(n)=2T(n/2)+Θ(n) ⇒ Θ(n log n) by Master Theorem.
3. **Space usage?** — Arrays: O(n) extra; Linked list: O(1) extra if you relink nodes.
4. **Mergesort vs Quicksort?** — M: stable, O(n) extra, guaranteed O(n log n). Q: in-place, average O(n log n), worst O(n^2).
5. **How to count inversions?** — Modify merge step to add (mid-i+1) when taking from right.
6. **How to implement generic mergesort in Java?** — Use `T[]` and `Comparable` or `Comparator<T>`; suppress unchecked cast for tmp.
7. **When is bottom‑up preferred?** — When avoiding recursion or tuning memory/cache behavior.
8. **How to test?** — Unit tests for sorted order, stability, edge cases (null, empty, one item), duplicate keys.

---

## 🔹 Testing & Pitfalls

- **Pitfalls**: wrong mid calculation (overflow — use `left + (right-left)/2`), forgetting `System.arraycopy`, off-by-one in merge loops, failing null checks.
- **Unit test ideas**: random arrays vs `Arrays.sort` comparison, arrays with duplicates, all-equal array, sorted/reversed inputs.

**JUnit snippet (very small):**

```java
@Test void testMergeSort() {
    Integer[] a = {3,1,2}; MergeSort.mergeSort(a);
    assertArrayEquals(new Integer[]{1,2,3}, a);
}
```

---

## 🔹 Mini trace (example) — array: [3,1,2]

Split -> [3] | [1,2] [1,2] -> [1] | [2] -> merge -> [1,2] Merge [3] and [1,2] => [1,2,3]

---

## 🔹 Quick checklist for interviews

- Be ready to explain recursion and merging loops line-by-line.
- Mention stability and where it matters.
- Describe memory tradeoffs and linked-list behavior.
- If asked for optimization: discuss insertion cutoff and temp reuse.

---

If you want, I can add a **parallel ForkJoin** implementation, a detailed **visual step-by-step** (ASCII or generated screenshot), or expand the **external k-way merge** section. Which one should I add next?

