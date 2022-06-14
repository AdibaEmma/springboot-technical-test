package com.aweperi.agpaytechtechnicaltest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Long id;
    @NotBlank(message = "country name cannot blank or null")
    private  String name;
    private int population;
}
