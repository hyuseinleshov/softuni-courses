package Exercise.groomingSalon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GroomingSalon salon = new GroomingSalon(20);

        Pet dog = new Pet("Ellias", 5, "Tim");

        System.out.println(dog);

        salon.salon.add(dog);
    }
}
