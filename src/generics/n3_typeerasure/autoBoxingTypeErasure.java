package generics.n3_typeerasure;

import java.util.ArrayList;
import java.util.List;

public class autoBoxingTypeErasure {
    public static void main(String[] args) {

        List<Integer> newList = new ArrayList<>();
        newList.add(10);
        int first = newList.get(0);

        /*
        List list = new ArrayList<>();
        list.add(Integer.valueOf(17));
        int first = ((Integer) list.get(0)).intValue();
        */
    }
}
