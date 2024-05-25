package Exercises.P02Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {

    private List<String> data;
    private int internalIndex = 0;

    public ListyIterator(String... data) {
        this.data = Arrays.asList(data);
    }

    public int size() {

        return this.data.size();
    }

    public boolean Move() {

        if (this.internalIndex == size() - 1) {
            return false;
        } else {
            internalIndex++;
            return true;
        }
    }

    public boolean HasNext() {

        if (this.internalIndex == size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    public void Print() {

        if (this.data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.data.get(internalIndex));
        }

    }

    private void checkIndex(int index) {

        if (index < 0 || index > this.data.size() - 1) {
            String message = "invalid Operation!";
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public String next() {
            return data.get(index++);
        }
    }

}
