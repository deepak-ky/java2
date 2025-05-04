package randomStuff;

public class num1_useOfValueOf {
    public static void main(String[] args) {
        Integer A = Integer.valueOf("12");
        // NumberFormatException
        // Integer A1 = Integer.valueOf("2asdf2");
        Float F = Float.valueOf("23.123456789");
        Double D = Double.valueOf("23.123456789");
        Boolean B = Boolean.valueOf("true");
        Boolean B1 = Boolean.valueOf("truee");
        Boolean B2 = Boolean.valueOf("false");
        Boolean B3 = Boolean.valueOf("falsee");
        Boolean B4 = Boolean.valueOf("tRuE");

        System.out.println("A : " + A);
        //System.out.println("A1 : " + A1);
        System.out.println("F : " + F);
        System.out.println("D : " + D);
        System.out.println("B : " + B);
        System.out.println("B1 : " + B1);
        System.out.println("B2 : " + B2);
        System.out.println("B3 : " + B3);
        System.out.println("B4 : " + B4);
    }
}
