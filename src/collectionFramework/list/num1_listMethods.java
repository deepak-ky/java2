package collectionFramework.list;

import java.util.*;

public class num1_listMethods {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        //List<Integer> list1 = new LinkedList<>();
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

        System.out.println("printing list1 using for loop");
        printListUsingForLoop(list1);

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

        /*
        returns first occurrence
        */
        var indexOf500 =  list1.indexOf(500);
        var indexOf91 = list1.indexOf(91);
        var indexOf200 = list2.indexOf(200);
        System.out.println("indexOf500 : " + indexOf500);
        System.out.println("indexOf91 : " + indexOf91);
        System.out.println("indexOf200 : " + indexOf200);
        System.out.println("----");

        /*
        returns last occurrence
        */
        list2.add(200);
        System.out.println("list2 : " + list2);
        indexOf200 = list2.indexOf(200);
        var lastIndexOf200 = list2.lastIndexOf(200);
        System.out.println("indexOf200 : " + indexOf200);
        System.out.println("lastIndexOf200 : " + lastIndexOf200);
        System.out.println("----");

        System.out.print("list2 : ");printListUsingListIterator(list2);
        System.out.print("list2 : ");printListBackwardUsingListIterator(list2);

        System.out.println("list1 before : " + list1);
        ListIterator<Integer> listIterator = list1.listIterator(1);
        listIterator.next(); /*without this IllegalStateException is thrown*/
        listIterator.set(800);
        listIterator.next();
        listIterator.remove();
        // listIterator.next(); // NoSuchElementException

        printLists(list1, list2);

        /*
            subList : [fromIndex, toIndex)
        */
        // System.out.println(list2.subList(2,1)); // IllegalArgumentException
        System.out.println("list2.subList(2,2) : " + list2.subList(2,2));
        System.out.println("list2.subList(2,3) : " + list2.subList(2,3));
        System.out.println("list2.subList(2,4) : " + list2.subList(2,4));
        // System.out.println("list2.subList(2,5) : " + list2.subList(2,5)); // IndexOutOfBoundsException
        System.out.println("list2.subList(4,4) : " + list2.subList(4,4));
        // System.out.println("list2.subList(4,5) : " + list2.subList(4,5)); // IndexOutOfBoundsException: toIndex = 5
        // System.out.println("list2.subList(5,4) : " + list2.subList(5,4)); // IllegalArgumentException: fromIndex(5) > toIndex(4)
        // System.out.println("list2.subList(5,5) : " + list2.subList(5,5));    // IndexOutOfBoundsException: toIndex = 5
    }

    static void printLists(List<?> list1, List<?> list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println("----");
    }

    static void printListUsingForLoop(List<?> list) {
        for (int i=0;i<list.size();i++) {
            System.out.println("element at index " + i + " is : " + list.get(i));
        }
    }

    /*
    Internally listIterator() and listIterator(0) are the same
    both call new ListItr(0)

    ArrayList Implementations

    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }
    */
    static <T> void printListUsingListIterator(List<T> list) {
        System.out.println("Printing list using an ListIterator");
        ListIterator<T> listIterator = list.listIterator(); // by default positioned between -1 and 0
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        System.out.println();

        System.out.println("Printing list using an ListIterator at index 0");
        ListIterator<T> listIteratorFromIndex0 = list.listIterator(0); // explicitly positioned between -1 and 0
        while (listIteratorFromIndex0.hasNext()) {
            System.out.print(listIteratorFromIndex0.next() + ", ");
        }
        System.out.println();
        System.out.println("----");
    }

    static <T> void printListBackwardUsingListIterator(List<T> list) {
        System.out.println("Printing list backward using an ListIterator");
        ListIterator<T> listIterator = list.listIterator(list.size()); // // explicitly positioned between list.size()-1 and list.size()
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
        System.out.println();
        System.out.println("----");
    }
}
