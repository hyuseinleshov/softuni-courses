package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        ArrayDeque<String> editHistoryStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commandArray = scanner.nextLine().split(" ");
            String commandType = commandArray[0];

            switch (commandType) {
                case "1":
                    String string = commandArray[1];
                    editHistoryStack.push(String.valueOf(text));
                    text.append(string);
                    break;
                case "2":
                    int count = Integer.parseInt(commandArray[1]);
                    editHistoryStack.push(String.valueOf(text));
                    int startIndex = text.length() - count;
                    text.replace(startIndex, text.length(), "");
                    break;
                case "3":
                    int index = Integer.parseInt(commandArray[1]);
                    char element = text.charAt(index - 1);

                    System.out.println(element);
                    break;
                case "4":
                    String currentText = editHistoryStack.pop();
                    text = new StringBuilder();
                    text.append(currentText);
                    break;
            }
        }
    }
}
