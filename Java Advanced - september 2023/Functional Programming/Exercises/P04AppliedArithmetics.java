package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = numbers.stream()
                            .map(number -> number + 1).
                            collect(Collectors.toList());

                    break;
                case "multiply":
                    numbers = numbers.stream()
                            .map(number -> number * 2).
                            collect(Collectors.toList());

                    break;
                case "subtract":
                    numbers = numbers.stream()
                            .map(number -> number - 1).
                            collect(Collectors.toList());

                    break;
                case "print":
                    System.out.println();
                    numbers.stream().forEach(n -> System.out.print(n + " "));

                    break;
            }

            input = scanner.nextLine();
        }

    }
}
