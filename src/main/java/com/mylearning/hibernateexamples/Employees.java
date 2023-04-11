package com.mylearning.hibernateexamples;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
}
