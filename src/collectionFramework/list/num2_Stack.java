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

        System.out.println("----");

        stack1.add(12);
        stack1.push(34);
        stack1.add(90);

        System.out.println("stack1 : " + stack1);
        System.out.println("stack1.peek() : " + stack1.peek());
        System.out.println("----");
        var elementPopped = stack1.pop();
        System.out.println("elementPopped : " + elementPopped);
        System.out.println("stack1 : " + stack1);
        System.out.println("----");

        System.out.println("stack1 elements using for loop : ");
        for (int i = 0; i < stack1.size(); i++) {
            System.out.println(stack1.get(i));
        }
        System.out.println("----");

        System.out.println("stack1 elements using iterator : ");
        Iterator<Integer> iterator = stack1.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----");


        System.out.println("stack1.peek() : " + stack1.peek());
        var positionOf34FromTop = stack1.search(34);
        System.out.println("positionOf34FromTop : " + positionOf34FromTop);

        var positionOf12FromTop = stack1.search(12);
        System.out.println("positionOf12FromTop : " + positionOf12FromTop);

        var positionOf35FromTop = stack1.search(35);
        System.out.println("positionOf35FromTop : " + positionOf35FromTop);

        printStackUsingWhileLoop(stack1);
        System.out.println("stack1 : " + stack1);
    }

    static void printStackUsingWhileLoop(Stack<?> s) {
        System.out.println("Printing elements of stack using while loop");
        while (!s.empty()) {
            System.out.print(s.pop() + ", ");
        }
        System.out.println();
    }
}
