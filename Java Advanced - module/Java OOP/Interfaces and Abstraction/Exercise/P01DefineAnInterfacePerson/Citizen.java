package Exercise.P01DefineAnInterfacePerson;

public class Citizen implements Person {

    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Citizen(String name, int age, String id, String birthDate) {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

}
