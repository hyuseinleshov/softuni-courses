import java.util.Scanner;

public class P09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cm = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int hight = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = cm * width * hight;
        double volumeInWater = volume * 0.001;
        double space = percent * 0.01;
        double neededLitre = volumeInWater * (1 - space);
        System.out.println(neededLitre);
    }
}
