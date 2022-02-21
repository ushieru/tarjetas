package com.ibm.academia.restapi.tarjetas.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards", schema = "private")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name")
    private String name;

    @NotEmpty
    @NotNull
    @Column(name = "passion")
    private String passion;

    @Positive
    @NotNull
    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    @Positive
    @NotNull
    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Positive
    @NotNull
    @Column(name = "min_age")
    private Integer minAge;

    @Positive
    @NotNull
    @Column(name = "max_age")
    private Integer maxAge;

}
