package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> coursesData = new LinkedHashMap<>();
        Map<String, String> studentsData = new LinkedHashMap<>();

        int count = 0;
        while (!input.equals("end")) {
            count++;
            String[] studentDataArray = input.split(" : ");
            String courseName = studentDataArray[0];
            String studentName = studentDataArray[1];

            if (!coursesData.containsKey(courseName)) {
                coursesData.put(courseName, 0);
            }

            coursesData.put(courseName, coursesData.get(courseName) + 1);

            studentsData.put(courseName + count, studentName);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : coursesData.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            for (Map.Entry<String, String> stringEntry : studentsData.entrySet()) {
                String course = stringEntry.getKey();
                if (course.contains(entry.getKey())) {
                    System.out.printf("-- %s%n", stringEntry.getValue());
                }
            }
        }
    }
}
