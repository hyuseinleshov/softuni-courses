package Exercise.P06Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.isBlank() || name.isEmpty()) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 0) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (gender.isBlank() || gender.isEmpty()) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    public String produceSound() {

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());

        sb.append(String.format("%s %d %s", name, age, gender)).append(System.lineSeparator());

        sb.append(this.produceSound());

        return sb.toString();
    }

}
