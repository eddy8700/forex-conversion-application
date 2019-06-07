package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyConversionDTO {

    private String sourceCurrency;
    private String destinationCurrency;
    private String message;

    public CurrencyConversionDTO(String sourceCurrency, String destinationCurrency) {
        this.sourceCurrency = sourceCurrency;
        this.destinationCurrency = destinationCurrency;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CurrencyConversionDTO() {
    }

    @Override
    public String toString() {
        return sourceCurrency+destinationCurrency;
    }
}
