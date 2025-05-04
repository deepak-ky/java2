package randomStuff.passByValueVsPassByReference;

public class num3_Example2 {
    public static void main(String[] args) {
        Cat aCat = new Cat("Lily", 3);
        System.out.println("Outside function");
        System.out.println(aCat);
        foo(aCat);
        System.out.println("Outside function");
        System.out.println(aCat);
    }

    public static void foo(Cat cat) {
        System.out.println("Inside function");
        cat.setAgeInMonths(5);
        System.out.println(cat);
        cat = new Cat("Coco", 1);
        System.out.println(cat);
        cat.setAgeInMonths(2);
        System.out.println(cat);
        System.out.println("returning....");
    }
}

class Cat {
    String name;
    int ageInMonths;

    public Cat(String name, int ageInMonths) {
        this.name = name;
        this.ageInMonths = ageInMonths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(int ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", ageInMonths=" + ageInMonths +
                '}';
    }
}