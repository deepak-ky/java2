package collectionFramework.hashmap_and_comparison;

import java.util.*;

public class comparison {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Deepak", Branch.ECE);
        Student s2 = new Student(2, "Suyash", Branch.SE);
        Student s3 = new Student(3, "Deepak", Branch.IT);
        Student s4 = new Student(4, "Abhinav", Branch.ECE);

        ArrayList<Student> arrayList = new ArrayList<>(Arrays.asList(s4,s3,s2,s1));
        
        System.out.println("arrayList :                 " + arrayList);
        /*Student needs to implement comparable interface*/
        Collections.sort(arrayList);
        System.out.println("sorted on roll_no :         " + arrayList);

        /*comparator can be passed in both Collections.sort() method and list.sort() method*/
        Collections.sort(arrayList, new StudentComparator());
        System.out.println("sorted on name :            " + arrayList);

        /*anonymous class comparator*/
        arrayList.sort(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                /*recommended to use Integer.compare method*/
                return o2.getRollNo().compareTo(o1.getRollNo());
                //return o2.getRollNo()- o1.getRollNo();
            }
        });
        System.out.println("sorted on reverse roll_no : " + arrayList);

        /*using lambda*/
        /*RE COMMENDED METHOD*/
        arrayList.sort((student1, student2) -> {
            if(student1.getBranchCode().getBranchRank() == student2.getBranchCode().getBranchRank()) {
                return student1.getRollNo().compareTo(student2.getRollNo());
            }
            return student1.getBranchCode().getBranchRank() - student2.getBranchCode().getBranchRank();
        });
        System.out.println("sorted on branch_rank :     " + arrayList);

        System.out.println("----");

        /*simplified lambda expressions - 1
        * no need for a return statement*/
        arrayList.sort((student1, student2) -> student1.getRollNo().compareTo(student2.getRollNo()));
        System.out.println("sorted on roll_no :         " + arrayList);

        /*simplified lambda expressions - 2*/
        arrayList.sort(Comparator.comparing(Student::getBranchRank));
        System.out.println("sorted on branch_rank :     " + arrayList);

        /*lambda expression with thenComparing*/
        arrayList.sort(Comparator.comparing(Student::getBranchRank).thenComparing(Student::getName));
        System.out.println("sorted on branch_rank :     " + arrayList);

        /*Comparators can also be defined like this*/
        Comparator<Student> byRanking = (Student student1, Student student2) -> Integer.compare(student1.getBranchRank(), student2.getBranchRank());
        Collections.sort(arrayList, byRanking);
        System.out.println("sorted on branch_rank :     " + arrayList);

        /*works without <Student> too => Comparator byRollNo*/
        Comparator<Student> byRollNo = Comparator.comparing(Student::getRollNo);
        arrayList.sort(byRollNo);
        System.out.println("sorted on roll_no :         " + arrayList);
    }
}

class Student implements Comparable<Student> {
    private Integer rollNo;
    private String name;
    private Branch branchCode;

    public Student(Integer rollNo, String name, Branch branchCode) {
        this.rollNo = rollNo;
        this.name = name;
        this.branchCode = branchCode;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public Branch getBranchCode() {
        return branchCode;
    }

    public int getBranchRank() {
        return branchCode.getBranchRank();
    }

    @Override
    public String toString() {
        return  rollNo + "_" + name + "_" + branchCode.name();
    }

    @Override
    public int compareTo(Student s) {
        /*All three of them work the same*/
        //return rollNo - s.getRollNo();

        /*In Java, one instance of a class can access private fields of another instance of the same class.
        So this is legal, though using getter is preferred.*/
        return rollNo - s.rollNo;

        /*The above two methods can overflow,
        * e.g. (INTEGER.MIN_VALUE - 1),
        * hence the recommended version is the below one*/
        // return Integer.compare(rollNo, s.getRollNo());
    }
}

enum Branch {
    CSE(1),
    IT(2),
    SE(3),
    ECE(4);

    private int branchRank;
    Branch(int branchRank) {
        this.branchRank = branchRank;
    }

    public int getBranchRank() {
        return branchRank;
    }
}

class  StudentComparator implements Comparator<Student> {
    /**
     * Using the comparable implementations of Integer and String class */
    @Override
    public int compare(Student o1, Student o2) {
        /*using equals instead of ==*/
        if(o1.getName().equals(o2.getName())) {
            return o1.getRollNo().compareTo(o2.getRollNo());
        }

        return o1.getName().compareTo(o2.getName());
    }
}