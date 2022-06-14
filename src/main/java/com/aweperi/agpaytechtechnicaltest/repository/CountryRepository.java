package com.aweperi.agpaytechtechnicaltest.repository;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
