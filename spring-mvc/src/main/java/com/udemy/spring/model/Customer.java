package com.udemy.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author alexander.shakhov on 07.05.2018 19:06
 */
@Getter
@Setter
public class Customer {

    @NotNull(message = "First name is required")
    @Size(message = "Should not be shorter then 2 letters", min = 2)
    private String firstName;


    @NotNull(message = "Last name is required")
    @Size(message = "Should not be shorter then 2 letters", min = 2)
    private String lastName;
}
