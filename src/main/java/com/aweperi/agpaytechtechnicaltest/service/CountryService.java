package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.exceptions.CountryAlreadyExistsException;
import com.aweperi.agpaytechtechnicaltest.exceptions.CountryNotFoundException;
import com.aweperi.agpaytechtechnicaltest.exceptions.IllegalPopulationSizeException;
import com.aweperi.agpaytechtechnicaltest.exceptions.NameCannotBeNullException;
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
        return countryList.orElseThrow(() -> new CountryNotFoundException(String.format("No country contains keyword %s",partialName)));
    }

    @Override
    public Country addCountry(Country country) {
        if (country.getName().isEmpty() || country.getName() == null ) throw new NameCannotBeNullException();
        var queriedCountry = countryRepository.findByName(country.getName());
        if(queriedCountry.isPresent()) {
            throw new CountryAlreadyExistsException(String.format("Country with name %s already exists", country.getName()));
        } else if (country.getPopulation() <= 0) {
            throw new IllegalPopulationSizeException();
        } else {
            return countryRepository.save(country);
        }
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.getCountryById(id);
    }
}
