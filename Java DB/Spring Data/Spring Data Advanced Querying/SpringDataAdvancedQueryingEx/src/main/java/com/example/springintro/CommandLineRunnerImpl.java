package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.repository.BookInfo;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
//        printBooksByAgeRestriction();
//        printBooksByEditiontypeGoldAndCopiesLessThan5000();
//        printBooksByPriceNotIn();
//        printBooksByReleaseDateNotIn();
//        printAllAuthorNamesWhoseFirstNameEndsWith();
//        printBooksTitleWhichContainGivenString();
//        printAllBooksWhichAreWrittenByAuthorsWhoseLastNameStartsWith();
//        printCountOfBooksWhoseTitleIsLongerThan();
//        printTotalNumberOfBookCopiesByAuthor();
        printBookProjection();

    }

    private void printBookProjection() {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        BookInfo info = bookService.findInfoByTitle(title);

        System.out.printf("%s %s %s %.2f\n", info.getTitle(), info.getEditionType(), info.getAgeRestriction(), info.getPrice());
    }

    private void printTotalNumberOfBookCopiesByAuthor() {
        List<Object[]> results = this.bookService.findTotalNumberOfBookCopiesByAuthor();

        for (Object[] result : results) {
            Author author = (Author) result[0];
            String firstName = author.getFirstName();
            String lastName = author.getLastName();

            long totalBookCopies = (long) result[1];

            System.out.printf("%s %s - %d\n", firstName, lastName, totalBookCopies);
        }
    }

    private void printCountOfBooksWhoseTitleIsLongerThan() {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int count = this.bookService.findCountOfBooksWhoseTitleIsLongerThan(number);

        System.out.printf("There are %d books with longer titles than %s symbols.", count, number);
    }

    private void printAllBooksWhichAreWrittenByAuthorsWhoseLastNameStartsWith() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        List<Book> books = this.bookService.findAllBooksWhichAreWrittenByAuthorsWhoseLastNameStartsWith(string);

        books.forEach(b -> System.out.printf("%s(%s %s)\n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    private void printBooksTitleWhichContainGivenString() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        List<String> books = this.bookService.findAllBooksTitleWhichContainString(string);

        books.forEach(System.out::println);
    }

    private void printAllAuthorNamesWhoseFirstNameEndsWith() {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        List<Author> authors = this.authorService.getAllAuthorsWhoseFirstNameEndsWith(string);

        authors.forEach(a -> System.out.printf("%s %s\n", a.getFirstName(), a.getLastName()));
    }

    private void printBooksByReleaseDateBefore() {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("-");

        int day = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int year = Integer.parseInt(tokens[2]);

        LocalDate releaseDate = LocalDate.of(year, month, day);

        List<Book> books = bookService.findAllBooksByReleaseDateBefore(releaseDate);

        books.forEach(b -> System.out.printf("%s %s %.2f\n", b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    private void printBooksByReleaseDateNotIn() {
        List<String> titles = bookService.findAllByReleaseDateIsNot(1998);

        titles.forEach(System.out::println);
    }

    private void printBooksByPriceNotIn() {
        List<Book> books = bookService.findByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        books.forEach(b -> System.out.printf("%s - $%.2f\n", b.getTitle(), b.getPrice()));
    }

    private void printBooksByEditiontypeGoldAndCopiesLessThan5000() {
        List<String> titles = bookService.findAllByEditionTypeAndCopies(EditionType.GOLD, 5000);

        titles.forEach(System.out::println);
    }

    private void printBooksByAgeRestriction() {
        Scanner scanner = new Scanner(System.in);
        String restriction = scanner.nextLine();

        try {
            AgeRestriction ageRestriction =
                    AgeRestriction.valueOf(restriction.toUpperCase());

            List<String> titles = bookService.findAllByAgeRestriction(ageRestriction);

            titles.forEach(System.out::println);
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong age category");
        }
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
