package Exercises.P04Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] numbers;

    public Lake(int... numbers) {
        this.numbers = numbers;
    }

    private int size() {

        return this.numbers.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public Integer next() {
            return numbers[index++];
        }

    }

}
