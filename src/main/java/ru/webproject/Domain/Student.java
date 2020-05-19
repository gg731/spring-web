package ru.webproject.Domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "score")
    private Long score;
}
