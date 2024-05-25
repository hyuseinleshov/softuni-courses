package Exercises.P02Collection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListyIterator list = new ListyIterator();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Create":

                    if (tokens.length > 1) {
                        String line = input.replace("Create ", "");
                        String[] array = line.split(" ");
                        list = new ListyIterator(array);
                    }

                    break;
                case "Move":

                    System.out.println(list.Move());
                    break;
                case "HasNext":

                    System.out.println(list.HasNext());
                    break;
                case "Print":

                    list.Print();
                    break;
                case "PrintAll":

                    list.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }

    }

}
