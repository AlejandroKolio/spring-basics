package com.udemy.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.udemy.spring.model.Student;
import java.io.File;

/**
 * @author alexander.shakhov on 25.05.2018 13:13
 */
public class Application {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);


            Student studentLight = mapper.readValue(new File("/Users/alexandershakhov/Developer/spring-basics/spring-rest-json-data-binding/src/main/resources/sample-lite.json"), Student.class);
            Student studentFull = mapper.readValue(new File("/Users/alexandershakhov/Developer/spring-basics/spring-rest-json-data-binding/src/main/resources/sample-full.json"), Student.class);

            mapper.writeValue(new File("C:\\Users\\alexander.shakhov\\IdeaProjects\\spring-basics\\spring-rest-json-data-binding\\src\\main\\resources\\json2.json"), studentFull);

            System.out.println(studentLight);
            System.out.println(studentFull);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
