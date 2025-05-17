package generics.upperbounedWildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Lot of things have been covered in this class, go through it with a zoomed out screen*/
public class num2_genericMethodsVsWildcardsUsage {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Double> ld = Arrays.asList(3.0D, 1.0D, 6.7D);

        System.out.println(sumOfList(li));
        System.out.println(sumOfList2(li));
        System.out.println("-----------");

        /* Use-cases when T could be useful */
        /*
        Does not work, second parameter needs to be of same type as List argument
        System.out.println(returnParamFunc1(ld, Integer.valueOf(45)));
        */
        System.out.println(returnParamFunc1(li, Integer.valueOf(45)));

        List<Integer> li2 = new ArrayList<>(Arrays.asList(50,60));
        System.out.println(li2);
        /* Does not work copyFunc1(li, lf);
         * this is not possible in copyFunc2
         */
        copyFunc1(li2, li);
        System.out.println(li2);
        System.out.println("-----------");

        /* Use-cases when ? could be useful */
        /*
        1. copyFunc2 can be useful if I want the sum of two lists containing different types of Number subtypes,
        basically any function which has to accept two subtypes of Number
        */
        System.out.println(copyFunc2(li, ld));

    }

    public static <T extends Number> double sumOfList(List<T> list) {
        /*<T extends Number> List<T> - generic with a type parameter
         * 1. You introduce a type parameter T, bound to a Number
         * 2. This is useful when you want to refer to T again,
         *     a. Returning a T
         *     b. Accepting another T parameter
         *     c. Creating T instances(rare)*/

        /*3. An Element can be added to the list */
        var elem = list.get(0);
        list.add(elem);
        list.add(null);

        double sum = 0;
        for(Number x : list) {
            if(Objects.nonNull(x)) {
                sum += x.doubleValue();
            }
        }
        return sum;
    }

    public static double sumOfList2(List<? extends Number> list) {
        /*List<? extends Number>
         * 1. You use this when you don't care about the specific subtype of Number, only that it's a subtype
         * 2. You can't add to the list(except null), because the compiler does not know which specific type it holds
         * 3. When only read is needed and not write
         * */

        /*4. An Element cannot be added to the list except null*/
        var elem = list.get(0);
        // list.add(elem);
        list.add(null);


        double sum = 0;
        for(Number x : list) {
            if(Objects.nonNull(x)) {
                sum += x.doubleValue();
            }
        }
        return sum;
    }

    public static <T extends Number> T returnParamFunc1(List<T> list, T param) {
        return param;
    }

    /*
    public static (? extends Number) returnParamFunc2(List<? extends Number> list, (? extends Number) param) {
        return param;
    }*/

    public static <T extends Number> void copyFunc1(List<T> list1, List<T> list2) {
        list1.add(list2.get(0));
    }

    public static double copyFunc2(List<? extends Number> list1, List<? extends Number> list2) {
        /*
        Java doesn't know if list1 is List<Integer> and list2 is List<Double>.
        They are both ? extends Number, but could be different subtypes.
        So you cannot safely copy, because the types are not bound together.
        list1.add(list2.get(0));
        */

        double sum = 0;
        for (Number x : list1) { sum += (x != null) ? x.doubleValue() : 0.0; }
        for (Number x : list2) { sum += (x != null) ? x.doubleValue() : 0.0;}
        return sum;
    }
}
