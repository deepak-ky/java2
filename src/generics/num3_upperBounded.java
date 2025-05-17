package generics;

import models.User;

public class num3_upperBounded {
    public static void main(String[] args) {
        System.out.println(getFormula(new Rectange()));
        System.out.println(getFormula(new Circle()));
        System.out.println(getFormula(new Square1()));
        System.out.println(getFormula(new Shape() {
            @Override
            String getFormulaToCalculateArea() {
                return "new_custom_formula";
            }
        }));

        System.out.println(getFormula2(new Rectange()));
        System.out.println(getFormula2(new Circle()));
        System.out.println(getFormula2(new Square2()));
        System.out.println(getFormula2(new Shape() {
            @Override
            String getFormulaToCalculateArea() {
                return "new_custom_formula";
            }
        }));

        /*reason: User is not compatible with Shape*/
        //System.out.println(getFormula(new User("Deepak", 23)));
        //System.out.println(getFormula2(new User("Deepak", 23)));
    }

    public static <T extends Shape> String getFormula(T shape) {
        return "1: " + shape.getClass().getSimpleName() + " Formula : " + shape.getFormulaToCalculateArea();
    }

    public static String getFormula2(Shape shape) {
        return "2: " + shape.getClass().getSimpleName() + " Formula : " + shape.getFormulaToCalculateArea();
    }
}

abstract class Shape {
     abstract String getFormulaToCalculateArea();
}

class Rectange extends Shape {

    @Override
    String getFormulaToCalculateArea() {
        return "length (X) breadth";
    }
}

class Circle extends Shape {

    @Override
    String getFormulaToCalculateArea() {
        return "pi * radius * radius";
    }
}

class Square1 extends Rectange {
    @Override
    String getFormulaToCalculateArea() {
        return "side * side";
    }
}

class Square2 extends Rectange {

}

