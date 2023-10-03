import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new TreeMap<>();

        DecimalFormat decimalFormat = new DecimalFormat("0.######");

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scores = scanner.nextLine().split(" ");

            double sum = 0;
            for (int j = 0; j < scores.length; j++) {
                sum += Double.parseDouble(scores[j]);
            }
            double averageScore = sum / scores.length;

            students.put(name, averageScore);
        }

        for (Map.Entry<String, Double> student : students.entrySet()) {
            String score = decimalFormat.format(student.getValue());
            System.out.printf("%s is graduated with %s%n", student.getKey(), student.getValue());
        }
    }
}
