package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        boolean isValid = isBalanced(parentheses);

        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String parentheses) {
        ArrayDeque<Character> parenthesesQueue = new ArrayDeque<>();

        char[] parenthesesArray = parentheses.toCharArray();

        for (int i = 0; i < parenthesesArray.length; i++) {
            char currentParentheses = parenthesesArray[i];

            if (currentParentheses == ')') {
                if (parenthesesQueue.poll() == '(') {
                   continue;
                } else {
                    return false;
                }
            } else if (currentParentheses == '}') {
                if (parenthesesQueue.poll() == '{') {
                    continue;
                } else {
                    return false;
                }
            } else if (currentParentheses == ']') {
                if (parenthesesQueue.poll() == '[') {
                    continue;
                } else {
                    return false;
                }
            }

            parenthesesQueue.addFirst(currentParentheses);
        }

        return true;
    }
}
