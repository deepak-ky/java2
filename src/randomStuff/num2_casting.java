package randomStuff;

public class num2_casting {
    public static void main(String[] args) {

        /*
         * 1. Whenever trying to assign big to a small -> explicit conversion
         *    - In explicit conversion if the value is within the range, after conversion appropriate value.
         *    - If the explicit conversion is done on a value which is out of range of the target data type,
         *      then inappropriate values get assigned to the variable, either the MIN value or the MAX value of the
         *      target data type, or any other inappropriate value
         * */

        long l1 = 300l;
        int i1 = (int)l1;
        System.out.println("i1 : " + i1);

        long l2 = 3000000000l;
        int i2 = (int)l2;
        System.out.println("i2 : " + i2);

        short s1 = -150;
        byte b1 = (byte)s1;
        System.out.println("b1 : " + b1);

        short s2 = 128;
        byte b2 = (byte)s2;
        System.out.println("b2 : " + b2);

        // this is kind of like 500 cannot be represented in byte, so java compiler considers it to be a
        // int value, and then that int was explicitly converted into byte
        byte b3 = (byte) 500;
        System.out.println("b3 : " + b3);

        //5000000000 -> Integer number too large by Java Compiler, append 'l' to make it considered for long
        // and then convert long to byte
        byte bbb3 = (byte) 5000000000l;
        System.out.println("bbb3 : " + bbb3);

        double d1 = 1.1234;
        System.out.println("d1 : " + d1);
        float f1 = (float)d1;
        System.out.println("f1 : " + f1);

        double d2 = 1.1234567891234;
        System.out.println("d2 : " + d2);
        float f2 = (float)d2;
        System.out.println("f2 : " + f2);

        /*
         * 2. Converting small to big -> Implicit type casting
         * - Compiler does this automatically without manual interference
         * */

        byte b4 = 100;
        int i4 = b4;
        System.out.println("i4 : " + i4);

        int i5 = 2000000000;
        long l5 = i5;
        System.out.println("l5 : " + l5);

        /*
         * 3. Any operation in Java can only take place if both of the operands are of common type
         *   - If the operands are not of same type, implicit type casting is done by Java, the following are the rules,
         *        applied in this order (also called type promotion hierarchy) 👇
         *     a. If any of the variables is of type double, the other would be converted to double
         *     b. If any of the variables is of type float, the other would be converted to float
         *     c. If any of the variables is of type long, the other would be converted to long
         *     d. If any of the variables is of type int, the other would be converted to int
         *     e. (VERY IMPORTANT) If neither of the variables are double, float, long or int both would be promoted to int
         *        -> The Java Virtual Machine (JVM) doesn't have dedicated instructions for arithmetic operations on byte and short data types directly.
         *        -> That is why when arithmetic operations are performed on byte and short data types, they are first promoted to int
         * */

        short s6 = 2;
        int i6 = 4 + s6; // s6 was converted to int implicitly
        System.out.println("i6 : " + i6);

        double d7 = 1.1;
        double d8 = d7 + 2; // 2 prmoted to 2.0
        System.out.println("d8 : " + d8);

        double d9 = 130.22;
        byte b9 = 1;
        // converted b9 to double and the result is of a double data type, cannot be assigned to a byte.
        //byte b10 = d9 + b9;

        // explicitly converted d9 to byte, now according to point (e), both were internally promoted to int
        // to perform the operation and hence the result is int, which cannot be assigned to a byte.
        // byte b11 = (byte)d9 + b9;

        // converted the resultant int to byte
        byte b12 = (byte)((byte)(d9) + b9);
        System.out.println("b12 : " + b12);

        // can also be done like this, explicitly convert double to int
        // in this case, b9 would be first converted to double and then the resultant double would be converted to byte
        byte b13 = (byte)(d9 + b9);
        System.out.println("b13 : " + b13);

        // few more examples
        byte bb1 = 2;
        short ss1 = 3;
        short ss2 = (short) (ss1 + bb1);

        System.out.println("ss2 : " + ss2);

        byte bb2 = 100;
        byte bb3 = 30;
        byte bb4 = (byte)(bb2 + bb3);
        System.out.println("bb4 : " + bb4);




        /*String str = "2101345123";
        String str1 = "2501345123";
        String str2 = "2501345123.123456";
        System.out.println("byte : " + Byte.parseByte("100"));
        System.out.println("short : " + Short.parseShort("30000"));
        System.out.println("integer : " + Integer.parseInt(str));
        System.out.println("long : " + Long.parseLong(str1));
        System.out.println("float : " + Float.parseFloat(str2));
        System.out.println("double : " + Double.parseDouble(str2));*/
    }
}
