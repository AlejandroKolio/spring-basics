package com.udemy.spring.one_to_one_uni.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 15.05.2018 16:44
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "youtube_channel")
    private String youTubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(String youTubeChannel, String hobby) {
        this.youTubeChannel = youTubeChannel;
        this.hobby = hobby;
    }
}
