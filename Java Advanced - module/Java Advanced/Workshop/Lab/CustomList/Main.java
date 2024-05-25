package Lab.CustomList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(13);
        list.add(5);
        list.add(2);
        list.add(43);
        list.add(6);

        SmartArray smartArray = new SmartArray();

        smartArray.add(13);
        smartArray.add(1);
        smartArray.add(3);
        smartArray.add(5);
        smartArray.add(2);

        smartArray.remove(0);
        smartArray.remove(1);
        smartArray.remove(1);
        smartArray.remove(1);
        smartArray.remove(0);

        smartArray.add(2);
        smartArray.add(2);
        smartArray.add(2);

        System.out.println();

    }

}
