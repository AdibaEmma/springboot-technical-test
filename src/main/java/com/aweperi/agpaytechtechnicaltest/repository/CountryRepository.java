package com.aweperi.agpaytechtechnicaltest.repository;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
