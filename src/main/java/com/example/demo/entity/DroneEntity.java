package com.example.demo.entity;

import com.example.demo.enm.DroneModel;
import com.example.demo.enm.DroneState;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "drone")
public class DroneEntity {

    @Id
    String serial_number;
    @Column(name = "model")
    DroneModel model;
    @Column(name = "weight_limit")
    Double weight_limit;
    @Column(name = "battery_capacity")
    Double battery_capacity;
    @Column(name = "state")
    DroneState state;

}
