package com.ibm.academia.restapi.tarjetas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.restapi.tarjetas.exceptions.NotFoundException;
import com.ibm.academia.restapi.tarjetas.model.entities.Card;
import com.ibm.academia.restapi.tarjetas.repositories.CardsRepository;

public class CardDAOImpl implements CardDAO {

    @Autowired
    private CardsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Card findByID(Long id) {
        Optional<Card> card = this.repository.findById(id);
        if (!card.isPresent())
            throw new NotFoundException("No se encontro la Tarjeta");
        return card.get();
    }

    @Override
    @Transactional
    public Card save(Card card) {
        return this.repository.save(card);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Card> findAll() {
        Iterable<Card> cards = this.repository.findAll();
        if (((List<Card>) cards).isEmpty())
            throw new NotFoundException("No se encontraron Tarjetas");
        return cards;
    }

    @Override
    @Transactional
    public void deleteByID(Long id) {
        Card card = this.findByID(id);
        this.repository.deleteById(card.getId());
    }

}
