package WhileLoop_Lecture;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = scanner.nextLine();

        String otherPassword = scanner.nextLine();
        while (!otherPassword.equals(password)) {
            otherPassword = scanner.nextLine();
        }
        System.out.printf("Welcome %s!",name);
    }
}
