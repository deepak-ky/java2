package collectionFramework.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class playground {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        /*push does not exist in Queue, but exists in Deque*/
        // q.push(23);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(10);
        dq.offer(20);
        dq.offer(30);

        System.out.println(dq);
        System.out.println(dq.pop());
    }
}
