package Exercises.P01ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator {

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

}
