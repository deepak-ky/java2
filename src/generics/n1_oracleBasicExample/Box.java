package generics.n1_oracleBasicExample;

public class Box<T> {
    T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
