# Understanding Java's Set Implementations

## Introduction to HashSet

- In Java, **HashSet** is commonly used when random access to elements is desired.
- Elements in a hash table are accessed using **hash codes**.
- The **hash code** of an element is a unique identity that helps to locate the element within a hash table.
- **HashSet cannot contain duplicate elements**; therefore, each HashSet element inherently possesses a unique hash code.

---

## Time Complexity of Various Set Types

| Set Type        | Add      | Remove   | Search   | Order Maintained | Internal Structure                                          |
|-----------------|----------|----------|----------|------------------|-------------------------------------------------------------|
| HashSet         | O(1)*    | O(1)*    | O(1)*    | No               | HashMap                                                     |
| LinkedHashSet   | O(1)*    | O(1)*    | O(1)*    | Yes (insertion)  | LinkedHashMap(HashMap + Linked List)                        |
| TreeSet         | O(log n) | O(log n) | O(log n) | Yes (sorted)     | TreeMap(Red-Black Tree (self-balancing binary search tree)) |
*O(1) on average / amortized 
(assuming well-distributed hash codes and occasional internal resizing)

> **⚠️ Note on HashSet and LinkedHashSet Time Complexity:**
> For both HashSet and LinkedHashSet, operations like add(), remove(), and contains() are typically O(1) on average due to the underlying HashMap.
However, in worst-case scenarios—such as when many elements hash to the same bucket (poorly distributed hashCode() values)—performance can degrade to O(n), as linear or tree traversal within the bucket may be required.
LinkedHashSet additionally maintains insertion order via a linked list, but this has negligible performance impact for individual operations.Note on LinkedHashSet Time Complexity:**
---

## Key Differences

### HashSet

- Stores elements in **random order**; does not guarantee the order of insertion or any specific order.
- **Does not allow duplicate elements.**
- All operations (add, remove, search) are **O(1) on average / amortized**.
- Internally uses a **HashMap**.
  - Each element in the HashSet is stored as a key in the internal HashMap, with a constant dummy value (usually PRESENT).

### LinkedHashSet

- Stores elements in the **order in which they were added** (insertion order).
- **Does not allow duplicate elements.**
- Add, remove, and search operations are **O(1) on average / amortized**.
- Internally uses a **LinkedHashMap**, which is itself
  - A HashMap that maintains a doubly linked list of entries. 
  - This list preserves the insertion order.

### TreeSet

- Stores elements in **sorted order**, either naturally (using the `Comparable` interface) or based on a custom `Comparator`.
- **Does not allow duplicate elements.**
- Add, remove, and search operations are **O(log N)**.
- Internally uses a **TreeMap**
  - TreeMap uses a Red-Black Tree, which is a kind of self-balancing binary search tree.

---

## C++ vs Java Set Collections

| C++ STL Container         | Java Equivalent                     |
|---------------------------|--------------------------------------|
| `std::unordered_set`      | `HashSet`, `LinkedHashSet`           |
| `std::set`                | `TreeSet`                            |
| `std::multiset`           | ❌ No direct equivalent in Java       |
| `std::unordered_multiset` | ❌ No direct equivalent in Java       |

> **Note:**  
> Java’s Collection Framework does **not** have built-in support for **multisets** (collections that allow duplicates).  
> You can simulate this behavior using:
> - **Google Guava’s `Multiset`**

---

## Key Concepts

### HashSet: Uniqueness and Hashing

- A **HashSet** does not allow duplicate entries.
- It uses the `hashCode()` and `equals()` methods to determine the uniqueness of elements.

---

## Custom Class (Student) Example

```java
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // equals() and hashCode() are NOT overridden
}
```

### Default Behavior without equals() and hashCode() Overrides

- By default, Java uses object references (memory addresses) to compare objects if these methods are not overridden.

#### What Happens in Your Code

- `set1.add(new Student(1, "Deepak"))` multiple times:
   - Each `new Student(1, "Deepak")` creates a new object in memory.
   - Since the `Student` class does not override `equals()` and `hashCode()`, these are treated as different objects based on their memory addresses.
   - Therefore, all distinct `Student` objects (even with the same id and name) will be added to `set1`.

- `set2.add(student1)` multiple times:
   - If `student1` is a single `Student` object reference, e.g., `Student student1 = new Student(1, "Deepak");`, then adding `student1` multiple times to `set2` will result in `set2` containing only one instance of that specific object.
   - HashSet identifies it as a duplicate because it's the exact same object reference, so it's only added once.

---

# How HashSet Works Internally (Add Operation)

1. **Call `hashCode()`**  
   The `hashCode()` of the object is called to determine the initial *bucket* where the object might reside.

