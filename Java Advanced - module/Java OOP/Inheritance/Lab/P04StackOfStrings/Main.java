package Lab.P04StackOfStrings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StackOfStrings stackOfStrings = new StackOfStrings();

        stackOfStrings.push("one");
        stackOfStrings.push("two");
        stackOfStrings.push("three");

        System.out.println(stackOfStrings.isEmpty());
        System.out.println(stackOfStrings.peek());

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());

    }

}
