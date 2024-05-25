package Exercise.P04Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String studentData = scanner.nextLine();
            String[] studentDataArray = studentData.split(" ");
            String firstName = studentDataArray[0];
            String lastName = studentDataArray[1];
            double grade = Double.parseDouble(studentDataArray[2]);

            Student student = new Student(firstName, lastName, grade);

            studentsList.add(student);
        }
        studentsList.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.printf("%s %s: %.2f%n", studentsList.get(i).getFirstName(), studentsList.get(i).getLastName(), studentsList.get(i).getGrade());
        }
    }
}
