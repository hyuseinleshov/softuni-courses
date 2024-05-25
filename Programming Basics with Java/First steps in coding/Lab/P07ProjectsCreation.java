import java.util.Scanner;

public class P07ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int projectsCount =Integer.parseInt(scanner.nextLine());

        int hours = projectsCount * 3;

        //The architect {името на архитекта} will need {необходими часове}
        //hours to complete {брой на проектите} project/s.

        System.out.printf("The architect %s will need %d hours to complete %d project/s.",
                name,hours,projectsCount);
    }
}
