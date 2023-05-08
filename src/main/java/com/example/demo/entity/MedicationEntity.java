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
    private String name;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "code")
    private String code;
    @Column(name = "image")
    private String image;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "serail_number", nullable = false)
    private DroneEntity drone;

}
