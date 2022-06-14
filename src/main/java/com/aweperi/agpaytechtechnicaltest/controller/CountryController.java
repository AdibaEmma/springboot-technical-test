package com.aweperi.agpaytechtechnicaltest.controller;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {
    private final ICountryService countryService;

    @GetMapping("/{pageNo}/{pageSize}")
    public List<Country> getPaginatedCountries(@PathVariable int pageNo, @PathVariable int pageSize) {
        return countryService.findPaginated(pageNo, pageSize);
    }
}
