package com.aweperi.agpaytechtechnicaltest.controller.fascade;

import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.service.ICountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CountryServiceFascade {
    private final ICountryService countryService;

    @Autowired
    private ModelMapper modelMapper;

    public List<CountryDto> findPaginatedCountries(int pageNo, int pageSize) {
        return countryService.findPaginated(pageNo, pageSize).stream()
                .map(this::convertToDto).toList();
    }

    public List<CountryDto> findByPartialName(String partialName) {
        return countryService.findByPartialName(partialName).stream()
                .map(this::convertToDto).toList();
    }

    public CountryDto addCountry(CountryDto requestBody) {
        CountryDto countryDto = null;
        try {
            var country = convertToEntity(requestBody);
            countryDto = convertToDto(countryService.addCountry(country));
        } catch (ParseException ex) {
            log.error(ex.getMessage());
        }
        return countryDto;
    }
    private CountryDto convertToDto(Country post) {
        return modelMapper.map(post, CountryDto.class);
    }

    private Country convertToEntity(CountryDto countryDto) throws ParseException {
        Country country = modelMapper.map(countryDto, Country.class);

        if (countryDto.getId() != null) {
            Country oldCountry = countryService.getCountryById(countryDto.getId());
            country.setName(oldCountry.getName());
            country.setPopulation(oldCountry.getPopulation());
        }
        return country;
    }
}
