package Lab.P04FirstAndReserveTeam;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {

        if (firstName.length() < 3) {
            String message = "First name cannot be less than 3 symbols";

            throw new IllegalArgumentException(message);
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        if (lastName.length() < 3) {
            String message = "Last name cannot be less than 3 symbols";

            throw new IllegalArgumentException(message);
        }

        this.lastName = lastName;
    }

    public void setAge(int age) {

        if (age <= 0) {
            String message = "Age cannot be zero or negative integer";

            throw  new IllegalArgumentException(message);
        }

        this.age = age;
    }

    public void setSalary(double salary) {

        if (salary < 460) {
            String message = "Salary cannot be less than 460 leva";

            throw new IllegalArgumentException(message);
        }

        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        if (getAge() < 30) {

            bonus /= 2;

            double newSalary = getSalary() + (getSalary() * (bonus / 100));

            setSalary(newSalary);
        } else {

            double newSalary = getSalary() + (getSalary() * (bonus / 100));

            setSalary(newSalary);
        }


    }

    @Override
    public String toString() {

        return String.format("%s %s gets %.2f leva.", getFirstName(), getLastName(), getSalary());
    }

}
