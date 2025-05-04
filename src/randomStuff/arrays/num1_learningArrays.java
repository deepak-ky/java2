package randomStuff.arrays;

public class num1_learningArrays {
    public static void main(String[] args) {
        /*1. Declaring an array*/
        int[] numbers;
        int numbers2[];

        /*2. Creating an array*/
        numbers = new int[5];
        numbers2 = new int[5];
        /*Doing the above two steps in one go */
        int[] numbers4 = new int[5];
        int numbers5[] = new int[5];



        /*3. Initializing an array*/
        // numbers = {1,2,3,4,5};  - not allowed
        // numbers2 = {1,2,3,4,5}; - not allowed
        int[] numbers3 = {1,2,3,4,5};
        System.out.println(numbers3.length);
        System.out.println(numbers2.length);
        System.out.println(numbers.length);

        /*the way numbers7 has been declared and initialized is somewhat similar to how we do it in C++,
        you can use that*/
        int[] numbers6 = {1,2};
        // JUST REMEMBER THIS
        int numbers7[]  = {1,2};

        /*There is one more way to assign stuff*/
        int[] numbers8;
        int numbers9[];

        numbers8 = new int[]{1,2};
        numbers9 = new int[]{4,5};

        /*
        You can include as many numbers as you want, and Java will automatically determine
        the array size based on the number of elements,
        However, once the array is created, its size is fixed. You cannot add or remove elements from it later.
        */

        /*
        In Java, after "int[] numbers = ",  you must either
         - use an initializer list like {1,2} (and Java infers the size), or
         - use "new" with explicit size (new int[5])
        */

        /*
        In Java I cannot mention the size when using {}; in C++ I can,
        but then I need to make sure I don't exceed the size
        */


        /*4. Accessing elements*/
        numbers[0] = numbers[3] = numbers[4] = 50;
        System.out.print("numbers : ");
        for(int i=0;i<numbers.length;i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println();

        System.out.print("numbers2 : ");
        for(int i=0;i<numbers2.length;i++) {
            System.out.print(numbers2[i] + ",");
        }
        System.out.println();

        System.out.print("numbers3 : ");
        for(int i=0;i<numbers3.length;i++) {
            System.out.print(numbers3[i] + ",");
        }
        System.out.println();

        System.out.print("numbers3 : ");
        for(int x : numbers3) {
            System.out.print(x + ",");
        }
        System.out.println();

    }
}
