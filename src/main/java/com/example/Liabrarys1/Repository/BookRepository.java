package com.example.Liabrarys1.Repository;

import com.example.Liabrarys1.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book>findAllBooksByGenre(String genre);
}
