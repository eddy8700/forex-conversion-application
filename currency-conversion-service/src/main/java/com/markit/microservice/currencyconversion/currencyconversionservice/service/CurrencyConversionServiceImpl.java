package com.markit.microservice.currencyconversion.currencyconversionservice.service;

import com.markit.microservice.currencyconversion.currencyconversionservice.config.CurrencyExchangeServiceProxy;
import com.markit.microservice.currencyconversion.currencyconversionservice.domain.CurrencyConversionDTO;
import com.markit.microservice.forex.forexservice.ForexValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {


    @Autowired
    public RestTemplate restTemplate;

    //@Autowired
    public CurrencyExchangeServiceProxy currencyExchangeServiceProxy;




    @Override
    public CurrencyConversionDTO convertCurrencyUsingFeign(String sourceCcy, String destCcy, BigDecimal sourceAmount) {
        final ForexValue forexValueResponse = currencyExchangeServiceProxy.getRatesData(sourceCcy, destCcy);
        return  new CurrencyConversionDTO(forexValueResponse.getSourceCurrency(), forexValueResponse.getTargetCurrency(),
                sourceAmount,
                forexValueResponse.getConversionRate().multiply(sourceAmount));

    }

    @Override
    public CurrencyConversionDTO convertCurrencyUsingRibbon(String sourceCcy, String destCcy, BigDecimal sourceAmount) {
        String urlToCall = "http://forex-service/forex-service/rates";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlToCall)
                .queryParam("sourceCcy",sourceCcy)
                .queryParam("destCcy", destCcy);
        final ForexValue forexValueResponse = restTemplate.getForObject(builder.toUriString(), ForexValue.class);
        return new CurrencyConversionDTO(forexValueResponse.getSourceCurrency(), forexValueResponse.getTargetCurrency(),
                sourceAmount,
                forexValueResponse.getConversionRate().multiply(sourceAmount));

    }
}
