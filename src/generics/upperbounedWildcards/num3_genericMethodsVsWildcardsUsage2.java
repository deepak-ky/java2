package generics.upperbounedWildcards;

public class num3_genericMethodsVsWildcardsUsage2 {
    public static void main(String[] args) {
        Bike newBike = new Bike();
        System.out.println(countTyres2(newBike));
        System.out.println(countTyres3(newBike));

        /*System.out.println(countTyres5(newBike));
        System.out.println(countTyres6(newBike));*/
    }


    /*
    * Wildcard types like (? extends Bike) cannot be used in method parameter declarations directly
    * Wildcards (? extends Something) are only allowed in generic type declarations, such as for method
    * parameters of type collections(List<? extends Bike>), not standalone object parameters
    */
    /*public static Integer countTyres1((? extends Bike) bike) {
        return bike.getTyres();
    }*/

    public static <T extends Bike> Integer countTyres2(T bike) {
        return bike.getTyres();
    }

    public static Integer countTyres3(Bike bike) {
        return bike.getTyres();
    }


    /*Same Issue as countTyres1*/
    /*public static Integer countTyres4((? extends Motor) motor) {
        return motor.getTyres();
    }*/

    /*Motor does not have a getTyres() method
    * Even if you pass a bike, the compiler cannot guarantee that every T has getTyres()
    * -- it can only guarantee every T is motor*/
    /*public static <T extends Motor> Integer countTyres5(T motor) {
        return motor.getTyres();
    }*/

    /*This does not work because compiler only looks at the declared type(Motor),
    not the actual object, that the method has been invoked on*/
    /*public static Integer countTyres6(Motor motor) {
        return motor.getTyres();
    }*/
}

class Motor {

}

class Bike extends Motor {
    public Integer getTyres() {
        return 2;
    }
}