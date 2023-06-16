package com.txt.auth.jwt.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "random_city")
@Data
public class RandomCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
