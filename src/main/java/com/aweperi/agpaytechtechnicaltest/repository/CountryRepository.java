package com.aweperi.agpaytechtechnicaltest.repository;

import com.aweperi.agpaytechtechnicaltest.model.Country;

import java.util.LinkedList;
import java.util.List;

public class CountryRepository {
    public static List<Country> countries = new LinkedList<>(
            List.of(
                    new Country(1,"China", 1382050000),
                    new Country(2,"India", 1313210000),
                    new Country(3,"USA", 324666000),
                    new Country(4,"Indonesia", 260581000),
                    new Country(5,"Brazil", 207221000),
                    new Country(6,"Pakistan", 196626000),
                    new Country(7,"Nigeria", 186988000),
                    new Country(8,"Bangladesh", 162099000),
                    new Country(9,"Russia", 146838000),
                    new Country(10,"Japan", 126830000),
                    new Country(11,"Mexico", 122273000),
                    new Country(12,"Philippines", 103738000),
                    new Country(13,"Ethiopia", 101853000),
                    new Country(14,"Vietnam", 92700000),
                    new Country(15,"Egypt", 92641000),
                    new Country(16,"Germany", 82800000),
                    new Country(17,"the Congo", 82243000),
                    new Country(18,"Iran", 82800000),
                    new Country(19,"Turkey", 79814000),
                    new Country(20,"Thailand", 68147000),
                    new Country(21,"France", 66984000),
                    new Country(22,"United Kingdom", 60589000),
                    new Country(23,"South Africa", 55908000),
                    new Country(24,"Myanmar", 51446000),
                    new Country(25,"South Korea", 68147000),
                    new Country(26,"Colombia", 49129000),
                    new Country(27,"Kenya", 47251000),
                    new Country(28,"Spain", 46812000),
                    new Country(29,"Argentina", 43850000),
                    new Country(30,"Ukraine", 42603000),
                    new Country(31,"Sudan", 41176000),
                    new Country(32,"Algeria", 40400000),
                    new Country(33,"Poland", 38439000),
                    new Country(34,"Canada", 37742154),
                    new Country(35,"Morocco", 36910560),
                    new Country(36,"Saudi Arabia", 34813871),
                    new Country(37,"Uzbekistan", 33469203),
                    new Country(38,"Peru", 32971854),
                    new Country(39,"Angola", 32866272),
                    new Country(40,"Malaysia", 32365999),
                    new Country(41,"Mozambique", 31255435),
                    new Country(42,"Ghana", 31072940),
                    new Country(43,"Yemen", 29825964),
                    new Country(44,"Nepal", 29136808),
                    new Country(45,"Venezuela", 28435940)
            )
    );
}
