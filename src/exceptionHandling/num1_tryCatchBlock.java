package exceptionHandling;

import models.User;

public class num1_tryCatchBlock {
    public static void main(String[] args) {
        int a[] = new int[5];

        System.out.println("checkpoint 1");

        int index = 8;

        try {
            System.out.println(a[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("caught an exception : " + e);
            System.out.println("cause : " + e.getCause());
            System.out.println("message : " + e.getMessage());
            System.out.println("localized message : " + e.getLocalizedMessage());
            System.out.println("stacktrace : " + e.getStackTrace());
            System.out.println("exception class : " + e.getClass());
        }

        System.out.println("checkpoint 2");

        try {
            int result = 8/0;
        } catch (ArithmeticException e) {
            System.out.println("caught arithematic exception : " + e);
        }


        System.out.println("checkpoint 3");

        try {
            //int result = 8/0;
            System.out.println(a[8]);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("handling two type of exceptions using the pipe operator, exception e : " + e);
            System.out.println("printing exception class : " + e.getClass());
            // ClassCastException when ArrayIndexOutOfBoundsException
            // System.out.println("printing exception message : " + ((ArithmeticException) e).getMessage());
        }

        System.out.println("checkpoint 4");

        try {
            int result = 8/0;
            //System.out.println(a[8]);
        } catch (RuntimeException e) {
            System.out.println("catching runtime exception, exception e : " + e);
        }

        System.out.println("checkpoint 5");

        User user = null;
        try {
            System.out.println(user.address);
        } catch (Exception e) {
            System.out.println("catching exception e : " + e);
        }


    }
}

