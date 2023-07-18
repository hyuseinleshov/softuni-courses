package L02ConditionalStatements;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        double area = 0;

        if (type.equals("square")) {
            double squareLength = Double.parseDouble(scanner.nextLine());
            area = squareLength * squareLength;
        } else if (type.equals("rectangle")) {
            double rectangleLength1 = Double.parseDouble(scanner.nextLine());
            double rectangleLength2 = Double.parseDouble(scanner.nextLine());
            area = rectangleLength1 * rectangleLength2;
        } else if (type.equals("triangle")) {
            double triangleLength = Double.parseDouble(scanner.nextLine());
            double triangleHigth = Double.parseDouble(scanner.nextLine());
            area = (triangleLength * triangleHigth) / 2;
        } else if (type.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * (radius * radius);
        }
        System.out.printf("%.3f",area);
    }
}
