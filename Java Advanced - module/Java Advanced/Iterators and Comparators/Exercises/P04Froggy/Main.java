package Exercises.P04Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(numbers);

        String command = scanner.nextLine();

        StringBuilder numbersSb = new StringBuilder();

        int index = 0;

        for (Integer number : lake) {

            if (index % 2 == 0) {
                numbersSb.append(number).append(", ");
            }

            index++;
        }

        int secondIndex = 0;

        for (Integer number : lake) {

            if (secondIndex % 2 != 0) {
                numbersSb.append(number).append(", ");
            }

            secondIndex++;
        }

        String substring = numbersSb.substring(0, numbersSb.length() - 2);

        System.out.println(substring);
    }

}
