package com.aweperi.agpaytechtechnicaltest.controller;

import com.aweperi.agpaytechtechnicaltest.controller.fascade.CountryServiceFascade;
import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryServiceFascade countryService;
    @GetMapping()
    public ResponseEntity<?> findPaginatedCountries( Pageable pageable) {
        return ResponseHandler.handleResponseBody(HttpStatus.OK, "Countries Found With Pagination" , countryService.findPaginatedCountries(pageable));
    }

    @GetMapping("/{partialName}")
    public ResponseEntity<?> findCountriesContainingName(@PathVariable("partialName") String partialName) {
        return ResponseHandler.handleResponseBody(HttpStatus.OK, "Countries Found From Query" , countryService.findByPartialName(partialName));
    }

    @PostMapping("")
    public ResponseEntity<?> createCountry(@RequestBody CountryDto requestBody) {
        return ResponseHandler.handleResponseBody(HttpStatus.CREATED, "New Country Added Successfully" , countryService.addCountry(requestBody));
    }
}
