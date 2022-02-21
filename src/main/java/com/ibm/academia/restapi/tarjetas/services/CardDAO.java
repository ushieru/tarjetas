package com.ibm.academia.restapi.tarjetas.services;

import com.ibm.academia.restapi.tarjetas.model.entities.Card;

public interface CardDAO {
    public Card findByID(Long id);

    public Card save(Card card);

    public Iterable<Card> findAll();

    public void deleteByID(Long id);
}
