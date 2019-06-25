package com.example.SimulacroParcial.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@org.springframework.context.annotation.Configuration
@EnableAsync
public class Configuration {

    @Bean("ThreadPoolTaskExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(500);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }
}
