package exceptionHandling;

public class num4_throw {
    public static void main(String[] args) {


        // Throwing existing exceptions
        try {
            throw new RuntimeException("a new runtime exception");
        } catch (Exception e) {
            System.out.println("caught exception : " + e);
        }

        // Throwing custom exception
        try {
            throw new MotorException("a new motor exception");
        } catch (Exception e) {
            System.out.println("caught exception : " + e);
            System.out.println("cause : " + e.getCause());
            System.out.println("e.getMessage() : " + e.getMessage());
            System.out.println("localized message : " + e.getLocalizedMessage());
            System.out.println("stacktrace : " + e.getStackTrace());
            System.out.println("exception class : " + e.getClass());
        }
    }
}

class MotorException extends Exception {
    public MotorException(String message) {
        super(message);
    }
}
