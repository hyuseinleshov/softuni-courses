package Lab.P03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private final Random random = new Random();

    public Object getRandomElement() {

        int index = random.nextInt(super.size());

        return super.remove(index);

    }

}
