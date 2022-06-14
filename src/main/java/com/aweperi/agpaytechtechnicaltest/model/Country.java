package com.aweperi.agpaytechtechnicaltest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private final String name;
    private final Integer population;
}
