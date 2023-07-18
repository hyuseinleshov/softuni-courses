import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();
        StringBuilder activationKeySb = new StringBuilder(rawActivationKey);

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] instructionsArray = input.split(">>>");
            String command = instructionsArray[0];

            if (command.equals("Contains")) {
                String substring = instructionsArray[1];
                if (activationKeySb.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", activationKeySb, substring);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if (command.equals("Flip")) {
                String upperOrLower = instructionsArray[1];
                int startIndex = Integer.parseInt(instructionsArray[2]);
                int endIndex = Integer.parseInt(instructionsArray[3]);

                String substring = activationKeySb.substring(startIndex, endIndex);

                if (upperOrLower.equals("Upper")) {
                    String substringToUpper = substring.toUpperCase();
                    activationKeySb.replace(startIndex, endIndex, substringToUpper);
                    System.out.println(activationKeySb);
                } else {
                    String substringToLower = substring.toLowerCase();
                    activationKeySb.replace(startIndex, endIndex, substringToLower);
                    System.out.println(activationKeySb);
                }
            } else if (command.equals("Slice")) {
                int startIndex = Integer.parseInt(instructionsArray[1]);
                int endIndex = Integer.parseInt(instructionsArray[2]);

                activationKeySb.replace(startIndex, endIndex, "");
                System.out.println(activationKeySb);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", activationKeySb);
    }
}
