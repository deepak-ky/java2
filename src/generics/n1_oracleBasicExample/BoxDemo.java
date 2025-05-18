package generics.n1_oracleBasicExample;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo {

    public static void main(String[] args) {
        List<Box<Integer>> integerBoxes = new ArrayList<>();
        BoxDemo.addBox(10, integerBoxes);
        BoxDemo.addBox(20, integerBoxes);
        BoxDemo.addBox(25, integerBoxes);
        BoxDemo.outputBoxes(integerBoxes);
    }
    public static <U> void addBox(U u, List<Box<U>> boxList) {
        Box<U> box = new Box<>();
        box.set(u);
        boxList.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for(Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }
}
