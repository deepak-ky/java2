package generics.n3_typeerasure.n1_typeParameters;



public class n1_Box<T> {
    /*erased to Object*/
    public static void main(String[] args) {
        System.out.println("refresh .class files, to view the bytecode go to View/Show Bytecode");
    }
    T value;

    public n1_Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
