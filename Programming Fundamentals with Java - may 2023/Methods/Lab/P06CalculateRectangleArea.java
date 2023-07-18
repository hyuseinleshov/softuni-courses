package Lab;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int area = area(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        System.out.println(area);
    }
    public static int area (int width, int length) {
        return width * length;
    }
}
