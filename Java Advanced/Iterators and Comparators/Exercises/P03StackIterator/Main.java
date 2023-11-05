package Exercises.P03StackIterator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();

        String input = scanner.nextLine();
        
        while (!input.equals("END")) {
            
            String[] tokens = input.split("[, ]+");
            
            String command = tokens[0];
            
            if (command.equals("Push")) {

                for (int i = 1; i < tokens.length; i++) {

                    stack.push(Integer.parseInt(tokens[i]));
                }

            } else if (command.equals("Pop")) {

                try {
                    stack.pop();
                } catch (NoSuchElementException exception) {
                    System.out.println(exception.getMessage());
                    break;
                }

            }

            input = scanner.nextLine();
        }

        if (stack.size() > 0) {

            stack.forEach(System.out::println);
            stack.forEach(System.out::println);

        }

    }

}
