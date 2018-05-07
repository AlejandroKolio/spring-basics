package com.udemy.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String country;
    private String programmingLanguage;
    private Map<String,String> countries;
    private String[] operatingSystems;

    public User() {
        countries = new LinkedHashMap<>();
        countries.put("BR", "Brazil");
        countries.put("FR", "France");
        countries.put("DE", "Germany");
        countries.put("RU", "Russia");
        countries.put("US", "United States of America");
    }


}
