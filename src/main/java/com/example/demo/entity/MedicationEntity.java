package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medications")
public class MedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    String name;
    @Column(name = "weight")
    Double weight;
    @Column(name = "code")
    String code;
    @Column(name = "image")
    String image;
}
