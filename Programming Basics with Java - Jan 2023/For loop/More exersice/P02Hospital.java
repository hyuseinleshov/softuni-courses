package ForLoop_MoreExersises;

import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int treatedPatients = 0;
        int untreatedPatients = 0;
        int doctors = 7;

        for (int i = 1; i <= period ; i++) {
            int patientsCount = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0) {
                if (untreatedPatients > treatedPatients) {
                    doctors++;
                }
            }
            if (patientsCount > doctors) {
                untreatedPatients = untreatedPatients + (patientsCount - doctors);
                treatedPatients = treatedPatients + (patientsCount - (patientsCount - doctors));
            } else if (patientsCount <= doctors) {
                treatedPatients = treatedPatients + patientsCount;
            }
        }
        System.out.printf("Treated patients: %d.%n",treatedPatients);
        System.out.printf("Untreated patients: %d.",untreatedPatients);
    }
}
