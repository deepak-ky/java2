package collectionFramework.set;

import java.util.EnumSet;
import java.util.Set;

public class num5_enumset {
    public static void main(String[] args) {
        System.out.println(Color.RED);
        System.out.println(Color.BLUE.name());

        System.out.println("---");

        Set<Color> colorSet = EnumSet.allOf(Color.class);
        System.out.println("colorSet.getClass().getSimpleName() : " + colorSet.getClass().getSimpleName());
        System.out.println("colorSet : " + colorSet);

        Set<Color> colorSet2 = EnumSet.of(Color.RED, Color.BLUE);
        System.out.println("colorSet2 : " + colorSet2);

        Set<Color> colorSet3 = EnumSet.range(Color.BLUE, Color.PURPLE);
        System.out.println("colorSet3 : " + colorSet3);

        /*# EnumSet in Java

            ## ✅ What is `EnumSet`?

            - `EnumSet` is a specialized `Set` implementation for use with **enum types only**.
            - It is part of the Java Collections Framework (`java.util` package).
            - All elements in an `EnumSet` must come from the **same enum type**, which is specified at the time of creation.

            ---

            ## 🚀 Key Features

            - **Extremely fast** (much faster than `HashSet` for enums).
            - **Memory-efficient** (internally uses a bit vector).
            - **Maintains natural order** (as declared in the enum).
            - **Not thread-safe** (but can be wrapped using `Collections.synchronizedSet()`).
            - **Null elements are not allowed**.

            ---

            ## 🧠 Internal Working

            - Internally implemented as a **bit vector**, where each bit corresponds to an enum constant.
            - Operations like `add`, `contains`, and `remove` are performed using **bitwise arithmetic**, making them very efficient.

            ---

            ## 📦 Common Factory Methods

            ```java
            EnumSet.allOf(MyEnum.class);            // Contains all enum constants
            EnumSet.noneOf(MyEnum.class);           // Empty set
            EnumSet.of(MyEnum.VALUE1, VALUE2);      // Specific values
            EnumSet.range(MyEnum.START, MyEnum.END);// All values in a range
            EnumSet.complementOf(set);              // All elements not in the given set
         */
    }
}

enum Color {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    PURPLE,
    ORANGE;
}
