package com.example.bookstore.domain.services;

import com.example.bookstore.domain.entities.Author;
import com.example.bookstore.domain.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        Author newAuthor = new Author();
        newAuthor.setName(author.getName());
        newAuthor.setNationality(author.getNationality());

        return authorRepository.save(newAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
