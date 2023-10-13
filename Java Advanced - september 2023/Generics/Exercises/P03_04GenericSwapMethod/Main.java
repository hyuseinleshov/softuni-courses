package Exercises.P03_04GenericSwapMethod;

import Exercises.P01_02GenericBox.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Box<Integer>> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));

            list.add(box);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        swap(list, indexes[0], indexes[1]);

        list.forEach(System.out::println);

    }

    static <T> void swap(List<T> list, int firstIndex, int secondIndex) {

        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);

    }

}
