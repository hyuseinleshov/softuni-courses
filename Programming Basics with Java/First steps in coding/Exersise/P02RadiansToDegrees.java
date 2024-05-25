import java.util.Scanner;

public class P02RadiansToDegrees {
    public static void main(String[] args) {

        //1.Четем радианите от конзолата
        //2.Преобразуваме радианите в градуси със формулата - градус = радиан * 180 / π
        //3.Принтираме градусите от конзолата

        Scanner scanner = new Scanner(System.in);
        double radians = Double.parseDouble(scanner.nextLine());

        double degres = radians * (180 / Math.PI);

        System.out.println(degres);
    }
}
