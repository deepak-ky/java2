package collectionFramework.list;

import java.util.Iterator;
import java.util.Stack;

public class num2_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();

        if(stack1.empty()) {
            System.out.println("stack1 is empty");
        }

        if(stack1.isEmpty()) {
            System.out.println("stack1 is empty");
        }


        stack1.add(12);
        stack1.push(34);
        stack1.add(90);

        System.out.println("stack1 : " + stack1);
        System.out.println("stack1.peek() : " + stack1.peek());
        var elementPopped = stack1.pop();
        System.out.println("elementPopped : " + elementPopped);
        System.out.println("stack1 : " + stack1);

        System.out.println("stack1 elements using for loop : ");
        for (int i = 0; i < stack1.size(); i++) {
            System.out.println(stack1.get(i));
        }

        System.out.println("stack1 elements using iterator : ");
        Iterator<Integer> iterator = stack1.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
