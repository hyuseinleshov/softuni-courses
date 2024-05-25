package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = range[0];
        int end = range[1];

        String condition = scanner.nextLine();

        if (condition.equals("odd")) {
            printRange(start, end, n -> n % 2 != 0);
        } else {
            printRange(start, end, n -> n % 2 == 0);
        }
    }

    private static void printRange(int start, int end, IntPredicate predicate) {
        IntStream.rangeClosed(start, end)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
