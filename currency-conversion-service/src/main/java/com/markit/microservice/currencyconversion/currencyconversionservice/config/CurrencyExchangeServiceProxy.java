package com.markit.microservice.currencyconversion.currencyconversionservice.config;


import com.markit.microservice.forex.forexservice.ForexValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@FeignClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping(value = "/forex-service/rates")
    ForexValue getRatesData(@RequestParam("sourceCcy") String sourceCcy, @RequestParam("destCcy") String destCcy);
}
