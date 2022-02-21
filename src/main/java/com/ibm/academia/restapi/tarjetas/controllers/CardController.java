package com.ibm.academia.restapi.tarjetas.controllers;

import java.util.List;

import com.ibm.academia.restapi.tarjetas.model.entities.Card;
import com.ibm.academia.restapi.tarjetas.services.CardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private CardDAO cardDAO;

    @GetMapping("/cards")
    public ResponseEntity<?> get() {
        List<Card> cards = (List<Card>) this.cardDAO.findAll();
        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Card card = this.cardDAO.findByID(id);
        return new ResponseEntity<Card>(card, HttpStatus.OK);
    }

    @PostMapping("/card")
    public ResponseEntity<?> post(@RequestBody Card card) {
        Card card_ = this.cardDAO.save(card);
        return new ResponseEntity<Card>(card_, HttpStatus.CREATED);
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.cardDAO.deleteByID(id);
        return new ResponseEntity<String>("Tarjeta eliminada correctamente", HttpStatus.OK);
    }

}
