package Lab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        if (type.equals("int")) {
            int max = getMax(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            System.out.println(max);
        } else if (type.equals("char")) {
            char max = getMax(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
            System.out.println(max);
        } else if (type.equals("string")) {
            String max = getMax(scanner.nextLine(), scanner.nextLine());
            System.out.println(max);
        }
    }
    public static int getMax (int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
    public static char getMax (char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
    public static String getMax (String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
