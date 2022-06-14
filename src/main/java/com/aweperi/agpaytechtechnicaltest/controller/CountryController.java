package com.aweperi.agpaytechtechnicaltest.controller;

import com.aweperi.agpaytechtechnicaltest.controller.fascade.CountryServiceFascade;
import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryServiceFascade countryService;
    @GetMapping(params = { "page", "size" } )
    public ResponseEntity<?> findPaginatedCountries(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseHandler.handleResponseBody(HttpStatus.OK, "Countries Found With Pagination" , countryService.findPaginatedCountries(page, size));
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
