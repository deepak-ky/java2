package collectionFramework.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Try running this file in two ways:
 * 1. With the equals() and hashCode() methods in Student class COMMENTED OUT
 * 2. With them UNCOMMENTED
 *
 * Observe how HashSet behaves in both cases.
 */
public class num2_hashset_of_custom_objects {
    public static void main(String[] args) {
        Set<Student> set1 = new HashSet<>();
        Set<Student> set2 = new HashSet<>();

        Student student1 = new Student(1, "Deepak");
        Student student2 = new Student(2, "Anuj");
        Student student3 = new Student(3, "Deepak");
        Student student4 = new Student(1, "Deepak");

        set1.add(new Student(1, "Deepak"));
        set1.add(new Student(1, "Deepak"));
        set1.add(new Student(2, "Anuj"));
        set1.add(new Student(2, "Anuj"));
        set1.add(new Student(3, "Deepak"));
        set1.add(new Student(1, "Deepak"));

        set2.add(student1);
        set2.add(student1);
        set2.add(student2);
        set2.add(student2);
        set2.add(student3);
        /*
         * Understanding equals() and hashCode() in HashSet
         *
         * HashSet uses a combination of hashCode() and equals() to determine object uniqueness:
         *
         * 1. hashCode() is used to locate the correct bucket in the hash table.
         * 2. equals() is used to check if an object in the same bucket is "equal" to the new one.
         *
         * To prevent duplicates, both these methods must behave consistently:
         * - If two objects are logically equal (as per equals()), they must also return the same hashCode().
         * - If this contract is broken, unexpected duplicates can appear in the set.
         *
         * 🔍 Case 1: equals() and hashCode() are NOT overridden
         * - Java uses the default implementations from Object class:
         *     - hashCode(): returns a value based on memory address
         *     - equals(): compares object references (i.e., this == other)
         * - So even if two Student objects have the same rollNo and name, they are treated as different if they are separate objects.
         * - Result: Both objects are added to the HashSet — duplicate not detected.
         *
         * 🔍 Case 2: ONLY hashCode() is overridden, but equals() is NOT
         * - Two objects with the same rollNo can return the same hashCode and go to the same bucket.
         * - However, since equals() is not overridden, it still compares memory references (this == other) → returns false.
         * - Result: Even though they are in the same bucket, they are still treated as different and both are added.
         *
         * ✅ Conclusion:
         * - Overriding only one of hashCode() or equals() is not enough.
         * - You must override both, and ensure they are consistent:
         *     - If equals() returns true, then hashCode() must return the same value.
         *     - If equals() returns false, the hashCode values may or may not be the same.
         * - This ensures that logically equal objects are detected correctly and duplicates are avoided.
         */
        set2.add(student4);

        printSet("set1", set1);
        printSet("set2", set2);
    }

    public static void printSet(String setName, Set<?> set) {
        System.out.println(setName + " : " + set);
    }
}

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }
}