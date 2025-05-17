package generics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class num2_genericMethods {
    public static void main(String[] args) {
        Integer numbers[] = {10,20,30,40,50};
        System.out.print("numbers : ");
        print(numbers);

        List<Integer> numberList = convertArrayToList(numbers);
        System.out.println("numberList : " + numberList);
        System.out.println("numberList size : " + numberList.size());

        List<String> stringList = convertArrayToListWithMapperFunction(numbers, Objects::toString);
        System.out.println("stringList : " + stringList);

        List<Boolean> booleanList = convertArrayToListWithMapperFunction(numbers, n -> n > 30);
        System.out.println("booleanList : " + booleanList);

        // Write a function, which first converts string to float, and then check if float is greater than 5.34, should return a boolean list
        String values[] = {"2.45", "2.34", "5.33", "5.34", "5.55"};
        List<Boolean> booleanList2 = convertArrayToListWithMapperFunction(values, new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) {
                float f = Float.parseFloat(s);
                return f > 5.34F;
            }
        });
        System.out.println("booleanList2 : " + booleanList2);
    }

    public static <T> List<T> convertArrayToList(T[] a) {
        return Arrays.stream(a).toList();
    }

    public static <T, G> List<G> convertArrayToListWithMapperFunction(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }

    public static void print(Integer numbers[]) {
        for (var x : numbers) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
