# Java Map Implementations: Time Complexities and Explanations

## ✅ Summary Table: Time Complexity

| Operation     | HashMap (Avg) | HashMap (Worst) | LinkedHashMap (Avg) | LinkedHashMap (Worst) | TreeMap (Avg) | TreeMap (Worst) |
|---------------|----------------|------------------|-----------------------|-------------------------|----------------|------------------|
| `put(K,V)`    | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |
| `get(K)`      | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |
| `remove(K)`   | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |

---

## 📌 1. HashMap

### ✅ Average Case: O(1)
- Based on a **hash table** using **separate chaining**.
- Keys are hashed into buckets using `hashCode()`.
- Each bucket holds entries with the same hash using a **linked list** or **tree (Java 8+)**.
- Efficient when keys are **evenly distributed**.

### ❌ Worst Case: O(n)
- Happens when many keys hash to the **same bucket** (i.e., poor `hashCode()`).
- All entries stored in one bucket → **linear search**.
- Java 8+ converts the bucket to a **Red-Black Tree** if it grows too large, improving worst-case to **O(log n)** per bucket.

---

## 📌 2. LinkedHashMap

- Inherits everything from `HashMap`.
- Additionally maintains a **doubly linked list** to preserve **insertion** or **access order**.

### ✅ Average Case: O(1)
- Same as HashMap for basic operations.

### ❌ Worst Case: O(n)
- Same issue as HashMap when hash collisions occur.
- Slightly more **memory overhead** due to pointers for the linked list.

---

## 📌 3. TreeMap

- Implements the `NavigableMap` interface using a **Red-Black Tree**.
- Entries are kept **sorted** by natural order or custom comparator.

### ✅ Average and Worst Case: O(log n)
- Balanced binary tree ensures all operations take O(log n).
- No degradation due to hash collisions.

---
