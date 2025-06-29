package collectionFramework.hashmap_and_comparison;

import java.util.Arrays;
import java.util.Comparator;

public class arrays_comparison {
    public static void main(String[] args) {
        int a[] = {3,1,6,9,5};

        printArray(a);
        Arrays.sort(a);
        printArray(a);

        int matrix[][] = {
                {1, 2, 3},
                {1, 2, 2},
                {1, 2, 4},
                {0, 9, 8}
        };

        printMatrix(matrix);
        Arrays.sort(matrix, (int arr1[], int arr2[]) -> {
            return Integer.compare(arr1[0], (arr2[0]));
        });

        /*
        This can also be used
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });*/


        System.out.println("sorting on the basis of first element");
        printMatrix(matrix);

        Arrays.sort(matrix, (arr1, arr2) -> {
            for(int i=0;i<arr1.length;i++){
                if(arr1[i] != arr2[i]) {
                    return Integer.compare(arr1[i], arr2[i]);
                }
            }
            return 0;
        });
        System.out.println("sorting on the basis of first different element");
        printMatrix(matrix);




    }

    static void printArray(int a[]) {
        System.out.print("[");
        for(int x : a) {
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }

    static void printMatrix(int a[][]) {

        System.out.println("{--------");
        for(int x[] : a) {
            System.out.print("[");
            for (int y : x) {
                System.out.print(y + ", ");
            }
            System.out.println("]");
        }
        System.out.println("--------}");
    }
}
