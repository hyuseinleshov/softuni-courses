package Exersice;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (studentsGrades.containsKey(studentName)) {
                List<Double> studentGrades = studentsGrades.get(studentName);
                studentGrades.add(grade);
            } else {
                studentsGrades.put(studentName, new ArrayList<>());
                studentsGrades.get(studentName).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            double sumOfGrades = 0;
            int count = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                count++;
                sumOfGrades += entry.getValue().get(i);
            }
            double averageGrade = sumOfGrades / count;

            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}
