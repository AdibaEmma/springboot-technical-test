package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CountryService implements  ICountryService{
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = countryRepository.findAll(paging);

        return pagedResult.toList();
    }

    @Override
    public List<Country> findByPartialName(String partialName) {
        return null;
    }

    @Override
    public Country addCountry(Country country) {
        return null;
    }
}
