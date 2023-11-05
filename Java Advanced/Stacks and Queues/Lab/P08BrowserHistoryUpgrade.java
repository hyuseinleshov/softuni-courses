package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String currentPage = "";

        String command = scanner.nextLine();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browser.size() <= 1) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    browser.pop();
                    currentPage = browser.peek();
                }
            } else if (command.equals("forward")) {
               if (forwardPages.isEmpty()) {
                   System.out.println("no next URLs");
               } else {

               }
            } else {
                currentPage = command;
                browser.push(currentPage);
                forwardPages.addFirst(currentPage);
            }

            System.out.println(currentPage);
            command = scanner.nextLine();
        }
    }
}
