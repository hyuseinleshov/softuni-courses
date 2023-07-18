package Lab;

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        List<Integer> numbersList = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).collect(Collectors.toList());;

        int n = numbersList.size() / 2;
        for (int i = 0; i < n; i++) {
            int firstNum = numbersList.get(i);
            int lastNum = numbersList.get(numbersList.size() - 1);

            int sum = firstNum + lastNum;
            numbersList.set(i, sum);
            numbersList.remove(numbersList.size() - 1);
        }
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(numbersList.get(i) + " ");
        }
    }
}
