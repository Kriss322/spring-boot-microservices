package com.eureka.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient        // Enable eureka client.
@EnableCircuitBreaker      // Enable circuit breakers
public class EurekaPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaPlayerApplication.class, args);
    }

}
