package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] numbersArr2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int diffIndex = -1;
        for (int i = 0; i < numbersArr1.length; i++) {
            if (numbersArr1[i] == numbersArr2[i]) {
                sum += numbersArr1[i];
            } else {
                diffIndex = i;
                break;
            }
        }
        if (diffIndex > -1) {
            System.out.printf("Arrays are not identical. Found difference at %d index.", diffIndex);
        } else {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
