package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICountryService {
    List<Country> findPaginated(Pageable pageable);
    List<Country> findByPartialName(String partialName);
    Country addCountry(Country country);

    Country getCountryById(Integer id);
}
