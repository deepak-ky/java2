package exceptionHandling;

public class num2_tryCatchFinallyBlock {
    public static void main(String[] args) {
        int a[] = new int[5];

        System.out.println("Checkpoint 1");

        try {
            System.out.println("a[8] : ");
            System.out.println(a[8]);
        } catch (Exception e) {
            System.out.println("caught exception : " + e);
        } finally {
            System.out.println("code inside the finally block");
        }

        System.out.println("Checkpoint 2");

        try {
            System.out.println("a[2] : ");
            System.out.println(a[2]);
        } catch (Exception e) {
            System.out.println("caught exception : " + e);
        } finally {
            System.out.println("no exception but still the code inside the finally block will run");
        }

        System.out.println("Checkpoint 3");

        try {
            int result = 8/0;
//            System.out.println("a[8] : ");
//            System.out.println(a[8]);
        } catch (ArithmeticException e) {
            System.out.println("caught arithmetic exception : " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("caught out of bounds exception : " + e);
        } finally {
            System.out.println("finally block running after multiple catch blocks");
        }

        System.out.println("Checkpoint 4");

        // testTryCatchFinallyInsideFunction
        String result = testTcfInsideFunction();


        System.out.println("Checkpoint 5, result : " + result);

        try {
            System.out.println("a[8] : ");
            System.out.println(a[8]);
        } catch (Exception e) {
            System.out.println("caught exception : " + e);
        } finally {
            System.out.println("finally block checkpoint 1");
            System.out.println(8/0);
            System.out.println("finally block checkpoint 2");
        }

        System.out.println("Checkpoint 6");

    }

    private static String testTcfInsideFunction() {

        try {
            System.out.println("inside try block");
            int result = 8/0;
            return "returning from try block";
        } catch (Exception e) {
            System.out.println("inside catch block, caught exception : " + e);
            return "returning from catch block";
        } finally {
            /*
            * Finally executes no matter what
            * If finally contains a return statement it overrides any previous return
            */
            System.out.println("inside finally");
            // return "returning from finally block";
        }

         // java unreachable statement
         // return "retunring from outside of try-catch-finally block";
    }


}
