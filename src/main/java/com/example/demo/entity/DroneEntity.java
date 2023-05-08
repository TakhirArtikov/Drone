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
    private String serial_number;
    @Column(name = "model")
    private DroneModel model;
    @Column(name = "weight_limit")
    private Double weight_limit;
    @Column(name = "battery_capacity")
    private Double battery_capacity;
    @Column(name = "state")
    private DroneState state;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
    private List<MedicationEntity> medications;


}
