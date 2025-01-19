package com.example.bookstore.domain.repositories;

import com.example.bookstore.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByTitleContaining(String title);
    List<Book> findByPriceGreaterThan(BigDecimal price);
    List<Book> findByPublishedDate(LocalDate publishedDate);
}
