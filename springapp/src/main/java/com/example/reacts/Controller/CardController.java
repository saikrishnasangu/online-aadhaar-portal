package com.example.reacts.Controller;

import com.example.reacts.Model.NewCard;
import com.example.reacts.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin 

public class CardController {
    @Autowired
    CardService cardService;
    @CrossOrigin(origins = "*")
    @PostMapping("/user/new_card")
    public ResponseEntity<?> createNewCard(@RequestBody NewCard newCard){
        System.out.println("hi there");
        NewCard card = cardService.addNewCard(newCard);
        return card != null
                ? ResponseEntity.ok(card)
                : new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR)
                ;
    }

    @GetMapping("user/get_card_by_id/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Integer id){
        NewCard savedCard = cardService.getCardById(id);
        return ResponseEntity.ok(savedCard);

    }
    @GetMapping("user/get_card_by_email/{email}")
    public ResponseEntity<?> getCardByEmail(@PathVariable String email){
        NewCard savedCard = cardService.getCardByEmail(email);
        return ResponseEntity.ok(savedCard);

    }

    @PutMapping("user/edit_card/{email}")
    public ResponseEntity<?> editCard(@PathVariable String email,@RequestBody NewCard newCard){
        System.out.println("testing aadhar");
        NewCard editedCard = cardService.editCard(email,newCard);
        return ResponseEntity.ok(editedCard);
    }

    @GetMapping("admin/getAllDocs")
    public ResponseEntity<?> getAllDocuments(){
        List<NewCard> allApplicatioonsInDb = cardService.getAllCards();
        return ResponseEntity.ok("");
    }
}
