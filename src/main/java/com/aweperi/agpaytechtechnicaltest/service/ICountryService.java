package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findPaginated(int pageNo, int pageSize);
    List<Country> findByPartialName(String partialName);
    Country addCountry(Country country);
}
