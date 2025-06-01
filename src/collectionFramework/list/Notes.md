### ✅ Java List Interface – Index Validity and Return Types

| Method                  | Valid Index Range    | Return Type | Description                                                                 |
|------------------------|----------------------|-------------|-----------------------------------------------------------------------------|
| `E get(int index)`     | `0` to `size() - 1`  | `E`         | Returns the element at the specified index.                                |
| `E set(int index, E e)`| `0` to `size() - 1`  | `E`         | Replaces the element at the specified index with `e`, returns the old one. |
| `void add(int index, E e)` | `0` to `size()`  | `void`      | Inserts `e` at the specified index, shifting subsequent elements to right. |
| `E remove(int index)`  | `0` to `size() - 1`  | `E`         | Removes the element at the specified index and returns it.                 |

### Why start at `list.size()` for backward traversal?

- The `ListIterator`'s position is **between elements** (not on an element).
- `listIterator(index)` means:
    - `next()` will return the element at `index`
    -  That is why, `listIterator(0)` -> `listIterator.next()` : returns the element at index 0
    - `previous()` will return the element at `index - 1`

So, to traverse **backward from the end**, you must start at `list.size()`, which is the position **after** the last element.
- If you started at `list.size() - 1`, `previous()` would skip the last element.
