package Exercise.P06Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Beast!")) {

            String type = input;
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = null;

        if (!type.equals("Tomcat") && !type.equals("Kitten")) {

            gender = data[2];
        }

            switch (type) {

                case "Dog":

                    Dog dog = new Dog(name, age, gender);
                    animals.add(dog);
                    break;
                case "Cat":

                    Cat cat = new Cat(name, age, gender);
                    animals.add(cat);
                    break;
                case "Frog":

                    Frog frog = new Frog(name, age, gender);
                    animals.add(frog);
                    break;
                case "Tomcat":

                    Tomcat tomcat = new Tomcat(name, age);
                    animals.add(tomcat);
                    break;
                case "Kitten":

                    Kitten kitten = new Kitten(name, age);
                    animals.add(kitten);
                    break;
            }


            input = scanner.nextLine();
        }

        for (Animal animal : animals) {

            System.out.println(animal.toString());
        }

    }

}
