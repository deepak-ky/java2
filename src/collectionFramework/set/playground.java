package collectionFramework.set;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class playground {
    /*1. Run directly
    * 2. Add hashcode and run
    * 3. Add hashcode and equals and then run*/
    public static void main(String[] args) {
        Set<PlaygroundStudent> set = new HashSet<>();
        set.add(new PlaygroundStudent(1, "Deepak"));
        set.add(new PlaygroundStudent(1, "Deepak"));
        set.add(new PlaygroundStudent(2, "Kumar"));
        set.add(new PlaygroundStudent(1, "Deepak"));


        System.out.println("set1 : " + set);


        Set<PlaygroundStudent> set2 = new HashSet<>();
        PlaygroundStudent ps1 = new PlaygroundStudent(1, "Deepak");
        PlaygroundStudent ps2 = new PlaygroundStudent(2, "Kumar");
        PlaygroundStudent ps3 = new PlaygroundStudent(1, "Deepak");
        /*below are considered same*/
        set2.add(ps1);
        set2.add(ps1);
        set2.add(ps2);
        set2.add(ps3);

        System.out.println("set2 : " + set2);
    }
}

class PlaygroundStudent {
    int rollNo;
    String name;

    public PlaygroundStudent(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlaygroundStudent{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaygroundStudent that = (PlaygroundStudent) o;
        return rollNo == that.rollNo;
    }

    @Override
    public int hashCode() {
        int randomNumber = 1;
        /*randomNumber = (int)((new Date()).getTime()%7.0d);
        System.out.println("randomNumber : " + randomNumber);*/
        return Objects.hash(rollNo) * randomNumber;
    }
}
