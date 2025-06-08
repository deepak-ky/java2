package collectionFramework.queue.num2_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class num1_dequeMethods {
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) {
        /*1. Add Elements*/
        deque.addFirst(10);
        deque.add(12);
        deque.addLast(15);

        deque.offerLast(100);
        deque.offerLast(101);
        deque.offerLast(102);
        deque.offerLast(103);
        deque.offerLast(104);

        deque.offerFirst(5);
        deque.offer(19);
        deque.offerLast(25);

        printDeque();

        System.out.println("deque.removeFirst() : " + deque.removeFirst());
        System.out.println("deque.remove() : " + deque.remove());
        System.out.println("deque.removeLast() : " + deque.removeLast());
        printDeque();
        System.out.println("deque.pollFirst() : " + deque.pollFirst());
        System.out.println("deque.poll() : " + deque.poll());
        System.out.println("deque.pollLast() : " + deque.pollLast());
        printDeque();

        Deque<Integer> d2 = new ArrayDeque<>();
        System.out.println("d2 : " + d2);
        try {
            /*System.out.println("d2.removeFirst() : " + d2.removeFirst());
            System.out.println("d2.remove() : " + d2.remove());*/
            System.out.println("d2.removeLast() : " + d2.removeLast());
        } catch (Exception e) {
            System.out.println("caught exception while using remove functions : " + e);
        }

        System.out.println("-");

        try {
            System.out.println("d2.pollFirst() : " + d2.pollFirst());
            System.out.println("d2.poll() : " + d2.poll());
            System.out.println("d2.pollLast() : " + d2.pollLast());
        } catch (Exception e) {
            System.out.println("caught exception while using poll functions : " + e);
        }

        System.out.println("----");

        System.out.println("Deque : " + deque);
        System.out.println("deque.getFirst() : " + deque.getFirst());
        System.out.println("deque.element() : " + deque.element());
        System.out.println("deque.getLast() : " + deque.getLast());
        System.out.println("-");
        System.out.println("deque.peekFirst() : " + deque.peekFirst());
        System.out.println("deque.peek() : " + deque.peek());
        System.out.println("deque.peekLast() : " + deque.peekLast());
        printDeque();

        System.out.println("d2 : " + d2);
        try {
            //System.out.println("d2.getFirst() : " + d2.getFirst());
            //System.out.println("d2.element() : " + d2.element());
            System.out.println("d2.getLast() : " + d2.getLast());
        } catch (Exception e) {
            System.out.println("caught exception while using get/element functions : " + e);
        }

        System.out.println("-");

        try {
            System.out.println("d2.peekFirst() : " + d2.peekFirst());
            System.out.println("d2.peek() : " + d2.peek());
            System.out.println("d2.peekLast() : " + d2.peekLast());
        } catch (Exception e) {
            System.out.println("caught exception while using peek functions : " + e);
        }

    }

    static void printDeque() {
        System.out.println("Deque : " + deque);
        System.out.println("----");
    }
}
