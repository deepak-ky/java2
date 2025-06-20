package collectionFramework.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class random1_stringsSortAndCompare {
    public static void main(String[] args) {
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        al1.add("Deepak");
        al1.add("Charlie");
        al1.add("abhishek");
        al1.add("elon");
        al1.add("Zebra");
        al1.add("apple");

        al2.add("pranay");
        al2.add("vikas");
        al2.add("deepak");

        System.out.println("al1 : ");
        System.out.println(al1);

        System.out.println("sorted al1 : ");
        /*
         Java uses Unicode (lexicographical) order by default in Collections.sort():
         Uppercase letters come before lowercase letters.
         */
        Collections.sort(al1);
        System.out.println(al1);

        System.out.println("----");

        System.out.println("al2 : ");
        System.out.println(al2);

        System.out.println("sorted al2 : ");
        Collections.sort(al2);
        System.out.println(al2);

        System.out.println("-----");
        System.out.println("custom compare");
        ArrayList<String> al3 = deepcopy(al2);
        al3.add("deepakkumaryadav");
        al3.add("deepakkumar");
        System.out.println(al3);

        Collections.sort(al3, new DeepakStringComparator());
        System.out.println("after sorting based on length : ");
        System.out.println(al3);

        System.out.println("-----Comparing two arraylists after sorting------");
        ArrayList<String> al4 = new ArrayList<>();
        al4.add("REG_YEAR");
        al4.add("REG_DATE");
        al4.add("OWNER_NAME");
        ArrayList<String> al5 = new ArrayList<>();
        al5.add("OWNER_NAME");
        al5.add("REG_YEAR");
        al5.add("REG_DATE");
        ArrayList<String> al6 = new ArrayList<>(al4);
        al6.add("OWNER_EMAIL");

        System.out.println("al4 : " + al4);
        System.out.println("al5 : " + al5);
        System.out.println("al6 : " + al6);
        System.out.println("al4.equals(al5) : " + al4.equals(al5));
        System.out.println("al4.equals(al6) : " + al4.equals(al6));
        System.out.println("--- After Sorting --- ");
        Collections.sort(al4);
        Collections.sort(al5);
        Collections.sort(al6);
        System.out.println("al4 : " + al4);
        System.out.println("al5 : " + al5);
        System.out.println("al6 : " + al6);
        System.out.println("al4.equals(al5) : " + al4.equals(al5));
        System.out.println("al4.equals(al6) : " + al4.equals(al6));

    }


    /*
    * al → original list at address abc
    * temp → new list at address xyz
    * You’re copying each string x from al into temp
    * return temp; → returns reference xyz
    * So, al3 now points to a new list, separate from al2.



    * For ArrayList<String>, this is effectively a deep copy because String is immutable.
      If you had a list of mutable objects, you’d need to clone/copy
      each object inside the list for a true deep copy.

    * ArrayList<String> al3 = new ArrayList<>(al2);

    * This constructor creates a new ArrayList and copies all elements from al2 into al3.
    Since String is immutable, this is functionally equivalent to deepcopy method.
    */
    private static ArrayList<String> deepcopy(ArrayList<String> al) {
        ArrayList<String> temp = new ArrayList<>();
        for(String x : al) {
            temp.add(x);
        }
        return temp;
    }
}

class DeepakStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length()) {
            return -1;
        } else if(o1.length() == o2.length()) {
            return 0;
        } else if(o1.length() > o2.length()) {
            return 1;
        }

        return 0;
    }
}