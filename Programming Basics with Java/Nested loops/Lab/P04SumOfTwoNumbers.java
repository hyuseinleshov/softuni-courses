package NestedLoops_Lecture;

import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int counter = 0;
        int a = 0;
        int b = 0;

        for (int i = startNum; i <= endNum ; i++) {
            for (int j = startNum; j <= endNum ; j++) {
                a = i;
                b = j;
                sum = a+ b;
                counter++;
                if (sum == magicNum) {
                    break;
                }
            }
            if (sum == magicNum) {
                break;
            }
        }
        if (sum == magicNum) {
            System.out.printf("Combination N:%d (%d + %d = %d)",counter,a,b,magicNum);
        } else {
            System.out.printf("%d combinations - neither equals %d",counter,magicNum);
        }
    }
}
