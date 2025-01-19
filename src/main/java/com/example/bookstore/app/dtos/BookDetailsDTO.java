package com.example.bookstore.app.dtos;

import com.example.bookstore.domain.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private LocalDate publishedDate;
    private Author author;
    private String isBn;
}
