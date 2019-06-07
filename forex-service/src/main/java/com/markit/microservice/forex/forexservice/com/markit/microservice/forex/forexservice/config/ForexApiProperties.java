package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("com.markit.forex.api")
public class ForexApiProperties {

    private String url;

    private String ratesUrl;

    public String getRatesUrl() {
        return ratesUrl;
    }

    public void setRatesUrl(String ratesUrl) {
        this.ratesUrl = ratesUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
