package Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> studentRecord = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokensArray = scanner.nextLine().split(" ");
            String name = tokensArray[0];
            String grade = tokensArray[1];

            if (!studentRecord.containsKey(name)) {
                studentRecord.put(name, new ArrayList<>());
                studentRecord.get(name).add(grade);
            } else {
                studentRecord.get(name).add(grade);
            }

        }

        for (Map.Entry<String, List<String>> entry : studentRecord.entrySet()) {
            List<String> currentGrades = entry.getValue();

            double sum = 0;

            String[] numbers = new String[currentGrades.size()];

            for (int i = 0; i < currentGrades.size(); i++) {
                sum += Double.parseDouble(currentGrades.get(i));
            }

            double averageGrade = sum / currentGrades.size();

            String splitedNumbers = String.join(" ", currentGrades);

            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), splitedNumbers, averageGrade);
        }
    }
}
