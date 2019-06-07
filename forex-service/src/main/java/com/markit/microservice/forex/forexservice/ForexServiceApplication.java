package com.markit.microservice.forex.forexservice;

import com.markit.microservice.forex.forexservice.com.markit.microservice.forex.forexservice.config.ForexApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(ForexApiProperties.class)
@EnableDiscoveryClient
public class ForexServiceApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		/*List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		messageConverters.add(converter);*/
		RestTemplate restTemplate = builder.build();
		//restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ForexServiceApplication.class, args);
	}

}

