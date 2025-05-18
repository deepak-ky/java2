package generics.n3_typeerasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class playground {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("hello");
        Integer num = (Integer) list.get(0); // Runtime error!

//        List<String> list = new ArrayList<>(Arrays.asList("12"));
//        String s = list.get(0);
//        System.out.println(s);
    }
}