2. **Search the Bucket:**
  - If the bucket is empty: The object is added directly.
  - If the bucket is not empty:
    - The new object is compared with existing objects in that bucket using the `equals()` method.
    - If any existing object is equal to the new object, it's considered a duplicate, and the new object is **not added**.
    - If none of the existing objects are equal to the new object, it's considered **unique** and is added to the list (or chain/tree) within that bucket.

---

## HashSet and Object Uniqueness

HashSet uses a combination of `hashCode()` and `equals()` to determine object uniqueness:

1. **`hashCode()`** is used to locate the correct **bucket** in the hash table.
2. **`equals()`** is used to check if an object in the same bucket is *equal* to the new one.

To prevent duplicates, **both methods must behave consistently**:

- If two objects are logically equal (as per `equals()`), they must also return the same `hashCode()`.
- If this contract is broken, unexpected duplicates can appear in the set.

---

### 🔍 Case 1: `equals()` and `hashCode()` are **NOT overridden**

- Java uses the default implementations from `Object` class:
  - `hashCode()` → returns a value based on **memory address**
  - `equals()` → compares **object references** (`this == other`)
- So even if two `Student` objects have the same `rollNo` and `name`, they are treated as **different** if they are separate objects.
- ✅ **Result:** Both objects are added to the `HashSet` — duplicate not detected.

---

### 🔍 Case 2: Only `hashCode()` is overridden, but `equals()` is NOT

- Two objects with the same `rollNo` may return the same `hashCode()` and go to the same **bucket**.
- However, since `equals()` is not overridden, it still compares **memory references** → returns `false`.
- So, within the same bucket, the set still sees them as **different**.
- ❌ **Result:** Both are added — **duplicate not avoided**.

---

### ✅ Conclusion

- Overriding **only one** of `hashCode()` or `equals()` is **not enough**.
- You must override **both**, and ensure they are **consistent**:

```text
If equals() returns true → hashCode() must return the same value.
If equals() returns false → hashCode() may or may not be the same.
```
---

### equals() and hashCode() for Wrapper Classes and Strings

- `equals()` and `hashCode()` methods are already correctly overridden for Java's wrapper classes (e.g., `Integer`, `Double`) and `String` class.
- Therefore, explicit overriding is not required when using these types in `HashSet`.

---

## What is a "Bucket" in HashSet?

- A "bucket" is **not a single slot** in the hash table.
- It is actually a data structure (typically a `LinkedList` or, in modern Java for high collision rates, a `TreeNode` structure) that holds entries that share the same `hashCode`.
- When two or more objects have the same `hashCode` (a "collision"), they are stored in the same bucket, typically in a list or chain form.
- Java does not discard new objects just because their `hashCode` maps to a bucket that already contains objects. Instead, it proceeds to check `equals()` with all items in that bucket.
- If no object in the bucket is equal to the new object, the new object is added to that list inside the bucket.

---

## Sorting Custom Objects in TreeSet

To sort `TreeSet`s of custom objects, the custom object class needs to either:

- Implement the `Comparable` interface (for natural ordering), **or**
- Pass a custom `Comparator` function to the `TreeSet` constructor.


> **⚠️ Note:**  
> If you try to add custom objects to a `TreeSet` **without**:
> - implementing the `Comparable` interface in the object class, **and**
> - providing a `Comparator` when creating the `TreeSet`,
>
> Java will throw a **`ClassCastException`** at runtime because it won’t know how to compare the elements.


---
## Object Comparison Logic in Sets

| Feature           | `HashSet`                                     | `LinkedHashSet`                                   | `TreeSet`                                                               |
| :---------------- | :-------------------------------------------- | :------------------------------------------------ | :---------------------------------------------------------------------- |
| **Uniqueness** | Determined by `equals()` and `hashCode()`     | Determined by `equals()` and `hashCode()`         | Determined by comparison logic (`compareTo` or `compare` methods)         |
| **Order** | No guaranteed order (random)                  | Preserves **insertion order** | Maintains elements in **sorted order** |
| **Sorting Role** | No role                                       | Not considered                                    | **Crucial**; elements are ordered based on `Comparable` or `Comparator` |
| **Duplicate Check** | If `equals()` returns `true` and `hashCode()` are same, it's a duplicate. | If `equals()` returns `true` and `hashCode()` are same, it's a duplicate. | If comparison logic returns `0`, it's treated as a **duplicate** and not added. |

- In `HashSet`, **only uniqueness matters**, determined using `equals()` and `hashCode()`.
  - Sorting or insertion order has **no role**.
- In `LinkedHashSet`, uniqueness is still based on `equals()` and `hashCode()`, but **insertion order is preserved**.
  - Sorting is **not** considered.
- In `TreeSet`, both **sorting** and **uniqueness** depend on the comparison logic (`Comparable` or `Comparator`).
  - If the comparison returns `0`, the element is treated as a **duplicate** and is not added, even if other fields differ.
