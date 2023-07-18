import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String passwordToReset = scanner.nextLine();

        String input = scanner.nextLine();

        StringBuilder newRawPasswordSb = new StringBuilder(passwordToReset);

        while (!input.equals("Done")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];

            if (command.equals("TakeOdd")) {
                String oldPassword = newRawPasswordSb.toString();
                newRawPasswordSb = new StringBuilder();
                for (int i = 0; i < oldPassword.length(); i++) {
                    if (i % 2 != 0) {
                        newRawPasswordSb.append(oldPassword.charAt(i));
                    }
                }
                System.out.println(newRawPasswordSb);
            } else if (command.equals("Cut")) {
                int index = Integer.parseInt(commandArray[1]);
                int length = Integer.parseInt(commandArray[2]);
                int indexesToRemove = index + length;

                newRawPasswordSb.replace(index, indexesToRemove, "");

                System.out.println(newRawPasswordSb);
            } else if (command.equals("Substitute")){
                String substring = commandArray[1];
                String substitute = commandArray[2];

                if (newRawPasswordSb.toString().contains(substring)) {
                    newRawPasswordSb = new StringBuilder(newRawPasswordSb.toString().replace(substring, substitute));
                    System.out.println(newRawPasswordSb);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s%n", newRawPasswordSb);
    }
}
