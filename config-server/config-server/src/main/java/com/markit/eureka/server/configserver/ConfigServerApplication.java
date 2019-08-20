package com.markit.eureka.server.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableEurekaServer
public class ConfigServerApplication {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP address: " + address.getHostAddress());
		System.out.println("Host name : " + address.getHostName());
		SpringApplication eurekaServer = new SpringApplication(ConfigServerApplication.class);
		eurekaServer.addListeners(new ApplicationPidFileWriter("eureka-server.pid"));
		eurekaServer.run(args);
	}

}

