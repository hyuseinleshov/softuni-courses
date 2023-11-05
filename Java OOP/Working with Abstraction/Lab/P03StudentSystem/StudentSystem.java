package Lab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> REPO;

    public StudentSystem() {
        this.REPO = new HashMap<>();
    }

    public void ParseCommand(String[] args) {

        String command = args[0];
        String name = args[1];
        
        if (command.equals("Create")) {
            
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            
            if (!checkIsContains(name)) {
                Student student = new Student(name, age, grade);
                REPO.put(name, student);
            }
            
        } else if (command.equals("Show")) {
            
            if (checkIsContains(name)) {
                Student student = REPO.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                double grade = student.getGrade();

                view = addCommentary(grade, view);

                System.out.println(view);
            }
            
        }
        
    }

    private static String addCommentary(double grade, String view) {

        if (grade >= 5.00) {
            view += " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;

    }

    private boolean checkIsContains(String name) {
        
        return REPO.containsKey(name);
    }
    
}
