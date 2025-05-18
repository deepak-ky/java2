package generics.n2_wildcards.n3_lowerBoundedWildcards;

import java.util.ArrayList;
import java.util.List;

public class num1_basicUsage {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(integerList);
        addNumbers(numberList);
        addNumbers(objectList);


        /*Does not work
        addNumbers2(integerList);*/
        addNumbers2(numberList);
        addNumbers2(objectList);
    }

    public static void addNumbers(List<? super Integer> list) {
        list.add(Integer.valueOf(56));
        /*list.add(Double.valueOf(57));*/
    }

    public static void addNumbers2(List<? super Number> list) {
        list.add(Integer.valueOf(56));
        list.add(Double.valueOf(57));
    }
}
