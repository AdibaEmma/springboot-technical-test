package com.aweperi.agpaytechtechnicaltest.controller;

import com.aweperi.agpaytechtechnicaltest.controller.fascade.CountryServiceFascade;
import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import com.aweperi.agpaytechtechnicaltest.mapper.CountryMapper;
import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryServiceFascade countryService;
    @GetMapping(params = { "page", "size" } )
    public List<CountryDto> findPaginatedCountries(@RequestParam("page") int page, @RequestParam("size") int size) {
        return countryService.findPaginatedCountries(page, size);
    }

    @GetMapping("/{partialName}")
    public List<CountryDto> findCountriesContainingName(@PathVariable("partialName") String partialName) {
        return countryService.findByPartialName(partialName);
    }

    @PostMapping("")
    public CountryDto addCountry(@RequestBody CountryDto requestBody) {
        return countryService.addCountry(requestBody);
    }
}
