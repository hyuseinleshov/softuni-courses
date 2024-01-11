package JavaAdvancedRetakeExam_14December2022.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    private int size() {

        return getData().size();
    }

    public int getCount() {

        return size();
    }

    public String insert(Student student) {

        if (getData().contains(student)) {

            return "Student is already in the hall.";
        }
        if (size() < capacity) {

            getData().add(student);

            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }

        return "The hall is full.";

    }

    public String remove(Student student) {

        if (getData().contains(student)) {

            getData().remove(student);

            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }

        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {

        for (Student student : getData()) {

            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {

                return student;
            }
        }

        return null;
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append("Hall size: " + size()).append(System.lineSeparator());

        for (Student student : getData()) {

            sb.append(student.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
