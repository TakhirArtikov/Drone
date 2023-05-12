package com.example.demo.entity;

import com.example.demo.enums.DroneModel;
import com.example.demo.enums.DroneState;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "drone")
public class DroneEntity {

    @Id
    private String serialNumber;

    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private DroneModel model;

    @Column(name = "weight_limit")
    private Double weightLimit;

    @Column(name = "battery_capacity")
    private Double batteryCapacity;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
    private List<MedicationEntity> medications;


}
