package Exercises.P07_08CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Comparable<CustomList<T>> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {

        return this.data.remove(index);
    }

    public boolean contains(T element) {

        return this.data.contains(element);
    }

    public void swap (int firstIndex, int secondIndex) {

        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {

        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);

            if (res > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int compareTo(CustomList<T> o) {
        return 0;
    }

    public int size() {

        return this.data.size();
    }

    public T getMax() {

        return Collections.max(this.data);
    }

    public T getMin() {

        return Collections.min(this.data);
    }

    public void print() {

        for (T element : this.data) {
            System.out.println(element);
        }

    }

    public void sort() {

        Collections.sort(this.data);
    }

}
