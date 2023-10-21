package com.example.Liabrarys1.Controller;

import com.example.Liabrarys1.Entities.Book;
import com.example.Liabrarys1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("addBookByAuthorId")
    public ResponseEntity addBookByAuthorId(@RequestBody Book book, @RequestParam("authorId")Integer authorId){
        try{
            String response=bookService.addBookByAuthorId(book,authorId);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/getBookByGenre")
    public ResponseEntity getBookByGenre(@RequestParam("genre")String genre){
        List<Book> booklist=bookService.getBookByGenre(genre);
        return new ResponseEntity(booklist,HttpStatus.OK);

    }
}
