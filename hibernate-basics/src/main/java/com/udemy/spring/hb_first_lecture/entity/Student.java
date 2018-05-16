package com.udemy.spring.hb_first_lecture.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 11.05.2018 13:11
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
