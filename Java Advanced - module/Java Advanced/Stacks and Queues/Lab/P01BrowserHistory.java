package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();

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
            } else {
                currentPage = command;
                browser.push(currentPage);
            }

            System.out.println(currentPage);
            command = scanner.nextLine();
        }
    }
}
