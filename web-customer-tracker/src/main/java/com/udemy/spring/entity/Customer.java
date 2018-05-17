package com.udemy.spring.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 17.05.2018 15:43
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

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

}
