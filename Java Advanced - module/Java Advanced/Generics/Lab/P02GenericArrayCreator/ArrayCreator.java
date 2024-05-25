package Lab.P02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator extends Object {

    public static <T> T[] create(int length, T item) {

        T[] array = create(item.getClass(), length, item);

        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> type, int length, T item) {

        T[] array = (T[]) Array.newInstance(type, length);

        Arrays.fill(array, item);

        return array;
    }

}
