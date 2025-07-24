---

---

---

---

```
for (int i = 0; i < n; i++) {
    temp[(i + k) % n] = nums[i];
}

for (int i = 0; i < n; i++) {
    nums[i] = temp[i];
}
```

}

```
reverse(nums, 0, n - 1);       // reverse whole array
reverse(nums, 0, k - 1);       // reverse first k elements
reverse(nums, k, n - 1);       // reverse remaining n-k elements
```

}

private void reverse(int[] nums, int start, int end) { while (start < end) { int temp = nums[start]; nums[start] = nums[end]; nums[end] = temp; start++; end--; } }

---

---

---

---

---

---

---

---

