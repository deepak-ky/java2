package exceptionHandling;

public class num100_playground {
    public static void main(String[] args) {
       callRandom();
    }

    public static void callRandom() throws RuntimeException {
        System.out.println("Inside call random");

        try {
            int result = 8/0;
        } catch (RuntimeException e) {
            System.out.println("caught exception : " + e);
        }
    }
}
