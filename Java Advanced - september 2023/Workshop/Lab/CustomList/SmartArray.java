package Lab.CustomList;

import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;

    public SmartArray() {
        data = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {

        if (size == data.length) {
            data = resize(data, '*');
        }

        data[size++] = element;

    }

    private int[] resize(int[] data, char symbol) {

        int length = 1;

        if (symbol == '*') {
            length = this.data.length * 2;
        } else if (symbol == '/'){
            length = this.data.length / 2;
        }

        int[] copy = new int[length];

        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }

        return copy;
    }

    public int get(int index) {
        checkIndex(index);

        return data[index];
    }

    private void checkIndex(int index) {

        String message = String.format("Index %d out of bounds for length %d", index, size);

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(message);
        }

    }

    public int remove(int index) {
        checkIndex(index);

        if (size == data.length / 4) {
            data = resize(data, '/');
        }

        int element = data[index];

        data = shiftLeft(data, index);
        size--;

        return element;
    }

    private int[] shiftLeft(int[] data, int index) {

        int length = size;

        if (index == size - 1) {
            data[index] = 0;
        } else {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }

            data[size - 1] = 0;
        }

        return data;
    }

    public boolean contains(int element) {

        boolean isContains = false;

        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                isContains = true;
                break;
            }
        }

        return isContains;
    }

    public void add(int index, int element) {

        checkIndex(index);

        data = shiftRight(data, index);

        data[index] = element;
    }

    private int[] shiftRight(int[] data, int index) {

        if (size == data.length) {
            data = resize(data, '*');
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        size++;

        return data;
    }

    public void forEach(Consumer<Integer> consumer) {

        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }

    }

}
