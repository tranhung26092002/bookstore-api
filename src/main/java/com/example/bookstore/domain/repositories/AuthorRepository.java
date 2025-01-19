package com.example.bookstore.domain.repositories;

import com.example.bookstore.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
