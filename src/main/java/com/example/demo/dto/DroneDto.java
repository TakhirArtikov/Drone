package com.example.demo.dto;

import com.example.demo.enm.DroneModel;
import com.example.demo.enm.DroneState;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class DroneDto {
    @Size(max = 100)
    String serial_number;

    DroneModel model;
    @Size(max = 500)
    Double weight_limit;

    @Size(max = 100)
    Double battery_capacity;

    DroneState state;

}
