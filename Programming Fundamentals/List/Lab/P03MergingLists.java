package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers1 = scanner.nextLine();
        List<Integer> numbersList1 = Arrays.stream(numbers1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String numbers2 = scanner.nextLine();
        List<Integer> numbersList2 = Arrays.stream(numbers2.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int firstListSize = numbersList1.size();
        int secondListSize = numbersList2.size();

        if (firstListSize == secondListSize) {
            for (int i = 0; i < firstListSize; i++) {
                resultList.add(numbersList1.get(i));
                resultList.add(numbersList2.get(i));
            }
        } else if (firstListSize > secondListSize) {
            for (int i = 0; i < firstListSize; i++) {
                resultList.add(numbersList1.get(i));
                if (numbersList2.size() > i) {
                    resultList.add(numbersList2.get(i));
                }
            }
        } else if (firstListSize < secondListSize) {
            for (int i = 0; i < secondListSize; i++) {
                if (numbersList1.size() > i) {
                    resultList.add(numbersList1.get(i));
                }
                    resultList.add(numbersList2.get(i));
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i) + " ");
        }
    }
}
