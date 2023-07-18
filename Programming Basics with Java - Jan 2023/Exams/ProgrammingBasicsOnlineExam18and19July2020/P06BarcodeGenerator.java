import java.util.Scanner;

public class P06BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        int firstStartDigit = startNum / 1000;
        int secondStartDigit = startNum / 100 % 10;
        int thirdStartDigit = startNum / 10 % 10;
        int fourthStartDigit = startNum % 10;

        int firstEndDigit = endNum / 1000;
        int secondEndDigit = endNum / 100 % 10;
        int thirdEndDigit = endNum / 10 % 10;
        int fourthEndDigit = endNum % 10;

        for (int i = firstStartDigit; i <= firstEndDigit ; i++) {
            for (int j = secondStartDigit; j <= secondEndDigit ; j++) {
                for (int k = thirdStartDigit; k <= thirdEndDigit ; k++) {
                    for (int l = fourthStartDigit; l <= fourthEndDigit ; l++) {
                    boolean isValid = i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0;
                    if (isValid) {
                        System.out.printf("%d%d%d%d ",i,j,k,l);
                    }
                    }
                }
            }
        }
    }
}
