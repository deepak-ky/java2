### Java Deque Methods Table

| Return Type                                | Method           | Description                                                                         | Throws Exception?                                 | Belongs To                |
|--------------------------------------------|------------------|-------------------------------------------------------------------------------------|---------------------------------------------------|---------------------------|
| `void`                                     | `addFirst(E e)`  | Inserts at the front.                                                               | ✅ Yes – `IllegalStateException` if full           | Deque                     |
| `void`                                     | `addLast(E e)`   | Inserts at the end.                                                                 | ✅ Yes – same as above                             | Deque                     |
| `boolean`                                  | `add(E e)`       | Inserts at the tail (same as `addLast()`).                                          | ✅ Yes – `IllegalStateException` if full           | Collection/Queue/Deque    |
| `boolean`                                  | `offerFirst(E e)`| Inserts at the front.                                                               | ❌ No – returns `false` if full                    | Deque                     |
| `boolean`                                  | `offerLast(E e)` | Inserts at the end.                                                                 | ❌ No – returns `false` if full                    | Deque                     |
| `boolean`                                  | `offer(E e)`     | Inserts at the tail (same as `offerLast()`).                                        | ❌ No – returns `false` if full                    | Queue/Deque               |
| `E`                                        | `removeFirst()`  | Removes and returns the first element.                                              | ✅ Yes – `NoSuchElementException` if empty         | Deque                     |
| `E`                                        | `removeLast()`   | Removes and returns the last element.                                               | ✅ Yes – same as above                             | Deque                     |
| `E`                                        | `remove()`       | Removes and returns the head (same as `removeFirst()`).                             | ✅ Yes – same as above                             | Queue/Collection/Deque    |
| `E`                                        | `pollFirst()`    | Removes and returns the first element, or `null` if empty.                          | ❌ No                                         | Deque                     |
| `E`                                        | `pollLast()`     | Removes and returns the last element, or `null` if empty.                           | ❌ No                                         | Deque                     |
| `E`                                        | `poll()`         | Removes and returns the head (same as `pollFirst()`), or `null` if empty.           | ❌ No             | Queue/Deque               |
| `E`                                        | `getFirst()`     | Retrieves but does not remove the first element.                                    | ✅ Yes – `NoSuchElementException` if empty         | Deque                     |
| `E`                                        | `getLast()`      | Retrieves but does not remove the last element.                                     | ✅ Yes – same as above                             | Deque                     |
| `E`                                        | `element()`      | Retrieves but does not remove the head (same as `getFirst()`).                      | ✅ Yes – same as above                     | Queue/Deque               |
| `E`                                        | `peekFirst()`    | Retrieves but does not remove the first element, or `null` if empty.                | ❌ No                                 | Deque                     |
| `E`                                        | `peekLast()`     | Retrieves but does not remove the last element, or `null` if empty.                 | ❌ No                                 | Deque                     |
| `E`                                        | `peek()`         | Retrieves but does not remove the head (same as `peekFirst()`), or `null` if empty. | ❌ No             | Queue/Deque               |
|                                            |                  |                                                                                     |                                                   |                           |
| **_Functions to imitate stack behaviour_** |                  |                                                                                     |                                                   |                           |
| `void`                                     | `push(E e)`      | Pushes an element onto the stack (front of deque). Equivalent to `addFirst(E e)`      | ✅ Yes – `IllegalStateException` if full           | Deque                     |  
| `E`                                        | `pop()`          | Pops and returns the element from the stack (front). Equivalent to `removeFirst()` | ✅ Yes – `NoSuchElementException` if empty         | Deque                     |

### Points
1. When using Stack via ArrayDeque use `push()`, `pop()` and `peek()`.
2. When using Queue via ArrayDeque use `offer()`, `poll()` and `peek()`.
3. If you want to work with a stack in Java, it's recommended to use the `ArrayDeque` class instead of the `Stack` class. This is because `Stack` extends `Vector`, which is synchronized and thread-safe, leading to slower performance. In contrast, `ArrayDeque` offers faster, unsynchronized operations and is generally more efficient for stack usage in single-threaded scenarios.
