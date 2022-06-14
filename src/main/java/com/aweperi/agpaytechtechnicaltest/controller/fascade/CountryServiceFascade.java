package com.aweperi.agpaytechtechnicaltest.controller.fascade;

import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import com.aweperi.agpaytechtechnicaltest.mapper.CountryMapper;
import com.aweperi.agpaytechtechnicaltest.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryServiceFascade {
    private final ICountryService countryService;
    private final CountryMapper countryMapper;

    public List<CountryDto> findPaginatedCountries(int pageNo, int pageSize) {
        return countryService.findPaginated(pageNo, pageSize).stream()
                .map(countryMapper::toDTO).toList();
    }

    public List<CountryDto> findByPartialName(String partialName) {
        return countryService.findByPartialName(partialName).stream()
                .map(countryMapper::toDTO).toList();
    }

    public CountryDto addCountry(CountryDto requestBody) {
        var country = countryMapper.toEntity(requestBody);
        return countryMapper.toDTO(countryService.addCountry(country));
    }
}
