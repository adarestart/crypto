package com.example.crypto.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Value("${rest.timeout}")
    private Integer timeout;

    @Bean(name = "binance")
    public RestTemplate getTemplate(){
        //return new RestTemplate(getClientHttpRequestFactory());
        return new RestTemplate();
    }

//    @Bean(name = "coinbase")
//    public RestTemplate getTemplate(){
//        return new RestTemplate(getClientHttpRequestFactory());
//    }

    public ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
