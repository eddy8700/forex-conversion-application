package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.markit.microservice.forex.forexservice.ForexValue;
import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain.CurrencyConversionDTO;
import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain.CurrencyPairResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ForexServiceImpl implements ForexService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${com.markit.forex.api.url}")
    private String forexApiURL;

    public ForexServiceImpl() {
    }

    @Override
    public List<String> getAllSupportedCurrencyPairs() {
        final ResponseEntity<String> ccyPairs = restTemplate.getForEntity(forexApiURL, String.class);
        if (ccyPairs.getStatusCode().equals(HttpStatus.OK)) {
            return buildCurrencyPairResponse(ccyPairs.getBody());
        }
        return Collections.emptyList();
    }

    @Override
    public CurrencyConversionDTO checkIfCurrencyPairSupported(final String sourceCcy, final String destCcy) {
        CurrencyConversionDTO currencyConversionDTO = new CurrencyConversionDTO(sourceCcy, destCcy);
        final List<String> supportedpairs = getAllSupportedCurrencyPairs();
        if (supportedpairs.contains(currencyConversionDTO.toString())) {
            currencyConversionDTO.setMessage("The currency pair " + currencyConversionDTO.toString() + " is suppoprted");
            return currencyConversionDTO;
        } else {
            currencyConversionDTO.setMessage("The currency pair " + currencyConversionDTO.toString() + " is not suppoprted");
            return currencyConversionDTO;
        }

    }

    @Override
    public ForexValue getRatesData(String sourceCcy, String destCcy) {
        CurrencyConversionDTO currencyConversionDTO = new CurrencyConversionDTO(sourceCcy, destCcy);
        final ResponseEntity<String> rates = restTemplate.getForEntity(forexApiURL + "?pairs=" + currencyConversionDTO.toString(), String.class);
        if (rates.getStatusCode().equals(HttpStatus.OK)) {
            return buildForexResponse(rates.getBody(), currencyConversionDTO);
        }
        return null;
    }

    private ForexValue buildForexResponse(String rates, CurrencyConversionDTO currencyConversionDTO) {
        try {
            JSONObject jsonObject = new JSONObject(rates);
            final Double rate = (Double) jsonObject.getJSONObject("rates").getJSONObject(currencyConversionDTO.toString()).get("rate");
            ForexValue forexValue = new ForexValue(currencyConversionDTO.getSourceCurrency(), currencyConversionDTO.getDestinationCurrency(), BigDecimal.valueOf(rate));
            return forexValue;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> buildCurrencyPairResponse(String body) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        try {
            final CurrencyPairResponse currencyPairResponse = mapper.readValue(body, CurrencyPairResponse.class);
            return currencyPairResponse.getSupportedPairs();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
