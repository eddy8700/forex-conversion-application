package com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.controller;


import com.markit.microservice.forex.forexservice.ForexValue;
import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.domain.CurrencyConversionDTO;
import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableDiscoveryClient
public class ForexController {

    @Autowired
    private ForexService forexService;


    @GetMapping("/supportedPairs")
    private List<String> getSupportedCurrencyPairs() {
        return forexService.getAllSupportedCurrencyPairs();
    }

    @GetMapping("/checkCcyPairs")
    private CurrencyConversionDTO checkIfCurrencyPairSupported(@RequestParam String sourceCcy, @RequestParam String destCcy) {
        if (sourceCcy != null && destCcy != null) {
            if (sourceCcy.equals(destCcy))
                throw new IllegalStateException("Source and destination ccy cannot be same");
            else
                return forexService.checkIfCurrencyPairSupported(sourceCcy, destCcy);
        } else {
            throw new IllegalStateException("Source/Destination currency cannot be null");
        }
    }

    @GetMapping(value = "/rates" , produces = "application/json")
    private ForexValue getRatesData(@RequestParam String sourceCcy, @RequestParam String destCcy){
        System.out.println("This is running on port 8003");
        if (sourceCcy != null && destCcy != null) {
            if (sourceCcy.equals(destCcy))
                throw new IllegalStateException("Source and destination ccy cannot be same");
            else
                return forexService.getRatesData(sourceCcy, destCcy);
        } else {
            throw new IllegalStateException("Source/Destination currency cannot be null");
        }
    }






}
