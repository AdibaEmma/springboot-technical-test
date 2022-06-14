package com.aweperi.agpaytechtechnicaltest.controller;

import com.aweperi.agpaytechtechnicaltest.controller.fascade.CountryServiceFascade;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
class CountryControllerIntegrationTest {
    @MockBean
    CountryServiceFascade countryService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToCountriesAndValidCountry_thenCorrectResponse() throws Exception {
        MediaType jsonMediaType = new MediaType(MediaType.APPLICATION_JSON);
        String country = "{\"name\": \"benin\", \"population\" : 230000}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/countries")
                        .content(country)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(jsonMediaType));
    }

    @Test
    public void whenPostRequestToCountriesAndInvalidCountry_thenCorrectResponse() throws Exception {
        String invalidCountry = "{\"name\": \"benin\", \"population\" : 0 \"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/countries")
                        .content(invalidCountry)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}