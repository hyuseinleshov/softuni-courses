package Exercises;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elementsArray = scanner.nextLine().split(" ");
            for (int j = 0; j < elementsArray.length; j++) {
                if (!elementsSet.contains(elementsArray[j])) {
                    elementsSet.add(elementsArray[j]);
                }
            }
        }

        for (String element : elementsSet) {
            System.out.print(element + " ");
        }
    }
}
