package collectionFramework.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class listMethods {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(56);
        list1.add(12);
        list1.add(90);
        list1.add(72);

        List<Integer> list2 = new LinkedList<>();
        list2.add(100);
        list2.add(200);

        printLists(list1, list2);

        System.out.println("list1 size : " + list1.size());
        System.out.println("list2 size : " + list2.size());
        System.out.println("----");

        System.out.println("list1 element at index 3 : " + list1.get(list1.size()-1));
        System.out.println("list2 element at index 0 : " + list2.get(0));
        System.out.println("----");

        var elementReplaced = list1.set(3,500);
        System.out.println("element replaced at index 3 with 500 : " + elementReplaced);
        /*
        Index out of bounds exception
        list2.set(2,150);
        */
        printLists(list1, list2);


        System.out.println("list1 size : " + list1.size());
        /*
        list1.get(4); //IndexOutOfBoundsException
        list1.set(4,1); // IndexOutOfBoundsException
        */
        list1.add(4, 22); // This works and adds the element
        /*
        now the list size is 5, so add(5,23) would work but add(6,24) gives IndexOutOfBoundsException
        hence add operation allows till <= size(), while other operations allow < size()
        */
        // list1.add(6,24); // Index out of bounds exception
        list2.add(1, 45);
        printLists(list1, list2);

        System.out.println("list1 size : " + list1.size());
        // list1.remove(5); // IndexOutOfBoundsException
        var elementRemoved = list1.remove(4);
        System.out.println("element removed : " + elementRemoved);

        // calling the collection method here
        boolean isElementRemoved = list1.remove(Integer.valueOf(56));
        System.out.println("is element removed : " + isElementRemoved);
        System.out.println("list1 size : " + list1.size());
        printLists(list1, list2);

    }

    static void printLists(List<?> list1, List<?> list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println("----");
    }
}
