package wrapperclasses;

public class num1_autoBoxingUnBoxing {
    public static void main(String[] args) {
        int a = 23;
        System.out.println("a : " + a);

        System.out.println("--------");
        // Autoboxing
        Integer A = a;
        Integer B = 24;
        Integer C = new Integer(25);
        Integer D = Integer.valueOf(26);
        System.out.println("A : " + A);
        System.out.println("B : " + B);
        System.out.println("C : " + C);
        System.out.println("D : " + D);

        System.out.println("--------");
        //UnBoxing
        int b = B;
        int c = C;
        int d = D;
        System.out.println("b : " + b);
        System.out.println("c : " + c);
        System.out.println("d : " + d);
    }
}
