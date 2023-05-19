import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesCount = Integer.parseInt(scanner.nextLine());
        int pages = Integer.parseInt(scanner.nextLine());
        int daysCount = Integer.parseInt(scanner.nextLine());

        int allTimeToReadBook = pagesCount / pages;
        int neededTime = allTimeToReadBook / daysCount;

        System.out.println(neededTime);
    }
}
