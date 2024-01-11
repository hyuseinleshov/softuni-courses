package Exercises.P01_02GenericBox;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), value);
    }

    @Override
    public int compareTo(Box<T> o) {

        return this.value.compareTo(o.value);
    }

}
