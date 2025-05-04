package randomStuff.passByValueVsPassByReference;

public class num2_Example {
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        System.out.println(aDog.getName());
        foo(aDog);
        System.out.println(aDog.getName());
    }

    public static void foo(Dog d) {
        d = new Dog("Fifi");
    }
}

class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
