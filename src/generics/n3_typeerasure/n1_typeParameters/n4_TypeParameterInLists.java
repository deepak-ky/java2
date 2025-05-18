package generics.n3_typeerasure.n1_typeParameters;

import java.util.List;

public class n4_TypeParameterInLists {

    public static <T> T fromList(List<T> list, T elem) {
        /*Erased to List and Object*/
        return elem;
    }

    public static <T extends Number> T fromList2(List<T> list, T elem) {
        /*Erased to List and Number*/
        return elem;
    }
}
