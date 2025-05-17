## Java Generics: List<Number> vs List<? extends Number> vs <T extends Number>

### 1. If a function accepts `List<Number>`, then:

- ❌ You **cannot** pass `List<Integer>` or `List<Double>` into it.
- This is because **generics are invariant** in Java.
  That means `List<Integer>` is **not** a subtype of `List<Number>`,
  even though `Integer` is a subtype of `Number`.

---

### 2. If a function accepts `List<? extends Number>`, then:

- ✅ You **can** pass `List<Integer>` or `List<Double>` into it.
- This is called a **covariant wildcard**, and it allows **read-only** access.
  (You can't safely add elements to the list.)

---

### 3. If a function is defined as `<T extends Number> void func(List<T> list)`, then:

- ✅ You **can** call `func()` with `List<Integer>` or `List<Double>`.
- This is a generic method, and the type parameter `T` will be inferred at the call site.
