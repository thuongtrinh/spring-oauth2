package com.txt.auth.jwt.entities.auth;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="app_role")
@Data
public class Role {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @Column(name="description")
    private String description;
}
