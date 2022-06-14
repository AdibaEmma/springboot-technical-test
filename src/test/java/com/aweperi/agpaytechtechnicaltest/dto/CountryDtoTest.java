package com.aweperi.agpaytechtechnicaltest.dto;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class CountryDtoUnitTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertCountryEntityToCountryDto_thenCorrect() {
        Country country = new Country();
        country.setId(1);
        country.setName("Togo");
        country.setPopulation(1000000);

        CountryDto countryDto = modelMapper.map(country, CountryDto.class);
        assertEquals(country.getId(), countryDto.getId());
        assertEquals(country.getName(), countryDto.getName());
        assertEquals(country.getPopulation(), countryDto.getPopulation());
    }

    @Test
    public void whenConvertCountryDtoToCountryEntity_thenCorrect() {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(1);
        countryDto.setName("Benin");
        countryDto.setPopulation(23000);

        Country country = modelMapper.map(countryDto, Country.class);
        assertEquals(countryDto.getId(), country.getId());
        assertEquals(countryDto.getName(), country.getName());
        assertEquals(countryDto.getPopulation(), country.getPopulation());
    }
}