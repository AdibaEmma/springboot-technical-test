package com.aweperi.agpaytechtechnicaltest.repository;

import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {
    public static final List<Country> countries = List.of(
            new Country(1L,"China", 1382050000),
            new Country(2L,"India", 1313210000),
            new Country(3L,"USA", 324666000),
            new Country(4L,"Indonesia", 260581000),
            new Country(5L,"Brazil", 207221000),
            new Country(6L,"Pakistan", 196626000),
            new Country(7L,"Nigeria", 186988000),
            new Country(8L,"Bangladesh", 162099000),
            new Country(9L,"Russia", 146838000),
            new Country(10L,"Japan", 126830000),
            new Country(11L,"Mexico", 122273000),
            new Country(12L,"Philippines", 103738000),
            new Country(13L,"Ethiopia", 101853000),
            new Country(14L,"Vietnam", 92700000),
            new Country(15L,"Egypt", 92641000),
            new Country(16L,"Germany", 82800000),
            new Country(17L,"the Congo", 82243000),
            new Country(18L,"Iran", 82800000),
            new Country(19L,"Turkey", 79814000),
            new Country(20L,"Thailand", 68147000),
            new Country(21L,"France", 66984000),
            new Country(22L,"United Kingdom", 60589000),
            new Country(23L,"South Africa", 55908000),
            new Country(24L,"Myanmar", 51446000),
            new Country(25L,"South Korea", 68147000),
            new Country(26L,"Colombia", 49129000),
            new Country(27L,"Kenya", 47251000),
            new Country(28L,"Spain", 46812000),
            new Country(29L,"Argentina", 43850000),
            new Country(30L,"Ukraine", 42603000),
            new Country(31L,"Sudan", 41176000),
            new Country(32L,"Algeria", 40400000),
            new Country(33L,"Poland", 38439000),
            new Country(34L,"Canada", 37742154),
            new Country(35L,"Morocco", 36910560),
            new Country(36L,"Saudi Arabia", 34813871),
            new Country(37L,"Uzbekistan", 33469203),
            new Country(38L,"Peru", 32971854),
            new Country(39L,"Angola", 32866272),
            new Country(40L,"Malaysia", 32365999),
            new Country(41L,"Mozambique", 31255435),
            new Country(42L,"Ghana", 31072940),
            new Country(43L,"Yemen", 29825964),
            new Country(44L,"Nepal", 29136808),
            new Country(45L,"Venezuela", 28435940)
    );
}
