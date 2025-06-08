package collectionFramework.queue.n3_priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class num1_priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /*
         * This is also valid. Even though the reference is of type Queue,
         * the actual object is a PriorityQueue, so all PriorityQueue behavior is preserved.
         * Queue<Integer> pq = new PriorityQueue<>();
         */

        pq.offer(10);
        pq.offer(5);
        pq.offer(100);
        pq.offer(1);

        /*The internal structure does not reflect true priority order*/
        System.out.println("pq (internal structure, not sorted, (might not show correct order)): " + pq);

        System.out.println("pq.peek() : " + pq.peek());

        /*
         * For wrappers of primitives, natural ordering is used as priority.
         * - For Integers: ascending order (min-heap)
         * - For Strings: lexicographical order
         * - For custom objects: the class should implement the Comparable interface,
         *   or you must provide a custom Comparator. //TODO Check again
         */
        System.out.println("Elements polled in priority order: ");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println("----");

        PriorityQueue<Integer> maxHeapPriorityQueue = new PriorityQueue<>((a,b) -> b - a);
        maxHeapPriorityQueue.offer(10);
        maxHeapPriorityQueue.offer(5);
        maxHeapPriorityQueue.offer(100);
        maxHeapPriorityQueue.offer(1);
        System.out.println("maxHeapPriorityQueue : " + maxHeapPriorityQueue);
        System.out.println("maxHeapPriorityQueue.peek() : " + maxHeapPriorityQueue.peek());
        System.out.println("Elements polled in priority order : ");
        while(!maxHeapPriorityQueue.isEmpty()) {
            System.out.println(maxHeapPriorityQueue.poll());
        }

    }
}
