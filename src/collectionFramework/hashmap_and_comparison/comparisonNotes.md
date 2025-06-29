# Java Sorting and Comparison Logic

## 1. How Java Sorts and Compares

1. **If a custom Comparator is provided:**  
   Java will use that custom comparator, regardless of whether the class implements `Comparable` or not.

2. **If no comparator is provided:**  
   Java will use the class’s `compareTo()` method (from the `Comparable` interface).

> The `Comparable` implementation of a class might be used in multiple places.  
> If you change it, there can be issues.  
> To avoid this, you can pass your own comparator, which always takes precedence.

---

## 2. Stable Sort

- A **stable sort** means that if two elements are equal according to the sorting criteria, their original relative order is preserved in the sorted output.

---

## 3. Example: Overriding `compareTo`

```java
@Override
public int compareTo(Student s) {
    // All three of them work the same
    // return rollNo - s.getRollNo();
    return rollNo - s.rollNo;

    /* The above two methods can overflow,
     * e.g. (Integer.MIN_VALUE - 1),
     * hence the recommended version is the below one */
    // return Integer.compare(rollNo, s.getRollNo());
}
```

- The recommended way is to use `Integer.compare()` to avoid integer overflow.

---

## 4. String's `compareTo`

- `compareTo` of `String` does **lexicographical sort**.

---

# 🔍 Understanding Generics in `Comparator.comparing`

## 📌 Method Signature

```java
public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
    Function<? super T, ? extends U> keyExtractor)
```

### What it means:

- `<T, U extends Comparable<? super U>>`
   - `T`: The type of object being compared (e.g., `Student`)
   - `U`: The type of the key extracted from `T`, and it **must be comparable**  
     Example: `Integer` is valid because it implements `Comparable<Integer>`

- `Function<? super T, ? extends U> keyExtractor`
   - A function that takes a `T` (or superclass of `T`) and returns a `U` (or subclass)

---

## ✅ Example Usage

```java
arrayList1.sort(Comparator.comparing(Student::getBranchRank));
```

### What's happening:

```java
public int getBranchRank() {
    return branchCode.getBranchRank();
}
```

- `Student::getBranchRank` returns a **primitive** `int`
- Java **autoboxes** it into an `Integer`
- So effectively, the function becomes:

```java
Function<Student, Integer> keyExtractor = s -> s.getBranchRank();
```

---

## 💡 Type Resolution in This Case

| Component                        | Type                      | Explanation                        |
|-----------------------------------|---------------------------|------------------------------------|
| `T`                              | `Student`                 | The object you're sorting          |
| `U`                              | `Integer`                 | Key extracted from `Student`       |
| `Function<? super T, ? extends U>`| `Function<Student, Integer>` | Accepts `Student`, returns `Integer` |
| `U extends Comparable<? super U>` | ✅ `Integer implements Comparable<Integer>` | Ensures `compareTo()` can be called |

---

## 🧠 Inside the Method

```java
(c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))
```

- `keyExtractor.apply(c1)` returns an `Integer`
- `Integer.compareTo(...)` compares the two values

---

## 🧃 Why `Comparable<? super U>`?

- This adds flexibility.
- Allows comparison with a superclass of `U`
- Follows **PECS** principle:
  > *Producer Extends, Consumer Super*

For example:
- If `U = Integer`,  
  `Comparable<? super U>` = `Comparable<? super Integer>`  
  This works because `Integer` implements `Comparable<Integer>`

---

## ✅ Summary

- `T` = `Student`
- `U` = `Integer` (from `int` via autoboxing)
- Function = `Student::getBranchRank`
- Comparator compares two students based on their branch rank

---

# 🔍 Java String Comparison: `==` vs `.equals()`

## ⚠️ Common Mistake: Using `==` to Compare Strings

```java
if (o1.getName() == o2.getName()) {
    // risky!
}
```
- This checks **reference equality** – it evaluates to `true` only if both variables point to the **same object in memory**.
- It does **NOT** compare the actual characters or content of the strings.

---

### ❌ Example of Incorrect Comparison

```java
String a = new String("Deepak");
String b = new String("Deepak");

System.out.println(a == b);         // false ❌ (different objects)
System.out.println(a.equals(b));    // true ✅ (same content)
```
- Even though `a` and `b` look the same, they are two different objects, so `a == b` returns `false`.

---

## ✅ Correct Way: Use `.equals()` to Compare Content

```java
if (o1.getName().equals(o2.getName())) {
    // correct!
}
```
- `.equals()` compares the **content** of the strings.
- Returns `true` if both strings contain the **same sequence of characters**.

---

## 🛡️ Bonus Tip: Avoid NullPointerException

To safely compare with a literal string:

```java
if ("Deepak".equals(o1.getName())) {
    // Safe from null pointer exceptions
}
```
- This way, even if `o1.getName()` is `null`, your code won’t crash.

---

## ✅ Summary Table

| Syntax                  | What it checks         | Result Example           |
|-------------------------|-----------------------|-------------------------|
| `a == b`                | Reference equality    | false                   |
| `a.equals(b)`           | Content equality      | true                    |
| `"Deepak".equals(x)`    | Safe content equality | true / no crash         |

---

💡 **Remember:**
- Always use `.equals()` to compare string values.
- Prefer `"constant".equals(variable)` if there’s a risk the variable is `null`.