package com.example.bookstore.domain.services;

import com.example.bookstore.app.dtos.BookDetailsDTO;
import com.example.bookstore.domain.entities.Book;
import com.example.bookstore.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Tạo mới sách
    public Book createBook(Book book) {
        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setPrice(book.getPrice());
        newBook.setAuthor(book.getAuthor());
        newBook.setPublishedDate(book.getPublishedDate());
        newBook.setIsBn(book.getIsBn());

        return bookRepository.save(newBook);
    }

    // Lấy sách theo ID
    public BookDetailsDTO getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            BookDetailsDTO bookDetailsDTO = new BookDetailsDTO();
            bookDetailsDTO.setId(book.get().getId());
            bookDetailsDTO.setTitle(book.get().getTitle());
            bookDetailsDTO.setPrice(book.get().getPrice());
            bookDetailsDTO.setAuthor(book.get().getAuthor());
            bookDetailsDTO.setPublishedDate(book.get().getPublishedDate());
            bookDetailsDTO.setIsBn(book.get().getIsBn());

            return bookDetailsDTO;
        }
        return null;
    }

    // Lấy tất cả sách với các tham số tùy chọn
    public List<Book> getAllBooks(Long authorId, String title, Double price, LocalDate publishedDate) {
        if (authorId != null) {
            return bookRepository.findByAuthorId(authorId);
        }
        if (title != null) {
            return bookRepository.findByTitleContaining(title);
        }
        if (price != null) {
            return bookRepository.findByPriceGreaterThan(BigDecimal.valueOf(price));
        }
        if (publishedDate != null) {
            return bookRepository.findByPublishedDate(publishedDate);
        }

        return bookRepository.findAll();
    }

    // Cập nhật sách
    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            return null;
        }

        Book updatedBook = bookRepository.findById(id).get();
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPublishedDate(book.getPublishedDate());
        updatedBook.setIsBn(book.getIsBn());

        return bookRepository.save(updatedBook);
    }

    // Xóa sách
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

