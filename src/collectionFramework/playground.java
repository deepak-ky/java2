package collectionFramework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class playground {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(45);
        al.add(89);
        al.add(56);

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offerLast(100);

        System.out.println("ad : " + ad);
        System.out.println("al : " + al);

        ad.addAll(al);
        System.out.println("ad : " + ad);
        /*Stack<Integer> s = new Stack<>();
        s.add(12);
        s.add(13);
        s.add(14);
        s.push(15);
        System.out.println(s);

        s.pop();
        System.out.println(s);
        s.remove(0);
        System.out.println(s);
        s.remove(0);
        System.out.println(s);
        s.remove(0);
        System.out.println(s);
        s.pop();
        System.out.println(s);*/
    }
}
