package com.example.Liabrarys1.Controller;

import com.example.Liabrarys1.Entities.Author;
import com.example.Liabrarys1.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")

public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addauthor(@RequestBody Author author){
        String ans=authorService.addAuthor(author);

        return new  ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public List<String> findallauthor(){
        return authorService.findallauthor();

    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findbyid(@PathVariable("id")int id){
        try{
            Author author=authorService.findbyid(id);
            return new ResponseEntity<>(author,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllBookNames")
    public ResponseEntity getAllBookNames(@RequestParam("authorId")Integer authorId){
        List<String>booknames=authorService.getAllBookNames(authorId);
        return new ResponseEntity(booknames,HttpStatus.OK);

    }
}
