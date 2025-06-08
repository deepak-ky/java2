# Java Queue Methods

| Return Type | Method        | Description                                                                                                 | Throws Exception?         |
|-------------|---------------|-------------------------------------------------------------------------------------------------------------|---------------------------|
| `boolean`   | `add(E e)`    | Inserts the specified element into the queue.                                                               | Yes (if capacity is full) |
| `boolean`   | `offer(E e)`* | Inserts the specified element into the queue. Returns `true` if successful, `false` if full.                | No                        |
| `E`         | `remove()`    | Removes and returns the element at the front of the queue. Throws exception if the queue is empty           | Yes (if queue is empty)   |
| `E`         | `poll()`*     | Removes and returns the element at the front of the queue. Returns null if the queue is empty               | No                        |
| `E`         | `element()`   | Retrieves but does not remove the element at the front of the queue. Throws exception if the queue is empty | Yes (if queue is empty)   |
| `E`         | `peek()`*     | Retrieves but does not remove the element at the front of the queue. Returns null if the queue is empty     | No                        |

*Use offer(), poll() and peek() when doing DSA