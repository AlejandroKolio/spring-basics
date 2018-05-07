package com.udemy.spring;

import com.udemy.app.model.FootballCoach;
import com.udemy.app.model.SwimCoach;
import com.udemy.app.service.FortuneService;
import com.udemy.app.service.RandomFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author alexander.shakhov on 04.05.2018 18:10
 * @project spring-framework-course
 * @description
 */
@Configuration
@PropertySource("classpath:sport.properties")
public class ConfigurationApp {

    @Bean
    public FortuneService randomFortuneService() {
        return new RandomFortuneService();
    }

    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach(randomFortuneService());
    }

    @Bean
    public FootballCoach footballCoach() {
        return new FootballCoach(randomFortuneService());
    }
}
