package Lab.P03GenericScale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Scale<Integer> scale = new Scale<>(5, 8);

        System.out.println(scale.getHeavier());

    }

}
