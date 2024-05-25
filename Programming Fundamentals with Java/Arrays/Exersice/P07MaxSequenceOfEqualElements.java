package Exersice;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int biggestSequenceNumber = 0;
        int biggestSequenceCounter = 0;

        int counter = 1;
        int numberSequence = numbersArray[numbersArray.length - 1];
        for (int i = numbersArray.length - 2; i >= 0; i--) {
            if (numbersArray[i] != numberSequence) {
                counter = 1;
                numberSequence = numbersArray[i];
            } else {
                counter++;
            }
            if (counter >= biggestSequenceCounter) {
                biggestSequenceCounter = counter;
                biggestSequenceNumber = numberSequence;
            }
        }
        for (int i = 0; i < biggestSequenceCounter; i++) {
            System.out.print(biggestSequenceNumber + " ");
        }
    }
}
