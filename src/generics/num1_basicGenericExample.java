package generics;

public class num1_basicGenericExample {
    public static void main(String[] args) {

        /*
        Raw use of parameterized class student
        Student s1 = new Student("2K18/SE/051");

        Explicit type argument String can be replaced with <>
        Student<String> s1 = new Student<String>("2K18/SE/051");
        */
        Student<String> s1 = new Student<>("2K18/SE/051");
        System.out.println(s1.getId());

        /*
        Type argument cannot be of primitive type
        Student<int> s2 = new Student<>(12);
        */
        Student<Integer> s2 = new Student<>(12);
        System.out.println(s2.getId());

        Student<Boolean> s3 = new Student<>(true);
        System.out.println(s3.getId());

        Student<Float> s4 = new Student<>(12.23423F);
        System.out.println(s4.getId());

        Student2<Integer, String> s5 = new Student2<>(12,"Deepak");
        System.out.println("Id : " + s5.getId() + " , Name : " + s5.getName());
        Student2<String, Integer> s6 = new Student2<>("Deepak", 134);
        System.out.println("Id : " + s6.getId() + " , Name : " + s6.getName());

        Student2<Float, Boolean> s7 = new Student2<>(34.234F, false);
        System.out.println("Id : " + s7.getId() + " , Name : " + s7.getName());
    }
}

class Student<T> {
    private T id;
    Student(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

class Student2<T,V> {
    private T Id;
    private V name;

    Student2(T Id, V name) {
        this.Id = Id;
        this.name = name;
    }

    public T getId() {
        return Id;
    }

    public V getName() {
        return name;
    }
}