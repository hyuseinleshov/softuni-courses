package Lab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinates[0];
        int topRightX = coordinates[1];
        int bottomLeftY = coordinates[2];
        int topRightY = coordinates[3];

        int n = Integer.parseInt(scanner.nextLine());

        Rectangle rectangle = new Rectangle(bottomLeftX, topRightX, bottomLeftY, topRightY);

        for (int i = 0; i < n; i++) {

            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int x = numbers[0];
            int y = numbers[1];

            Point point = new Point(x, y);

            System.out.println(rectangle.contains(point));
        }



    }

}
