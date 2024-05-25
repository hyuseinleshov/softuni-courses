package Exersise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double GeorgesMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = studentsCount / 6;
        double totalPrice = (lightsaberPrice * Math.ceil(studentsCount + (studentsCount * 0.1))) + (robePrice * studentsCount) + (beltPrice * (studentsCount - freeBelts));
        if (totalPrice <= GeorgesMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double neededMoney = Math.abs(totalPrice - GeorgesMoney);
            System.out.printf("George Lucas will need %.2flv more.", neededMoney);
        }
    }
}
