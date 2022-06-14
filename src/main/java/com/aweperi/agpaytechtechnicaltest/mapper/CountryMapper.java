package com.aweperi.agpaytechtechnicaltest.mapper;

import com.aweperi.agpaytechtechnicaltest.dto.CountryDto;
import com.aweperi.agpaytechtechnicaltest.model.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface CountryMapper extends IMapper<Country, CountryDto> {
}
