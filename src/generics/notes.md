# Java Generics Type Erasure Summary

| Syntax                | Erased To | Use For                | Can Write? | Can Read?        |
|-----------------------|-----------|-------------------------|------------|------------------|
| `<T>`                 | Object    | General use             | ✅         | ✅               |
| `<T extends Number>`  | Number    | Numeric types           | ✅         | ✅               |
| `<?>`                 | Object    | Read-only (any type)    | ❌         | ✅ (`Object`)    |
| `<? extends Number>`  | Object    | Read-only (Number sub)  | ❌         | ✅ (`Number`)    |
| `<? super Number>`    | Object    | Write Number            | ✅         | ✅ (`Object`)    |
"""