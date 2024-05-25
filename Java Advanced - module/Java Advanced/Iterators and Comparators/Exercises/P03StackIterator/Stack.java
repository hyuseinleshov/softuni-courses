package Exercises.P03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack implements Iterable<Integer> {

    private List<Integer> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    public int size() {

        return this.data.size();
    }

    public void push(int element) {

        this.data.add(element);
    }

    public int pop() {

        if (size() == 0) {
            String message = "No elements";
            throw new NoSuchElementException(message);
        }

        int element = this.data.get(size() - 1);

        this.data.remove(size() - 1);

        return element;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {

        int index = size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            return data.get(index--);
        }

    }

}
