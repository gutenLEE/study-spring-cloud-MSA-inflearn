package com.example.apigatewayservice.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LogginFilter extends AbstractGatewayFilterFactory<LogginFilter.Config> {

    public LogginFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        // custom pre filter
/*
        return ((exchange, chain) ->{
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Global Filter baseMessage : request id -> {}", config.getBaseMessage());

            if(config.isPreLogger()){
                log.info("Global Filter Start : request id -> {}", request.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPostLogger()){
                    log.info("Global Filter end : response code -> {}", response.getStatusCode());
                }
            }));
        });
*/

        // 위 람다식은 아래 두 코드를 합친 것.
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) ->{
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Logging Filter baseMessage : request id -> {}", config.getBaseMessage());

            if(config.isPreLogger()){
                log.info("Logging Pre Filter Start : request id -> {}", request.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPostLogger()){
                    log.info("Logging POST Filter end : response code -> {}", response.getStatusCode());
                }
            }));
        }, Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }

    @Data
    public static class Config{
        // put the configuration properties
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

    }
}
