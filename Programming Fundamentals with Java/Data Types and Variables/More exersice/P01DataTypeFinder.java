package MoreExersises;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            System.out.println(input.getClass().getSimpleName());
            input = scanner.nextLine();
        }
    }
}
