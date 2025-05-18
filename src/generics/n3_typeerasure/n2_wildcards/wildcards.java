package generics.n3_typeerasure.n2_wildcards;

import java.util.List;

public class wildcards {
    public static void main(String[] args) {
        System.out.println("refresh .class files, to view the bytecode go to View/Show Bytecode");
    }

    public static void print1(List<?> list) {
        /*erased to list*/
    }

    public static void print2(List<? extends Number> list) {
        /*erased to list*/
    }

    public static void print3(List<? super Integer> list) {
        /*erased to list*/
    }
}
