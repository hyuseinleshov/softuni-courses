package Lab.P01Book.P03ComparableBook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookOne.getTitle(), bookTwo.getTitle()));
        } else if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format("%s is before %s", bookTwo.getTitle(), bookOne.getTitle()));
        } else {
            System.out.println("Book are equal");
        }


    }

}
