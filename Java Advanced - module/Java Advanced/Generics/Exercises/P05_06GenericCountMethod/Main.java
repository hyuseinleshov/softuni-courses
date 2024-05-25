package Exercises.P05_06GenericCountMethod;

import Exercises.P01_02GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            
            list.add(new Box<>(Double.parseDouble(scanner.nextLine())));
        }

        Box<Double> element = new Box<>(Double.parseDouble(scanner.nextLine()));

        System.out.println(countGreaterElements(list, element));

    }

    public static <T extends Comparable<T>> int countGreaterElements(List<T> data, T element) {

        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);

            if (res > 0) {
                count++;
            }
        }

        return count;
    }

}
