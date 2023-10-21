package com.example.Liabrarys1.Controller;

import com.example.Liabrarys1.Entities.LibraryCard;
import com.example.Liabrarys1.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")

public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/generatenewcard")
    public ResponseEntity generatenewcard(){
        LibraryCard card=cardService.generatenewcard();
        String respone="generate new card"+card.getCardNo();
        return new ResponseEntity(respone, HttpStatus.OK);

    }

    @PutMapping("/associatewithstudent")
    public ResponseEntity associatewithstudent(@RequestParam("studentId")int studentId,@RequestParam("liabryId")int liabryId){
        try {
            String response = cardService.associatewithstudent(studentId, liabryId);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
