package com.example.requestlogging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty("service-log.service.url")
@Configuration
public class RequestLoggingClientConfig {

    @Bean
    public RequestLoggingClient requestLoggingClient(@Value("${service-log.service.url}") String loggingServiceUrl) {
        return new RequestLoggingClientImpl(loggingServiceUrl);
    }
}
