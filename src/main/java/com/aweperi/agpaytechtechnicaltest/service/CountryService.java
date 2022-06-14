package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService implements  ICountryService{
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("name").ascending());
        Page<Country> pagedResult = countryRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Country> findByPartialName(String partialName) {

        var countryList = countryRepository.findByNameContaining(partialName);
        return countryList.orElseThrow(() -> new RuntimeException("No country contains keyword"));
    }

    @Override
    public Country addCountry(Country country) {
        var queriedCountry = countryRepository.findByName(country.getName());
        if(queriedCountry.isPresent()) {
            throw new RuntimeException("Country already exists");
        } else {
            return countryRepository.save(country);
        }
    }
}
