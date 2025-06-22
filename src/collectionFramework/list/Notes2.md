# Difference Between `Arrays.asList()` and `List.of()` in Java

Both `Arrays.asList()` and `List.of()` create a `List` in Java, but they differ significantly in behavior, especially in terms of **mutability**, **null handling**, and **Java version compatibility**.

---

## ✅ 1. Mutability

| Feature               | `Arrays.asList()`                          | `List.of()` (Java 9+)                         |
|-----------------------|--------------------------------------------|-----------------------------------------------|
| **Mutable?**           | ✅ Yes (partially)                          | ❌ No (completely immutable)                   |
| **Add/Remove allowed?**| ❌ Cannot add/remove elements <br>✅ Can modify existing elements | ❌ Cannot add, remove, or modify elements |
| **Example**            | `list.set(0, 10); ✅`<br>`list.add(5); ❌`  | `list.set(0, 10); ❌` (throws exception)       |

---

## ✅ 2. Backed by Array

| Feature               | `Arrays.asList()`                          | `List.of()`                                   |
|-----------------------|--------------------------------------------|-----------------------------------------------|
| **Backed by array?**   | ✅ Yes – changes affect the original array | ❌ No – independent of any array              |

### Example:
```java
Integer[] arr = {1, 2, 3};
List<Integer> list = Arrays.asList(arr);
arr[0] = 100;  // list.get(0) becomes 100 too
```

## ✅ 3. Null Handling

| Feature               | `Arrays.asList()`                          | `List.of()`                                   |
|-----------------------|--------------------------------------------|-----------------------------------------------|
| **Allows nulls?**      | ✅ Yes                                     | ❌ Throws `NullPointerException`              |

### Example:
```java
Arrays.asList(1, null, 3);  // ✅ OK
List.of(1, null, 3);        // ❌ Runtime error
```

## ✅ 4. Performance and Use Case

### 🔹 `Arrays.asList()` is useful when:
- You need a **fixed-size** list.
- You want to **modify elements**, but **not add or remove** them.
- You're working in **Java 8 or earlier**.
- You're converting an existing **array to a list**.
- You **want to allow `null` values**.

### 🔹 `List.of()` (Java 9+) is useful when:
- You want a **completely immutable** list.
- You don’t need to **add, remove, or modify** elements.
- You're working in **Java 9 or later**.
- You want to **avoid `null` values** for safety and cleaner code.
- You want a **lightweight**, read-only list for constants or config.

## ✅ Quick Summary Table

| Feature              | `Arrays.asList()`        | `List.of()` (Java 9+)       |
|----------------------|--------------------------|------------------------------|
| Modifiable?          | ✅ Yes (elements only)    | ❌ No                        |
| Resizable?           | ❌ No                    | ❌ No                        |
| Allows `null`?       | ✅ Yes                   | ❌ No                        |
| Backed by array?     | ✅ Yes                   | ❌ No                        |
| Java version         | Java 1.2+               | Java 9+                     |

