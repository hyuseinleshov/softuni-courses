package Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] specialBombNumberAndPowerArray = scanner.nextLine().split(" ");
        int specialBombNumber = Integer.parseInt(specialBombNumberAndPowerArray[0]);
        int power = Integer.parseInt(specialBombNumberAndPowerArray[1]);

        int specialBombNumbersCount = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == specialBombNumber) {
                specialBombNumbersCount++;
            }
        }

        for (int i = 0; i < specialBombNumbersCount; i++) {
            for (int j = 0; j < numbersList.size(); j++) {
                if (numbersList.get(j) == specialBombNumber) {
                    int index = j;
                    int indexesToRemove = 0;
                    int startingPoint = 0;
                    int end = 0;
                    int endNumbers = (numbersList.size() - 1) - index;
                    if (index < power) {
                        if (index == 0) {
                            indexesToRemove = 1 + power;
                        } else {
                            indexesToRemove = (1 + (2 * power)) - (power - index);
                        }
                        startingPoint = 0;
                        if (endNumbers < power) {
                            end = numbersList.size() - 1;
                        } else {
                            end = index + power;
                        }
                    } else {
                        indexesToRemove = 1 + (2 * power);
                        startingPoint = index - power;
                        if (endNumbers < power) {
                            end = numbersList.size() - 1;
                        } else {
                            end = index + power;
                        }
                    }
                    for (int k = startingPoint; k <= end ; k++) {
                        numbersList.remove(startingPoint);
                    }
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }
        System.out.println(sum);
    }
}
