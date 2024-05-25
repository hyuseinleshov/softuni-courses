package Lab;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int counter = 0;
        for (int i = 0; i < array.length / 2; i++) {
            String oldElement = array[i];
            array[i] = array[array.length - 1 - counter];
            array[array.length - 1 - counter] = oldElement;
            counter++;
        }

        for (String e : array) {
            System.out.print(e + " ");
        }
    }
}
