package com.udemy.spring.one_to_one_uni.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 15.05.2018 16:51
 */

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "instructor")
public class Instructor {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }
}
