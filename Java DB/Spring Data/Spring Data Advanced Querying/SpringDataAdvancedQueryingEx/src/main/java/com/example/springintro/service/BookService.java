package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.repository.BookInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopies(EditionType editionType, int threshold);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);

    List<String> findAllByReleaseDateIsNot(int releaseDate);

    List<Book> findAllBooksByReleaseDateBefore(LocalDate releaseDate);

    List<String> findAllBooksTitleWhichContainString(String string);

    List<Book> findAllBooksWhichAreWrittenByAuthorsWhoseLastNameStartsWith(String string);

    int findCountOfBooksWhoseTitleIsLongerThan(int number);

    List<Object[]> findTotalNumberOfBookCopiesByAuthor();

    Optional<Book> findBookByTitle(String title);

    BookInfo findInfoByTitle(String title);
}
