package Exersice;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonsCount = Integer.parseInt(scanner.nextLine());

        int[] peoplesArray = new int[wagonsCount];
        int sum = 0;

        for (int i = 0; i < wagonsCount; i++) {
            int peoples = Integer.parseInt(scanner.nextLine());
            peoplesArray[i] = peoples;
            sum += peoples;
        }
        for (int i = 0; i < peoplesArray.length; i++) {
            System.out.print(peoplesArray[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
