package com.markit.microservice.currencyconversion.currencyconversionservice.controller;


import com.markit.microservice.currencyconversion.currencyconversionservice.domain.CurrencyConversionDTO;
import com.markit.microservice.currencyconversion.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;


    @GetMapping("/convert")
    public CurrencyConversionDTO convertCurrency(@RequestParam String sourceCcy, @RequestParam String destCcy, @RequestParam BigDecimal sourceAmount) {
        if (sourceCcy != null && destCcy != null && sourceAmount != null) {
            if (sourceCcy.equals(destCcy))
                throw new IllegalStateException("Cannot convert between same currencies");
            else
                return currencyConversionService.convertCurrencyUsingRibbon(sourceCcy, destCcy, sourceAmount);

        } else {
            throw new IllegalStateException("source/dest currency cannot be null and/or sourceAmount cannot be null");
        }
    }


}
