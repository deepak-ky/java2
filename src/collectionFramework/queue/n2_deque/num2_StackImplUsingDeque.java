package collectionFramework.queue.n2_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class num2_StackImplUsingDeque {
    public static void main(String[] args) {

        Deque<Integer> dqStack = new ArrayDeque<>();

        /*1. Stack Implementation*/
        dqStack.push(12);
        dqStack.push(17);
        dqStack.push(40);

        System.out.println("dqStack : " + dqStack);
        System.out.println("elementPopped : " + dqStack.pop());
        System.out.println("dqStack : " + dqStack);
        System.out.println("elementAtTop : " + dqStack.peek());
        System.out.println("dqStack : " + dqStack);

        System.out.println("----");

        Deque<Integer> dqStack2 = new ArrayDeque<>();
        System.out.println("dqStack2 : " + dqStack2);
        /*NoSuchElementxception*/
        //System.out.println("elementPopped : " + dqStack2.pop());
        System.out.println("elementAtTop : " + dqStack2.peek());
    }
}
