package Exercises.P05ComparingObjects;

public class Person {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        setName(name);
        setAge(age);
        setTown(town);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int compareTo(Person other) {

        int nameComparison = this.name.compareTo(other.getName());

        if (nameComparison == 0) {
            int ageComparison = Integer.compare(this.age, other.getAge());

            if (ageComparison == 0) {
                return this.town.compareTo(other.getTown());
            }

            return ageComparison;
        }

        return nameComparison;
    }

}
