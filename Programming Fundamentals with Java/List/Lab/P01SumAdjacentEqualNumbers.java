package Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        List<Double> numbersList = Arrays.stream(numbers.split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbersList.size() - 1; i++) {
            double currentNum = numbersList.get(i);
            double nextNum = numbersList.get(i + 1);
            if (currentNum == nextNum) {
                double sum = currentNum + nextNum;
                numbersList.set(i, sum);
                numbersList.remove(i + 1);
                i = -1;
            }
        }
        String output = joinElementsByDelimiter(numbersList, " ");
        System.out.println(output);
    }
    public static String joinElementsByDelimiter (List<Double> numbersList, String delimiter) {
        String output = "";
        for (Double number : numbersList) {
            output += (new DecimalFormat("0.#").format(number) + delimiter);
        }
        return output;
    }
}
