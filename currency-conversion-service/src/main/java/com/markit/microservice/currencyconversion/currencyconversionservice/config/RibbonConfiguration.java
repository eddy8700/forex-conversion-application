package com.markit.microservice.currencyconversion.currencyconversionservice.config;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.NIWSDiscoveryPing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;


public class RibbonConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;


    @Bean
    public IRule ribboonRule(IClientConfig config){
        return new RoundRobinRule();
    }

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new DummyPing();
    }

    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        return new StaticServerList<>(new Server("localhost",8003), new Server("localhost",8005));
    }


}
