package generics.n3_typeerasure.n1_typeParameters;

public class n3_TypeParameterInArrays {
    public static <T> T fromArray(T[] a, T elem) {
        /*Erased to Object Array and Object*/
        return elem;
    }

    public static <T extends Number> T fromArray2(T[] a, T elem) {
        /*Erased to Number Array and Number*/
        return elem;
    }
}
