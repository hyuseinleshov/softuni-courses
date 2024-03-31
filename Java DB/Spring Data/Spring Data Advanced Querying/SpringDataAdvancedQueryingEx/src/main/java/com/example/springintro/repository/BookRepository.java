package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int threshold);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);

    @Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) != :year")
    List<Book> findBooksNotReleasedInYear(int year);

    List<Book> findAllByTitleContainsIgnoreCase(String string);

    List<Book> findAllByAuthorLastNameStartsWith(String string);

    @Query("SELECT COUNT(*) FROM Book b WHERE LENGTH(b.title) > :number")
    int findAllByTitleGreaterThan(int number);

    @Query("SELECT b.author, SUM(b.copies) AS totalCopies FROM Book b GROUP BY b.author ORDER BY totalCopies DESC")
    List<Object[]> findTotalNumberOfBookCopiesByAuthor();

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b WHERE b.title = :title")
    Optional<Book> findBookByTitle(String title);

    BookInfo findByTitle(String title);
}
