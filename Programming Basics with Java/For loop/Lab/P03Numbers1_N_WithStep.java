package ForLoop_Lecture;

import java.util.Scanner;

public class P03Numbers1_N_WithStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i = i + 3) {
            System.out.println(i);
        }
    }
}
