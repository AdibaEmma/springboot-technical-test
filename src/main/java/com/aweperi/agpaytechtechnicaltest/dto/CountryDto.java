package com.aweperi.agpaytechtechnicaltest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private @Nullable Integer id;
    private  String name;
    private Integer population;
}
