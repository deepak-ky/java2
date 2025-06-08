# Java Collection Framework – Insertion Method Summary

| Collection Type | Method         | Capacity Exception?         | Notes                                                                 |
|-----------------|----------------|------------------------------|-----------------------------------------------------------------------|
| `Queue`         | `add(e)`       | ✅ Yes (`IllegalStateException`) | For bounded queues. Strict insertion.                                 |
| `Queue`         | `offer(e)`     | ❌ No                         | Graceful failure with `false` if full. Preferred for bounded queues.  |
| `List`          | `add(e)`       | ❌ No                         | Auto-resizes. Will not throw capacity-related exceptions.             |
| `List`          | `add(index,e)` | ✅ Yes (`IndexOutOfBoundsException`) | Only if index is invalid.                                           |
| `Stack`         | `push(e)`      | ❌ No                         | Syntactic sugar over `addElement()`. LIFO behavior.                   |
| `Stack`         | `add(e)`       | ❌ No                         | Adds to the end. Inherited from `Vector`.                             |

> **Note:** `ArrayList`, `Vector`, and other standard Lists auto-resize and are not capacity-bound by default.
