package Exersice;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder textWithExplosionsSb = new StringBuilder(scanner.nextLine());

        int power = 0;

        for (int i = 0; i < textWithExplosionsSb.length(); i++) {
            char currentSymbol = textWithExplosionsSb.charAt(i);

            if (currentSymbol == '>') {
                power += Integer.parseInt(String.valueOf(textWithExplosionsSb.charAt(i + 1)));
            }

            if (power > 0 && currentSymbol == '>') {
                textWithExplosionsSb.replace(i + 1, i + 2, "");
                power--;
            } else if (power > 0){
                textWithExplosionsSb.replace(i, i + 1, "");
                power--;
                i--;
            }
        }
        System.out.println(textWithExplosionsSb);
    }
}
