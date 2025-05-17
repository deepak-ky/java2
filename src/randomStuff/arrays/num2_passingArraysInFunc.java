package randomStuff.arrays;

public class num2_passingArraysInFunc {
    public static void main(String[] args) {
        int numbers[] = {1,2,3};
        print(numbers);
        foo(numbers);
        System.out.println("Outside function");
        print(numbers);
    }

    public static void foo(int numbers[]) {
        System.out.println("Inside function");
        numbers[1] = 20;
        print(numbers);
        numbers = new int[]{100,101,102,103,104};
        print(numbers);
    }

    public static void print(int numbers[]) {
        for(var x : numbers) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
