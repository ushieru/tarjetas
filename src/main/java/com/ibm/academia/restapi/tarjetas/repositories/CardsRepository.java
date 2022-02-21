package com.ibm.academia.restapi.tarjetas.repositories;

import com.ibm.academia.restapi.tarjetas.model.entities.Card;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {
    
}
