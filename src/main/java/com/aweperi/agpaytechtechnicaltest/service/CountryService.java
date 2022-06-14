package com.aweperi.agpaytechtechnicaltest.service;

import com.aweperi.agpaytechtechnicaltest.exceptions.CountryAlreadyExistsException;
import com.aweperi.agpaytechtechnicaltest.exceptions.CountryNotFoundException;
import com.aweperi.agpaytechtechnicaltest.exceptions.IllegalPopulationSizeException;
import com.aweperi.agpaytechtechnicaltest.exceptions.NameCannotBeNullException;
import com.aweperi.agpaytechtechnicaltest.model.Country;
import com.aweperi.agpaytechtechnicaltest.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements  ICountryService{
    private final List<Country> countries = CountryRepository.countries;
    @Override
    public List<Country> findPaginated(int offset, int pageSize) {
        return countries.subList(offset, pageSize).stream().toList();
    }

    @Override
    public List<Country> findByPartialName(String partialName) {

        var countryList = countries.stream().filter(country -> country.getName().contains(partialName)).toList();
        if(countryList.isEmpty())throw new CountryNotFoundException(String.format("No country contains keyword %s",partialName));
        return countryList;
    }

    @Override
    public Country addCountry(Country country) {
        if (country.getName().isEmpty() || country.getName() == null ) throw new NameCannotBeNullException();
        var countryExists = countries.contains(country);
        if(countryExists) {
            throw new CountryAlreadyExistsException(String.format("Country with name %s already exists", country.getName()));
        } else if (country.getPopulation() <= 0) {
            throw new IllegalPopulationSizeException();
        } else {
            country.setId(countries.size() + 1);
            countries.add(country);
            return countries.get(countries.size() - 1);
        }
    }

    @Override
    public Country getCountryById(Integer id) {
        var foundCountries = countries.stream().filter(country -> country.getId().equals(id)).toList();
        return foundCountries.stream().findFirst().orElseThrow(CountryNotFoundException::new);
    }
}
