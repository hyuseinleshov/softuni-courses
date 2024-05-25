package ForLoop_Exersise;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupsCount = Integer.parseInt(scanner.nextLine());

        int Musala = 0;
        int Monblan = 0;
        int Kilimandzharo = 0;
        int K2 = 0;
        int Everest = 0;
        int allPeoples = 0;
        for (int i = 1; i <= groupsCount ; i++) {
            int peoples = Integer.parseInt(scanner.nextLine());
            allPeoples = allPeoples + peoples;
            if (peoples <= 5) {
                Musala = Musala + peoples;
            } else if (peoples > 5 && peoples < 13) {
                Monblan = Monblan + peoples;
            } else if (peoples > 12 && peoples < 26) {
                Kilimandzharo = Kilimandzharo + peoples;
            } else if (peoples > 25 && peoples < 41) {
                K2 = K2 + peoples;
            } else {
                Everest = Everest + peoples;
            }
        }
        double MusalaPercent = (Musala * 1.0 / allPeoples) * 100;
        double MonblanPercent = (Monblan * 1.0 / allPeoples) * 100;
        double KilimandzharoPercent = (Kilimandzharo * 1.0 / allPeoples) * 100;
        double K2Percent = (K2 * 1.0 / allPeoples) * 100;
        double EverestPercent = (Everest * 1.0 / allPeoples) * 100;

        System.out.printf("%.2f%%%n",MusalaPercent);
        System.out.printf("%.2f%%%n",MonblanPercent);
        System.out.printf("%.2f%%%n",KilimandzharoPercent);
        System.out.printf("%.2f%%%n",K2Percent);
        System.out.printf("%.2f%%%n",EverestPercent);
    }
}