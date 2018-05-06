package com.udemy.spring.service;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "You got lucky today";
    }
}
