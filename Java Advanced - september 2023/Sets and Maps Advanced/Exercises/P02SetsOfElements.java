package Exercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elementsCount = scanner.nextLine().split(" ");

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        int n = Integer.parseInt(elementsCount[0]);
        int m = Integer.parseInt(elementsCount[1]);

        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextLine());
        }

        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);

        System.out.println(String.join(" ", firstSet));
    }
}
