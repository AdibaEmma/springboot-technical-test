package com.aweperi.agpaytechtechnicaltest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country{
    private Integer id;
    private  String name;
    private Integer population;
}
