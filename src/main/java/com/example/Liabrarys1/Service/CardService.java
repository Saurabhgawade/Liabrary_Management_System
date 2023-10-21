package com.example.Liabrarys1.Service;

import com.example.Liabrarys1.Entities.LibraryCard;
import com.example.Liabrarys1.Entities.Student;
import com.example.Liabrarys1.Enum.CardStatus;
import com.example.Liabrarys1.Repository.CardRepository;
import com.example.Liabrarys1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public LibraryCard generatenewcard(){
        LibraryCard card=new LibraryCard();

        card.setCardStatus(CardStatus.NEW);

        card=cardRepository.save(card);

        return card;


    }

    public String associatewithstudent(int studentId,int cardId)throws  Exception{
        Optional<Student> optionalStudent=studentRepository.findById(studentId);
        if(!optionalStudent.isPresent()){
            throw new Exception("Invalid student id");
        }
        Student student=optionalStudent.get();

        Optional<LibraryCard>optionalLibraryCard=cardRepository.findById(cardId);
        if(!optionalLibraryCard.isPresent()){
            throw new Exception("Invalid liabrary id");
        }
        LibraryCard libraryCard=optionalLibraryCard.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setNameoncard(student.getName());
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        studentRepository.save(student);

        return "cardId"+cardId+"associate with"+studentId;
    }
}
