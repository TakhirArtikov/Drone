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
    @Column(name = "serial_number")
    private String droneSerialNumber;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "serial_number",insertable = false,updatable = false)
    private DroneEntity drone;

}
