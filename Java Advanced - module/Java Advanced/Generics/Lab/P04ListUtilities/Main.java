package Lab.P04ListUtilities;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = List.of(3, 5, 2 , 1);

        Integer min = ListUtils.getMin(numbers);

        System.out.println(min);

    }

}
