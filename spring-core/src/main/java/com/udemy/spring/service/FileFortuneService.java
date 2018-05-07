package com.udemy.spring.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author alexander.shakhov on 04.05.2018 15:14
 * @project spring-framework-course
 * @description
 */
@Component
public class FileFortuneService implements FortuneService {

    private List<String> fortunesList;

    @Override
    public String getFortune() {
        return "Get Fortune: " + fortunesList.get(new Random().nextInt(fortunesList.size()));
    }

    @PostConstruct
    public void fillList() {
        fortunesList = new ArrayList<>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("fortunes.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = br.readLine()) != null) {
                fortunesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("PostConstruct: " + fortunesList.get(new Random().nextInt(fortunesList.size())));
    }
}
