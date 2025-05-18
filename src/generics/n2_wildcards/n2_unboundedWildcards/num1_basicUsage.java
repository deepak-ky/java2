package generics.n2_wildcards.n2_unboundedWildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num1_basicUsage {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));

        /*
        Does not work
        printList(integerList);
        */
        printList2(integerList);
    }

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.print(elem + "");
        System.out.println();
    }

    public static void printList2(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + "");
        System.out.println();
    }
}
