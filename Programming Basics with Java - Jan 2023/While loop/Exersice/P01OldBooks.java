package WhileLoop_Exercise;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String herBook = scanner.nextLine();

        int checkedBooksCount = 0;
        String currentBook = scanner.nextLine();
        while (!currentBook.equals(herBook)) {
            checkedBooksCount++;
            currentBook = scanner.nextLine();
            if (currentBook.equals("No More Books")) {
                break;
            }
        }
        if (currentBook.equals(herBook)) {
            System.out.printf("You checked %d books and found it.",checkedBooksCount);
        } else {
            System.out.printf("The book you search is not here!%n");
            System.out.printf("You checked %d books.",checkedBooksCount);
        }
    }
}
