package com.udemy.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {

    private Integer code;
    private String message;
    private Long timeStamp;



}
