import java.util.Scanner;

public class P04Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double points = 0;
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int other = 0;
        for (int i = 1; i <= n ; i++) {
            String ballColour = scanner.nextLine();
            if (ballColour.equals("red")) {
                points += 5;
                red++;
            } else if (ballColour.equals("orange")) {
                points += 10;
                orange++;
            } else if (ballColour.equals("yellow")) {
                points += 15;
                yellow++;
            } else if (ballColour.equals("white")) {
                points += 20;
                white++;
            } else if (ballColour.equals("black")) {
                points = Math.floor(points / 2);
                black++;
            } else {
                other++;
            }
        }
        System.out.printf("Total points: %.0f%n",points);
        System.out.printf("Red balls: %d%n",red);
        System.out.printf("Orange balls: %d%n",orange);
        System.out.printf("Yellow balls: %d%n",yellow);
        System.out.printf("White balls: %d%n",white);
        System.out.printf("Other colors picked: %d%n",other);
        System.out.printf("Divides from black balls: %d",black);
    }
}
