package com.example.Liabrarys1.Service;

import com.example.Liabrarys1.Entities.Author;
import com.example.Liabrarys1.Entities.Book;
import com.example.Liabrarys1.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public String addAuthor(Author author){
        authorRepository.save(author);
        return "stored Successsfully";
    }

    public List<String> findallauthor(){
        List<Author>authors=authorRepository.findAll();
        List<String>ans=new ArrayList<>();

        for(Author author:authors){
            ans.add(author.getAuthorName());


        }
        return ans;
    }

    public Author findbyid(int id)throws  Exception{
        Optional<Author>optionalAuthor=authorRepository.findById(id);
        if(!optionalAuthor.isPresent()){
            throw new Exception("Invalid id");

        }
        Author author=optionalAuthor.get();

        return author;
    }

    public List<String>getAllBookNames(Integer authorId){
        Author author=authorRepository.findById(authorId).get();
        List<String>booklist=new ArrayList<>();
        List<Book>books=author.getBookList();
        for(Book book:books){
            booklist.add(book.getBookName());
        }
        return booklist;
    }
}
