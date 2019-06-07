package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyPairResponse {

    private List<String> supportedPairs;

    public List<String> getSupportedPairs() {
        return supportedPairs;
    }

    public void setSupportedPairs(List<String> supportedPairs) {
        this.supportedPairs = supportedPairs;
    }

    public CurrencyPairResponse(List<String> supportedPairs) {
        this.supportedPairs = supportedPairs;
    }

    public CurrencyPairResponse() {
    }
}
