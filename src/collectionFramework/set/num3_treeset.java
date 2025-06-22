package collectionFramework.set;

import java.util.Set;
import java.util.TreeSet;

import static collectionFramework.set.num2_hashset_of_custom_objects.printSet;

public class num3_treeset {
    public static void main(String[] args) {
        Set<Integer> integerSet = new TreeSet<>();
        Set<String> stirngSet = new TreeSet<>();

        integerSet.add(100);
        integerSet.add(100);
        integerSet.add(15);
        integerSet.add(9);
        integerSet.add(12);
        integerSet.add(12);

        printSet("integerSet", integerSet);

        stirngSet.add("maruti");
        stirngSet.add("audi");
        stirngSet.add("audi");
        stirngSet.add("suzuki");
        stirngSet.add("Zcar");
        stirngSet.add("Zcar");
        stirngSet.add("zcar");
        stirngSet.add("zcar");
        stirngSet.add("Yamaha");
        stirngSet.add("Yamaha");
        stirngSet.add("yamaha");
        stirngSet.add("yamaha");

        printSet("stringSet", stirngSet);

    }
}
