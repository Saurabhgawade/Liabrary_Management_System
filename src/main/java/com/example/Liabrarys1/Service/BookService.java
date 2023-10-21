package com.example.Liabrarys1.Service;

import Exceptions.authorNotPresent;
import com.example.Liabrarys1.Entities.Author;
import com.example.Liabrarys1.Entities.Book;
import com.example.Liabrarys1.Repository.AuthorRepository;
import com.example.Liabrarys1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addBookByAuthorId(Book book,Integer authorId)throws  Exception{
        Optional<Author>optionalAuthor=authorRepository.findById(authorId);
        if(!optionalAuthor.isPresent()){
            throw new authorNotPresent("author id not present");
        }
        Author author=optionalAuthor.get();
        book.setAuthor(author);



        author.getBookList().add(book);
        authorRepository.save(author);
        return "Book added successfully";



    }

    public List<Book> getBookByGenre(String genre){
        List<Book>books=bookRepository.findAllBooksByGenre(genre);
        return books;

    }
}
