package generics;

public class num4_upperBoundedExample2 {
    public static void main(String[] args) {
        Float numbers[] = {10F, 11.45F, 2.455F, 6.33F, 6.34F, 6.35F, 445F, 7F, 8.090F};
        System.out.println(countGreaterThan(numbers,6.34F));
    }

    /*public static <T> int countGreaterThan(T[] a, T elem) {
        int count = 0;
        for (T x : a) {
            *//*
            The operator (>) only applies to primitive types.
            You cannot use (>) operator to compare objects.
            To fix this problem, use a type parameter bounded by Comparable<T> interface
            * *//*
            if (x > elem) {
                count++;
            }
        }
        return count;
    }*/

    public static <T extends Comparable<T>> int countGreaterThan(T[] a, T elem) {
        int count = 0;
        for (T x : a) {
            if (x.compareTo(elem) > 0) {
                count++;
            }
        }
        return count;
    }
}
