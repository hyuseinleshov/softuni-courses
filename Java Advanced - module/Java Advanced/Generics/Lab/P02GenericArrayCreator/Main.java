package Lab.P02GenericArrayCreator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = ArrayCreator.create(10, "none");

        Arrays.stream(strings).forEach(System.out::println);

    }

}
