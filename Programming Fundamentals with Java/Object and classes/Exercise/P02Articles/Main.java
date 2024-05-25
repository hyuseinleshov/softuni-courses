package Exercise.P02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String[] articleArray = articleData.split(", ");

        String title = articleArray[0];
        String content = articleArray[1];
        String author = articleArray[2];

        Article article = new Article(title, content, author);

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] commandString = command.split(": ");
            String neededTextToChange = commandString[1];
            if (commandString[0].equals("Edit")) {
                article.Edit(neededTextToChange);
            } else if (commandString[0].equals("ChangeAuthor")) {
                article.ChangeAuthor(neededTextToChange);
            } else {
                article.Rename(neededTextToChange);
            }
        }
        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
