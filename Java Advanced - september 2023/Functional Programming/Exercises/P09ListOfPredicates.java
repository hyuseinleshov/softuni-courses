package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntPredicate isDivisibleBySequence = number -> Arrays.stream(numbers).allMatch(num -> number % num == 0);

        List<Integer> divisibleNumber = IntStream.rangeClosed(1, n)
                .filter(isDivisibleBySequence)
                .boxed()
                .collect(Collectors.toList());

        divisibleNumber.forEach(number -> System.out.print(number + " "));

    }

}
