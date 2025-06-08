package collectionFramework.queue.num1_queue;

import java.util.LinkedList;
import java.util.Queue;

public class queueMethods {
    /**
     * LinkedList implements both List and Deque*/
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        /**
         * Inserts the specified element into this queue if it is possible to do so
         * immediately without violating capacity restrictions,
         * returning true upon success
         * and throwing an IllegalStateException if no space is currently available.*/
        q.add(12);

        /**
         * Inserts the specified element into this queue if it is possible to do so
         * immediately without violating capacity restrictions.
         * When using a capacity-restricted queue, this method is generally preferable to add,
         * which can fail to insert an element only by throwing an exception.*/
        q.offer(56);
        q.add(90);
        q.add(96);
        q.offer(96);
        q.offer(97);
        q.offer(100);
        q.offer(105);

        printQueue(q);

        var elementRemoved1 = q.remove();
        var elementRemoved2 = q.poll();
        var is96Removed = q.remove(Integer.valueOf(96));
        var is97Removed = q.remove(97);
        var is98Removed = q.remove(98);
        System.out.println("elementRemoved1 : q.remove() : " + elementRemoved1);
        System.out.println("elementRemoved2 : q.poll() : " + elementRemoved2);
        System.out.println("is96Removed : q.remove(Integer.valueOf(96)) : " + is96Removed);
        System.out.println("is97Removed : q.remove(97) : " + is97Removed);
        System.out.println("is98Removed : q.remove(98) : " + is98Removed);
        printQueue(q);

        Queue<Integer> q2 = new LinkedList<>();
        System.out.println("q2 : " + q2);
        Integer elementRemoved3 = null;
        try {
            elementRemoved3 = q2.remove();
        } catch (Exception e) {
            System.out.println("trying to remove an element from q2 using q2.remove(), caught exception : " + e);
        } finally {
            /*cannot use q2.remove() here because it throws exception*/
            System.out.println("elementRemoved3 : q2.remove() : " + elementRemoved3);
        }

        System.out.println("-");

        Integer elementRemoved4 = null;
        try {
            elementRemoved4 = q2.poll();
        } catch (Exception e) {
            System.out.println("trying to remove an element from q2 using q2.poll(), caught exception : " + e);
        } finally {
            System.out.println("elementRemoved4 : q2.poll() : " + elementRemoved4);
            /*can use q2.poll() here because it does not throw exception*/
            System.out.println("elementRemoved4 : q2.poll() : " + q2.poll());
        }

        System.out.println("-");

        boolean is100Removed = false;
        try {
            is100Removed = q2.remove(Integer.valueOf(100));
        } catch (Exception e) {
            System.out.println("trying to remove 100 from q2 using q2.remove(Integer.valueOf(100)), caught exception : " + e);
        } finally {
            System.out.println("is100Removed : " + is100Removed);
        }


        System.out.println("----");

        System.out.println("q : " + q);
        var elementAtTop_1 = q.element();
        System.out.println("elementAtTop_1 : q.element() : " + elementAtTop_1);

        var elementAtTop_2 = q.peek();
        System.out.println("elementAtTop_2 : q.peek() : " + elementAtTop_2);

        System.out.println("-");

        System.out.println("q2 : " + q2);
        Integer elementAtTop_3 = null;
        try {
            elementAtTop_3 = q2.element();
        } catch (Exception e) {
            System.out.println("exception caught while q2.element(), exception : " + e);
        } finally {
            System.out.println("elementAtTop_3 : q2.element() : " + elementAtTop_3);
        }

        System.out.println("-");

        Integer elementAtTop_4 = null;
        try {
            elementAtTop_4 = q2.peek();
        } catch (Exception e) {
            System.out.println("exception caught while q2.peek(), exception : " + e);
        } finally {
            System.out.println("elementAtTop_4 : q2.peek() : " + elementAtTop_4);
            System.out.println("elementAtTop_4 : q2.peek() : " + q2.peek());
        }

        System.out.println("----");

        printQueueUsingWhileLoop(q);
        printQueue(q);

    }

    static void printQueue(Queue<?> q) {
        System.out.println("Queue : " + q);
        System.out.println("----");
    }

    static void printQueueUsingWhileLoop(Queue<?> q) {
        System.out.println("Printing elements in queue using while loop : ");
        while(!q.isEmpty()) {
            /*q.remove() would also work here*/
            System.out.print(q.poll() + ", ");
        }
        System.out.println();
    }
}
