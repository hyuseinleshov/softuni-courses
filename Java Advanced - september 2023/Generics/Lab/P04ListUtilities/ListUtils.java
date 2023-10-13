package Lab.P04ListUtilities;

import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMax(List<T> list) {

        if (list.isEmpty()) {
            String message = "List is empty!";
            throw new IllegalArgumentException(message);
        }

        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).compareTo(max) == 1) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {

        if (list.isEmpty()) {
            String message = "List is empty!";
            throw new IllegalArgumentException(message);
        }

        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }

        return min;
    }



}
