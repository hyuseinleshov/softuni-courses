package Exercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        charactersInRange(first, second);
    }
    public static void charactersInRange (char first, char second) {
        int firstRange = (int) first;
        int secondRange = (int) second;

        if (firstRange > secondRange) {
            for (int i = secondRange + 1; i < firstRange; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = firstRange + 1; i < secondRange; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
