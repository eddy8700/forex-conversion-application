package com.markit.microservice.forex.forexservice;


import java.math.BigDecimal;

public class ForexValue {

    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal conversionRate;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }


    public ForexValue(String sourceCurrency, String targetCurrency, BigDecimal conversionRate) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.conversionRate = conversionRate;
    }

    public ForexValue() {
    }

    @Override
    public String toString() {
        return "ForexValue{" +
                "sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }
}
