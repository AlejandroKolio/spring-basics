package com.udemy.spring.model;

import com.udemy.spring.annotation.CourseCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * @author alexander.shakhov on 07.05.2018 19:06
 */
@Getter
@Setter
public class Customer {

    @NotNull(message = "is required")
    @Size(message = "Should not be shorter then 2 letters", min = 2)
    private String firstName;

    @NotNull(message = "is required")
    @Size(message = "Should not be shorter then 2 letters", min = 2)
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "Must be grater than or equal to zero")
    @Max(value = 10, message = "Must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 digits/characters")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String courseCode;
}
