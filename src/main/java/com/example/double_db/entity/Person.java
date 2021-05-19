package com.example.double_db.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person")
@NoArgsConstructor
@ToString(exclude = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
