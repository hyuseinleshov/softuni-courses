package Exersice;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyUsers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] userData = input.split(" -> ");
            String companyName = userData[0];
            String employeesId = userData[1];

            if (companyUsers.containsKey(companyName) && !companyUsers.get(companyName).contains(employeesId)) {
                companyUsers.get(companyName).add(employeesId);
            } else if (!companyUsers.containsKey(companyName)) {
                companyUsers.put(companyName, new ArrayList<>());
                companyUsers.get(companyName).add(employeesId);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyUsers.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < companyUsers.get(entry.getKey()).size(); i++) {
                System.out.printf("-- %s%n", companyUsers.get(entry.getKey()).get(i));
            }
        }
    }
}
