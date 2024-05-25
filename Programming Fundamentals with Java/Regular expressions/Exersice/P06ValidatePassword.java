package Exersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();

            String regex = "_\\.+(?<passwordName>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            StringBuilder groupSb = new StringBuilder();

            if (matcher.find()) {
                String name = matcher.group("passwordName");

                for (int j = 0; j < name.length(); j++) {
                    if (Character.isDigit(name.charAt(j))) {
                        String currentDigit = String.valueOf(name.charAt(j));
                        groupSb.append(currentDigit);
                    }
                }

                if (groupSb.length() == 0) {
                    groupSb.append("default");
                }

                System.out.printf("Group: %s%n",groupSb);
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
