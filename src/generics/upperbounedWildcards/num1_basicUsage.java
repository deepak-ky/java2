package generics.upperbounedWildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num1_basicUsage {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,3,4,5);
        List<Float> lf = Arrays.asList(1.0F, 2.3F,5.5F);
        List<Double> ld = Arrays.asList(3.0D, 1.0D, 6.7D);
        List<Number> ln = Arrays.asList(1, 2.0F, 3.2D);

        System.out.println(sumOfIntegerList(li));
        // System.out.println(sumOfIntegerList(lf));
        System.out.println("-----------");

        /*
        * Required type: List<Number>
          Provided: List<Integer>
        * You cannot pass List<Integer> or List<Double> into it.
          This is because generics are invariant in Java.
          That means List<Integer> is not a subtype of List<Number>,
          even though Integer is a subtype of Number.
          System.out.println(sumOfNumberList(li));
         */
        System.out.println(sumOfNumberList(ln));

        System.out.println("-----------");

        System.out.println(sumOfList(li));
        System.out.println(sumOfList(lf));
        System.out.println(sumOfList(ld));

        System.out.println("-----------");

        System.out.println(sumOfList2(li));
        System.out.println(sumOfList2(lf));
        System.out.println(sumOfList2(ld));

    }

    public static Integer sumOfIntegerList(List<Integer> list) {
        Integer sum = 0;
        for(Integer x : list) {
            sum += x;
        }
        return sum;
    }

    public static double sumOfNumberList(List<Number> list) {
        double sum = 0;
        for(Number x : list) {
            sum += x.doubleValue();
        }
        return sum;
    }

    public static double sumOfList(List<? extends  Number> list) {
        double sum = 0;
        for(Number x : list) {
            sum += x.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double sumOfList2(List<T> list) {
        double sum = 0;
        for(Number x : list) {
            sum += x.doubleValue();
        }
        return sum;
    }
}
