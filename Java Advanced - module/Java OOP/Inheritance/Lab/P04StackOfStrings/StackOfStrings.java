package Lab.P04StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private final List<String> data = new ArrayList<>();

    private int getLastIndex() {

        return data.size() - 1;
    }

    public void push(String item) {

        data.add(item);
    }

    public String pop() {

        return data.remove(getLastIndex());
    }

    public String peek() {

        return data.get(getLastIndex());
    }

    public boolean isEmpty() {

        return data.isEmpty();
    }

}
