### ✅ Java List Interface – Index Validity and Return Types

| Method                  | Valid Index Range    | Return Type | Description                                                                 |
|------------------------|----------------------|-------------|-----------------------------------------------------------------------------|
| `E get(int index)`     | `0` to `size() - 1`  | `E`         | Returns the element at the specified index.                                |
| `E set(int index, E e)`| `0` to `size() - 1`  | `E`         | Replaces the element at the specified index with `e`, returns the old one. |
| `void add(int index, E e)` | `0` to `size()`  | `void`      | Inserts `e` at the specified index, shifting subsequent elements to right. |
| `E remove(int index)`  | `0` to `size() - 1`  | `E`         | Removes the element at the specified index and returns it.                 |
