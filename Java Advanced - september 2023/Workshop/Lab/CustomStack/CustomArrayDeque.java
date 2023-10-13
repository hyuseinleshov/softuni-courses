package Lab.CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomArrayDeque {

    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;

    public CustomArrayDeque() {
        this.data = new int[INITIAL_CAPACITY];
    }

    public void push(int element) {

        if (data.length == size) {
            data = resize(data, '*');
        }

        data[size] = element;
        size++;
    }

    public int pop() {

        checkIsEmpty(data);

        if (data.length / 4 == size) {
            data = resize(data, '/');
        }

        int element = data[size - 1];
        data[size - 1] = 0;
        size--;

        return element;
    }

    public int peek() {
        checkIsEmpty(this.data);

        return data[size - 1];
    }

    public void forEach(Consumer<Integer> consumer) {

        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    private void checkIsEmpty(int[] data) {

        if (size == 0) {
            String message = "Stack is empty!";

            throw new NoSuchElementException(message);
        }
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

}
