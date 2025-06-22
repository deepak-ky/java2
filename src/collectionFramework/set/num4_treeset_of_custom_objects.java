package collectionFramework.set;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class num4_treeset_of_custom_objects {
    public static void main(String[] args) {
        Set<Person> set1 = new TreeSet<>(new PersonComparator());

        Person p1 = new Person(12, "Deepak");
        Person p2 = new Person(1, "DeepakKumar");
        Person p3 = new Person(8,"DeepakKumarYadav");
        Person p4 = new Person(4, "DeepakKumar");

        set1.add(p1);
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p3);
        set1.add(p4);

        printSet("set1", set1);


        Set<EnhancedPerson> set2 = new TreeSet<>();

        EnhancedPerson ep1 = new EnhancedPerson(p1);
        EnhancedPerson ep2 = new EnhancedPerson(p2);
        EnhancedPerson ep3 = new EnhancedPerson(p3);
        EnhancedPerson ep4 = new EnhancedPerson(p4);

        set2.add(ep1);
        set2.add(ep2);
        set2.add(ep2);
        set2.add(ep3);
        set2.add(ep3);
        set2.add(ep4);

        printSet("set2", set2);
    }

    public static void printSet(String setName, Set<?> set) {
        System.out.println(setName + " : " + set);
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EnhancedPerson implements Comparable<EnhancedPerson> {
    private int id;
    private String name;

    public EnhancedPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EnhancedPerson(Person p) {
        this.id = p.getId();
        this.name = p.getName();
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(EnhancedPerson o) {
        if(this.name.length() < o.getName().length()){
            return -1;
        } else if(this.name.length() == o.getName().length()) {
            if(this.id < o.getId()) {
                return -1;
            } else if(this.id == o.getId()) {
                return 0;
            }else return 1;
        }

        return 1;
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getName().length() > o2.getName().length()) {
            return -1;
        } else if(o1.getName().length() == o2.getName().length()) {
            if(o1.getId() > o2.getId()) {
                return -1;
            } else if(o2.getId() == o2.getId()) {
                return 0;
            } else return 1;
        }

        return 1;
    }
}
