package randomStuff.passByValueVsPassByReference;

public class num1_SwapFunc {
    public static void main(String[] args) {
        Integer a = 3;
        Integer b = 40;

        System.out.println("a : " + a);
        System.out.println("b : " + b);
        swap(a,b);
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    public static void swap(Integer x, Integer y){
        int temp = x;
        x = y;
        y = temp;
    }
}
