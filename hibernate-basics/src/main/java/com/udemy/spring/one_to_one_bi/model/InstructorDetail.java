package com.udemy.spring.one_to_one_bi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 15.05.2018 16:44
 */
@Entity
@Getter
@Setter
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

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail(String youTubeChannel, String hobby) {
        this.youTubeChannel = youTubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
    }
}
