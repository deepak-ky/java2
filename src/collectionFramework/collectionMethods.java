package collectionFramework;

import java.util.*;

public class collectionMethods {
    public static void main(String[] args) {
        Collection<Integer> collection1 = new ArrayList<>();
        /*Collection<Integer> collection1 = new LinkedList<>();*/
        Collection<Integer> collection2 = new LinkedList<>();

        collection1.add(10);
        collection1.add(20);
        collection1.add(30);

        collection2.add(100);

        printCollections(collection1, collection2);
        printCollectionUsingIterator(collection1);
        /*
        * printCollectionUsingForLoop(collection1);
        * This method is not applicable to Collection interface types directly
        * because Collection does not have a get(index) method.
        */
        printCollectionUsingForEachLoop(collection1);

        System.out.println("collection1 size : " + collection1.size());
        System.out.println("collection2 size : " + collection2.size());

        System.out.println("----");

        collection1.addAll(collection2);

        printCollections(collection1, collection2);

        collection2.clear();

        printCollections(collection1, collection2);

        if(collection1.contains(10)) {
            System.out.println("collection1 contains 10");
        } else System.out.println("collection1 does not contain 10");

        if(collection1.contains(Integer.valueOf(10))) {
            System.out.println("collection1 contains Integer.valueOf(10)");
        } else System.out.println("collection1 does not contain Integer.valueOf(10)");

        if(collection1.contains(11)) {
            System.out.println("collection1 contains 11");
        } else System.out.println("collection1 does not contain 11");

        if(collection1.contains(Integer.valueOf(11))) {
            System.out.println("collection1 contains Integer.valueOf(11)");
        } else System.out.println("collection1 does not contain Integer.valueOf(11)");

        System.out.println("----");

        Collection<Integer> collection6 = new ArrayList<>();
        collection6.add(100);
        collection6.add(10);
        collection6.add(30);

        System.out.println("collection1 : " + collection1);
        System.out.println("collection2 : " + collection2);
        System.out.println("collection6 : " + collection6);

        if(collection1.containsAll(collection6)) {
            System.out.println("collection1 contains collection6");
        } else System.out.println("collection1 does not contain collection6");

        if(collection2.containsAll(collection6)) {
            System.out.println("collection2 contains collection6");
        } else System.out.println("collection2 does not contain collection6");

        System.out.println("----");

        if(collection1.equals(collection2)) {
            System.out.println("collection1 equals collection2");
        } else System.out.println("collection1 does not equal collection2");

        Collection<Integer> collection3 = collection1;

        if(collection1.equals(collection3)) {
            System.out.println("collection1 equals collection3");
        } else System.out.println("collection1 does not equal collection3");

        System.out.println("----");

        if(collection1.isEmpty()) {
            System.out.println("collection1 is empty");
        } else System.out.println("collection1 is not empty");

        if(collection2.isEmpty()) {
            System.out.println("collection2 is empty");
        } else System.out.println("collection2 is not empty");

        System.out.println("---------");

        collection1.remove(Integer.valueOf(20));
        collection2.remove(Integer.valueOf(20));

        printCollections(collection1, collection2);

        Collection<Integer> collection4 = new ArrayList<>();
        collection4.add(200);
        collection4.add(100);
        collection4.add(10);

        /*according to venn diagram A - B*/
        collection1.removeAll(collection4);
        collection2.removeAll(collection4);

        printCollections(collection1, collection2);

        Collection<Integer> collection5 = new ArrayList<>();
        collection5.add(40);
        collection5.add(50);

        /*according to venn diagram A x B (intersection)*/
        collection1.retainAll(collection5);
        collection1.retainAll(collection5);

        printCollections(collection1, collection2);

        System.out.println("Collection to Array : ");
        Object arr[] = collection5.toArray();
        for(Object o : arr) {
            System.out.print((Integer) o + ",");
        }
    }

    static void printCollections(Collection<?> collection1, Collection<?> collection2) {
        System.out.println("collection1 : " + collection1);
        System.out.println("collection2 : " + collection2);
        System.out.println("----");
    }

    static <T> void printCollectionUsingIterator(Collection<T> collection) {
        System.out.println("printing " + collection.getClass().getSimpleName() + " using iterator");

        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        System.out.println("----");
    }

    static <T> void printCollectionUsingForEachLoop(Collection<T> collection) {
        System.out.println("printing " + collection.getClass().getSimpleName() + " using for each loop");

        for (T t : collection) {
            System.out.print(t + ",");
        }
        System.out.println();

        System.out.println("----");
    }

}
