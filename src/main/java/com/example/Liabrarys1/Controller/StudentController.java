package com.example.Liabrarys1.Controller;

import com.example.Liabrarys1.Entities.Student;
import com.example.Liabrarys1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addstudent(@RequestBody Student student){
        String ans=studentService.addstudent(student);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/findallstudent")
    public List<String>  findallstudent(){
        return studentService.findallstudent();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findbyid(@PathVariable("id")int id){
        try {
            Student student = studentService.findbyid(id);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
