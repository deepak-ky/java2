package collectionFramework.set;

import java.util.*;

public class num1_hashset_linkedhashset {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(12, 5, 50, 50, 100, 12));

        hashSet.addAll(arrayList);
        linkedHashSet.addAll(arrayList);

        /*Not present in the order in which it was added*/
        printSet(hashSet);
        printSet(hashSet);

        /*Present in the order in which it was added*/
        printSet(linkedHashSet);
        printSet(linkedHashSet);

        boolean is100Removed = hashSet.remove(100);
        System.out.println("removing 100 from hashset : " + is100Removed);
        printSet(hashSet);

        boolean is101Removed = linkedHashSet.remove(101);
        System.out.println("removing 101 from linkedHashSet : " + is101Removed);
        printSet(linkedHashSet);

        boolean is55Present = hashSet.contains(55);
        System.out.println("55 present in hashset : " + is55Present);

        boolean is50Present = linkedHashSet.contains(50);
        System.out.println("50 present in linkedHashSet : " + is50Present);

    }

    public static void printSet(Set<?> set) {
        System.out.println(set.getClass().getSimpleName() + " : " + set);
        System.out.println("----");
    }
}
