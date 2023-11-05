package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] evenNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();

        int[] oddNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .toArray();

        Arrays.sort(evenNumbers);
        Arrays.sort(oddNumbers);

        Arrays.stream(evenNumbers).forEach(n -> System.out.print(n + " "));
        Arrays.stream(oddNumbers).forEach(n -> System.out.print(n + " "));
    }

}
