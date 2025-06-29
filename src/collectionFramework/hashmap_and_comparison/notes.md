# Java Map Implementations: Time Complexities and Explanations

## Might Need Review - 29 June
## ✅ Summary Table: Time Complexity

| Operation       | HashMap (Avg) | HashMap (Worst) | LinkedHashMap (Avg) | LinkedHashMap (Worst) | TreeMap (Avg) | TreeMap (Worst) |
|-----------------|----------------|------------------|-----------------------|-------------------------|----------------|------------------|
| `put(K,V)`      | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |
| `get(K)`        | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |
| `remove(K)`     | O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |
| `containsKey(K)`| O(1)           | O(n)             | O(1)                  | O(n)                    | O(log n)       | O(log n)         |

---

## 📌 1. HashMap

### ✅ Average Case: O(1)
- Based on a **hash table** using **separate chaining**.
- Keys are hashed into buckets using `hashCode()`.
- Each bucket holds entries with the same hash using a **linked list** or **tree (Java 8+)**.
- Efficient when keys are **evenly distributed**.
- **Allows one `null` key and multiple `null` values.**

### ❌ Worst Case: O(n)
- This occurs when many keys hash to the **same bucket** (i.e., due to a poor `hashCode()` implementation or an unfortunate set of keys).
- All `n` entries end up stored in a single bucket, leading to a **linear search**.
- **Java 8+ Mitigation:** To prevent severe performance degradation, if a bucket's size exceeds a certain threshold (typically 8 elements), it is converted from a linked list to a **Red-Black Tree**. This improves the worst-case time complexity for operations within that specific bucket to **O(log n)**.

---

## 📌 2. LinkedHashMap

- Extends `HashMap` and **maintains a doubly linked list** running through all its entries.
- This linked list defines the iteration order, which is either **insertion order** (default) or **access order** (if configured for LRU cache-like behavior).

### ✅ Average Case: O(1)
- Same as `HashMap` for basic operations (`put`, `get`, `remove`, `containsKey`), as it still relies on the underlying hash table.
- **Allows one `null` key and multiple `null` values.**

### ❌ Worst Case: O(n)
- Shares the same worst-case scenarios as `HashMap` when hash collisions lead to all elements residing in a single bucket.
- Has slightly more **memory overhead** compared to `HashMap` due to the additional pointers required for the doubly linked list.

---

## 📌 3. TreeMap

- Implements the `NavigableMap` interface and is based on a **Red-Black Tree** data structure.
- Entries are kept **sorted** according to the keys' natural ordering or by a `Comparator` provided at map creation time.

### ✅ Average and Worst Case: O(log n)
- The balanced nature of the Red-Black Tree guarantees that all operations (`put`, `get`, `remove`, `containsKey`) have a time complexity of **O(log n)**, regardless of the key distribution.
- There is no degradation due to hash collisions, as it doesn't use hashing.
- **Important Note:** `TreeMap` **does not allow `null` keys**. Attempting to insert a `null` key will result in a `NullPointerException` if using natural ordering, or if the custom `Comparator` does not explicitly handle `null` values. `null` values are generally allowed.