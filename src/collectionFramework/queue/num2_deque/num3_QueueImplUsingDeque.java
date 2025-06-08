package collectionFramework.queue.num2_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class num3_QueueImplUsingDeque {
    public static void main(String[] args) {
        /*
        1. offer() / add() for adding elements
        2. poll() / remove() for removing elements
        3. peek() / element() for finding the element at the top
        */
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offer(12);
        dq.offer(17);
        dq.offer(19);
        System.out.println("dq : " + dq);
        System.out.println("elementPopped : " + dq.poll());
        System.out.println("dq : " + dq);
        System.out.println("elementAtTop : " + dq.peek());

    }
}
