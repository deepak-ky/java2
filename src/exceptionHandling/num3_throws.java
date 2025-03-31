package exceptionHandling;

public class num3_throws {
    public static void main(String[] args) {
        int a[] = new int[5];

        try {
            int result = getNumberFromArray(a);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("caught exception : " + e);
        }
    }

    /*
    * 1. Java does not force to handle unchecked exceptions
    * 2. This is the reason why I am throwing an unchecked exception ArithmeticException
    *    and I am handling another unchecked exception ArrayIndexOutOfBoundsException*/
    static int getNumberFromArray(int a[]) throws ArithmeticException {
        return a[8];
    }
}
