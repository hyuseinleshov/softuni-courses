package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        printList(numbers);

        Collections.sort(numbers);

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        String result = String.join(", ", numbers.stream()
                .map(Object::toString)
                .toArray(String[]::new));
        System.out.println(result);
    }
}
