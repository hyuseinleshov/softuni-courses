package Exercises.P06StrategyPattern;

import java.util.Comparator;

public class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static class NameComparator implements Comparator<Person> {


        @Override
        public int compare(Person o1, Person o2) {

            int firstPersonLength = o1.name.length();
            int secondPersonLength = o2.name.length();

            if (firstPersonLength == secondPersonLength) {

                return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
            }

            return Integer.compare(o1.name.length(), o2.name.length());

        }

    }

    public static class AgeComparator implements Comparator<Person> {


        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.age, o2.age);
        }

    }

}
