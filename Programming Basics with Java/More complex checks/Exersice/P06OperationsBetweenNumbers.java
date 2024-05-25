package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0;
        String evenOrOdd = "";

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero" ,number1);
                }
                result = number1 / (number2 * 1.0);
                break;
            case "%":
                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero" ,number1);
                } else {
                    result = number1 % number2;
                    System.out.printf("%d %s %d = %.0f",number1,operator,number2,result);
                }
                break;
        }
        if (operator.equals("+")) {
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even",number1,operator,number2,result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd",number1,operator,number2,result);
            }
        }
        if (operator.equals("-")) {
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even",number1,operator,number2,result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd",number1,operator,number2,result);
            }
        }
        if (operator.equals("*")) {
            if (result % 2 == 0) {
                System.out.printf("%d %s %d = %.0f - even",number1,operator,number2,result);
            } else {
                System.out.printf("%d %s %d = %.0f - odd",number1,operator,number2,result);
            }
        }
        if (operator.equals("/") && number2 != 0) {
            System.out.printf("%d %s %d = %.2f",number1,operator,number2,result);
        }
    }
}
