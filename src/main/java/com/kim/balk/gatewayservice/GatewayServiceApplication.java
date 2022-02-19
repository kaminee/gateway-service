package com.kim.balk.gatewayservice;

/*Zuul Server is an API Gateway application. 
It handles all the requests and performs the dynamic routing of microservice applications. 
It is also known as Edge Server. 
Zuul is built to enable dynamic routing, monitoring, resiliency, and security.*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kim.balk.gatewayservice.filters.PreRequestHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient 
@Configuration
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public PreRequestHeaderFilter addRequestHeaderFilter() {
		return new PreRequestHeaderFilter();
	}
}
