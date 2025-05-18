package generics.n3_typeerasure.n1_typeParameters;

public class n2_NumericBox<T extends Number> {
    /*erased to Number*/
    T value;

    public n2_NumericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
