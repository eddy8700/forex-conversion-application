package com.markit.microservice.currencyconversion.currencyconversionservice.service;

import com.markit.microservice.currencyconversion.currencyconversionservice.domain.CurrencyConversionDTO;

import java.math.BigDecimal;

public interface CurrencyConversionService {

    CurrencyConversionDTO convertCurrencyUsingFeign(String sourceCcy, String destCcy, BigDecimal sourceAmount);

    CurrencyConversionDTO convertCurrencyUsingRibbon(String sourceCcy, String destCcy, BigDecimal sourceAmount);
}
