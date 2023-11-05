import java.util.Scanner;

public class P02RecursiveFactorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calculateFactorial(n));

    }

    private static long calculateFactorial(int num) {

        if (num == 0) {

            return 1;
        }

        return num * calculateFactorial(num - 1);
    }

}
