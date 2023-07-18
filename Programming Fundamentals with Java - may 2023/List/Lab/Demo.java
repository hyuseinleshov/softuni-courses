package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = new ArrayList<>();

        namesList.size();
        namesList.add("Hiusein");
        namesList.add("Ahmed");
        namesList.add(0, "Audi");
        namesList.remove("Ahmed");

        System.out.println(String.join("; ", namesList));

        String names = scanner.nextLine();
        List<String> namesList2 = Arrays.stream(names.split(" ")).toList();

        String numbers = scanner.nextLine();
        List<Integer> numbersList = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).toList();

        System.out.println();
    }
}
