package com.example.Liabrarys1.Service;

import com.example.Liabrarys1.Entities.Student;
import com.example.Liabrarys1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addstudent(Student student){
        studentRepository.save(student);

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        String message="hi"+student.getName()+"you successfully registered";

        simpleMailMessage.setFrom("springbbotpractice94@gmail.com");
        simpleMailMessage.setTo(student.getEmailId());
        simpleMailMessage.setSubject("welcome to liabrary");
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);


        return  "Successfully added";
    }

    public List<String>findallstudent(){
        List<Student>students=studentRepository.findAll();
        List<String>ans=new ArrayList<>();

        for(Student student:students){
            ans.add(student.getName());
        }
        return ans;
    }

    public Student findbyid(int id)throws Exception{
        Optional<Student>optionalstudent=studentRepository.findById(id);
        if(!optionalstudent.isPresent()){
            throw new Exception("Invalid id");
        }
        Student student=optionalstudent.get();
        return student;
    }
}
