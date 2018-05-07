package com.udemy.spring.model;

import com.udemy.app.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author alexander.shakhov on 04.05.2018 18:28
 * @project spring-framework-course
 * @description
 */
@Component
public class FootballCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;
    private List<String> lessons;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return getCoachWisdomLesson();
    }

    @Override
    public String getDailyFortune() {
        return "You got lucky today";
    }

    public String getCoachWisdomLesson() {
        lessons = new ArrayList<>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("lessons.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lessons.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lessons.get(new Random().nextInt(lessons.size()));
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
