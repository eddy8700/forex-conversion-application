package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.service;


import com.markit.microservice.forex.forexservice.ForexValue;
import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain.CurrencyConversionDTO;

import java.util.List;

public interface ForexService {

     List<String> getAllSupportedCurrencyPairs();

    CurrencyConversionDTO checkIfCurrencyPairSupported(final String sourceCcy, final String destCcy);

    ForexValue getRatesData(String sourceCcy, String destCcy);
}
