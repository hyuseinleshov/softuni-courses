package ForLoop_Exersise;

import java.util.Scanner;

public class P05Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabsCount = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());

        for (int i = 1; i <= tabsCount; i++) {
            String websiteName = scanner.nextLine();

            switch (websiteName) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }
            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }
        if (salary > 0) {
            System.out.printf("%.0f",salary);
        }
    }
}
