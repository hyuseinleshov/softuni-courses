import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String currentBarcode = scanner.nextLine();

            String regex = "@#+(?<barcodeName>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(currentBarcode);

            StringBuilder productGroupSb = new StringBuilder();

            if (matcher.find()) {
                String barcodeName = matcher.group("barcodeName");
                for (int j = 0; j < barcodeName.length(); j++) {
                    if (Character.isDigit(barcodeName.charAt(j))) {
                        productGroupSb.append(barcodeName.charAt(j));
                    }
                }
                if (productGroupSb.length() == 0) {
                    productGroupSb.append("00");
                }
                System.out.println("Product group: " + productGroupSb);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
