package Exersices;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        List<String> numbersList = (Arrays.asList(numbers.split("")));

        List<String> resultList = new ArrayList<>();
        List<String> finalList = new ArrayList<>();


        while (true) {
            for (int i = numbersList.size() - 1; i >= 0; i--) {
                if (numbersList.get(i).equals(" ")) {

                } else if (numbersList.get(i).equals("|")) {
                    Collections.reverse(resultList);
                    finalList.addAll(resultList);
                    resultList.clear();
                } else {
                resultList.add(numbersList.get(i));
                }
            }
            Collections.reverse(resultList);
            finalList.addAll(resultList);
            break;
        }
        for (int i = 0; i < finalList.size(); i++) {
            System.out.print(finalList.get(i) + " ");
        }
    }
}
