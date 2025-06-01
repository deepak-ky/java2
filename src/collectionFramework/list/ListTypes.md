### Different Types of List

#### 1. ArrayList
- Provides dynamic arrays in Java.
- May be slower than standard arrays but helpful for programs requiring extensive manipulation of arrays.
- The size of an `ArrayList` increases automatically if the collection grows or shrinks when objects are removed.

#### 🔍 What is Resizing in ArrayList?

An `ArrayList` in Java is backed by an array. Arrays have **fixed size**, so when you keep adding elements beyond its current capacity, the `ArrayList` has to **resize** its internal array to accommodate more elements.

---

#### 🔧 How Resizing Happens

**Initial Capacity:**  
When you create an `ArrayList`, it starts with a default capacity (usually **10**).

**When Full:**  
When you try to add an element and the internal array is **full**, resizing is triggered.

**New Capacity:**  
The new capacity is calculated as:

```java
newCapacity = oldCapacity + (oldCapacity / 2)
```

- Frequent resizing operations can lead to performance overhead.
- If the capacity increased by just 1 each time an element is added beyond the current size (e.g., from 10 to 11 to 12...), multiple costly resizes would occur.
- To reduce this overhead, the ArrayList increases its capacity by a growth factor (usually 1.5x) each time it resizes. This reduces the number of times resizing occurs, thereby improving performance.

---

#### 2. LinkedList 
- Implements the `LinkedList` data structure, which is a linear data structure.
- Elements are not stored in contiguous locations; every element is a separate object with a data part and address part.
- Elements are linked using pointers and addresses, and each element is known as a node.
- It is a _**`doubly linked list`**_, meaning each node contains pointers to both the previous and next nodes

#### 3. Vector
- Provides dynamic arrays in Java.
- Similar to `ArrayList` in terms of implementation.
- The primary difference is that a Vector is synchronized (i.e., thread-safe), whereas an ArrayList is not synchronized (i.e., not thread-safe by default ("need to manage synchronization ourselves")). 
- Because of synchronization, Vector has slightly lower performance compared to ArrayList in single-threaded environments.

#### 4. Stack
- Models and implements the `Stack` data structure based on the principle of last-in-first-out (LIFO).
- Provides basic operations like `push` and `pop`.
- Includes additional functions such as `empty`, `search`, and `peek`.
- Can be referred to as a subclass of `Vector`.