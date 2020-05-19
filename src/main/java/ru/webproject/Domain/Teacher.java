package ru.webproject.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "about")
    private String about;

}
