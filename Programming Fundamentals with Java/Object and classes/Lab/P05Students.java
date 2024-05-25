package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    public static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public String getFirstName(String firstName) {
            return firstName;
        }
        public String getLastName(String LastName) {
            return lastName;
        }
        public int getAge(int age) {
            return age;
        }
        public String getHometown(String hometown) {
            return hometown;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentsList = new ArrayList<>();

        while (!input.equals("end")) {
            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            String hometown = input.split(" ")[3];

            Student student = new Student(firstName, lastName, age, hometown);
            studentsList.add(student);
            input = scanner.nextLine();
        }
        String hometown = scanner.nextLine();

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).hometown.equals(hometown)) {
                System.out.printf("%s %s is %d years old%n",studentsList.get(i).firstName, studentsList.get(i).lastName, studentsList.get(i).age);
            }
        }
    }
}
