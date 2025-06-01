package generics;

import java.util.ArrayList;
import java.util.List;

public class playground {
    public static void main(String[] args) {
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        someObject = someInteger;
        System.out.println(someObject);
        System.out.println(someInteger);

        /*List<int> list = new ArrayList<>();
        list.add(17);*/
    }
}
