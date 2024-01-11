import java.util.Scanner;

public class Brute_Force {

    public static void main(String[] args) {

        // Brute-Force algorithm to find all possible combinations from all 5-digit numbers

        for (int i1 = 0; i1 < 10; i1++) {

            for (int i2 = 0; i2 < 10; i2++) {

                for (int i3 = 0; i3 < 10; i3++) {

                    for (int i4 = 0; i4 < 10; i4++) {

                        for (int i5 = 0; i5 < 10; i5++) {

                            System.out.printf("{%d}{%d}{%d}{%d}{%d}\n", i1, i2, i3, i4, i5);
                        }
                    }
                }
            }
        }

        // 10 x 10 x 10 x 10 x 10 = 100 000

    }

}
