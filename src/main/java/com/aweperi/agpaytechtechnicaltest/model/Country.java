package com.aweperi.agpaytechtechnicaltest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private  String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }
}
